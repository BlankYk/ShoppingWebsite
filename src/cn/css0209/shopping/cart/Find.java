package cn.css0209.shopping.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.css0209.shopping.dao.JDBCDao;
import cn.hutool.json.JSONObject;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * Servlet implementation class Find
 */
@WebServlet("/Find")
public class Find extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JDBCDao jdbcDao;
	private Log log;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Find() {
		super();
		jdbcDao = new JDBCDao();
		log = LogFactory.get(getClass());
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		try {
			String username = session.getAttribute("username").toString();
			String carts = jdbcDao.findCart(username);
			log.debug(carts);

			response.setContentType("application/text;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(carts);
		} catch (NullPointerException e) {
			log.debug("没有登录");
			return;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
