/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/ourlife/dev">dev</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.ourlife.dev.modules.cms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ourlife.dev.common.persistence.BaseDao;
import com.ourlife.dev.common.persistence.BaseDaoImpl;
import com.ourlife.dev.modules.cms.entity.Link;

/**
 * 链接DAO接口
 * @author ourlife
 * @version 2013-01-15
 */
public interface LinkDao extends LinkDaoCustom, CrudRepository<Link, Long> {

	@Modifying
	@Query("update Link set delFlag=?2 where id = ?1")
	public int updateDelFlag(Long id, String status);
	
	public List<Link> findByIdIn(Long[] ids);
	
	@Modifying
	@Query("update Link set weight=0 where weight > 0 and weightDate < current_timestamp()")
	public int updateExpiredWeight();
}

/**
 * DAO自定义接口
 * @author ourlife
 */
interface LinkDaoCustom extends BaseDao<Link> {

}

/**
 * DAO自定义接口实现
 * @author ourlife
 */
@Repository
class LinkDaoImpl extends BaseDaoImpl<Link> implements LinkDaoCustom {

}
