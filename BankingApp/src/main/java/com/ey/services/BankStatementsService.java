package com.ey.services;
import com.ey.models.Accounts;
import com.ey.models.BankStatements;
import com.ey.models.People;

import java.util.List;
public interface BankStatementsService {
    public BankStatements addBankStatements (BankStatements b);
    public BankStatements getBankStatements (int id);
    public List<BankStatements> getAllBankStatements();
    public BankStatements updateBankStatements(BankStatements change);
    public boolean deleteBankStatements(int id);

    public BankStatements depositBankStatement(int x, double added);

    public BankStatements withdrawBankStatement(int x, double subtracted);

    public BankStatements deleteAccount(int x);

    public BankStatements addAccount(People p);

    public List<BankStatements> filterBankStatementsWhereto(String whereTo, List<BankStatements> bankStatements);
    public List<BankStatements> filterBankStatementsFromWhere(String fromWhere, List<BankStatements> bankStatements );
    public List<BankStatements> filterBankStatementsByDate(long date, List<BankStatements> statement);
}