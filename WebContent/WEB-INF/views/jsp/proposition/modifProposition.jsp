<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<form:form class="col s12" method="POST" modelAttribute="propositionAModifier">
		<div class="row">
			<div class="input-field col s4 offset-s4">
				<form:input path="libelle" type="text" class="validate"/> 
				<form:label	path="libelle">Proposition</form:label>
				<form:errors path="libelle" style="color :#d32f2f "></form:errors>
			</div>


			<p class="col s4 offset-s4">
			<c:if test="${propositionAModifier.correct}">
				<input id="correct" type="checkbox" name="correct" class="filled-in" checked/>
				</c:if>
				<c:if test="${!propositionAModifier.correct}">
				<input id="correct" type="checkbox" name="correct" class="filled-in"/>
				</c:if>
				<label for="correct">Réponse vraie</label>
				<form:errors path="correct" style="color :#d32f2f "></form:errors>
			<p>
			<div class="input-field col s4 offset-s4">
				<button class="btn waves-effect waves-light blue darken-3" type="submit">
					Enregistrer <i class="material-icons right">send</i>
				</button>
			</div>
		</div>
	</form:form>
</div>