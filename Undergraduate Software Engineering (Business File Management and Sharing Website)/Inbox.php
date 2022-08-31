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

    <title>Inbox</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <link href="https://fonts.googleapis.com/css?family=Barlow&display=swap" rel="stylesheet">

    </head>

    <body>
    <div class = "navBar">
    <div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="Landing.php">Landing</a>
    <a href="InboxSentDocuments.php">View sent documents</a>
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
    
    <h2 style = "margin-left: 600px; margin-top: 80px">Inbox</h2>
    


    <?php //database connection variables for a typical local development
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
            
        $sql = "SELECT Username, TheDateTime, DocumentTitle FROM inbox WHERE Username = '$theuser' ORDER BY Id DESC";
        ?>

        <?php
            foreach($conn->query($sql, PDO::FETCH_ASSOC) as $row){
        ?>

        <table style = "margin-left: 350px; width: 600px; text-align: center; border-width: thin;">
        <br>
        <tr data-href="">
        <td><?php echo 'Date: ' . $row['TheDateTime'] . '<br>'; ?></td>
        </tr>
        <tr data-href="">
        <td><?php echo 'Username: ' . $row['Username'] . '<br>'; ?></td>
        </tr>
        <tr data-href="">
        <td><?php echo 'Title: ' . $row['DocumentTitle'] . '<br>'; ?></td>
        </tr>
        <br>
        </table>

        <?php
        }
        ?>

         
        <div class = "composeContainer">

        <div class="row">


    <div class="col-75">
            <h2 style= "margin-left: 600px;">Documents</h2>
            <br>
            <form method="POST" action="ViewDocument.php">
            <select style= "font-weight: bold; margin-left: 600px; transform: translate(-0%, -0%); position: fixed; width: 270px;" name="document">
            <?php
            foreach($conn->query($sql, PDO::FETCH_ASSOC) as $row){
            ?>
            <?php echo'<option  value= "'. $row['DocumentTitle'] .'">'.$row['DocumentTitle'].'</option>'?>;
            <?php
            }
            ?>
            </select>
            <br>
            <br>
            <br>
            <br>
    <button type="button" id="Sent" class = "b1" name="Sent" placeholder="Send documents" style= "font-weight: bold; margin-left: 600px; transform: translate(-0%, -0%); position: fixed; width: 270px;" onclick="location.href = 'InboxSentDocuments.php';">View Sent Documents</button>
            <br>
            <br>
            <br>
    <button type="submit" id="View" class = "b2" name="View" placeholder="View documents" style= "font-weight: bold; margin-left: 600px; transform: translate(-0%, -0%); position: fixed; width: 270px;">View Document</button>
            </form>        
            <br>
            <br>
            <br>
    <button type="button" id="Submit" class = "b3" name="Submit" placeholder="Compose documents" style= "font-weight: bold; margin-left: 600px; transform: translate(-0%, -0%); position: fixed; width: 270px;">Compose Document</button>
            <br>
            <br>                   
                            
    </div>

    <?php
        }
        catch(PDOException $e)
        {
        echo $sql . "<br>" . $e->getMessage(); //If we are not successful we will see an error
        }
        ?> 
                   
    </div>        
    </div>

    
        <script>
            jQuery(document).ready(function($) {
                $('*[data-href]').on('click', function() {
                    window.location = $(this).data("href");
                });
            });
        </script>


        <?php //database connection variables for a typical local development
        $servername = "localhost";
        $username = "root";
        $password = "usbw";
        $database = "project"; //database name that you have already created that you want to connect to
        $port = 3307; // new addition of port number for usbwebserver to work

        $theuser = $_SESSION["username"];

        try {
                if($_SERVER['REQUEST_METHOD'] == 'POST') //has the user submitted the form
                        {
        $conn = new PDO("mysql:host=$servername;port=$port;dbname=$database", $username, $password); //building a new connection object
        // set the PDO error mode to exception
        $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        //Selecting multiple rows from a MySQL database using the PDO::query function.

        $Document = $_POST["document"];

        sleep(5);
        header("Location: ViewDocument.php");
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
