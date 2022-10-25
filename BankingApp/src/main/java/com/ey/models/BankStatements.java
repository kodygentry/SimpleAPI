package com.ey.models;

import javax.persistence.*;
@Entity
@Table(name = "bank_statements")
public class BankStatements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bs_id", updatable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Accounts account;

    @Column(name = "date_created", columnDefinition = "bigint DEFAULT 0")
    private long dateCreated;

    @Column(name = "action_type")
    private String actionType;

    @Column(name = "amount", columnDefinition = "NUMERIC(12,2)")
    private double amount;

    @Column(name = "where_to")
    private String whereTo;

    @Column(name = "from_where")
    private String fromWhere;

    public BankStatements() {}

    public BankStatements(int id, Accounts account, long dateCreated, String actionType, double amount, String whereTo, String fromWhere) {
        this.id = id;
        this.account = account;
        this.dateCreated = dateCreated;
        this.actionType = actionType;
        this.amount = amount;
        this.whereTo = whereTo;
        this.fromWhere = fromWhere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getWhereTo() {
        return whereTo;
    }

    public void setWhereTo(String whereTo) {
        this.whereTo = whereTo;
    }

    public String getFromWhere() {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere) {
        this.fromWhere = fromWhere;
    }

    @Override
    public String toString() {
        return "BankStatements{" +
                "id=" + id +
                ", account=" + account +
                ", dateCreated=" + dateCreated +
                ", actionType='" + actionType + '\'' +
                ", amount=" + amount +
                ", whereTo='" + whereTo + '\'' +
                ", fromWhere='" + fromWhere + '\'' +
                '}';
    }
}