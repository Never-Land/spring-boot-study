<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>HTTP信息转换演示</title>
    <script type="text/javascript" src="../assets/jquery-3.6.0.min.js"></script>
</head>
<body>
<div id="resp">
    <input type="button" onclick="setParams();" value="设置参数">
</div>
<script type="text/javascript">
    function setParams(){
        $.ajax({
            url: "convert",
            data: "1-yangYiFan",
            type: "POST",
            contentType: "application/x-wisely",
            success: function(data){
                $("#resp").html(data);
            }
        });
    }
</script>
</body>
</html>