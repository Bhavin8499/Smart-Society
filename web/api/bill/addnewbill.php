<?php

header("Content-type: application/json; charset=utf-8");
include("../../config.php");

$required_params = [];//["user_id", "uploader_id", "bill_name", "bill_amount", "img"];

foreach ($required_params as $value) {
    if(!key_exists($value, $_POST)){
        $error = new SmartCityError(PostDataItemNotFound, $value." is not provided");
        $res = new Response(FALSE, $error);
        $res->print_response();
        return;
    }
}

$args = [
    "user_id" => $_POST["user_id"],
    "uploader_id" => $_POST["uploader_id"],
    "bill_name" => $_POST["bill_name"],
    "bill_amount" => $_POST["bill_amount"]
];


$demo = "bill-".time().".jpg";


move_uploaded_file($_FILES["img"]["tmp_name"], BILL_IMAGE_PATH.$demo)
/*
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
*/

?>