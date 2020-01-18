<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>筋トレ管理</title>
        <link rel="styleSheet" href="<c:url value='/css/reset.css' />">
        <link rel="StyleSheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>筋トレ管理</h1>
            </div>
                <div id="content">
                    ${param.content}
            </div>
                <div id="footer">
                    by nozomu.
            </div>
        </div>
    </body>
</html>