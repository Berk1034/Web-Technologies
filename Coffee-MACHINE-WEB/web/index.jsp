<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 13.12.2019
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Coffee-Machine-MainPage</title>
  </head>
  <body>
    <section>
      <h2>Choose Parser:</h2>
      <section>
        <form enctype="multipart/form-data" action="parsing" method="post">
          <input type="file" name="fileXML" accept=".xml"/>
          <br><br>
          <input class="type" type="submit" name="parserType" value="SAX">
          <input class="type" type="submit" name="parserType" value="StAX">
          <input class="type" type="submit" name="parserType" value="DOM">
        </form>
      </section>
    </section>
  </body>
</html>
