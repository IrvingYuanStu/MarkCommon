package com.irving.mark.comm.config;

/**
 * 数据库配置
 * @author 毅成
 * @since 2017年7月22日 下午12:34:50
 * @version MARK 0.0.1
 */
public class DBconfig extends BaseConfig{

	private static final long serialVersionUID = 6044128461678569139L;
	
	private String driver;
	private String url;
	private String userName;
	private String password;
	private int num;
	private long lnum;
	
	public String getDriver() {
		return driver;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public long getLnum() {
		return lnum;
	}
	public void setLnum(long lnum) {
		this.lnum = lnum;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
