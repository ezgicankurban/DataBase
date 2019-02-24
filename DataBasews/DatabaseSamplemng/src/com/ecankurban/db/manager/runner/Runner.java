package com.ecankurban.db.manager.runner;

import java.sql.SQLException;

import com.ecankurban.db.manager.comming.ConnectionManager;

public class Runner {

	public static void main(String[] args) {
		try {
			ConnectionManager temp=ConnectionManager.getInstance();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
