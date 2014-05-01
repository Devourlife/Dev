/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/ourlife/dev">dev</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.ourlife.dev.modules.sys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ourlife.dev.common.persistence.BaseDao;
import com.ourlife.dev.common.persistence.BaseDaoImpl;
import com.ourlife.dev.modules.sys.entity.Area;

/**
 * 区域DAO接口
 * @author ourlife
 * @version 2013-01-15
 */
public interface AreaDao extends AreaDaoCustom, CrudRepository<Area, Long> {

	@Modifying
	@Query("update Area set delFlag='" + Area.DEL_FLAG_DELETE + "' where id = ?1 or parentIds like ?2")
	public int deleteById(Long id, String likeParentIds);
	
	public List<Area> findByParentIdsLike(String parentIds);

	@Query("from Area where delFlag='" + Area.DEL_FLAG_NORMAL + "' order by code")
	public List<Area> findAllList();
	
	@Query("from Area where (id=?1 or parent.id=?1 or parentIds like ?2) and delFlag='" + Area.DEL_FLAG_NORMAL + "' order by code")
	public List<Area> findAllChild(Long parentId, String likeParentIds);
	
}

/**
 * DAO自定义接口
 * @author ourlife
 */
interface AreaDaoCustom extends BaseDao<Area> {

}

/**
 * DAO自定义接口实现
 * @author ourlife
 */
@Repository
class AreaDaoImpl extends BaseDaoImpl<Area> implements AreaDaoCustom {

}