package com.jk.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.lookup.ImplicitNullAnnotationVerifier;

import com.jk.entity.User;
import com.jk.tools.Dbutils;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入到修改操作中---");
		 //1.设置编码格式---他的意思就是把请求和响应都转换为一个编码格式； 不容易出现乱码；
	    request.setCharacterEncoding("utf-8");  //把所有的请求都转化为utf-8
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=UTF-8");
	    //2.接收数据
	    String dos=request.getParameter("do");
	    String id=request.getParameter("id");
	    //3.进行查询数据
	    if (dos.equals("getEdit")) 
	    {
			System.out.println("进行修改操作---");
			try {
				//根据id进行数据查询
				ResultSet resultSet=Dbutils.selectQuery("select *from user where id=?",id);
				User user=null;
				while (resultSet.next()) {
					user=new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getString(5));
					
				}
				HttpSession session=request.getSession();
				session.setAttribute("user", user);
				request.getRequestDispatcher("edit-user.jsp").forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    else {
	        int id01=Integer.valueOf(request.getParameter("id"));
			String name=request.getParameter("name");
			String age=request.getParameter("age");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			
			try {
				Dbutils.makeUser("update user set name=?,age=?,password=?,email=? where id=? ", name,age,password,email,id);
				response.getWriter().print("<script>alert('修改数据成功！');window.location='SelectServlet?do=user-list';</script>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				response.getWriter().print("<script>alert('修改数据失败！');window.location='SelectServlet?do=user-list';</script>");
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
