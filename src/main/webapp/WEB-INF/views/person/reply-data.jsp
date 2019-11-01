<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${replyVoList}" var="r">
    <div style="line-height: 30px;">
        <span class="petsp">${r.getReplyDate()}</span><br>
        <i class="pets" style="color: #333">回复内容:</i><br>
        <i class="pets" style="color: #333">${r.getReplyContent()}</i><br>
        <div class="inpost">
            <span class="insp">${r.getReplyFromComment()}</span>
        </div>
        <hr class="hrLine" style="width:100%;" />
    </div>
</c:forEach>
<%--加载分页标签--%>
<%@ include file="../comment/reply-page.jsp"%>