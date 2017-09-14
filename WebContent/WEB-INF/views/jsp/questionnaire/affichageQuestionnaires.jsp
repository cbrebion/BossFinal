<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Nbre de tests</th>
				<th></th>
				<th></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${Questionnaires}" var="Questionnaire">
				<tr>
					<td>${Questionnaire.id}</td>
					<td>${Questionnaire.nom }</td>
					<td>${Questionnaire.tests.size() }</td>
					<td><a href="/BossFinal/${Questionnaire.id}/questions" class="btn-floating btn-large waves-effect waves-light blue"><i class="material-icons">remove_red_eye</i></a></td>
					<td><a href="${Questionnaire.id}/ajoutQuestion" class="btn-floating btn-large waves-effect waves-light blue"><i class="material-icons">add_to_photos</i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>