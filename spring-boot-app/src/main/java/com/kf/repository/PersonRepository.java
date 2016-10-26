package com.kf.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kf.model.DoPerson;

public interface PersonRepository extends CrudRepository<DoPerson, Long> {
	
	List<DoPerson> findByLastName(String lastName);

}
