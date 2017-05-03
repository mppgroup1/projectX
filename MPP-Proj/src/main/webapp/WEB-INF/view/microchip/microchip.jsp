<%@ include file="/resources/common/header.jspf"%>
<%@ include file="/resources/common/navigation.jspf"%>

<div class="container">

	<spring:url value="/microchip/" var="saveMicrochip" />

	<form:form modelAttribute="microchipForm" method="POST" action="${saveMicrochip}">
		<f:hidden path="id" />
		<table style="width: 499px; height: 265px; ">
			<tr>
				<td>Description: </td>
				<td style="width: 200px"><f:input path="description" maxlength="30"  />
					</tr>
					<tr>
				<td>Brand Name: </td>						
				<td style="width: 355px"><f:input path="brand" maxlength="30" />
				</tr>
				<tr>
				<td>Implant Date: </td>
				<td style="width: 355px">
					<f:input path="implantDate" type="date"/>
				</td>
				</tr>
				<tr>
					<td>Implant Site: </td>
					<td style="width: 355px">
						<f:select path="implantSite" >
				        <c:forEach items="${ImplantSiteList}" var="option">
				        			<option value="${option}" ${option == selectedImplantSite ? 'selected="selected"' : ''}>
				                    <c:out value="${option}"></c:out>
				                	</option>
				        </c:forEach>
					</f:select>
					</td>
				</tr>
				<tr><td>
				<button type="submit" class="btn btn-success">Save</button></td>
				</tr>
		</table>
	</form:form>
 
	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Description</th>
			<th>Brand</th>
			<th>Implant Date</th>
			<th>Implant Site</th>
			<th colspan="2"> Action</th>
		</tr>
		<c:forEach items="${listMicrochip}" var="microchip">
			<tr>
				<td>${microchip.id}</td>
				<td>${microchip.description}</td>
				<td>${microchip.brand}</td>
				<td>${microchip.implantDate}</td>
				<td>${microchip.implantSite}</td>

				<td>
					<spring:url value="/microchip/update?id=${microchip.id}" var="updateMicrochip" />
					<a type="button" class="btn btn-primary"
						href="${updateMicrochip}">Update</a>
					<spring:url value="/microchip/delete?id=${microchip.id}" var="deleteMicrochip" />
					<a type="button" class="btn btn-warning"
						href="${deleteMicrochip}">Delete</a>
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