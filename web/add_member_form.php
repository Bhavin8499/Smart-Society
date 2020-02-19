<!doctype html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Finloans</title>
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

    <!-- header-start -->
    <?php 
			include("header.php"); 
		?>
    <!-- header-end -->

    <!-- slider_area_start -->
<div class="slider_area">
        <div class="single_slider  d-flex align-items-center slider_bg_2">
            <div class="container">
                <div class="row align-items-center justify-content-center">
<form class="row contact_form" action="add_member" method="post" id="loginform">
	 <div class="col-lg-12 col-md-300">
                        <div class="col-lg-10 col-md-200">
                        <div class="payment_form white-bg wow fadeInDown" data-wow-duration="1.2s" data-wow-delay=".2s">
                 		  <div class="info text-center">
                            		    <h4>Member Info.</h4>
		  </div>
                  <div class="form">
                        <div class="row">
			
		<?php
			echo  " <div class='col-lg-12'>";
                echo "<div class='single_input'>";
                    echo  "<div class='form-group'>";
				    echo "<input type='text' class='form-control' 
		id='email' title='Enter Name' required name='name' placeholder='Enter Name'>";
		      		echo "</div>";
				    echo "</div>";
				echo "</div>";
                echo " <div class='col-lg-12'>";
                    echo "<div class='single_input'>";
               		echo  "<div class='form-group'>";
				echo "<select name='gender'> ";
                    echo "<option value='0'>Choose Gender</option>";
                	echo "<option >Female</option>";
                    echo "<option>Male</option>";
        		    echo "</select>";
                    echo "</div>";
				echo "</div>";
				echo "</div>";

				echo " <div class='col-lg-12'>";
                    echo "<div class='single_input'>";
                    echo  "<div class='form-group'>";
				echo "<br><input type='number' class='form-control' 
		id='email' title='Enter Age' required name='age' placeholder='Enter Age'>";
		      		echo "</div>";
				echo "</div>";
				echo "</div>";
				
				 echo "<div class='submit_btn'>";
                 echo "<a href='add_member_code' >";
                 echo  "<button class='boxed-btn3'  >Add</button></a></td>";
              echo " </div>";

		?>
		</div>
                            </div>
                            
                           
                        </div>
                    </div>
                    </div>
					</form>
                    
                </div>
            </div>
        </div>
    </div>
    <!-- slider_area_end -->

    <!-- service_area_start  -->
    
    <!-- service_area_end  -->
    
    <!-- about_area_start  -->
        <!-- about_area_end  -->

    
    <!-- testimonial_area  -->
    
    <!-- /testimonial_area  -->

    
    <!-- footer start -->
    <?php include("footer.php")?>
    <!--/ footer end  -->

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
