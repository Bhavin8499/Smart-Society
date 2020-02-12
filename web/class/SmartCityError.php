<?php

/**
 * class Name : SmartCityError
 * usage : To Store the details of error
 *
 */
define("BaseError", "BaseError");
define("ArrayError", "Array Required");
define("MySQLError","SQL Error");
define("VariableNotFoundError", "VariableNotFoundError");
define("PostDataItemNotFound","PostDataItemNotFound");
define("LoginFailedError","LoginFailedError");
define("SQLDeleteError", "SQLDeleteError");

class SmartCityError
{

    public function __construct($name, $desc)
    {

        $this->name = $name;
        $this->desc = $desc;

    }

    public function get_json_error()
    {

        $arr = [
            "error" => [
                "error_name" => $this->name,
                "desc" => $this->desc,
            ],
        ];
        return json_encode($arr);
    }

}
?>