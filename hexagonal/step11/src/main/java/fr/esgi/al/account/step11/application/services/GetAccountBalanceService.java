package fr.esgi.al.account.step11.application.services;

import fr.esgi.al.account.step11.application.port.in.AccountBalanceQuery;
import fr.esgi.al.account.step11.application.port.in.GetAccountBalanceUseCase;
import fr.esgi.al.account.step11.application.port.out.LoadAccountPort;
import fr.esgi.al.account.step11.domain.Money;

public class GetAccountBalanceService implements GetAccountBalanceUseCase {

    private final LoadAccountPort loadAccountPort;

    public GetAccountBalanceService(LoadAccountPort loadAccountPort) {
        this.loadAccountPort = loadAccountPort;
    }

    @Override
    public Money handle(AccountBalanceQuery query) {
        var account = loadAccountPort.load(query.accountId);
        return account.balance();
    }
}
