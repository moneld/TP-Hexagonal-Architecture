package fr.esgi.al.account.step8.application.services;

import fr.esgi.al.account.step8.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step8.application.port.in.CreateAccountUseCase;
import fr.esgi.al.account.step8.application.port.out.CreateAccountPort;
import fr.esgi.al.account.step8.domain.Account;
import fr.esgi.al.account.step8.domain.AccountId;

public class CreateAccountService implements CreateAccountUseCase {

    private final CreateAccountPort createAccountPort;

    public CreateAccountService(CreateAccountPort createAccountPort) {
        this.createAccountPort = createAccountPort;
    }

    @Override
    public AccountId createAccount(CreateAccountCommand createAccountCommand) {
        var accountId = createAccountPort.nextId();
        var account = new Account(accountId, createAccountCommand.initialMoney);
        createAccountPort.save(account);
        return accountId;
    }
}
