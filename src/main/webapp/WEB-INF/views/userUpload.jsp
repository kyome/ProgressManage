<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<title>Insert title here</title>
</head>
<body>

	<form id="excelUploadForm" name="excelUploadForm"
		enctype="multipart/form-data" method="post"
		action="${pageContext.request.contextPath}/userUpload">
		<div class="contents">
			<input id="excelFile" type="file" name="excelFile" />
		</div>

		<div class="bottom">
			<button type="button" id="addExcelImpoartBtn" class="btn"
				onclick="check()">
				<span>추가</span>
			</button>
		</div>
	</form>
</body>
<script type="text/javascript">
	function checkFileType(filePath) {
		var fileFormat = filePath.split(".");
		if (fileFormat.indexOf("xlsx") > -1) {
			return true;
		} else {
			return false;
		}
	}

	function check() {
		var file = $("#excelFile").val();
		if (file == "" || file == null) {
			alert("파일을 선택해주세요.");
			return false;
		} else if (!checkFileType(file)) {
			alert("엑셀 파일만 업로드 가능합니다.");
			return false;
		}

		if (confirm("업로드 하시겠습니까?")) {
			$("#excelUploadForm").submit();
		}
	}
</script>
</html>