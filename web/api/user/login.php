<?php

include("../../config.php");
include(CLASS_PATH."user/User.php");

$required_params = ["email", "password"];


foreach ($required_params as $value) {
    if(!key_exists($value, $_POST)){
        $error = new ParkedError(PostDataItemNotFound, $value." is not provided");
        $res = new Response(FALSE, $error);
        $res->print_response();
        return;
    }
}

$user = login_user_by_email($_POST["email"], $_POST["password"]);

if(!is_object($user)){
    $error = new ParkedError("Error", "Failed To Login");
    $res = new Response(FALSE, $error);
    echo json_encode($res);
    return;
}

$res = new Response(TRUE, $user);
echo json_encode($res);


?>