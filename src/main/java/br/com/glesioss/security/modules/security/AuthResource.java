package br.com.glesioss.security.modules.security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthResource {

  @PostMapping("/signIn")
  public ResponseEntity<?> signIn() {
    return null;
  }

  @PostMapping("/signUp")
  public ResponseEntity<?> signUp() {
    return null;
  }
}
