package br.com.challenge.infrastructure.repository;

import br.com.challenge.model.Address;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class responsible to store and retrieve zip codes
 */
@Repository
public class AddressRepository {


    @Autowired
    private ResourceLoader resourceLoader;

    private Map<String, Address> data;

    public AddressRepository() throws IOException {
        data = new HashMap<>();

        InputStreamReader input = new InputStreamReader(getClass().getResourceAsStream("/mockAddress.json"));

        ObjectMapper mapper = new ObjectMapper();

        List<Address> addresses = mapper.readValue(input,
                TypeFactory.defaultInstance().constructCollectionType(List.class,
                        Address.class));

        for (Address a : addresses) {
            data.put(a.getCep(), a);
        }
    }

    public Address find(String cep) {
        return this.data.get(cep);
    }

}
