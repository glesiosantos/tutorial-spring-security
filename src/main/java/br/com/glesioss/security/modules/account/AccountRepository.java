package br.com.glesioss.security.modules.account;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.glesioss.security.modules.account.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
