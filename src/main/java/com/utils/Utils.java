package com.utils;

import com.jfoenix.controls.JFXButton;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

@SuppressWarnings("restriction")
public class Utils {

	public static void bindRegionsWidthProperties(Region regionToBind, Region regionToBeBindedTo) {
		regionToBind.minWidthProperty().bind(regionToBeBindedTo.widthProperty());
		regionToBind.maxWidthProperty().bind(regionToBeBindedTo.widthProperty());
	}

	public static void initializeLabel(Label label, int width, String content) {
		label.setPrefWidth(width);
		label.setText(content);
	}

	public static void initializeTextField(TextField textField, int width, String content) {
		textField.setPrefWidth(width);
		textField.setText(content);
	}

	public static void initializeIconView(FontAwesomeIconView iconView, FontAwesomeIcon icon) {
		iconView.setIcon(icon);
		iconView.getStyleClass().add("icons");
	}

	public static void initializeButton(JFXButton button, FontAwesomeIconView iconView) {
		button.setGraphic(iconView);
		button.getStyleClass().add("buttons");
	}

}
