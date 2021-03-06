<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<security:authorize access="hasRole('BROTHERHOOD')">
<form:form action="enrolment/brotherhood/accept.do" modelAttribute="enrolment">
	<form:hidden path="id" />
	
	<jstl:if test="${lang=='en'}">
	<acme:select items="${positions}" itemLabel="roleEn" code="enrolment.positions" 
	path="position"/>
	</jstl:if>
	
	<jstl:if test="${lang=='es'}">
	<acme:select items="${positions}" itemLabel="roleEs" code="enrolment.positions" 
	path="position"/>
	</jstl:if>
	
	<input type="submit" name="accept"
		value="<spring:message code="enrolment.save" />" />&nbsp; 
	<input type="button" name="cancel"
		value="<spring:message code="enrolment.cancel" />"
		onclick="javascript: relativeRedir('enrolment/brotherhood/list.do');" />
	<br />
	
	
</form:form>
</security:authorize>