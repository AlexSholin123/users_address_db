package ua.sholin.databasepractice.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.sholin.databasepractice.models.Address;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    @DisplayName("It should save the address to the database")
    void save(){
        //Arrange
        Address address = new Address();
        address.setCity("city");
        address.setStreet("street");
        address.setHomeNumber("number");
        //Act
        Address newAddress = addressRepository.save(address);
        //Assert
        assertNotNull(newAddress);
        assertThat(newAddress.getId()).isNotEqualTo(null);
        assertThat(newAddress.getCity()).isEqualTo("city");
        assertThat(newAddress.getStreet()).isEqualTo("street");
        assertThat(newAddress.getHomeNumber()).isEqualTo("number");
   }

    @Test
    @DisplayName("It should return the addresses")
    void getAllAddresses(){
        //Arrange
        Address address = new Address();
        address.setCity("city");
        address.setStreet("street");
        address.setHomeNumber("number");
        //Act
        addressRepository.save(address);
        //Arrange
        Address newAddress = new Address();
        address.setCity("new city");
        address.setStreet("new street");
        address.setHomeNumber("new number");
        //Act
        addressRepository.save(newAddress);

        List<Address> addressList = addressRepository.findAll();
        //Assert
        assertNotNull(addressList);
        assertThat(addressList).isNotNull();
        assertEquals(2,addressList.size());
    }

}
