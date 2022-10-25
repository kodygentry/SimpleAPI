package com.ey.models;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a_id", updatable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "people_id")
    private People people;

    @Column(columnDefinition = "NUMERIC(12,2)")
    private double balance;

    @Column(name = "date_created", columnDefinition = "bigint DEFAULT 0")
    private long dateCreated;

    @Column(name = "date_closed", columnDefinition = "bigint DEFAULT 0")
    private long dateClosed;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "interest_rate", nullable = false, columnDefinition = "NUMERIC(12,2)")
    private double interestRate;

    public Accounts() {}

    public Accounts(int id, People people, double balance, long dateCreated, long dateClosed, String accountType, double interestRate) {
        this.id = id;
        this.people = people;
        this.balance = balance;
        this.dateCreated = dateCreated;
        this.dateClosed = dateClosed;
        this.accountType = accountType;
        this.interestRate = interestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public long getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(long dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", people=" + people +
                ", balance=" + balance +
                ", dateCreated=" + dateCreated +
                ", dateClosed=" + dateClosed +
                ", accountType='" + accountType + '\'' +
                ", interestRate=" + interestRate +
                '}';
    }

}
