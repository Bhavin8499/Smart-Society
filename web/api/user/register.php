<?php

header("Content-type: application/json; charset=utf-8");
include("../../config.php");


$required_params = ["name", "email", "password", "phoneno", "role"];

foreach ($required_params as $value) {
    if(!key_exists($value, $_POST)){
        $error = new SmartCityError(PostDataItemNotFound, $value." is not provided");
        $res = new Response(FALSE, $error);
        $res->print_response();
        return;
    }
}

$_POST["password"] = md5($_POST["password"]);
$args = [
    "name" => $_POST["name"],
    "email" => $_POST["email"], 
    "password" => $_POST["password"],
    "phoneno" => $_POST["phoneno"], 
    "role" => $_POST["role"]

];

$qry = generate_insert_query($args, TABLE_USER);
$db = Database::getInstance();
$db->set_auto_commit(false);
$affect = $db->run_query($qry);

if($affect < 1){
    $db->rollback();
    $res = new Response(false, "Failed to register user");
    echo json_encode($res);
    return;
}


$args = [
    "user_id" => $affect,
    "name" => $_POST["name"],
    "email" => $_POST["email"],
    "phoneno" => $_POST["phoneno"], 
    "role" => $_POST["role"]
];

if($_POST["role"] == "Admin"){

    $n=8; 
        $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'; 
        $randomString = ''; 
      
        for ($i = 0; $i < $n; $i++) { 
            $index = rand(0, strlen($characters) - 1); 
            $randomString .= $characters[$index]; 
        } 
      
    $arg1 = ["societyname" => $_POST["societyname"], "user_id" => $affect, "societycode" => $randomString];

    $db->run_query($arg1, TABLE_SOCIETY);
    
    $args["societycode"] = $randomString;
}
elseif ($_POST["role"] == "Customer") {
    
    $soc_code = $_POST["societycode"];
    $qry = "select id from society where societycode='$soc_code'";

    $res = $db->run_query($qry);

    if(!is_array()){
        $db->rollback();
    }


}

$db->commit();
$db->set_auto_commit(true);


$res = new Response(true, $args);
    echo json_encode($res);
    return;


?>