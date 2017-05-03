<%@ include file="/resources/common/header.jspf"%>
<%@ include file="/resources/common/navigation.jspf"%>


<div class="container">

	<spring:url value="/animal/" var="saveAnimal" />

	<form:form modelAttribute="animalForm" method="POST" action="${saveAnimal}">
		<f:hidden path="id" />
		<table>
			<tr>
				<td>Animal Name : </td>
				<td style="width: 200px;padding:10px">
					<f:input path="name" required="required" />
				</td>
				<td style="width: 100px;"></td>
				<td>Animal Gender : </td>
				<td>
					<f:select path="gender" style="margin:10px">
					    
				        <c:forEach items="${listStatus}" var="option">
				                <option value="${option}" ${option == selectedGender ? 'selected="selected"' : ''}>
				                    <c:out value="${option}"></c:out>
				                </option>
				        </c:forEach>
					</f:select>
       			</td>
				
			</tr>
			
			<tr>
				<td>Is Neuter : </td>
				<td style="padding:10px;">
					<f:checkbox path="neutered" />
       			</td>
       			<td style="width: 100px;"></td>
       			<td>Birth Date : </td>
				<td style="width: 20px;padding:10px">
					<f:input path="birth" maxlength="10" type = "date" style="width: 200px" />
				</td>		
			</tr>
			
			<tr>
				<td>Color : </td>
				<td style="width: 20px;padding:10px">
					<f:input path="color" maxlength="10" />
				</td>
				<td style="width: 100px;"></td>
				<td>Is Active : </td>
				<td style="padding:10px;">
					<f:checkbox path="status" />
       			</td>
			</tr>
			<tr>
				<td>Is Deceased : </td>
				<td style="padding:10px;">
					<f:checkbox id="is_deceased" path="is_deceased" />
       			</td>
       			<td style="width: 100px;"></td>
				<td class="myColumn">Deceased : </td>
				<td class="myColumn" style="width: 20px;padding:10px">
					<f:input id="deceased" path="deceased" maxlength="10" type="date" style="width: 200px" 
					  />
				</td>
			</tr>
			
			<tr>
				<td>Specie : </td>
				<td style="width: 200px;padding:10px">
					<f:select id="specie_id" path="specie_id" style="width: 200px" required="required">
						<option value="-1">-- Select Specie --</option>
						<f:options items="${listSpecies}" itemValue="id" itemLabel="description"/>
       				</f:select>
				</td>
				<td style="width: 100px;"></td>
				<td>Breed : </td>
				<td style="width: 200px;padding:10px">
					<f:select id="breed_id" path="breed_id" style="width: 200px">
						<option value="-1">-- Select Breed --</option>
						<f:options items="${listBreeds}" itemValue="id" itemLabel="description"/>
       				</f:select>
				</td>				
			</tr>
			
			<tr>
				<td>Microchip : </td>
				<td style="width: 200px;padding:10px">
					<f:select id="microchip_id" path="microchip_id" style="width: 200px">
						<option value="-1">-- Select Microchip --</option>
						<f:options items="${listMicrochips}" itemValue="id" itemLabel="description"/>
       				</f:select>
				</td>				
			</tr>
			
			<tr>
				<td><button type="submit" style="margin-top:10px;" class="btn btn-success">Save</button></td>
			</tr>
		</table>
	</form:form>
 
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Animal Name</th>
			<th>Gender</th>
			<th>Is Neutered</th>
			<th>Birth Date</th>
			<th>Deceased</th>
			<th>Color</th>
			<th>Specie</th>
			<th>Breed</th>
			<th>Microchip</th>
			<th>Is Active</th>
			<th colspan="2"> Action</th>
		</tr>
		<c:forEach items="${listAnimal}" var="animal">
			<tr>
				<td>${animal.id}</td>
				<td>${animal.name}</td>
				<td>${animal.gender}</td>
				<td>${animal.neutered}</td>
				<td>${animal.birth}</td>
				<td>${animal.deceased}</td>
				<td>${animal.color}</td>
				<td>${animal.specie.description}</td>
				<td>${animal.breed.description}</td>
				<td>${animal.microchip.description}</td>
				<td>${animal.status}</td>				
				
				<td>
					<spring:url value="/animal/update?id=${animal.id}" var="updateAnimal" />
					<a type="button" class="btn btn-primary"
						href="${updateAnimal}">Update</a>
					<spring:url value="/animal/delete?id=${animal.id}" var="deleteAnimal" />
					<a type="button" class="btn btn-warning"
						href="${deleteAnimal}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<%@ include file="/resources/common/footer.jspf"%>
<script>
	$(document).ready(function () {
		
		$( ".myColumn").css({'visibility': 'hidden'});
		$( "#deceased" ).val('2016-01-01');
		var url = window.location;
	    $('ul.nav > li').removeClass('active');
	    $('ul.nav a[href="'+ url +'"]').parent().addClass('active');
	    $('ul.nav a').filter(function() {
	         return this.href == url;
	    }).parent().addClass('active');    
	   	   
	   $( "#is_deceased" ).click(function() {
		   
		   if( $(this).is(':checked') ){
		        $( ".myColumn").css({'visibility': 'visible'}); 
		    } else {
		    	$( ".myColumn").css({'visibility': 'hidden'}); 
		    	$( "#deceased" ).val('2016-01-01');    	
		    }		   			   
		   
	   });
	});
			
	
</script>
