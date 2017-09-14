<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div>

	<form:form action="processAjoutQuestionnaire" method="POST"
		modelAttribute="nouveauQuestionnaire">
		<table class="col s8 offset-s2">
			<tr>
				<td class="col s1" style="text-align: center;"><form:label path="nom">Nom</form:label></td>
				<td class="col s5"><form:input id="nom" path="nom" type="text" /></td>
				<td class="col s2"><button class="waves-effect waves-light btn-large blue darken-3" type="submit">Ajouter<i class="material-icons right">add_circle_outline</i></button></td>
				
			</tr>
		</table>
	</form:form>

</div>