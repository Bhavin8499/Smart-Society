<?php

/**
 * Class Name : Response
 * Usage : Response Is used for printing the response in proper format
 */
class Response
{

    public function __construct($status = false, $data){

        $this->status = $status;
        $this->data = $data;

    }

    public function print_response(){

        $arr = [
            "status" => $this->status,
            "data" => $this->data,
            "status_code" => "200"
        ];

        echo json_encode($arr);

    }

    public function print_error_response(){

        $arr = [
            "status" => $this->status,
            "data" => $this->data,
            "status_code" => "404"
        ];

        echo json_encode($arr);

    }

}


?>