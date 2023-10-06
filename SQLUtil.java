package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class SQLUtil {
	
	static String URL="jdbc:mysql://127.0.0.1:3306/film_db?useUnicode=true&charsetEncoding=UTF-8";
	static String userName="root";
	static String password="root";
	//更新方法
	public static int executeUpdate(String sql,Object ...objects) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(URL,userName,password);
		PreparedStatement ps = conn.prepareStatement(sql);
		for (int i = 0; i < objects.length; i++) {
			ps.setObject(i+1,objects[i]);
		}
		int count=ps.executeUpdate();
		ps.close();
		conn.close();
		return count;
	}
	
	//查询
	public static List<Map<String, Object>> executeQuery(String sql,Object ...objects) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(URL,userName,password);
		PreparedStatement ps = conn.prepareStatement(sql);
		for (int i = 0; i < objects.length; i++) {
			ps.setObject(i+1,objects[i]);
		}
		ResultSet rs=ps.executeQuery();
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();//创建一个返回用的list，对象为map的集合
		ResultSetMetaData rsmd=ps.getMetaData();//结果集参数
		List<String> keys=new ArrayList<String>();//储存数据库字段的集合
		for (int i = 0; i < rsmd.getColumnCount(); i++) {//循环getColumnCount（）数据库字段
			keys.add(rsmd.getColumnName(i+1));//根据位置 取数据库字段名称
		}
		while (rs.next()) {//迭代结果集
			Map<String, Object> map=new HashMap<String, Object>();
			for (String key : keys) {//循环数据库字段
				map.put(key,rs.getObject(key));
			}
			list.add(map);
		}
		rs.close();
		ps.close();
		conn.close();
		return list;
		
	}
}
