/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.work.web;

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
import com.thinkgem.jeesite.modules.work.entity.WorkProduct;
import com.thinkgem.jeesite.modules.work.service.WorkProductService;

/**
 * 产品管理Controller
 * @author 吴鹏飞
 * @version 2015-03-03
 */
@Controller
@RequestMapping(value = "${adminPath}/work/workProduct")
public class WorkProductController extends BaseController {

	@Autowired
	private WorkProductService workProductService;
	
	@ModelAttribute
	public WorkProduct get(@RequestParam(required=false) String id) {
		WorkProduct entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = workProductService.get(id);
		}
		if (entity == null){
			entity = new WorkProduct();
		}
		return entity;
	}
	
	@RequiresPermissions("work:workProduct:view")
	@RequestMapping(value = {"list", ""})
	public String list(WorkProduct workProduct, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WorkProduct> page = workProductService.findPage(new Page<WorkProduct>(request, response), workProduct); 
		model.addAttribute("page", page);
		return "modules/work/workProductList";
	}

	@RequiresPermissions("work:workProduct:view")
	@RequestMapping(value = "form")
	public String form(WorkProduct workProduct, Model model) {
		model.addAttribute("workProduct", workProduct);
		return "modules/work/workProductForm";
	}

	@RequiresPermissions("work:workProduct:edit")
	@RequestMapping(value = "save")
	public String save(WorkProduct workProduct, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, workProduct)){
			return form(workProduct, model);
		}
		workProductService.save(workProduct);
		addMessage(redirectAttributes, "保存产品列表成功");
		return "redirect:"+Global.getAdminPath()+"/work/workProduct/?repage";
	}
	
	@RequiresPermissions("work:workProduct:edit")
	@RequestMapping(value = "delete")
	public String delete(WorkProduct workProduct, RedirectAttributes redirectAttributes) {
		workProductService.delete(workProduct);
		addMessage(redirectAttributes, "删除产品列表成功");
		return "redirect:"+Global.getAdminPath()+"/work/workProduct/?repage";
	}

}