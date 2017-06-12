<%-- 
    Document   : welcome
    Created on : Jun 11, 2017, 11:19:44 AM
    Author     : manish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to GENPharma</title>
        <style>
            body{
                background-color: cornflowerblue;
            }
            #register{
                width: 380px;
                border: 2px solid black;
                padding: 20px;
                
            }
           #register td{
                padding:10px;
            }
            #container{
                float:right;
                        }
            div{
                margin:10px;
            }
            #login{
                width: 700px;
                padding: 20px;
                border: 2px solid black;
                  }
                   .error{
                      color:red;
                      font-style: italic;
                      column-span: all;
                  }
        </style>

    </head>
    <body>
       
        <h1 style="text-align:center">Generic Pharmaceuticals Inc. </h1>
        <div id="container">
        <div id="login" >
            
            <form method="post" action="login">
                <table>
                    <tr>
                        <td>Choose Role</td>
                        <td>
                            <select name="role">
                                <option value="">Select Any...</option>
                                <option value="FSO">FSO</option>
                                <option value="Supervisor">Supervisor</option>
                                <option value="Employee">Employee</option>
                                
                            </select>
                        </td>
                        <td>Email Id</td>
                        <td><input type="email" name="emailid"></td>
                        <td>Password</td>
                        <td><input type="password" name="password"></td>
                        <td><input type="submit" value="Login"></td>
                    </tr>
                </table>
                
            </form>
            
        </div>
            <hr/>
                <div id="register">
                    <span class="error">  ${requestScope.registerError}</span>
            <h2 style="text-align: center"> New User </h2>
            <form method="post" action="register">
                <table>
                    <tr>
                         <td>Choose Role</td>
                        <td>
                            <select name="role">
                                <option value="">Select Any...</option>
                                <option value="FSO">FSO</option>
                                <option value="Supervisor">Supervisor</option>
                                <option value="Employee">Employee</option>
                                
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="fname"></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lname"></td>
                    </tr>
                    <tr>
                        <td>Email Id</td>
                        <td><input type="email" name="emailid"></td>
                    </tr>
                    <tr>
                        <td>Gender </td>
                        <td><input type="radio" name="gender" value="M"> Male 
                        <input type="radio" name="gender" value="F">Female
                        </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td>Confirm Password</td>
                        <td><input type="password" name="confirm"></td>
                    </tr>
                    <tr>
                        <td></td><td class="error">${requestScope.passwordError}</td></tr>
                    <tr><td></td>
                        <td><input type="submit" value="Register"></td>
                    </tr>
                    
                    
                </table>
                
            </form>
        </div>
        </div>

    </body>
</html>
