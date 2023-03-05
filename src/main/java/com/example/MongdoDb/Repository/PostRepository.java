package com.example.MongdoDb.Repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.MongdoDb.Model.JobModel;

public interface PostRepository extends MongoRepository<JobModel, String> {

	@Query("{ 'id' : ?0 }")
	JobModel findOneJob(String id);

}
