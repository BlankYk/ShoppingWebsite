package cn.css0209.shopping.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.css0209.shopping.dao.JDBCDao;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JDBCDao jdbcDao;
    private Log log;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        log = LogFactory.get(getClass());
        jdbcDao = new JDBCDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/html;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDo userDo = new UserDo();
		userDo.setName(username);
		userDo.setPwd(password);
		try {
			boolean flag = jdbcDao.login(userDo);
			if(flag) {
				
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				log.debug("用户 "+username+" 登陆成功");
				out.print("<script>window.location.assign('/ShoppingWebsite/');</script>");
			}else {
				log.debug("用户 "+username+" 登录失败，失败密码："+password);
				out.print("<script>alert('用户名或密码错误！');history.back();</script>");
			}
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("/ShoppingWebsite/");
		}
	}

}
