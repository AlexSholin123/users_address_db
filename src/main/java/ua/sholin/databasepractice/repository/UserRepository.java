package ua.sholin.databasepractice.repository;

import org.springframework.data.jpa.repository.*;
import ua.sholin.databasepractice.models.Users;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {


}
