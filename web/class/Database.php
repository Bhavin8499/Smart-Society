<?php

include("SmartCityError.php");

class Database
{
    private $username = "root";
    private $password = "";
    private $host = "localhost";
    private $database_name = "parked";
    public $conn;
    public static $dbObj;
    public function __construct()
    {
        // Create connection
        $this->conn = new mysqli($this->host, $this->username, $this->password, $this->database_name);
        // Check connection
        if ($this->conn->connect_error) {
            die("Connection failed: " . $this->conn->connect_error);
        }
    }
    public static function getInstance()
    {
        if (Database::$dbObj == null) {
            Database::$dbObj = new Database();
        }

        return Database::$dbObj;
    }
    public function run_query($query = "")
    {
        $this->conn->query($query, MYSQLI_USE_RESULT);
        if ($this->conn->error != null) {
            $error = new ParkedError(MySQLError,$this->conn->error);
            return $this->conn->error;
        }

        if($this->conn->insert_id > 0){
            return $this->conn->insert_id;
        }
        else
            return $this->conn->affected_rows;
        return $this->conn->insert_id;
    }
    public function get_results($query = "")
    {
        $result = $this->conn->query($query, MYSQLI_USE_RESULT);
        if ($result == null || $result == false) {
            return false;
        }

        for ($set = array(); $row = $result->fetch_assoc(); $set[] = $row);
        if ($set == null) {
            return false;
        }
        return $set;
    }
    public function get_result($query = "")
    {
        $result = $this->conn->query($query, MYSQLI_USE_RESULT);
        if ($this->conn->error) {
            echo $this->conn->error;
        }
        if ($result == null || $result == false) {
            return false;
        }

        $arr = $result->fetch_assoc();
        if ($arr != null) {
            return $arr;
        }
        return false;

    }

    public function get_last_id(){
        return $this->conn->insert_id;
    }

}

function generate_insert_query($args, $tbl_name = "")
{
    $keys = array();
    $values = array();
    foreach ($args as $key => $value) {
        array_push($keys, $key);
        array_push($values, "'$value'");
    }
    implode(",", $keys) . " values " . implode(',', $values);
    return "insert into $tbl_name (" . implode(",", $keys) . ") values (" . implode(",", $values) . ");";
}
function generate_update_query($args)
{

    $strItem = "";
    $arr = array();
    foreach ($args as $key => $value) {
        $strItem = $key . "='" . $value . "'";
        array_push($arr, $strItem);
    }
    $str = implode(",", $arr);
    //implode(",",$keys)." values ".implode(',', $values);
    return $str;
}
?>