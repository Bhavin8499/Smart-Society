<?php

/**
 * Class : ImageHandler
 * Usage : To Mange And upload images
 */
class ImageHandler
{
    public $image_dir = "image";
    
    
    public function __construct()
    {
        
    }

    public function upload($file = array(), $img_type = ""){

        $dirname = "";
        $filepath = "";

        switch ($img_type){
            case "Spot_Header" :
                $filepath = "images/header/";
                $dirname = SPOT_HEADER_IMAGE_PATH;            
                break;

            case "Spot" : 
                $filepath = "images/spot/";
                $dirname = SPOT_IMAGE_PATH;
                break;

            case "Profile" :
                $filepath = "images/profile/";
                $dirname = PROFILE_IMAGE_PATH;
                break;

            default :
                $dirname = ROOT_IMAGE_PATH;

        }

        if (!file_exists($dirname)) {
            mkdir($dirname, 0777, true);
        }

        $errors = array();
        $uploadedFiles = array();
        $extension = array("jpeg","jpg","png");
        $bytes = 1024;
        $KB = 2048;
        $totalBytes = $bytes * $KB;
        $imagesDB="";
        $counter = 0;
    
        $temp = $file["tmp_name"];
        //echo "<br/>".$temp;
        $name = $file["name"];
        //echo "<br/>".$name;
        if(empty($temp)){return false;}

        $UploadOk = true;
        
        $ext = pathinfo($name, PATHINFO_EXTENSION);

        $randomfilename = $img_type."_".rand(100000,100000000).".".$ext;

        if(in_array($ext, $extension) == false){
            $UploadOk = false;
            array_push($errors, $name." is invalid file type.");
        }
        
        if(file_exists($dirname.$randomfilename) == true){
            $UploadOk = false;
            array_push($errors, $randomfilename." file is already exist.");
        }
        
        if($UploadOk == true){
            move_uploaded_file($temp,$dirname.$randomfilename);            
            $newName = str_replace('//', '/', $filepath.$randomfilename);
            return $newName;
        }

        return "";

        }



}

$imageHandler = new ImageHandler();

?>