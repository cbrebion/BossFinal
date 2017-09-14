<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<div class="row">
		<div class="input-field col s4 offset-s4">
			<p> Ajouter un ou plusieurs test au candidat suivant : <b> ${candidat.nom}
			${candidat.prenom}</b></p>
		</div>

		<table>
			<thead>
			<tr>
				<th>Nom du test</th>
				<th></th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${listeTests}" var="test">
					<tr>
						<td>${test}</td>
						<td>
							<c:set var="cdtTest" value=""/>
							
							<c:forEach items="${candidat.candidatTests}" var="candidatTest">
								<c:if test="${test.candidatTests.contains(candidatTest)}"><c:set var="cdtTest" value="${candidatTest.code}"/></c:if>
							</c:forEach>
							
							<c:if test="${cdtTest != ''}">${cdtTest}</c:if>
							<c:if test="${cdtTest eq ''}"><a href="/BossFinal/${candidat.id}/associerTest/${test.id}">Ajouter un test</a></c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>