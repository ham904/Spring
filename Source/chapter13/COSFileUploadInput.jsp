<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>

<form name="fileUp1" method="post" action="cos" enctype="multipart/form-data">

	<table border=1 cellspacing=0 cellpadding=3>
		<tr>
			<td width=60 align=center> 설 명 </td>
			<td width=300> <input type="text" name="comment" size=30> </td>
		</tr>
		<tr>
			<td width=60 align=center> 파일1 </td>
			<td width=300> <input type="file" name="userFile1"> </td>
		</tr>
		<tr>
			<td width=60 align=center> 파일2 </td>
			
			<td width=300> <input type="file" name="userFile2"> </td>
		</tr>				
		<tr>
			<td width=60 align=center colspan=2>
				<input type="submit" value="SAVE">
			</td>
		</tr>
	</table>

</form>
</body>
</html>