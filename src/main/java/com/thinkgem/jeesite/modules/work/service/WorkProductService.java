/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.work.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.work.entity.WorkProduct;
import com.thinkgem.jeesite.modules.work.dao.WorkProductDao;

/**
 * 产品管理Service
 * @author 吴鹏飞
 * @version 2015-03-03
 */
@Service
@Transactional(readOnly = true)
public class WorkProductService extends CrudService<WorkProductDao, WorkProduct> {

	public WorkProduct get(String id) {
		return super.get(id);
	}
	
	public List<WorkProduct> findList(WorkProduct workProduct) {
		return super.findList(workProduct);
	}
	
	public Page<WorkProduct> findPage(Page<WorkProduct> page, WorkProduct workProduct) {
		return super.findPage(page, workProduct);
	}
	
	@Transactional(readOnly = false)
	public void save(WorkProduct workProduct) {
		super.save(workProduct);
	}
	
	@Transactional(readOnly = false)
	public void delete(WorkProduct workProduct) {
		super.delete(workProduct);
	}
	
}