<?php

header("Content-type: application/json; charset=utf-8");
include("../../config.php");

$required_params = ["member_id","name", "gender", "dob", "flat_id"];

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
    "gender" => $_POST["gender"], 
    "dob" => $_POST["dob"],
    "flat_id" => $_POST["flat_id"]
];

$qry = "update ".TABLE_MEMBER." set ".generate_update_query($args)."where id='".$_POST["member_id"]."'";
$db = Database::getInstance();

$affect = $db->run_query($qry);

if($affect < 1){
    $res = new Response(false, "Failed to update member details");
    echo json_encode($res);
    return;
}


$args = [
    "member_id" => $affect,
    "name" => $_POST["name"],
    "gender" => $_POST["gender"], 
    "dob" => $_POST["dob"],
    "flat_id" => $_POST["flat_id"]
];

$res = new Response(true, $args);
    echo json_encode($res);
    return;


?>