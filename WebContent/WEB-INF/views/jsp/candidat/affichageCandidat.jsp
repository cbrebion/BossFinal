
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>



<table class="stripped">
	<thead>
		<tr>
			<th>Nom</th>
			<th>Prénom</th>
		</tr>
	</thead>

	<tbody>

		<c:forEach items="${affichageCandidats}" var="item">
			<tr>
				<td>${ item.nom }
				</td>

				<td>${item.prenom }
				</td>
			</tr>

		</c:forEach>

	</tbody>
</table>

<br />

<div>
		
		 <a href="/BossFinal/candidat/add" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
		
</div>