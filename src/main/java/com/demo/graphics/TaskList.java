package com.demo.graphics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.bean.Task;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

@Component
public class TaskList {

	private VBox taskListBox;
	private static List<Task> tasks = new ArrayList<>();

	@Autowired
	private TaskForm taskForm;

	@Autowired
	private TaskEntry taskEntry;

	public void initialize(List<Task> tasks, VBox taskListBox) {
		this.tasks = tasks;
		this.taskListBox = taskListBox;
	}

	public void draw() {

		taskListBox.getChildren().removeAll(taskListBox.getChildren());

		HBox taskBox = null;

		for (Task task : tasks) {

			if (null != task) {

				taskBox = task.IsForm() ? taskForm.draw(task) : taskEntry.draw(task);
				taskListBox.getChildren().add(taskBox);
			}
		}
		taskBox = taskForm.draw(new Task());
		taskListBox.getChildren().add(taskBox);
	}

	public void toggleTaskType(Task task) {
		task.setIsForm(!task.IsForm());
	}

	public void add(Task task) {
		tasks.add(task);
	}

	public void remove(Task task) {
		tasks.remove(task);
	}
}
