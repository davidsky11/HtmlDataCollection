package com.kn.query;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 * Main 主函数 用于数据的输出
 * 
 * @author kevin
 * 
 *         Created At 2014-8-14 下午4:35:44
 */
public class Main {
	public static void main(String[] args) {
		DataCollectionAndStorage dcs = new DataCollectionAndStorage();
		DataQuery dQuery = new DataQuery();

		while (true) {
			System.out.println("清空数据库-请按1");
			System.out.println("收集英超比赛数据-请按2");
			System.out.println("查看英超所有球队-请按3");
			System.out.println("查看具体球队比赛结果-请按4");
			System.out.println("查看某一天的比赛-请按5");
			// Scanner 文本扫描器 用于读取 用户的输入
			Scanner sc = new Scanner(System.in);
			int intInput = sc.nextInt();
			if (intInput == 1) {
				dQuery.initialDataBase();
				System.out
						.println("---------------------------------------------");
			} else if (intInput == 2) {
				dcs.dataCollectAndStore();
				System.out
						.println("---------------------------------------------");
			} else if (intInput == 3) {
				// 获取 查询到的所有球队名称
				Vector<String> vecAllTeams = dQuery.getAllTeams();
				if (vecAllTeams.size() != 0) {
					System.out.println("参加过比赛的球队如下:");
					System.out
							.print("-----------------------------------------------");
					System.out
							.print("-----------------------------------------------\r\n");
					for (int i = 0; i < vecAllTeams.size(); i++) {
						if (i % 7 == 0 && i != 0) {
							System.out.println("\r\n");
						}
						System.out.print(vecAllTeams.get(i) + "\t");
					}
				} else
					System.out.print("数据库目前没有数据,请按2收集数据!");
				System.out
						.print("\r\n---------------------------------------------");
				System.out
						.println("-----------------------------------------------\r\n");
			} else if (intInput == 4) {
				System.out.println("请输入你要查看的球队");
				Scanner scLeague = new Scanner(System.in);
				String strLeague = scLeague.next();
				// 获取 具体球队的比赛结果
				Vector<String> lsResult = dQuery.querySpecifiedTeam(strLeague);
				if (lsResult.size() != 0) {
					System.out.println("日期\t\t\t主队\t\t客队\t\t比分");
					for (int i = 0; i < lsResult.size(); i++) {
						if (i % 4 == 0 && i != 0)
							System.out.println();
						System.out.print(lsResult.get(i) + "\t\t");
					}
				} else
					System.out.println("没有相关球队的记录或数据库没有数据!");
				System.out
						.println("\r\n---------------------------------------------------");
			} else if (intInput == 5) {
				System.out.println("请输入你要查看的比赛日期  例子格式[14.01.2012]");
				Scanner scDate = new Scanner(System.in);
				String strDate = scDate.next();
				// 获取具体日期下的 所有比赛
				List<String> lsResulOnDate = dQuery.queryByDate(strDate);
				if (lsResulOnDate.size() != 0) {
					System.out.println("日期\t\t\t主队\t\t客队\t\t比分");
					for (int i = 0; i < lsResulOnDate.size(); i++) {
						if (i % 4 == 0 && i != 0)
							System.out.println();
						System.out.print(lsResulOnDate.get(i) + "\t\t");
					}
				} else
					System.out.println("该天没有比赛 或 数据库没有数据!");
				System.out
						.println("\r\n---------------------------------------------------");
			}
		}

	}
}
