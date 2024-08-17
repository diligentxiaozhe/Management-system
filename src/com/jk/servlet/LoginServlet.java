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
		System.out.println("�û���¼����doget!!!");
		//1.���ñ����ʽ
		request.setCharacterEncoding("utf-8");  //�����е�����ת��Ϊutf-8
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=UTF-8");
	    //2.��������
	    String dos=request.getParameter("do");
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");
	    System.out.println(dos+"\t"+username+"\t"+password);
	    //3.���ݴ��ݹ��������ݽ��������ݿ��в�ѯ���ݣ������ݣ��͵�½�ɹ���û�У��͵�½ʧ�ܡ�
	    if (dos.equals("loginValidate")) //���е�½����
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
					
					response.getWriter().print("\"<script>alert('�װ����û�����½�ɹ���������');window.location='index.jsp';</script>\"");
				}
				else {
					response.getWriter().print("\"<script>alert('�װ����û�����������ʺŻ�����������������룡������');window.location='login.jsp';</script>\"");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    else 
	    {
	    	response.getWriter().print("\"<script>alert('�װ����û�����Ĳ������ǵ�¼������������');window.location='login.jsp';</script>\"");
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
