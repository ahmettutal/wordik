<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                            <h2>Seviye Düzenle</h2>
                            <div class="clearfix"></div>
                        </div>

                        <div class="x_content">

                            <br/>
                            <form:form method="POST" class="form-horizontal form-label-left"
                                       action="save" modelAttribute="level" enctype="multipart/form-data">

                                <form:hidden path="id"/>

                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Seviye İsmi</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <form:input path="name" class="form-control col-md-7 col-xs-12"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="defaultQuestionCount">Varsayılan Soru Sayısı</label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <form:input path="defaultQuestionCount" class="form-control col-md-7 col-xs-12"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Resim Yükle </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input id="files" type="file" name="files"/>
                                    </div>
                                </div>

                                <div class="ln_solid"></div>

                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                        <button class="btn btn-primary" type="button" onclick="history.go(-1);">İptal</button>
                                        <button type="submit" class="btn btn-success">Kaydet</button>
                                    </div>
                                </div>

                            </form:form>
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
