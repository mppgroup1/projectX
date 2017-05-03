<%@ include file="/resources/common/header.jspf"%>
<%@ include file="/resources/common/navigation.jspf"%>
<div class="container">

	<spring:url value="/person/" var="savePerson" />

	<form:form modelAttribute="personForm" method="POST" action="${savePerson}">
		<f:hidden path="id"/>
		<table style="margin: 10 10 10 10">
			<tr>
				<td>Type</td><td width="10px"></td><td width="15px">:</td>
                <td style="width: 300px;padding:10px">
					<f:radiobuttons path="type" items="${personType}" itemValue="value" itemLabel="key"/>
				</td>
			</tr>
			<tr>
				<td>Title</td><td/><td>:</td>
				<td style="width: 200px;padding:10px">
					<f:select id="titleList" path="title">
						<option value="-1">Select</option>
						<f:options items="${titleList}"/>
					</f:select>
				</td>
			</tr>
			
			<tr>
				<td>First Name</td><td/><td>:</td>
				<td style="width: 200px;padding:10px"><f:input path="firstName"/></td>
			</tr>
			<tr>
				<td>Last Name</td><td/><td>:</td>
				<td style="width: 200px;padding:10px"><f:input path="lastName" /></td>
			</tr>
			
			<tr>
				<td>Gender</td><td/><td>:</td>
				<td style="width: 200px;padding:10px">
       				<f:radiobuttons path="gender" items="${genderList}" />
       			</td>
       		</tr>
       		<tr>
				<td>Status</td><td/><td>:</td>
				<td style="width: 200px;padding:10px">
       				<f:radiobuttons path="status" items="${statusList}" itemValue="value" itemLabel="key"/>
       			</td>
       		</tr>  
       		<tr>
				<td colspan="4" align="right">
					<button type="submit" class="btn btn-success">Save</button>
					<spring:url value="/person" var="cancel" />
					<a type="button" class="btn btn-warning"
						href="${cancel}">Cancel</a>
				</td>
			</tr>
			
		</table>
		
		<table class="table table-striped">
			<tr>
				<th>Title</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				<th>Type</th>
				<th>Location(s)</th>
				<th>Contact(s)</th>
				<th>Email(s)</th>
				<th>Active</th>
				<th align="right"></th>
			</tr>
			 
			<c:forEach items="${personList}" var="persons">
				<tr>
					<td width="30px">${persons.title}</td>
					<td width="150px">${persons.firstName}</td>
					<td width="150px">${persons.lastName}</td>
					<td width="40px">${persons.gender}</td>
					<td width="40px">
						<select name="department">
							<c:forEach var="item" items="${personType}">
						        <option value="${item.key}" ${item.value == persons.type ? 'selected="selected"' : ''}>${item.key}</option>
						    </c:forEach> 
						</select>
					</td>
					<td>
						<spring:url value="/person/location?id=${persons.id}&update_id=0" var="addEditLocation" />
						<a type="button" class="btn btn-default glyphicon glyphicon-pencil" href="${addEditLocation}" title="Edit Location">
					</td>
					<td>
						<spring:url value="/person/phone?id=${persons.id}&update_id=0" var="addEditContact" />
						<a type="button" class="btn btn-default glyphicon glyphicon-pencil" href="${addEditContact}" title="Edit Contact">
					</td>
					<td>
						<spring:url value="/person/email?id=${persons.id}&update_id=0" var="addEditEmail" />
						<a type="button" class="btn btn-default glyphicon glyphicon-pencil" href="${addEditEmail}" title="Edit Email">
					</td>
					<td width="40px">${persons.status}</td>
					<td align="right">
						<spring:url value="/person/update?id=${persons.id}" var="updatePerson" />
						<a type="button" class="btn btn-primary"
							href="${updatePerson}">Update</a>
							
							
							<div id="myModal_${persons.id}" class="modal fade">
							    <div class="modal-dialog">
							        <div class="modal-content">
							            <div class="modal-header">
							                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							                <h4 class="modal-title">Confirm Delete</h4>
							            </div>
							
							            <div class="modal-body">
							                <p>Are you sure you want to delete this Person Record? </p>
							            </div>
							            <div class="modal-footer">
											<spring:url value="/person/delete?id=${persons.id}" var="deletePerson" />
							                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
							                <a type="button" class="btn btn-warning" href="${deletePerson}" title="Delete"><i class="fa fa-trash-o"></i>Delete</a>
							            </div>
							        </div>
							    </div>
							</div> 
							
							
						<a href="#myModal_${persons.id}" role="button" class="btn btn-large btn-primary btn-warning" data-toggle="modal">Delete</a>

					</td>
				</tr>
			</c:forEach>
			
		</table>
	</form:form>
 
	
</div>
<script type="text/javascript">
	function myFunc() {
    var  selectedValue= $("#categoryId").val();
    alert(selectedValue);
   }
</script>

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