<?php

header("Content-type: application/json; charset=utf-8");
include("../../config.php");

$required_params = ["maintance_name", "maintance_date", "price", "user_id", "society_id"];

foreach ($required_params as $value) {
    if(!key_exists($value, $_POST)){
        $error = new SmartCityError(PostDataItemNotFound, $value." is not provided");
        $res = new Response(FALSE, $error);
        $res->print_response();
        return;
    }
}

$args = [
    "maintance_name" => $_POST["maintance_name"],
    "maintance_date" => $_POST["maintance_date"], 
    "price" => $_POST["price"],
    "uploader_id" => $_POST["user_id"],
    "society_id" => $_POST["society_id"]

];

$qry = generate_insert_query($args, TABLE_MAINTANCE);
$db = Database::getInstance();

$affect = $db->run_query($qry);

if($affect < 1){
    $res = new Response(false, "Failed to Add Maintance details\n".$db->get_last_error());
    echo json_encode($res);
    return;
}


$args = [
    "maintance_id" => $affect,
    "maintance_name" => $_POST["maintance_name"],
    "maintance_date" => $_POST["maintance_date"], 
    "price" => $_POST["price"],
    "uploader_id" => $_POST["user_id"],
    "society_id" => $_POST["society_id"]
];

$res = new Response(true, $args);
    echo json_encode($res);
    return;


?>