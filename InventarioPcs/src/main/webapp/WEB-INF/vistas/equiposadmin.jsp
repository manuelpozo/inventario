<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<c:if test="${op == 'borrar'}">
		
		<div class="alert alert-danger alert-dismissible fade show mt-3" role="alert">
  <strong>Cuidado; </strong>Esta en el formulario de borrar equipos.
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

	</c:if>
	<form action="equiposadmin" method="post" class="row g-3 needs-validation mt-5" novalidate>


	<input type="hidden" name="op" value="${op}" />
	
	
	
	<div class="col-md-3 ">
    	<label for="id" class="form-label">Id</label>
    	<input type="number" class="form-control" readonly  id="id" name="id"
			value="${equipo.id}">
   </div>
    
 	<div class="col-md-9 ps-4">
    	<label for="numero_serie" class="form-label">Numero de Serie</label>
    	<input type="text" class="form-control" id="numero_serie" name="numero_serie" value="${equipo.numero_serie}" 

			<c:choose>
				<c:when test="${op == 'borrar'}">readonly</c:when>
				<c:when test="${op != 'editar'}">required</c:when>
			</c:choose>>
    		<div class="invalid-feedback">
     		 	Por favor, introduzca el numero de serie del equipo.
   			</div>
  	</div>
	
	<div class="col-md-4 mt-3" >
    	<label for="nombre" class="form-label">Nombre Equipo</label>
    	<input type="text" class="form-control" id="nombre" name="nombre" value="${equipo.nombre}" 
			<c:choose>
				<c:when test="${op == 'borrar'}">readonly</c:when>
				<c:when test="${op != 'editar'}">required</c:when>
			</c:choose>
			>
			
    		<div class="invalid-feedback">
      			Introduzca el nombre del equipo.
    		</div>
  	</div>

  <div class="col-md-4 ps-4 mt-3">
    <label for="modelo" class="form-label">Modelo</label>
    <input type="text" class="form-control" id="modelo" name="modelo" value="${equipo.modelo}" 
			<c:choose>
				<c:when test="${op == 'borrar'}">readonly</c:when>
				<c:when test="${op != 'editar'}">required</c:when>
			</c:choose>
			>
    <div class="invalid-feedback">
     		Introduzca el modelo del equipo.
  	</div>
  </div>
  
  <div class="col-md-4 ps-4 mt-3">
    <label for="procesador" class="form-label">Procesador</label>
    <input type="text" class="form-control" id="procesador" name="procesador"value="${equipo.procesador}" 
		<c:choose>
				<c:when test="${op == 'borrar'}">readonly</c:when>
				<c:when test="${op != 'editar'}">required</c:when>
			</c:choose>
			>
    <div class="invalid-feedback">
      Introduzca el procesador del equipo.
    </div>
  </div>
  
  <div class="col-md-4  mt-3">
    <label for="ram" class="form-label">Ram</label>
    <div class="input-group has-validation">
     <input type="number"  class="form-control" id="ram" name="ram" value="${equipo.ram}"aria-describedby="inputGroupPrepend" 
			<c:choose>
				<c:when test="${op == 'borrar'}">readonly</c:when>
				<c:when test="${op != 'editar'}">required</c:when>
			</c:choose>
			>
       <span class="input-group-text" id="inputGroupPrepend">Gb</span>
      <div class="invalid-feedback">
        Introduzca la ram del equipo (en Gb, solo la cantidad).
      </div>
    </div>
   </div>  
   
   <div class="col-md-4 ps-4 mt-3">
    <label for="disco" class="form-label">Disco</label>
    
	<c:choose>
		<c:when test="${op != 'borrar'}">
		<select class="form-select" id="disco" name="disco" required>
		<option selected value="${equipo.disco}">${equipo.disco}</option>
       	<option value="HDD">HDD</option>
  		<option value="SSD">SSD</option>
  		<option value="Hibrido">Hibrido</option>
  		<option value="M2">M2</option>
   		</select>
		</c:when>
		<c:when test="${op == 'borrar'}">
		<input type="text" class="form-control" id="disco" name="disco" value="${equipo.disco}" readonly>
		</c:when>
	</c:choose>
    
      
    <div class="invalid-feedback">
      Selecciona un tipo de disco.
    </div>
  </div>
  
 
   <div class="col-md-4 ps-4 mt-3 ">
    <label for="capacidad_disco" class="form-label">Capacidad disco</label>
    <div class="input-group has-validation">
    	<input type="number"  class="form-control" id="capacidad_disco" name="capacidad_disco" value="${equipo.capacidad_disco}"aria-describedby="inputGroupPrepend" 
				<c:choose>
				<c:when test="${op == 'borrar'}">readonly</c:when>
				<c:when test="${op != 'editar'}">required</c:when>
			</c:choose>
			>
			
       	<span class="input-group-text" id="inputGroupPrepend">Gb</span>
      <div class="invalid-feedback">
        Introduzca la capacidad de disco del equipo (en Gb, solo la cantidad).
      </div>
    </div>
  </div>
  
  <div class="col-md-4  mt-3">
    <label for="aula" class="form-label">Aula</label>
    <c:choose>
			<c:when test="${op != 'borrar'}">
			<select class="form-select" id="aula" name="aula" required>
			<option selected  value="${equipo.aula}">${equipo.aula}</option>
       		<option value="isuntza">ISUNTZA</option>
  			<option value="karraspio">KARRASPIO</option>
  			<option value="gorbeia">GORBEIA</option>
  			<option value="pagasarri">PAGASARRI</option>
  			<option value="sin asignar">SIN ASIGNAR</option>
    		</select>
			</c:when>
			
			<c:when test="${op == 'borrar'}">
			<input type="text" class="form-control" id="aula" name="aular"value="${equipo.aula}" readonly>

			</c:when>
			
			
		</c:choose>
    

    <div class="invalid-feedback">
      Selecciona un aula valida.
    </div>
  </div>
  
 
  <div class="col-12 mt-5 mb-3 ">
		
			<button type="submit" 
			<c:choose>
				<c:when test="${op != 'borrar'}">class="btn btn-Azul_claro"</c:when>
				<c:when test="${op == 'borrar'}">class="btn btn-danger"</c:when>
			</c:choose>
			>
			
			<c:choose>
				<c:when test="${op == 'agregar'}">Añadir</c:when>
				<c:when test="${op == 'editar'}">Editar</c:when>
				<c:when test="${op == 'borrar'}">Borrar</c:when>
							
			</c:choose>
			</button>
			<a href="equipostodos" class="btn btn-Gris_oscuro ms-3">Cancelar</a>
		</div>
	
  
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>