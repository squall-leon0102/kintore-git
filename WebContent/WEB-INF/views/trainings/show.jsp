<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
                <c:when test="${training != null}">
                    <h2>トレーニング　詳細ページ</h2>

                    <table>
                        <tbody>
                            <tr>
                                <th>ユーザーネーム</th>
                                <td><c:out value="${training.user.name}" /></td>
                            </tr>
                            <tr>
                                <th>日付</th>
                                <td><fmt:formatDate value="${training.training_date}" pattern="yyyy-MM-dd" /></td>
                            </tr>
                            <tr>
                                <th>グラフ</th>
                                <td>
                                <div style="width: 45%">
                                <canvas id="myDoughnutChart" width="600" height="600"></canvas>
                                <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
                                <script>
                                var ctx = document.getElementById("myDoughnutChart").getContext('2d');
                                var myDoughnutChart = new Chart(ctx, {
                                    type: 'doughnut',
                                    data: {
                                           labels: ["腕立て伏せ","懸垂","サイドレイズ","腹筋","スクワット"],
                                           datasets: [{
                                                data: ["${training.pushup}","${training.kensui}","${training.sideraise}","${training.abs}","${training.squat}"],
                                                backgroundColor: [
                                                'rgba(255, 99, 132, 0.7)',
                                                'rgba(54, 162, 235, 0.7)',
                                                'rgba(255, 206, 86, 0.7)',
                                                'rgba(108, 204, 129, 0.7)',
                                                'rgba(153, 102, 255, 0.7)'
                                            ],
                                        }]
                                    },

                                });</script>
                                </div>
                                </td>
                            </tr>
                            <tr>
                            <th>登録日時</th>
                            <td>
                                <fmt:formatDate value="${training.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>更新日時</th>
                            <td>
                                <fmt:formatDate value="${training.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                    </tbody>
                </table>

                <c:if test="${sessionScope.login_user.id == training.user.id}">
                    <p><a href="<c:url value="/trainings/edit?id=${training.id}" />">このトレーニングを編集する</a></p>
                </c:if>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/trainings/index" />">一覧に戻る</a></p>
    </c:param>
</c:import>
