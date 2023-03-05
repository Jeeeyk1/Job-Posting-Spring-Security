package com.example.MongdoDb.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.example.MongdoDb.Model.JobModel;
import com.example.MongdoDb.Service.SearchService;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class SearchRepositoryImpl implements SearchService {
	@Autowired
	MongoClient client;
	@Autowired
	MongoConverter convert;

	@Override
	public List<JobModel> searchJob(String text) {
		// TODO Auto-generated method stub
		final List<JobModel> result = new ArrayList<>();

		MongoDatabase database = client.getDatabase("SpringProject");
		MongoCollection<Document> collection = database.getCollection("JobPost");
		
		AggregateIterable<Document> resultSearch = collection.aggregate(Arrays.asList(
				new Document("$search",
						new Document("index", "default").append("text",
								new Document("query", text).append("path",
										Arrays.asList("desc", "techs", "profile")))),
				new Document("$sort", new Document("exp", 1L)), new Document("$limit", 5L)));

		resultSearch.forEach(doc -> result.add(convert.read(JobModel.class, doc)));
		return result;
	}

}
