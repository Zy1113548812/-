package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		while (true) {
			System.out.println("        影院管理系统");
			System.out.println("******************************");
			System.out.println("    1------管理员登录");
			System.out.println("    2------经理登录");
			System.out.println("    0------退出系统");
			System.out.println("******************************");
			Scanner scanner = new Scanner(System.in);
			switch (Integer.parseInt(scanner.nextLine())) {
			case 1:// 管理员登录
				System.out.println("         管理员登录");
				System.out.println("******************************");
				System.out.print("请输入管理员用户名：");
				String adminName = scanner.nextLine();
				System.out.print("请输入密码：");
				String adminPassword = scanner.nextLine();
				User user = new User(adminName,adminPassword,"1");
				if (Dao.login(user)) {// 登录验证
					System.out.println("******************************");
					System.out.println(adminName + "管理员登录成功！");
					System.out.println("******************************");
					boolean flag1 = true;
					while (flag1) {
						System.out.println("        影院管理系统");
						System.out.println("******************************");
						System.out.println("    1------密码管理");
						System.out.println("    2------客户管理");
						System.out.println("    3------退出登录");
						System.out.println("******************************");
						System.out.print("请输入功能数字:");
						switch (Integer.parseInt(scanner.nextLine())) {
						case 1:
							boolean adminFlag1 = true;
							while (adminFlag1) {
								System.out.println("        影院管理系统---密码管理");
								System.out.println("******************************");
								System.out.println("    1------修改密码");
								System.out.println("    2------重置指定用户密码");
								System.out.println("    3------返回");
								System.out.println("******************************");
								System.out.print("请输入功能数字:");
								switch (Integer.parseInt(scanner.nextLine())) {
								case 1:
									System.out.print("请输入旧密码：");
									String oldPassword = scanner.nextLine();
									if (!adminPassword.equals(oldPassword)) {
										System.out.println("******************************");
										System.out.println("旧密码错误，请重试！");
										System.out.println("******************************");
										break;
									}
									System.out.print("请输入新密码：");
									String newPassword = scanner.nextLine();
									System.out.print("请再次输入密码：");
									String againPassword = scanner.nextLine();
									if (!newPassword.equals(againPassword)) {
										System.out.println("******************************");
										System.out.println("两次输入的密码不一致，请重试！");
										System.out.println("******************************");
										break;
									}
									if (Dao.updateStudent("admin", againPassword)) {// 修改密码
										System.out.println("******************************");
										System.out.println("密码修改成功，请重新登录！");
										System.out.println("******************************");
										adminFlag1 = false;
										flag1 = false;
										break;
									} else {
										System.out.println("******************************");
										System.out.println("密码修改失败，请重试！");
										System.out.println("******************************");
									}
									break;
								case 2:
									System.out.print("请输入要重置密码的用户名：");
									String resetUserName = scanner.nextLine();
									if (Dao.updateStudent(resetUserName, "123456")) {// 重置密码
										System.out.println("******************************");
										System.out.println(resetUserName + "密码重置成功，重置密码为123456！");
										System.out.println("******************************");
									} else {
										System.out.println("******************************");
										System.out.println("没有找到用户名为" + resetUserName + "的用户，请重试！");
										System.out.println("******************************");
									}
									break;
								case 3:
									adminFlag1 = false;
									break;
								default:
									System.out.println("******************************");
									System.out.println("请输入正确的功能数字！");
									System.out.println("******************************");
									break;
								}
							}
							break;
						case 2:
							boolean adminFlag2 = true;
							while (adminFlag2) {
								System.out.println("        影院管理系统---客户管理");
								System.out.println("******************************");
								System.out.println("    1------列出所有客户信息");
								System.out.println("    2------删除客户");
								System.out.println("    3------查询客户信息");
								System.out.println("    4------返回");
								System.out.println("******************************");
								System.out.print("请输入功能数字:");
								switch (Integer.parseInt(scanner.nextLine())) {
								case 1:// 查询所有客户信息
									System.out.println("******************************");
									System.out.println("客户信息");
									System.out.println("******************************");
									break;
								case 2:
									System.out.print("请输入要删除的客户ID：");
									String deleteUserID = scanner.nextLine();
									break;
								case 3:
									System.out.println("        影院管理系统---客户查询");
									System.out.println("******************************");
									System.out.println("    1------根据客户ID查询");
									System.out.println("    2------根据用户名查询");
									System.out.println("    3------查询所有客户信息");
									System.out.println("******************************");
									System.out.print("请输入功能数字:");
									switch (Integer.parseInt(scanner.nextLine())) {
									case 1:
										System.out.print("请输入要查询的客户ID：");
										String selectUserID = scanner.nextLine();
										break;
									case 2:
										System.out.print("请输入要查询的用户名：");
										String selectUserName = scanner.nextLine();
										break;
									case 3:
										System.out.println("******************************");
										System.out.println("客户信息");
										System.out.println("******************************");
										break;
									default:
										System.out.println("******************************");
										System.out.println("请输入正确的功能数字！");
										System.out.println("******************************");
										break;
									}
									break;
								case 4:
									adminFlag2 = false;
									break;
								default:
									System.out.println("******************************");
									System.out.println("请输入正确的功能数字！");
									System.out.println("******************************");
									break;
								}
							}
							break;
						case 3:
							flag1 = false;
							break;
						default:
							System.out.println("******************************");
							System.out.println("请输入正确的功能数字！");
							System.out.println("******************************");
							break;
						}
					}

				} else {
					System.out.println("******************************");
					System.out.println("登录失败，账号或密码错误，请重试！");
					System.out.println("******************************");
				}
				break;
			case 2:// 经理登录
				System.out.println("         经理登录");
				System.out.println("******************************");
				System.out.print("请输入经理用户名：");
				String manageName = scanner.nextLine();
				System.out.print("请输入密码：");
				String managePassword = scanner.nextLine();
				User jinliUser = new User(manageName,managePassword,"2");
				if (Dao.login(jinliUser)) {// 登录验证
					System.out.println("******************************");
					System.out.println(manageName + "经理登录成功！");
					System.out.println("******************************");
					boolean flag1 = true;
					while (flag1) {
						System.out.println("        影院管理系统");
						System.out.println("******************************");
						System.out.println("    1------影片管理");
						System.out.println("    2------排片管理");
						System.out.println("    3------退出登录");
						System.out.println("******************************");
						System.out.print("请输入功能数字:");
						switch (Integer.parseInt(scanner.nextLine())) {
						case 1:
							boolean adminFlag1 = true;
							while (adminFlag1) {
								System.out.println("        影院管理系统---影片管理");
								System.out.println("******************************");
								System.out.println("    1------列出所有影片");
								System.out.println("    2------添加影片");
								System.out.println("    3------修改影片");
								System.out.println("    4------删除影片");
								System.out.println("    5------查询影片");
								System.out.println("    6------返回");
								System.out.println("******************************");
								System.out.print("请输入功能数字:");
								switch (Integer.parseInt(scanner.nextLine())) {
								case 1://查询所有影片
									System.out.println("******************************");
									System.out.println("影片信息");
									System.out.println("******************************");
									System.out.println("ID\t\t片名\t\t\t导演\t\t主演\t\t\t\t\t剧情简介\t\t\t\t影片时长");
									for (Movie movieItem:
											Dao.getMovieList(null,null,null,null)) {
										System.out.println(movieItem.getId() + "\t\t" + movieItem.getMovieName() +"\t\t"+movieItem.getDirectorName() +"\t\t" + movieItem.getActRole() + "\t\t\t\t" + movieItem.getDetail()+ "\t\t\t\t"
												+movieItem.getTime());
									}
									System.out.println("******************************");
									break;
								case 2:
									System.out.println("******************************");
									System.out.print("请输入影片片名：");
									String movieName = scanner.nextLine();
									System.out.print("请输入影片导演：");
									String movieDirector = scanner.nextLine();
									System.out.print("请输入影片主演：");
									String movieAct = scanner.nextLine();
									System.out.print("请输入影片剧情简介：");
									String movieDetail = scanner.nextLine();
									System.out.print("请输入影片时长：");
									String movieTime = scanner.nextLine();
									Movie addMovie = new Movie(movieName,movieDirector,movieAct,movieDetail,movieTime);
									if (Dao.addMovie(addMovie)) {// 添加影片
										System.out.println("******************************");
										System.out.println(movieName + "影片添加成功！");
										System.out.println("******************************");
									} else {
										System.out.println("******************************");
										System.out.println(movieName + "影片添加失败，请重试！");
										System.out.println("******************************");
									}
									break;
								case 3:
									System.out.println("******************************");
									System.out.print("请输入要修改的影片ID：");
									String movieID= scanner.nextLine();
									if (Dao.getMovieList(movieID,null,null,null).size()!=0) {//根据影片ID查询
										Movie editMovie = Dao.getMovieList(movieID,null,null,null).get(0);
										System.out.print("请输入修改后的影片片名：");
										String movieEditName = scanner.nextLine();
										System.out.print("请输入修改后的影片导演：");
										String movieEditDirector = scanner.nextLine();
										System.out.print("请输入修改后的影片主演：");
										String movieEditAct = scanner.nextLine();
										System.out.print("请输入修改后的影片剧情简介：");
										String movieEditDetail = scanner.nextLine();
										System.out.print("请输入修改后的影片时长：");
										String movieEditTime = scanner.nextLine();
										editMovie.setMovieName(movieEditName);
										editMovie.setDirectorName(movieEditDirector);
										editMovie.setActRole(movieEditAct);
										editMovie.setDetail(movieEditDetail);
										editMovie.setTime(movieEditTime);
									}else {
										System.out.println("******************************");
										System.out.println("没有找到影片ID为"+movieID+"的影片，请重试！");
										System.out.println("******************************");
									}
									break;
								case 4:
									System.out.print("请输入要删除的影片ID：");
									String deleteMovieID = scanner.nextLine();
									if (Dao.getMovieList(deleteMovieID,null,null,null).size()!=0) {// 查找该影片
										System.out.println("确认删除影片ID为"+deleteMovieID+"的影片？");
										System.out.println("******************************");
										System.out.println("    1------确认删除");
										System.out.println("    2------取消删除");
										System.out.println("******************************");
										switch (Integer.parseInt(scanner.nextLine())) {
											case 1:
												if (Dao.delMovie(deleteMovieID)) {//删除影片
													System.out.println("******************************");
													System.out.println(deleteMovieID + "删除成功！");
													System.out.println("******************************");
												}else {
													System.out.println("******************************");
													System.out.println(deleteMovieID + "删除失败，请重试！");
													System.out.println("******************************");
												}
												break;
											case 2:
												break;
											default:
												System.out.println("******************************");
												System.out.println("请输入正确的功能数字！");
												System.out.println("******************************");
												break;
										}
									} else {
										System.out.println("******************************");
										System.out.println("没有找到影片ID为" + deleteMovieID + "的影片，请重试！");
										System.out.println("******************************");
									}
									break;
								case 5:
									System.out.println("******************************");
									System.out.println("片名、导演、主演三条件查询，输入为空时，默认不进行该条件查询。");
									System.out.println("******************************");
									System.out.print("请输入查询的影片片名：");
									String movieSelectName = scanner.nextLine();
									System.out.print("请输入查询的影片导演：");
									String movieSelectDirector = scanner.nextLine();
									System.out.print("请输入查询的影片主演：");
									String movieSelectAct = scanner.nextLine();
									ArrayList<Movie> movies = Dao.getMovieList(null,movieSelectName,movieSelectDirector,movieSelectAct);
									if (movies.size()!=0) {//查询显示影片
										System.out.println("******************************");
										System.out.println("影片信息");
										System.out.println("******************************");
										System.out.println("ID\t\t片名\t\t\t导演\t\t主演\t\t\t\t\t剧情简介\t\t\t\t影片时长");
										for (Movie movieItem:
												movies) {
											System.out.println(movieItem.getId() + "\t\t" + movieItem.getMovieName() +"\t\t"+movieItem.getDirectorName() +"\t\t" + movieItem.getActRole() + "\t\t\t\t" + movieItem.getDetail()+ "\t\t\t\t"
													+movieItem.getTime());
										}
										System.out.println("******************************");
									}else {
										System.out.println("******************************");
										System.out.println("没有找到符合条件的影片，请重试！");
										System.out.println("******************************");
									}
									break;
								case 6:
									adminFlag1 = false;
									break;
									default:
										System.out.println("******************************");
										System.out.println("请输入正确的功能数字！");
										System.out.println("******************************");
										break;
								}

							}

							break;
						case 2:
							boolean adminFlag2 = true;
							while (adminFlag2) {
								System.out.println("        影院管理系统---排片管理");
								System.out.println("******************************");
								System.out.println("    1------增加场次");
								System.out.println("    2------修改场次");
								System.out.println("    3------删除场次");
								System.out.println("    4------列出所有场次信息");
								System.out.println("    5------返回");
								System.out.println("******************************");
								System.out.print("请输入功能数字:");
								switch (Integer.parseInt(scanner.nextLine())) {
								case 1:
									System.out.println("******************************");
									System.out.println("请输入要增加电影场次的ID");
									System.out.println("******************************");
									break;
								case 2:
									System.out.println("******************************");
									System.out.println("请输入要修改电影场次的ID");
									System.out.println("******************************");
									break;
								case 3:
									System.out.print("请输入要删除的场次ID：");
									String deleteSessionID = scanner.nextLine();
									break;
								case 4:// 查询所有场次信息
									System.out.println("******************************");
									System.out.println("场次信息");
									System.out.println("******************************");
									System.out.println("ID\t\t片名\t\t\t放映厅\t\t\t\t\t\t放映时间\t\t\t\t价格");
									for (Arrangement arrangementItem:
											Dao.getArrangementList(null)) {
										System.out.println(arrangementItem.getId() + "\t\t" + arrangementItem.getMovieName() +"\t\t"+arrangementItem.getLocation() +"\t\t\t\t\t\t" + arrangementItem.getTime()+ "\t\t\t\t"
												+arrangementItem.getPrice());
									}
									System.out.println("******************************");
									break;
								case 5:
									adminFlag2 = false;
									break;
								default:
									System.out.println("******************************");
									System.out.println("请输入正确的功能数字！");
									System.out.println("******************************");
									break;
								}
							}
							break;
						case 3:
							flag1 = false;
							break;
						default:
							System.out.println("******************************");
							System.out.println("请输入正确的功能数字！");
							System.out.println("******************************");
							break;
						}
					}

				} else {
					System.out.println("******************************");
					System.out.print("登录失败，账号或密码错误，请重试！");
					System.out.println("******************************");
				}
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("******************************");
				System.out.println("请输入正确的功能数字！");
				System.out.println("******************************");
				break;
			}
		}
	}
}
