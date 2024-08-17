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
 * Servlet implementation class LoginAddUserServlet
 */
@WebServlet("/LoginAddUserServlet")
public class LoginAddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("你的请求已经进入到后端的get方法上--------");
		//	1.设置编码格式---他的意思就是把请求和响应都转换为一个编码格式； 不容易出现乱码；
		    request.setCharacterEncoding("utf-8");  //把所有的请求都转化为utf-8
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=UTF-8");
		    
		    
	   //  2.接收你传过来的数据；
		    String dos=request.getParameter("do");
		    String name=request.getParameter("name");
		    String password=request.getParameter("password");
		    String rpassword=request.getParameter("rpassword");
		    //进行了数据的转换
		    int age=Integer.valueOf(request.getParameter("age"));
		    String email=request.getParameter("email");
		    
//		    打印了数据
		    System.out.println(dos);
		    System.out.println(name+"\t"+password+"\t"+rpassword+"\t"+age+"\t"+email);
		    
		    
//		   3.开始进行判断操作和进行入库操作
		    if (dos.equals("addlist")) { //判断你操作是添加用户的一个操作
		    	//这个就是我们的添加操作；
		    	if (password.equals(rpassword)) {  //两次输入的密码要一样
		    		
		    		try {
						Dbutils.makeUser("insert into user(name,age,password,email) values(?,?,?,?)", name,age,password,email);
						response.getWriter().print("\"<script>alert('亲爱的用户，你本次注册非常的成功！！！！');window.location='login.jsp';</script>\"");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						response.getWriter().print("\"<script>alert('亲爱的用户，你的本次注册失败！！！！');window.location='login.jsp';</script>\"");
						e.printStackTrace();
					}
		    		
					
				}else {
					response.getWriter().print("\"<script>alert('亲爱的用户，两次密码不一样！！！！');window.location='login.jsp';</script>\"");
				}
			}else {
				response.getWriter().print("\"<script>alert('亲爱的用户，你的操作不是添加操作！！！！');window.location='login.jsp';</script>\"");
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
