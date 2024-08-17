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
		System.out.println("�������");
		 //1.���ñ����ʽ---������˼���ǰ��������Ӧ��ת��Ϊһ�������ʽ�� �����׳������룻
	    request.setCharacterEncoding("utf-8");  //�����е�����ת��Ϊutf-8
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=UTF-8");
	    //2.��������
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
				response.getWriter().print("<script>alert('����û����ݳɹ���');window.location='SelectServlet?do=user-list';</script>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				response.getWriter().print("<script>alert('����û�����ʧ�ܣ�');window.location='SelectServlet?do=user-list';</script>");
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
