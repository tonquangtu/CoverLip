<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Playlist</title>

	 <!-- Latest compiled and minified CSS -->
	 <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="/resources/libs/jb/bootstrap.min.css">
	<!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<!-- <script src="https://use.fontawesome.com/479981a8a3.js"></script> -->
	<link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css">

	<script src="font-awesome/js/" type="text/javascript"></script>
    
    <link rel="stylesheet" type="text/css" href="/resources/styles/card_playlist_cover_style.css">

    <link rel="stylesheet" type="text/css" href="/resources/styles/playlist_cover_page_style.css">

	<script src="https://www.w3schools.com/lib/w3data.js"></script> 

</head>

<body>

	<%--<%@include file="../common/main_header.jsp"%>--%>
	
	<content>
        <div id="main_content_playlist" class="container">
            
            <h1>Tổng hợp playlist cover</h1>

            <div class=content_page_playlist>

                <div class="order">
                    
                    <p>Sắp xếp</p>
                    <div class="dropdown">
                        
                        <button type="button" class="btn btn-primary dropdown-toggle btn-xs" data-toggle=dropdown>
                            Ngày
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="#">Ngày</a></li>
                            <li><a href="#">Tháng</a></li>
                            <li><a href="#">Năm</a></li>
                        </ul>
                    </div>
                </div>

                <c:forEach var="item" items="${playlistList}" varStatus="i">

                    <c:if test="${i.index % 4 == 0}">

                        <div class="row list_playlist">
                    </c:if>

                        <div class="col-md-3">
                            <div class="card_playlist">
                                <img src="${item.playlistThumbnaiLink}" class="avatar_playlist">

                                <ul class="avatar_cover_list">
                                    <c:forEach var="itemCover" items="${item.items}" varStatus="j">

                                        <li><img src="${itemCover.item.video.videoThumbnailLink}" class="img-circle img-responsive"></li>
                                    </c:forEach>
                                </ul>


                                <div class="info_card_playlist">

                                    <p><strong>${item.numView} view</strong></p>
                                    <h5><strong>${item.playlistName}</strong></h5>

                                    <div class="member_post">

                                        <img src="/resources/storage/image/thumbnail/owner_thumbnail/avatar1.jpg" class="img-circle avatar_member">
                                        <p>${item.account.fullname}</p>
                                    </div>

                                </div>

                            </div>
                        </div>


                    <c:if test="${i.index % 4 == 3}">

                        </div>
                    </c:if>


                </c:forEach>
                

                    


                    



            </div>
        </div>
	</content>



    <%--<%@include file="../common/main_footer.jsp"%>--%>

	<script type="text/javascript">
		w3IncludeHTML();
	</script>

</body>
</html>