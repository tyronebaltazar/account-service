package com.nttdata.accountservice.model.repository;

import com.nttdata.accountservice.model.document.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Class for AccountRepository.
 */
public interface AccountRepository  extends ReactiveMongoRepository<Account, String> {

}
