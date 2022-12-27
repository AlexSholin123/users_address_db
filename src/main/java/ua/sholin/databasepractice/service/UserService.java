package ua.sholin.databasepractice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.sholin.databasepractice.models.Address;
import ua.sholin.databasepractice.models.Users;
import ua.sholin.databasepractice.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository usersRepository){
        this.userRepository = usersRepository;
    }

    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    public Users edit(long id, Users editedUser) {
        Optional<Users> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new IllegalArgumentException();
        } else{
            editedUser.setId(id);
            return userRepository.save(editedUser);
        }
    }

    public List<Users> findAll(){
        return userRepository.findAll();
    }

    public Users findById(Long userId){
        Optional<Users> user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new IllegalArgumentException();
        } else {
            return user.get();
        }
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    public boolean existsById(long id) {
        return userRepository.existsById(id);
    }


//    public List<Users> findAllByName(String name){
//        return userRepository.findAllByName(name);
//    }
//
//    public List<Users> findWhereEmailIsGmail(){
//        return userRepository.findWhereEmailIsGmail();
//    }
//
//    public List<Users> findWhereNameStartsFromSmith(){
//        return userRepository.findWhereNameStartsFromSmith();
//    }
}
