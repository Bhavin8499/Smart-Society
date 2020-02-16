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

$affect = $db->run_query($qry);

if($affect < 1){
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

$res = new Response(true, $args);
    echo json_encode($res);
    return;


?>