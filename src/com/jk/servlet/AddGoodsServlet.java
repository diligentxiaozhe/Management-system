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
 * Servlet implementation class AddGoodsServlet
 */
@WebServlet("/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGoodsServlet() {
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
	    	request.getRequestDispatcher("goods-add.jsp").forward(request, response);
	    }
	    else {
	    	String name=request.getParameter("name");
			String type=request.getParameter("type");
			double price=Double.valueOf(request.getParameter("price"));
			String date=request.getParameter("date");
			

			try {
				Dbutils.makeUser("insert into goods (name,type,price,date) values(?,?,?,?)", name,type,price,date);
				response.getWriter().print("<script>alert('�����Ʒ���ݳɹ���');window.location='SelectServlet?do=user-list';</script>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				response.getWriter().print("<script>alert('�����Ʒ����ʧ�ܣ�');window.location='SelectServlet?do=user-list';</script>");
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
