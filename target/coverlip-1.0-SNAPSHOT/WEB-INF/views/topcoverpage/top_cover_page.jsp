<%--
Created by IntelliJ IDEA.
User: nguyenthanhtung
Date: 25/04/2017
Time: 08:36
To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CoverLip</title>
    <%@ include file="../common/common_lib.html" %>

    <link rel="stylesheet" href="/resources/styles/main_navigation_style.css"/>
    <link rel="stylesheet" href="/resources/styles/main_header_style.css"/>
    <link rel="stylesheet" href="/resources/styles/main_footer_style.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/styles/top_cover_page_style.css"/>

</head>
<body>
<%@include file="../common/main_header.jsp" %>

<content>
    <div class="container">
        <div class="col-md-12">
            <div class="title_top_cover text-center">
                <h1>Bảng Xếp Hạng</h1>
                <p>Cập nhật vào Thứ Hai hàng tuần, dữ liệu được thống kê từ Zing MP3 (BXH Zing) và tham khảo các BXH âm nhạc uy tín khác như Billboard (US-UK), Soompi (K-Pop)</p>
            </div>
        </div>
        <div class="col-md-9">
            <div class="box_view_week">
                <a id="prev_foo_video_more" class="prev" href="http://www.nhaccuatui.com/bai-hat/top-20.nhac-viet.tuan-17.2017.html" style="display: block;" title="Bảng xếp hạng tuần trước"></a>
                <h2><strong>Tuần 18</strong> (30/04/2017 - 06/05/2017)</h2>
                <a id="next_foo_video_more" class="next" href="http://www.nhaccuatui.com/bai-hat/top-20.nhac-viet.tuan-19.2017.html" style="display: none;" title="Bảng xếp hạng tuần kế tiếp"></a>
                <a href="javascript:;" title="Chọn ngày" class="select_date" id="select_date"></a>
                <a href="http://www.nhaccuatui.com/playlist/top-20-bai-hat-viet-nam-nhaccuatui-tuan-172017-va.KzulS3wj8Tb3.html" class="active_play" title="Nghe Toàn Bộ"><span class="icon_playall"></span>Nghe Toàn Bộ</a>
            </div>
            <div class="list-item">
                    <ul>
                        <c:forEach begin="0" end="10" varStatus="i">
                        <li class="one-song">
                            <span class="priority">${i.count}</span>
                            <span class="change">
			            		<span class=""></span>
			            		<p>6</p>
			            	</span>
                            <a class="thumb-song" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">
                                <img class="img-responsive img-circle" alt="Anh Vẫn Thấy" src="http://zmp3-photo.d.za.zdn.vn/thumb/94_94/covers/e/0/e0a93e9df0a781ff081d1414bdffc919_1487580385.jpg" width="50">
                                <span class="icon-circle-play icon-small"></span>
                            </a>
                            <div class="tool-song">
                                <div class="icon-download"><a title="Download" class="link-download"></a></div>
                                <div class="icon-addlist"><a title="Thêm vào" class="link-addlist"></a></div>
                                <div class="icon-share"><a title="Chia sẻ" class="link-share"></a></div>
                            </div>
                            <div style="width:100%;">
                                <h3 class="title-song">
                                    <a class="" href="#" title="Bài hát Anh Vẫn Thấy - Trọng Hiếu">Anh Vẫn Thấy</a>
                                </h3>
                                <span class="singer">
				                    <h4><a href="#" title="Nghệ sĩ Trọng Hiếu">Trọng Hiếu</a></h4>
				                </span>
                                <div class="footer_card">
                                    <ul class="interaction">
                                        <li class="like">
                                            <img src="/resources/icons/icon_like.svg" alt="" class="icon_react">&nbsp;<span
                                                class="like_counter">100</span>
                                        </li>
                                        <li class="comment">
                                            <a href="#">
                                                <img src="/resources/icons/icon_comment.svg" alt="" class="icon_react">&nbsp;100
                                            </a>
                                        </li>
                                        <li class="view">
                                            <span> <img src="/resources/icons/icon_view.svg" alt="" class="icon_react">&nbsp;100 </span>
                                        </li>
                                    </ul>
                                    <div style="clear:both;"></div>
                                </div>
                            </div>

                            <div style="clear:both;"></div>
                        </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        <div class="col-md-3" style="background:red; height:500px">

        </div>
    </div>
</content>

<%@ include file="/WEB-INF/views/common/main_footer.jsp" %>
</body>
</html>
