<?

<?php

/**
 * class name : User
 * usage : to store the user related details
 *
 */

class User
{

    public static $table_name = "user";

    public $user_id = 0;
    public $user_name = "";
    public $email = "";
    public $phone_no = "";

    public function __construct($args = array())
    {

        if (is_array($args)) {
            $this->user_id = $args["id"];
            $this->user_name = $args["user_name"];
            $this->email = $args["email"];
            $this->phone_no = $args["phone_no"];
        } else {

            $qry = "select * from user where id=" . $args;

        }
    }

}

function validate_password($user_id, $password)
{

    $db_obj = Database::getInstance();
    $hash_pass = md5($password);    

    $qry = "select password from user where id=" . $user_id;
    $result = $db_obj->get_result($qry);    
    $db_password = $result["password"];

    if($hash_pass == $db_password)
        return true;
    else
        return false;

}

function login_user_by_id($user_id)
{
    $db_obj = Database::getInstance();
    $qry = "select * from ".TABLE_USER." where email='$email'";
    $result = $db_obj->run_query($qry);
    $user = new User($result);

    return $user;
}

function login_user_by_email($email, $password)
{
    $db_obj = Database::getInstance();
    $qry = "select * from ".TABLE_USER." where email='$email'";
    $result = $db_obj->get_result($qry);
    $user = new User($result);
    $hash_pass = md5($password);
    

    //$sql = "select password from user where id=" . $user->user_id;
    //$result = $db_obj->get_result($sql);    
    $db_password = $result["password"];

    if($hash_pass == $db_password)
        return $user;
    else
        return false;

    return false;

}

function register_new_user($args = array())
{

    $db_obj = Database::getInstance();

    $def_args = [
        "user_name" => "",
        "password" => "",
        "email" => "",
        "phone_no" => "",
    ];

    if (is_array($args)) {

        $args = array_replace_recursive($def_args, $args);
        $args["password"] = md5($args["password"]);
        $qry = generate_insert_query($args, TABLE_USER);
        $result = $db_obj->run_query($qry);

        return $result;

    } else {

        $error = new ParkedError(ArrayError, "User Details Are Not Provided Properly.");
        return $error->get_json_error();

    }

}


function reset_password($user_id, $new_pass, $old_pass){

    //$qry = "select * from user where id=$user_id";
    
    $db = Database::getInstance();
    //$result = $db->get_result($qry);

    $res = validate_password($user_id, $old_pass);
    if($res){
        $hash_pass = md5($new_pass);
        $qry = "update ".TABLE_USER." set password='$hash_pass' where id=$user_id";
        $res = $db->run_query($qry);
        if($res > 0)
            return true;
        else
            return false;
    }
    else{
        return false;
    }
    

}

function create_or_get_userid_for_social($email= ""){

    $db_obj = Database::getInstance();
    $qry = "select id from ".TABLE_USER." where email='$email'";
    $result = $db_obj->run_query($qry);
    $user_id = null;

    if(is_array($result)){
        $user_id = $result["user_id"];
    }
    else{
        $args = ["email" => $email];
        $user_id = register_new_user($args);
    }

    return $user_id;

}

?>