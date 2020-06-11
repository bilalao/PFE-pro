
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
										type="text" required />
								</div>
							</div>
							<div class="form-group ">
								<label for="matricule" class="control-label col-lg-2">Bus
									Matricule : </label>
								<div class="col-lg-4">
									<input class="form-control" id="matricule" type="text"
										name="matricule" required />
								</div>
								</div>
								<div class="form-group ">
								<label for="total_seat" class="control-label col-lg-2">Total_Seat
								</label>
								<div class="col-lg-2">
									<input class="form-control" id="total_seat" type="text"
										name="total_seat" />
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
									<th>Code Client</th>
									<th>address</th>
									<th>email</th>
									<th>name</th>
									<th>password</th>
									<th>phone</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="client" items="${requestScope.clients}">
									<tr>
										<td>CL<fmt:formatNumber groupingUsed="false"
												value="${client.numcli}" minIntegerDigits="4"></fmt:formatNumber></td>
										<td>${client.address}</td>
										<td>${client.email}</td>
										<td>${client.name}</td>
										<td>${client.password}</td>
										<td>${client.phone}</td>
										<td>
											<button type="button" class="btn btn-warning">
												<span class="fa fa-edit"></span>
											</button>
											<button type="button" class="btn btn-danger">
												<span class="fa fa-trash-o"></span>
											</button>
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