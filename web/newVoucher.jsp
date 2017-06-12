<%-- 
    Document   : newVoucher
    Created on : Jun 12, 2017, 10:47:47 AM
    Author     : manish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Voucher</title>
        <style>
        h1{
                text-align: center;
            }
            </style>
    </head>
    <body>
       
         <h1> GENERIC PHARMACEUTICALS INC.</h1>
        
        <FORM method="post"  action='VoucherSubmit' enctype="multipart/form-data">
            <table>
                <tr>
                    <td>
                        <h3>Type of Vouchers</h3>
                    </td>
                    <td>
                        <select name="type">
                                <option value="">Please select any ....</option>
                                <option value="LTA">Leave travel Allowance(LTA)</option>
                <option value="CV">Cash Allowance(CV)</option>
            <option value="MA">Medical Allowance(MA)</option>
            <option value="PBR"> Phone bill Reimbursement(PBR)</option>
            <option value="DTVL">Domestic and International travel(DTVL\ITVL)</option>
        </select>
                    </td>
                </tr>
                
                <tr>
                    <td>Date</td>
                    <td>
        <input type="date" name="date">
                    </td>
                </tr>
                
                <tr>
                    <td>Amount</td>
                   <td>
         <input type="text" name="amount">
                    </td>
                </tr>
                
                <tr>
                    <td>
        Description
                    </td>
                    <td>
        <textarea rows="5" cols="50" name="descs">Description</textarea></td>
                </tr>
                
                <tr>
                    <td>
                        Bill No.
                    </td>
                    <td>
                        <input type="text" name="billno"></td>
                </tr>
                
                <tr>
                    <td>
        Upload Document
                    </td>
                    <td>
                        <input type="file" name="document"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="SUBMIT"></td>
                </tr>
        </table>
        </FORM>
        
    </body>
</html>
