package com.jk.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jk.tools.Dbutils;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("添加数据");
		 //1.设置编码格式---他的意思就是把请求和响应都转换为一个编码格式； 不容易出现乱码；
	    request.setCharacterEncoding("utf-8");  //把所有的请求都转化为utf-8
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=UTF-8");
	    //2.接收数据
	    String dos=request.getParameter("do");
	    if(dos.equals("add"))
	    {
	    	request.getRequestDispatcher("user-add.jsp").forward(request, response);
	    }
	    else {
	    	String name=request.getParameter("name");
			int age=Integer.valueOf(request.getParameter("age"));
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			

			try {
				Dbutils.makeUser("insert into user (name,age,password,email) values(?,?,?,?)", name,age,password,email);
				response.getWriter().print("<script>alert('添加用户数据成功！');window.location='SelectServlet?do=user-list';</script>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				response.getWriter().print("<script>alert('添加用户数据失败！');window.location='SelectServlet?do=user-list';</script>");
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
