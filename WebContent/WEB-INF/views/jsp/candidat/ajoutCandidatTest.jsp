<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<div class="row">
		<div class="input-field col s4 offset-s4">
			<p> Ajouter un ou plusieurs test au candidat suivant : <b> ${candidatTestToCreate.candidat.nom}
			${candidatTestToCreate.candidat.prenom}</b></p>
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
							<c:if test = "${candidatTestToCreate.code == null}">
							<a href="">Ajouter un test</a></c:if>
							<c:if test ="${candidatTestToCreate.code !=null}">${candidatTestToCreate.code }</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>