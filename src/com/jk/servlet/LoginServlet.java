package com.jk.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jk.tools.Dbutils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("用户登录进入doget!!!");
		//1.设置编码格式
		request.setCharacterEncoding("utf-8");  //把所有的请求都转化为utf-8
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=UTF-8");
	    //2.接收数据
	    String dos=request.getParameter("do");
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");
	    System.out.println(dos+"\t"+username+"\t"+password);
	    //3.根据传递过来的数据进行在数据库中查询数据，有数据，就登陆成功，没有，就登陆失败。
	    if (dos.equals("loginValidate")) //进行登陆操作
	    {
			try {
				ResultSet resultSet=Dbutils.selectQuery("select *from user");
				int flag=0;
				while(resultSet.next())
				{
					if((resultSet.getString(2).equals(username)) && (resultSet.getString(4).equals(password)))
					{
						flag=1;
						break;
					}
					else {
						flag=0;
					}
				}
				System.out.println(flag);
				if(flag==1)
				{
					HttpSession session=request.getSession();
					session.setAttribute("username",username);
					
					response.getWriter().print("\"<script>alert('亲爱的用户，登陆成功！！！！');window.location='index.jsp';</script>\"");
				}
				else {
					response.getWriter().print("\"<script>alert('亲爱的用户，你输入的帐号或密码错误，请重新输入！！！！');window.location='login.jsp';</script>\"");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    else 
	    {
	    	response.getWriter().print("\"<script>alert('亲爱的用户，你的操作不是登录操作！！！！');window.location='login.jsp';</script>\"");
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
