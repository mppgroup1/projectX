<%@ include file="/resources/common/header.jspf"%>
<%@ include file="/resources/common/navigation.jspf"%>


<div class="container">

	<spring:url value="/person/phone?pid=${pid}" var="savePhone" />

	<form:form modelAttribute="phoneForm" method="POST" action="${savePhone}">
		<h3>${personName} ADDRESS(es) INFO:</h1><h2 style="display:none">"${pid}"</h3>
		<f:hidden path="id" />
		<f:hidden path="pid" />
		<table>
			<tr>
				<td>Area Code</td><td width="10px"><td width="15px">:</td>
				<td style="width: 200px;padding:10px">
					<div><f:input path="areacode" placeholder="999"  /></div>
				</td>
				
			</tr>
			<tr>
				<td>Telephone</td><td/><td>:</td>
				<td style="width: 200px;padding:10px">
					<div><f:input path="telephone" class="style-4" placeholder="9999999"  /></div>
				</td>
			</tr>
			<tr>
				<td>Primary</td><td/><td>:</td>
				<td style="width: 200px;padding:10px">
					<f:radiobuttons path="primary" items="${phonePrimary}" itemValue="value" itemLabel="key"/> 
       			</td>		
			</tr>
			
			<tr>
				<td>
					<spring:url value="/person" var="back" />
					<a type="button" class="btn btn-primary" href="${back}">Back</a>
				</td>
				<td colspan="3" align="right">
					<button type="submit" class="btn btn-success">Save</button>
					<spring:url value="/person/phone?id=${pid}&update_id=0" var="cancel" />
					<a type="button" class="btn btn-warning"
						href="${cancel}">Cancel</a>
				</td>
			</tr>
		</table>
	</form:form>
 
	<table class="table table-striped">
		<tr>
			<th>Area Code</th>
			<th>Phone Number</th>
			<th>Primary</th>
			<th align="right"></th>
		</tr>
		<c:forEach items="${listPhones}" var="phones">
			<tr>
				<td>${phones.areacode}</td>
				<td>${phones.telephone}</td>
				<td>${phones.primary}</td>
				
				<td align="right">
						<spring:url value="/person/phone?id=${pid}&update_id=${phones.id}" var="updatePhone" />
						<a type="button" class="btn btn-primary" href="${updatePhone}">Update</a>
							
							
							<div id="myModal_${phones.id}" class="modal fade">
							    <div class="modal-dialog">
							        <div class="modal-content">
							            <div class="modal-header">
							                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							                <h4 class="modal-title">Confirm Delete</h4>
							            </div>
							
							            <div class="modal-body">
							                <p>Are you sure you want to delete this Phone Record? </p>
							            </div>
							            <div class="modal-footer">
											<spring:url value="/person/phone/delete?id=${phones.id}&pid=${pid}" var="deletePhone" />
							                <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
							                <a type="button" class="btn btn-warning" href="${deletePhone}" title="Delete"><i class="fa fa-trash-o"></i>Delete</a>
							            </div>
							        </div>
							    </div>
							</div> 
							
							
						<a href="#myModal_${phones.id}" role="button" class="btn btn-large btn-primary btn-warning" data-toggle="modal">Delete</a>

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
