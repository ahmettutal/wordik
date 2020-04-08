<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<jsp:include page="includes/head.jsp"/>

<body class="nav-md">
<div class="container body">
    <div class="main_container">

        <jsp:include page="includes/header.jsp"/>

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="row">

                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">

                        <div class="x_title">
                            <h2>Seviyeler</h2>
                            <div class="clearfix"></div>
                        </div>

                        <div class="x_content">

                            <a href="levels/new" class="btn btn-app"><i class="fa fa-plus-square"></i>Yeni Seviye</a>

                            <div class="table-responsive">
                                <table class="table table-striped jambo_table">
                                    <thead>
                                    <tr class="headings">
                                        <th class="column-title" width="88"></th>
                                        <th class="column-title" width="66"></th>
                                        <th class="column-title">Resim</th>
                                        <th class="column-title">İsim</th>
                                        <th class="column-title">Varsayılan Soru Sayısı</th>
                                    </tr>
                                    </thead>

                                    <tbody>

                                    <c:forEach var="level" items="${levels}">

                                        <tr class="even pointer">
                                            <td><a href="levels/${level.id}"><i class="fa fa-edit"></i> Düzenle</a></td>
                                            <td><a href="levels/delete/${level.id}"><i class="fa fa-remove"></i> Sil</a></td>
                                            <td>
                                                <c:if test="${level.picture != null}">
                                                    <img src="../../levelImages/${level.id}/${level.picture.name}" height="75">
                                                </c:if>
                                            </td>
                                            <td><c:out value="${level.name}"/></td>
                                            <td><c:out value="${level.defaultQuestionCount}"/></td>
                                        </tr>

                                    </c:forEach>

                                    </tbody>

                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->

        <jsp:include page="includes/footer.jsp"/>

    </div>
</div>

</body>
</html>
