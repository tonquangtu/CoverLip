<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<div class="card_playlist" style="background-color:${item.randomColor} ">
    <img src="http://${item.playlistThumbnaiLink}" class="avatar_playlist">
    <ul class="avatar_cover_list">
        <c:forEach var="itemCover" items="${item.items}" varStatus="j" end="4">
            <li><img src="${itemCover.item.video.videoThumbnailLink}"
                     class="img-circle img-responsive"></li>
        </c:forEach>
    </ul>
    <div class="info_card_playlist">
        <p><strong>${item.numView} view</strong></p>
        <h5><strong>${item.playlistName}</strong></h5>
        <div class="member_post">
            <img src="/resources/storage/image/thumbnail/owner_thumbnail/avatar1.jpg"
                 class="img-circle avatar_member">
            <a href="#">${item.account.fullname}</a>
        </div>
    </div>
</div>