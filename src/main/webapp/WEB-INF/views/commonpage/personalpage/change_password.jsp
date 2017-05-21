<%--
  Created by IntelliJ IDEA.
  User: nguyenthanhtung
  Date: 19/05/2017
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="change_password main_person">
    <div class="subhead">
        <h2 class="subhead-heading">Thay Đổi Mật Khẩu</h2>
    </div>
    <form accept-charset="UTF-8" action="" class="" method="post" style="margin-top:45px;">
        <div class="form-group">
            <label class="col-sm-2 col-sm-offset-2 control-label">Mật Khẩu Cũ</label>
            <div class="col-sm-6">
                <input type="password" class="form-control" id="old_password" placeholder="">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 col-sm-offset-2 control-label">Mật Khẩu Mới</label>
            <div class="col-sm-6">
                <input type="password" class="form-control" id="new_password" placeholder="">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 col-sm-offset-1 control-label">Xác Nhận Mật Khẩu</label>
            <div class="col-sm-6">
                <input type="password" class="form-control" id="confirm_password" placeholder="">
            </div>
        </div>
        <button type="submit" class="col-sm-3 col-sm-offset-5 btn btn-primary">Thay Đổi Mật Khẩu</button>

    </form>
</div>
