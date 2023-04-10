package br.com.glesioss.security.modules.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRegisterRequestDTO {
  private String firstname;
  private String lastname;
  private String email;
  private String password;
}
