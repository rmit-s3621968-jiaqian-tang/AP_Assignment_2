
package com.ap.ozlympic.controller;

import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.ap.ass2.model.Message;

import javafx.collections.FXCollections;
import com.ap.ass2.model.SQLHelper;

public class ViewAll implements Initializable {

	public static ObservableList<Message> getList() {
		ObservableList<Message> list = FXCollections.observableArrayList();
	SQLHelper sp=new SQLHelper();
	try{
	String sql="select * from Participant;";
	ResultSet rs=sp.query(sql);
		
			while (rs.next()) {
				list.add(new Message(rs.getString("ID"), rs.getString("Type"), rs.getString("Name"), rs.getInt("Age"),
						rs.getString("State")));
			}
		} catch (Exception e2) {
			System.err.println(e2);
		}
		return list;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}
