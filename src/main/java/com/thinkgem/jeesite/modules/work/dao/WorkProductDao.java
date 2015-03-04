/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.work.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.work.entity.WorkProduct;

/**
 * 产品管理DAO接口
 * @author 吴鹏飞
 * @version 2015-03-03
 */
@MyBatisDao
public interface WorkProductDao extends CrudDao<WorkProduct> {
	
}