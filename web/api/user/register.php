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
$db->set_auto_commit(false);
$affect = $db->run_query($qry);

if($affect < 1){
    $db->rollback();
    $db->set_auto_commit(true);
    $res = new Response(false, "Failed to register user");
    echo json_encode($res);
    return;
}


$args = [
    "user_id" => $affect,
    "name" => $_POST["name"],
    "email" => $_POST["email"],
    "phoneno" => $_POST["phoneno"], 
    "role" => $_POST["role"],
    "password" => $_POST["password"]
];

if($_POST["role"] == "Admin"){

    $n=8; 
        $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'; 
        $randomString = ''; 
      
        for ($i = 0; $i < $n; $i++) { 
            $index = rand(0, strlen($characters) - 1); 
            $randomString .= $characters[$index]; 
        } 
      
    $arg1 = ["societyname" => $_POST["societyname"], "user_id" => $affect, "societycode" => $randomString];
    $qry = generate_insert_query($arg1, TABLE_SOCIETY);
    $args["society_id"] = $db->run_query($qry);    
    $args["society_code"] = $randomString;
}
else if ($_POST["role"] == "Security") {
    
    $soc_code = $_POST["societycode"];
    $qry = "select id from society where societycode='$soc_code'";

    $res = $db->run_query($qry);

    if(!is_array($res)){
        $db->rollback();
        $db->set_auto_commit(true);
        $res = new Response(false, "No Society was found with given society code");
        echo json_encode($res);
        return;
    }

        $society_id = $res["id"];
    //$society_id = $res;

    $argFlat = ["userid" =>$affect,
     "flatname" => "Security Guard", 
     "flatno" => "0", 
     "society_id" => $society_id
    ];

    $qry = generate_insert_query($argFlat, TABLE_FLATOWNER);
    $flat_id = $db->run_query($qry);

    $args["flat_id"] = $flat_id;
    $args["society_code"] = $soc_code;
    $args["society_id"] = $res["id"];
}
else{
    
        $soc_code = $_POST["societycode"];
        $qry = "SELECT * FROM `society` WHERE societycode='".$soc_code."'";
    
        $res = $db->get_result($qry);
    
        if(!is_array($res)){
            $db->rollback();
            $db->set_auto_commit(true);
            $res = new Response(false, "No Society was found with given society code ".$soc_code);
            echo json_encode($res);
            return;
        }
    
        
        $society_id = $res["id"];
     //   $society_id = $res;
    
        $argFlat = ["userid" =>$affect,
         "flatname" => $_POST["flatname"], 
         "flatno" => $_POST["flatno"], 
         "society_id" => $society_id
        ];
    
        $qry = generate_insert_query($argFlat, TABLE_FLATOWNER);
        $flat_id = $db->run_query($qry);

        $args["flat_id"] = $flat_id;
        $args["society_code"] = $soc_code;
        $args["society_id"] = $res["id"];
    
}

$db->commit();
$db->set_auto_commit(true);


$res = new Response(true, $args);
echo json_encode($res);
return;


?>