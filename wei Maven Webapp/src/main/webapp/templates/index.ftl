<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title> 用户列表 </title>
    
    <link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
     <link href="css/jquery.dataTables.min.css" rel="stylesheet">
     <link href="css/daterangepicker-bs2.css" rel="stylesheet">
     <link href="css/daterangepicker-bs3.css" rel="stylesheet">
     <link href="css/select2.min.css" rel="stylesheet">
 		<style type="text/css">
			.left-btn{
				margin-top:10px;
				margin-left:40px;
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
            			 <button class="btn btn-primary left-btn" onclick="adduser();">添加账户</button>
            			 <div class="row" style="margin-top: 20px;">
            			 	<span style="font-weight:bold;margin-left:15px;">搜索：</span><br/>
            			 	 编码<input type="text" id="account" style="    margin-top: 10px;"/><br/>
            			 	 名称<input type="text" id="name" style="    margin-top: 10px;"/><br/>
            			 	
            			 	 
            			 	 <label style="    margin-top: 10px;font-weight: 100;">账号类型：</label>
				        	<div style="width:180px;margin-left: 25px;">
				            <select id="sel_menu2" multiple="multiple" class="form-control">
							    <optgroup> 
							    <option value="0" checked="checked">学生</option>
							    <option value="1">老师</option>
							    </optgroup>
							 </select>
				    		</div>
				    	<br/> 注册时段<input type="text" id="registtime" style="margin-top: 10px;margin-left: 25px;"/><br/>
            			 	 <button class="btn btn-primary left-btn" onclick="return search();">搜索</button>
            			 	 <br/><br/><br/><br/><br/><br/>
            			<button class="btn btn-primary left-btn" onclick="logout();">注销</button>
            			 </div>
	            	</div>
	            
	            	
				 	<div class="col-md-9">
	           
	                <table class="table table-hover" id="mytable">
	                	
	                	
	              </div>
              
           		</div>
                  <thead>
                    <tr>
                    	<!-- 编码；名称，备注；状态；创建时间；最后登录时间;账号类型 -->
                      <th style="width:45px;font-weight:bold;">编码</th>
                      <th style="width:50px;font-weight:bold;">名称</th>
                      <th style="width:50px;font-weight:bold;">备注</th>
                      <th style="width:50px;font-weight:bold;">状态</th>
                      <th style="width:50px;font-weight:bold;">创建时间</th>
                      <th style="width:50px;font-weight:bold;">最后登录时间</th>
                      <th style="width:50px;font-weight:bold;">账号类型</th>
                      <th style="width:40px;font-weight:bold;">删除</th>
                      <th style="width:40px;font-weight:bold;">权限</th>
                      <th style="width:30px;font-weight:bold;">编辑</th>
                    
                    </tr>
                  </thead>
        
                   <tbody>
                 
                  <#list userlist as user>
                  	
                    <tr>
                      <td>${user.account}</td>
                      <td>${user.name}</td>
                      <td>${user.nickname}</td>
                      <td id="${user.id}">
                      <#if (user.state=0)>正常
                      <#elseif (user.state=1)>封存
                      </#if>
                      </td>
                      <td>${user.createdate}</td>
                      <td>
                      ${user.lastlogindate!}
                      
                      
                      
                      
                      </td>
                      <td>
                      <#if (user.type=0)>学生
                      <#elseif (user.type=1)>老师
                      </#if>
                      </td>
                      <td><img src="images/cross.png" onclick="return deleteUser(this,${user.id});" style="cursor:pointer;width:20px;height:20px;"></img>
                        </td> 
                      <td>
                         <span style="font-weight:bold;color:#f00;cursor:pointer;" onclick="return feng(this,${user.state},${user.id});">
                         	<#if (user.state=0)>封存
                      		<#elseif (user.state=1)>启封
                     		 </#if>
                         </span>
                      </td>
                     
                      <td><a style="color:#0f0;font-weight:bold;" href="toedituser?id=${user.id}">编辑</a>
                       </td>
                      
                  	</tr>
                  	
                  </#list>
                   </tbody>
                </table>
							
               

           
        </div>
    </div>

    
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/bootstrap.min.js?v=3.4.0"></script>
    <script src="js/select2.js"></script>
    <script src="js/daterangepicker.js"></script>
    <script src="js/moment.js"></script>
    <script src="js/jquery.dataTables.min.js"></script>
    
		<script type="text/javascript">
			var startime="";
			var endtime="";
			
		
			//select2 
   				$("#sel_menu2").select2({
				  tags: true,
				  maximumSelectionLength: 1, //最多能够选择的个数
				  placeholder: "请选择",
				 });
		
   			$(document).ready(function() {
   				
   				//表格
   				$('#mytable').dataTable({
				"bFilter": false,
				"aaSorting": [
					[ 5, "desc" ]
					]
				});
   			
   				//日期选择器
   				$('#registtime').daterangepicker({

				    format: 'YYYY-MM-DD',
				
				    startDate: '2016-06-01',
				
				    endDate: '2016-8-31'
				
				  },
				
				  function(start, end, label) {
						startime=start.format('YYYY-MM-DD');
						endtime=end.format('YYYY-MM-DD');
				
				  }
				
				);
   			} );
   			
   			
   			function logout(){
   				window.location.href="logout";
   			}
				
			
			
			function search(){
				var account = $('#account').val();
				var name = $('#name').val();
				var types = $('#sel_menu2').val();
				if(types==null){
					var type ="";
	   				
				}else{
					var type = types[0];
				}
				window.location.href="searchuser?account="+account+"&name="+name+"&type="+type+"&startime="+startime+"&endtime="+endtime;
			
			
			}
			
			
			
			
			
   			//删除用户
   			function deleteUser(obj,uid){
   				if(confirm("确定删除该用户吗？")){
   				
   					//ajax 后台删除用户  
   					
   					$.ajax({
   					  	url:"deleteUser",
   					  	data:{
   					  		"id":uid,
   					  	},
   					  	type:"post",
   					  	success:function(data){
   					  		if(data=="success"){
   					  			$(obj).parent().parent().remove();
   					  		
   					  		}else{
   					  		   alert("删除错误");
   					  		   
   					  		   
   					  		}
   					  		
   					  	}
   					  	
   					  });
   					
   				
   				
   				}else{
   					return false;
   				
   				}
   			}
   			//封存或启封用户
   			function feng(obj,state,uid){
   			
   				if(state==0){
   					
   					if(!confirm("确定封存该用户吗？")){
   						return false;
   					}
   				}else{
   				
   					if(!confirm("确定启封该用户吗？")){
   						return false;
   					}
   				
   				}
   				
   				
   					//ajax 后台封存或启封用户  
   					
   					$.ajax({
   					  	url:"fengUser",
   					  	data:{
   					  		"id":uid,
   					  		"state":state,
   					  	},
   					  	type:"post",
   					  	success:function(data){
   					  		if(data=="success"){
   					  			if(state==0){
   					  				$(obj).text("启封");
   					  				$('#'+uid).text("封存");
								}else{
									$(obj).text("封存");
									$('#'+uid).text("正常");
								} 					  		
   					  		}else{
   					  		   alert("错误");
   					  		   
   					  		}
   					  		
   					  	}
   					  	
   					  });
   					
   			
   			}
   			
   			function adduser(){
   				window.location.href="toadduser";
   			
   			}
   			
   </script>

</body>

</html>
