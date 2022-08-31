<?php
// Start the session
session_start();
?>

<!DOCTYPE html>
<html>
  <head>
      <meta charset="utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <title>Edit Details</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
      <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
      <link href="https://fonts.googleapis.com/css?family=Barlow&display=swap" rel="stylesheet">
  </head>
  <body>
    <div class = "navBar">
      <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="Landing.php">Landing</a>

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

        <p class = "header" style = "margin-top: 200px;">Edit your account</p>

        <div class="col-md-4 ml-auto mr-auto mt-5">

        <form class = "form" name="editdetails" method="POST">
        <div class="form-group">
        <label for="username">Current Username</label>
        <input type="text" class="form-control" id="currentusername" name="currentusername" aria-describedby="emailHelp" required>
        </div>
        <div class="form-group">
        <label for="username">New Username</label>
        <input type="text" class="form-control" id="newusername" name="newusername" aria-describedby="emailHelp" required>
        </div>
        <div class="form-group">
        <label for="firstname">First Name</label>
        <input type="text" class="form-control" id="firstname" name="firstname" aria-describedby="emailHelp" required>
        </div>
        <div class="form-group">
        <label for="surename">Surname</label>
        <input type="text" class="form-control" id="surename" name="surename" aria-describedby="emailHelp" required>
        </div>
        <div class="form-group">
        <label for="email">Email Address</label>
        <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" required>
        </div>
        <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password" aria-describedby="emailHelp" required>
        </div>
        <div class="text-center">
        <button type="submit" id ="search" class="btn btn-primary">Edit account</button>     
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
                
   
                //3. Save the POST values of the form to local variables to use in the UPDATE statement
                $currentusername = $_POST["currentusername"]; // your search keyword from the search form

                $newusername = $_POST["newusername"]; // your search keyword from the search form

                $firstname = $_POST["firstname"]; // your search keyword from the search form
                                
                $surename = $_POST["surename"]; // your search keyword from the search form

                $email = $_POST["email"]; // your search keyword from the search form

                $passwords = $_POST["password"]; // your search keyword from the search form       

                //4. Complete the UPDATE statement to include all of the fields
                $sql = $conn->prepare(" UPDATE userdetails SET Username = ?, Firstname = ?, Secondname = ?, Email = ?, Passwords = ? WHERE Username = '$currentusername';
                                        UPDATE inbox SET Username = '$newusername' WHERE Username = '$currentusername';
                                        UPDATE inbox_sent SET Username = '$newusername' WHERE Username = '$currentusername';
                                        UPDATE messages SET Sender = '$newusername' WHERE Sender = '$currentusername';");


                $sql -> bindValue(1, "$newusername"); //we bind this variable to the 1 ? in the sql statement
                $sql -> bindValue(2, "$firstname"); //we bind this variable to the 2 ? in the sql statement
                $sql -> bindValue(3, "$surename"); //we bind this variable to the 3 ? in the sql statement
                $sql -> bindValue(4, "$email"); //we bind this variable to the 4 ? in the sql statement
                $sql -> bindValue(5, "$passwords"); //we bind this variable to the 5 ? in the sql statement
                
                //5. Bind the rest of the values needed
                $sql -> execute(); //execute the statement

                //6. Display a message to the user to say UPDATE has been successful
                echo("your information has been updated successfully, you may now check your information");

                //7. setting updated session variables
                $_SESSION["username"] = "$newusername";
                $_SESSION["Passwords"] = "$passwords";

                echo "user Session variables are set.";

                sleep(10);

                header("Location: Landing.php");

                exit();



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