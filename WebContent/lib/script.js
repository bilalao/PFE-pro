$(document)
		.ready(
				function() {

					var oTable = $('#clients-table').dataTable({
						"aoColumnDefs" : [ {
							"bSortable" : false,
							"aTargets" : [ 0 ]
						} ],
						"aaSorting" : [ [ 1, 'asc' ] ]
					});

					$('#commentForm')
							.submit(
									function() {
										if ($('#name').val() == "") {
											$('#error_name').text(
													"Name non renseigne");
											return false;
										}

										if ($('#matricule').val() == "") {
											$('#error_matricule').text(
													"Matricule non renseigne");
											return false;
										}
										if ($('#total_seat').val() == "") {
											$('#error_total_seat')
													.text(
															"Total_Seat  non renseigne");
											return false;
										}
										return true;
									});
					$('#tableOne')
							.dataTable(
									{
										paginate : true,
										searching : false,
										ordering : true,
										language : {
											lengthMenu : "Afficher _MENU_ &eacute;l&eacute;ments",
											info : "Affichage de l'&eacute;lement _START_ &agrave; _END_ sur _TOTAL_ &eacute;l&eacute;ments",
											paginate : {
												first : "Premier",
												previous : "Pr&eacute;c&eacute;dent",
												next : "Suivant",
												last : "Dernier"
											}
										}
									});

					function modificationProd(id) {
						$('#action_' + id).val('update');
						$('#formedit_' + id).submit();
					}

					function suppressionProd(id) {
						$('#deleteModal').modal();
						$('#deleteButton').html(
								'<a class="btn btn-danger" onclick="appelsupprimer('
										+ id + ')">Supprimer</a>');
					}

					function appelsupprimer(id) {
						$('#deleteModal').hide();
						$('#action_' + id).val('delete');
						$('#formedit_' + id).submit();
					}

				});
