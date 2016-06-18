package br.com.challenge.infrastructure.repository;

import br.com.challenge.model.Zipcode;
import org.springframework.stereotype.Repository;

/**
 * Class responsible to store and retrieve zip codes
 */
@Repository
public class ZipcodeRepository {

    public Zipcode find(String zipcode) {
        return new Zipcode(zipcode, "neighborhood", "state", "city");
    }

}
