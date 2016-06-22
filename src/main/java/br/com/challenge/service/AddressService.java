package br.com.challenge.service;

import br.com.challenge.infrastructure.exception.InvalidCepException;
import br.com.challenge.infrastructure.repository.AddressRepository;
import br.com.challenge.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class responsible for the business rules from the zip code domain
 */
@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address search(String cep) {
        cep = cep.replace(" ", "").replace("-", " ");

        if (!this.isAValidCep(cep)) {
            throw new InvalidCepException();
        }

        Address address = searchAValidAddress(cep);

        if (address != null) {
            return address;
        } else {
            throw new InvalidCepException();
        }
    }

    private Address searchAValidAddress(String cep) {
        Address address = addressRepository.find(cep);

        int index = 8;
        char[] charCep = cep.toCharArray();

        while (address == null && !cep.equals("00000000")) {
            charCep[--index] = '0';
            cep = new String(charCep);
            address = addressRepository.find(cep);
        }

        return address;
    }

    private boolean isAValidCep(String cep) {
        return cep.matches("\\d{8}");
    }

}
