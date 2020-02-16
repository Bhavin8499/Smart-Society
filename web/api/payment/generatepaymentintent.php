<?php

header("Content-type: application/json; charset=utf-8");

include("../../config.php");
include(ROOT_PATH."/stripe/init.php");

$required_params = ["payment_amount", "user_id"];

foreach ($required_params as $value) {
    if(!key_exists($value, $_POST)){
        $error = new SmartCityError(PostDataItemNotFound, $value." is not provided");
        $res = new Response(FALSE, $error);
        $res->print_response();
        return;
    }
}

\Stripe\Stripe::setApiKey('sk_test_O8uCqubfsFJrCQNmNNDgbSfN00q1ktZpki');

$amount = $_POST["payment_amount"] * 100;

$intnet = \Stripe\PaymentIntent::create([
  'amount' => $amount,
  'currency' => 'inr',
  'payment_method_types' => ['card'],
]);

$res = new Response(true, $intnet);
echo json_encode($res);

$user_id = $_POST["user_id"];

$args = [
    "generatedby" => $user_id,
    "amount"=> $amount,
    "data" => json_encode($intnet)
];

$db = Database::getInstance();
$db->run_query(generate_insert_query($args, TABLE_PAYMENTINTENT));

return;

?>