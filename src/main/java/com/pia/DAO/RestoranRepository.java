package com.pia.DAO;

import com.pia.Model.Restoran;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ali on 15.12.2017.
 */
@Repository
public interface RestoranRepository extends CrudRepository<Restoran, Integer> {
}
