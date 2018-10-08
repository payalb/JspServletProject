

let result;
$(document).ready(function() {
	 $('#from').keyup(function(event) {
            var name = $('#from').val();
            $.get('autocomplete', {
                    city : name
            }, function(data) 
            {
            
            	 result = $.map(data, function (d){
                    return d.departure_city;
                    }).filter(function(item, pos,self) {
                        return self.indexOf(item) == pos;
                    });
           });
            $("#from").autocomplete({
                source: result
              });
           
	 } );
	 
	 $('#to').keyup(function(event) {
         var name = $('#to').val();
         $.get('autocomplete', {
                 city : name
         }, function(data) 
         {
         
         	 result = $.map(data, function (d){
                 return d.arrival_city;
                 }).filter(function(item, pos,self) {
                     return self.indexOf(item) == pos;
                 });
        });
         $("#to").autocomplete({
             source: result
           });
        
	 } );
	 var today = new Date();
	 var m= today.getMonth();
	 var d= today.getDate();
	 var y=today.getFullYear();
	 if(m < 10)
	        m = '0' + m.toString();
	    if(day < 10)
	        d = '0' + d.toString();
	 var min= y + '-' + m + '-' + d;
	 console.log(min);
	 $('#ondate').attr('min',min);
	
//           
//            $('#to').change(function(event) {
//                var name = $('#to').val();
//                $.get('autocomplete', {
//                        city : name
//                }, function(data) {
//                	console.log(data);
//                	val.push(data);
//                	console.log(val);
//               });
//                
//                $("#to").autocomplete({
//                    source: val
//                  });
//            } );
            
//            $.get('autocomplete',{ city:name},function(data){
//           	   console.log('autocomplete data',data);
//            	alert('callback called');
//            	return data;
//            });
//            $("#from").autocomplete({
//            source: data
//          });
//	let list=[];
//            $.ajax("autocomplete", {
//            	dataType: "json",
//            	data: name,
//            	success: function(data) {
//            	console.log(data);
//            	list:data
//            	},
//            	error: function(jqXHR, textStatus, errorThrown) {
//            	console.log(textStatus); //error logging
//            	}
//            	});
//            
//            $("#from").autocomplete({
//              source: list
//            });
            
            
            
	
});

