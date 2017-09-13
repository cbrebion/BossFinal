<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="uri" value="${ requestScope['javax.servlet.forward.request_uri'] }" />

<nav class="blue darken-3" role="navigation">
	<div class="nav-wrapper container">
		<a id="logo-container" href="/BossFinal/home" class="brand-logo">BossFinal</a>
		
		<!-- Lien de déconnexion si connecté -->
		<c:if test="${ !empty sessionScope.admin }">
			<ul class="right hide-on-med-and-down">
				<li><a href="/BossFinal/deconnexion">Déconnexion</a></li>
			</ul>
		</c:if>
		
		<!-- Lien du menu, uniquement si connecté en tant qu'admin -->
		<%-- <c:if test="${ !empty sessionScope.admin }"> --%>
			<ul class="right hide-on-med-and-down">
				<li <c:if test='${ uri.equals("/tetrimino/listeTetriminos") }'>class="active"</c:if>>
					<a href="/tetrimino/listeTetriminos">Liste tetri</a>
				</li>
				<li <c:if test='${ uri.equals("/tetrimino/listeParties") }'>class="active"</c:if>>
					<a href="/tetrimino/listeParties">Liste parties</a>
				</li>
				<li <c:if test='${ uri.equals("/tetrimino/listeJoueurs") }'>class="active"</c:if>>
					<a href="/tetrimino/listeJoueurs">Liste joueurs</a>
				</li>
			</ul>
		<%-- </c:if> --%>
	</div>
</nav>