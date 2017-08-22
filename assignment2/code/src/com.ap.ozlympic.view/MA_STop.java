package com.ap.ozlympic.view;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MA_STop {
	public void settop(BorderPane layout) {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);
		hbox.setStyle("-fx-background-color: #66CCFF");
		Label toplabel = new Label("Welcome to Ozlympic");
		toplabel.setFont(Font.font("Chalkduster", 35));
		toplabel.setTextFill(Color.BLACK);
		hbox.getChildren().add(toplabel);

		VBox vbox = new VBox();
		Separator sper = new Separator();
		sper.setOrientation(Orientation.HORIZONTAL);
		sper.setStyle(" -fx-background-color: #66CCFF;-fx-background-radius: 2;");
		vbox.getChildren().addAll(hbox, sper);

		layout.setTop(vbox);
	}
}
