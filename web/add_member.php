<?php 
	
	include("connect.php");
	session_start();
	if(isset($_POST['submit']))
	{
		$name=$_POST['name'];
		$gender=$_POST['gender'];
		$age=$_POST['age'];
		
		$q="insert into member(m_name,gender,age) values('$name','$gender',$age)";
		$res=mysqli_query($cn,$q);
		if($res)
		{
			#echo "ok";
			header("location:index");
		}
		else
		{
			echo "not";
		}
	}
			
?>
