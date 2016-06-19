package br.com.challenge.service;

import br.com.challenge.infrastructure.exception.CepNotFoundException;
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

        Address address = addressRepository.find(cep);

        int digits = 1;

        while (address == null && digits != 8) {
            cep.replaceAll("\\d{" + digits++ + "}$", "0");
            address = addressRepository.find(cep);
        }

        if (address != null) {
            return address;
        } else {
            throw new CepNotFoundException();
        }
    }

    private boolean isAValidCep(String cep) {
        return cep.matches("\\d{8}");
    }

}
