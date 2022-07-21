package com.nttdata.accountservice.api;


import com.nttdata.accountservice.model.document.Account;
import com.nttdata.accountservice.model.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/accounts")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * Get list of accounts
     * @param account
     * @return
     */
    @GetMapping
    public Flux<Account> findAll(@RequestBody Account account) {
        Flux<Account> response = accountService.getAll();
        log.info("findAll");
        log.debug(response.toString());
        return response;
    }

    /**
     * Create account
     * @param account
     * @return
     */
    @PostMapping
    public Mono<Account> create(@RequestBody Account account) {
        Mono<Account> response = accountService.save(account);
        log.info("create OK");
        log.debug(response.toString());
        return response;
    }

    /**
     * Update account
     * @param account
     */
    @PutMapping
    public void update(@RequestBody Account account) {
        accountService.update(account);
        log.info("update OK");
        log.debug(account.getAccountId() + "/" + account.toString());
    }

    /**
     * Delete account by id
     * @param id
     */
    @DeleteMapping({"{id}"})
    public void delete(@PathVariable("id") String id) {
        accountService.delete(id);
        log.info("delete OK");
        log.debug(id.toString());
    }

}
