package br.com.glesioss.security.modules.security;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.glesioss.security.modules.security.dto.AuthRegisterRequestDTO;
import br.com.glesioss.security.modules.security.dto.AuthResponseDTO;
import br.com.glesioss.security.modules.security.dto.AuthSignInDTO;
import br.com.glesioss.security.modules.security.services.AuthService;
import lombok.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthResource {

  private final AuthService authService;

  @PostMapping("/signIn")
  public ResponseEntity<AuthResponseDTO> signIn(@RequestBody AuthSignInDTO signInDTO) {
    var response = authService.authenticated(signInDTO);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/signUp")
  public ResponseEntity<?> signUp(@RequestBody AuthRegisterRequestDTO authRegisterRequestDTO) {
    var account = authService.register(authRegisterRequestDTO);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/api/auth/{id}")
        .buildAndExpand(account.getId()).toUri();
    return ResponseEntity.created(location).build();
  }
}
