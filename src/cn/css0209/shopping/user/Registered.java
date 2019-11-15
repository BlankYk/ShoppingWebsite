package cn.css0209.shopping.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.css0209.shopping.dao.JDBCDao;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * Servlet implementation class Registered
 */
@WebServlet("/Registered")
public class Registered extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JDBCDao jdbcDao;
	private Log log;
	public Registered() {
		super();
		log = LogFactory.get(getClass());
		jdbcDao = new JDBCDao();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/html;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		log.debug("创建用户：" + userName + "密码：" + password);
		try {
			if (jdbcDao.add(userName, password)) {
				out.print("<script>alert('注册成功！');</script>");
			} else {
				out.print("<script>alert('注册失败！');</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			response.setHeader("refresh", "0;url=/ShoppingWebsite/");
		}
	}
}
