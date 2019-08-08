package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.bean.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
