package com.ap.ozlympic.view;

import java.util.ArrayList;

import com.ap.ass2.controller.Driver;
import com.ap.ass2.controller.ViewAll;
import com.ap.ass2.controller.ViewCy;
import com.ap.ass2.controller.ViewOf;
import com.ap.ass2.controller.ViewRn;
import com.ap.ass2.controller.ViewSw;
import com.ap.ass2.model.Athlete;
import com.ap.ass2.model.Message;
import com.ap.ass2.model.Official;
import com.ap.ass2.model.Participants;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Separator;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application {

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
		MA_STop st = new MA_STop();
		st.settop(layout);
	}
	// public void setleft(BorderPane layout) {
	// MA_SLeft sl=new MA_SLeft();
	// sl.setleft(layout);
	// }

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
	// public void setcenter(final BorderPane layout) {
	// MA_SCenter sc=new MA_SCenter();
	// sc.setcenter(layout);
	// }

	public void setcenter(final BorderPane layout) {

		Label normal = new Label("NORMAL");
		layout.setCenter(normal);

		// set node2 bs..
		tree2btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				layout.setCenter(tree2Modellayout(ViewAll.getList()));
			}

		});

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
				layout.setCenter(tree1Modellayout(ViewRn.getList()));
			}

		});

		// set node1 btn5
		tree1btn5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				layout.setCenter(tree1Modellayout(ViewSw.getList()));
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

		tableview.setItems(list);
		tableview.getColumns().addAll(clo1, clo2, clo3, clo4, clo5);
		tableview.setEditable(true);
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

	public HBox tree2Modellayout(final ObservableList<Message> list) {
		Label lb1 = new Label("Select Player and Offical");
		Label lb2 = new Label("Current Player");

		Button btn1 = new Button("Add to Current Player");
		Button btn2 = new Button("Start Game");
		Button btn3 = new Button();

		TableView<Message> tableview1 = new TableView<>();
		// left
		// tableview.getColumns().add(clo1);
		TableColumn cl1 = new TableColumn();
		cl1.setText("ID");
		cl1.setCellValueFactory(new PropertyValueFactory("ID"));
		cl1.setMinWidth(100);

		// tableview.getColumns().add(clo2);
		TableColumn cl2 = new TableColumn();
		cl2.setText("Type");
		cl2.setCellValueFactory(new PropertyValueFactory("Type"));
		cl2.setMinWidth(100);

		// tableview.getColumns().add(clo3);
		TableColumn cl3 = new TableColumn();
		cl3.setText("Name");
		cl3.setCellValueFactory(new PropertyValueFactory("Name"));
		cl3.setMinWidth(100);

		// tableview.getColumns().add(clo4);
		TableColumn cl4 = new TableColumn();
		cl4.setText("Age");
		cl4.setCellValueFactory(new PropertyValueFactory("Age"));
		cl4.setMinWidth(100);

		// tableview.getColumns().add(clo5);
		TableColumn cl5 = new TableColumn();
		cl5.setText("State");
		cl5.setCellValueFactory(new PropertyValueFactory("State"));
		cl5.setMinWidth(100);

		tableview1.setItems(list);
		tableview1.getColumns().addAll(cl1, cl2, cl3, cl4, cl5);
		tableview1.setEditable(true);
		VBox tavbox1 = new VBox();
		tavbox1.setSpacing(10);
		tavbox1.setPadding(new Insets(10, 0, 0, 10));
		tavbox1.getChildren().addAll(lb1, tableview1, btn1);

		// Mid
		/*
		 * Label n1=new Label(); GridPane gp=new GridPane();
		 * gp.setGridLinesVisible(true); gp.setVgap(20); gp.setHgap(40);
		 * //gp.setPadding(new Insets(10,10,10,10));
		 * 
		 * Label txtID=new Label("ID"); GridPane.setConstraints(txtID, 0, 0);
		 * GridPane.setColumnSpan(txtID,2); GridPane.setHalignment(txtID,
		 * HPos.CENTER); Label txtType=new Label("Type");
		 * GridPane.setConstraints(txtType, 1, 0);
		 * GridPane.setColumnSpan(txtType,2); GridPane.setHalignment(txtType,
		 * HPos.CENTER); Label txtName=new Label("Name");
		 * GridPane.setConstraints(txtName, 2, 0);
		 * GridPane.setColumnSpan(txtName,2); GridPane.setHalignment(txtName,
		 * HPos.CENTER); Label txtAge=new Label("Age");
		 * GridPane.setConstraints(txtAge, 3, 0); GridPane.setHalignment(txtAge,
		 * HPos.CENTER); GridPane.setColumnSpan(txtAge,2); Label txtState=new
		 * Label("State"); GridPane.setConstraints(txtState, 4, 0);
		 * GridPane.setColumnSpan(txtState,2); GridPane.setHalignment(txtState,
		 * HPos.CENTER);
		 * 
		 * gp.getChildren().addAll(txtID,txtType,txtName,txtAge,txtState);
		 * 
		 * VBox tavbox3=new VBox(); tavbox3.setSpacing(10);
		 * tavbox3.setPadding(new Insets(10, 0, 0, 10));
		 * tavbox3.getChildren().addAll(lb2,gp,btn2);
		 */
		/*
		 * 
		 * TableView<Message> tableview2 = new TableView<>();
		 * 
		 * // tableview.getColumns().add(clo1); TableColumn co1 = new
		 * TableColumn(); co1.setText("ID"); co1.setCellValueFactory(new
		 * PropertyValueFactory("ID")); co1.setMinWidth(100);
		 * 
		 * // tableview.getColumns().add(clo2); TableColumn co2 = new
		 * TableColumn(); co2.setText("Type"); co2.setCellValueFactory(new
		 * PropertyValueFactory("Type")); co2.setMinWidth(100);
		 * 
		 * // tableview.getColumns().add(clo3); TableColumn co3 = new
		 * TableColumn(); co3.setText("Name"); co3.setCellValueFactory(new
		 * PropertyValueFactory("Name")); co3.setMinWidth(100);
		 * 
		 * // tableview.getColumns().add(clo4); TableColumn co4 = new
		 * TableColumn(); co4.setText("Age"); co4.setCellValueFactory(new
		 * PropertyValueFactory("Age")); co4.setMinWidth(100);
		 * 
		 * // tableview.getColumns().add(clo5); TableColumn co5 = new
		 * TableColumn(); co5.setText("State"); co5.setCellValueFactory(new
		 * PropertyValueFactory("State")); co5.setMinWidth(100);
		 * 
		 * // tableview1.setItems(); tableview2.getColumns().addAll(co1, co2,
		 * co3, co4, co5); tableview2.setEditable(true); VBox tavbox2 = new
		 * VBox(); tavbox2.setSpacing(10); tavbox2.setPadding(new Insets(10, 0,
		 * 0, 10)); tavbox2.getChildren().addAll(lb2, tableview2, btn2);
		 */
		// Items Declaration
		Driver driver = new Driver();
		driver.DBCheck();
		driver.txtCheck();
		driver.readData();
		driver.initialisation();

		//Label choose = new Label("choose 4 to 8 Athletes and 1 Offical");
		ListView<Participants> ParticipantsList1 = new ListView<>();
		ListView<Participants> ParticipantsList2= new ListView<>();
		ArrayList<Participants> participants1 = new ArrayList<>();
		ArrayList<Participants> participants2 = new ArrayList<>();
		ArrayList<Athlete> athletesList = driver.getAthleteList();
		ArrayList<Official> officialList = driver.getOfficialList();
		participants1.addAll(athletesList);
		participants2.addAll(officialList);

		ObservableList<Participants> ParticipantsObservableList1 = FXCollections.observableArrayList(participants1);
		ObservableList<Participants> ParticipantsObservableList2 = FXCollections.observableArrayList(participants2);

		ParticipantsList1.setItems(ParticipantsObservableList1);
		ParticipantsList2.setItems(ParticipantsObservableList2);
		ParticipantsList1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		Label lbhbm=new Label("Select 4 to 8 Athletes");
		VBox hbm = new VBox();
		hbm.getChildren().addAll(lbhbm,ParticipantsList1);
		
		
		
		Button str=new Button("Start Game");
		AnchorPane ap=new AnchorPane();
		ap.getChildren().addAll(str);
		str.setLayoutX(200);
		str.setLayoutY(50);
		Label lbhbm1=new Label("Select One Officer");
		VBox hbm1 = new VBox();
		hbm1.getChildren().addAll(lbhbm1,ParticipantsList2,ap);
		
		
	
		ParticipantsList1.setPrefWidth(400);
		ParticipantsList2.setPrefWidth(400);
		
		
		
		// final
		HBox gameModel = new HBox();
		gameModel.getChildren().addAll(hbm,hbm1);
		return gameModel;

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane root = setBorder();
		settop(root);
		setleft(root);
		setcenter(root);
		Scene scene = new Scene(root, 1000, 600);
		primaryStage.setTitle("Ozlympic");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
