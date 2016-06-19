package br.com.challenge;

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

        return addressRepository.find(cep);
    }

    private boolean isAValidCep(String cep) {
        return cep.matches("\\d{8}");
    }

}
