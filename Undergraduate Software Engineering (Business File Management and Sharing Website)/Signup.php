<!DOCTYPE html>
<html>


  <head>
      <meta charset="utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <title>Signup Page</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
      <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
      <link href="https://fonts.googleapis.com/css?family=Barlow&display=swap" rel="stylesheet">
  </head>


  <body>
  <div class = "navBar">
  <div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="login.php">Login</a>

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


   <img src="logo.JPG" class="logoimage" style= "margin-left: 780px;">


   <div class="d-flex justify-content-center align-items-center main-container flex-column">

   <p class = "header">Create your account</p>

   <div class="col-md-4 ml-auto mr-auto mt-5">
  
   <form class = "form" name="usersignup" action="" method="POST">
   
   <div class="form-group">
   <label for="username">Username</label>
   <input type="text" class="form-control" id="username" name="username" aria-describedby="emailHelp" required>
   </div>
   <div class="form-group">
   <label for="firstname">First Name</label>
   <input type="text" class="form-control" id="Firstname" name="firstname" aria-describedby="emailHelp" required>
   </div>
   <div class="form-group">
   <label for="surename">Surname</label>
   <input type="text" class="form-control" id="Secondname" name="secondname" aria-describedby="emailHelp" required>
   </div>
   <div class="form-group">
   <label for="emailaddress">Email Address</label>
   <input type="email" class="form-control" id="Email" name="email" aria-describedby="emailHelp" required>
   </div>
   <div class="form-group">
   <label for="password">Password</label>
   <input type="password" class="form-control" id="Password" name="password" aria-describedby="emailHelp" required>
   </div>
   <div class="text-center">
   <button type="submit" id ="search" class="btn btn-primary">Create Account</button>
   </div>
   <div>
   <a href="Login.php">Already Registered? Login</a>
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
                $keyword2 = $_POST['firstname']; // your search keyword from the search form
                // password the user submitted from $_POST
                $keyword3 = $_POST['secondname']; // your search keyword from the search form
                // name the user submitted from $_POST
                $keyword4 = $_POST['email']; // your search keyword from the search form
                // name the user submitted from $_POST
                $keyword5 = $_POST['password']; // your search keyword from the search form
                // name the user submitted from $_POST

                    $sql = "INSERT INTO userdetails (Id, Usertype, Username, Firstname, Secondname, Email, Passwords) VALUES ('', 'user', '$keyword1', '$keyword2', '$keyword3', '$keyword4', '$keyword5' )"; // building a string with the SQL INSERT you want to run
                    
                    // use exec() because no results are returned
                    $conn->exec($sql);
                    echo "<br /> New table record created successfully <br />"; // If successful we will see this
                    //redirect the user to a page we want them to go to. 
                    header("Location:login.php"); /* Redirect browser */
                    exit();
                    
                }
                }
                catch(PDOException $e)
                    {
                    echo $sql . "<br>" . $e->getMessage(); //If we are not successful we will see an error
                    }
                
                    
        ?>


    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script> 
  
  
  </body>
</html>