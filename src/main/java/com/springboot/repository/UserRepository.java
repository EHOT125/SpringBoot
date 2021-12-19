package com.springboot.repository;

import com.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("select u from User u where u.name =: n")
    User findUserByName(String name); /* @RequestParam("n") - в параметрах перед String */

}
