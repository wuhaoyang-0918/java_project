<%--
  Created by IntelliJ IDEA.
  User: 昊洋
  Date: 2021/8/16
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax请求</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js" ></script>
   <%-- <script type="text/javascript">
        /*get的请求*/
        $(function(){
            //绑定事件
            $("#btnAjax").on("click",function(){
              $.ajax({
                  url:"ajx",
                  type:"GET",//默认就是get请求
                  dataType:"json",
                  data:{name:"lisi", age:12},             //{"name":"lisi", "age":12}
                  success:function (res){
                     //alert("res"+res.name+"->"+res.age) //返回单个json对象
                      $.each(res,function (i,n){          //返回一个json数组
                           alert(n.name+"--"+n.age)
                      })
                   }
              })

            })
        })
    </script>--%>
   <%-- <script type="text/javascript">
        /*post请求*/
        $(function(){
            $("#btnAjax").on("click",function(){
               // var da={"name":"战兽","age":11};//或者{name:"战兽",age:11};
                $.ajax({
                    url:"ajx",
                    type:"POST",
                    contentType: "application/json;charset=UTF-8",//请求体的参数类型(必须)
                    data:JSON.stringify({name:"战兽",age:11}),    //将json对象转换为JSON字符串
                    dataType : "json",
                    success:function (res){
                        alert(res.name+"-->"+res.age)
                    }
                })

            })
        })
    </script>--%>
    <script type="text/javascript">
       //返回String类型，解决中文乱码
        $(function(){
            //绑定事件
            $("#btnAjax").on("click",function(){
                $.ajax({
                    url:"ajxS",
                    type:"GET",//默认就是get请求
                    dataType:"text",//后端返回String类型
                    data:{name:"lisi", age:12},           //{"name":"lisi", "age":12}
                    success:function (res){
                       alert(res)
                    }
                })

            })
        })
    </script>
</head>
<body>
<button id="btnAjax">发起ajax请求</button>
</body>
</html>
