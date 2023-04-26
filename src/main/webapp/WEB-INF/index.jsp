<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Juego Ninja Gold</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Tu puntuación: ${gold}</h1>
		<div class="row">
			<div class="col">
				<h3>Granja</h3>
				<p>Ganas 10-20 puntos</p>
				<form action="/jugar" method="POST">
					<input type="hidden" value="granja" name="lugar">
					<input type="submit" class="btn btn-info" value="¡Encontrar Oro!">
				</form>
			</div>
			<div class="col">
				<h3>Cueva</h3>
				<p>Ganas 5-10 puntos</p>
				<form action="/jugar" method="POST">
					<input type="hidden" value="cueva" name="lugar">
					<input type="submit" class="btn btn-primary" value="¡Encontrar Oro!">
				</form>
			</div>
			<div class="col">
				<h3>Casa</h3>
				<p>Ganas 2-5 puntos</p>
				<form action="/jugar" method="POST">
					<input type="hidden" value="casa" name="lugar">
					<input type="submit" class="btn btn-success" value="¡Encontrar Oro!">
				</form>
			</div>
			<div class="col">
				<h3>Casino</h3>
				<p>Ganas/Pierdes 0-50 puntos</p>
				<form action="/jugar" method="POST">
					<input type="hidden" value="casino" name="lugar">
					<input type="submit" class="btn btn-danger" value="¡Encontrar Oro!">
				</form>
			</div>
		</div>
		<div class="row">
			<h2>Actividad</h2>
			<c:forEach items="${activities}" var="activity">
				<c:if test="${activity.contains('ganaste')}">
					<p class="text-success">${activity}</p>
				</c:if>
				
				<c:if test="${activity.contains('perdiste')}">
					<p class="text-danger">${activity}</p>
				</c:if>
				
			</c:forEach>
		</div>
	</div>
</body>
</html>