<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request객체 예제</title>
</head>
<body>
	<h2>Request 연습 Form(숫자 입력은 정수형으로 입력하세요.)</h2>
	<form action="/testWeb/requestTest02.do">
		<input type="text" size="10" name="number1">
		<select name="op">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
			<option value="%">%</option>
		</select>
		<input type="text" size="10" name="number2">
		<input type="submit" value="확인">
	</form>
</body>
</html>