/**
 * 
 */
 function addDoctor(){
 	var id=$("#id").val();
 	var name=$("#name").val();
 	var sex=$("#sex").val();
 	var age=$("#age").val();
 	var number=$("#number").val();
 	var password=$("#password").val();
 	
 	$.ajax({
 	//method:"post",
 	url:"adminAddDoctor.do",
 	data:{id:id,name:name,sex:sex,age:age,number:number,password:password},
 	success:function(data)
 	{
 		alert("success!");
 		self.location='all_doctor.do'
 		
 	},
 	error:function(){
 		alert("error")
 	}
 	})
 }
  function addOperationRoom(){
 	var id=$("#id").val();
 	var location=$("#location").val();
 	
 	
 	$.ajax({
 	//method:"post",
 	url:"adminAddOperationRoom.do",
 	data:{id:id,location:location},
 	success:function(data)
 	{
 		alert("success!");
 		self.location='all_operation_room.do'
 		
 	},
 	error:function(){
 		alert("error")
 	}
 	})
 }
  function addPatient(){
 	var id=$("#id").val();
 	var name=$("#name").val();
 	var sex=$("#sex").val();
 	var age=$("#age").val();
 	var number=$("#number").val();
 	
 	$.ajax({
 	//method:"post",
 	url:"adminAddPatient.do",
 	data:{id:id,name:name,sex:sex,age:age,number:number},
 	success:function(data)
 	{
 		alert("success!");
 		self.location='all_patient.do'
 		
 	},
 	error:function(){
 		alert("error")
 	}
 	})
 }
  function addNurse(){
 	var id=$("#id").val();
 	var name=$("#name").val();
 	var sex=$("#sex").val();
 	var age=$("#age").val();
 	var number=$("#number").val();
 	var password=$("#password").val();
 	
 	$.ajax({
 	//method:"post",
 	url:"adminAddNurse.do",
 	data:{id:id,name:name,sex:sex,age:age,number:number,password:password},
 	success:function(data)
 	{
 		alert("success!");
 		self.location='all_nurse.do'
 		
 	},
 	error:function(){
 		alert("error")
 	}
 	})
 }
 function addAnalgesist(){
 	var id=$("#id").val();
 	var name=$("#name").val();
 	var sex=$("#sex").val();
 	var age=$("#age").val();
 	var number=$("#number").val();
 	var password=$("#password").val();
 	
 	$.ajax({
 	//method:"post",
 	url:"adminAddAnalgesist.do",
 	data:{id:id,name:name,sex:sex,age:age,number:number,password:password},
 	success:function(data)
 	{
 		alert("success!");
 		self.location='all_analgesist.do'
 		
 	},
 	error:function(){
 		alert("error")
 	}
 	})
 }
