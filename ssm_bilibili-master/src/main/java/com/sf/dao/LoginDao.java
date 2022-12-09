package com.sf.dao;


import com.sf.entity.OrdertableEntity;

public interface LoginDao {
			//验证登录
		public int login(String userName,String passWord);
		/**
		 *  查看支付密码是否正确
		 * @param userName
		 * @param pass
		 * @return
		 */
		public int paypassword(String userName,String pass);
		/**
		 * 如果支付密码正确. 则可以修改用户余额
		 * @param userName
		 * @param userRMB
		 * @return
		 */
		//修改余额
		public int updateRMB(String userRMB,String userName);
		/**
		 * 用户下单之后 将订单存储到数据库
		 * @param ordertable
		 * @return
		 */

		//下单
		public int ordertable(OrdertableEntity ordertable);
		/**
		 * 根据商品ID 确认收货
		 * @param orderID
		 * @return
		 */
		public int Confirmorder(String orderID);
		/**
		 * 根据商品ID 取消订单
		 * @param orderID
		 * @return
		 */
		public int Cancellationoforder(String orderID);
		/**
		 * 根据商品ID 删除订单
		 * @param orderID
		 * @return
		 */
		public int delordertable(String orderID);
		/**
		 * 根据商品ID 立即发货
		 * @param orderID
		 * @return
		 */
		public int Delivergoods(String OrderStat,String orderID);
}



