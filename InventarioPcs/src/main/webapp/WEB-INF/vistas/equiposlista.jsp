<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

    


<div class="col text-end mt-3 mb-3">  
  <a class="btn btn-Azul_claro  btn-lg" href="equiposadmin?op=agregar">Añadir Equipo</a>
  
</div>



<table class="table table-hover table-bordered table-striped  mt-3 pb-3">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Modelo</th>
			<th>Procesador</th>
			<th>Ram</th>
			<th>Disco</th>
			<th>Capacidad Disco</th>
			<th>Aula</th>
			<th>Opciones</th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaequipos}" var="l">
			<tr>
				<th>${l.id}</th>
				<td>${l.nombre}</td>
				<td>${l.modelo}</td>
				<td>${l.procesador}</td>
				<td>${l.ram }  GB</td>
				<td>${l.disco}</td>
				<td>${l.capacidad_disco} GB</td>
				<td>${l.aula}</td>
			
				<td>
					
					<a class="btn btn-outline-Azul_claro btn-sm" href="equiposadmin?id=${l.id}&op=editar">Editar</a>
					<a class="btn btn-outline-danger btn-sm " href="equiposadmin?id=${l.id}&op=borrar">Borrar</a>
				
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		
	</tfoot>
</table>



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>