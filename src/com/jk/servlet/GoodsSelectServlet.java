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

import com.jk.entity.Goods;
import com.jk.entity.User;
import com.jk.tools.Dbutils;

/**
 * Servlet implementation class GoodsSelectServlet
 */
@WebServlet("/GoodsSelectServlet")
public class GoodsSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式一致
				request.setCharacterEncoding("utf-8");  //把所有的请求都转化为utf-8
			    response.setCharacterEncoding("utf-8");
			    response.setContentType("text/html;charset=UTF-8");
			    
			    String dos=request.getParameter("do");
			    System.out.println(dos);
			    if(dos.equals("goods-list"))
			    {
			    	System.out.println("进行商品管理-查询商品信息-------");
			    	List<Goods> list=new ArrayList<Goods>();
			    	try {
						ResultSet resultSet=Dbutils.selectQuery("select *from goods", null);
						while(resultSet.next())
						{
							list.add(new Goods(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4),resultSet.getString(5)));
							
						}
					//4.把这个list放在到我们的一个共享域--是一共的区域
						HttpSession session=request.getSession();//得到一个session对象
						session.setAttribute("list", list);//把数据放入到了共享的域中
					//5.就需要把这个数据传递给你的页面	
						request.getRequestDispatcher("goods-list.jsp").forward(request, response);
						//请求到了这个servlet之后，进行数据的处理完毕之后，
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			    else {
			    	response.getWriter().print("\"<script>alert('商品管理失败！！！！');window.location='index.jsp';</script>\"");
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
