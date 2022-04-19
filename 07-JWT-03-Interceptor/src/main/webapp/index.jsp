<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>主页</title>
</head>
<body>
<h1 align="center" style="color: yellowgreen"><span id="username"></span>登陆成功</h1>
<script type="application/javascript">
  //页面渲染时执行
  $(function () {
    var token=localStorage.getItem("token");

    if(token===null){

      $(location).attr('href',"/login.html");
    }else {
      $.ajax({
        type:"post",
        url:"/user/verifyToken",
        headers:{"token":token},
        success:function (resp) {
          if (resp.success){
            alert(resp.message);
            $("#username").text(resp.data.username);

          }else {
            alert(resp.message);
            $(location).attr('href',"/login.html");
          }
        }
      })
    }
  })
</script>
</body>
</html>