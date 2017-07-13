<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INICIO DE SESION</title>
        <link href="<c:url value="/css/menu.css"/>" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="login-form">
            <form method="post" action="login.htm">
                <h1>INICIAR SESION</h1>
                <div class="form-group ">
                    <input type="text" name="usuario" class="form-control" placeholder="Usuario " id="UserName">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group log-status">
                    <input type="password" name="clave" class="form-control" placeholder="Clave " id="Passwod">
                    <i class="fa fa-lock"></i>
                </div>
            <span class="alert">${error}</span>    
                <input type="submit" class="log-btn" value="Ingresar" ></input>
            </form>
            
        </div>
        <script src='<c:url value="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.0/jquery.min.js" />'></script>
        <script src='<c:url value="/js/jquery.js" />'></script>

    </body>
</html>