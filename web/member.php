<?php
include("header.php");
if(!isset($_SESSION["client_id"])){
    header("Location:client_login");
}
?>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Smart society</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/nice-select.css">
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/gijgo.css">
    <link rel="stylesheet" href="css/animate.min.css">
    <link rel="stylesheet" href="css/slick.css">
    <link rel="stylesheet" href="css/slicknav.css">

    <link rel="stylesheet" href="css/style.css">
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->
</head>

<body>
    <!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->
   
      <!-- bradcam_area  -->
      <div class="bradcam_area bradcam_bg_1">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text">
                        <h3>Member</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--/ bradcam_area  -->

    <!-- service_area_start  -->
  <!--  <div class="service_area">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section_title text-center mb-90">
                        <span class="wow fadeInUp" data-wow-duration="1s" data-wow-delay=".1s"></span>
                        <h3 class="wow fadeInUp" data-wow-duration="1s" data-wow-delay=".2s">Manage Your Member info.</h3>
                        
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-md-6">
                    <div class="single_service wow fadeInLeft" data-wow-duration="1.2s" data-wow-delay=".5s">
                        <div class="service_icon_wrap text-center">
                            <div class="service_icon ">
                                
                            </div>
                        </div>
                        <div class="info text-center">
                           
                            
                        </div>
                        <div class="service_content">
                            <ul>
                                <li>Name :<a href="index">Edit</a></li>
                                <li>Age  :</li>
                                <li>Gender :</li>
                            </ul>
                            <div class="apply_btn">
                                <button class="boxed-btn3" type="submit">Join Event Now</button>
                            </div>
                        </div> 
                        
                    </div>
                </div>
               
            </div>
        </div>
    </div>-->
    <?php
           # include('connect.php');
           # $get=mysqli_query(   $cn,'SELECT * FROM member ');
			#$rs=mysqli_num_rows($get);
			#if($rs!=0)
			#{
				?><center><br>
            <?php 
				echo "<table border=3>";
					echo "<tr>";
					echo "<th>Name</th>";
					echo "<th>Gender</th>";
					echo "<th >Age</th>";
					echo "<th>Remove</th>";
					echo "<th>Edit</th>";
					echo "</tr>";
		
			#	while($data=mysqli_fetch_array($get))
			#	{
				echo "<tr>";
					
					echo "<td>abc</td>";

					echo "<td>female</td>";

					echo "<td width='160px'>12</td>";

       # echo "<td><a href='user_del_pro.php?id=$data[0]' >Delete</a>";
        echo "<td><a href='#' >Delete</a>";
        echo "<td><a href='#' >Edit</a>";			
        #echo "<td><a href='user_del_pro.php?id=$data[1]' >Edit</a>";
   


				echo "<br>";
				
				echo "</tr>";
				echo "</table><br>";
                echo "<a href='add_member_form' >";
                echo  "<button class='boxed-btn3'  >Add member</button></a></td>";
         
		
			
				                     	
                		?> 

    <!-- service_area_end  -->
    

    <!-- works_area_start  -->
    <!-- works_area_end  -->

    <!-- apply_loan_start  -->
    <!-- footer start -->
    <?php include("footer.php") ?><!--/ footer end  -->

    <!-- link that opens popup -->
    <!-- JS here -->
    <script src="js/vendor/modernizr-3.5.0.min.js"></script>
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/isotope.pkgd.min.js"></script>
    <script src="js/ajax-form.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/imagesloaded.pkgd.min.js"></script>
    <script src="js/scrollIt.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/nice-select.min.js"></script>
    <script src="js/jquery.slicknav.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/gijgo.min.js"></script>
    <script src="js/slick.min.js"></script>



    <!--contact js-->
    <script src="js/contact.js"></script>
    <script src="js/jquery.ajaxchimp.min.js"></script>
    <script src="js/jquery.form.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/mail-script.js"></script>


    <script src="js/main.js"></script>
</body>

</html>