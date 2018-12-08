<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlet - API</title>
</head>
<body>
		<form action="novaEmpresa" method="POST">
			Nome: 
			<input type="text" name="nome" size="20"/>
			
			<input type="submit" value="salvar"/>
		</form>
		
		<br/><br/>
		
		<form action="login" method="POST">
			Nome: 
			<input type="text" name="email" size="20"/>
			<br/>
			
			Senha:
			<input type="password" name="senha" size="20"/>
			<br/>
			
			<input type="submit" value="salvar"/>
			<br/>
		</form>
		
		<form action="logout" method="POST">
			<input type="submit" value="deslogar"/>
		</form>

</body>
</html>