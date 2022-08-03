package com.nttdata.accountservice.api;


import com.nttdata.accountservice.model.document.Account;
import com.nttdata.accountservice.model.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class for AccountController.
 */
@RestController
@RequestMapping("/accounts")
@Slf4j
public class AccountController {

  @Autowired
  private AccountService accountService;

  /**
   * Get list of accounts.
   *
   * @param account references Account
   * @return account
   */
  @GetMapping
  public Flux<Account> findAll(@RequestBody Account account) {
    Flux<Account> response = accountService.getAll();
    log.info("findAll");
    log.debug(response.toString());
    return response;
  }

  /**
   * Create account.
   *
   * @param account represents Account
   * @return account
   */
  @PostMapping
  public Mono<Account> create(@RequestBody Account account) {
    Mono<Account> response = accountService.save(account);
    log.info("create OK");
    log.debug(response.toString());
    return response;
  }

  /**
   * Update account.
   *
   * @param account represents Account
   */
  @PutMapping
  public void update(@RequestBody Account account) {
    accountService.update(account);
    log.info("update OK");
    log.debug(account.getAccountId() + "/" + account.toString());
  }

  /**
   * Delete account by id.
   *
   * @param id represents accountId
   */
  @DeleteMapping({"{id}"})
  public void delete(@PathVariable("id") String id) {
    accountService.delete(id);
    log.info("delete OK");
    log.debug(id.toString());
  }

}
