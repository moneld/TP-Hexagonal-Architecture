package fr.esgi.al.account.step2.domain;

import java.util.Objects;

public final class Account {

    private final AccountId accountId;
    private Money balance;

    public Account(AccountId accountId, Money balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public void withdraw(Money money) {
        validateTransfer(money);
        this.balance = this.balance.minus(money);
    }

    public void deposit(Money money) {
        validateTransfer(money);
        this.balance = this.balance.add(money);
    }

    private void validateTransfer(Money money) {
        if (!money.isPositive()) {
            throw AccountException.create();
        }
    }

    public AccountId id() {
        return accountId;
    }

    public Money balance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }
}
