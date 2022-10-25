package com.ey.controllers;

import com.ey.models.Accounts;
import com.ey.models.BankStatements;
import com.ey.models.People;
import com.ey.services.AccountsService;
import com.ey.services.BankStatementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankStatementsController {
    BankStatementsService bsr;
    AccountsService as;

    @Autowired //Constructor Injection
    public BankStatementsController(BankStatementsService bsr) {
        this.bsr = bsr;
    }
    @PostMapping(value = "/statements", consumes = "application/json", produces = "application/json")
    public BankStatements addBankStatement(@RequestBody BankStatements b) {
        System.out.println("Adding Statement");
        return bsr.addBankStatements(b);
    }
    @GetMapping("/statements/{id}")
    public BankStatements getBankStatements(@PathVariable("id") String id) {
        System.out.println("Getting Statement from Account #" + id);
        return bsr.getBankStatements(Integer.parseInt(id));
    }

    // only available for admin
    @GetMapping("/statements")
    public List<BankStatements> getAllBankStatements() {
        System.out.println("Getting all statements in DB");
        return bsr.getAllBankStatements();
    }

    @PutMapping(value = "/statements/{id}", consumes = "application/json", produces = "application/json")
    public BankStatements updateBankStatement(@PathVariable String id, @RequestBody BankStatements change) {
        System.out.println("Updated statement #" + id);
        change.setId(Integer.parseInt(id));
        return bsr.updateBankStatements(change);
    }

    @DeleteMapping("/statements/{id}")
    public ResponseEntity<Boolean> deleteBankStatement(@PathVariable int id) {
        try {
            boolean wasDeleted = bsr.deleteBankStatements(id);
            return new ResponseEntity<>(wasDeleted, (wasDeleted) ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/statements/search")
    public ResponseEntity<List<BankStatements>> getFilteredBankStatements(
            @RequestParam(required = false) long date){

        List<BankStatements> statements = bsr.getAllBankStatements();
        if(date != -1) statements = bsr.filterBankStatementsByDate(date, statements);

        return new ResponseEntity<>(statements, HttpStatus.OK);
    }

    @PutMapping(value = "/statements/deposit/{id}/{amount}", produces = "application/json")
    public BankStatements depositBankStatement(@PathVariable("id") String id, @PathVariable("amount") String amount) {
        System.out.println("Depositing #" + id);



        return bsr.depositBankStatement(Integer.parseInt(id), Double.parseDouble(amount));
    }

    @PutMapping(value = "/statements/withdraw/{id}/{amount}", produces = "application/json")
    public BankStatements withdrawBankStatement(@PathVariable("id") String id, @PathVariable("amount") String amount) {
        System.out.println("Withdrawing #" + id);


        return bsr.withdrawBankStatement(Integer.parseInt(id), Double.parseDouble(amount));
    }


    @PutMapping(value = "/statements/delete/{id}", consumes = "application/json", produces = "application/json")
    public BankStatements deleteAccount(@PathVariable("id") String id)
    {
        System.out.println("Deleting Account Number = " + id);
        return bsr.deleteAccount(Integer.parseInt(id));
    }

    @PutMapping(value = "/statements/create", consumes = "application/json", produces = "application/json")
    public BankStatements createAccount(@RequestBody People p)
    {
        System.out.println("Creating New Account");
        return createAccount(p);
    }

}
