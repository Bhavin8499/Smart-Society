<?php
define("ROOT_PATH", __DIR__);
define("CLASS_PATH", __DIR__."/class/");
define("ROOT_IMAGE_PATH",__DIR__."/images/");
define("GALLERY_IMAGE_PATH", __DIR__."/images/gallery/");
define("EVENT_IMAGE_PATH", __DIR__."/images/event/");
define("BILL_IMAGE_PATH", __DIR__."/images/bills/");

define("TABLE_USER","user");

#setting header
#header("Content-type: application/json; charset=utf-8");

#Including Most Common Model
if(!class_exists("Database"))
    include(__DIR__."/class/"."Database.php");
if(!class_exists("Response"))
    include(__DIR__."/class/"."Response.php");
if(!class_exists("ImageHandler"))
    include(__DIR__."/class/"."ImageHandler.php");


?>