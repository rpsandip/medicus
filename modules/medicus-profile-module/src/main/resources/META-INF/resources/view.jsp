<%@ include file="/init.jsp" %>

<c:choose>
	<c:when test="${isPartner }">
		<%@ include file="/edit_partner_profile.jsp" %>
	</c:when> 
	<c:otherwise>
		<%@ include file="/edit_school_user.jsp" %>
	</c:otherwise> 
</c:choose>    