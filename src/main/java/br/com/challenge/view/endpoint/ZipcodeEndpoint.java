package br.com.challenge.view.endpoint;

import br.com.challenge.model.Zipcode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Defines a <strong>cep</strong> api, which provides the zip code search service <br>
 * URI: <strong>/rs/cep</strong> <br>
 * Methods: <br>
 * <strong>GET</strong> returns a {@link Zipcode} if it is valid or else returns a message error
 */
@RestController
@RequestMapping("/cep")
public class ZipcodeEndpoint {

    @RequestMapping(value = "/{zipcode}", method = RequestMethod.GET)
    public ResponseEntity<Zipcode> getZipcode(@PathVariable String zipcode) {
        Zipcode found = new Zipcode(zipcode, "neighborhood", "state", "city");

        return new ResponseEntity<Zipcode>(found, HttpStatus.OK);
    }
}
