<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="col text-end mt-3 mb-3">  
  <a class="btn btn-Azul_claro btn-lg" href="incidenciainsertar?op=agregar">Añadir Incidencia</a>
</div>


<table class="table table-hover table-bordered table-striped mt-3">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre Equipo</th>
			<th>Descripcion</th>
			<th>Aula</th>
			<th>Inicio</th>
			<th>Fin</th>
			<th>Reportado Por</th>
			<th>Estado</th>
			<th>Resuelto Por</th>
			<th>Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaincidencias}" var="l">
			<tr>
				<th>${l.id}</th>
				<td>${l.nombre_equipo}</td>
				<td>${l.descripcion}</td>
				<td>${l.aula}</td>
				<td>${l.inicio }</td>
				<td>${l.fin}</td>
				<td>${l.reportado_por}</td>
				<td>${l.estado}</td>
				<td>${l.resuelto_por}</td>
			
				<td>
					<a class="btn btn-outline-Azul_claro btn-sm" href="incidenciaadmin?id=${l.id}&op=editar">Editar</a>
					<a class="btn btn-outline-danger btn-sm" href="incidenciaadmin?id=${l.id}&op=borrar">Borrar</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		
	</tfoot>
</table>



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>