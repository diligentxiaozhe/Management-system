package com.jk.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jk.tools.Dbutils;
import com.jk.tools.Email;

/**
 * Servlet implementation class PasswordFindServlet
 */
@WebServlet("/PasswordFindServlet")
public class PasswordFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordFindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入到找回密码的get上！！！");
		//1.设置编码格式---他的意思就是把请求和响应都转换为一个编码格式； 不容易出现乱码；
	    request.setCharacterEncoding("utf-8");  //把所有的请求都转化为utf-8
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=UTF-8");
	    //2.接收数据
		String dos=request.getParameter("do");
		String email=request.getParameter("email");
		System.out.println(dos+"\t"+email);
		//3.根据传递的参数进行判断，查询数据库中的密码，用邮箱找回密码
		if(dos.equals("email")) 
		{
			try {
				ResultSet resultSet=Dbutils.selectQuery("select password from user where email=?", email);
				String password="";
				while(resultSet.next())
				{
					System.out.println(resultSet.getString(1));
					password=resultSet.getString(1);
					break;
				}
				System.out.println(password);
				//继续判断找到密码之后，发送邮箱;
				if (password.equals("")) {
					response.getWriter().print("\"<script>alert('根据邮箱没有找到你的密码！！！！');window.location='login.jsp';</script>\"");
				}
				else {
					Email email2=new Email();
					try {
						email2.sendEmail(email, password);
						response.getWriter().print("\"<script>alert('尊敬的用户，你好，你的密码已经通过邮件发送至你的邮箱了，请注意查收！！！！');window.location='login.jsp';</script>\"");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else 
		{
			response.getWriter().print("\"<script>alert('亲爱的用户，你的操作不是找回密码操作！！！！');window.location='login.jsp';</script>\"");
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
