<%--
  Created by IntelliJ IDEA.
  User: nguyenthanhtung
  Date: 19/05/2017
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="information_person main_person">
    <div class="subhead">
        <h2 class="subhead-heading">Thông Tin Công Khai</h2>
    </div>
    <form accept-charset="UTF-8" action="" class="form_person" method="post">
        <dl class="form-group float-right col-md-4">
            <dt><label>Ảnh Đại Diện</label></dt>
            <dd class="" style="padding:0; width:100%;">
                <img alt="" class="avatar"
                     src="${userInfo.account.avatarThumbnail}">
                <div class="btn btn-success avatar-upload">
                    <label>
                        Cập Nhật Ảnh Đại Diện
                        <input id="choose_file" type="file" role="button" accept="image/*">
                    </label>
                </div>
            </dd>
        </dl>

        <div class="col-md-8">
            <dl class="form-group">
                <dt><label for="user_profile_name">Họ Và Tên</label></dt>
                <dd><input class="form-control" id="user_profile_name" name="" size="30"
                           value="${userInfo.account.fullname}" type="text"></dd>
            </dl>
            <dl class="form-group">
                <dt><label>Email</label></dt>
                <input type="email" class="form-control"/>
            </dl>
            <dl class="form-group">
                <dt><label for="user_profile_bio">Mô tả </label></dt>
                <dd class="">
                                <textarea
                                        class="form-control"
                                        cols="20" id="user_profile_bio"
                                        name="" placeholder="Hãy nói một chút về bạn!"
                                        rows="7">${userInfo.description}</textarea>
                    <div class="suggester-container">
                        <div class="suggester"
                             data-url="/autocomplete/user-suggestions">
                        </div>
                    </div>
                </dd>
            </dl>
            <dl class="form-group">
                <dt><label>Ngày sinh</label></dt>
                <dd><input class="form-control" id="calendar" name="" size="30"
                           value="${userInfo.formatTimestamp(userInfo.dateOfBirth)}" type="date"></dd>
            </dl>

            <dl class="form-group">
                <dt><label for="user_profile_location">Địa Chỉ: </label></dt>
                <dd><input class="form-control" id="user_profile_location" name=""
                           size="30" value="${userInfo.address}" type="text"></dd>
            </dl>
            <p>
                <button type="submit" class="btn btn-success">Cập nhật</button>
            </p>
        </div>
    </form>
</div>
