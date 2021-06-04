<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">
    <script src="jquery/jquery-2.1.2.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            $("button").click(function () {
                window.history.back(-1);
            });
        });
    </script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<div class="container">
    <h1 style="text-align: center;">呜呜呜请求出现了错误</h1>
    <h2 style="text-align: center;">错误消息：${requestScope.exception.message}</h2>
    <br/><br/>
    <button style="width:150px;margin: 0 auto;" class="btn btn-lg btn-success btn-block" >返回上一步</button>
</div>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>