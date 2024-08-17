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
 * Servlet implementation class DeleteGoodsServlet
 */
@WebServlet("/DeleteGoodsServlet")
public class DeleteGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("���뵽ɾ��������---");
        //1.���ñ����ʽ---������˼���ǰ��������Ӧ��ת��Ϊһ�������ʽ�� �����׳������룻
	    request.setCharacterEncoding("utf-8");  //�����е�����ת��Ϊutf-8
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=UTF-8");
	    //2.����ǰ�˴�����������
		String dos=request.getParameter("do");
		int id=Integer.valueOf(request.getParameter("id"));
		//3.�����ж�
		if(dos.equals("del"))
		{
			System.out.println("������Ʒɾ������");
			try {
				Dbutils.makeUser("delete from goods where num=?", id);
				response.getWriter().print("<script>alert('ɾ����Ʒ���ݳɹ���');window.location='GoodsSelectServlet?do=goods-list';</script>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				response.getWriter().print("<script>alert('ɾ����Ʒ����ʧ�ܣ�');window.location='SelectServlet?do=user-list';</script>");
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
