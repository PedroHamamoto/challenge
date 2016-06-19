package br.com.challenge;

import br.com.challenge.infrastructure.exception.ApplicationExceptionEnum;
import br.com.challenge.infrastructure.exception.InvalidCepException;
import br.com.challenge.infrastructure.repository.ZipcodeRepository;
import br.com.challenge.model.Zipcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class responsible for the business rules from the zip code domain
 */
@Service
public class ZipcodeService {

    @Autowired
    private ZipcodeRepository zipcodeRepository;

    public Zipcode search(String zipcode) {
        zipcode = zipcode.replace(" ", "").replace("-", " ");

        if (!this.isZipcodeValid(zipcode)) {
            throw new InvalidCepException();
        }

        return zipcodeRepository.find(zipcode);
    }

    private boolean isZipcodeValid(String zipcode) {
        return zipcode.matches("\\d{8}");
    }

}
