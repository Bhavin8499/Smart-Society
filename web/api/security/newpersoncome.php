<?php

header("Content-type: application/json; charset=utf-8");
include("../../config.php");

$required_params = ["name", "flat_id", "reason"];

foreach ($required_params as $value) {
    if(!key_exists($value, $_POST)){
        $error = new SmartCityError(PostDataItemNotFound, $value." is not provided");
        $res = new Response(FALSE, $error);
        $res->print_response();
        return;
    }
}

$args = [
    "name" => $_POST["name"],
    "flat_id" => $_POST["flat_id"],
    "reason" => $_POST["reason"]
];

$qry = generate_insert_query($args, TABLE_SECURITYCOMERS);
$db = Database::getInstance();

$affect = $db->run_query($qry);

if($affect < 1){
    $res = new Response(false, "Failed to Add Maintance details\n".$db->get_last_error());
    echo json_encode($res);
    return;
}


$args = [
    "person_id" => $affect,
    "name" => $_POST["name"],
    "flat_id" => $_POST["flat_id"]
];

$res = new Response(true, $args);
    echo json_encode($res);
    return;


?>