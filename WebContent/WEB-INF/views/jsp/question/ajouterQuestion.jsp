<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form method="POST" modelAttribute="question">
	<div class="input-field">
		<form:label path="libelle">Libelle</form:label>
		<form:input path="libelle" type="text" name="libelle" />
	</div>

	<button class="btn waves-effect waves-light blue darken-3" type="submit" name="action">
		Ajouter <i class="material-icons right">send</i>
	</button>
	<br><span class="erreur" style="color: red;"><form:errors path="libelle" /></span>
	<br><span class="erreur" style="color: red;"><form:errors path="questionnaire" /></span>
</form:form>