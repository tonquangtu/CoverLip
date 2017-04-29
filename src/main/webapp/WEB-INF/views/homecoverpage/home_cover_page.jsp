<!DOCTYPE html>
<%@include file="../common/common_lib.html"%>

<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>CoverLip</title>
	 <!-- Latest compiled and minified CSS -->
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
	<%--<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">--%>
	<%--<link rel="stylesheet" type="text/css" href="css/navigation.css">--%>
	<%--<link rel="stylesheet" type="text/css" href="css/footer.css">--%>
	<link rel="stylesheet" type="text/css" href="tung_style.css">
	<link rel="stylesheet" type="text/css" href="one_card_style.css">
	<!-- jQuery library -->
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
	<%--<script src="js/jquery.min.js" type="text/javascript"></script>--%>

	<!-- Latest compiled JavaScript -->
	<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
	<%--<script src="js/bootstrap.min.js" type="text/javascript"></script>--%>

	<!-- <script src="https://use.fontawesome.com/479981a8a3.js"></script> -->
	<%--<link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css">--%>
	
	<style type="text/css" media="screen">
		
	</style>

	<!--Slider-->
	<script src="courial.js" type="text/javascript"></script>
	<script src="one_card_script.js" type="text/javascript"></script>
	
	<script>
		$(document).ready(function() {
			slide('demo_first_0', 'next_first', 'prev_first', 1000);	
			slide('demo_first_1','next_first_1','prev_first_1', 1200);
			slide('demo_first_2','next_first_2','prev_first_2', 1400);
			slide('demo_first_3','next_first_3','prev_first_3', 1600);

			slide('demo_second_0', 'next_second', 'prev_second',1000);	
			slide('demo_second_1','next_second_1','prev_second_1', 1200);
			slide('demo_second_2','next_second_2','prev_second_2', 1400);
			slide('demo_second_3','next_second_3','prev_second_3', 1600);
			// $('.caroufredsel_wrapper').height($('.caroufredsel_wrapper').height());
			$('.next_first').on('click',function(){
				$('.next_first_1').click();
			});
			$('.next_first_1').on('click',function(){
				$('.next_first_2').click();
			});
			$('.next_first_2').on('click',function(){
				$('.next_first_3').click();
			});

			$('.next_second').on('click',function(){
				$('.next_second_1').click();
			});
			$('.next_second_1').on('click',function(){
				$('.next_second_2').click();
			});
			$('.next_second_2').on('click',function(){
				$('.next_second_3').click();
			});

			$('.prev_first').on('click',function(){
				$('.prev_first_1').click();
			});
			$('.prev_first_1').on('click',function(){
				$('.prev_first_2').click();
			});
			$('.prev_first_2').on('click',function(){
				$('.prev_first_3').click();
			});

			$('.prev_second').on('click',function(){
				$('.prev_second_1').click();
			});
			$('.prev_second_1').on('click',function(){
				$('.prev_second_2').click();
			});
			$('.prev_second_2').on('click',function(){
				$('.prev_second_3').click();
			});
		});
		function slide(id, classNext, classPrev, duration){
			$('#'+id).carouFredSel({
					auto: false,
					prev: '.'+classPrev,
					next: '.'+classNext,
					// // pagination: "#pager2",
					mousewheel: true,
					swipe: {
						onMouse: true,
						onTouch: true
					},
					items				: 2,
					direction			: "up",
					scroll : {
						items			: 2,
						effect			: "easeOutBounce",
						duration		: duration,							
						pauseOnHover	: true
					}	
				});
		}
	</script>

	<!--End Slider-->


	<!---->
