package ua.sholin.databasepractice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.sholin.databasepractice.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
