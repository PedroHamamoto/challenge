package br.com.challenge.infrastructure.repository;

import br.com.challenge.model.Address;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

public class AddressRepositoryTest {

    private AddressRepository addressRepository;

    private static final String EXISTING_CEP = "12345678";
    private static final String NON_EXISTING_CEP = "00000000";

    private Address existingAddress;

    @Before
    public void setUp() {
        addressRepository = new AddressRepository();
        existingAddress = new Address(EXISTING_CEP, "Bairro A", "Estado A", "Cidade A");
    }

    @Test
    public void shouldFindAnExistingAddress() {
        Address address = addressRepository.find(EXISTING_CEP);
        assertThat(address, is(existingAddress));
    }

    @Test
    public void shouldNotFindANonexistentAddress() {
        Address address = addressRepository.find(NON_EXISTING_CEP);
        assertThat(address, nullValue());
    }

}