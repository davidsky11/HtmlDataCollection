package com.kn.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

/**
 * 接口 DataQueryInterface 继承了 远程接口 Remote 用于远程访问
 * 
 * @author kevin
 * 
 *         Created At 2014-8-14 下午4:46:29
 */
public interface DataQueryInterface extends Remote {

	public void initialDataBase() throws RemoteException;

	public void dataCollectAndStore() throws RemoteException;

	public Vector<String> getAllTeams() throws RemoteException;

	public Vector<String> querySpecifiedTeam(String league)
			throws RemoteException;

	public List<String> queryByDate(String date) throws RemoteException;

}