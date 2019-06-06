package cn.css0209.shopping.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.css0209.shopping.dao.JDBCDao;

/**
 * Servlet implementation class Registered
 */
@WebServlet("/Registered")
public class Registered extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JDBCDao jdbcDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registered() {
		super();
		jdbcDao = new JDBCDao();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/html;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(userName);
		System.out.println(password);
		try {
			if (jdbcDao.add(userName, password)) {
				out.print("<script>alert('注册成功！');</script>");
			}else {
				out.print("<script>alert('注册失败！');</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			response.setHeader("refresh", "1;url=/ShoppingWebsite/");
		}

	}

}
