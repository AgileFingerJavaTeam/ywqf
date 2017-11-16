<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../common/meta.jsp" %>
<%-- 自定义css样式 --%>
<meta charset="UTF-8">
<meta content="text/html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="PropertyFeePayment/updateOver" method="post">
    <input type="text"  name=id
           value="${data.id}"/>
    <input type="text"  name=status
           value="${data.status}" style="display: none; " />
    <table cellpadding="10" style="text-align: center;" id="table_at" >
        <tr style="height: 100px;">
            <td style="text-align: center;">是否改为作废状态？</td>
        </tr>
        <tr style="height: 60px;">
            <td>
                <div>
                    <button class="btn btn-primary" id="submit" data-keyboard="ture">确定</button>
                    <button class="btn" onclick="layer_close();">关闭</button>
                </div>
            </td>
        </tr>
    </table>

<%@ include file="../common/footer.jsp" %>
<script type="text/javascript">
    $('#submit').on('click',function(){
        $.ajax({

        })
    })
   $('#close').on('click',function(){
       var index=parent.layer.getFrameIndex(window.name);
       parent.layer.close(index);
   })

</script>
</body>
</html>