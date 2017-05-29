<c:forEach var="item" varStatus="i" items="${hotList}">
    <li id="li${i.index}" class="top-search" rel="${i.index}">
        <a class="tkw" href="">
            <span class="top-number top-number-${i.index+1}">${i.index+1}</span>
            <span></span>
        </a>
    </li>
</c:forEach>

<li class="playlist">
    <div class="one_playlist">
        <a class="image_playlist" href="">
            <img class="thumb"
                 src="http://${item.playlistThumbnaiLink}"
                 alt="${item.description}"
                 width="55" height="55">
        </a>
        <div class="info-table">
            <h4 class="name_playlist">
                <a href=""
                   title="${item.playlistName}">${item.playlistName}</a>
            </h4>
            <div class="member_post">
                <a href="/user/${item.account.id}"
                   title="Nghệ sĩ ${item.account.fullname}">
                    <img src="../../../resources/storage/image/thumbnail/owner_thumbnail/avatar1.jpg"
                         class="img-circle avatar_member">
                    <p>${item.account.fullname}</p>
                </a>
            </div>
        </div>
    </div>
</li>