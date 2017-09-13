<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
	<form:form method="post" modelAttribute="admin">
		<div class="input-field">
			<i class="material-icons prefix">account_circle</i>
			<form:label path="pseudo">Nom d'utilisateur</form:label>
			<form:input type="text" name="pseudo" path="pseudo" /><br>
		</div>
		<div class="input-field">
			<i class="material-icons prefix">vpn_key</i>
			<form:label path="mdp">Mot de passe</form:label>
			<form:input type="password" path="mdp" />
		</div>

		<button class="btn waves-effect waves-light blue darken-3" type="submit" name="action">
			Connexion <i class="material-icons right">send</i>
		</button>
		
		<br>
		<c:if test="${ !empty erreur }"><span class="erreur" style="color: red;">${ erreur }</span><br></c:if>
		<span class="erreur" style="color: red;"><form:errors path="pseudo" /></span><br>
		<span class="erreur" style="color: red;"><form:errors path="mdp" /></span>
	</form:form>
</div>