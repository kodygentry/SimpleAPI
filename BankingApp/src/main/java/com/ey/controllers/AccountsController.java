package com.ey.controllers;

import com.ey.Aspects.Authorized;
import com.ey.models.Accounts;
import com.ey.models.BankStatements;
import com.ey.models.People;
import com.ey.services.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountsController {

    AccountsService as;
    Accounts a;


    @Autowired //Constructor Injection
    public AccountsController(AccountsService as) {
        this.as = as;
    }

    // PEOPLE TRIVIAL SERVICES

    @PostMapping(value = "/people", consumes = "application/json", produces = "application/json")
    public People addPeople(@RequestBody People p) {
        System.out.println("Adding Person");
        return as.addPeople(p);
    }

    @GetMapping("/people/{id}")
    public People getPeople(@PathVariable("id") String id) {
        return as.getPeople(Integer.parseInt(id));
    }


    @GetMapping("/people")
    public List<People> getAllPeople() {
        System.out.println("Getting All People");
        return as.getAllPeople();
    }

    @PutMapping("/people/{id}")
    public People updatePeople(@PathVariable String id, @RequestBody People change) {
        change.setId(Integer.parseInt(id));
        return as.updatePeople(change);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity<Boolean> deletePeople(@PathVariable int id) {
        try {
            boolean wasDeleted = as.deletePeople(id);
            return new ResponseEntity<>(wasDeleted, (wasDeleted) ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/people/search/name")
    public List<People> getPeopleByName(@RequestParam String name) {
        return as.getPeopleByName(name);
    }

    @GetMapping("/people/search/username")
    public List<People> getPeopleByUsername(@RequestParam String username) {
        return as.getPeopleByUsername(username);
    }

    // ACCOUNT TRIVIAL SERVICES

    @PostMapping(value = "/accounts")
    public ResponseEntity<Accounts> addAccounts(@RequestBody Accounts a) {
        System.out.println("Adding Accounts");
        return as.addAccounts(a);
    }


    @GetMapping("/accounts/{id}")
    public Accounts getAccounts(@PathVariable("id") String id) {
        System.out.println("Getting Account #" + id);
        return as.getAccounts(Integer.parseInt(id));
    }

    @GetMapping("/accounts")
    public List<Accounts> getAllAccount() {
        System.out.println("Getting All Accounts");
        return as.getAllAccounts();
    }

    @PutMapping("/accounts/{id}")
    public Accounts updateAccounts(@PathVariable String id, @RequestBody Accounts change) {
        change.setId(Integer.parseInt(id));
        return as.updateAccounts(change);
    }

    @Authorized
    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<Boolean> deleteAccounts(@PathVariable int id) {
        if (as.getAccounts(id).getBalance() >= 0) {
            try {
                boolean wasDeleted = as.deleteAccounts(id);
                return new ResponseEntity<>(wasDeleted, (wasDeleted) ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
            } catch (EmptyResultDataAccessException e) {
                return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }
        else{
            System.out.println("Cannot Close Account with negative balance");
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


        @GetMapping("/accounts/search/type")
        public ResponseEntity<List<Accounts>> getAccountsByType (
                @RequestParam(required = false) String type){

            System.out.println("TYPE " + type);

            List<Accounts> accounts = as.getAllAccounts();
            if (type != null) accounts = as.getAccountsByType(type, accounts);

            return new ResponseEntity<>(accounts, HttpStatus.OK);
        }


    }

