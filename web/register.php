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
			include("connect.php");

			include("header.php");
			
			

			if(isset($_POST['submit']))
			{
	
				$name=$_POST['name'];
				$email=$_POST['email'];
				$password=$_POST['password'];
				$contact=$_POST['contact'];
				

				$q="insert into client(name,email,password,contact) values('$name','$email','$password','$contact')";
				mysqli_query($cn,$q);
				//header("Location:index.php");
			}
			
		?>
    <!-- header-end -->

    <!-- slider_area_start -->
    <div class="slider_area">
        <div class="single_slider  d-flex align-items-center slider_bg_1">
            <div class="container">
                <div class="row align-items-center justify-content-center">
				<form class="row contact_form" action="register.php" method="post" id="registerform">

                    <div class="col-lg-12 col-md-1">
                        <div class="col-lg-7 col-md-1">
                        <div class="payment_form white-bg wow fadeInDown" data-wow-duration="1.2s" data-wow-delay=".2s">
                            <div class="info text-center">
                                <h4>Registration</h4>
                                
                            </div>
                            <div class="form">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="single_input">
                                            <div class="form-group">
												<input type="text" class="form-control" id="name" name="name" placeholder="Enter your name">
											</div>
								
                                        </div>
                                    </div>
                                    <div class="col-lg-12">
                                        <div class="single_input">
                                            <div class="form-group">
												<input type="email" class="form-control" id="email" title="Enter email in proper format" required pattern="[^@]+@[^@]+\.[a-zA-Z]{2,6}" name="email" placeholder="Enter email address">
											</div>
                                         </div>
                                    </div>
									<div class="col-lg-12">
                                        <div class="single_input">
                                            <div class="form-group">
												<input type="password" class="form-control" id="password" title="Enter letters and numbers both in password" pattern="[a-zA-Z0-9]*$" required name="password" placeholder="Enter Password">
											</div>
                                         </div>
                                    </div>
									<div class="col-lg-12">
                                        <div class="single_input">
                                            <div class="form-group">
												<input type="text" class="form-control" id="contact" name="contact" placeholder="Enter Contact no.">
											</div>
                                         </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="submit_btn">
                                <button class="boxed-btn3" type="submit" name="submit" value="submit">Register</button>
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