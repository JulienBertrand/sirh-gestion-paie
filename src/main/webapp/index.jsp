<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
language="java"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css"
	href="https://bootswatch.com/slate/bootstrap.min.css">
	<title>Menu Principal</title>
</head>
<body>
	<h1>SIRH - Interface de Gestion Paie</h1>
</br>
</br>
</br>
</br>
</br>
</br>
<center>
<div class="table table-striped table-hover">
	<div class="row">
		<div class="col-sm-4 col-sm-offset-4">
			<center><h1>Menu Principal</h1></center>
			<table class="table">
				<tr class="info">
					<td>
						<center><a href="<%=request.getContextPath()%>/mvc/employes/creer_employe">Ajouter un nouvel employé</a></center>
					</td>
				</tr>
				<tr class="info">
					<td>
						<center><a href="<%=request.getContextPath()%>/mvc/employes/affichage_employe">Liste des employés</a></center>
					</td>
				</tr>
				<tr class="success">
					<td>
						<center><a href="<%=request.getContextPath()%>/mvc/bulletins/creer_bulletin">Créer un bulletin de salaire</a></center>
					</td>
				</tr>
				<tr class="success">
					<td>
						<center><a href="<%=request.getContextPath()%>/mvc/bulletins/affichage_bulletin">Afficher les bulletins de salaire</a></center>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
</center>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"</script>
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"</script>
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
	</html>