<?php
// Start the session
session_start();
?>

<!DOCTYPE html>
<html>
<head>
      <meta charset="utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <title>View document page</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
      <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
      <link href="https://fonts.googleapis.com/css?family=Barlow&display=swap" rel="stylesheet">
</head>

    

</head>
<body>
                <div class = "navBar">
                <div id="mySidenav" class="sidenav">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                <a href="Inbox.php">Inbox</a>
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


                <div class="grid-container" style = "margin-top: 100px;">

                <?php //database connection variables for a typical local development
                 $servername = "localhost";
                 $username = "root";
                 $password = "usbw";
                 $database = "project"; //database name that you have already created that you want to connect to
                 $port = 3307; // new addition of port number for usbwebserver to work
        

                 try {
                 $conn = new PDO("mysql:host=$servername;port=$port;dbname=$database", $username, $password); //building a new connection object
                 // set the PDO error mode to exception
                 $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                 //Selecting multiple rows from a MySQL database using the PDO::query function.

                 $documentname = $_POST["document"];
                 $sentdocumentname = $_POST["sentdocument"];
                 $theuser = $_SESSION["username"];
            
                 $sql = "SELECT ModifiedBy, TheDate, TheTime, DocumentNotes FROM document_info WHERE 	DocumentTitle = '$documentname' OR 	DocumentTitle = '$sentdocumentname';";

                 foreach($conn->query($sql, PDO::FETCH_ASSOC) as $row){
                 ?> 

                <div class="top-left-area" style = "margin-left: 200px;">
                    <ul style="list-style-type:none;">
                    <li><p><?php echo 'Modified By: ' . $row['ModifiedBy'] . '<br>'; ?></p></li>
                    <li><p><?php echo 'Date: ' . $row['TheDate'] . '<br>'; ?></p></li>
                    <li><p><?php echo 'Time: ' . $row['TheTime'] . '<br>'; ?></p></li>
                    <li><p><?php echo 'Notes: ' . $row['DocumentNotes'] . '<br>'; ?></p></li>
                    <br><br><br>
                    </ul>
                </div>

                <?php
                  }
                  }
                  catch(PDOException $e)
                  {
                  echo $sql . "<br>" . $e->getMessage(); //If we are not successful in connecting or running the query we will see an error
                  }
                  ?>

                 <?php //database connection variables for a typical local development
                 $servername = "localhost";
                 $username = "root";
                 $password = "usbw";
                 $database = "project"; //database name that you have already created that you want to connect to
                 $port = 3307; // new addition of port number for usbwebserver to work
        

                 try {
                 $conn = new PDO("mysql:host=$servername;port=$port;dbname=$database", $username, $password); //building a new connection object
                 // set the PDO error mode to exception
                 $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                 //Selecting multiple rows from a MySQL database using the PDO::query function.
            
                 $sql = $conn->prepare("SELECT inbox.DocumentTitle, inbox_sent.DocumentTitle FROM inbox INNER JOIN inbox_sent ON inbox.Username=inbox_sent.Username;");

                 $sql -> execute(); //execute the statement
                 ?>

                    <div class="header-area" style = "margin-left: 150px;">
                    <table>
                    <tbody><tr>
                    <td>Sender</td>
                    </tr>
                    <tr>
                    <td>Title</td>
                    </tr>
                    <tr>
                    <td height="280">Body<iframe src = "http://localhost/phpfinished/User_documents/<?php echo $documentname;?><?php echo $sentdocumentname;?>.txt" width = "555" height = "200"></iframe></td>
                    </tr>
                    </tbody></table>
                    </div>

                    <div class="top-right-area">
                    <button type="button" id="Inbox" name="Inbox" placeholder="Inbox" style= "font-weight: bold; margin-left: 140px; transform: translate(-0%, -0%); width: 270px;" onclick="location.href = 'Inbox.php';">Inbox</button>
                    <br>
                    <button type="button" id="View" name="View" placeholder="Sent inbox documents" style= "font-weight: bold; margin-left: 140px; transform: translate(-0%, -0%); width: 270px;" onclick="location.href = 'InboxSentDocuments.php';">Sent documents Inbox</button>
                    <br>
                    </div>

                    <div class="view-document"></div>

                    <div class="left-timeline">
            
                    </div>

                    <div class="right-timeline"></div>



                    <div class="left-footer"></div>
                    <div class="main-footer"></div>
                    <div class="right-footer"></div>
                    </div>

                    <?php
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