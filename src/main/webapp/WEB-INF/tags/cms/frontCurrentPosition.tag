<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<%@ attribute name="category" type="com.ourlife.dev.modules.cms.entity.Category" required="true" description="栏目对象"%>
<li><strong>当前位置：</strong><a href="${ctx}/index-${site.id}${urlSuffix}">首页</a></li><c:forEach items="${fnc:getCategoryListByIds(category.parentIds)}" var="category">
	<c:if test="${category.id ne 1}"><li><span class="divider">/</span> <a href="${ctx}/list-${category.id}${urlSuffix}">${category.name}</a></li></c:if>
</c:forEach><li><span class="divider">/</span> <a href="${ctx}/list-${category.id}${urlSuffix}">${category.name}</a></li>