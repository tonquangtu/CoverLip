<%--
  Created by IntelliJ IDEA.
  User: Khanh Nguyen
  Date: 13/5/2017
  Time: 7:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<footer class="footer">
    <p style="padding-right: 20px;">Developed by Khanh Nguyen</p>
</footer>

<script>
    function openNav() {
        document.getElementById("left-nav").style.width = "17.7%";
        document.getElementById("main-content").style.marginLeft = "17.7%";
//        document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
    }

    function closeNav() {
        document.getElementById("left-nav").style.width = "0";
        document.getElementById("main-content").style.marginLeft = "0";
//        document.body.style.backgroundColor = "white";
    }

</script>
<script src="/resources/scripts/admin/admin.js"></script>
