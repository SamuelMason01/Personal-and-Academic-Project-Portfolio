<?php
// Start the session
session_start();
?>

<!DOCTYPE html>
<html>
<head>
      <meta charset="utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <title>Login Page</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
      <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
      <link href="https://fonts.googleapis.com/css?family=Barlow&display=swap" rel="stylesheet">
</head>

  <body>

  <div class = "navBar">
  <div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="Signup.php">Signup</a>
  </div>
  <span id= "menuButton" onclick="openNav()">&#9776;</span>
  <script>
  function openNav() {
        document.getElementById("mySidenav").style.width = "250px";
  }
        
  function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
  }
  </script>
  <label for="note" class="checkSignIn">Signed in</label>
  <img src="avatar-372-456324.png" alt="Avatar" class="avatar">
  </div>


   <img src="logo.JPG"  class="logoimage" style= "margin-left: 780px;">

  
   <div class="d-flex justify-content-center align-items-center main-container flex-column">

   <p class = "header">Log into your account</p>

   <div class="col-md-4 ml-auto mr-auto mt-5">
   
    <form class = "form" name="userLogin" method="POST">

    <div class="form-group">
    <label for="exampleInputEmail1">Username</label>
    <input type="text" class="form-control" id="username" name="username" aria-describedby="emailHelp" required>
    </div>
    <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="password" name="password" aria-describedby="emailHelp" required>
    </div>
    <div class="text-center">
    <button type="submit" id ="search" class="btn btn-primary">Sign In</button>
    </div>
    <div>
    <a href="Signup.php">Create an account</a>
    </div>

    </form>
    </div>     
    </div>



    <?php
        
            //database connection variables for a typical local development
         $servername = "localhost";
         $username = "root";
         $password = "usbw";
         $database = "project"; //database name that you have already created that you want to connect to
         $port = 3307; // new addition of port number for usbwebserver to work
        
        try {
            if($_SERVER['REQUEST_METHOD'] == 'POST') //has the user submitted the form
            {
                
              $conn = new PDO("mysql:host=$servername;port=$port;dbname=$database", $username, $password); //building a new connection object
              // set the PDO error mode to exception
              $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                
                $keyword1 = $_POST['username']; // your search keyword from the search form
                // email the user submitted from $_POST
                $keyword2 = $_POST['password']; // your search keyword from the search form
                // password the user submitted from $_POST

                
                //preparing an sql statement to search email and password for whatever the user has typed and be equal to an admin user
                $sql = $conn->prepare("SELECT * FROM userdetails WHERE Username = ? AND Passwords = ?");
                $sql -> bindValue(1, "$keyword1"); //we bind this variable to the first ? in the sql statement
                $sql -> bindValue(2, "$keyword2"); //we bind this value to the second ? in the sql statement
                $sql -> execute(); //execute the statement
                
                if($sql->rowCount())  
                
                    { //check if we have results by counting rows
                    $row = $sql->fetch();
                   
                    //fetch the results form the table
                
                    if($row['Usertype'] == 'user') {

                        
                        //set session login variable here
                        $_SESSION["Usertype"] = "user";
                        $_SESSION["username"] = "$keyword1";
                        $_SESSION["Passwords"] = "$keyword2";
                        
                        echo "user Session variables are set.";

                        sleep(10);

                        header("Location: Landing.php");

                        exit();
                    }
                }
                else
                {
                        //message to display if we did not match a user
                        echo 'no rows returned, your details did not match';
                }
                
                }

                }
                catch(PDOException $e)
                {
                        echo $sql . "<br>" . $e->getMessage(); //If we are not successful in connecting or running the query we will see an error
                }
        ?>


    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script> 
  
  
  </body>
</html>