<?php

header("Content-type: application/json; charset=utf-8");
include("../../config.php");

$required_params = ["member_id"];

foreach ($required_params as $value) {
    if(!key_exists($value, $_POST)){
        $error = new SmartCityError(PostDataItemNotFound, $value." is not provided");
        $res = new Response(FALSE, $error);
        $res->print_response();
        return;
    }
}

$mem_id = $_POST["member_id"];
$qry = "delete from ".TABLE_MEMBER." where id='$mem_id'";
$db = Database::getInstance();

$affect = $db->run_query($qry);

if($affect < 1){
    $res = new Response(false, "Failed to delete member details");
    echo json_encode($res);
    return;
}


$res = new Response(true, true);
    echo json_encode($res);
    return;


?>