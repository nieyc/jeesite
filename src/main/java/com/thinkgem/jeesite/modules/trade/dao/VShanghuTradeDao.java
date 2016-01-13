/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.trade.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.trade.entity.VShanghuTrade;

/**
 * 商户流水DAO接口
 * @author 聂亚春
 * @version 2016-01-12
 */
@MyBatisDao
public interface VShanghuTradeDao extends CrudDao<VShanghuTrade> {
	
	public int getCount();
	
}