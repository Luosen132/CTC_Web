<%@ page language="java"

	pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="com.xmlg.ctc.dao.AdminDAO"%>
<%@page import="com.xmlg.ctc.daoimpl.AdminDAOImpl"%>
<%@page import="com.xmlg.ctc.entity.Admin"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>管理员专区</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<link rel="stylesheet" href="assets/css/style.css">
		<link rel="stylesheet" href="assets/css/loader-style.css">
		<link rel="stylesheet" href="assets/css/bootstrap.css">

		<link rel="stylesheet" type="text/css"
			href="assets/js/progress-bar/number-pb.css">
		<link href="assets/js/footable/css/footable.core.css?v=2-0-1"
			rel="stylesheet" type="text/css">
		<link href="assets/js/footable/css/footable.standalone.css"
			rel="stylesheet" type="text/css">
		<link href="assets/js/footable/css/footable-demos.css"
			rel="stylesheet" type="text/css">
		<link rel="stylesheet"
			href="assets/js/dataTable/lib/jquery.dataTables/css/DT_bootstrap.css">
		<link rel="stylesheet"
			href="assets/js/dataTable/css/datatables.responsive.css">

		<link rel="shortcut icon" href="assets/ico/minus.png">

		<style type="text/css">
canvas#canvas4 {
	position: relative;
	top: 20px;
}
</style>


	</head>

	<body>
		
	

		
		<!-- END OF SIDE MENU -->




	




				<!-- CONTENT -->
				
				<!--/ TITLE -->

				<!-- BREADCRUMB 路径 -->
				
	<%
			
	
	%>
				<!-- 从这里开始 -->
		<div class="content-wrap">
			<div class="row">
				<div class="col-sm-12">

					<div class="nest" id="FootableClose">
						<div class="title-alt">
							<h6>
								管理员信息表
							</h6>
						</div>

						<div class="body-nest" id="Footable">
							<div class="row" style="margin-bottom: 10px;">
								<div class="col-sm-4">
									
								</div>

								<div class="col-sm-2">


								</div>
							
								
							
								<div class="col-sm-6">

									<a style="margin-left: 10px;" class="pull-right btn btn-info"
										title="添加" href="houtai/add_admin.jsp">+</a>
								</div>
								

							</div>
							
							<form name="form" method="post" action="">

								<table class="table-striped footable-res footable metro-blue"
									data-page-size="6">
									<thead>
										<tr>
											<th>
												管理员账号
											</th>
											<th >
												姓名
											</th>
										
											
											<th>
												密码
											</th>
											
										
											
											<th>
												操作
											</th>
											
										</tr>
									</thead>
									<tbody>
										<%
											request.setCharacterEncoding("utf-8");
											
											List<Admin> list = null;
											AdminDAO aDao = new AdminDAOImpl();
												list = aDao.admins();
											
											if (list != null && list.size() > 0) {
												for (Object object : list) {
													Admin item = (Admin) object;
										%>
										<tr>
											<td align="center"><%=item.getAdId()%></td>
											<td align="center">
												<a href="#"><%=item.getAdminName()%></a>
											</td>
										
											
											<td data-value="78025368997" align="center"><%=item.getAdminPassword()%></td>
										
									
											
											<td data-value="1" align="center">
												<a href="houtai/modify_admin.jsp?adminNo=<%=item.getAdId()%>"><button type="button"
														class="btn btn-default" title="修改">
														<span class="entypo-pencil"></span>
													</button>
												</a> &nbsp;&nbsp;&nbsp;
												<a onclick="return del(<%=item.getAdId()%>)" ><button type="button"
														class="btn btn-info" title="删除">
														<span class="entypo-trash"></span>
													</button> </a>

											</td>
										
										</tr>
										<%
												}
											}
										%>

									</tbody>
									<tfoot>
										<tr>
											<td colspan="7">
												<div class="pagination pagination-centered"></div>
												<div id="placeholder" style="width: 1%; height: 1px;"></div>
											</td>

										</tr>
									</tfoot>
								</table>
							</form>

						</div>





					</div>


				</div>
			</div>
		</div>



		<!-- 到这里结束 -->
	





		<!-- /END OF CONTENT -->



		<!--  END OF PAPER WRAP -->

		<!--  天气 -->
		<script type="text/javascript" src="assets/js/jquery.js">
</script>
		<script src="assets/js/progress-bar/src/jquery.velocity.min.js">
</script>
		<script src="assets/js/progress-bar/number-pb.js">
</script>
		<script src="assets/js/progress-bar/progress-app.js">
</script>



		<!-- MAIN EFFECT -->
		<script type="text/javascript" src="assets/js/preloader.js">
</script>
		<script type="text/javascript" src="assets/js/bootstrap.js">
</script>
		<script type="text/javascript" src="assets/js/app.js">
</script>
		<script type="text/javascript" src="assets/js/load.js">
</script>
		<script type="text/javascript" src="assets/js/main.js">
</script>




		<!-- GAGE -->


		<script type="text/javascript" src="assets/js/chart/jquery.flot.js">
</script>
		<script type="text/javascript"
			src="assets/js/chart/jquery.flot.resize.js">
</script>
		<script type="text/javascript" src="assets/js/chart/realTime.js">
</script>
		<script type="text/javascript"
			src="assets/js/speed/canvasgauge-coustom.js">
</script>
		<script type="text/javascript"
			src="assets/js/countdown/jquery.countdown.js">
</script>
		<script src="assets/js/jhere-custom.js">
</script>
		<script type="text/javascript" src="assets/js/toggle_close.js">
</script>
		<script src="assets/js/footable/js/footable.js?v=2-0-1"
			type="text/javascript">
</script>
		<script src="assets/js/footable/js/footable.sort.js?v=2-0-1"
			type="text/javascript">
</script>
		<script src="assets/js/footable/js/footable.filter.js?v=2-0-1"
			type="text/javascript">
</script>
		<script src="assets/js/footable/js/footable.paginate.js?v=2-0-1"
			type="text/javascript">
</script>
		<script src="assets/js/footable/js/footable.paginate.js?v=2-0-1"
			type="text/javascript">
</script>

		<script type="text/javascript">
$(function() {
	$('.footable-res').footable();
});
</script>
		<script type="text/javascript">
$(function() {
	$('#footable-res2')
			.footable()
			.bind(
					'footable_filtering',
					function(e) {
						var selected = $('.filter-status').find(':selected')
								.text();
						if (selected && selected.length > 0) {
							e.filter += (e.filter && e.filter.length > 0) ? ' ' + selected
									: selected;
							e.clear = !e.filter;
						}
					});

	$('.clear-filter').click(function(e) {
		e.preventDefault();
		$('.filter-status').val('');
		$('table.demo').trigger('footable_clear_filter');
	});

	$('.filter-status').change(function(e) {
		e.preventDefault();
		$('table.demo').trigger('footable_filter', {
			filter : $('#filter').val()
		});
	});

	$('.filter-api').click(function(e) {
		e.preventDefault();

		//get the footable filter object
			var footableFilter = $('table').data('footable-filter');

			alert('about to filter table by "tech"');
			//filter by 'tech'
			footableFilter.filter('tech');

			//clear the filter
			if (confirm('clear filter now?')) {
				footableFilter.clearFilter();
			}
		});
});
</script>
<script type="text/javascript">
				function del(id){
					if(confirm("您确定要删除吗?")){
						window.location.href="houtai/delete_admin.jsp?adminNo="+id;
					}
				}
			</script>





		
		
	</body>
</html>
