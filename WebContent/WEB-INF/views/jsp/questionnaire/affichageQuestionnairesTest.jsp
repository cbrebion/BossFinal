<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div>

	<a href="ajoutQuestionnaire">Ajouter un questionnaire au test N°${ Test.id }</a>

	<table>
		<thead>
			<tr>
				<th style="text-align: center;">ID</th>
				<th style="text-align: center;">Nom</th>
				<th style="text-align: center;">Nombre de tests associés</th>
				<th style="text-align: center;">Afficher questions</th>
				<th style="text-align: center;">Ajouter une question</th>
				<th style="text-align: center;">Action</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${QuestionnairesTest}" var="Questionnaire">
				<tr>
					<td style="text-align: center;">${Questionnaire.id}</td>
					<td style="text-align: center;">${Questionnaire.nom }</td>
					<td style="text-align: center;">${Questionnaire.tests.size() }</td>
					<td style="text-align: center;"><a href="/BossFinal/${Questionnaire.id}/questions" class="btn-floating btn-large waves-effect waves-light blue"><i class="material-icons">remove_red_eye</i></a></td>
					
					<td style="text-align: center;" ><a href="/BossFinal/${Questionnaire.id}/ajoutQuestion" } class="btn-floating btn-large waves-effect waves-light blue"><i class="material-icons">add_to_photos</i></a></td>
					
					<c:if test="${Questionnaire.tests.contains(Test) }">
						<td style="text-align: center;" ><a href="dissocier/${Questionnaire.id}" class="btn-floating btn-large waves-effect waves-light blue"><i class="material-icons">gps_fixed</i></a></a></td>
					</c:if>
					<c:if test="${!Questionnaire.tests.contains(Test) }">
						<td style="text-align: center;" ><a href="associer/${Questionnaire.id}" class="btn-floating btn-large waves-effect waves-light blue"><i class="material-icons">gps_not_fixed</i></a></a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>