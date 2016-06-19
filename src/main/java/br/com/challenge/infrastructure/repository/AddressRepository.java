package br.com.challenge.infrastructure.repository;

import br.com.challenge.model.Address;
import org.springframework.stereotype.Repository;

/**
 * Class responsible to store and retrieve zip codes
 */
@Repository
public class AddressRepository {

    public Address find(String cep) {
        return new Address(cep, "neighborhood", "state", "city");
    }

}
