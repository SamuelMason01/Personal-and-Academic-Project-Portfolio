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
    <title>Send Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <link href="https://fonts.googleapis.com/css?family=Barlow&display=swap" rel="stylesheet">

</head>

<body>
<div class = "navBar">
<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="Landing.php">Landing</a>
    <a href="Inbox.php">Inbox</a>
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


    <div class = "composeContainer">
    <form class = "form" name = "sendDocument" action="" method="post" enctype="" onsubmit= "">
    <div class="row">
        <div class="col-25">
        <label for="To" style="font-weight: bold;">To</label>
        </div>
        <div class="col-75">
        <input type="text" id="Sendto" name="Sendto" placeholder="Send to.....">
        </div>
        </div>
        <div class="row">
        <div class="col-25">
        <label for="Subject" style="font-weight: bold;">Subject</label>
        </div>
        <div class="col-75">
        <input type="text" id="Subject" name="Subject" placeholder="Subject">
        </div>
        </div>
         
        <div class="row">
        <div class="col-25">
        <label for="Message" style="font-weight: bold;">Message</label>
        </div>
        <div class="col-75">
        <textarea id="Message" name="Message" placeholder="Write a message...." style="height:200px"></textarea>
        </div>
        </div>
        <div class="row">
        <input class = "attach" id = "attach" type="file" id = "image" style="transform: translate(0%, -140%);" name="myfile" multiple >
        <br>
        <br>
        <input style = "margin-top: 20px; margin-left: 550px" type="submit" value="Send">
        <br>
        <br>
        </div>

        </form>
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

                $sentto = $_POST['Sendto'];
                $filename = $_POST['myfile'];

                //preparing an sql statement to search email and password for whatever the user has typed and be equal to an admin user
                $sql = $conn->prepare("INSERT INTO inbox (Username, DocumentTitle)
                                       VALUES ('$sentto', '$filename');");
                $sql -> execute(); //execute the statement

                echo "Message has been sent.";

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