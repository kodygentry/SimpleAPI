package com.ey.services;
import com.ey.models.Accounts;
import com.ey.models.BankStatements;
import com.ey.models.People;
import com.ey.repositories.AccountsRepo;
import com.ey.repositories.BankStatementsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankStatementServiceImpl implements BankStatementsService {

    @Autowired
    BankStatementsRepo bsr;

    @Autowired
    AccountsRepo ar;

    @Override
    public BankStatements addBankStatements(BankStatements b) {
        return bsr.save(b);
    }

    @Override
    public BankStatements getBankStatements(int id) {
        return bsr.findById(id).get();
    }

    @Override
    public List<BankStatements> getAllBankStatements() {
        return (List<BankStatements>) bsr.findAll();
    }

    @Override
    public BankStatements updateBankStatements(BankStatements change) {
        return bsr.save(change);
    }

    @Override
    public boolean deleteBankStatements(int id) throws EmptyResultDataAccessException {
        try {
            bsr.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public BankStatements depositBankStatement(int x, double added) {

        BankStatements temp = bsr.findById(x).get();
        double newBalance = temp.getAccount().getBalance()+added;
        temp.getAccount().setBalance(newBalance);
        temp.setActionType("DEPOSIT");
        temp.setAmount(added);
        return bsr.save(temp);
    }

    @Override
    public BankStatements withdrawBankStatement(int change, double subtracted) {
        BankStatements temp = bsr.findById(change).get();
        double newBalance = temp.getAccount().getBalance()-subtracted;
        temp.getAccount().setBalance(newBalance);
        temp.setActionType("WITHDRAW");
        temp.setAmount(subtracted);
        return bsr.save(temp);
    }

    @Override
    public BankStatements deleteAccount(int x) {
        BankStatements temp = bsr.findById(x).get();
        Accounts accounts = temp.getAccount();
        accounts.setDateClosed(System.currentTimeMillis());
        temp.setActionType("DELETED");
        temp.setAmount(0.0);

        return temp;
    }

    @Override
    public BankStatements addAccount(People p) {

        Accounts a = new Accounts(1,p,100.00, System.currentTimeMillis(),0,"Checking Account",7.8);
        ar.save(a);


        BankStatements bankStatements = new BankStatements(1,a,System.currentTimeMillis(),"CREATE", 0.0, "Big Bank", "My Savings Account");
        return bsr.save(bankStatements);

    }


//    @Override
//    public List<BankStatements> getBankStatementsByAccount(int id, List<BankStatements> statements, List<Accounts> accounts) {
//        return null;
//
//    }

    @Override
    public List<BankStatements> filterBankStatementsWhereto(String whereTo, List<BankStatements> bankStatements) {
        List<BankStatements> refinedList = new ArrayList<>();
        bankStatements.forEach(bankStatements1 -> {
            if (bankStatements1.getWhereTo().equals(whereTo)) refinedList.add(bankStatements1);
        });

//        for(Movie movie : movies)
        return refinedList;
    }


    @Override
    public List<BankStatements> filterBankStatementsFromWhere(String fromWhere, List<BankStatements> statements) {
        List<BankStatements> refinedList = new ArrayList<>();
        statements.forEach(statement -> {
            if (statement.getWhereTo().equals(fromWhere)) refinedList.add(statement);
        });

//        for(Movie movie : movies)
        return refinedList;
    }

    @Override
    public List<BankStatements> filterBankStatementsByDate(long date, List<BankStatements> statements) {
        List<BankStatements> refinedList = new ArrayList<>();
        statements.forEach(statement -> {
            if(statement.getDateCreated() > date) refinedList.add(statement);
        });

        return refinedList;
    }

}