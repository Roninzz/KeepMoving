<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="comment" items="${commentVoList}">
    <div style="line-height: 30px;">
        <span class="petsp">${comment.getDate()}</span><br>
        <i class="pets" style="color: #333">评论内容:</i><br>
        <i class="pets" style="color: #333">${comment.getContent()}</i><br>
        <div class="inpost">
            <span class="insp">${comment.getPlanName()}</span>
        </div>
        <hr class="hrLine" style="width:100%;" />
    </div>
</c:forEach>
<%--分页标签--%>
<%@include file="../comment/comment-page.jsp"%>
