package com.aem.mind.core.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.aem.mind.core.dao.ServletDao;
import com.aem.mind.core.models.JDBCData;
import com.aem.mind.core.utility.DBConnection;

public class ServletDaoImpl implements ServletDao {

	@Override
	public void registerData(List<JDBCData> mb) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		PreparedStatement pt = null;
		String query = "insert into data(firstname,lastname,gender) values(?,?,?);";
		JDBCData m = mb.get(0);
		try {
			pt = con.prepareStatement(query);
			pt.setString(1, m.getFirstname());
			pt.setString(2, m.getAddress());
			pt.setString(3, m.getGender());
			pt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {

			try {
				if (pt != null) {
					pt.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
