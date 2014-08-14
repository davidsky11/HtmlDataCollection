package com.kn.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * DataQuery 类 用于查询数据库里的信息 包含了不同的方法
 * 
 * @author kevin
 * 
 *         Created At 2014-8-14 下午4:34:30
 */
public class DataQuery {
	/**
	 * 用于清空数据库里比赛结果
	 */
	public void initialDataBase() {
		String initialSql = "delete from premiership";
		MySql ms = new MySql();
		try {
			// MySql类里 提供了一个 删除数据的 方法 executeUpdate()
			ms.datatoMySql(initialSql);
			System.out.println("数据库清空成功!");
		} catch (Exception e) {
			System.out.println("数据库清空失败!");
		}
	}

	/**
	 * 用于 获取当前数据库里一共有多少球队 方便后期查看自己喜欢的球队比赛成绩
	 * 
	 * @return 所有的参与过比赛的球队名
	 */
	public Vector<String> getAllTeams() {
		// 使用一个向量来 存取 从数据库中读到的值
		Vector<String> vecAllTeams = new Vector<String>();
		String allteamsSql = "select HomeTeam,AwayTeam from premiership group by HomeTeam;";
		ResultSet rs = null;
		MySql ms = new MySql();
		// 调用 MySql类里 查看数据的方法
		rs = ms.queryMySql(allteamsSql);
		try {
			// 如果 ResultSet数据集里的数据不为空 则获取相应的 数据 添加到 向量vecAllTeams里
			while (rs.next()) {
				if (!vecAllTeams.contains(rs.getString("HomeTeam")))
					vecAllTeams.add(rs.getString("HomeTeam"));
				else if (!vecAllTeams.contains(rs.getString("AwayTeam")))
					vecAllTeams.add(rs.getString("AwayTeam"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// 返回 取到的所有结果
		return vecAllTeams;

	}

	/**
	 * 查看具体的球队比赛结果
	 * 
	 * @param league
	 * @return 具体球队的所有比赛结果
	 */
	public Vector<String> querySpecifiedTeam(String league) {
		// 创建一个向量 来装载 从数据库中 读到的数据
		Vector<String> lsMatches = new Vector<String>();
		String specifiedTeamSql = "select * from premiership where HomeTeam ='"
				+ league + "' or AwayTeam ='" + league + "'";
		MySql ms = new MySql();
		ResultSet rs = null;
		rs = ms.queryMySql(specifiedTeamSql);
		try {
			while (rs.next()) {
				lsMatches.add(rs.getString("Date"));
				lsMatches.add(rs.getString("HomeTeam"));
				lsMatches.add(rs.getString("AwayTeam"));
				lsMatches.add(rs.getString("Result"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsMatches;

	}

	/**
	 * 查看 某一天的 比赛结果
	 * 
	 * @param date
	 * @return 某一天的所有比赛结果
	 */
	public List<String> queryByDate(String date) {
		// 使用一个 list泛型来装载 比赛结果
		List<String> lsMatchesOnDate = new ArrayList<String>();
		String sqlDate = "SELECT * FROM premiership WHERE Date ='" + date + "'";
		// 创建一个ResultSet数据集 用来 获取查询到的结果集
		ResultSet rs = null;
		MySql ms = new MySql();
		// 调用 MySql 类里的 查看数据库数据的方法
		rs = ms.queryMySql(sqlDate);
		try {
			// 如果 ResultSet数据集 不为空
			while (rs.next()) {
				// 则 从ResultSet数据集 中取出 相应的 字段值 添加到 list泛型里
				lsMatchesOnDate.add(rs.getString("Date"));
				lsMatchesOnDate.add(rs.getString("HomeTeam"));
				lsMatchesOnDate.add(rs.getString("AwayTeam"));
				lsMatchesOnDate.add(rs.getString("Result"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// 最后 返回 取到的所有比赛数据结果
		return lsMatchesOnDate;
	}
}
