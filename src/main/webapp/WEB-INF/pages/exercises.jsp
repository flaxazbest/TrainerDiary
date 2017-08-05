<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Inner Books Page</title>
    <link rel="stylesheet" type="text/css" href="../style/main.css">
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Exercise List</h1>

<c:if test="${!empty listExercises}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listExercises}" var="exercise">
            <tr>
                <td>${exercise.id}</td>
                <td><a href="/exercisedata/${exercise.id}" target="_blank">${exercise.name}</a></td>
                <td><a href="<c:url value='/edit/${exercise.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${exercise.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Exercise</h1>

<c:url var="addAction" value="/exercises/add"/>

<form:form action="${addAction}" commandName="exercise">
    <table>
        <c:if test="${!empty exercise.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="description">
                    <spring:message text="Deccription"/>
                </form:label>
            </td>
            <td>
                <form:input path="description"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty exercise.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Exercise"/>"/>
                </c:if>
                <c:if test="${empty exercise.name}">
                    <input type="submit"
                           value="<spring:message text="Add Exercise"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>