package com.nttdata.accountservice.model.repository;

import com.nttdata.accountservice.model.document.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AccountRepository  extends ReactiveMongoRepository<Account, String> {

}
