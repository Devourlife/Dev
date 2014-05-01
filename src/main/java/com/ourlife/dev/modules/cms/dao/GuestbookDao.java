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
import com.ourlife.dev.modules.cms.entity.Guestbook;

/**
 * 留言DAO接口
 * @author ourlife
 * @version 2013-01-15
 */
public interface GuestbookDao extends GuestbookDaoCustom, CrudRepository<Guestbook, Long> {

	@Modifying
	@Query("update Guestbook set delFlag=?2 where id = ?1")
	public int updateDelFlag(Long id, String status);
	
}

/**
 * DAO自定义接口
 * @author ourlife
 */
interface GuestbookDaoCustom extends BaseDao<Guestbook> {

}

/**
 * DAO自定义接口实现
 * @author ourlife
 */
@Repository
class GuestbookDaoImpl extends BaseDaoImpl<Guestbook> implements GuestbookDaoCustom {

}
