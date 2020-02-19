<?php
session_start();
unset($_SESSION["client_id"]);
if(session_destroy()){
echo "<script>
	alert('Logout Succefully')
	
	</script>";
	header("Location:index");
 }
	else{
header("Location:index1");
	}
?>