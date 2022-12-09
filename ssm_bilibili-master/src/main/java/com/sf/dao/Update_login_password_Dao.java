package com.sf.dao;

public interface Update_login_password_Dao {
	
	/**
	 * 	根据用户名查询出用户密码 如果正确则再去修改密码
	 * @param userName
	 * @param passWord
	 * @param newpassWord
	 * @return
	 */
	public int Update_login_password(String userName,String passWord,String newpassWord);
	
	

	public int Update_Addred(String sessionName,String dizhi,String xingming,String phone);
	
	
	

	public int Update_login_Emial(String userName,String emial,String newemial);
	
	

	public int Update_login_Phone(String userName,String userPhone,String newuserPhone);
	
	

	public int Update_login_payPassword(String userName,String paypassword,String newpaypassword);
	
	

	public int Update_login_hand(String userName,String userHand);

	public int delectcartID (String cartID);

    int Update_BankCard(String sessionName, String useryinhangka, String useryinhangming, String kaihuhangdizhi, String huzhuxingming);

    int Updateyue(String sessionNmae, String userRMB);
}
