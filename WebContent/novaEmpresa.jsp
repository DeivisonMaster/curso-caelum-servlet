<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nova Empresa</title>
</head>
<body>

	<h2>Resultado da busca:</h2>
	<br />

	<ul>
		<c:forEach var="empresa" items="${listaEmpresas}">
			<li>${empresa.id} : ${empresa.nome}</li>
		</c:forEach>
	</ul>

</body>
</html>