/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.trade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.trade.entity.VShanghuTrade;
import com.thinkgem.jeesite.modules.trade.dao.VShanghuTradeDao;

/**
 * 商户流水Service
 * @author 聂亚春
 * @version 2016-01-12
 */
@Service
@Transactional(readOnly = true)
public class VShanghuTradeService extends CrudService<VShanghuTradeDao, VShanghuTrade> {
	
	
	@Autowired
	private VShanghuTradeDao vShanghuTradeDao;

	public VShanghuTrade get(String id) {
		return super.get(id);
	}
	
	public List<VShanghuTrade> findList(VShanghuTrade vShanghuTrade) {
		return super.findList(vShanghuTrade);
	}
	
	public Page<VShanghuTrade> findPage(Page<VShanghuTrade> page, VShanghuTrade vShanghuTrade) {
		return super.findPage(page, vShanghuTrade);
	}
	
	@Transactional(readOnly = false)
	public void save(VShanghuTrade vShanghuTrade) {
		super.save(vShanghuTrade);
	}
	
	@Transactional(readOnly = false)
	public void delete(VShanghuTrade vShanghuTrade) {
		super.delete(vShanghuTrade);
	}
	public int getCount(){
		return vShanghuTradeDao.getCount();
	}
	
	public int getCountByMobile(VShanghuTrade vShanghuTrade){
		return vShanghuTradeDao.getCountByMobile(vShanghuTrade);
	}
	
}