<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>ExerciseData</title>
    <link rel="stylesheet" type="text/css" href="../style/main.css">

</head>
<body>
<h1>Book Details</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Name</th>
        <th width="120">Description</th>
    </tr>
    <tr>
        <td>${exercise.id}</td>
        <td>${exercise.name}</td>
        <td>${exercise.description}</td>
    </tr>
</table>
</body>
</html>