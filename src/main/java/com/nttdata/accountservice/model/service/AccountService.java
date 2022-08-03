package com.nttdata.accountservice.model.service;


import com.nttdata.accountservice.model.document.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class for AccountService.
 */
public interface AccountService {
  Flux<Account> getAll();

  Mono<Account> save(Account account);

  Mono<Account> findById(String id);

  Mono<Boolean> existsById(String id);

  Mono<Account> update(Account account);

  void delete(String id);
}
