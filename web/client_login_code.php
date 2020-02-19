<?php
session_start();
include("connect.php");
$email=$_POST['email'];
$password=$_POST['password'];

$q="select * from client where email='$email' and password='$password'";
$rs=mysqli_query($cn,$q);
if($row=mysqli_fetch_array($rs))
{
	$_SESSION['client_id']=$row[0];
	header("location:index");
		
	
}
else
{
	header("location:client_login.php?msg=n");
}

?>