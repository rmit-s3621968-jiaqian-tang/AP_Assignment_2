package com.ap.ozlympic.view;

import java.util.ArrayList;

import com.ap.ozlympic.controller.Driver;
import com.ap.ozlympic.controller.ViewAll;
import com.ap.ozlympic.controller.ViewCy;
import com.ap.ozlympic.controller.ViewOf;
import com.ap.ozlympic.controller.ViewRn;
import com.ap.ozlympic.controller.ViewSw;
import com.ap.ozlympic.model.Athlete;
import com.ap.ozlympic.model.Cyclist;
import com.ap.ozlympic.model.GameFullException;
import com.ap.ozlympic.model.Message;
import com.ap.ozlympic.model.NoRefereeException;
import com.ap.ozlympic.model.Official;
import com.ap.ozlympic.model.Participants;
import com.ap.ozlympic.model.Sprinter;
import com.ap.ozlympic.model.SuperAthlete;
import com.ap.ozlympic.model.Swimmer;
import com.ap.ozlympic.model.TooFewAthleteException;
import com.ap.ozlympic.model.WrongTypeException;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	public Button tree1btn1 = new Button();
	public Button tree1btn2 = new Button();
	public Button tree1btn3 = new Button();
	public Button tree1btn4 = new Button();
	public Button tree1btn5 = new Button();

	public Button tree2btn1 = new Button();
	public Button tree2btn2 = new Button();

	public Button tree3btn1 = new Button();
	public Button tree3btn2 = new Button();
	private String gameType;

	ArrayList<Athlete> SelectedAthlete = new ArrayList<>();
	Official SelectedOfficial = null;

	public BorderPane setBorder() {
		BorderPane layout = new BorderPane();

		return layout;

	}

	public void settop(BorderPane layout) {
		MA_STop st = new MA_STop();
		st.settop(layout);
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
		TitledPane node1 = new TitledPane("VIEW PARTICIPANTS", vb1);

		// node2
		VBox vb2 = new VBox(5);
		vb2.setPadding(new Insets(15, 12, 15, 12));
		tree2btn1.setText("Games");
		tree2btn1.setPrefSize(150, 20);

		tree2btn2.setText("Help");
		tree2btn2.setPrefSize(150, 20);

		vb2.getChildren().addAll(tree2btn1, tree2btn2);
		TitledPane node2 = new TitledPane("GAME CENTRE", vb2);

		// node3
		VBox vb3 = new VBox(5);
		vb3.setPadding(new Insets(15, 12, 15, 12));
		tree3btn1.setText("Specification");
		tree3btn1.setPrefSize(150, 20);

		tree3btn2.setText("Author Detail");
		tree3btn2.setPrefSize(150, 20);

		vb3.getChildren().addAll(tree3btn1, tree3btn2);
		TitledPane node3 = new TitledPane("INFORMATION", vb3);

		// set node
		Accordion accordion = new Accordion();
		accordion.getPanes().add(node1);
		accordion.getPanes().add(node2);
		accordion.getPanes().add(node3);

		HBox hb = new HBox();
		Separator sper = new Separator();
		sper.setOrientation(Orientation.VERTICAL);
		sper.setStyle(" -fx-background-color: #66CCFF;-fx-background-radius: 2;");
		hb.getChildren().addAll(accordion, sper);

		// return
		layout.setLeft(hb);
	}

	// set centre
	public void setcenter(final BorderPane layout) {

		AnchorPane ap = new AnchorPane();
		ap.setStyle("-fx-background-color: #FFFFFF");
		Label lb1 = new Label("@2017 AP Assignment 2");
		lb1.setLayoutX(300);
		lb1.setLayoutY(500);

		Image image = new Image("file:image/Index.png");
		ImageView iv = new ImageView(image);
		iv.setFitHeight(215);
		iv.setFitWidth(620);
		iv.setLayoutX(100);
		iv.setLayoutY(150);
		ap.getChildren().addAll(lb1, iv);

		layout.setCenter(ap);

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

		// set node2
		// tree2btn1
		tree2btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				layout.setCenter(tree2Model1layout());
			}

		});

		// tree2btn2
		tree2btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				layout.setCenter(tree2Model2layout());
			}

		});

		// set node3
		// btn1
		tree3btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				layout.setCenter(tree3Model1layout());
			}

		});
		// btn2
		tree3btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				layout.setCenter(tree3Model2layout());
			}

		});

	}

	// return node1
	public AnchorPane tree1Modellayout(final ObservableList<Message> list) {
		AnchorPane ap = new AnchorPane();
		// set table
		TableView<Message> tableview = new TableView<>();
		tableview.setPrefWidth(800);

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

		Label lb0 = new Label("@2017 AP Assignment 2");
		lb0.setLayoutX(300);
		lb0.setLayoutY(500);

		VBox vblast = new VBox();
		vblast.getChildren().addAll(sper1, sper2, tavbox);
		vblast.setLayoutX(0);
		ap.getChildren().addAll(vblast, lb0);
		return ap;
	}

	// node2
	public VBox tree2Model1layout() {
		// ArrayList<Athlete> SelectedAthlete = new ArrayList<>();
		// Official SelectedOfficial=null;
		final int TooFewAthleteException = 3;
		final int GameFullException = 8;
		Text title1 = new Text();
		title1.setFill(Color.RED);
		title1.setFont(Font.font(14));
		Text title2 = new Text();
		title2.setFont(Font.font(25));
		Stage windows = null;
		Button str = new Button("Start Game");
		Button viewResult = new Button("View Result");
		Button viewHistory = new Button("View History");
		Button viewAll = new Button("Point Review");

		// game page
		// Get the data
		Driver driver = new Driver();
		driver.DBCheck();
		driver.txtCheck();
		driver.readData();
		driver.initialisation();

		// Label choose = new Label("choose 4 to 8 Athletes and 1 Offical");
		ListView<Participants> ParticipantsList1 = new ListView<>();
		ListView<Participants> ParticipantsList2 = new ListView<>();
		ArrayList<Participants> participants1 = new ArrayList<>();
		ArrayList<Participants> participants2 = new ArrayList<>();
		ArrayList<Athlete> athletesList = driver.getAthleteList();
		ArrayList<Official> officialList = driver.getOfficialList();
		ListView<String> gameList = new ListView<String>(
				FXCollections.observableArrayList(Driver.SWIM, Driver.CYCLE, Driver.RUN));
		participants1.addAll(athletesList);
		participants2.addAll(officialList);

		ObservableList<Participants> ParticipantsObservableList1 = FXCollections.observableArrayList(participants1);
		ObservableList<Participants> ParticipantsObservableList2 = FXCollections.observableArrayList(participants2);

		ParticipantsList1.setItems(ParticipantsObservableList1);
		ParticipantsList2.setItems(ParticipantsObservableList2);
		ParticipantsList1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		// multiple select ListView
		MultipleSelectionModel<Participants> selectionModel = ParticipantsList1.getSelectionModel();
		selectionModel.clearSelection();
		ParticipantsList1.setCellFactory(lv -> {
			ListCell<Participants> cell = new ListCell<Participants>() {
				@Override
				public void updateItem(Participants item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null) {
						setText(null);
					} else {
						setText(item.toString());
					}
				}
			};
			cell.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
				ParticipantsList1.requestFocus();
				if (!cell.isEmpty()) {
					int index = cell.getIndex();
					if (selectionModel.getSelectedIndices().contains(index)) {
						selectionModel.clearSelection(index);
					} else {
						selectionModel.select(index);
					}
					event.consume();
				}
			});
			return cell;
		});

		// Start Game
		gameList.getSelectionModel().selectedItemProperty()
				.addListener((ObservableValue<? extends String> ov, String oldVal, String newVal) -> {
					gameType = newVal;
				});

		str.setOnAction(

				e -> {

					ObservableList<Participants> OBSelectedAthlete = ParticipantsList1.getSelectionModel()
							.getSelectedItems();
					ObservableList<Participants> OBSelectedOfficial = ParticipantsList2.getSelectionModel()
							.getSelectedItems();

					try {
						SelectedAthlete = new ArrayList<>();
						SelectedOfficial = null;
						for (Participants athlete : OBSelectedAthlete) {
							switch (gameType) {
							case Driver.SWIM:
								if (athlete instanceof Swimmer || athlete instanceof SuperAthlete) {
									SelectedAthlete.add((Athlete) athlete);
									title1.setText("Success");
								} else
									throw new WrongTypeException();
								break;
							case Driver.CYCLE:
								if (athlete instanceof Cyclist || athlete instanceof SuperAthlete) {
									SelectedAthlete.add((Athlete) athlete);
									title1.setText("Success");
								} else
									throw new WrongTypeException();
								break;
							case Driver.RUN:
								if (athlete instanceof Sprinter || athlete instanceof SuperAthlete) {
									SelectedAthlete.add((Athlete) athlete);
									title1.setText("Success");
								} else
									throw new WrongTypeException();
								break;

							}
						}
						for (Participants official : OBSelectedOfficial) {
							if (official instanceof Official) {
								SelectedOfficial = ((Official) official);
								title1.setText("(Success)");
							} else {
								throw new WrongTypeException();
							}
						}
						if (SelectedAthlete.size() <= TooFewAthleteException)
							throw new TooFewAthleteException();
						else if (SelectedAthlete.size() >= GameFullException)
							throw new GameFullException();
						else if (SelectedOfficial == null)
							throw new NoRefereeException();

						driver.startgame(gameType, SelectedAthlete, SelectedOfficial);
						gameList.getSelectionModel().clearSelection();
						ParticipantsList1.getSelectionModel().clearSelection();
						ParticipantsList2.getSelectionModel().clearSelection();

					} catch (TooFewAthleteException e1) {
						title1.setText("TooFewAthleteException");
						title2.setText("Please add some Athletes.");
					} catch (GameFullException e2) {
						title1.setText("GameFullException");
						title2.setText("Please choose less Athletes.");
					} catch (NoRefereeException e3) {
						title1.setText("NoRefereeException");
						title2.setText("Please choose a Officer.");
					} catch (WrongTypeException e4) {
						title1.setText("Wrong type exception");
						title2.setText("Game type is not suit for Anthletes, please check again.");
					} catch (Exception e5) {
						title1.setText("Please select a game type");
						title2.setText("Please select a game type to play.");
					}

				}

		);

		viewResult.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub

				ArrayList<String> result = driver.getresult();
				ObservableList<String> resultObservableList = FXCollections.observableArrayList(result);
				AnchorPane AP1 = new AnchorPane();

				ListView<String> resultList = new ListView<>();
				resultList.setPrefWidth(400);
				resultList.setItems(resultObservableList);

				AP1.getChildren().addAll(resultList);
				final Stage dialog = new Stage();
				dialog.initModality(Modality.APPLICATION_MODAL);
				dialog.initOwner(windows);
				VBox dialogVBox = new VBox(20);
				dialogVBox.getChildren().add(AP1);

				Scene dialogScene = new Scene(dialogVBox, 400, 400);
				dialog.setScene(dialogScene);
				dialog.show();

			}

		});

		viewHistory.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub

				ArrayList<String> gameHistory = driver.getgamesHistory();
				ObservableList<String> gameHistoryObservableList = FXCollections.observableArrayList(gameHistory);
				AnchorPane AP1 = new AnchorPane();

				ListView<String> gameHistoryList = new ListView<>();
				gameHistoryList.setPrefWidth(400);
				gameHistoryList.setItems(gameHistoryObservableList);

				AP1.getChildren().addAll(gameHistoryList);
				final Stage dialog = new Stage();
				dialog.initModality(Modality.APPLICATION_MODAL);
				dialog.initOwner(windows);
				VBox dialogVBox = new VBox(20);
				dialogVBox.getChildren().add(AP1);

				Scene dialogScene = new Scene(dialogVBox, 400, 400);
				dialog.setScene(dialogScene);
				dialog.show();

			}

		});

		viewAll.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub

				AnchorPane AP1 = new AnchorPane();

				ListView<String> athletePointList = new ListView<>();
				driver.printSortAthelets();
				ArrayList<String> athletePoint = driver.getathletePoint();
				ObservableList<String> athletePointObservableList = FXCollections.observableArrayList(athletePoint);
				athletePointList.setPrefWidth(600);
				athletePointList.setItems(athletePointObservableList);

				AP1.getChildren().addAll(athletePointList);
				final Stage dialog = new Stage();
				dialog.initModality(Modality.APPLICATION_MODAL);
				dialog.initOwner(windows);
				VBox dialogVBox = new VBox(20);
				dialogVBox.getChildren().add(AP1);

				Scene dialogScene = new Scene(dialogVBox, 600, 400);
				dialog.setScene(dialogScene);
				dialog.show();

			}

		});

		// Layout
		Label tips = new Label("You can click \"View Result\" when you see the \"Success\"");
		tips.setPadding(new Insets(0, 10, 10, 10));
		HBox w = new HBox();
		Label warning = new Label("REMINDER:");
		w.getChildren().addAll(warning, title1);
		w.setPadding(new Insets(0, 10, 10, 10));
		VBox w1 = new VBox();
		w1.getChildren().addAll(w, title2);
		VBox vb0 = new VBox(tips, w1);

		Label gameType = new Label("Select Game Type");
		VBox vb1 = new VBox(gameType, gameList);
		// gameList.setPrefWidth(150);

		Label lbhbm = new Label("Select 4 to 8 Athletes");
		VBox vb2 = new VBox();
		HBox hb1 = new HBox();
		hb1.getChildren().addAll(lbhbm);
		vb2.getChildren().addAll(hb1, ParticipantsList1);

		AnchorPane ap = new AnchorPane();
		ap.getChildren().addAll(str, viewResult, viewHistory, viewAll);

		Label lbhbm1 = new Label("Select One Officer");
		VBox vb3 = new VBox();
		vb3.getChildren().addAll(lbhbm1, ParticipantsList2);

		// ParticipantsList1.setPrefWidth(350);
		// ParticipantsList2.setPrefWidth(200);
		vb1.setPadding(new Insets(10, 10, 10, 10));
		VBox parti = new VBox();
		parti.getChildren().addAll(vb2, vb3);
		parti.setPadding(new Insets(10, 10, 10, 10));
		parti.setPrefWidth(800);
		HBox hbbtn = new HBox();
		str.setLayoutX(50);
		viewResult.setLayoutX(250);
		viewHistory.setLayoutX(450);
		viewAll.setLayoutX(650);
		hbbtn.getChildren().addAll(ap);

		// final
		Label lb0 = new Label("@2017 AP Assignment 2");
		lb0.setLayoutX(300);
		lb0.setLayoutY(500);
		HBox gm = new HBox();
		gm.getChildren().addAll(vb1, parti);
		VBox gameModel = new VBox();
		gameModel.getChildren().addAll(vb0, gm, hbbtn);
		gameModel.setPadding(new Insets(10, 10, 10, 10));

		return gameModel;

	}

	// node 2 tree 2
	public AnchorPane tree2Model2layout() {
		AnchorPane ap = new AnchorPane();
		Label lb0 = new Label("@2017 AP Assignment 2");
		lb0.setLayoutX(300);
		lb0.setLayoutY(500);

		Label lb = new Label("HOW TO USE");
		lb.setLayoutX(50);
		lb.setLayoutY(5);
		lb.setFont(Font.font("Wawati SC", 30));

		Label lb1 = new Label("Step One");
		lb1.setLayoutX(50);
		lb1.setLayoutY(50);
		lb1.setFont(Font.font("Wawati SC", 25));

		Label lb2 = new Label("Choose The Game Type.");
		lb2.setLayoutX(50);
		lb2.setLayoutY(75);
		lb2.setFont(Font.font("Wawati SC", 20));

		Label lb3 = new Label("Step Two");
		lb3.setLayoutX(50);
		lb3.setLayoutY(100);
		lb3.setFont(Font.font("Wawati SC", 25));

		Label lb4 = new Label("Choose Four To Eight Anthletes and One Officer.");
		lb4.setLayoutX(50);
		lb4.setLayoutY(125);
		lb4.setFont(Font.font("Wawati SC", 20));

		Label lb5 = new Label("Step Three");
		lb5.setLayoutX(50);
		lb5.setLayoutY(150);
		lb5.setFont(Font.font("Wawati SC", 25));

		Label lb6 = new Label("Click \"Start Game\" Button.");
		lb6.setLayoutX(50);
		lb6.setLayoutY(175);
		lb6.setFont(Font.font("Wawati SC", 20));

		Label lb7 = new Label("Step Four");
		lb7.setLayoutX(50);
		lb7.setLayoutY(200);
		lb7.setFont(Font.font("Wawati SC", 25));

		Label lb8 = new Label("Click \"View Rresult\" Button.");
		lb8.setLayoutX(50);
		lb8.setLayoutY(225);
		lb8.setFont(Font.font("Wawati SC", 20));

		Label lb9 = new Label("OTHER FUNCTION");
		lb9.setLayoutX(50);
		lb9.setLayoutY(250);
		lb9.setFont(Font.font("Wawati SC", 25));

		Label lbA = new Label("View History: This funciton can help you to view past game result.");
		lbA.setLayoutX(50);
		lbA.setLayoutY(275);
		lbA.setFont(Font.font("Wawati SC", 20));

		Label lbB = new Label("Point Review: This funciton can help you to view All anthlete final points.");
		lbB.setLayoutX(50);
		lbB.setLayoutY(300);
		lbB.setFont(Font.font("Wawati SC", 20));

		ap.getChildren().addAll(lb, lb0, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lbA, lbB);
		ap.setStyle("-fx-background-color: #FFFFFF;");
		return ap;
	}

	// node 3 tree1
	public AnchorPane tree3Model1layout() {
		AnchorPane apT3B1 = new AnchorPane();
		Image image = new Image("file:image/target.png");
		ImageView iv = new ImageView(image);

		iv.setFitHeight(520);
		iv.setFitWidth(500);
		apT3B1.getChildren().addAll(iv);
		apT3B1.setStyle("-fx-background-color: #FFFFFF;");

		return apT3B1;
	}

	// node3 tree2
	public AnchorPane tree3Model2layout() {
		AnchorPane ap = new AnchorPane();
		Label lb0 = new Label("@2017 AP Assignment 2");
		lb0.setLayoutX(300);
		lb0.setLayoutY(500);

		Label lb1 = new Label("Name/StudentID：");
		lb1.setLayoutX(550);
		lb1.setLayoutY(300);
		lb1.setFont(Font.font("Wawati SC", 20));

		Label lb2 = new Label("Jiaqian Tang/s3621968");
		lb2.setLayoutX(550);
		lb2.setLayoutY(325);
		lb2.setFont(Font.font("Wawati SC", 20));

		Label lb3 = new Label("Kaixin Ren/s3617315");
		lb3.setLayoutX(550);
		lb3.setLayoutY(350);
		lb3.setFont(Font.font("Wawati SC", 20));

		Label lb4 = new Label("Thank You For Your Using!");
		lb4.setLayoutX(50);
		lb4.setLayoutY(50);
		lb4.setFont(Font.font("Wawati SC", 60));

		ap.getChildren().addAll(lb0, lb1, lb2, lb3, lb4);
		ap.setStyle("-fx-background-color: #FFFFFF;");

		return ap;
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
