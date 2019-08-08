package com.demo.graphics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.bean.Task;
import com.demo.controller.MainController;
import com.jfoenix.controls.JFXButton;
import com.utils.Constants;
import com.utils.Utils;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

@Component
public class TaskForm {

	private HBox taskFormBox;
	private JFXButton saveTaskButton;
	private FontAwesomeIconView saveButtonIconView;

	@Autowired
	private MainController mainController;

	public HBox draw(Task task) {

		taskFormBox = new HBox();
		taskFormBox.setSpacing(Constants.TASKBOX_SPACING);

		TextField inputTaskName = new TextField();
		TextField inputTaskDescription = new TextField();
		Utils.initializeTextField(inputTaskName, Constants.TASK_NAME_LENGTH, task.getName());
		Utils.initializeTextField(inputTaskDescription, Constants.TASK_DESCRIPTION_LENGTH, task.getDescription());

		drawButtons(task, inputTaskName, inputTaskDescription);

		taskFormBox.getChildren().addAll(inputTaskName, inputTaskDescription, saveTaskButton);

		return taskFormBox;
	}

	private void drawButtons(Task task, TextField inputTaskName, TextField inputTaskDescription) {

		saveTaskButton = new JFXButton();
		saveButtonIconView = new FontAwesomeIconView();

		if (task.getName().isEmpty() && task.getDescription().isEmpty()) {
			Utils.initializeIconView(saveButtonIconView, FontAwesomeIcon.FONT.SAVE);
		} else {
			Utils.initializeIconView(saveButtonIconView, FontAwesomeIcon.FONT.CHECK);
		}
		Utils.initializeButton(saveTaskButton, saveButtonIconView);

		saveTaskButton.setOnAction((event) -> {

			if (validateInputsAreEmpty(inputTaskName, inputTaskDescription)) {
				mainController.handleEmptyFieldError();
			} else {
				if (task.getName().isEmpty() && task.getDescription().isEmpty()) {
					mainController.handleSaveFromNewForm(task, inputTaskName.getText(), inputTaskDescription.getText());
				} else {
					mainController.handleSaveFromTaskForm(task, inputTaskName.getText(),
							inputTaskDescription.getText());
				}
			}
		});
	}

	private boolean validateInputsAreEmpty(TextField inputTaskName, TextField inputTaskDescription) {
		return inputTaskName.getText().trim().isEmpty() || inputTaskDescription.getText().trim().isEmpty();
	}
}
