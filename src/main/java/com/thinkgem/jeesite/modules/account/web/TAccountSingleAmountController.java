/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.modules.account.entity.TAccountSingleAmount;
import com.thinkgem.jeesite.modules.account.service.TAccountSingleAmountService;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.trade.entity.VShanghuTrade;

/**
 * 预售票账务汇总Controller
 * @author 聂亚春
 * @version 2016-01-14
 */
@Controller
@RequestMapping(value = "${adminPath}/account/tAccountSingleAmount")
public class TAccountSingleAmountController extends BaseController {
	
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

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
	
	/**
	 * 广州预售账务汇总日报表
	 * @author nyc
	 * @date 2016年1月19日 下午1:40:19
	 * @param tAccountSingleAmount
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @since 0.1
	 * @see
	 */
	@RequiresPermissions("account:tAccountSingleAmount:view")
	@RequestMapping(value = {"getGzDay", ""})
	public String list(TAccountSingleAmount tAccountSingleAmount, HttpServletRequest request, HttpServletResponse response, Model model) {
		tAccountSingleAmount.setAmountType("1");
		tAccountSingleAmount.setShanghuCode("510000001");
		Page<TAccountSingleAmount> page = tAccountSingleAmountService.findPage(new Page<TAccountSingleAmount>(request, response), tAccountSingleAmount); 
		model.addAttribute("page", page);
		return "modules/account/tAccountSingleAmountGzList";
	}
	
	/**
	 * 广州预售账务汇总月报表
	 * @author nyc
	 * @date 2016年1月19日 下午1:40:43
	 * @param tAccountSingleAmount
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @since 0.1
	 * @see
	 */
	@RequiresPermissions("account:tAccountSingleAmount:view")
    @RequestMapping(value = {"getGzMonth", ""})
	public String Month(TAccountSingleAmount tAccountSingleAmount, HttpServletRequest request, HttpServletResponse response, Model model) {
		tAccountSingleAmount.setAmountType("2");
		tAccountSingleAmount.setShanghuCode("510000001");
		Page<TAccountSingleAmount> page = tAccountSingleAmountService.findPage(new Page<TAccountSingleAmount>(request, response), tAccountSingleAmount); 
		model.addAttribute("page", page);
		return "modules/account/tAccountSingleAmountGzMonthList";
	}
	
