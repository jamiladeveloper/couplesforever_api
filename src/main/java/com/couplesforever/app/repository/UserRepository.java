package com.couplesforever.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.couplesforever.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	
	@Query("SELECT u FROM User u WHERE u.userid = ?1")
	User findByUserId(String userid);
}
