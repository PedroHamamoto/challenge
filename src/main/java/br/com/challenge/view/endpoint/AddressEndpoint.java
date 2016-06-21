package br.com.challenge.view.endpoint;

import br.com.challenge.infrastructure.exception.CepNotFoundException;
import br.com.challenge.model.Address;
import br.com.challenge.service.AddressService;
import br.com.challenge.view.presentation.dto.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Defines a <strong>Address</strong> api, which provides the CEP search service <br>
 * URI: <strong>/rs/cep</strong> <br>
 * Methods: <br>
 * <strong>GET</strong> returns a {@link Address} if it is valid or else returns a message error
 */
@RestController
@RequestMapping("/rs/cep")
public class AddressEndpoint {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/{cep}", method = RequestMethod.GET)
    public ResponseEntity<Resource> getCep(@PathVariable String cep, HttpServletRequest request) throws CepNotFoundException {
        Address found = addressService.search(cep);

        Resource<Address> resource = new Resource<Address>(request.getRequestURI(), found);

        return new ResponseEntity(resource, HttpStatus.OK);
    }
}
