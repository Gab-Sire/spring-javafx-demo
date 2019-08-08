package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.bean.Task;
import com.demo.graphics.TaskList;
import com.demo.service.TaskService;
import com.utils.Utils;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

@Component
@SuppressWarnings("restriction")
public class MainController {

	@FXML
	private AnchorPane toDoListWindow;

	@FXML
	private Label toDoListTitle;

	@FXML
	private Label toDoListSignature;

	@FXML
	private VBox taskListBox;

	@FXML
	private HBox clockBox;

	@FXML
	private VBox toDoListMainBox;

	@Autowired
	TaskService taskService;

	@Autowired
	private TaskList taskList;

	public void initialize() {
		
		Utils.bindRegionsWidthProperties(toDoListTitle, taskListBox);
		Utils.bindRegionsWidthProperties(toDoListSignature, taskListBox);

		taskService.initializeDemoTasks();
		List<Task> tasks = taskService.findAll();
		
		taskList.initialize(tasks, taskListBox);
		taskList.draw();
	}


	public void handleEditTask(Task task) {
		taskList.toggleTaskType(task);
		taskList.draw();
	}

	public void handleDeleteTask(Task task) {
		taskService.deleteTask(task);
		taskList.remove(task);
		taskList.draw();
	}

	public void handleSaveFromTaskForm(Task task, String name, String description) {
		handleSaveEditedTask(task, name, description);
		taskList.toggleTaskType(task);
		taskList.draw();
	}

	public void handleSaveFromNewForm(Task task, String name, String description) {
		handleSaveEditedTask(task, name, description);
		taskList.add(task);
		taskList.draw();
	}

	public void handleSaveEditedTask(Task task, String name, String description) {
		task.setName(name);
		task.setDescription(description);
		taskService.saveTask(task);
	}

	public void handleEmptyFieldError() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erreur !");
		alert.setHeaderText("Un ou plusieurs champs sont vides");
		alert.showAndWait();
	}

}
