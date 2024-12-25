console.log("this is javascript file")
const togglebar=()=> {
	
	if($(".sidebar").is(":visible"))
	{
		$(".sidebar").css("display","none");
		
		$(".content").css("margin-left","0%")
		
	}
	else
	{
		$(".sidebar").css("display","block");
		
		$(".content").css("margin-left","20%")
		
	}
};
const paymentStart=()=>{
	console.log("payment started");
	let amt=$("#payment_input").val();
	console.log("emtered amount:"+amt);
	
	if(amt==''||amt==null)
		{
			alert("enter ammount");
			return;
		}
		
	//send AJAX request to start payment
	$.ajax(
		{
			url:"/user/create_order",
			data:JSON.stringify({price:amt,info:'order_req'}),
			contentType:'application/json',
			type:'POST',
			dataType:'json',
			success:function(response){
				console.log(response);
				if(response.status=="created")
					{
						let options={
							key:'rzp_test_Zu5XqFUMQpn9bZ',
							amount:response.amount,
							currency:'INR',
							name:'Smart contact manager',
							description:'Donation',
							image:'https://www.w3schools.com/css/img_lights.jpg',
							order_id:response.id,
							handler:function(response)
							{
								console.log(response.razorpay_payment_id);
								console.log(response.razorpay_order_id);
								console.log(response.razorpay_signature);
								console.log("payment successfull");
								swal("Good Job!","Payment successfull!","success");
							},
							prefill:{
								name:"sainath kadam",
								email:"sainathkadam1025@gmail.com",
								contact:"8483876922"
							},
							notes:{
								address:"learn code with sainath kadam"
							},
							theme:{color:"#3399cc"}
						};
						let rzp=new Razorpay(options);
						rzp.on("payment_failed",function(response){
							console.log(response.error.code);
							console.log(response.error.description);
							console.log(response.error.source);
							swal("Failed","Oops payment failed!","error");
						});
						
						rzp.open();
					}
			},
			error:function(error){
				console.log(error);
			}
			
		}
	)
}


document.
querySelector("#profile_input").
addEventListener("change",function(event){
	let file=event.target.files[0];
	let reader=new FileReader();
	reader.onload=function (){
		
		document.getElementById("upload_preview").src=reader.result;
	};
	reader.readAsDataURL(file);
});



