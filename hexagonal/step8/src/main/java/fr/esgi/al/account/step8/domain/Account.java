package fr.esgi.al.account.step8.domain;

import java.util.Objects;

public final class Account {

    private final fr.esgi.al.account.step8.domain.AccountId accountId;
    private fr.esgi.al.account.step8.domain.Money balance;

    public Account(fr.esgi.al.account.step8.domain.AccountId accountId, fr.esgi.al.account.step8.domain.Money balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public void withdraw(fr.esgi.al.account.step8.domain.Money money) {
        this.balance = this.balance.minus(money);
    }

    public void deposit(fr.esgi.al.account.step8.domain.Money money) {
        this.balance = this.balance.add(money);
    }

    public AccountId id() {
        return accountId;
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

    @Override
    public String toString() {
        return String.format("[id=%s,balance=%,.2f]", id().value(), balance.value());
    }
}
