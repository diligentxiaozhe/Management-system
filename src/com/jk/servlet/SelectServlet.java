package com.jk.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jk.entity.User;
import com.jk.tools.Dbutils;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession(false)!=null && request.getSession(false).getAttribute("username")!=null) {
			System.out.println("�Ѿ�������ҳ���û�����ģ��---doget����");
			//���ñ����ʽһ��
			request.setCharacterEncoding("utf-8");  //�����е�����ת��Ϊutf-8
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=UTF-8");
		    
		    String dos=request.getParameter("do");
		    System.out.println(dos);
		    if(dos.equals("user-list"))
		    {
		    	System.out.println("�����û�����-��ѯ�û���Ϣ-------");
		    	List<User> list=new ArrayList<User>();
		    	try {
					ResultSet resultSet=Dbutils.selectQuery("select *from user", null);
					while(resultSet.next())
					{
						list.add(new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getString(5)));
						
					}
				//4.�����list���ڵ����ǵ�һ��������--��һ��������
					HttpSession session=request.getSession();//�õ�һ��session����
					session.setAttribute("list", list);//�����ݷ��뵽�˹��������
				//5.����Ҫ��������ݴ��ݸ����ҳ��	
					request.getRequestDispatcher("user-list.jsp").forward(request, response);
					//���������servlet֮�󣬽������ݵĴ������֮��
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    else {
		    	response.getWriter().print("\"<script>alert('�û�����ʧ�ܣ�������');window.location='index.jsp';</script>\"");
			}
		}
		else {
			response.sendRedirect("/jkManager/login.jsp");
		}
		}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
	     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	 if(request.getSession(false)!=null && request.getSession(false).getAttribute("username")!=null)
	    	 {
	    		 // TODO Auto-generated method stub
			     doGet(request, response);
	    	 }
	    	 else {
				response.sendRedirect("/jkManager/login.jsp");
			}
			
		}	
		
		
		

}
