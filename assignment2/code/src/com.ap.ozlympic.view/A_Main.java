package com.ap.ass2.view;

import com.ap.ass2.controller.ViewAll;
import com.ap.ass2.controller.ViewCy;
import com.ap.ass2.controller.ViewOf;
import com.ap.ass2.controller.ViewRN;
import com.ap.ass2.controller.ViewSW;
import com.ap.ass2.model.Message;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class A_Main extends Application {
	public Button tree1btn1 = new Button();
	public Button tree1btn2 = new Button();
	public Button tree1btn3 = new Button();
	public Button tree1btn4 = new Button();
	public Button tree1btn5 = new Button();

	public Button tree2btn1 = new Button();
	public Button tree2btn2 = new Button();
	public Button tree2btn3 = new Button();

	public Button tree3btn1 = new Button();

	public BorderPane setBorder() {
		BorderPane layout = new BorderPane();

		return layout;

	}

	public void settop(BorderPane layout) {

		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);
		hbox.setStyle("-fx-background-color: #336699");
		Label toplabel = new Label("Welcome to Ozlympic");
		toplabel.setFont(new Font(35));
		toplabel.setTextFill(Color.BLACK);
		hbox.getChildren().add(toplabel);

		VBox vbox = new VBox();
		Separator sper = new Separator();
		sper.setOrientation(Orientation.HORIZONTAL);
		sper.setStyle(" -fx-background-color: #e79423;-fx-background-radius: 2;");
		vbox.getChildren().addAll(hbox, sper);

		layout.setTop(vbox);
	}

	// setLEFT
	public void setleft(BorderPane layout) {

		// node1
		VBox vb1 = new VBox(5);
		vb1.setPadding(new Insets(15, 12, 15, 12));
		tree1btn1.setText("All Participants");
		tree1btn1.setPrefSize(150, 20);

		tree1btn2.setText("Offical");
		tree1btn2.setPrefSize(150, 20);

		tree1btn3.setText("Cyclist");
		tree1btn3.setPrefSize(150, 20);

		tree1btn4.setText("Sprinter");
		tree1btn4.setPrefSize(150, 20);

		tree1btn5.setText("Swimmer");
		tree1btn5.setPrefSize(150, 20);

		vb1.getChildren().addAll(tree1btn1, tree1btn2, tree1btn3, tree1btn4, tree1btn5);
		TitledPane node1 = new TitledPane("View Participants", vb1);

		// node2
		VBox vb2 = new VBox(5);
		vb2.setPadding(new Insets(15, 12, 15, 12));
		tree2btn1.setText("Cyclist");
		tree2btn1.setPrefSize(150, 20);

		tree2btn2.setText("Running");
		tree2btn2.setPrefSize(150, 20);

		tree2btn3.setText("Swimming");
		tree2btn3.setPrefSize(150, 20);

		vb2.getChildren().addAll(tree2btn1, tree2btn2, tree2btn3);
		TitledPane node2 = new TitledPane("Select a Game", vb2);

		// node3
		VBox vb3 = new VBox(5);
		vb3.setPadding(new Insets(15, 12, 15, 12));
		tree3btn1.setText("QUIT");
		tree3btn1.setPrefSize(150, 20);

		vb3.getChildren().addAll(tree3btn1);
		TitledPane node3 = new TitledPane("HELP", vb3);

		// set node
		Accordion accordion = new Accordion();
		accordion.getPanes().add(node1);
		accordion.getPanes().add(node2);
		accordion.getPanes().add(node3);

		HBox hb = new HBox();
		Separator sper = new Separator();
		sper.setOrientation(Orientation.VERTICAL);
		sper.setStyle(" -fx-background-color: #e79423;-fx-background-radius: 2;");
		hb.getChildren().addAll(accordion, sper);

		// return
		layout.setLeft(hb);
	}

	// set centre
	/**
	 * @param layout
	 *            setin pane
	 */
	
	//public void 
	
	public void setcenter(final BorderPane layout) {
		Label normal = new Label("NORMAL");
		layout.setCenter(normal);
		
		//set node2 b
		// set node1 btn1
		tree1btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				layout.setCenter(tree1Modellayout(ViewAll.getList()));
			}

		});

		// set node1 btn2
		tree1btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				layout.setCenter(tree1Modellayout(ViewOf.getList()));
			}

		});

		// set node1 btn3
		tree1btn3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				layout.setCenter(tree1Modellayout(ViewCy.getList()));
			}

		});
		
		// set node1 btn4
		tree1btn4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				layout.setCenter(tree1Modellayout(ViewRN.getList()));
			}

		});
		
		// set node1 btn5
		tree1btn5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				layout.setCenter(tree1Modellayout(ViewSW.getList()));
			}

		});
	}

	// return node1 btn1
	public VBox tree1Modellayout(final ObservableList<Message> list) {
		// set table
		TableView<Message> tableview = new TableView<>();

		// tableview.getColumns().add(clo1);
		TableColumn clo1 = new TableColumn();
		clo1.setText("ID");
		clo1.setCellValueFactory(new PropertyValueFactory("ID"));
		clo1.setMinWidth(100);

		// tableview.getColumns().add(clo2);
		TableColumn clo2 = new TableColumn();
		clo2.setText("Type");
		clo2.setCellValueFactory(new PropertyValueFactory("Type"));
		clo2.setMinWidth(100);

		// tableview.getColumns().add(clo3);
		TableColumn clo3 = new TableColumn();
		clo3.setText("Name");
		clo3.setCellValueFactory(new PropertyValueFactory("Name"));
		clo3.setMinWidth(100);

		// tableview.getColumns().add(clo4);
		TableColumn clo4 = new TableColumn();
		clo4.setText("Age");
		clo4.setCellValueFactory(new PropertyValueFactory("Age"));
		clo4.setMinWidth(100);

		// tableview.getColumns().add(clo5);
		TableColumn clo5 = new TableColumn();
		clo5.setText("State");
		clo5.setCellValueFactory(new PropertyValueFactory("State"));
		clo5.setMinWidth(100);

		//
		tableview.setItems(list);
		tableview.getColumns().addAll(clo1, clo2, clo3, clo4, clo5);
		// tableview.setEditable(true);
		VBox tavbox = new VBox();
		tavbox.setSpacing(5);
		tavbox.setPadding(new Insets(10, 0, 0, 10));
		tavbox.getChildren().addAll(tableview);

		Separator sper1 = new Separator();
		sper1.setOrientation(Orientation.HORIZONTAL);
		Separator sper2 = new Separator();
		sper2.setOrientation(Orientation.HORIZONTAL);

		VBox vblast = new VBox();
		vblast.getChildren().addAll(sper1, sper2, tavbox);
		return vblast;
	}


	
	


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane root = setBorder();
		settop(root);
		setleft(root);
		setcenter(root);
		Scene scene = new Scene(root, 1000, 600);
		primaryStage.setTitle("Layout sample");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
