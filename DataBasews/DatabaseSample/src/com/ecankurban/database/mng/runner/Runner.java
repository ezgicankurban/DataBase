package com.ecankurban.database.mng.runner;

import com.ecankurban.database.mng.dao.ConnectionManager;

public class Runner {

	public static void main(String[] args) {
		ConnectionManager mng=new ConnectionManager();
		mng.getConnection();
	}
}
