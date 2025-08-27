// repository/UserRepository.java
package com.ecom.repository;
import com.ecom.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}