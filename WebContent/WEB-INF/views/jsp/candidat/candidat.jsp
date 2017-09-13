<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

	<form:form method="POST" class="row center" modelAttribute="candidat">
		<h5>Nom</h5>
		<form:input path="nom" class="row center" />
		<h5>Prenom</h5>
		<form:input path="prenom" class="row center" />
		<br />
		<button class="btn waves-effect waves-light blue"
			type="submit" name="Valider">
			Ajouter<i class="material-icons right">send</i>
		</button>
	
	</form:form>