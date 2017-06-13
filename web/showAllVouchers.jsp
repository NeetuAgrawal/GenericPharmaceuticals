<%-- 
    Document   : showAllVouchers
    Created on : Jun 12, 2017, 10:48:00 AM
    Author     : manish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show All Vouchers</title>
    </head>
    <body>
        
        <h3> All Vouchers </h3>
        <table>
            <thead>
            <th>Sr. No.</th> 
            <th>Voucher Type</th>
            <th>Date</th>
            <th>Amount</th>
            <th>Description</th>
            <th>Bill No. </th>
            <th>Bill Image</th>
            <th>Status</th>
            </thead>
            <tbody>
                
            </tbody>
            
        </table>
    </body>
</html>

<!--
mysql> select voucher_type,bill_date,amount,uv.description, bill_no,s.description from voucher v,user_voucher uv,
status s where v.voucher_id=uv.voucher_id and s.status_id= uv.status_id order by s.status_id desc;
-->