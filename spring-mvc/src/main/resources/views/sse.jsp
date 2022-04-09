<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>SSE演示</title>
</head>
<body>
<div id="messagePush"></div>
<script type="text/javascript" src="../jquery-3.6.0.min.js"></script>
<script type="text/javascript">
    if(!!window.EventSource){
        const source = new EventSource("push");
        let s = "";
        source.addEventListener("message", function(e){
            s += e.data + "<br/>";
            $("#messagePush").html(s);
        });
        source.addEventListener("open", function(e){
            console.log("连接打开.");
        }, false);
        source.addEventListener("error", function(e){
            if(e.readyState === EventSource.CLOSED){
                console.log("连接关闭.");
            }else{
                console.log(e.readyState);
            }
        }, false);
    }else{
        console.log("你的浏览器不支持SSE.")
    }
</script>
</body>
</html>