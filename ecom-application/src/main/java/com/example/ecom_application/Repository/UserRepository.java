package com.example.ecom_application.Repository;


import com.example.ecom_application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByFirstNameAndLastName(String firstName,String lastName);
    User findByEmail(String email);
}
