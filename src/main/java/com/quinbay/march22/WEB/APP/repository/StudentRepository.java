package com.quinbay.march22.WEB.APP.repository;


import com.quinbay.march22.WEB.APP.entity.Studententity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Studententity,Integer> {
}
