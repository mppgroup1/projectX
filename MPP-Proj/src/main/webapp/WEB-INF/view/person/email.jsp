<%@ include file="/resources/common/header.jspf"%>
<%@ include file="/resources/common/navigation.jspf"%>


<div class="container">

	<spring:url value="/person/email?pid=${pid}" var="saveEmail" />

	<form:form modelAttribute="EmailForm" method="POST" action="${saveEmail}">
		<h3>${personName} EMAIL(s) INFO:</h1><h2 style="display:none">"${pid}"</h3>
		<f:hidden path="id" />
		<f:hidden path="person_id" />
		<table>
				<%-- <tr>
				<td>Person: </td>
				<td style="width: 200px;padding:10px">
				<f:select id="person_id" path="person_id">
						<option value="-1">Select Person</option>
						<f:options items="${PersonList}" itemValue="id" itemLabel="lastName"/>
       			</f:select>
				</td>	
			</tr> --%>
			<tr>
				<td>Email Name : </td>
				<td style="width: 200px;padding:10px">
					<f:input path="email"  />
				</td>				
			</tr>			
			<tr>
				<td>Is Primary : </td>
				<td style="padding:10px;">
					<f:checkbox path="primary" />
       			</td>		
			</tr>			
			<tr>		
					
			</tr>			
			<tr>
				<td>
					<spring:url value="/person" var="back" />
					<a type="button" class="btn btn-primary" href="${back}">Back</a>
				</td>
				<td><button type="submit" class="btn btn-success">Save</button></td>
			</tr>
		</table>
	</form:form>
 
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<!-- <th>Person</th> -->
			<th>Email Name</th>
			<th>Is Primary</th>
			
			<th colspan="2"></th>
		</tr>
		<c:forEach items="${listEmail}" var="Email">
			<tr>
				<td>${Email.id}</td>
				<%-- <td>${Email.person.getLastName()}</td> --%>
				<td>${Email.email}</td>
				<td>${Email.primary}</td>
								
				<td colspan="2" align="right">
					<spring:url value="/person/email?id=${pid}&update_id=${Email.id}" var="updateEmail" />
					<a type="button" class="btn btn-primary"
						href="${updateEmail}">Update</a>
						
						<div id="myModal_${Email.id}" class="modal fade">
						    <div class="modal-dialog">
						        <div class="modal-content">
						            <div class="modal-header">
						                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						                <h4 class="modal-title">Confirm Delete</h4>
						            </div>
						
						            <div class="modal-body">
						                <p>Are you sure you want to delete this Email Record? </p>
						            </div>
						            <div class="modal-footer">
										<spring:url value="/person/email/delete?id=${Email.id}&pid=${pid}" var="deleteEmail" />
						                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
						                <a type="button" class="btn btn-warning" href="${deleteEmail}" title="Delete"><i class="fa fa-trash-o"></i>Delete</a>
						            </div>
						        </div>
						    </div>
						</div> 	
					<a href="#myModal_${Email.id}" role="button" class="btn btn-large btn-primary btn-warning" data-toggle="modal">Delete</a>
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