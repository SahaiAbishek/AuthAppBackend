package com.auth.loginApp.repositories;

import com.auth.loginApp.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepo extends MongoRepository<User, String> {

    Optional<List<User>> findByEmailAndPassword(String email, String password);

}
