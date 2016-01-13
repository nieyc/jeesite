/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.trade.web;

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
import com.thinkgem.jeesite.modules.trade.entity.VShanghuTrade;
import com.thinkgem.jeesite.modules.trade.service.VShanghuTradeService;

/**
 * 商户流水Controller
 * @author 聂亚春
 * @version 2016-01-12
 */
@Controller
@RequestMapping(value = "${adminPath}/trade/vShanghuTrade")
public class VShanghuTradeController extends BaseController {

	@Autowired
	private VShanghuTradeService vShanghuTradeService;
	
	@ModelAttribute
	public VShanghuTrade get(@RequestParam(required=false) String id) {
		VShanghuTrade entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = vShanghuTradeService.get(id);
		}
		if (entity == null){
			entity = new VShanghuTrade();
		}
		return entity;
	}
	
	@RequiresPermissions("trade:vShanghuTrade:view")
	@RequestMapping(value = {"list", ""})
	public String list(VShanghuTrade vShanghuTrade, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<VShanghuTrade> page = vShanghuTradeService.findPage(new Page<VShanghuTrade>(request, response), vShanghuTrade); 
		model.addAttribute("page", page);
		System.out.println("============>"+vShanghuTrade);
		request.setAttribute("vShanghuTrade", vShanghuTrade);
		return "modules/trade/vShanghuTradeList";
	}

	@RequiresPermissions("trade:vShanghuTrade:view")
	@RequestMapping(value = "form")
	public String form(VShanghuTrade vShanghuTrade, Model model) {
		model.addAttribute("vShanghuTrade", vShanghuTrade);
		return "modules/trade/vShanghuTradeForm";
	}

	@RequiresPermissions("trade:vShanghuTrade:edit")
	@RequestMapping(value = "save")
	public String save(VShanghuTrade vShanghuTrade, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, vShanghuTrade)){
			return form(vShanghuTrade, model);
		}
		vShanghuTradeService.save(vShanghuTrade);
		addMessage(redirectAttributes, "保存商户流水成功");
		return "redirect:"+Global.getAdminPath()+"/trade/vShanghuTrade/?repage";
	}
	
	@RequiresPermissions("trade:vShanghuTrade:edit")
	@RequestMapping(value = "delete")
	public String delete(VShanghuTrade vShanghuTrade, RedirectAttributes redirectAttributes) {
		vShanghuTradeService.delete(vShanghuTrade);
		addMessage(redirectAttributes, "删除商户流水成功");
		return "redirect:"+Global.getAdminPath()+"/trade/vShanghuTrade/?repage";
	}

}