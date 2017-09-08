<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="https://bootswatch.com/slate/bootstrap.min.css">
<title>Ajout d'un nouvel Employé</title>
</head>
<body>


	<h1>Ajouter un Employé</h1>
	<center>
		<form method="POST" action="creer_employe">
			<table>
				<tr>
					<td><span>Matricule&nbsp;:&nbsp;</span></td>
					<td><input type="text" name="Matricule" required></td>
				</tr>
				<tr>
					<td>Entreprises&nbsp;:&nbsp;</td>
					<td><select name="entrepriseId" required>
							<option disabled selected></option>
							<c:forEach items="${entreprises}" var="entreprise">
								<option value="${entreprise.id}">${entreprise.denomination}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Profils&nbsp;:&nbsp;</td>
					<td><select name="profilId" required>
							<option disabled selected></option>
							<c:forEach items="${profils}" var="profil">
								<option value="${profil.id}">${profil.code}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Grades&nbsp;:&nbsp;</td>
					<td><select name="gradeId" required>
							<option disabled selected></option>
							<c:forEach items="${grades}" var="grade">
								<option value="${grade.id}">${grade.code} - ${(grade.nbHeuresBase*grade.tauxBase)*12} €/an</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr><td colspan="2" align="center"><input class="btn-success" type="submit" name="Valider"></td><td></td></tr>
			</table>
		</form>
	</center>




</body>





<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</html>