package cn.css0209.shopping.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.css0209.shopping.dao.JDBCDao;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JDBCDao jdbcDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
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
		//接受json数据
		String json = request.getReader().readLine();
		JSONObject jsonObj = new JSONObject(json);
		JSONArray cart = jsonObj.getJSONArray("cart");
		String[] arr = new String[cart.size()];
		for(int i=0;i<arr.length;i++) {
			arr[i] = cart.getStr(i);
		}
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();
		
		//返回
		JSONObject result = new JSONObject();
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(jdbcDao.addCart(username, arr)) {
			result.put("result", "success");
			result.put("msg","已添加到购物车");
		}else {
			result.put("result","fail");
			result.put("msg", "添加到购物车失败");
		}
		out.print(result);
	}

}
