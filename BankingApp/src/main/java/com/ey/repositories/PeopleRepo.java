package com.ey.repositories;

import com.ey.models.People;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PeopleRepo extends CrudRepository<People,Integer> {

    List<People> findByName(String name);
    List<People> findByUsername(String name);
}
