<%-- 
    Document   : empProfile
    Created on : Jun 12, 2017, 10:01:41 AM
    Author     : manish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class = "company"> <h1>Generic Pharamceuticals</h1></div>
        <div class="profile">
            <h3>Employee Profile</h3>
            <table>
                <tr><td>Name </td><td>${requestScope.user.firstName}&nbsp;&nbsp;${requestScope.user.lastName}</td></tr>
                <tr><td>EmailId</td><td>${requestScope.user.emailId}</td></tr>
                <tr><td>Gender</td><td>${requestScope.user.gender}</td></tr>
            </table>
        </div>
            <div>
                <a href="newVoucher.jsp" target="empFrame">New Voucher</a>
                <a href="showAllVouchers.jsp" target="empFrame">Show All Vouchers</a>
            </div>
            
            <div>
                <iframes>
                    <iframe width="90%" height="600" name="empFrame" src="newVoucher.jsp"></iframe>
                </iframes>
            </div>
    </body>
</html>
