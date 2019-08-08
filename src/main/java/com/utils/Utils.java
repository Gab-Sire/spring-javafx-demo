package com.utils;

import java.time.LocalTime;

import com.jfoenix.controls.JFXButton;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import eu.hansolo.medusa.Clock;
import eu.hansolo.medusa.ClockBuilder;
import eu.hansolo.medusa.LcdDesign;
import eu.hansolo.medusa.TimeSection;
import eu.hansolo.medusa.TimeSectionBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

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

	public static void drawClock(HBox clockBox) {

		TimeSection workDay = TimeSectionBuilder.create().start(LocalTime.of(9, 00, 00)).stop(LocalTime.of(15, 00, 00))
				.onTimeSectionEntered(event -> System.out.println("Working"))
				.onTimeSectionLeft(event -> System.out.println("")).color(Color.rgb(255, 0, 0)).build();

		TimeSection freeTime = TimeSectionBuilder.create().start(LocalTime.of(15, 00, 00)).stop(LocalTime.of(9, 00, 00))
				.onTimeSectionEntered(event -> System.out.println("Enjoying free time"))
				.onTimeSectionLeft(event -> System.out.println("")).color(Color.rgb(0, 0, 255)).build();

		Clock clock = ClockBuilder.create().sectionsVisible(true).sections(workDay, freeTime)
				.lcdDesign(LcdDesign.LIGHTGREEN).checkSectionsForValue(true).running(true).build();

		clockBox.getChildren().add(clock);
	}

}
