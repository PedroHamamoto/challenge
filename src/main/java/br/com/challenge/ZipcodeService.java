package br.com.challenge;

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
        return zipcodeRepository.find(zipcode);
    }

}
