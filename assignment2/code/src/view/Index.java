package view;

import javafx.application.Application;
import javafx.application.Platform;
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
		btn1.setText("Start");
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub

				Platform.runLater(new Runnable() {
					public void run() {
						try {
							new MainGameView().start(new Stage());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				});//change the stage(open the new "windows"
			}

		});

		StackPane root = new StackPane();

		root.getChildren().add(btn1);

		Scene scene = new Scene(root, 400, 250);

		primaryStage.setTitle("OLYMPIZ");
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	protected static void close() {
		// TODO Auto-generated method stub

	}

}
