<?php
// Start the session
session_start();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Landing</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <link href="https://fonts.googleapis.com/css?family=Barlow&display=swap" rel="stylesheet">

</head>

<body>

    <div class = "navBar">
    <div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="EditDetails.php">Edit Details</a>
    <a href="SendMessage.php">Compose Message</a>
    <a href="SendDocument.php">Send Documents</a>
    <a href="Inbox.php">Inbox</a>
    <a href="login.php">Sign out</a>
    
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


     <?php
   
        
        //database connection variables for a typical local development
        $servername = "localhost";
        $username = "root";
        $password = "usbw";
        $database = "project"; //database name that you have already created that you want to connect to
        $port = 3307; // new addition of port number for usbwebserver to work

        $theuser = $_SESSION["username"];

        try {
            $conn = new PDO("mysql:host=$servername;port=$port;dbname=$database", $username, $password); //building a new connection object
            // set the PDO error mode to exception
            $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            //Selecting multiple rows from a MySQL database using the PDO::query function.

            $sql = "SELECT Firstname, Username, Email FROM userdetails WHERE Username = '$theuser' ORDER BY Id DESC";



            foreach($conn->query($sql, PDO::FETCH_ASSOC) as $row){


      ?>
        <div class = "composeContainer">
        <form class = "form" name = "landing" action="" method="POST">
        <div class="row">
        <div class="col-25">
        <label for="name" style="font-weight: bold;" >Name:</label>
        <label for="nameans" style="display: inline;"> <?php echo ' ' . $row['Firstname'] . '<br>'; ?> </label>
        </div>
                
        <div class="col-75">
        <button type="button" id="inb" name="Inbox" placeholder="Inbox" style="float: right; font-weight: bold;" onclick="location.href = 'Inbox.php';">Inbox</button>
        </div>
        </div>
        <div class="row">
        <div class="col-25">
        <label for="Uname" style="font-weight: bold;" >Username:</label>
        <label for="usernameans" style="display: inline;"> <?php echo ' ' . $row['Username'] . '<br>'; ?> </label>
        </div>
                
        <div class="col-75">
        <button type="button" id="Snd" name="Send" placeholder="Send documents"style="float: right; font-weight: bold;" onclick="location.href = 'SendDocument.php';">Send document</button>
        </div>
        </div>   
        <div class="row">
        <div class="col-25">
        <label for="Email" style="font-weight: bold;" >Email:</label>
        <label for="emailans" style="display: inline;"> <?php echo ' ' . $row['Email'] . '<br>'; ?> </label>
        </div>
                
        <div class="col-75">
        <button type="button" id="Cmp" name="Compose" placeholder="Compose message"style="float: right; font-weight: bold;" onclick="location.href = 'SendMessage.php';">Compose message</button>
        </div>
        </div>
        <div class="row">
        <div class="col-25">
        <label for="Profile" style="font-weight: bold;" >Profile picture:</label>
                
        <input class = "attach" id = "attach" type="file" id = "image" style="transform: translate(50%, -140%);" name="files[]" multiple ><br>
        </div>
      
        <div class="col-75">
        <button type="button" id="Edt" name="Edit" placeholder="Edit account details"style="float: right; font-weight: bold;" onclick="location.href = 'EditDetails.php';">Edit details</button>
        </div>
        </div>
    
        </form>
        </div>

        <?php



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