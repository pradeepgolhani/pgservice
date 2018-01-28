<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome</title>
    </head>
    <body>
    <center>
        <h3>Enter The Notification Details</h3>
        <form:form method="POST" action="pnotification" modelAttribute="notification">
             <table>
                <tr>
                    <td><form:label path="id">Device Id</form:label></td>
                    <td><form:textarea path="id" cols="45" rows="4" /></td>
                </tr>
                <tr>
                    <td><form:label path="title">Message Title</form:label></td>
                    <td><form:input path="title" /></td>
                </tr>
                <tr>
                    <td><form:label path="messageBody">Message Body</form:label></td>
                    <td><form:textarea path="messageBody" cols="45" rows="4"/></td>
                </tr>
                <tr>
                    <td><form:label path="button1">Button 1</form:label></td>
                    <td><form:input path="button1"/></td>
                </tr>
                <tr>
                    <td><form:label path="button2">Button 2</form:label></td>
                    <td><form:input path="button2"/></td>
                </tr>
                <tr>
                    <td><form:label path="button3">Button 3</form:label></td>
                    <td><form:input path="button3"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
        
        <c:if test="${not empty message}">
    		<h2>${message}</h2>
		</c:if>
        
        </center>
    </body>
    </html>