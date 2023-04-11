package br.com.glesioss.security.modules.account.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.glesioss.security.modules.account.AccountRepository;
import br.com.glesioss.security.modules.account.model.Account;
import br.com.glesioss.security.modules.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AccountService {

  private final AccountRepository accountRepository;

  public Account saveAccount(Account account) {
    return accountRepository.save(account);
  }

  @Transactional(readOnly = true)
  public Account findAccountByEmail(String email) throws Exception {
    return accountRepository.findByEmail(email).orElseThrow(() -> new ObjectNotFoundException("Email no found"));
  }

  public boolean existAccount(String email) {
    return accountRepository.findByEmail(email).isPresent();
  }
}
