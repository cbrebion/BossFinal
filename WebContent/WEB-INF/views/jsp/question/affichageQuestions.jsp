<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<h5><b>Questions de <c:out value="${ questionnaire.nom }"/></b></h5>
	<ul class="collection">
		<c:forEach items="${questions}" var="question">
		<li class="collection-item avatar">
			<c:out value="${ question.libelle }" />
			<div style="float: right;">
				<a href='/<c:out value="${questionnaire.id}" />/questions/<c:out value="${question.id}" />/supprimer' class="secondary-content posRelative" title="Supprimer"><i class="material-icons">cancel</i></a>
				<a href='/<c:out value="${questionnaire.id}" />/questions/<c:out value="${question.id}" />/modifier' class="secondary-content posRelative" title="Editer"><i class="material-icons">edit</i></a>
			</div>
		</li>
		</c:forEach>
	</ul>
	<p>
		<a class="waves-effect waves-light btn-large blue darken-3" href='ajoutQuestion'><i class="material-icons left">add</i>Ajouter une question</a>
	</p>
</div>