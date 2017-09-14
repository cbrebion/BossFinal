<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
<div class="col s8 offset-s2">La question est : ${question.libelle}</div>
<div class="col s8 offset-s2"> Voici les réponses correspondantes : </div>
<div class="col s8 offset-s2">
	<table>
		<thead>
		<tr>
		<th>Réponse</th>
		<th></th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${listePropositions}" var="proposition">
		<tr>
		<td>${ proposition.libelle }</td>
		<td><c:if test="${ proposition.correct ==true }">Bonne réponse</c:if></td>
		<td><a href="propositions/${proposition.id}/supprimer"
						class="secondary-content "><i class="material-icons">delete</i></a></td>
		<td><a href="propositions/${proposition.id}/modifier"
						class="secondary-content "><i class="material-icons">mode_edit</i></a></td>
		</c:forEach>
		</tr>
		</tbody>
	</table>
</div>
<div class="col s3 offset-s7">
<a class="waves-effect waves-light btn-large blue darken-3" href="propositions/ajouter" style="width : 400px; margin-top : 150px;">
<i class="material-icons right">add_circle_outline</i>Ajouter une proposition</a>
</div>
</div>