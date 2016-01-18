/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.account.entity.TAccountSingleAmount;
import com.thinkgem.jeesite.modules.account.service.TAccountSingleAmountService;

/**
 * 预售票账务汇总Controller
 * @author 聂亚春
 * @version 2016-01-14
 */
@Controller
@RequestMapping(value = "${adminPath}/account/tAccountSingleAmount")
public class TAccountSingleAmountController extends BaseController {

	@Autowired
	private TAccountSingleAmountService tAccountSingleAmountService;
	
	@ModelAttribute
	public TAccountSingleAmount get(@RequestParam(required=false) String id) {
		TAccountSingleAmount entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tAccountSingleAmountService.get(id);
		}
		if (entity == null){
			entity = new TAccountSingleAmount();
		}
		return entity;
	}
	
	@RequiresPermissions("account:tAccountSingleAmount:view")
	@RequestMapping(value = {"getDay", ""})
	public String list(TAccountSingleAmount tAccountSingleAmount, HttpServletRequest request, HttpServletResponse response, Model model) {
		tAccountSingleAmount.setAmountType("1");
		Page<TAccountSingleAmount> page = tAccountSingleAmountService.findPage(new Page<TAccountSingleAmount>(request, response), tAccountSingleAmount); 
		model.addAttribute("page", page);
		return "modules/account/tAccountSingleAmountList";
	}
	
	
	@RequiresPermissions("account:tAccountSingleAmount:view")
    @RequestMapping(value = {"getMonth", ""})
	public String Month(TAccountSingleAmount tAccountSingleAmount, HttpServletRequest request, HttpServletResponse response, Model model) {
		tAccountSingleAmount.setAmountType("2");
		Page<TAccountSingleAmount> page = tAccountSingleAmountService.findPage(new Page<TAccountSingleAmount>(request, response), tAccountSingleAmount); 
		model.addAttribute("page", page);
		return "modules/account/tAccountSingleAmountMonthList";
	}


	@RequiresPermissions("account:tAccountSingleAmount:view")
	@RequestMapping(value = "form")
	public String form(TAccountSingleAmount tAccountSingleAmount, Model model) {
		model.addAttribute("tAccountSingleAmount", tAccountSingleAmount);
		return "modules/account/tAccountSingleAmountForm";
	}

	@RequiresPermissions("account:tAccountSingleAmount:edit")
	@RequestMapping(value = "save")
	public String save(TAccountSingleAmount tAccountSingleAmount, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tAccountSingleAmount)){
			return form(tAccountSingleAmount, model);
		}
		tAccountSingleAmountService.save(tAccountSingleAmount);
		addMessage(redirectAttributes, "保存预售票账务汇总成功");
		return "redirect:"+Global.getAdminPath()+"/account/tAccountSingleAmount/?repage";
	}
	
	@RequiresPermissions("account:tAccountSingleAmount:edit")
	@RequestMapping(value = "delete")
	public String delete(TAccountSingleAmount tAccountSingleAmount, RedirectAttributes redirectAttributes) {
		tAccountSingleAmountService.delete(tAccountSingleAmount);
		addMessage(redirectAttributes, "删除预售票账务汇总成功");
		return "redirect:"+Global.getAdminPath()+"/account/tAccountSingleAmount/?repage";
	}

}