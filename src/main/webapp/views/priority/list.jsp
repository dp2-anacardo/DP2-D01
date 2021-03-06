<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<security:authorize access="hasRole('ADMIN')">
	<display:table name="priorities" id="row" requestURI="${requestURI}"
		pagesize="5" class="displaytag">

		<display:column>
			<a href="priority/administrator/show.do?priorityId=${row.id}"> <spring:message
					code="priority.show" /></a>
		</display:column>

		<spring:message code="priority.nameES" var="titleES" />
		<display:column title="${titleES}">
			<jstl:out value="${row.name['ES']}" />
		</display:column>

		<spring:message code="priority.nameEN" var="titleEN" />
		<display:column title="${titleEN}">
			<jstl:out value="${row.name['EN']}" />
		</display:column>

		<display:column>
			<a href="priority/administrator/edit.do?priorityId=${row.id}"> <spring:message
					code="priority.edit" />
			</a>
		</display:column>
	</display:table>
	<div>
		<acme:cancel url="priority/administrator/create.do" code="priority.create" />
		<acme:cancel url="/" code="priority.back" />
	</div>
</security:authorize>