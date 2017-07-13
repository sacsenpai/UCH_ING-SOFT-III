<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<h2>RESULTADO</h2>

<div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>accion</th>
				<th>categoria</th>
				<th>nombre</th>
				<th>precio</th>
				<th>stock</th>
				<th>estado</th>
				<th>descripcion</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaP}" var="r">
			<tr>
				<td>
                                    <a href="crudProductosEditar.htm?idprod=${r.idprod}" class="btn btn-default btn-sm"><span  class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                    <a href="crudProductosEliminar.htm?idprod=${r.idprod}"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
				</td>
				<td>${r.categoria}</td>
				<td>${r.nombre}</td>
				<td>${r.precio}</td>
				<td>${r.stock}</td>
				<td>${r.estado}</td>
				<td>${r.descripcion}</td>
			</tr>
			</c:forEach>
                <p></p>
		</tbody>
	</table>
    
</div>
