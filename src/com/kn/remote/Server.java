package com.kn.remote;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.kn.query.DataQueryImpl;

/**
 * Server 类 用于启动服务端
 * 
 * @author kevin
 * 
 *         Created At 2014-8-14 下午4:38:36
 */
public class Server {
	/**
	 * 服务端上主函数 用于启动服务端
	 */
	public static void main(String[] args) {

		try {
			// 定义远程接口DataQueryInterface对象 用于绑定在服务端上 该接口由 DataQueryImpl()类实现
			DataQueryInterface dqi = new DataQueryImpl();
			int port = 6666; // 定义一个端口号
			// 创建一个接受对特定端口调用的远程对象注册表 注册表上需要接口一个指定的端口号
			LocateRegistry.createRegistry(port);
			// 定义 服务端远程地址 URL格式
			String address = "rmi://localhost:" + port + "/RemoteQuery";
			// 绑定远程地址和接口对象
			Naming.bind(address, dqi);
			// 如果启动成功 则弹出如下信息
			System.out.println(">>>服务端启动成功");
			System.out.println(">>>请启动客户端进行连接访问");
		} catch (MalformedURLException e) {
			System.out.println("地址出现错误!");
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			System.out.println("重复绑定了同一个远程对象!");
			e.printStackTrace();
		} catch (RemoteException e) {
			System.out.println("创建远程对象出现错误!");
			e.printStackTrace();
		}

	}
}