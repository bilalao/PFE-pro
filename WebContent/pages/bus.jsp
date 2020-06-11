
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<section id="main-content">
	<section class="wrapper site-min-height">
		<h3>
			<i class="fa fa-angle-right"></i> Gestion des Bus
		</h3>

		<div class="row mt">
			<div class="col-lg-12">
				<div class="form-panel">
					<div class=" form">
							<form class="cmxform form-horizontal style-form" id="commentForm"
							method="get" action="/BusManagement/b/save">
							<div class="form-group ">
								<label for="name" class="control-label col-lg-2">Bus
									Name : </label>
								<div class="col-lg-6">
									<input class=" form-control col-lg-6" id="name" name="name"
										type="text" required /><span id="error_name"></span>
								</div>
							</div>
							<div class="form-group ">
								<label for="matricule" class="control-label col-lg-2">Bus
									Matricule : </label>
								<div class="col-lg-4">
									<input class="form-control" id="matricule" type="text"
										name="matricule" required /><span id="error_matricule"></span>
								</div>
								</div>
								<div class="form-group ">
								<label for="total_seat" class="control-label col-lg-2">Total_Seat
								</label>
								<div class="col-lg-2">
									<input class="form-control" id="total_seat" type="text"
										name="total_seat" /><span id="error_total_seat"></span>
								</div>
							</div>
							<div class="form-group ">
								<label  for="bus_type" class="control-label col-lg-2">type bus : </label>
								<div class="col-lg-4">
									<select name="bus_type" class="form-control" name="bus_type"
										id="bus_type">
										<c:forEach var="type" items="${requestScope.types }">
											<option value="${type}">${type}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group float-right">
								<div class="col-lg-offset-9 col-lg-12">
									<button class="btn btn-theme" type="submit">
										<span class="fa fa-plus"></span> Enregistrer
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- /form-panel -->
			</div>
			<!-- /col-lg-12 -->
		</div>

		<div class="row mt">
			<div class="col-lg-12">
				<div class="content-panel">
					<div class="adv-table">
						<table cellpadding="0" cellspacing="0" border="0"
							class="display table table-bordered" id="clients-table">
							<thead>
								<tr>
									<th>Code</th>
									<th>Bus Matricule</th>
									<th>Name</th>
									<th>Type</th>
									<th>Total_Seat</th>
									<th>Operations</th>
								</tr>
							</thead>
							<tbody>
									<c:forEach var="bus" items="${requestScope.allBus}">
									<tr>
										<td>${bus.idBus}</td>
										<td>${bus.matricule}</td>
										<td>${bus.name}</td>
										<td>${bus.type}</td>
										<td>${bus.total_seat}place</td>

										<td>
										<a href="/BusManagement/b/edit?id=<c:out value='${bus.idBus}' />">
											<button type="button" class="btn btn-warning">
												<span class="fa fa-edit"></span>
											</button></a>
										  <a href="/BusManagement/b/delete?id=<c:out value='${bus.idBus}' />">
											<button type="button" class="btn btn-danger">
												<span class="fa fa-trash-o"></span>
											</button>
											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
</section>