<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="https://bootswatch.com/slate/bootstrap.min.css">
<center>
	<title>Liste des Bulletins</title>
</center>
</head>
<body>

	<a href="<%=request.getContextPath()%>">retour au menu principal</a>
	</br>
	</br>
	<a href="<%=request.getContextPath()%>/mvc/employes/creer_employe">Ajouter
		un nouvel employé</a>
	</br>
	<a href="<%=request.getContextPath()%>/mvc/employes/affichage_employe">Afficher
		la liste des employés</a>
	</br>
	<a href="<%=request.getContextPath()%>/mvc/bulletins/creer_bulletin">Créer
		un bulletin de salaire</a>
</br>
</br>
</br>
</br>
</br>

	<div class="container">
		<div class="row">
			<div class="col-sm-10">
				<h1>Tableau des bulletins</h1>
				<table class="table">
					<tr>
						<th>Periode</th>
						<th>Matricule</th>
						<th>Salaire Brut</th>
						<th>Net Imposable</th>
						<th>Net à Payer</th>
					</tr>
					<c:forEach items="${bulletins}" var="bulletin">
						<tr>
							<td>${bulletin.periode.dateDebut}-
								${bulletin.periode.dateFin}</td>
							<td>${bulletin.remunerationEmploye.matricule}</td>
							<td>${bulletin.resultatCalculRemuneration.salaireBrut}€</td>
							<td>${bulletin.resultatCalculRemuneration.netImposable}€</td>
							<td>${bulletin.resultatCalculRemuneration.netAPayer}€</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</html>