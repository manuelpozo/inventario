<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="incidenciainsertar" method="post" class="row g-3 needs-validation mt-5" novalidate>
  
  
  		<input type="hidden" name="op" value="${op}" />
  		
	<div class="col-md-3 ">
		<label for="id" class="form-label">Id</label>
		<input type="number" class="form-control" readonly  id="id" name="id"
				value="${incidencia.id}">
  		</div>
  	
  	

  <div class="col-md-9 ps-4 ">
    <label for="nombre_equipo" class="form-label">Nombre Equipo</label>
    <select class="form-select" id="nombre_equipo" name="nombre_equipo" required>
    	<option selected  disabled value="">Seleccione un nombre de equipo</option>
      		<c:forEach items="${listanombresequipos}" var="l">
      			<option value="${l.nombre}">${l.nombre}</option>
			</c:forEach>
	 </select>
    <div class="invalid-feedback">
      Por favor, seleccione el nombre del equipo
    </div>
</div>
  
  
  
  <div class="col-md-12  mt-3">
    <label for="descripcion" class="form-label">Descripcion</label>
    <input type="text" class="form-control" id="descripcion" name="descripcion" value="${incidencia.descripcion}" required>
      <div class="invalid-feedback">
        Proporcione una descripcion de la incidencia.
      </div>
    </div>
  
  	<div class="col-md-4 mt-3">
    <label for="aula" class="form-label">Aula</label>
    <select class="form-select" id="aula" name="aula" required>
    
      <option selected  disabled value="">Seleccione un aula</option>
       <option value="isuntza">ISUNTZA</option>
  		<option value="karraspio">KARRASPIO</option>
  		<option value="gorbeia">GORBEIA</option>
  		<option value="pagasarri">PAGASARRI</option>
    </select>
    <div class="invalid-feedback">
      Selecciona un aula valida.
    </div>
  </div>
  
	 <div class="col-md-4 ps-4 mt-3">
    <label for="reportado_por" class="form-label">Reportado Por</label>
    <input type="text" class="form-control" id="reportado_por" name ="reportado_por"required>   
	 <div class="invalid-feedback">
      Introduzca el nombre del creador de la incidencia.
    </div>
  	</div>
  

  
  <div class="col-md-4 ps-4 mt-3">
    <label for="resuelto_por" class="form-label">Resuelto Por</label>
    <input type="text" class="form-control" id="resuelto_por" name ="resuelto_por">
    <div class="invalid-feedback">
      Introduzca el nombre de quien resuelve la incidencia.
    </div>
  </div>
  
 

<div class="col-12 mt-5 mb-3 ">
		
		<button type="submit" class="btn btn-primary">Añadir
	
			</button>
			<a href="incidenciastodas" class="btn btn-secondary ms-3">Cancelar</a>
		</div>
	


</form>
	


<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>