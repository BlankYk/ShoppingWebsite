package cn.css0209.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.css0209.shopping.user.UserDo;

public class JDBCDao{

	public boolean add(String name, String pwd) {
		// TODO 自动生成的方法存根
		Connection conn = DbUtil.getConnection();
		String sql = "insert into user values(?,?,null)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			if(pstmt.executeUpdate()>0) {
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
		String sql = "select username,password from user where username=? and password=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDo.getName());
			pstmt.setString(2, userDo.getPwd());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addCart(String username,String[] cart) {
		Connection conn = DbUtil.getConnection();
		String sql = "update user set cart = ? where username = ?";
		try {
			String carts = findCart(username);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			for(int i=1;i<=cart.length;i++) {
				pstmt.setString(i, carts+=","+cart[i-1]);
			}
			int flag = pstmt.executeUpdate();
//			System.out.println(flag);
			if(flag>=0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String findCart(String username) {
		Connection conn = DbUtil.getConnection();
		String sql = "select cart from user where username = "+username;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString("cart");
			}else {
				return "购物车为空";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return "查询异常";
		}
	}

}
