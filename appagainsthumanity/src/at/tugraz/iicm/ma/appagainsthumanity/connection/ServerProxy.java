package at.tugraz.iicm.ma.appagainsthumanity.connection;

import java.util.HashMap;

public abstract class ServerProxy {

	protected static ServerProxy instance = null;
	protected boolean isConnected = false;
	
	/**
	 * returns the singleton instance of the server proxy
	 * can't define static abstract function - yet each implementateion needs to provide it's instance 
	 */
	//public static abstract ServerProxy getInstance();
	
	/**
	 * Retrieve status of connection to game server
	 * @return
	 */
	public boolean isConnected() {
		if (!isConnected)
			checkConnection();
		return isConnected;
	}
	
	/**
	 * called by derivations to indicate established connection
	 */
	protected void setConnected() {
		this.isConnected = true;
	}

	/**
	 * called by derivations to indicate connection problems which occurred during communications
	 */
	protected void setDisconnected() {
		this.isConnected = false;
	}
	
	/*
	 * abstract methods implemented by concrete server-proxy instances to facilitate connections 
	 */
	
	public abstract boolean checkConnection();
	public abstract int signupUser(String username);
	public abstract int getUserId(String username);
	public abstract boolean createGame(String username, long[] invites, int roundcap, int scorecap);
	public abstract HashMap<String, String> checkUpdates(String username,
			HashMap<String, String> info);
	
	
}
