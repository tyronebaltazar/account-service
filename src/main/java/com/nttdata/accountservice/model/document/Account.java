package com.nttdata.accountservice.model.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Flux;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "accounts")
public class Account {

    @Id
    private String accountId;

    private String clientId;
    private String typeAccount;
    private String maintenance;
    private String monthlyMovementLimit;
    private String dateMovement;
    private Flux<Transaction> transactions;

}
