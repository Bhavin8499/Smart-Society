<?php

header("Content-type: application/json; charset=utf-8");
include("../../config.php");

$required_params = ["society_id"];

foreach ($required_params as $value) {
    if(!key_exists($value, $_POST)){
        $error = new SmartCityError(PostDataItemNotFound, $value." is not provided");
        $res = new Response(FALSE, $error);
        $res->print_response();
        return;
    }
}

$qry = "select * from ".TABLE_MAINTANCE." where society_id='".$_POST["society_id"]."'";
$db = Database::getInstance();

$result = $db->get_results($qry);

if(!is_array($result)){
    $res = new Response(false, "Failed to get member details");
    echo json_encode($res);
    return;
}


$res = new Response(true, $result);
    echo json_encode($res);
    return;


?>