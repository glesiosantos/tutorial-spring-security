package br.com.glesioss.security.modules.account.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.glesioss.security.modules.account.AccountRepository;
import br.com.glesioss.security.modules.account.model.Account;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AccountService {

  private final AccountRepository accountRepository;

  public Account saveAccount() {
    return null;
  }
}
