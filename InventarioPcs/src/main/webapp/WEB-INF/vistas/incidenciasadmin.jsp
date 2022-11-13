<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<c:if test="${op == 'borrar'}">
		
		<div class="alert alert-danger alert-dismissible fade show mt-3" role="alert" >
  <strong>Cuidado; </strong>Esta en el formulario de borrar incidencias.
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

	</c:if>


<form action="incidenciaadmin" method="post" class="row g-3 needs-validation mt-5" novalidate>

	<input type="hidden" name="op" value="${op}" />
	
	<div class="col-md-3 ">
		<label for="id" class="form-label">Id</label>
		<input type="number" class="form-control" readonly  id="id" name="id"
				value="${incidencia.id}">
  	</div>
  		
  	<div class="col-md-9 ps-4 ">
    <label for="nombre_equipo" class="form-label">Nombre Equipo</label>
    
    <c:choose>
		<c:when test="${op != 'borrar'}">
		<select class="form-select" id="nombre_equipo" name="nombre_equipo" >
    		<option selected  value="${incidencia.nombre_equipo}">${incidencia.nombre_equipo}</option>
      		<c:forEach items="${listanombresequipos}" var="l">
      		<option value="${l.nombre}">${l.nombre}</option>
			</c:forEach>
	 	</select>
		</c:when>
		<c:when test="${op == 'borrar'}">
		
		
		<input type="text" class="form-control" id="nombre_equipo" name="nombre_equipo"value="${incidencia.nombre_equipo}" readonly>
		
		</c:when>
			</c:choose>
    
    
    <div class="invalid-feedback">
      Por favor, seleccione el nombre del equipo
    </div>
</div>
  
  
	
<div class="col-md-12  mt-3">
    <label for="descripcion" class="form-label">Descripcion</label>
    <input type="text" class="form-control" id="descripcion" name="descripcion" value="${incidencia.descripcion}" <c:choose>
				<c:when test="${op != 'borrar'}">required</c:when>
				<c:when test="${op == 'borrar'}">readonly</c:when>
			</c:choose>>
      <div class="invalid-feedback">
        Proporcione una descripcion de la incidencia.
      </div>
    </div>

	<div class="col-md-4  mt-3">
		<label for="aula" class="col-sm-2 col-form-label">Aula</label>
		<c:choose>
				<c:when test="${op != 'borrar'}">
				<select class="form-select" id="aula" name="aula" >
				<option selected  value="${incidencia.aula}">${incidencia.aula}</option>
      			<option value="isuntza">ISUNTZA</option>
  				<option value="karraspio">KARRASPIO</option>
  				<option value="gorbeia">GORBEIA</option>
  				<option value="pagasarri">PAGASARRI</option>
    			</select>
				</c:when>
				<c:when test="${op == 'borrar'}">

				<input type="text" class="form-control" id="aula" name="aula" value="${incidencia.aula}" readonly >


				</c:when>
			</c:choose>
		
		
    <div class="invalid-feedback">
      Selecciona un aula valida.
    </div>
  </div>	
			
	<div class="col-md-4 ps-4 mt-4">
    <label for="inicio" class="form-label">Inicio</label>
    <input type="date" class="form-control" id="inicio" name ="inicio" value="${incidencia.inicio}"
    	<c:choose>
				<c:when test="${op == 'borrar'}">readonly</c:when>
			</c:choose>
			>   
	 <div class="invalid-feedback">
      Introduzca la fecha de creacion.
    </div>
  	</div>
	
	<div class="col-md-4 ps-4 mt-4">
    <label for="fin" class="form-label">Fin</label>
    <input type="date" class="form-control" id="fin" name ="fin" value="${incidencia.fin}" 
    		<c:choose>
				<c:when test="${op == 'borrar'}">readonly</c:when>
			</c:choose>
			>    
	 <div class="invalid-feedback">
      Introduzca la fecha de resolucion.
    </div>
  
	</div>
	
	
	<div class="col-md-4  mt-3">
		<label for="reportado_por" class="form-label">Reportado Por</label>
			<input type="text" class="form-control" id="reportado_por" name="reportado_por"
			value="${incidencia.reportado_por}" 
			<c:choose>
				<c:when test="${op != 'borrar'}">required</c:when>
				<c:when test="${op == 'borrar'}">readonly</c:when>
			</c:choose>
			>
		<div class="invalid-feedback">
     	 Introduzca quien  reporta la incidencia.
		</div>
	</div>
	
	
  <div class="col-md-4 ps-4 mt-3">
		<label for="estado" class="form-label">Estado</label>
		
   			<c:choose>
				<c:when test="${op != 'borrar'}">
				<select class="form-select" id="estado" name="estado" >
				<option selected  value="${incidencia.estado}">${incidencia.estado}</option>
      				<option value="activa">ACTIVA</option>
  					<option value="resuelta">RESUELTA</option>
		  		</select>
				</c:when>
				<c:when test="${op == 'borrar'}">
				<input type="text" class="form-control" id="estado" name="estado"value="${incidencia.estado}" readonly>
			
				</c:when>
			</c:choose>
    	
			
		<div class="invalid-feedback">
      		Seleccione el estado de la incidencia.
		</div>
		</div>

	<div class="col-md-4 ps-4 mt-3">
		<label for="resuelto_por" class="form-label">Resuelto Por</label>
			<input type="text" class="form-control" id="resuelto_por" name="resuelto_por"
			value="${incidencia.resuelto_por}" 
			<c:choose>
				<c:when test="${op == 'borrar'}">readonly</c:when>
			</c:choose>
			>   
		<div class="invalid-feedback">
     	 Introduzca quien  resuelve la incidencia.
		</div>
	</div>
	
	
	<div class="col-12 mt-5 mb-3 ">
		
			<button type="submit" <c:choose>
				
				<c:when test="${op != 'borrar'}">class="btn btn-Azul_claro"</c:when>
				<c:when test="${op == 'borrar'}">class="btn btn-danger"</c:when>
			</c:choose>
			>
			
			
			<c:choose>
				
				<c:when test="${op == 'editar'}">Editar</c:when>
				<c:when test="${op == 'borrar'}">Borrar</c:when>
							
			</c:choose>
			</button>
			<a href="incidenciastodas" class="btn btn-Gris_oscuro ms-3">Cancelar</a>
		
	</div>
</form>
	
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>