/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/ourlife/dev">dev</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.ourlife.dev.modules.cms.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ourlife.dev.common.persistence.BaseDao;
import com.ourlife.dev.common.persistence.BaseDaoImpl;
import com.ourlife.dev.modules.cms.entity.Site;

/**
 * 站点DAO接口
 * @author ourlife
 * @version 2013-01-15
 */
public interface SiteDao extends SiteDaoCustom, CrudRepository<Site, Long> {
	
	@Modifying
	@Query("update Site set delFlag=?2 where id = ?1")
	public int updateDelFlag(Long id, String delFlag);
}

/**
 * DAO自定义接口
 * @author ourlife
 */
interface SiteDaoCustom extends BaseDao<Site> {

}

/**
 * DAO自定义接口实现
 * @author ourlife
 */
@Repository
class SiteDaoImpl extends BaseDaoImpl<Site> implements SiteDaoCustom {

}
