package com.example.MongdoDb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import com.example.MongdoDb.Model.JobDTO;
import com.example.MongdoDb.Model.JobModel;
import com.example.MongdoDb.Repository.PostRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {

	private final PostRepository postRepository;
	
@Autowired
	private final SearchService searchService;

	public List<JobModel> getAllPost() {
		return postRepository.findAll();
	}

	public Optional<JobModel> postJob(JobModel jobModel) {
		postRepository.insert(jobModel);
		Optional<JobModel> newJob = postRepository.findById(jobModel.getId());

		if (newJob.isPresent()) {
			return newJob;
		} else {
			throw new IllegalStateException("No job Found");
		}

	}

	public List<JobModel> searchJob(String inputText) {

		List<JobModel> isEmpty = (searchService.searchJob(inputText));

		if (isEmpty.size() != 0) {
			return searchService.searchJob(inputText);
		} else if (isEmpty.isEmpty()) {
			throw new IllegalStateException("No jobs found");
		} else {
			throw new IllegalAccessError();
		}

	}

	public void updateJob(String id, JobDTO updateJob) {

		JobModel beforeData = postRepository.findOneJob(id);

		updateJob.setId(id);
		if (!updateJob.getDesc().isEmpty()) {
			beforeData.setDesc(updateJob.getDesc());
		}

		Integer exp = updateJob.getExp();

		if (exp != null) {
			beforeData.setExp(updateJob.getExp());
		}

		if (!updateJob.getProfile().isEmpty()) {
			beforeData.setProfile(updateJob.getProfile());
		}

		try {
			if (!updateJob.getTechs().equals(null)) {
				beforeData.setTechs(updateJob.getTechs());
			}
		} catch (NullPointerException e) {
			
		}

		postRepository.save(beforeData);

	}

	public void deleteJob(String id) {
		postRepository.deleteById(id);
	}

}
