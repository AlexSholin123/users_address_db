package ua.sholin.databasepractice.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.sholin.databasepractice.exceptions.AddressNotFoundException;
import ua.sholin.databasepractice.models.Address;
import ua.sholin.databasepractice.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public Address createAddress(Address address){
        return addressRepository.save(address);
    }

    public Address edit(long id, Address editedAddress) {
        Optional<Address> address = addressRepository.findById(id);
        if(address.isEmpty()) {
            throw new AddressNotFoundException("address not found", new Exception());
        } else {
            editedAddress.setId(id);
            return addressRepository.save(editedAddress);
        }
    }

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Address findById(Long addressId){
        Optional<Address> address = addressRepository.findById(addressId);
        if(address.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            return address.get();
        }
    }

    public void delete(long id) {
        addressRepository.deleteById(id);
    }

    public boolean existsById(long id) {
        return addressRepository.existsById(id);
    }
}