function  updatedoctor(id){
 	$("#"+id+" td input").each(
 		
 		function(){
 			$(this).removeAttr("disabled")
 		}
 	)
 	$("#updata"+id).hide();
 	$("#save"+id).show();
 }
 function  updateanalgesist(id){
 	$("#"+id+" td input").each(
 		function(){
 			$(this).removeAttr("disabled")
 		}
 	)
 	$("#updata"+id).hide();
 	$("#save"+id).show();
 }
 function  updatepatient(id){
 	$("#"+id+" td input").each(
 		function(){
 			$(this).removeAttr("disabled")
 		}
 	)
 	$("#updata"+id).hide();
 	$("#save"+id).show();
 }
 function  updatedoctor(id){
 	$("#"+id+" td input").each(
 		
 		function(){
 			$(this).removeAttr("disabled")
 		}
 	)
 	$("#updata"+id).hide();
 	$("#save"+id).show();
 }
 function  updateoperationroom(id){
 	$("#"+id+" td input").each(
 		function(){
 			$(this).removeAttr("disabled")
 		}
 	)
 	$("#updata"+id).hide();
 	$("#save"+id).show();
 }
 function  updatenurse(id){
 	$("#"+id+" td input").each(
 		
 		function(){
 			$(this).removeAttr("disabled")
 		}
 	)
 	$("#updata"+id).hide();
 	$("#save"+id).show();
 }
 function savedoctor(id){
 	$("#"+id+" td input").each(
 		
 		function(){
 			$(this).attr("disabled","true")
 		}
 	)
 	$("#updata"+id).show();
 	$("#save"+id).hide();
 	var e=$("#"+id+" td input")
 	//alert(e[0].value);
 	var id=e[0].value
 	var name=e[1].value
 	var sex=e[2].value
 	var age=e[3].value
 	var number=e[4].value
 	var password=e[5].value
 	
 	$.ajax({
 	//method:"post",
 	url:"adminUpdataDoctor.do",
 	data:{id:id,name:name,sex:sex,age:age,number:number,password:password},
 	success:function(data)
 	{
 		alert("success!");
 		//self.location='all_doctor.do'
 		
 	},
 	error:function(){
 		alert("error")
 	}
 	})
 }
  function savepatient(id){
 	$("#"+id+" td input").each(
 		
 		function(){
 			$(this).attr("disabled","true")
 		}
 	)
 	$("#updata"+id).show();
 	$("#save"+id).hide();
 	var e=$("#"+id+" td input")
 	//alert(e[0].value);
 	var id=e[0].value
 	var name=e[1].value
 	var sex=e[2].value
 	var age=e[3].value
 	var number=e[4].value
 	
 	
 	$.ajax({
 	//method:"post",
 	url:"adminUpdataPatient.do",
 	data:{id:id,name:name,sex:sex,age:age,number:number},
 	success:function(data)
 	{
 		alert("success!");
 		//self.location='all_doctor.do'
 		
 	},
 	error:function(){
 		alert("error")
 	}
 	})
 }
  function saveoperationroom(id){
 	$("#"+id+" td input").each(
 		
 		function(){
 			$(this).attr("disabled","true")
 		}
 	)
 	$("#updata"+id).show();
 	$("#save"+id).hide();
 	var e=$("#"+id+" td input")
 	//alert(e[0].value);
 	var id=e[0].value
 	var location=e[1].value
 	
 	
 	$.ajax({
 	//method:"post",
 	url:"adminUpdataOperationroom.do",
 	data:{id:id,location:location},
 	success:function(data)
 	{
 		alert("success!");
 		//self.location='all_doctor.do'
 		
 	},
 	error:function(){
 		alert("error")
 	}
 	})
 }
 function savenurse(id){
 	$("#"+id+" td input").each(
 		
 		function(){
 			$(this).attr("disabled","true")
 		}
 	)
 	$("#updata"+id).show();
 	$("#save"+id).hide();
 	var e=$("#"+id+" td input")
 	//alert(e[0].value);
 	var id=e[0].value
 	var name=e[1].value
 	var sex=e[2].value
 	var age=e[3].value
 	var number=e[4].value
 	var password=e[5].value
 	
 	$.ajax({
 	//method:"post",
 	url:"adminUpdataNurse.do",
 	data:{id:id,name:name,sex:sex,age:age,number:number,password:password},
 	success:function(data)
 	{
 		alert("success!");
 		//self.location='all_doctor.do'
 		
 	},
 	error:function(){
 		alert("error")
 	}
 	})
 }
 function saveanalgesist(id){
 	$("#"+id+" td input").each(
 		
 		function(){
 			$(this).attr("disabled","true")
 		}
 	)
 	$("#updata"+id).show();
 	$("#save"+id).hide();
 	var e=$("#"+id+" td input")
 	//alert(e[0].value);
 	var id=e[0].value
 	var name=e[1].value
 	var sex=e[2].value
 	var age=e[3].value
 	var number=e[4].value
 	var password=e[5].value
 	
 	$.ajax({
 	//method:"post",
 	url:"adminUpdataAnalgesist.do",
 	data:{id:id,name:name,sex:sex,age:age,number:number,password:password},
 	success:function(data)
 	{
 		alert("success!");
 		//self.location='all_doctor.do'
 		
 	},
 	error:function(){
 		alert("error")
 	}
 	})
 }
 function deletanalgesist(id){


     var sure = confirm('确认删除吗？');
     if(sure==true) {
         $.ajax({
                 url:"adminDelAnalgesist.do",
                 data:{id:id},
                 success:function(data){
                     self.location='all_analgesist.do'
                 },
                 error:function(){
                     alert("error")
                 }
             }
         )
     }else {
     	return;
	 }

 	
 }
  function deletoperationroom(id){

      var sure = confirm('确认删除吗？');
      if(sure==true) {
          $.ajax({
                  url:"adminDelOperationroom.do",
                  data:{id:id},
                  success:function(data){
                      self.location='all_operationroom.do'
                  },
                  error:function(){
                      alert("error")
                  }
              }
          )
      }else {
      	return;
	  }


 	
 }
 function deletdoctor(id){

     var sure = confirm('确认删除吗？');
     if(sure==true) {
         $.ajax({
                 url:"adminDelDoctor.do",
                 data:{id:id},
                 success:function(data){
                     self.location='all_doctor.do'
                 },
                 error:function(){
                     alert("error")
                 }
             }
         )
     }else {
     	return;
	 }


 	
 }
 function deletnurse(id){

     var sure = confirm('确认删除吗？');
     if(sure==true) {
         $.ajax({
                 url:"adminDelNurse.do",
                 data:{id:id},
                 success:function(data){
                     self.location='all_nurse.do'
                 },
                 error:function(){
                     alert("error")
                 }
             }
         )
     }else{
     	return;
	 }

 	
 }
 function deletpatient(id){

     var sure = confirm('确认删除吗？');
     if(sure==true) {
         $.ajax({
                 url:"adminDelPatient.do",
                 data:{id:id},
                 success:function(data){
                     self.location='all_patient.do'
                 },
                 error:function(){
                     alert("error")
                 }
             }
         )
     }else {
     	return;
	 }

 	
 }