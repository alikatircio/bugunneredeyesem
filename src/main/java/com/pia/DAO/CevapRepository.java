package com.pia.DAO;

import com.pia.Model.Cevap;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ali on 8.01.2018.
 */
public interface CevapRepository extends CrudRepository<Cevap, Integer> {

    public Cevap findByOfferId(int offerId);
}
