/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.account.entity.TAccountSingleAmount;
import com.thinkgem.jeesite.modules.account.dao.TAccountSingleAmountDao;

/**
 * 预售票账务汇总Service
 * @author 聂亚春
 * @version 2016-01-14
 */
@Service
@Transactional(readOnly = true)
public class TAccountSingleAmountService extends CrudService<TAccountSingleAmountDao, TAccountSingleAmount> {

	public TAccountSingleAmount get(String id) {
		return super.get(id);
	}
	
	public List<TAccountSingleAmount> findList(TAccountSingleAmount tAccountSingleAmount) {
		return super.findList(tAccountSingleAmount);
	}
	
	public Page<TAccountSingleAmount> findPage(Page<TAccountSingleAmount> page, TAccountSingleAmount tAccountSingleAmount) {
		page.setOrderBy("trade_date desc");
		return super.findPage(page, tAccountSingleAmount);
	}
	
	@Transactional(readOnly = false)
	public void save(TAccountSingleAmount tAccountSingleAmount) {
		super.save(tAccountSingleAmount);
	}
	
	@Transactional(readOnly = false)
	public void delete(TAccountSingleAmount tAccountSingleAmount) {
		super.delete(tAccountSingleAmount);
	}
	
}