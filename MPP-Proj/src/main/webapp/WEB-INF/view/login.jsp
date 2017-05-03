<%@ include file="/resources/common/header.jspf"%>
<div align = "center" class="container" style="margin:10% auto; 
	padding: 25 25; width:400px; border-radius: 25px;
	border:2px solid #73AD21; background: url(paper.gif);">

	<div class="details">
		<h1>Authentication</h1>
	</div>

	<form action="/login" method="post">

		<div >
			<table>
				<tr>
					<td style="width:90px"><label>Username</label></td>
					<td width="10px">:</td>
					<td>
						<div>
							<input type="text" class="style-4" name="username"
								placeholder="User Name" />
						</div>
					</td>
				</tr>
				<tr>
					<td style="width:90px"><label>Password</label> </td>
					<td>:  </td>
					<td>
						<div>
							<input type="password" class="style-4" name="password"
								placeholder="Password" />
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="3" align="right">
						<div>
							<br/>
							<button type="submit" class="btn btn-success" style = "width:120px">Sign In</button>
							<!-- <input type="submit" value="Sign In" class="button red small" />-->
						</div>
					</td>
				</tr>
			</table>
			
			
			
			<c:if test="${param.error ne null}">
				<div class="alert-danger">Invalid username and password.</div>
			</c:if>
			<c:if test="${param.logout ne null}">
				<div class="alert-normal">You have been logged out.</div>
			</c:if>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</div>

<%@ include file="/resources/common/footer.jspf"%>