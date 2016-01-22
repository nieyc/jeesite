/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.trade.web;

import java.text.ParseException;
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

	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
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
	/*    int i=	vShanghuTradeService.getCount();
	    System.out.println("i ===fsfsf=====>"+i);
	    VShanghuTrade vShanghuTrade1=new VShanghuTrade();
	    vShanghuTrade1.setUserMobile("13341830268");
	    int j=	vShanghuTradeService.getCountByMobile(vShanghuTrade1);
	    System.out.println("j========>"+j);*/
		return "modules/trade/vShanghuTradeList";
	}
	
	/**
	 * 广州地铁交易明细查询
	 * @author nyc
	 * @date 2016年1月19日 上午10:47:44
	 * @param vShanghuTrade
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @since 0.1
	 * @see
	 */
	@RequiresPermissions("trade:vShanghuTrade:view")
	@RequestMapping(value = {"gzlist", ""})
	public String gzlist(VShanghuTrade vShanghuTrade, HttpServletRequest request, HttpServletResponse response, Model model) {
		vShanghuTrade.setShanghu("01");
		
		Page<VShanghuTrade> page = vShanghuTradeService.findPage(new Page<VShanghuTrade>(request, response), vShanghuTrade); 
		model.addAttribute("page", page);
		request.setAttribute("vShanghuTrade", vShanghuTrade);
		return "modules/trade/vShanghuTradeGzList";
	}
	
	/**
	 * 长沙地铁交易明细
	 * @author nyc
	 * @date 2016年1月19日 上午10:50:53
	 * @param vShanghuTrade
	 * @param request
	 * @param response
	 * @param model
	 * @return 
	 * @since 0.1
	 * @see
	 */
	@RequiresPermissions("trade:vShanghuTrade:view")
	@RequestMapping(value = {"cslist", ""})
	public String cslist(VShanghuTrade vShanghuTrade, HttpServletRequest request, HttpServletResponse response, Model model) {
		vShanghuTrade.setShanghu("00");
		Page<VShanghuTrade> page = vShanghuTradeService.findPage(new Page<VShanghuTrade>(request, response), vShanghuTrade); 
		model.addAttribute("page", page);
		request.setAttribute("vShanghuTrade", vShanghuTrade);
		return "modules/trade/vShanghuTradeCsList";
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
	
	
	/**
	 * 导出广州日详细信息
	 * @author nyc
	 * @date 2016年1月20日 下午5:57:09
	 * @param vShanghuTrade
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return 
	 * @since 0.1
	 * @see
	 */
	@RequiresPermissions("trade:vShanghuTrade:view")
    @RequestMapping(value = "exportGzDay", method=RequestMethod.POST)
    public String exportGzDay(VShanghuTrade vShanghuTrade, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			String day=request.getParameter("day");
			String shanghu=request.getParameter("shanghu");
            String fileName = "闪客蜂业务明细查询"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            vShanghuTrade.setShanghu(shanghu);
            Date day1=sdf.parse(day);
            vShanghuTrade.setCreateTime(day1);
            List<VShanghuTrade> page = vShanghuTradeService.findPage1(new Page<VShanghuTrade>(request, response,-1), vShanghuTrade); 
    		new ExportExcel("闪客蜂业务明细查询", VShanghuTrade.class).setDataList(page).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
			addMessage(redirectAttributes, "导出闪客蜂业务明细查询汇总！失败信息："+e.getMessage());
		}
		return "redirect:" + adminPath +"/account/tAccountSingleAmountGzList?repage";
    }
	
	
	/**
	 * 长沙
	 * @author nyc
	 * @date 2016年1月20日 下午5:57:48
	 * @param vShanghuTrade
	 * @param request
	 * @param response
	 * @param redirectAttributes
	 * @return 
	 * @since 0.1
	 * @see
	 */
	@RequiresPermissions("trade:vShanghuTrade:view")
    @RequestMapping(value = "exportCsDay", method=RequestMethod.POST)
    public String exportCsDay(VShanghuTrade vShanghuTrade, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			String day=request.getParameter("day");
            String fileName = "闪客蜂业务明细查询"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            vShanghuTrade.setShanghu("00");
            Date day1=sdf.parse(day);
            vShanghuTrade.setCreateTime(day1);
            List<VShanghuTrade> page = vShanghuTradeService.findPage1(new Page<VShanghuTrade>(request, response,-1), vShanghuTrade); 
    		new ExportExcel("闪客蜂业务明细查询", VShanghuTrade.class).setDataList(page).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
			addMessage(redirectAttributes, "导出闪客蜂业务明细查询汇总！失败信息："+e.getMessage());
		}
		return "redirect:" + adminPath +"/account/tAccountSingleAmountGzList?repage";
    }
	
	
	
	
	
	@RequiresPermissions("trade:vShanghuTrade:view")
    @RequestMapping(value = "exportDeail", method=RequestMethod.POST)
    public String exportDeail(VShanghuTrade vShanghuTrade, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			String shanghu=request.getParameter("shanghu");
			String beginCreateTime=request.getParameter("beginCreateTime");
			String endCreateTime=request.getParameter("endCreateTime");
			String dealType=request.getParameter("dealType");
			String realName=request.getParameter("realName");
			String userMobile=request.getParameter("userMobile");
			String extOrderNo=request.getParameter("extOrderNo");
            String fileName = "闪客蜂业务明细查询"+DateUtils.getDate("yyyyMMddHHmmss")+".xlsx";
            vShanghuTrade.setShanghu(shanghu);
            if(StringUtils.isNotEmpty(beginCreateTime)){
            	  Date biginDay=sdf.parse(beginCreateTime);
            	  vShanghuTrade.setBeginCreateTime(biginDay);
            }
            if(StringUtils.isNotEmpty(endCreateTime)){
          	  Date endDay=sdf.parse(endCreateTime);
          	  vShanghuTrade.setEndCreateTime(endDay);
             }
            vShanghuTrade.setDealType(dealType);
            vShanghuTrade.setRealName(realName);
            vShanghuTrade.setUserMobile(userMobile);
            vShanghuTrade.setExtOrderNo(extOrderNo);
         
            List<VShanghuTrade> page = vShanghuTradeService.findPage1(new Page<VShanghuTrade>(request, response,-1), vShanghuTrade); 
    		new ExportExcel("闪客蜂业务明细查询", VShanghuTrade.class).setDataList(page).write(response, fileName).dispose();
    		return null;
		} catch (Exception e) {
			e.printStackTrace();
			addMessage(redirectAttributes, "导出闪客蜂业务明细查询汇总！失败信息："+e.getMessage());
		}
		return "redirect:" + adminPath +"/trade/vShanghuTrade/vShanghuTradeGzList?repage";
    }
	
	

}