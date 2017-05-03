<%@ include file="/resources/common/header.jspf"%>
<%@ include file="/resources/common/navigation.jspf"%>


<div class="container">

	<spring:url value="/vaccine/" var="saveVaccine" />

	<form:form modelAttribute="vaccineForm" method="POST" action="${saveVaccine}">
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
				<td>Name Vaccine : </td>
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
				<td>Batch : </td>
				<td style="width: 20px;padding:10px">
					<f:input path="batch" maxlength="30" />
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
			<th>Name Vaccine</th>
			<th>Batch</th>
			<th>Doctor</th>
			<th colspan="2"> Action</th>
		</tr>
		<c:forEach items="${listvaccine}" var="vaccine">
			<tr>
				<td>${vaccine.id}</td>
				<td>${vaccine.animal.getName()}</td>
				<td>${vaccine.date}</td>
				<td>${vaccine.name}</td>
				<td>${vaccine.batch}</td>
				<td>${vaccine.doctor.getLastName()}</td>
				
				<td>
					<spring:url value="/vaccine/update?id=${vaccine.id}" var="updateVaccine" />
					<a type="button" class="btn btn-primary"
						href="${updateVaccine}">Update</a>
					<spring:url value="/vaccine/delete?id=${vaccine.id}" var="deleteVaccine" />
					<a type="button" class="btn btn-warning"
						href="${deleteVaccine}">Delete</a>
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