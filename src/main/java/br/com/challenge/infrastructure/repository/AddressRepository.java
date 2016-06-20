package br.com.challenge.infrastructure.repository;

import br.com.challenge.model.Address;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class responsible to store and retrieve zip codes
 */
@Repository
public class AddressRepository {

    private Map<String, Address> data;

    public AddressRepository() {
        data = new HashMap<>();

        List<Address> addresses = getAddresses();

        for (Address a : addresses) {
            data.put(a.getCep(), a);
        }
    }

    private List<Address> getAddresses() {
        InputStreamReader input = new InputStreamReader(getClass().getResourceAsStream("/mockAddress.json"));

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(input,
                    TypeFactory.defaultInstance().constructCollectionType(List.class,
                            Address.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Address find(String cep) {
        return this.data.get(cep);
    }

}
