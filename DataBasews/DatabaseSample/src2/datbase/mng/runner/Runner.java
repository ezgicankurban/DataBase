package datbase.mng.runner;

import datbase.mng.dao.ConnectionManager2;

public class Runner {
	public static void main(String[] args) {
		ConnectionManager2 mng=new ConnectionManager2();
		mng.getConnection();
	}

}
