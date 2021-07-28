package com.quynx.microservice.usersModule.rest.users.dtos;

import com.quynx.microservice.usersModule.rest.users.entities.Address;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddressDTOTest {

    @Test
    public void testAddressDTOConstructor1() {
        AddressDTO addressDTO = new AddressDTO();
        assertEquals(null, addressDTO.getCity());
        assertEquals(null, addressDTO.getCountry());
        assertEquals(null, addressDTO.getZipCode());
        assertEquals(null, addressDTO.getAddress());
        assertEquals(null, addressDTO.getAddress2());
    }

    @Test
    public void testAddressDTOConstructor2() {
        Address address = new Address();
        address.setCity("HN");
        address.setCountry("VN");
        address.setZipCode("10000");

        AddressDTO addressDTO = new AddressDTO(address);
        assertEquals("HN", addressDTO.getCity());
        assertEquals("VN", addressDTO.getCountry());
        assertEquals("10000", addressDTO.getZipCode());
    }

}
