/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.trade.dao;

import java.util.List;

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
	
	/**
	 * 
	 * @author nyc
	 * @date 2016年1月13日 上午10:08:06
	 * @return 
	 * @since 0.1
	 * @see
	 */
	public int getCount();
	
	/**
	 * 根据手机号码查询总数，测试用
	 * @author nyc
	 * @date 2016年1月13日 下午3:34:17
	 * @param vShanghuTrade
	 * @return 
	 * @since 0.1
	 * @see
	 */
	public int getCountByMobile(VShanghuTrade vShanghuTrade);
	
	public List<VShanghuTrade> getVShanghuTradeList(VShanghuTrade vShanghuTrade);
	
}