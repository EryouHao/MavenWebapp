<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title> 编辑用户 </title>
    
    <link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
     <link href="css/jquery.dataTables.min.css" rel="stylesheet">
    <link href="css/select2.min.css" rel="stylesheet">
    
    
 		<style type="text/css">
			.left-btn{
				margin-top:10px;
				margin-left:40px;
			}
			.accountlabel{
				margin-left: -156px;
				margin-top: 20px;
			
			}
			.subbtn{
				margin-left: 175px;
    			margin-top: 30px;
			}
		</style>
    

</head>

<body>

    <div >
        <div>
            <div>

                <h1 >WEI 禾唐科技笔试题 </h1>

            </div>
            
            	<div class="row" style="margin-top:50px;">
            		<div class="col-md-2" style="margin-left:30px;">
            			 <button class="btn btn-primary left-btn" onclick="window.history.go(-1);">返回</button>
            			
	            	</div>
	            	
	            	
				 	<div class="col-md-9">
	           				<!--表单 -->
	                	<div class="col-md-12">
   							<div class="form-group">
       							 <label class="col-sm-2 control-label">编码：</label>
       						 <div class="col-sm-10">
         						   <input type="text" id="account" value="${user.account}"  onblur="return checkaccount()" class="form-control" placeholder="请输入文本"> <span id="accountspan" class="help-block m-b-none"></span>

       						 </div>
   							 </div>
  					  <div class="form-group">
       					 <label class="col-sm-2 control-label">名称：</label>
      					  <div class="col-sm-10">
          				  <input type="text" id="name" value="${user.name}" class="form-control" placeholder="请输入文本"> <span class="help-block m-b-none" id="name"></span>

      				  		</div>
   					 </div>
				    <div class="form-group">
				        <label class="col-sm-2 control-label">备注：</label>
				        <div class="col-sm-10">
				            <input type="text" id="nickname" value="${user.nickname}" class="form-control" placeholder="请输入文本"> <span class="help-block m-b-none"></span>
				
				      	  </div>
				    	</div>
				    	 <div class="form-group">
				        <label class="col-sm-2 control-label">新密码：</label>
				        <div class="col-sm-10">
				            <input type="password" id="password" class="form-control" placeholder="请输入密码"> <span class="help-block m-b-none"></span>
				
				      	  </div>
				    	</div>
				    	<div class="form-group">
				        <label class="col-sm-2 control-label">确认密码：</label>
				        <div class="col-sm-10">
				            <input type="password" id="confirmpass" class="form-control" placeholder="请输入密码"> <span class="help-block m-b-none"></span>
				
				      	  </div>
				    	</div>
				    	
				    <div class="form-group">
				        <label class="col-sm-2 control-label accountlabel" style="    margin-left: 0px;">账号类型：</label>
				        <div class="col-sm-2" style="margin-top: 15px;">
				            <select id="sel_menu2" multiple="multiple" class="form-control" value="${user.type}">
							    <optgroup> 
							    <option value="0">学生</option>
							    <option value="1">老师</option>
							    </optgroup>
							 </select>
				    	</div>
				    </div>
				   
				    <br/>
	                	<div class="row form-group col-sm-12">
	                		
	                		<button class="btn btn-primary subbtn" onclick="return submit(${user.id});">提交</button>
	                	</div>
	              	</div>
              
           		
							
               

           
        </div>
    </div>

    
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/bootstrap.min.js?v=3.4.0"></script>
    <script src="js/jquery.dataTables.min.js"></script>
    <script src="js/select2.js"></script>
		<script type="text/javascript">
		
				//select2 
   				$("#sel_menu2").select2({
				  tags: true,
				  maximumSelectionLength: 1, //最多能够选择的个数
				  placeholder: "请选择",
				 });
   			
   				function checkaccount(){
   				
   					var account = $("#account").val();
   					if(account==""){
   						return false;
   					}
   					//到后台进行判断
	   				$.ajax({
   					  	url:"checkaccount",
   					  	data:{
   					  		"account":account,
   					  	},
   					  	type:"post",
   					  	success:function(data){
   					  	
   					  		if(data=="no_this_user"){
   					  			$('#accountspan').attr("style","color:#0f0");
   					  			$('#accountspan').text("此编码可以使用"); 		
   					  		}else if(data=="has_this_user"){
   					  			$('#accountspan').attr("style","color:#f00");
   					  			  $('#accountspan').text("此编码已存在"); 	
   					  		}else{
   					  			alert("检查编码错误");
   					  		}
   					  		
   					  	}
   					  	
   					  });
   					
   					
   				}
   			
   			
	   			function submit(uid){
	   				
	   				
	   				var account = $("#account").val();
	   				var name = $("#name").val();
	   				var nickname = $("#nickname").val();
	   				var password = $("#password").val();
	   				var confirmpass = $("#confirmpass").val();
	   				var types = $('#sel_menu2').val();
	   				if(types==null){
						var type ="";
	   				
					}else{
						var type = types[0];
					}
	   				
	   				if(account==""||name==""||nickname==""||type==""||password==""||confirmpass==""){
	   					alert("请将表单填写完整");
	   					return false;
	   				}
	   				
	   				if(password!=confirmpass){
	   					alert("两次密码不正确");
	   					return false;
	   				}
	   				
	   				
	   				//ajax 传到后台添加
	   				
	   				$.ajax({
   					  	url:"edituser",
   					  	data:{
   					  		"id":uid,
   					  		"account":account,
   					  		"name":name,
   					  		"nickname":nickname,
   					  		"password":password,
   					  		"type":type,
   					  	},
   					  	type:"post",
   					  	success:function(data){
   					  		
   					  		if(data=="success"){
   					  				alert("修改成功!");  
   					  				window.location.href="index";		
   					  		}else{
   					  		   		alert("修改失败");
   					  		}
   					  		
   					  	}
   					  	
   					  });
	   				
	   			}
   			
   			
   </script>

</body>

</html>
