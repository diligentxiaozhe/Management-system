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

import com.jk.entity.Goods;
import com.jk.tools.Dbutils;

/**
 * Servlet implementation class EditGoodsServlet
 */
@WebServlet("/EditGoodsServlet")
public class EditGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入到商品修改操作中---");
		 //1.设置编码格式---他的意思就是把请求和响应都转换为一个编码格式； 不容易出现乱码；
	    request.setCharacterEncoding("utf-8");  //把所有的请求都转化为utf-8
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=UTF-8");
	    //2.接收数据
	    String dos=request.getParameter("do");
	    int id=Integer.valueOf(request.getParameter("id"));
	    System.out.println(id);
	    //3.进行查询数据
	    if (dos.equals("getEdit")) 
	    {
			System.out.println("进行修改操作---");
			try {
				//根据num进行数据查询
				ResultSet resultSet=Dbutils.selectQuery("select *from goods where num=?",id);
				Goods goods=null;
				while (resultSet.next()) {
					goods=new Goods(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4),resultSet.getString(5));
					
				}
				HttpSession session=request.getSession();
				session.setAttribute("goods", goods);
				request.getRequestDispatcher("edit-goods.jsp").forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    else {
	        int num=Integer.valueOf(request.getParameter("id"));
			String name=request.getParameter("name");
			String type=request.getParameter("type");
			double price=Double.valueOf(request.getParameter("price"));
			String date=request.getParameter("date");
			System.out.println(num+"\t"+name+"\t"+type+"\t"+price+"\t"+date);
			
			try {
				Dbutils.makeUser("update goods set name=?,type=?,price=?,date=? where num=? ", name,type,price,date,id);
				response.getWriter().print("<script>alert('修改商品数据成功！');window.location='GoodsSelectServlet?do=goods-list';</script>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				response.getWriter().print("<script>alert('修改商品数据失败！');window.location='GoodsSelectServlet?do=goods-list';</script>");
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
