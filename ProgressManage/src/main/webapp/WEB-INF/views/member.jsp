<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="fixed.jsp"%>
<!-- page content -->
<div class="right_col" role="main">
	<form:form modelAttribute="userVO" enctype="multipart/form-data" method="POST">
		<table>
			<tr>
				<td colspan="2" style="color: red;"><form:errors path="*"
						cssStyle="color : red;" /> ${errors}</td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input type="file" path="file" name="file"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Upload File" /></td>
			</tr>
		</table>
	</form:form>
</div>
<!-- /page content -->
<%@include file="fixed_footer.jsp"%>