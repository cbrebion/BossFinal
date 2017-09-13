<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="row">
<form class="col s12" method="POST" modelAttribute="newProposition">
	<div class="row">
        <div class="input-field col s8 offset-s2">
          <input id="reponse" type="text" class="validate">
          <label for="reponse">Proposition</label>
        </div>
		<div class="input-field col s8 offset-s2">
          <input id="correct" type="radio" name="correct">
          <label for="correct">Réponse vraie</label>
        </div>
</div>
</form>
</div>