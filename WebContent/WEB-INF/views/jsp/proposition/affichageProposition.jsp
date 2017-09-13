<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
<div>La question est : ${question.libelle}</div>
<div> Voici r�ponses correspondantes : </div>
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