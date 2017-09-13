<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
<div class="col s8 offset-s2">La question est : ${question.libelle}</div>
<div class="col s8 offset-s2"> Voici les r�ponses correspondantes : </div>
<div class="col s8 offset-s2">
	<table>
		<thead>
		<tr>
		<th>R�ponse</th>
		<th></th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${listePropositions}" var="proposition">
		<tr>
		<td>${ proposition.libelle }</td>
		<td><c:if test="${ proposition.correct ==true }">Bonne r�ponse</c:if></td>
		</c:forEach>
		</tr>
		</tbody>
	</table>
</div>
</div>