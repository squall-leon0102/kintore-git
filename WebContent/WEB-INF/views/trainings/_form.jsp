<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>
<div id="training-wrapper">
<label for="training_date">日付</label><br />
<input type="date" name="training_date" value="<fmt:formatDate value='${training.training_date}' pattern='yyyy-MM-dd' />" />
<br /><br />

<label for="name">ユーザーネーム</label><br />
<c:out value="${sessionScope.login_user.name}" />
<br /><br />

<label for="title">タイトル</label><br />
<input type="text" name="title" value="${training.title}" />
<br /><br />

<label for="pushup">腕立て伏せ</label><br />
<input type="number" name="pushup" min="0" value="${training.pushup}" />
<br /><br />

<label for="kensui">懸垂</label><br />
<input type="number" name="kensui" min="0" value="${training.kensui}" />
<br /><br />

<label for="sideraise">サイドレイズ</label><br />
<input type="number" name="sideraise" min="0" value="${training.sideraise}" />
<br /><br />

<label for="abs">腹筋</label><br />
<input type="number" name="abs" min="0" value="${training.abs}" />
<br /><br />

<label for="squat">スクワット</label><br />
<input type="number" name="squat" min="0" value="${training.squat}" />
<br /><br />


<input type="hidden" name="_token" value="${_token}" />
<button type="submit" class="button-shadow">投稿</button>
</div>