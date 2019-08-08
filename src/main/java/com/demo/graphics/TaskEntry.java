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
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

@Component
@SuppressWarnings("restriction")
public class TaskEntry {

	private HBox taskEntryBox;
	private Label taskName;
	private Label taskDescription;
	private JFXButton editTaskButton;
	private JFXButton deleteTaskButton;

	@Autowired
	private MainController mainController;

	public HBox draw(Task task) {

		taskEntryBox = new HBox();
		taskEntryBox.setSpacing(Constants.TASKBOX_SPACING);

		taskName = new Label();
		taskDescription = new Label();
		Utils.initializeLabel(taskName, Constants.TASK_NAME_LENGTH, task.getName());
		Utils.initializeLabel(taskDescription, Constants.TASK_DESCRIPTION_LENGTH, task.getDescription());

		drawButtons(task);

		taskEntryBox.getChildren().addAll(taskName, taskDescription, editTaskButton, deleteTaskButton);

		return taskEntryBox;
	}

	private void drawButtons(Task task) {

		FontAwesomeIconView editIconView = new FontAwesomeIconView();
		FontAwesomeIconView deleteIconView = new FontAwesomeIconView();

		Utils.initializeIconView(editIconView, FontAwesomeIcon.FONT.EDIT);
		Utils.initializeIconView(deleteIconView, FontAwesomeIcon.FONT.REMOVE);

		editTaskButton = new JFXButton();
		deleteTaskButton = new JFXButton();
		Utils.initializeButton(editTaskButton, editIconView);
		Utils.initializeButton(deleteTaskButton, deleteIconView);

		editTaskButton.setOnAction((event) -> {
			mainController.handleEditTask(task);
		});

		deleteTaskButton.setOnAction((event) -> {
			mainController.handleDeleteTask(task);
		});
	}

}
