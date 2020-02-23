<?php

include("../../config.php");
include(CLASS_PATH."user/User.php");

header("Content-type: application/json; charset=utf-8");

$required_params = ["email", "password"];


foreach ($required_params as $value) {
    if(!key_exists($value, $_POST)){
        $error = new SmartCityError(PostDataItemNotFound, $value." is not provided");
        $res = new Response(FALSE, $error);
        $res->print_response();
        return;
    }
}

$user = login_user_by_email($_POST["email"], $_POST["password"]);

if(!is_object($user)){
    $error = new SmartCityError("Error", "Failed To Login");
    $res = new Response(FALSE, $error);
    echo json_encode($res);
    return;
}

$db = Database::getInstance();
$qry = "";
if($user->role == "Admin")
    $qry = "select id society_id,societycode from society where user_id=$user->user_id";
else
    $qry = "select fo.society_id, s.societycode from flat_owner fo, society s where fo.society_id=s.id and userid=$user->user_id";

$res = $db->get_result($qry);

if(is_array($res)){
    $user->society_id = $res["society_id"];
    $user->society_code = $res["societycode"];
}


if($user->role =="Security"){
    $qry = "select flatno,flatname from flat_owner where society_id = $user->society_id and flatno!=0";

    $res = $db->get_results($qry);
    if(is_array($res))
        $user->flat_details = $res;
}

$res = new Response(TRUE, $user);
echo json_encode($res);


?>