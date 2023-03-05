package com.example.MongdoDb.PostController;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MongdoDb.Model.JobDTO;
import com.example.MongdoDb.Model.JobModel;

import com.example.MongdoDb.Service.PostService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/posts")
@AllArgsConstructor
public class PostController {

	private final PostService postService;

	@GetMapping()
	public List<JobModel> getAllPosts() {
		return postService.getAllPost();
	}

	@PostMapping("/postJob")
	public Optional<JobModel> postJob(@RequestBody JobModel jobModel) {
		return postService.postJob(jobModel);
	}

	@GetMapping("/posts/{text}")
	public List<JobModel> searchJob(@PathVariable("text") String text) {
		return postService.searchJob(text);
	}

	@PutMapping("/posts/{id}")
	public void updateJob(@PathVariable("id") String id, @RequestBody JobDTO jobDto) {
		postService.updateJob(id, jobDto);
	}

	@DeleteMapping("/post/{id}")

	public void deleteJob(@PathVariable("id") String id) {
		postService.deleteJob(id);
	}

}
