<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title> 登录</title>
    
    <link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
 
    

</head>

<body>

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1>WEI</h1>

            </div>
            

           
                <div class="form-group form-group col-md-2 col-md-offset-5">
                    <input type="text" id="account" style="margin-top: 10px;" class="form-control" placeholder="账号" required="">
                </div>
                <div class="form-group form-group col-md-2 col-md-offset-5">
                    <input type="password" id="password" class="form-control" placeholder="密码" required="">
                </div>
                <div class="row col-md-12">
                	<button  class="btn btn-primary block full-width m-b" onclick="login()" >登 录</button>
								</div>
							
               

           
        </div>
    </div>

    
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/bootstrap.min.js?v=3.4.0"></script>
		<script type="text/javascript">
   				function login(){
   						var account = $('#account').val();
   					  var password = $('#password').val();
   					  $.ajax({
   					  	url:"login",
   					  	data:{
   					  		"account":account,
   					  		"password":password,
   					  	},
   					  	type:"post",
   					  	success:function(data){
   					  		if(data=="success"){
   					  			window.location.href="index";
   					  		
   					  		}else{
   					  		   alert(data);
   					  		}
   					  		
   					  	}
   					  	
   					  });
   					  
   					
   				}
   				
   
   </script>

</body>

</html>
