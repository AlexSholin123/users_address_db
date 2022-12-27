package ua.sholin.databasepractice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.sholin.databasepractice.models.Address;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AddressServiceTest {
    @Autowired
    AddressService addressService;


    @Test
//    @Order(1)
    public void testCreate() {
        Address address = new Address();
        address.setId(1L);
        address.setCity("Macao");
        address.setHomeNumber("4");
        address.setStreet("Main Street");
        addressService.createAddress(address);
        assertNotNull(addressService.findById(1L));
    }

    @Test
//    @Order(2)
    public void testReadAll() {
        List<Address> list = addressService.findAll();
        int startSizeList = list.size();
        Address address = new Address();
        address.setId(3L);
        address.setCity("Macao");
        address.setHomeNumber("4");
        address.setStreet("Main Street");
//        list.add(address);
        addressService.createAddress(address);
        list=addressService.findAll();
        int finalsizelist=list.size();
        assertThat(finalsizelist).isGreaterThan(startSizeList);
    }

    @Test
//    @Order(3)
    public void testSingleAddress() {
        Address address = new Address();
        address.setCity("Lviv");
        address.setHomeNumber("4");
        address.setStreet("Main Street");
        addressService.createAddress(address);
        List<Address> all = addressService.findAll();
        Address address1 = addressService.findById((long)all.size());
        assertEquals("Lviv",address1.getCity());
    }

    @Test
//    @Order(4)
    public void testUpdate() {
        Address address = new Address();
        address.setCity("Lviv");
        address.setHomeNumber("4");
        address.setStreet("Main Street");
        addressService.createAddress(address);
        List<Address> all = addressService.findAll();
        int firstSize = all.size();
        Address editedAddress = new Address("Paris", "Rue", "5");
        addressService.edit(firstSize, editedAddress);
        List<Address> secondAll = addressService.findAll();
        int finishSize = secondAll.size();
        assertEquals("Paris",addressService.findById((long) finishSize).getCity());
        assertEquals(firstSize,finishSize);
    }

    @Test
//    @Order(5)
    public void testDelete(){
        addressService.delete(1L);
        assertThat(addressService.existsById(1L)).isFalse();
    }
}
