<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div>

	<form:form action="processAjoutQuestionnaire" method="POST"
		modelAttribute="nouveauQuestionnaire">
		<table>
			<tr>
				<td style="text-align: center;"><form:label path="nom">Nom</form:label></td>
				<td><form:input id="nom" path="nom" type="text" /></td>
			</tr>
			<tr>
				<td><button type="submit">Ajouter</i></button></td>
				<td></td>
			</tr>
		</table>
	</form:form>

</div>