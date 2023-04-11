package br.com.glesioss.security.modules.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.glesioss.security.modules.account.model.Account;
import br.com.glesioss.security.modules.account.model.Role;
import br.com.glesioss.security.modules.account.services.AccountService;
import br.com.glesioss.security.modules.exceptions.UniqueObjectException;
import br.com.glesioss.security.modules.security.dto.AuthRegisterRequestDTO;
import br.com.glesioss.security.modules.security.dto.AuthResponseDTO;
import br.com.glesioss.security.modules.security.dto.AuthSignInDTO;
import br.com.glesioss.security.modules.security.model.CustomUserDetails;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthService {

  private final AuthenticationManager authenticationManager;
  private final PasswordEncoder passwordEncoder;
  private final AccountService accountService;
  private final JwtService jwtService;

  public AuthResponseDTO authenticated(AuthSignInDTO signInDTO) throws Exception {
    authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(signInDTO.getEmail(), signInDTO.getPassword()));
    Account account = accountService.findAccountByEmail(signInDTO.getEmail());
    var token = jwtService.generateToken(new CustomUserDetails(account));
    return AuthResponseDTO.builder().token(token).build();
  }

  public Account register(AuthRegisterRequestDTO dto) throws Exception {

    if (accountService.existAccount(dto.getEmail()))
      throw new UniqueObjectException("User already registered");

    Account account = createdAccount(dto);
    return accountService.saveAccount(account);
  }

  private Account createdAccount(AuthRegisterRequestDTO dto) {
    Account account = Account.builder()
        .email(dto.getEmail())
        .firstName(dto.getFirstname())
        .lastName(dto.getLastname())
        .password(passwordEncoder.encode(dto.getPassword()))
        .role(Role.USER)
        .isAccountNonExpired(true)
        .isAccountNonLocked(true)
        .isCredentialsNonExpired(true)
        .isEnabled(true)
        .build();
    return account;
  }

}