	/**
	 * 长沙预售账务汇总日报表
	 * @author nyc
	 * @date 2016年1月19日 下午1:40:57
	 * @param tAccountSingleAmount
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @since 0.1
	 * @see
	 */
	@RequiresPermissions("account:tAccountSingleAmount:view")
	@RequestMapping(value = {"getCsDay", ""})
	public String getCslist(TAccountSingleAmount tAccountSingleAmount, HttpServletRequest request, HttpServletResponse response, Model model) {
		tAccountSingleAmount.setAmountType("1");
		tAccountSingleAmount.setShanghuCode("410000001");
		Page<TAccountSingleAmount> page = tAccountSingleAmountService.findPage(new Page<TAccountSingleAmount>(request, response), tAccountSingleAmount); 
		model.addAttribute("page", page);
		return "modules/account/tAccountSingleAmountCsList";
	}
	/**
	 * 长沙预售账务汇总月报表
	 * @author nyc
	 * @date 2016年1月19日 下午1:41:09
	 * @param tAccountSingleAmount
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @since 0.1
	 * @see
	 */
	@RequiresPermissions("account:tAccountSingleAmount:view")
    @RequestMapping(value = {"getCsMonth", ""})
	public String getCsMonth(TAccountSingleAmount tAccountSingleAmount, HttpServletRequest request, HttpServletResponse response, Model model) {
		tAccountSingleAmount.setAmountType("2");
		tAccountSingleAmount.setShanghuCode("410000001");
		Page<TAccountSingleAmount> page = tAccountSingleAmountService.findPage(new Page<TAccountSingleAmount>(request, response), tAccountSingleAmount); 
		model.addAttribute("page", page);
		return "modules/account/tAccountSingleAmountCsMonthList";
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
	
	
	
	/**
	 * 导出闪客蜂预售票账务汇总
	 * @param user
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("account:tAccountSingleAmount:view")
    @RequestMapping(value = "export", method=RequestMethod.POST)
    public String exportFile(TAccountSingleAmount tAccountSingleAmount, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
            String fileName = "闪客蜂预售票账务汇总"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            String ShanghuCode=request.getParameter("ShanghuCode");
        	tAccountSingleAmount.setAmountType("1");
    		tAccountSingleAmount.setShanghuCode(ShanghuCode);
    		List<TAccountSingleAmount> page = tAccountSingleAmountService.findPage1(new Page<TAccountSingleAmount>(request, response,-1), tAccountSingleAmount); 
    		new ExportExcel("闪客蜂预售票账务汇总", TAccountSingleAmount.class).setDataList(page).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
			addMessage(redirectAttributes, "导出闪客蜂预售票账务汇总！失败信息："+e.getMessage());
		}
		return "redirect:" + adminPath +"/account/tAccountSingleAmountGzList?repage";
    }
	
	
	
	/**
	 * 导出闪客蜂预售票账务汇总日报表
	 * @author nyc
	 * @date 2016年1月20日 下午6:41:27
	 * @param tAccountSingleAmount
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return 
	 * @since 0.1
	 * @see
	 */
	@RequiresPermissions("account:tAccountSingleAmount:view")
    @RequestMapping(value = "exportDay", method=RequestMethod.POST)
    public String exportDay(TAccountSingleAmount tAccountSingleAmount, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			String day=request.getParameter("day");
			String shanghu=request.getParameter("ShanghuCode");
            String fileName = "闪客蜂预售票账务汇总"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
        	tAccountSingleAmount.setAmountType("1");
    		tAccountSingleAmount.setShanghuCode(shanghu);
    		  Date day1=sdf.parse(day);
    		tAccountSingleAmount.setTradeDate(day1);
    		List<TAccountSingleAmount> page = tAccountSingleAmountService.findPage1(new Page<TAccountSingleAmount>(request, response,-1), tAccountSingleAmount); 
    		new ExportExcel("闪客蜂预售票账务汇总", TAccountSingleAmount.class).setDataList(page).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
			addMessage(redirectAttributes, "导出闪客蜂预售票账务汇总！失败信息："+e.getMessage());
		}
		return "redirect:" + adminPath +"/account/tAccountSingleAmountGzMonthList?repage";
    }
	
	
	
	/**
	 * 导出月报表
	 * @author nyc
	 * @date 2016年1月20日 下午6:45:11
	 * @param tAccountSingleAmount
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return 
	 * @since 0.1
	 * @see
	 */
	@RequiresPermissions("account:tAccountSingleAmount:view")
    @RequestMapping(value = "exportMonth", method=RequestMethod.POST)
    public String exportMonth(TAccountSingleAmount tAccountSingleAmount, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			String ShanghuCode=request.getParameter("ShanghuCode");
            String fileName = "闪客蜂预售票账务汇总"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
        	tAccountSingleAmount.setAmountType("2");
    		tAccountSingleAmount.setShanghuCode(ShanghuCode);
    		Page<TAccountSingleAmount> page = tAccountSingleAmountService.findPage(new Page<TAccountSingleAmount>(request, response,-1), tAccountSingleAmount); 
    		new ExportExcel("闪客蜂预售票账务汇总", TAccountSingleAmount.class).setDataList(page.getList()).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
			addMessage(redirectAttributes, "导出闪客蜂预售票账务汇总！失败信息："+e.getMessage());
		}
		return "redirect:" + adminPath +"/account/tAccountSingleAmountGzMonthList?repage";
    }

}