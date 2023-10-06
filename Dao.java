package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class Dao {
	/**
	 * 登录方法
	 * @return
	 */
	public static boolean login(User user) {
		boolean flag=false;
		List<Map<String, Object>> list=null;
		try {
			list = SQLUtil.executeQuery("select * from user where user_name=? and password=? and role=?",user.getUserName(),user.getPassWord(),user.getRole());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (list.size()==1) {
			return true;
		}
		return false;
	}
	/**
	 * 更新密码方法
	 * @param userName
	 * @param password
	 * @return
	 */
	public static boolean updateStudent(String userName,String password) {
		boolean flag=false;
		try {
			int count =SQLUtil.executeUpdate("update user set password=? where user_name = ?",password,userName);
			if(count==1) {
				flag=true;
			}
		} catch (ClassNotFoundException e) {
			 
			e.printStackTrace();
		} catch (SQLException e) {
		 
			e.printStackTrace();
		}
		return flag;
	}



	/**
	 * 查询影片方法
	 * @return
	 */
	public static ArrayList<Movie> getMovieList(String id,String movieName,String directorName,String actRole){
		List<Map<String, Object>> list=null;
		ArrayList<Movie> arrayList = new ArrayList<Movie>();
		String sqlString = "select * from movie where 1=1";
		if(id!=null&&!id.isEmpty()) {
			sqlString +=" and id = "+id;
		}
		if(movieName!=null&&!movieName.isEmpty()) {
			sqlString +=" and movie_name = '"+movieName+"'";
		}
		if(directorName!=null&&!directorName.isEmpty()) {
			sqlString +=" and director_name = '"+directorName+"'";
		}
		if(actRole!=null&&!actRole.isEmpty()) {
			sqlString +=" and act_role = '"+actRole+"'";
		}
		try {
			list = SQLUtil.executeQuery(sqlString);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Map<String, Object> map : list) {
			Movie movie = new Movie();
			movie.setMovieName(map.get("movie_name").toString());
			movie.setId(map.get("id").toString());
			movie.setActRole(map.get("act_role").toString());
			movie.setTime(map.get("time").toString());
			movie.setDirectorName(map.get("director_name").toString());
			movie.setDetail(map.get("detail").toString());
			arrayList.add(movie);
		}
		return arrayList;
	}

	/**
	 * 添加影片
	 * @param movie
	 * @return
	 */
	public static boolean addMovie(Movie movie) {
		boolean flag=false;
		try {
			int count=SQLUtil.executeUpdate("insert into movie(movie_name,director_name,act_role,detail,time) values(?,?,?,?,?)",
					movie.getMovieName(),movie.getDirectorName(),movie.getActRole(),movie.getDetail(),movie.getTime());
			if (count==1) {
				flag=true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 影片删除方法
	 */
	public static boolean delMovie(String id) {
		boolean flag=false;
		try {
			int count=SQLUtil.executeUpdate("delete from movie where id=?", id);
			if(count==1) {
				flag=true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	/**
	 * 查询场次方法
	 * @return
	 */
	public static ArrayList<Arrangement> getArrangementList(String id){
		List<Map<String, Object>> list=null;
		ArrayList<Arrangement> arrayList = new ArrayList<Arrangement>();
		String sqlString = "select * from arrangement where 1=1";
		if(id!=null&&!id.isEmpty()) {
			sqlString +=" and id = "+id;
		}
		try {
			list = SQLUtil.executeQuery(sqlString);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Map<String, Object> map : list) {
			Arrangement arrangement = new Arrangement();
			arrangement.setId(map.get("id").toString());
			arrangement.setLocation(map.get("location").toString());
			arrangement.setMovieName(map.get("movie_name").toString());
			arrangement.setTime(map.get("time").toString());
			arrangement.setPrice(map.get("price").toString());
			arrayList.add(arrangement);
		}
		return arrayList;
	}
}

