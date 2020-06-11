<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Liste des Bus</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../fontawesome/css/all.css">
<link rel="stylesheet" href="../css/jquery.dataTables.css">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

</head>
<body>

	<div class="container">
		<h3 style="margin-top: 20px;">Liste des bus :</h3>

		<br>

		<c:choose>

			<c:when test="${empty requestScope.allBus}">
				<div class="alert alert-warning">
					<strong>Warning!</strong> Aucun bus a afficher
				</div>
			</c:when>

			<c:when test="${not empty requestScope.allBus}">
			<form class="form-inline" action="/Atelier4/do/search">
				<label class="control-label mr-2" for="prd_type">type
					bus : </label> 
				<select name="prd_type" class="form-control mr-3 col-md-4" name="prd_type"
					id="prd_type" >
					<c:choose>
						<c:when test="${empty requestScope.type || requestScope.type=='tous'}">
							<option value="tous" selected="selected">Tous</option>
						</c:when>
						<c:otherwise>
							<option value="tous">Tous</option>
						</c:otherwise>
					</c:choose>
					<c:forEach var="s" items="${requestScope.types}">
						<c:choose>
							<c:when test="${requestScope.type==s}">
								<option value="${s}" selected="selected">${s}</option>
							</c:when>
							<c:otherwise>
								<option value="${s}">${s}</option>
							</c:otherwise>
					</c:choose>
					</c:forEach>
				</select>
				<button  class="btn col-md-3 btn-primary" type="submit">
					<span class="fas fa-search"></span> Rechercher
				</button>
			</form>

			<br>

			<table class="table table-bordered table-striped" id="tableOne">
				<thead class="thead-dark">
					<tr>
						<th>Code</th>
						<th>Bus Matricule</th>
						<th>Name</th>
						<th>Type</th>
						<th>Total_Seat</th>
						<th>Operations</th>
					</tr>
				</thead>
				<tbody id="rowproducts">
					<c:forEach var="bus" items="${requestScope.allBus}">
						<tr>
							<td>${bus.idBus}</td>
							<td>${bus.matricule}</td>
							<td>${bus.name}</td>
							<td>${bus.type}</td>
							<td>${bus.total_seat}place</td>
						
							<td>
								<form action="/BusManagement/do/edit" id="formedit_${bus.idBus}">
									<input type="hidden" id="action_${bus.idBus}" name="action">
									<input type="hidden" id="idProd_${bus.idBus}" name="idProd" value="${bus.idBus}">
									<button id="modProd_${bus.idBus}" type="button" class="btn btn-warning" onclick="modificationProd(${bus.idBus})">
										<span class="fas fa-edit"></span>
									</button>
									<button id="delProd_${bus.idBus}" type="button" class="btn btn-danger" onclick="suppressionProd(${bus.idBus})">
										<span class="fas fa-trash"></span>
									</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
		</c:when>
		</c:choose>
		
		<a href="/BusManagement/do/add">
			<button type="button" class="btn btn-success col-md-3 float-right">
				<span class="fa fa-plus"></span> Nouveau bus
			</button>
		</a>

	</div>


		<div id="deleteModal" class="modal fade" role='dialog'>
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">Suppression de bus</h4>
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						</div>
						<div class="modal-body">
							<p>Voulez-vous vraiment supprimer ce bus</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
							<span id='deleteButton'></span>
						</div>
					</div>
				</div>
		</div>	 	
	<script src="../js/jquery.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.dataTables.js"></script>
	<script src="../js/script.js"></script>
</body>
</html>