</head>
<body>
<div id="fb-root"></div>
	<script>(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.8&appId=379118262476877";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));</script>
<%@include file="../common/mainheader/main_header.html"%>
	<content>
		<div id="slider" class="container">
			<div id="carousel-id" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carousel-id" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-id" data-slide-to="1" class=""></li>
					<li data-target="#carousel-id" data-slide-to="2" class=""></li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img class="img-responsive" data-src="" alt="First slide" src="images/phiasaumotcogai.jpg">
						<div class="background-gadian"></div>
						<div class="container">
							<div class="carousel-caption">
								<h1>Phia Sau Mot Co Gai</h1>
								<p>Mot ban cover di vao long nguoi cua hot girl Beo La</p><br>
								<p><a class="btn btn-lg btn-primary" href="#" role="button">Xem ngay</a></p>
							</div>
						</div>
					</div>
					<div class="item">
						<img class="img-responsive" data-src="" alt="Second slide" src="images/didetrove.jpg">
						<div class="background-gadian"></div>
						<div class="container">
							<div class="carousel-caption">
								<h1>Di De Tro Ve</h1>
								<p>Le Roi tro lai voi ban hit dinh dam "Di de tro ve"</p><br>
								<p><a class="btn btn-lg btn-primary" href="#" role="button">Xem ngay</a></p>
							</div>
						</div>
					</div>
					<div class="item">
						<img class="img-responsive" data-src="" alt="Third slide" src="images/lactroi.jpg">
						<div class="background-gadian"></div>
						<div class="container">
							<div class="carousel-caption">
								<h1>Lac Troi</h1>
								<p>Girl Xinh Maria Ozawa cover hit Lac Troi cua Son Tung MTP</p><br>
								<p><a class="btn btn-lg btn-primary" href="#" role="button">Xem ngay</a></p>
							</div>
						</div>
					</div>
				</div>
				<a class="left carousel-control" href="#carousel-id" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
				<a class="right carousel-control" href="#carousel-id" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
		</div> <!-- slider -->
		<div id="main_content" class="container">
	        <!-- List video -->
	        <div class="first_content">
	        	<!-- Page Header -->
		        <div class="row title">
		            <div class="col-lg-12">
		                <h1 class="page-header">Moi Dang
		                    <!-- <small>Secondary Text</small> -->
			                <div class="action_slide">
						        <div class="btn-group">
						            <button type="button" class="btn btn-primary next_first"><span class="glyphicon glyphicon-chevron-up"></span></button>
						            <button type="button" class="btn btn-primary prev_first"><span class="glyphicon glyphicon-chevron-down"></span></button>
						        </div>
						    </div>
		                </h1>
		            </div>
		        </div>
		        <!-- /.row -->

		        <!-- Projects Row -->
		        <div class="row" style="overflow:hidden;">
		            <div class="col-md-3 text-center">
		            	<div class="subject">
			                <a href="#">
			                    <img class="img-responsive" src="images/singer.jpg" alt="">
			                </a>
			                <h3>
			                    <a href="#">Moi Dang</a>
			                </h3>
			                <!-- <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p> -->
			            	<button type="button" class="btn btn-primary">Xem toan bo</button>
			            </div>
		            </div>
		           
					<div class="col-md-9" style="padding-right:0;padding-left:0;">
						<%
						for(int i=0; i<3; i++){ %>
						<ul id="demo_first_<%= i %>" class="one_list">
						   	<% for (int j=0; j < 4; j++) { %>
							<div class="one_card col-md-12">
								<div class="header_card">
									<div class="img-circle avatar_member">
										<img class = "img-responsive" src="images/youtube_logo.png" alt="Avatar Member">
									</div>
									<div class="name_member">
										<h2>Son Tung MTP</h2>
									</div>
									<div class="option_card">
										<img src="icon/icon_more_vertical.svg" alt="" class="icon_more_vertical">
									</div>
								</div>
								<div class="content_card">
									<div class="media">
										<li class="item_singer_video ">
				                            <div class="singer_video_box">
				                                <div class="thumbnail_video_box" >
				                                    <a class="thumbnail_video" href="#" title="Đi Ngang Qua Nhau- Tống Gia Huy">
				                                        <span class="icon_play"></span>
				                                        <img  src="images/anh1.jpg" alt="Anh đợi em nhé - Lương Gia Bằng" title ="Anh đợi em nhé - Lương Gia Bằng">
				                                    </a>            
				                                </div>

				                                <div class="info_singer_video_box">
				                                    <span>Hạnh Phúc Thoáng Qua</span>
				                                </div>
				                            </div>
				                        </li>
									</div>
								</div>
								<div class="footer_card">
									<ul class="interaction"> 
										<li class="like"> 
											<img src="icon/icon_like.svg" alt="" class="icon_react">&nbsp;<span class="like_counter">100</span> 
										</li> 
										<li class="comment"> 
											<a href="#"> 
												<img src="icon/icon_comment.svg" alt="" class="icon_react">&nbsp;100 
											</a> 
										</li> 
										<li class="view"> 
											<span> <img src="icon/icon_view.svg" alt="" class="icon_react">&nbsp;5k </span> 
										</li> 
									</ul>
									<div class="facebook">

										<div class="col-md-6">
											<div class="fb-like" data-href="https://developers.facebook.com/docs/plugins/" data-layout="button" data-action="like" data-size="large" data-show-faces="false" data-share="false"></div>
										</div>
										<div class="col-md-6">
											<div class="fb-share-button" data-href="https://developers.facebook.com/docs/plugins/" data-layout="button" data-size="large" data-mobile-iframe="false"><a class="fb-xfbml-parse-ignore" target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2F&amp;src=sdkpreparse">Share</a></div>
										</div>
									</div>
									<div style="clear:both;"> </div>
								</div>
							</div>
						    <% } %>
						</ul>
						<% } %>
						
						<br><br>
						
						<div style="display:none!important;">
							<button class="next_first_1"></button>
							<button class="next_first_2"></button>
							<button class="next_first_3"></button>
							<button class="prev_first_1"></button>
							<button class="prev_first_2"></button>
							<button class="prev_first_3"></button>
						</div>
					</div>
		        </div>
		        <!-- /.row -->
	        </div>

			<div class="first_content">
	        	<!-- Page Header -->
		        <div class="row title">
		            <div class="col-lg-12">
		                <h1 class="page-header">Cover Hot
		                    <!-- <small>Secondary Text</small> -->
			                <div class="action_slide">
						        <div class="btn-group">
						            <button type="button" class="btn btn-primary next_second"><span class="glyphicon glyphicon-chevron-up"></span></button>
						            <button type="button" class="btn btn-primary prev_second"><span class="glyphicon glyphicon-chevron-down"></span></button>
						        </div>
						    </div>
		                </h1>
		            </div>
		        </div>
		        <!-- /.row -->

		        <!-- Projects Row -->
		        <div class="row" style="overflow:hidden;">
		            <div class="col-md-3 text-center">
		            	<div class="subject">
			                <a href="#">
			                    <img class="img-responsive" src="images/singer.jpg" alt="">
			                </a>
			                <h3>
			                    <a href="#">Cover Hot</a>
			                </h3>
			                <!-- <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p> -->
			            	<button type="button" class="btn btn-primary">Xem toan bo</button>
			            </div>
		            </div>
		           	
					<div class="col-md-9" style="padding-right:0;padding-left:0;">
					<% for(int i=0; i<3; i++){ %>
						<ul id="demo_second_<%= i %>" class="col-md-4 one_list">
						<% for(int j=0; j<4; j++){ %>
						    <div class="one_card col-md-12">
								<div class="header_card">
									<div class="img-circle avatar_member">
										<img class = "img-responsive" src="images/youtube_logo.png" alt="Avatar Member">
									</div>
									<div class="name_member">
										<h2>Son Tung MTP</h2>
									</div>
									<div class="option_card">
										<span class="glyphicon glyphicon-option-vertical"></span>
									</div>
								</div>
								<div class="content_card">
									<div class="media">
										<li class="item_singer_video ">
				                            <div class="singer_video_box">
				                                <div class="thumbnail_video_box" >
				                                    <a class="thumbnail_video" href="#" title="Đi Ngang Qua Nhau- Tống Gia Huy">
				                                        <span class="icon_play"></span>
				                                        <img  src="images/anh1.jpg" alt="Anh đợi em nhé - Lương Gia Bằng" title ="Anh đợi em nhé - Lương Gia Bằng">
				                                    </a>            
				                                </div>

				                                <div class="info_singer_video_box">
				                                    <span>Hạnh Phúc Thoáng Qua</span>
				                                </div>
				                            </div>
				                        </li>
									</div>
								</div>
								<div class="footer_card">
									<ul class="interaction"> 
										<li class="like"> 
											<span class="glyphicon glyphicon-heart"></span>&nbsp;<span class="like_counter">100</span> 
										</li> 
										<li class="comment"> 
											<a href="#"> 
												<span class="glyphicon glyphicon-comment"></span>&nbsp;100 
											</a> 
										</li> 
										<li class="view"> 
											<span> <span class="glyphicon glyphicon-eye-open"></span>&nbsp;5k </span> 
										</li> 
									</ul>
									<div style="clear:both;"> </div>
								</div>
							</div>
					    <% } %>
						</ul>
					<% } %>
						<br><br>
						<div style="display:none!important;">
							<button class="next_second_1"></button>
							<button class="next_second_2"></button>
							<button class="next_second_3"></button>
							<button class="prev_second_1"></button>
							<button class="prev_second_2"></button>
							<button class="prev_second_3"></button>
						</div>
					</div>
		        </div>
		        <!-- /.row -->
	        </div>


			<!-- Cover hay moi ngay -->
			<div class="first_content">
	        	<!-- Page Header -->
		        <div class="row title">
		            <div class="col-lg-12">
		                <h1 class="page-header">Cover Hay Moi Ngay
		                </h1>
		            </div>
		        </div>
		        <!-- /.row -->

		        <!-- Projects Row -->
		        <div class="row" style="overflow:hidden;">
		            
					<div class="col-md-12" style="padding-right:0;padding-left:0;">
					<% for(int i=0; i<3; i++){ %>
						<div class="row" style="margin-right: 15px; margin-left: 15px;">
						<% for(int j=0; j<4; j++){ %>
						    <div class="one_card col-md-3">
								<div class="header_card">
									<div class="img-circle avatar_member">
										<img class = "img-responsive" src="images/youtube_logo.png" alt="Avatar Member">
									</div>
									<div class="name_member">
										<h2>Son Tung MTP</h2>
									</div>
									<div class="option_card">
										<span class="glyphicon glyphicon-option-vertical"></span>
									</div>
								</div>
								<div class="content_card">
									<div class="media">
										<li class="item_singer_video ">
				                            <div class="singer_video_box">
				                                <div class="thumbnail_video_box" >
				                                    <a class="thumbnail_video" href="#" title="Đi Ngang Qua Nhau- Tống Gia Huy">
				                                        <span class="icon_play"></span>
				                                        <img  src="images/anh1.jpg" alt="Anh đợi em nhé - Lương Gia Bằng" title ="Anh đợi em nhé - Lương Gia Bằng">
				                                    </a>            
				                                </div>

				                                <div class="info_singer_video_box">
				                                    <span>Hạnh Phúc Thoáng Qua</span>
				                                </div>
				                            </div>
				                        </li>
									</div>
								</div>
								<div class="footer_card">
									<ul class="interaction"> 
										<li class="like"> 
											<span class="glyphicon glyphicon-heart"></span>&nbsp;<span class="like_counter">100</span> 
										</li> 
										<li class="comment"> 
											<a href="#"> 
												<span class="glyphicon glyphicon-comment"></span>&nbsp;100 
											</a> 
										</li> 
										<li class="view"> 
											<span> <span class="glyphicon glyphicon-eye-open"></span>&nbsp;5k </span> 
										</li> 
									</ul>
									<div style="clear:both;"> </div>
								</div>
							</div>
						<% } %>
						</div>
					<% } %>
						<br><br>
					</div>
		        </div>
		        <!-- /.row -->
	        </div>

	        <!-- List music -->
	        <!-- <div class="list_music">
	        	<div class="row">
		            <div class="col-md-4">
					    <h2 class="title-section"><a title="Nhạc Việt Hot" href="#" class="link-to-list">Nhạc Việt Hot <i class="icon-arrow"></i></a></h2>
					    <div class="list-item">
					        <ul>
					            <li class="one-song">
					                <a class="thumb-song" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">
					                    <img class="img-responsive img-circle" alt="Anh Vẫn Thấy" src="http://zmp3-photo.d.za.zdn.vn/thumb/94_94/covers/e/0/e0a93e9df0a781ff081d1414bdffc919_1487580385.jpg" width="50">
					                    <span class="icon-circle-play icon-small"></span>
					                </a>
					                <h3 class="title-song">
					                    <a class="" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">Anh Vẫn Thấy</a>
					                </h3>
					                <span class="singer">
					                    <h4><a href="#" title="Nghệ sĩ Trọng Hiếu">Trọng Hiếu</a></h4>
					                </span>
					                <div class="tool-song">
					                    <div class="icon-download"><a title="Download" class="link-download"></a></div>
					                    <div class="icon-addlist"><a title="Thêm vào" class="link-addlist"></a></div>
					                    <div class="icon-share"><a title="Chia sẻ" class="link-share"></a></div>
					                </div>
					                <div style="clear:both;"></div>
					            </li>
					            <li class="one-song">
					                <a class="thumb-song" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">
					                    <img class="img-responsive img-circle" alt="Anh Vẫn Thấy" src="http://zmp3-photo.d.za.zdn.vn/thumb/94_94/covers/e/0/e0a93e9df0a781ff081d1414bdffc919_1487580385.jpg" width="50">
					                    <span class="icon-circle-play icon-small"></span>
					                </a>
					                <h3 class="title-song">
					                    <a class="" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">Anh Vẫn Thấy</a>
					                </h3>
					                <span class="singer">
					                    <h4><a href="#" title="Nghệ sĩ Trọng Hiếu">Trọng Hiếu</a></h4>
					                </span>
					                <div class="tool-song">
					                    <div class="icon-download"><a title="Download" class="link-download"></a></div>
					                    <div class="icon-addlist"><a title="Thêm vào" class="link-addlist"></a></div>
					                    <div class="icon-share"><a title="Chia sẻ" class="link-share"></a></div>
					                </div>
					                <div style="clear:both;"></div>
					            </li>
					            <li class="one-song">
					                <a class="thumb-song" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">
					                    <img class="img-responsive img-circle" alt="Anh Vẫn Thấy" src="http://zmp3-photo.d.za.zdn.vn/thumb/94_94/covers/e/0/e0a93e9df0a781ff081d1414bdffc919_1487580385.jpg" width="50">
					                    <span class="icon-circle-play icon-small"></span>
					                </a>
					                <h3 class="title-song">
					                    <a class="" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">Anh Vẫn Thấy</a>
					                </h3>
					                <span class="singer">
					                    <h4><a href="#" title="Nghệ sĩ Trọng Hiếu">Trọng Hiếu</a></h4>
					                </span>
					                <div class="tool-song">
					                    <div class="icon-download"><a title="Download" class="link-download"></a></div>
					                    <div class="icon-addlist"><a title="Thêm vào" class="link-addlist"></a></div>
					                    <div class="icon-share"><a title="Chia sẻ" class="link-share"></a></div>
					                </div>
					                <div style="clear:both;"></div>
					            </li>
					            <li class="one-song">
					                <a class="thumb-song" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">
					                    <img class="img-responsive img-circle" alt="Anh Vẫn Thấy" src="http://zmp3-photo.d.za.zdn.vn/thumb/94_94/covers/e/0/e0a93e9df0a781ff081d1414bdffc919_1487580385.jpg" width="50">
					                    <span class="icon-circle-play icon-small"></span>
					                </a>
					                <h3 class="title-song">
					                    <a class="" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">Anh Vẫn Thấy</a>
					                </h3>
					                <span class="singer">
					                    <h4><a href="#" title="Nghệ sĩ Trọng Hiếu">Trọng Hiếu</a></h4>
					                </span>
					                <div class="tool-song">
					                    <div class="icon-download"><a title="Download" class="link-download"></a></div>
					                    <div class="icon-addlist"><a title="Thêm vào" class="link-addlist"></a></div>
					                    <div class="icon-share"><a title="Chia sẻ" class="link-share"></a></div>
					                </div>
					                <div style="clear:both;"></div>
					            </li>
					        </ul>
					    </div>
					</div>
					<div class="col-md-4">
					    <h2 class="title-section"><a title="Nhạc Việt Hot" href="#" class="link-to-list">Nhạc Việt Hot <i class="icon-arrow"></i></a></h2>
					    <div class="list-item">
					        <ul>
					            <li class="one-song">
					                <a class="thumb-song" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">
					                    <img class="img-responsive img-circle" alt="Anh Vẫn Thấy" src="http://zmp3-photo.d.za.zdn.vn/thumb/94_94/covers/e/0/e0a93e9df0a781ff081d1414bdffc919_1487580385.jpg" width="50">
					                    <span class="icon-circle-play icon-small"></span>
					                </a>
					                <h3 class="title-song">
					                    <a class="" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">Anh Vẫn Thấy</a>
					                </h3>
					                <span class="singer">
					                    <h4><a href="#" title="Nghệ sĩ Trọng Hiếu">Trọng Hiếu</a></h4>
					                </span>
					                <div class="tool-song">
					                    <div class="icon-download"><a title="Download" class="link-download"></a></div>
					                    <div class="icon-addlist"><a title="Thêm vào" class="link-addlist"></a></div>
					                    <div class="icon-share"><a title="Chia sẻ" class="link-share"></a></div>
					                </div>
					                <div style="clear:both;"></div>
					            </li>
					            <li class="one-song">
					                <a class="thumb-song" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">
					                    <img class="img-responsive img-circle" alt="Anh Vẫn Thấy" src="http://zmp3-photo.d.za.zdn.vn/thumb/94_94/covers/e/0/e0a93e9df0a781ff081d1414bdffc919_1487580385.jpg" width="50">
					                    <span class="icon-circle-play icon-small"></span>
					                </a>
					                <h3 class="title-song">
					                    <a class="" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">Anh Vẫn Thấy</a>
					                </h3>
					                <span class="singer">
					                    <h4><a href="#" title="Nghệ sĩ Trọng Hiếu">Trọng Hiếu</a></h4>
					                </span>
					                <div class="tool-song">
					                    <div class="icon-download"><a title="Download" class="link-download"></a></div>
					                    <div class="icon-addlist"><a title="Thêm vào" class="link-addlist"></a></div>
					                    <div class="icon-share"><a title="Chia sẻ" class="link-share"></a></div>
					                </div>
					                <div style="clear:both;"></div>
					            </li>
					            <li class="one-song">
					                <a class="thumb-song" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">
					                    <img class="img-responsive img-circle" alt="Anh Vẫn Thấy" src="http://zmp3-photo.d.za.zdn.vn/thumb/94_94/covers/e/0/e0a93e9df0a781ff081d1414bdffc919_1487580385.jpg" width="50">
					                    <span class="icon-circle-play icon-small"></span>
					                </a>
					                <h3 class="title-song">
					                    <a class="" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">Anh Vẫn Thấy</a>
					                </h3>
					                <span class="singer">
					                    <h4><a href="#" title="Nghệ sĩ Trọng Hiếu">Trọng Hiếu</a></h4>
					                </span>
					                <div class="tool-song">
					                    <div class="icon-download"><a title="Download" class="link-download"></a></div>
					                    <div class="icon-addlist"><a title="Thêm vào" class="link-addlist"></a></div>
					                    <div class="icon-share"><a title="Chia sẻ" class="link-share"></a></div>
					                </div>
					                <div style="clear:both;"></div>
					            </li>
					            <li class="one-song">
					                <a class="thumb-song" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">
					                    <img class="img-responsive img-circle" alt="Anh Vẫn Thấy" src="http://zmp3-photo.d.za.zdn.vn/thumb/94_94/covers/e/0/e0a93e9df0a781ff081d1414bdffc919_1487580385.jpg" width="50">
					                    <span class="icon-circle-play icon-small"></span>
					                </a>
					                <h3 class="title-song">
					                    <a class="" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">Anh Vẫn Thấy</a>
					                </h3>
					                <span class="singer">
					                    <h4><a href="#" title="Nghệ sĩ Trọng Hiếu">Trọng Hiếu</a></h4>
					                </span>
					                <div class="tool-song">
					                    <div class="icon-download"><a title="Download" class="link-download"></a></div>
					                    <div class="icon-addlist"><a title="Thêm vào" class="link-addlist"></a></div>
					                    <div class="icon-share"><a title="Chia sẻ" class="link-share"></a></div>
					                </div>
					                <div style="clear:both;"></div>
					            </li>
					        </ul>
					    </div>
					</div>
					<div class="col-md-4">
					    <h2 class="title-section"><a title="Nhạc Việt Hot" href="#" class="link-to-list">Nhạc Việt Hot <i class="icon-arrow"></i></a></h2>
					    <div class="list-item">
					        <ul>
					            <li class="one-song">
					                <a class="thumb-song" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">
					                    <img class="img-responsive img-circle" alt="Anh Vẫn Thấy" src="http://zmp3-photo.d.za.zdn.vn/thumb/94_94/covers/e/0/e0a93e9df0a781ff081d1414bdffc919_1487580385.jpg" width="50">
					                    <span class="icon-circle-play icon-small"></span>
					                </a>
					                <h3 class="title-song">
					                    <a class="" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">Anh Vẫn Thấy</a>
					                </h3>
					                <span class="singer">
					                    <h4><a href="#" title="Nghệ sĩ Trọng Hiếu">Trọng Hiếu</a></h4>
					                </span>
					                <div class="tool-song">
					                    <div class="icon-download"><a title="Download" class="link-download"></a></div>
					                    <div class="icon-addlist"><a title="Thêm vào" class="link-addlist"></a></div>
					                    <div class="icon-share"><a title="Chia sẻ" class="link-share"></a></div>
					                </div>
					                <div style="clear:both;"></div>
					            </li>
					            <li class="one-song">
					                <a class="thumb-song" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">
					                    <img class="img-responsive img-circle" alt="Anh Vẫn Thấy" src="http://zmp3-photo.d.za.zdn.vn/thumb/94_94/covers/e/0/e0a93e9df0a781ff081d1414bdffc919_1487580385.jpg" width="50">
					                    <span class="icon-circle-play icon-small"></span>
					                </a>
					                <h3 class="title-song">
					                    <a class="" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">Anh Vẫn Thấy</a>
					                </h3>
					                <span class="singer">
					                    <h4><a href="#" title="Nghệ sĩ Trọng Hiếu">Trọng Hiếu</a></h4>
					                </span>
					                <div class="tool-song">
					                    <div class="icon-download"><a title="Download" class="link-download"></a></div>
					                    <div class="icon-addlist"><a title="Thêm vào" class="link-addlist"></a></div>
					                    <div class="icon-share"><a title="Chia sẻ" class="link-share"></a></div>
					                </div>
					                <div style="clear:both;"></div>
					            </li>
					            <li class="one-song">
					                <a class="thumb-song" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">
					                    <img class="img-responsive img-circle" alt="Anh Vẫn Thấy" src="http://zmp3-photo.d.za.zdn.vn/thumb/94_94/covers/e/0/e0a93e9df0a781ff081d1414bdffc919_1487580385.jpg" width="50">
					                    <span class="icon-circle-play icon-small"></span>
					                </a>
					                <h3 class="title-song">
					                    <a class="" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">Anh Vẫn Thấy</a>
					                </h3>
					                <span class="singer">
					                    <h4><a href="#" title="Nghệ sĩ Trọng Hiếu">Trọng Hiếu</a></h4>
					                </span>
					                <div class="tool-song">
					                    <div class="icon-download"><a title="Download" class="link-download"></a></div>
					                    <div class="icon-addlist"><a title="Thêm vào" class="link-addlist"></a></div>
					                    <div class="icon-share"><a title="Chia sẻ" class="link-share"></a></div>
					                </div>
					                <div style="clear:both;"></div>
					            </li>
					            <li class="one-song">
					                <a class="thumb-song" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">
					                    <img class="img-responsive img-circle" alt="Anh Vẫn Thấy" src="http://zmp3-photo.d.za.zdn.vn/thumb/94_94/covers/e/0/e0a93e9df0a781ff081d1414bdffc919_1487580385.jpg" width="50">
					                    <span class="icon-circle-play icon-small"></span>
					                </a>
					                <h3 class="title-song">
					                    <a class="" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">Anh Vẫn Thấy</a>
					                </h3>
					                <span class="singer">
					                    <h4><a href="#" title="Nghệ sĩ Trọng Hiếu">Trọng Hiếu</a></h4>
					                </span>
					                <div class="tool-song">
					                    <div class="icon-download"><a title="Download" class="link-download"></a></div>
					                    <div class="icon-addlist"><a title="Thêm vào" class="link-addlist"></a></div>
					                    <div class="icon-share"><a title="Chia sẻ" class="link-share"></a></div>
					                </div>
					                <div style="clear:both;"></div>
					            </li>
					        </ul>
					    </div>
					</div>
				</div>
	        </div> -->
	        <div class = "top_member">
	        <!-- Page Header -->
		        <div class="row title">
		            <div class="col-lg-12">
		                <h1 class="page-header">Top Nguoi Dang Noi Bat
		                </h1>
		            </div>
		        </div>
		        <!-- /.row -->
	        <% for(int i=0; i<2; i++) {%>
	        	<div class="row">
	        		<% for(int j=0; j<4; j++){ %>
						<div class="col-md-3 one_member text-center">
						<a href = "">
			                <img src="images/t1.jpg" alt="Son Tung MTP" class="img-responsive img-circle">
			                <div class="name_of_member">
			                	<p>Son Tung MTP</p>
			                </div>
			            </a>
			            </div>
	        		<% } %>
	        	</div>
	        <% } %>
	        </div>
		</div> <!-- main content -->
	</content>
	<footer class="footer-distributed">
			<div class="footer-left">
				<h3>Company<span>logo</span></h3>
				<p class="footer-links">
					<a href="#">Home</a> ·
					<a href="#">Blog</a> ·
					<a href="#">Pricing</a> ·
					<a href="#">About</a> ·
					<a href="#">Faq</a> ·
					<a href="#">Contact</a>
				</p>
				<p class="footer-company-name">Company Name &copy; 2015</p>
			</div>
			<div class="footer-center">
				<div>
					<i class="fa fa-map-marker"></i>
					<p><span>21 Revolution Street</span> Paris, France</p>
				</div>
				<div>
					<i class="fa fa-phone"></i>
					<p>+1 555 123456</p>
				</div>
				<div>
					<i class="fa fa-envelope"></i>
					<p><a href="mailto:support@company.com">support@company.com</a></p>
				</div>
			</div>
			<div class="footer-right">
				<p class="footer-company-about">
					<span>About the company</span>
					Lorem ipsum dolor sit amet, consectateur adispicing elit. Fusce euismod convallis velit, eu auctor lacus vehicula sit amet.
				</p>
				<div class="footer-icons">
					<a href="#"><i class="fa fa-facebook"></i></a>
					<a href="#"><i class="fa fa-twitter"></i></a>
					<a href="#"><i class="fa fa-linkedin"></i></a>
					<a href="#"><i class="fa fa-github"></i></a>
				</div>
			</div>
		</footer>
		<script>
			$(document).ready(function(){
				$('._2tga').css('width', '115px !important');
			});
		</script>	
</body>
</html>