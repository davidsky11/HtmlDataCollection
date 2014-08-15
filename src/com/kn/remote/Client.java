package com.kn.remote;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 * Client 类 用于启动客户端  远程连接并访问 服务端
 * @author SoFlash - 博客园  http://www.cnblogs.com/longwu
 */
public class Client {
    /**
     * 客户端上主函数 用于连接 并访问服务端
     */
    public static void main(String[] args) {
        //定义一个端口号  该端口号必须与服务端的端口号相同 
        int port = 6666;
        //同样定义一个远程地址 该地址为服务端的远程地址 所以 与服务端的地址是一样的 
        String address = "rmi://localhost:" + port + "/RemoteQuery";

        try {
            //在RMI注册表上需找 对象为DataQueryInterface的地址 
            //即服务端地址  - 因为服务端上DataQueryImpl类 实现了该接口的所有方法
            DataQueryInterface dqInterface = (DataQueryInterface) Naming
                    .lookup(address);
            
            //一旦客户端找到该服务端地址 则 进行连接
            System.out.println("<<<客户端访问成功!");
            System.out.println("<<<开始查询服务端!");
            System.out.println("---------------------------");
            while (true) {
                System.out.println("清空服务端上的数据库-请按1");
                System.out.println("服务端收集英超比赛数据-请按2");
                System.out.println("查看英超所有球队-请按3");
                System.out.println("查看具体球队比赛结果-请按4");
                System.out.println("查看某一天的比赛-请按5");
                // Scanner 文本扫描器 用于读取 用户的输入
                Scanner sc = new Scanner(System.in);
                int intInput = sc.nextInt();
                if (intInput == 1) {
                    try{
                    dqInterface.initialDataBase();
                    System.out.println("服务端上数据清空完毕!");
                    }catch(Exception e){
                        System.out.println("清空数据失败!请检查!");
                        System.out.println(e.getMessage());
                    }
                    
                    System.out
                            .println("---------------------------------------------");
                } else if (intInput == 2) {
                    System.out.println("服务端开始收集英超比赛数据,请稍等....");
                    System.out.println("------------------------------------");
                    try{
                        dqInterface.dataCollectAndStore();
                        System.out.println("服务端上数据收集成功! 按3,4,5查看相关");
                        }catch(Exception e){
                            System.out.println("服务端收集数据失败!请检查!");
                            System.out.println(e.getMessage());
                        }
                    System.out
                            .println("---------------------------------------------");
                } else if (intInput == 3) {
                    // 获取 查询到的所有球队名称
                    Vector<String> vecAllTeams = dqInterface.getAllTeams();
                    if (vecAllTeams.size() != 0) {
                        System.out.println("参加过比赛的球队如下:");

                        System.out
                                .print("-----------------------------------------------\r\n");
                        System.out.println("球队(" + vecAllTeams.size() + "支): \n");
                        for (int i = 0; i < vecAllTeams.size(); i++) {
                            if (i % 7 == 0 && i != 0) {
                                System.out.println("\r\n");
                            }
                            System.out.print(vecAllTeams.get(i) + "\t");
                        }
                    } else
                        System.out.print("服务端上数据库目前没有数据,请按2收集数据!");
                    System.out
                    .print("\r\n-----------------------------------------------\r\n");

                } else if (intInput == 4) {
                    System.out.println("请输入你要查看的球队");
                    BufferedReader scLeague = new BufferedReader(new InputStreamReader(System.in, "UTF8"));
                    String strLeague = scLeague.readLine();
                    //strLeague = new String(strLeague.getBytes("iso8859-1"), "utf-8");
                    System.out.println(strLeague);
                    // 获取 具体球队的比赛结果
                    Vector<String> lsResult = dqInterface
                            .querySpecifiedTeam(strLeague);
                    if (lsResult.size() != 0) {
                        System.out.println("日期\t\t\t主队\t\t客队\t\t比分");
                        for (int i = 0; i < lsResult.size(); i++) {
                            if (i % 4 == 0 && i != 0)
                                System.out.println();
                            System.out.print(lsResult.get(i) + "\t\t");
                        }
                    } else
                        System.out.println("服务端上没有相关球队的记录或没有数据!");
                    System.out
                            .println("\r\n---------------------------------------------------");
                } else if (intInput == 5) {
                    System.out.println("请输入你要查看的比赛日期  例子格式[2014-05-11]");
                    Scanner scDate = new Scanner(System.in);
                    String strDate = scDate.next();
                    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    // 获取具体日期下的 所有比赛
                    List<String> lsResulOnDate = dqInterface
                            .queryByDate(java.sql.Date.valueOf(strDate));
                    if (lsResulOnDate.size() != 0) {
                        System.out.println("日期\t\t\t主队\t\t客队\t\t比分");
                        for (int i = 0; i < lsResulOnDate.size(); i++) {
                            if (i % 4 == 0 && i != 0)
                                System.out.println();
                            System.out.print(lsResulOnDate.get(i) + "\t\t");
                        }
                    } else
                        System.out.println("该天没有比赛 或 服务端数据库没有数据!");
                    System.out
                            .println("\r\n---------------------------------------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("远程链接出错,请检查!");
            e.printStackTrace();
        }
    }

}