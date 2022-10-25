package com.ey.repositories;

import com.ey.models.Ranks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RanksRepo extends CrudRepository<Ranks,Integer> {
}
