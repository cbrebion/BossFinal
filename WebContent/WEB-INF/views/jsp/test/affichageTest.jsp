
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>



<table class="stripped">
	<thead>
		<tr>
			<th>Branche</th>
			<th>Niveau</th>
		</tr>
	</thead>

	<tbody class="stripped">

		<c:forEach items="${affichageTests}" var="item">
			<tr>
				<td><a href="/BossFinal/test-${ item.id }/questionnaires">${ item.branche }
				</a></td>

				<td><a href="/BossFinal/test-${ item.id }/questionnaires">${item.niveau }
				</a></td>
			</tr>

		</c:forEach>

	</tbody>
</table>

<br />

<div>
		
		 <a href="/BossFinal/test/add" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
		
</div>