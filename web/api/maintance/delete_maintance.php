<?php

header("Content-type: application/json; charset=utf-8");
include("../../config.php");

$required_params = ["maintance_id"];

foreach ($required_params as $value) {
    if(!key_exists($value, $_POST)){
        $error = new SmartCityError(PostDataItemNotFound, $value." is not provided");
        $res = new Response(FALSE, $error);
        $res->print_response();
        return;
    }
}

$main_id = $_POST["maintance_id"];
$qry = "delete from ".TABLE_MAINTANCE." where id='$main_id'";
$db = Database::getInstance();

$affect = $db->run_query($qry);

if($affect < 1){
    $res = new Response(false, "Failed to delete maintance details\n".$DB->get_last_error());
    echo json_encode($res);
    return;
}

$res = new Response(true, true);
echo json_encode($res);
return;


?>