package com.ey.services;
import com.ey.models.Accounts;
import com.ey.models.People;
import com.ey.repositories.AccountsRepo;
import com.ey.repositories.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AccountsServiceImpl implements AccountsService {

    AccountsRepo ar;
    PeopleRepo pr;
    @Autowired
    public AccountsServiceImpl(PeopleRepo pr, AccountsRepo ar) {
        this.ar = ar;
        this.pr = pr;
    }

    // PEOPLE SERVICES
    @Override
    public People addPeople(People p) {
        return pr.save(p);
    }

    @Override
    public People getPeople(int id) {
        return pr.findById(id).get();
    }

    @Override
    public List<People> getAllPeople() {
        return (List<People>) pr.findAll();
    }

    @Override
    public People updatePeople(People change) {
        if (pr.findById(change.getId()).isPresent())
            return pr.save(change);
        else return null;
    }

    @Override
    public boolean deletePeople(int id) throws EmptyResultDataAccessException {
        try {
            pr.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<People> getPeopleByName(String name) {
        return pr.findByName(name);
    }

    @Override
    public List<People> getPeopleByUsername(String username) {
        return pr.findByUsername(username);
    }

    // ACCOUNT SERVICES

    @Override
    public ResponseEntity<Accounts> addAccounts(Accounts a) {

        if (a.getBalance()>=100)
            return ResponseEntity.ok(ar.save(a));
        return ResponseEntity.badRequest().build();
    }

    @Override
    public Accounts getAccounts(int id) {
        return ar.findById(id).get();
    }

    @Override
    public List<Accounts> getAllAccounts() {
        return (List<Accounts>) ar.findAll();
    }
    @Override
    public Accounts updateAccounts(Accounts change) {
        if (ar.findById(change.getId()).isPresent())
            return ar.save(change);
        else return null;
    }

    @Override
    public boolean deleteAccounts(int id) throws EmptyResultDataAccessException {
        try {
            ar.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Accounts> getAccountsByType(String type, List<Accounts> accounts) {
        List<Accounts> refinedList = new ArrayList<>();
        accounts.forEach(account -> {
            if (account.getAccountType().equals(type)) refinedList.add(account);
        });

        return refinedList;
    }
}