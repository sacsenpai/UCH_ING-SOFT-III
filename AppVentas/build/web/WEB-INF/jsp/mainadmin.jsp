<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title></title>
        <link rel="stylesheet" type="text/css" href='<c:url value="/css/bootstrap.min.css" />'>

    </head>
    <body>
        <h1>BIENVENIDO ${bean.nombre}</h1>
        <div class="container" >
            <ul class="nav nav-tabs">

                <li class="active"><a data-toggle="tab" href="#productos">crud productos</a></li>

            </ul>

            <div class="tab-pane fade in active" id="productos">
                <h2>
                    PRODUCTOS
                </h2>
                <div class="form-group row">
                    <form id="formproducto" class="form-inline" >
                        <div class="form-group col-sm-5">	
                            <label for="categoria" >Categoria:</label>
                            <select class="form-control" name="codigo">
                                <c:forEach items="${categoria}" var="c">
                                    <option value="${c.idcat}">${c.nombre}</option>
                                </c:forEach>
                            </select>	

                            <input class="form-control" placeholder="NOMBRE" name="nombre" value="${nombre}" id="categoriaproducto">
                            <input type="button" id="btnBuscarProd"  name="btnBuscarProd" value="Buscar" class="btn btn-default">
                            <input type="button" id="btnNuevoProd" name="btnNuevoProd" value="Nuevo" class="btn btn-default">

                        </div>
                    </form>

                </div>
                <div id="divResultadoProducto" class="row container">

                </div>

            </div>

            <script type="text/javascript" src='<c:url value="/js/jquery.min.js" />'></script>
            <script type="text/javascript" src='<c:url value="/js/bootstrap.min.js" />'></script>
            <script>

                $("#categoriaproducto").keyup(fnBuscarProducto);
                $("#btnBuscarProd").click(fnBuscarProducto);
                function fnBuscarProducto() {

                    var data = $("#formproducto").serialize();

                    $("#divResultadoProducto").load("crudProductoConsultar.htm", data)
                }
                $("#btnNuevoProd").click(function () {
                    window.location = "crudProductoNuevo.htm";
                });
            </script>

    </body>
</html>