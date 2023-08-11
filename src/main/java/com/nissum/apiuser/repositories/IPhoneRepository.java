package com.nissum.apiuser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissum.apiuser.models.Phone;

@Repository
public interface IPhoneRepository extends JpaRepository<Phone, Long>{

}
