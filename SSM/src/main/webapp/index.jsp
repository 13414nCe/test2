<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<%
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>

<!-- web路径：
		不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题
		以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:8080/crud)：需要加上项目名 
	
 -->
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 员工添加的模态框 -->
	<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">员工添加</h4>
	            </div>
	            <div class="modal-body">
	            	<!-- 水平排列的表单 -->
	            	<form class="form-horizontal"> 
					  <div class="form-group"> 
					    <label class="col-sm-2 control-label">empName</label> 
					    <div class="col-sm-10"> 
					      <input type="text" class="form-control" name="empName" id="empName_add_input" placeholder="empName"> 
					      <span class="help-block"></span>
					    </div> 
					  </div> 
					  <div class="form-group"> 
					    <label class="col-sm-2 control-label">email</label> 
					    <div class="col-sm-10"> 
					      <input type="text" class="form-control" name="email" id="email_add_input" placeholder="email@qq.com"> 
					      <span class="help-block"></span>
					    </div> 
					  </div> 
					  <!-- 性别 -->
					  <div class="form-group"> 
					    <label class="col-sm-2 control-label">gender</label> 
					    <div class="col-sm-10"> 
					    	<label class="radio-inline">
					    		<input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked" />男
					    	</label>
					    	<label class="radio-inline">
					    		<input type="radio" name="gender" id="gender2_add_input" value="F" />女
					    	</label>
					    </div> 
					  </div>
					  <!-- 部门 -->
					  <div class="form-group"> 
					    <label class="col-sm-2 control-label">deptName</label> 
					    <div class="col-sm-4"> 
					    	<select class="form-control" name="dId" id="dept_add_select"></select>
					    </div> 
					  </div>
					  
					</form> 
	            </div>
	            
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	                <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>

	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>SSM-CRUD</h1>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
				<button class="btn btn-danger">删除</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="emps_table">
					<!-- 表头 -->
					<thead>
						<tr>
							<th>#</th>
							<th>empName</th>
							<th>gender</th>
							<th>email</th>
							<th>deptName</th>
							<th>操作</th>
						</tr>
					</thead>
					
					<tbody>
						
					</tbody>
					
					<c:forEach items="${pageInfo.list}" var="emp">
						<tr>
							<th>${emp.empId}</th>
							<th>${emp.empName}</th>
							<th>${emp.gender=="M"?"男":"女"}</th>
							<th>${emp.email}</th>
							<th>${emp.department.deptName}</th>
							<th>
								<button class="btn btn-primary btn-sm">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									编辑
								</button>
								<button class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									删除
								</button>
							</th>
						</tr>
					</c:forEach>
					
				</table>
			</div>
		</div>
		<!-- 显示分页信息 -->
		<div class="row">
			<!-- 分页文字信息 -->
			<div class="col-md-6" id="page_info_area">
				
			</div>
			<!-- 分页条信息 -->
			<div class="col-md-6" id="page_nav_area">
				
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var totalRecord; 
		//1、页面加载完成以后，直接发送ajax请求，要到分页数据
		$(function(){
			//去首页
			to_page(1);
		});
		
		function to_page(pn){
			$.ajax({
				url:"${APP_PATH}/emps",
				data:"pn="+pn,
				type:"GET",
				success:function(result){
					//console.log(result);
					//1、解析并显示员工数据
					build_emps_table(result);
					//2、解析并显示分页信息
					build_page_info(result);
					//3、解析并显示
					build_page_nav(result);
				}
			});
		}
		
		//解析员工表格信息
		function build_emps_table(result){
			//清空table表格
			$("#emps_table tbody").empty();
			//拿到所有员工数据
			var emps = result.extend.pageInfo.list;
			//遍历员工数据		index-索引   item-当前对象
			$.each(emps,function(index,item){
				var empIdTd = $("<td></td>").append(item.empId);
				var empNameTd = $("<td></td>").append(item.empName);
				var genderTd = $("<td></td>").append(item.gender=='M'?"男":"女");
				var emailTd = $("<td></td>").append(item.email);
				var dedptNameTd = $("<td></td>").append(item.department.deptName);
				
				var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm")
								.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
				
				var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm")
				.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
				$("<tr></tr>").append(empIdTd)
					.append(empNameTd)
					.append(genderTd)
					.append(emailTd)
					.append(dedptNameTd)
					.append(btnTd)
					.appendTo("#emps_table tbody");
			});
			
		}
		
		//解析分页信息
		function build_page_info(result){
			$("#page_info_area").empty();
			$("#page_info_area").append("当前第"+result.extend.pageInfo.pageNum+"页,共 "+
					result.extend.pageInfo.pages+"页,共"+
					result.extend.pageInfo.total+" 条记录");
			totalRecord = result.extend.pageInfo.total;
		}
		//解析分页条信息
		function build_page_nav(result){
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			/**
				构建元素
			*/
			//首页
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
			//前一页
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
			
			if(result.extend.pageInfo.hasPreviousPage == false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else{
				//为元素添加点击翻页事件
				firstPageLi.click(function(){
					to_page(1);
				});
				prePageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum-1);
				});
			}
			
			//下一页
			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
			//末页
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
			if(result.extend.pageInfo.hasNextPage == false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else{
				nextPageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum +1);
				});
				lastPageLi.click(function(){
					to_page(result.extend.pageInfo.pages);
				});
			}
			
			
			//添加首页和前一页的提示
			ul.append(firstPageLi).append(prePageLi);
			//取出页码号,遍历个ul中添加页码提示
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if(result.extend.pageInfo.pageNum == item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					to_page(item);
				});
				ul.append(numLi);
			});
			//添加后一页和末页
			ul.append(nextPageLi).append(lastPageLi);
			//把ul加入到nav中
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");
		}
		
		//点击新增按钮弹出模态框
		$("#emp_add_modal_btn").click(function(){
			//发送ajax请求，查出部门信息，显示在下拉列表中
			getDepts();
			//弹出模块框
			$("#empAddModal").modal({
				backdrop:"static"
			});
		});
		
		//查出所有的部门信息显示在下拉列表中
		function getDepts(){
			$.ajax({
				//  /depts -->获取所有部门信息
				url:"${APP_PATH}/depts",
				type:"GET",
				success:function(result){
					console.log(result);
					//显示部门在下拉列表中
					//extend: {depts: [{deptId: 1, deptName: "开发部"}, {deptId: 2, deptName: "测试部"}]}
					$.each(result.extend.depts,function(){
						//构建option
						var optionEle = $("<option></option>").append(this.deptName).attr("value",this.deptId);
						optionEle.appendTo("#empAddModal select");
					});
				}
				
			});
		}
		//校验表单数据
		function validate_add_form(){
			//1、拿到要校验的数据，使用正则表达式
			var empName = $("#empName_add_input").val();
			var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
			if(!regName.test(empName)){
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#empName_add_input", "error","用户名可以是2-5位中文或者6-16位英文和数字的组合");
				return false;
			}else{
				show_validate_msg("#empName_add_input", "success","");
			};
			//2、校验邮箱
			var email = $("#email_add_input").val();
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)){
				//alert("邮箱格式不正确");
				/* $("#email_add_input").parent().addClass("has-error");
				$("#email_add_input").next("span").text("邮箱格式不正确"); */
				show_validate_msg("#email_add_input", "error", "邮箱格式不正确");
				return false;
			}else{
				/* $("#email_add_input").parent().addClass("has-success");
				$("#email_add_input").next("span").text(""); */
				show_validate_msg("#email_add_input", "success", "");
			}
			return true;
		}
		//显示校验结果的提示信息
		function show_validate_msg(ele,status,msg){
			//清楚当前元素的校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if("success" == status){
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			}else if("error" == status){
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
		
		//校验用户名是否可用
		$("#empName_add_input").change(function(){
			//发送ajax请求校验用户名是否可用
			var empName = this.value;
			$.ajax({
				url:"${APP_PATH}/checkuser",
				data:"empName="+empName,
				type:"POST",
				success:function(result){
					
					if(result.code == 200){
						show_validate_msg("empName_add_input", "success", "用户名可用");
					}else{
						show_validate_msg("empName_add_input", "error", "用户名不可用");
					}
				}
			});
		});
		
		
		//点击保存
		$("#emp_save_btn").click(function(){
			//1、模块框中填写的表单数据提交给服务器进行保存
			//1、先对要提交给服务器的数据进行校验
			if(!validate_add_form()){
				return false;
			};
			//2、发送ajax请求保存员工
			$.ajax({
				url:"${APP_PATH}/emp",
				type:"POST",
				data:$("#empAddModal form").serialize(),
				success:function(result){
					//alert(result.msg);
					/**
						员工保存成功：
						1、关闭模态框
						2、来到最后一页，显示刚才保存的数据
					*/
					//1、关闭模态框
					$("#empAddModal").modal('hide');
					//2、来到最后一页，显示刚才保存的数据
					//发送ajax请求显示最后一页数据即可
					to_page(totalRecord);
				}
			});
		});
		
	</script>
	
</body>
</html>