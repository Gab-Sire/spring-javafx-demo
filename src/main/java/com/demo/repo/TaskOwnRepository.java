package com.demo.repo;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.demo.bean.Task;

public interface TaskOwnRepository extends Repository<Task, Long> {

	List<Task> findById(Integer id);

	List<Task> findByName(String name);

	List<Task> findByDescription(String description);
}
