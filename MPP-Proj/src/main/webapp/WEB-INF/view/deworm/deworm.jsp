<%@ include file="/resources/common/header.jspf"%>
<%@ include file="/resources/common/navigation.jspf"%>


<div class="container">

	<spring:url value="/deworm/" var="saveDeworm" />

	<form:form modelAttribute="dewormForm" method="POST" action="${saveDeworm}">
		<f:hidden path="id" />
		<table>
			<tr>
				<td>Animal: </td>
				<td style="width: 200px;padding:10px">
				<f:select id="animal_id" path="animal_id">
						<option value="-1">Select Animal</option>
						<f:options items="${AnimalList}" itemValue="id" itemLabel="name"/>
       			</f:select>
				</td>	
			</tr>
			<tr>
				<td>Name Deworm : </td>
				<td style="width: 20px;padding:10px">
					<f:input path="name" maxlength="30"/>
				</td>
			</tr>
			<tr>
				<td>Date : </td>
				<td style="width: 20px;padding:10px">
					<f:input path="date" maxlength="10" type = "date" />
				</td>
			</tr>
			<tr>
				<td>Doctor: </td>
				<td style="width: 200px;padding:10px">
				<f:select id="doctor_id" path="doctor_id">
						<option value="-1">Select Doctor</option>
						<f:options items="${DoctorList}" itemValue="id" itemLabel="lastName"/>
       			</f:select>
				</td>	
			</tr>
			<tr>
				<td><button type="submit" class="btn btn-success">Save</button></td>
			</tr>
		</table>
	</form:form>
 
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Animal</th>
			<th>Date</th>
			<th>Name Deworm</th>
			<th>Doctor</th>
			<th colspan="2"> Action</th>
		</tr>
		<c:forEach items="${listdeworm}" var="deworm">
			<tr>
				<td>${deworm.id}</td>
				<td>${deworm.animal.getName()}</td>
				<td>${deworm.date}</td>
				<td>${deworm.name}</td>
				<td>${deworm.doctor.getLastName()}</td>
				
				<td>
					<spring:url value="/deworm/update?id=${deworm.id}" var="updateDeworm" />
					<a type="button" class="btn btn-primary"
						href="${updateDeworm}">Update</a>
					<spring:url value="/deworm/delete?id=${deworm.id}" var="deleteDeworm" />
					<a type="button" class="btn btn-warning"
						href="${deleteDeworm}">Delete</a>
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
