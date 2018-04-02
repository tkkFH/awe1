<html>
  <head>
    <title> Hello World JSP </title>
  </head>
  <body>
    <h1> Meine erste JSP </h1>
    
    <img src="static/fhdw.jpg" />
    <%
      // beliebiger Java-Code ...
      out.println( "Hallo" );
    %>
    <%= request.getParameter("name")  %>
    ...
  </body>
</html>