package com.ey.repositories;

import com.ey.models.BankStatements;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankStatementsRepo extends CrudRepository<BankStatements,Integer> {
}
