package com.pia.DAO;

import com.pia.Model.Kisi;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ali on 25.12.2017.
 */
public interface KisiRepository extends CrudRepository<Kisi, Integer> {

    public Kisi findByEmail(String email);

    public Kisi findByEmailAndPassword (String email, String password);


}
