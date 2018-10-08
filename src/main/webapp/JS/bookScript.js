
let v;
let result;
let eseat;
let fseat;
let bseat;
$(document).ready(function(){
	console.log("ready");
	v=$('#fnum').val();
	if($('#seatno').val()==="0"){
		console.log("disable");
		$("button[type=submit]").prop("disabled",true);
	}
	getvalue();
/* 	}); */
/* $('#fclass').change(function() {
	console.log($('#fclass').val()); */
	
	});
	$('#fclass').change(function() {
		getvalue();
	});
	$('#seatno').change(function() {
		if($('#seatno').val()==="0"){
			console.log("disable");
			$("button[type=submit]").prop("disabled",true);
		}if($('#seatno').val()!=="0"){
			console.log("disable");
			$("button[type=submit]").prop("disabled",false);
		}
		
	});
	function getvalue(){
		$.get('fetchseats', {
	        id : v
	}, function(data) 
	{console.log(data);
	for (var key in data) {
	    console.log("seat",key);
	    if(key==="economy_seat"){
	    	eseat=data[key];
	    }else if(key==="first_seat"){
	    	fseat=data[key];
	    }else if(key==="business_seat"){
	    	bseat=data[key];
	    }
	    
	    }

	
		if($('#fclass').val()==="Economy"){
			$('#seatno').attr("max",eseat);
		}else if($('#fclass').val()==="First class"){
			$('#seatno').attr("max",fseat);
		}else if($('#fclass').val()==="Business"){
			$('#seatno').attr("max",bseat);
		}
		
	});
	}