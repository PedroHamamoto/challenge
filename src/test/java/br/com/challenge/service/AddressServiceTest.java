package br.com.challenge.service;

import br.com.challenge.infrastructure.exception.CepNotFoundException;
import br.com.challenge.infrastructure.exception.InvalidCepException;
import br.com.challenge.infrastructure.repository.AddressRepository;
import br.com.challenge.model.Address;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;
    @InjectMocks
    private AddressService addressService;

    private static final String EXISTING_CEP = "02545000";
    private static final String VALID_CEP = "02545865";
    private static final String INVALID_CEP = "1234567";
    private static final String NONEXISTENT_CEP = "99999999";

    private Address existingAddress;

    @Before
    public void setUp() {
        existingAddress = new Address(EXISTING_CEP, "Bairro", "Estado", "Cidade");
        when(addressRepository.find(EXISTING_CEP)).thenReturn(existingAddress);
    }

    @Test
    public void shouldGetAnExistentAddress() {
        Address address = addressService.search(EXISTING_CEP);

        assertThat(address, is(existingAddress));
    }

    @Test
    public void shouldGetAValidCepAddress() {
        Address address = addressService.search(VALID_CEP);

        assertThat(address, is(existingAddress));
    }

    @Test(expected = InvalidCepException.class)
    public void shouldNotGetAnInvalidCep() {
        Address address = addressService.search(INVALID_CEP);
    }

    @Test(expected = CepNotFoundException.class)
    public void shouldNotGetANonexistentCep() {
        Address address = addressService.search(NONEXISTENT_CEP);
    }

}