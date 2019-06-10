package cn.css0209.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.css0209.shopping.user.UserDo;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

public class JDBCDao {

	public boolean add(String name, String pwd) {
		// TODO 自动生成的方法存根
		Connection conn = DbUtil.getConnection();
		String sql = "insert into user values(?,MD5(?),null)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			if (pstmt.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return false;
	}

	public boolean login(UserDo userDo) {
		// TODO 自动生成的方法存根
		Connection conn = DbUtil.getConnection();
		String sql = "select username,password from user where username=? and password=md5(?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDo.getName());
			pstmt.setString(2, userDo.getPwd());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addCart(String username, String[] cart) {
		Connection conn = DbUtil.getConnection();
		Log log = LogFactory.get(getClass());
		String sql = "update user set cart = ? where username = ?";
		try {
			String carts = findCart(username);
			for (String x : cart) {
				if (carts.matches(".*" + x + "(.*)")) {
					return false;
				}
			}
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			for (int i = 1; i <= cart.length; i++) {
				pstmt.setString(1, carts += "[" + cart[i - 1] + "]");
			}
			pstmt.setString(2, username);
			int flag = pstmt.executeUpdate();
//			System.out.println(flag);
			if (flag >= 0) {
				return true;
			}
		} catch (NullPointerException e) {
			Connection conn2 = DbUtil.getConnection();
			Log log2 = LogFactory.get(getClass());
			String sql2 = "update user set cart = ? where username = ?";
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);

				pstmt = conn.prepareStatement(sql);
				for (int i = 0; i <= cart.length; i++) {
					pstmt.setString(1, "[" + cart[i] + "]");
				}
				pstmt.setString(2, username);
				int flag = pstmt.executeUpdate();
//			System.out.println(flag);
				if (flag >= 0) {
					return true;
				}
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String findCart(String username) {
		Connection conn = DbUtil.getConnection();

		try {
			String sql = "select cart from user where username = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next() && rs != null) {
				return rs.getString("cart");
			} else {
				return "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
