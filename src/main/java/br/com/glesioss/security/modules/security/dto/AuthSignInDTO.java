package br.com.glesioss.security.modules.security.dto;

import lombok.*;

@Getter
@Setter
public class AuthSignInDTO {
  private String email;
  private String password;
}
