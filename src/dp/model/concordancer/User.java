package dp.model.concordancer;

import java.io.Serializable;

public class User implements Serializable {


	private static final long serialVersionUID = 2354064310193024575L;
	private  String username;
	private  String password;
	private  int user_id;
	private boolean isRegistered;


	public int getUser_id()
	{
		return user_id;
	}

	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;

	}

	public void setUsername(String user)
	{
		this.username=user;
	}

	public void setPassword(String pass)
	{
		this.password=pass;
	}

	public void setUserid(int id)
	{
		this.user_id=id;
	}

	public void setIsRegistered(boolean b)
	{
		this.isRegistered=b;
	}

	public boolean getIsRegistered()
	{
		return isRegistered;
	}
}
