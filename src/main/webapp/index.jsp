<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="https://bootswatch.com/slate/bootstrap.min.css">
	<title>Menu Principal</title>
</head>
<body>
	<h1>SIRH - Interface de Gestion Paie</h1></br>
	</br>
</br>
</br>
</br>
</br>
	<center><h2>Menu Principal</h2></center>
	<center>
		<table>
			<tr>
				<td><a href="<%=request.getContextPath()%>/mvc/employes/creer_employe">Ajouter un nouvel employé</a></br></td>
			</tr>
			<tr>
				<td><a
					href="<%=request.getContextPath()%>/mvc/employes/affichage_employe">Liste
						des employés</a></td>
			</tr>
			<tr>
				<td><a
					href="<%=request.getContextPath()%>/mvc/bulletins/creer_bulletin">Créer
						un bulletin de salaire</a></td>
			</tr>
			<tr>
				<td><a href="<%=request.getContextPath()%>/mvc/bulletins/affichage_bulletin">Afficher les bulletins de salaire</a></td>
			</tr>
		</table>
	</center>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"</script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"</script>
		<script src ="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
		</html>