
package com.ap.ozlympic.controller;

import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.ap.ozlympic.model.Message;
import com.ap.ozlympic.model.SQLHelper;

import javafx.collections.FXCollections;

public class ViewCy implements Initializable {

	public static ObservableList<Message> getList() {
		ObservableList<Message> list = FXCollections.observableArrayList();
	SQLHelper sp=new SQLHelper();
	try{
	String sql="select * from participants where Type like 'cyclist' or  Type like 'super';";
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
