<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css"
	href="https://bootswatch.com/slate/bootstrap.min.css">
	<title>Créer un Nouveau Bulletin de Salaire</title>
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
<a
href="<%=request.getContextPath()%>/mvc/bulletins/affichage_bulletin">Afficher
la liste des Bulletins</a>
</br>
</br>
</br>
</br>
</br>


<form method="POST" action="creer_bulletin">
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<h1>Ajouter un Bulletin</h1>
				<table class="table">
					<tr class="active">
						<td>Sélectionner la période de rémunération&nbsp;:&nbsp;</td>
						<td><select name="periodeId" required>
							<option disabled selected></option>
							<c:forEach items="${periodes}" var="periode">
							<option value="${periode.id}">${periode.dateDebut} - ${periode.dateFin}</option>
						</c:forEach>
					</select></td>
				</tr>
				<tr class="active">
					<td>Sélectionner l'employe&nbsp;:&nbsp;</td>
					<td><select name="remunerationEmployeId" required>
						<option disabled selected></option>
						<c:forEach items="${remunerationEmployes}"
						var="remunerationEmploye">
						<option value="${remunerationEmploye.id}">${remunerationEmploye.matricule}</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr class="active">
				<td><span>Ajouter prime exceptionnelle&nbsp;:&nbsp;</span></td>
				<td><input type="text" name="primeExceptionnelle" value="0"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"></br><input class="btn-success"
					type="submit" name="Valider"></td>
				</tr>
			</table>
		</div>
	</div>
</div>
</form>
</body>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"</script>
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"</script>
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
	</html>