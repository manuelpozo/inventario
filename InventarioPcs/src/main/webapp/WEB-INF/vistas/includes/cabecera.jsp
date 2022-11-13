<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html class="h-100 ">
<head>
<meta charset="UTF-8">


<title>Inventario Pcs</title>
<base href="${pageContext.request.contextPath}/">

<!--  <link rel="stylesheet" href="css/datatables.min.css" />-->

<link rel="stylesheet" href="css/datatables.min.css" />
<link rel="stylesheet" href="css/bottstrapmodificado.css" />
<link rel="stylesheet" href="css/estilos.css">
<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/datatables.min.js"></script>
<script src="js/bottstrap.min.js"></script>
</head>


<body class="h-100 d-flex flex-column ">
	<h1 class="display2 text-center text-white bg-Azul_oscuro border border-5 border-Amarillo_oscuro mx-2 mt-1  py-5">Ipartek Servicios Informaticos</h1> 
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-Azul_claro border border-5 border-Amarillo_oscuro mx-2 mt-0   ">
		<div class="container-fluid d-flex">
			<a class="navbar-brand me-auto ms-5" href="equipostodos">Gestion de Equipos</a>
			 <a class="nav-link text-white me-5" href="equipostodos">Equipos</a>
          	<a class="nav-link text-white me-5" href="incidenciastodas">Incidencias</a>
				
		</div>
	</nav>
	

	<c:if test="${texto != null}">
		<div class="alert alert-Azul_claro alert-dismissible fade show mx-2 mt-2"
			role="alert">
			${texto}
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
	
	
	
	<main class="container">

