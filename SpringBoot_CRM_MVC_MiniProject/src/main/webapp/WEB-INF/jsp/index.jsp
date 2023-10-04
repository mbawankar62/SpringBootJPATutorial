<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>

<body>

<i><h2 style="text-align:center;color:DodgerBlue;">Welcome To CRM</h2></i>

<%= new java.util.Date() %><br><br>
<div>
Please visit below link to Register with us.
</div>
<a href="${pageContext.request.contextPath}/customer/list">Get All Customers</a>
<br>
<br>
<br>

<h5 style="text-align:left;">
<i>*Contact Us*<br>
 Mohit Bawankar<br>
Mobile: 7507421288<br>
Email : mbawankar62@gmail.com<br>

</i>
</h5> 

</body>
</html> 

<%-- <% response.sendRedirect("customer/list"); %> --%>