package br.com.glesioss.security.modules.security.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.glesioss.security.modules.account.model.Account;
import lombok.Getter;

public class CustomUserDetails implements UserDetails {

  @Getter
  private Account account;

  public CustomUserDetails(Account account) {
    this.account = account;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(this.account.getRole().toString()));
  }

  @Override
  public String getPassword() {
    return this.account.getPassword();
  }

  @Override
  public String getUsername() {
    return this.account.getEmail();
  }

  @Override
  public boolean isAccountNonExpired() {
    return this.account.isAccountNonExpired();
  }

  @Override
  public boolean isAccountNonLocked() {
    return this.account.isAccountNonLocked();
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return this.account.isCredentialsNonExpired();
  }

  @Override
  public boolean isEnabled() {
    return this.account.isEnabled();
  }

}
