package com.jk.tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



//�������Ҫ�����þ���������ǵ����ݿ�Ĳ����ķ�װ��
public class Dbutils {

//	1.����ȫ�ֵı����������±ߵ��κεķ����ж�����ã�
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
//	2.�������ݿ�����ԣ�
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/jkstu";
	private static String user="root";
	private static String password="123456";
	
	
	
//	3.�����������򣻣���Ϊ��������ִ��һ�Σ� д�ھ�̬�飻 ��̬������ ���췽��ִ�У�
	static {
		
		try {
			Class.forName(driver);
			System.out.println("�������سɹ���������");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("��������ʧ�ܣ�������");
			e.printStackTrace();
		}
		
	}
	
//	4.�������ݿ������
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
//	5.�ر���Դ
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
	
	
	
//	6.��װ���ǲ�ѯ�����������ص��������ݵģ�...������ǿɱ������ ����������Ĳ��������������仯�������Ǹ����飩
	
	public static ResultSet selectQuery(String sql,Object...objects) throws SQLException {
		
//		��Ҫ�����ݿ⽨������
		connection=getConnection();
//		����sql��䵽���mysql���ݿ��У�
		preparedStatement=connection.prepareStatement(sql);
		
		if (objects!=null) {//����Ĳ�����Ϊ��
			for (int i = 0; i < objects.length; i++) {
				System.out.println(objects[i]);
				preparedStatement.setObject(i+1, objects[i]);
			}
			
		}else {  //����Ĳ���Ϊ�յ�ʱ��
			preparedStatement=connection.prepareStatement(sql);
		}
		return preparedStatement.executeQuery();
	}
	
	
	
//	7. ����ӣ� ɾ���� �޸ģ� ���з�װ��
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
