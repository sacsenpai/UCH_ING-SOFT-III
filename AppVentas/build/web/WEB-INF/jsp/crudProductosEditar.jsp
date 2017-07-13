<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
    </head>
    <body>


    <center><h1>${ accion } PRODUCTO</h1> </center>
        <input type="hidden" name="accion" value="${accion}"/>
        <div class="container">
            <form class="form-horizontal" method="post" action="crudProductoGrabar.htm">
                <div class="form-group">
                    <label for="idprod" class="col-sm-3 control-label">ID producto: </label>
                    <div class="col-sm-7">
                        <span class="form-control">${beanP.idprod}</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="idcat" class="col-sm-3 control-label">ID categoria: </label>
                    <div class="col-sm-7">
                        <input class="form-control" id="idcat" value="${beanP.idcat}" ${disabled}>
                    </div>
                </div>
                <div class="form-group">
                    <label for="nombre"class="col-sm-3 control-label">Nombre: </label>
                    <div class="col-sm-7">
                        <input class="form-control" id="nombre"value="${beanP.nombre}" ${disabled}>
                    </div>
                </div>
                <div class="form-group">
                    <label for="descripcion"class="col-sm-3 control-label">Descripcion: </label>
                    <div class="col-sm-7">
                        <input class="form-control" id="descripcion"value="${beanP.descripcion}" ${disabled}>
                    </div>
                </div>
                <div class="form-group">
                    <label for="precio"class="col-sm-3 control-label">Precio: </label>
                    <div class="col-sm-7">
                        <input class="form-control" id="precio"value="${beanP.precio}" ${disabled}>
                    </div>
                </div>                    
                <div class="form-group">
                    <label for="stock"class="col-sm-3 control-label">Stock: </label>
                    <div class="col-sm-7">
                        <input class="form-control" id="stock"value="${beanP.stock}" ${disabled}>
                    </div>
                </div>                    
                    <div class="form-group col-sm-offset-9 col-sm-3">
                        <input type="submit" class="btn btn-default" value="${ accion }">
                    </div>                 

            </form>
        </div>
 
        <script src='<c:url value="/js/jquery.min.js" />'></script>
        <script src='<c:url value="/js/bootstrap.min.js" />'></script>
    </body>
</html>
