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
		
		System.out.println("��������Ѿ����뵽��˵�get������--------");
		//	1.���ñ����ʽ---������˼���ǰ��������Ӧ��ת��Ϊһ�������ʽ�� �����׳������룻
		    request.setCharacterEncoding("utf-8");  //�����е�����ת��Ϊutf-8
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=UTF-8");
		    
		    
	   //  2.�����㴫���������ݣ�
		    String dos=request.getParameter("do");
		    String name=request.getParameter("name");
		    String password=request.getParameter("password");
		    String rpassword=request.getParameter("rpassword");
		    //���������ݵ�ת��
		    int age=Integer.valueOf(request.getParameter("age"));
		    String email=request.getParameter("email");
		    
//		    ��ӡ������
		    System.out.println(dos);
		    System.out.println(name+"\t"+password+"\t"+rpassword+"\t"+age+"\t"+email);
		    
		    
//		   3.��ʼ�����жϲ����ͽ���������
		    if (dos.equals("addlist")) { //�ж������������û���һ������
		    	//����������ǵ���Ӳ�����
		    	if (password.equals(rpassword)) {  //�������������Ҫһ��
		    		
		    		try {
						Dbutils.makeUser("insert into user(name,age,password,email) values(?,?,?,?)", name,age,password,email);
						response.getWriter().print("\"<script>alert('�װ����û����㱾��ע��ǳ��ĳɹ���������');window.location='login.jsp';</script>\"");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						response.getWriter().print("\"<script>alert('�װ����û�����ı���ע��ʧ�ܣ�������');window.location='login.jsp';</script>\"");
						e.printStackTrace();
					}
		    		
					
				}else {
					response.getWriter().print("\"<script>alert('�װ����û����������벻һ����������');window.location='login.jsp';</script>\"");
				}
			}else {
				response.getWriter().print("\"<script>alert('�װ����û�����Ĳ���������Ӳ�����������');window.location='login.jsp';</script>\"");
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
