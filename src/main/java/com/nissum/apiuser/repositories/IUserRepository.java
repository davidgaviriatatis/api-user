package com.nissum.apiuser.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nissum.apiuser.models.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

	@Query(value = "select * from USERS where EMAIL = ?1", nativeQuery = true)
	Optional<User> findByEmail(String email);
}
