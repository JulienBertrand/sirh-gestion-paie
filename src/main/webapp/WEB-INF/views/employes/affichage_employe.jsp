<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css"
	href="https://bootswatch.com/slate/bootstrap.min.css">
	<center><title>Liste des Employés</title></center>
</head>
<body>

	<a href="<%=request.getContextPath()%>">retour au menu principal</a>
</br>
</br>
<a href="<%=request.getContextPath()%>/mvc/employes/creer_employe">Ajouter un nouvel employé</a>
</br>
<a href="<%=request.getContextPath()%>/mvc/bulletins/creer_bulletin">Ajouter un nouveau bulletin</a>
</br>
<a href="<%=request.getContextPath()%>/mvc/bulletins/affichage_bulletin">Afficher les bulletins de salaire</a>
</br>
</br>
</br>
</br>
</br>
<div class="container">
	<div class="row">
		<div class="col-sm-8 col-sm-offset-2">
			<h1>Tableau des employés</h1>
			<table class="table">
				<thead>
					<tr class="info">
						<th>Matricule</th>
						<th>Entreprise</th>
						<th>Grade</th>
						<th>Profil de Remuneration</th>
					</tr>
				</thead>
				<c:forEach items="${employes}" var="employe">
				<tr class="active">
					<td>${employe.matricule}</td>
					<td>${employe.entreprise.denomination}</td>
					<td>${employe.grade.code}</td>
					<td>${employe.profilRemuneration.code}</td>

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