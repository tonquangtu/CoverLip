<c:forEach var="item" varStatus="i" items="${hotList}">
    <li id="li${i.index}" class="top-search" rel="${i.index}">
        <a class="tkw" href="">
            <span class="top-number top-number-${i.index+1}">${i.index+1}</span>
            <span></span>
        </a>
    </li>
</c:forEach>