package com.nttdata.accountservice.service;

import com.nttdata.accountservice.model.document.Account;
import com.nttdata.accountservice.model.repository.AccountRepository;
import com.nttdata.accountservice.model.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class for AccountServiceImpl.
 */
@Service
public class AccountServiceImpl implements AccountService {
  @Autowired
  private AccountRepository accountRepository;

  @Override
  public Flux<Account> getAll() {
    return this.accountRepository.findAll();
  }

  @Override
  public Mono<Account> save(Account account) {
    return this.accountRepository.save(account);
  }

  @Override
  public Mono<Account> findById(String id) {
    return this.accountRepository.findById(id);
  }

  @Override
  public Mono<Boolean> existsById(String id) {
    return this.accountRepository.existsById(id);
  }

  @Override
  public Mono<Account> update(Account account) {
    return this.accountRepository.save(account);
  }

  @Override
  public void delete(String id) {
    this.accountRepository.deleteById(id);
  }
}
