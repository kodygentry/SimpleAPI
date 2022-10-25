package com.ey.services;

import com.ey.models.Accounts;
import com.ey.models.People;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountsService {

    // PEOPLE SERVICES
    public People addPeople(People p);
    public People getPeople(int id);
    public List<People> getAllPeople();
    public People updatePeople(People change);
    public boolean deletePeople(int id);

    public List<People> getPeopleByName(String name);
    public List<People> getPeopleByUsername(String username);

    // ACCOUNT SERVICES
    public ResponseEntity<Accounts> addAccounts(Accounts a);
    public Accounts getAccounts(int id);
    public List<Accounts> getAllAccounts();
    public Accounts updateAccounts(Accounts change);
    public boolean deleteAccounts(int id);
    public List<Accounts> getAccountsByType(String type, List<Accounts> accounts);
}
