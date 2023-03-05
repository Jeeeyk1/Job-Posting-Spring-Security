package com.example.MongdoDb.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.MongdoDb.Model.JobModel;
@Service
public interface SearchService {

	
	 List<JobModel> searchJob(String text);
}
