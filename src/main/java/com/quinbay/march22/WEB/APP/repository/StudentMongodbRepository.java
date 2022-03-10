package com.quinbay.march22.WEB.APP.repository;

import com.quinbay.march22.WEB.APP.entity.StudentMongodbentity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentMongodbRepository  extends MongoRepository<StudentMongodbentity,Integer> {

}
