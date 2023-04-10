package br.com.glesioss.security.modules.account.dto;

import lombok.*;

@Getter
@Setter
public class AccountDTO {

  private Long id;

  private String firtname;

  private String lastname;

  private String email;

  private String password;
}
