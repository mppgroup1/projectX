<%@ include file="/resources/common/header.jspf"%>
<%@ include file="/resources/common/navigation.jspf"%>


<div class="container">

	<spring:url value="/breed/" var="saveBreed" />

	<form:form modelAttribute="BreedForm" method="POST" action="${saveBreed}">
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
			<th>Breed</th>
			
			<th colspan="2"> Action</th>
		</tr>
		<c:forEach items="${listBreed}" var="Breed">
			<tr>
				<td>${Breed.id}</td>
				<td>${Breed.description}</td>
								
				<td>
					<spring:url value="/breed/update?id=${Breed.id}" var="updateBreed" />
					<a type="button" class="btn btn-primary"
						href="${updateBreed}">Update</a>
					<spring:url value="/breed/delete?id=${Breed.id}" var="deleteBreed" />
					<a type="button" class="btn btn-warning"
						href="${deleteBreed}">Delete</a>
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