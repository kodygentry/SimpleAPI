package com.ey.repositories;

import com.ey.models.Accounts;
import com.ey.models.People;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsRepo extends CrudRepository<Accounts,Integer> {
    List<Accounts> findByAccountType(String type);
}
