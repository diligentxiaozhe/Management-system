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
		System.out.println("���뵽�һ������get�ϣ�����");
		//1.���ñ����ʽ---������˼���ǰ��������Ӧ��ת��Ϊһ�������ʽ�� �����׳������룻
	    request.setCharacterEncoding("utf-8");  //�����е�����ת��Ϊutf-8
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=UTF-8");
	    //2.��������
		String dos=request.getParameter("do");
		String email=request.getParameter("email");
		System.out.println(dos+"\t"+email);
		//3.���ݴ��ݵĲ��������жϣ���ѯ���ݿ��е����룬�������һ�����
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
				//�����ж��ҵ�����֮�󣬷�������;
				if (password.equals("")) {
					response.getWriter().print("\"<script>alert('��������û���ҵ�������룡������');window.location='login.jsp';</script>\"");
				}
				else {
					Email email2=new Email();
					try {
						email2.sendEmail(email, password);
						response.getWriter().print("\"<script>alert('�𾴵��û�����ã���������Ѿ�ͨ���ʼ���������������ˣ���ע����գ�������');window.location='login.jsp';</script>\"");
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
			response.getWriter().print("\"<script>alert('�װ����û�����Ĳ��������һ����������������');window.location='login.jsp';</script>\"");
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
