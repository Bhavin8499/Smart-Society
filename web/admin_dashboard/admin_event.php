<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Event</title>
    
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600">
   
    <link rel="stylesheet" href="css/fontawesome.min.css">
   
    <link rel="stylesheet" href="css/bootstrap.min.css">
   
    <link rel="stylesheet" href="css/tooplate.css">
</head>

<body id="reportsPage" class="bg02">
    <?php include('admin_header.php'); ?>
    <!-- row -->
            <div class="row tm-content-row tm-mt-big">
                <div class="col-xl-12 tm-md-12 tm-sm-12 tm-col">
                    <div class="bg-white tm-block h-100">
                        <div class="row">
                            <div class="col-md-8 col-sm-12">
                                <h2 class="tm-block-title d-inline-block">Event</h2>

                            </div>
                            <div class="col-md-4 col-sm-12 text-right">
                                <a href="add_event" class="btn btn-small btn-primary">
                                    Add New Event</a>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-hover table-striped tm-table-striped-even mt-3">
                                <thead>
                                    <!--  column of table-->
                                    <tr class="tm-bg-gray">
                                        
                                        <th scope="col">Event Name</th>
                                        <th scope="col" class="text-center">Date</th>
                                        <th scope="col" class="text-center">Time</th>
                                        <th scope="col" class="text-center">Organized By</th>
                                        <th scope="col" class="text-center">Is closed?</th>
                                        <th scope="col" class="text-center">Location</th>
                                        <th scope="col">&nbsp;</th>
                                        <th scope="col">&nbsp;</th>
                                    <!-- table column name over -->
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        
                                        <!-- data will come from database -->
                                        <td class="tm-product-name">1. In malesuada placerat (hover)</td>
                                        <td class="text-center">145</td>
                                        <td class="text-center">255</td>
                                        <td class="text-center">255</td>
                                        <td class="text-center">Yes</td>
                                        <td class="text-center">abc</td>
                                        <!-- Deleting Bills -->
                       <td><a class="fas fa-trash-alt tm" href="delete_bill"></a></td>
                                        <!-- Editing Bill -->
                     <td><a class="fas fa-edit" href="edit_event"></a></td>          
                                    </tr>
                                    <tr>
                                        <td class="tm-product-name">2. Aenean eget urna enim. Sed enim</td>
                                        <td class="text-center">240</td>
                                        <td class="text-center">260</td>
                                        <td class="text-center">255</td>
                                        <td class="text-center">No</td>
                                        <td class="text-center">abc</td>
                                        <td><i class="fas fa-trash-alt tm-trash-icon"></i></td>
                                        <td><a class="fas fa-edit" href="edit_event"></a></td>          
                                    </tr>
                                    
                                </tbody>
                            </table>
                        </div>

                       
                    </div>
                </div>

              
            </div>
            <footer class="row tm-mt-small">
                <div class="col-12 font-weight-light">
                    <p class="d-inline-block tm-bg-black text-white py-2 px-4">
                        Copyright &copy; 2018 Admin Dashboard . Created by
                        <a rel="nofollow" href="https://www.tooplate.com" class="text-white tm-footer-link">Tooplate</a>
                    </p>
                </div>
            </footer>
        </div>
    </div>
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- https://jquery.com/download/ -->
    <script src="js/bootstrap.min.js"></script>
    <!-- https://getbootstrap.com/ -->
    <script>
        $(function () {
            $('.tm-product-name').on('click', function () {
                window.location.href = "edit-product.html";
            });
        })
    </script>
</body>

</html>