
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<br />
<table class="bordered">
	<thead>
		<tr>
			<th>Branche</th>
			<th>Niveau</th>
			<th>Aperçu</th>
		</tr>
	</thead>

	<tbody >

		<c:forEach items="${affichageTests}" var="item">
			<tr>
				<td>${ item.branche }
				</td>

				<td>${item.niveau }
				</td>
			
				<td><a href="/BossFinal/test-${ item.id }/questionnaires" class="btn-floating btn-large waves-effect waves-light blue"><i class="material-icons">remove_red_eye</i></a>
				</td>
			</tr>

		</c:forEach>

	</tbody>
</table>

<br />

<div>
		
		 <a href="/BossFinal/test/add" class="btn-floating btn-large waves-effect waves-light blue"><i class="material-icons">add</i></a>
		
</div>