<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13.12.2019
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Coffee-Machine-ListOfUserProfiles</title>
  </head>
  <body>
    <section>
      <table>
        <caption style="font-weight:bold">UserProfiles parsed by ${parserType}</caption>
        <tr>
          <th>Name</th>
          <th>Surname</th>
          <th>Age</th>
          <th>CreationDate</th>
        </tr>
        <c:forEach var="item" items="${userProfiles}">
          <tr>
            <td><c:out value="${item.getName()}"/></td>
            <td><c:out value="${item.getSurname()}"/></td>
            <td><c:out value="${item.getAge()}"/></td>
            <td><c:out value="${item.getCreationDate()}"/></td>
          </tr>
        </c:forEach>
      </table>
    </section>
  </body>
</html>
