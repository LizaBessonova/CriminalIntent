<?php
	$con = mysqli_connect("my_host", "my_user","my_password","my_db");
	
	$username = $_POST["username"];
	$password = $_POST["password"];
	
	$statement=mysqli_prepare($con, "SELECT * FROM user WHERE username=? AND password=?");
	mysqli_stmt_store_result($statement);
	mysql_stmt_bind_result($statement,$userID,$name,$age,$username,$password);
	
	$response=array();
	$response["success"]=false;
	
	while(mysqli_stmt_fetch($statment)){
		$response["success"]=true;
		$response["username"]=$username
		$response["password"]=$password;
	}
	
	echo json_encode($response);
?>