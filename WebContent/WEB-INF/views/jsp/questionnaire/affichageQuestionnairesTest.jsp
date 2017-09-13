<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div>

	<a href="ajoutQuestionnaire">Ajouter un questionnaire au test N°${ Test.id }</a>

	<table>
		<thead>
			<tr>
				<th style="text-align: center;">ID</th>
				<th style="text-align: center;">Nom</th>
				<th style="text-align: center;">Ajouter</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${QuestionnairesTest}" var="Questionnaire">
				<tr>
					<td style="text-align: center;">${Questionnaire.id}</td>
					<td style="text-align: center;">${Questionnaire.nom }</td>
					<td style="text-align: center;" ><a href="/BossFinal/${Questionnaire.id}/ajoutQuestion" }>Ajouter question</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>