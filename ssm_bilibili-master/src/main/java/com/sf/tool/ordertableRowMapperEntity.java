package com.sf.tool;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sf.entity.OrdertableEntity;



//用户表
public class ordertableRowMapperEntity implements RowMapper<OrdertableEntity>{

	public OrdertableEntity mapRow(ResultSet arg0, int arg1) throws SQLException {
		OrdertableEntity ordertable = new OrdertableEntity();
		//user.setUseryinghangka(arg0.getString("useryinghangka"));
			  //grids.setGridsID(arg0.getString("gridsID"));
		ordertable.setOrderID(arg0.getString("orderID"));
		ordertable.setOrdergridsImg(arg0.getString("ordergridsImg"));
		ordertable.setOrderIgridsName(arg0.getString("orderIgridsName"));
		ordertable.setOrderStat(arg0.getString("orderStat"));
		ordertable.setOrderTime(arg0.getString("orderTime"));
		ordertable.setOrderuserName(arg0.getString("orderuserName"));
		ordertable.setOrderzongRMB(arg0.getString("orderzongRMB"));
		ordertable.setOrderAddr(arg0.getString("orderAddr"));
		return ordertable;
	}

	
	
}
