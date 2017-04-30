package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*
 * @Author Jiaqian Tang
 * 
 * Index of the game
 * 
 * 
 */

public class Index extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Button btn1 = new Button();
		Button btn2 = new Button();
		btn1.setText("Start");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
			}
		});

		btn2.setText("Close");
		btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Index.close();
			}

		});

		StackPane root = new StackPane();
		StackPane root1 = new StackPane();
		root.getChildren().add(btn1);
		root1.getChildren().add(btn2);
		Scene scene = new Scene(root, 100, 250);
		Scene scene1 = new Scene(root1, 400, 250);

		primaryStage.setTitle("OLYMPIZ");
		primaryStage.setScene(scene);
		primaryStage.setScene(scene1);
		primaryStage.show();
	}

	protected static void close() {
		// TODO Auto-generated method stub
		
	}

}
