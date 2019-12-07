<%-- 
    Document   : createUser
    Created on : 2 déc. 2019, 19:39:36
    Author     : Pierre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>User registration</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
            <a class="navbar-brand" href="https://github.com/Taranti/LO54">ProjectZ</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                  <a class="nav-link" href="/">Home<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/allCourses">All Courses</a>
                </li>
                <li class="nav-item active">
                  <a class="nav-link" href="/filter">Filters</a>
                </li>
              </ul>
            </div>
        </nav>
        <div class="container-fluid"style="margin-top:100px">
            <div class="row justify-content-md-center">
                <div class="col-md-8">
                    <h1>Sign Up</h1>
                </div>
                <div class="col-md-7">
                    <form action="/register?session=${session}" method="post">
                        First Name:<br>
                        <input type="text" name="firstname" >
                        <br>
                        Last name:<br>
                        <input type="text" name="lastname" >
                        <br>
                        Address:<br>
                        <input type="text" name="address" >
                        <br>
                        Phone Number:<br>
                        <input type="tel" name="phonenumber" pattern="0[0-9]{9}">
                        <br>
                        Email:<br>
                        <input type="email" name="mail">
                        <br><br>
                        <input type="hidden" name="session" value=${session}>
                        <input type="submit" value="Submit" class="btn btn-primary">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
