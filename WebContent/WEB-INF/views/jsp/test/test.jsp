<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

	<form:form method="POST" class="row center" modelAttribute="test">
		<h5>Niveau</h5>
		<form:input path="niveau" class="row center" />
		<h5>Branche</h5>
		<form:input path="branche" class="row center" />
		<br />
		<button class="btn waves-effect waves-light red lighten-1"
			type="submit" name="Valider">
			Valider<i class="material-icons right">send</i>
		</button>
	
	</form:form>