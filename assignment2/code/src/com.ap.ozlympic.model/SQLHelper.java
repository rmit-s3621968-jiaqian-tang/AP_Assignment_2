package package com.ap.ozlympic.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLHelper {
	ResultSet rs = null;
	Connection ct = null;
	Statement stat = null;
	String forname = "org.sqlite.JDBC";

	public SQLHelper() {
		try {
			Class.forName(forname);
			ct = DriverManager.getConnection("jdbc:sqlite:participants.db");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet query(String sql) {
		try {
			stat = ct.createStatement();
			rs = stat.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (stat != null)
				stat.close();
			if (ct != null)
				ct.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLHelper {
	ResultSet rs = null;
	Connection ct = null;
	Statement stat = null;
	String forname = "org.sqlite.JDBC";

	public SQLHelper() {
		try {
			Class.forName(forname);
			ct = DriverManager.getConnection("jdbc:sqlite:participants.db");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet query(String sql) {
		try {
			stat = ct.createStatement();
			rs = stat.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (stat != null)
				stat.close();
			if (ct != null)
				ct.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
