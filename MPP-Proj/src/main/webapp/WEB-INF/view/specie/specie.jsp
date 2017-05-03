<%@ include file="/resources/common/header.jspf"%>
<%@ include file="/resources/common/navigation.jspf"%>


<div class="container">

	<spring:url value="/specie/" var="saveSpecie" />

	<form:form modelAttribute="SpecieForm" method="POST" action="${saveSpecie}">
		<f:hidden path="id" />
		<table>
			<tr>
				<td>Description : </td>
				<td style="width: 200px;padding:10px">
					<f:input path="description"  />
				</td>				
			</tr>					
			<tr>		
					
			</tr>			
			<tr>
				<td><button type="submit" class="btn btn-success">Save</button></td>
			</tr>
		</table>
	</form:form>
 
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Specie</th>
			
			<th colspan="2"> Action</th>
		</tr>
		<c:forEach items="${listSpecie}" var="Specie">
			<tr>
				<td>${Specie.id}</td>
				<td>${Specie.description}</td>
								
				<td>
					<spring:url value="/specie/update?id=${Specie.id}" var="updateSpecie" />
					<a type="button" class="btn btn-primary"
						href="${updateSpecie}">Update</a>
					<spring:url value="/specie/delete?id=${Specie.id}" var="deleteSpecie" />
					<a type="button" class="btn btn-warning"
						href="${deleteSpecie}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<%@ include file="/resources/common/footer.jspf"%>

<script>
$(document).ready(function () {
    var url = window.location;
    $('ul.nav > li').removeClass('active');
    $('ul.nav a[href="'+ url +'"]').parent().addClass('active');
    $('ul.nav a').filter(function() {
         return this.href == url;
    }).parent().addClass('active');
});
</script>