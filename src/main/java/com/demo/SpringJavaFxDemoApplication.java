package com.demo;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@Configuration
@SpringBootApplication
@EnableJpaRepositories
public class SpringJavaFxDemoApplication extends Application {

	private ConfigurableApplicationContext context;
	private Parent root;

	public static void main(String[] args) throws Exception {
		Application.launch(args);
	}

	@Override
	public void init() throws IOException {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringJavaFxDemoApplication.class);
		context = builder.run(getParameters().getRaw().toArray(new String[0]));

		FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
		loader.setControllerFactory(context::getBean);
		root = loader.load();
	}

	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(root);
		scene.getStylesheets().add("/com/demo/style/demo.css");
		stage.setScene(scene);
		stage.show();
	}
}
