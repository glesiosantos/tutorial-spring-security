package br.com.glesioss.security.modules.account.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name", length = 50, nullable = false)
  private String firstName;

  @Column(name = "last_name", length = 50, nullable = false)
  private String lastName;

  @Column(name = "email", length = 150, nullable = false, unique = true)
  private String email;

  @Column(name = "password", length = 150, nullable = false)
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "role", length = 50, nullable = false)
  private Role role;

  @Column(name = "no_expired", columnDefinition = "boolean default 'true'")
  private boolean isAccountNonExpired;

  @Column(name = "no_locked", columnDefinition = "boolean default 'true'")
  private boolean isAccountNonLocked;

  @Column(name = "no_credentials_no_expired", columnDefinition = "boolean default 'true'")
  private boolean isCredentialsNonExpired;

  @Column(name = "enabled", columnDefinition = "boolean default 'true'")
  private boolean isEnabled;
}
