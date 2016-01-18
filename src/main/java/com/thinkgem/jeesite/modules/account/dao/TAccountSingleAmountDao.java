/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.account.entity.TAccountSingleAmount;

/**
 * 预售票账务汇总DAO接口
 * @author 聂亚春
 * @version 2016-01-14
 */
@MyBatisDao
public interface TAccountSingleAmountDao extends CrudDao<TAccountSingleAmount> {
	
}