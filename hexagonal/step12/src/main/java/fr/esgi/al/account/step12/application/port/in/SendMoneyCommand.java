package fr.esgi.al.account.step12.application.port.in;

import fr.esgi.al.account.step12.domain.AccountId;
import fr.esgi.al.account.step12.domain.Money;
import fr.esgi.al.kernel.Command;

import javax.validation.constraints.NotNull;

public class SendMoneyCommand implements Command<SendMoneyCommand> {

    @NotNull
    public final AccountId sourceAccountId;
    @NotNull
    public final AccountId targetAccountId;
    @NotNull
    public final Money amount;

    public SendMoneyCommand(AccountId sourceAccountId, AccountId targetAccountId, Money amount) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;
        if (!this.amount.isPositive()) {
            throw new IllegalArgumentException();
        }
    }
}
