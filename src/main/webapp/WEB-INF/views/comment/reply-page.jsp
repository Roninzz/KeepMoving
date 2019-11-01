<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container" style="text-align: center;margin-top: 20px;">
    <ul class="pagination pagination-lg">
        <li><a href="javascript:goPage(1)">首页</a></li>

        <%-- 对边界值进行处理 --%>
        <c:if test="${replyPageInfo.pageNum > 1}">
            <li><a href="javascript:goPage(${replyPageInfo.pageNum-1})">&laquo;</a></li>
        </c:if>
        <c:if test="${replyPageInfo.pageNum <= 1}">
            <li class="disabled"><a>&laquo;</a></li>
        </c:if>

        <%-- 循环显示页码 --%>
        <c:forEach begin="1" end="${replyPageInfo.pages}" var="n">
            <li <c:if test="${replyPageInfo.pageNum == n}"> class="active" </c:if>><a href="javascript:goPage(${n})">${n}</a></li>
        </c:forEach>

        <%-- 对边界值进行处理--%>
        <c:if test="${replyPageInfo.pageNum < replyPageInfo.pages}">
            <li><a href="javascript:goPage(${replyPageInfo.pageNum+1})">&raquo;</a></li>
        </c:if>
        <c:if test="${replyPageInfo.pageNum >= replyPageInfo.pages}">
            <li class="disabled"><a>&raquo;</a></li>
        </c:if>

        <li><a href="javascript:goPage(${replyPageInfo.pages})">最后一页</a></li>
        <li><a href="javascript:void(0);">当前页${replyPageInfo.pageNum}/${replyPageInfo.pages}总页</a></li>
    </ul>
</div>

<script>
    // 获取下一页
    function goPage(pageNum){
        $("#reply-page").load("${path}/person/reply",{pageNum:pageNum});
    }
</script>

