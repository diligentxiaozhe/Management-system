package com.jk.tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



//这个类主要的作用就是完成我们的数据库的操作的封装：
public class Dbutils {

//	1.定义全局的变量；（在下边的任何的方法中都会调用）
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
//	2.链接数据库的属性：
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/jkstu";
	private static String user="root";
	private static String password="123456";
	
	
	
//	3.加载驱动程序；（因为驱动程序执行一次； 写在静态块； 静态块优先 构造方法执行）
	static {
		
		try {
			Class.forName(driver);
			System.out.println("驱动加载成功！！！！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("驱动加载失败！！！！");
			e.printStackTrace();
		}
		
	}
	
//	4.进行数据库的链接
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
//	5.关闭资源
	public static void closeAll() throws SQLException {
		
		if (connection!=null) {
			connection.close();
		}
		if (preparedStatement!=null) {
			preparedStatement.close();
		}
		
		if (resultSet!=null) {
			resultSet.close();
		}
		
	}
	
	
	
//	6.封装我们查询方法：（返回的是有数据的）...带表的是可变参数； 他可以让你的参数随着你的需求变化（本质是个数组）
	
	public static ResultSet selectQuery(String sql,Object...objects) throws SQLException {
		
//		先要和数据库建立链接
		connection=getConnection();
//		发送sql语句到你的mysql数据库中；
		preparedStatement=connection.prepareStatement(sql);
		
		if (objects!=null) {//传入的参数不为空
			for (int i = 0; i < objects.length; i++) {
				System.out.println(objects[i]);
				preparedStatement.setObject(i+1, objects[i]);
			}
			
		}else {  //传入的参数为空的时候
			preparedStatement=connection.prepareStatement(sql);
		}
		return preparedStatement.executeQuery();
	}
	
	
	
//	7. 把添加； 删除； 修改； 进行封装；
	public static int makeUser(String sql, Object...objects) throws SQLException {
		connection=getConnection();
		preparedStatement=connection.prepareStatement(sql);
		if (objects!=null) {
			for (int i = 0; i < objects.length; i++) {
				preparedStatement.setObject(i+1, objects[i]);
			}
			
		}else {
			preparedStatement=connection.prepareStatement(sql);
		}
		return preparedStatement.executeUpdate();
	}
}
