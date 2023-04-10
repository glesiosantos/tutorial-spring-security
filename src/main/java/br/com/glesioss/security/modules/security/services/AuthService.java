package br.com.glesioss.security.modules.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.glesioss.security.modules.account.model.Account;
import br.com.glesioss.security.modules.account.model.Role;
import br.com.glesioss.security.modules.account.services.AccountService;
import br.com.glesioss.security.modules.security.dto.AuthRegisterRequestDTO;
import br.com.glesioss.security.modules.security.dto.AuthResponseDTO;
import br.com.glesioss.security.modules.security.dto.AuthSignInDTO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthService {

  private final AuthenticationManager authenticationManager;
  private final PasswordEncoder passwordEncoder;
  private final AccountService accountService;

  public AuthResponseDTO authenticated(AuthSignInDTO signInDTO) {
    authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(signInDTO.getEmail(), signInDTO.getPassword()));
    return null;
  }

  public Account register(AuthRegisterRequestDTO dto) {
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
    return accountService.saveAccount(account);
  }

}
