<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ParkingFeePayment/updateOver" class="table_form" method="post">
    <input type="text"  name=id
           value="${data.id}" style="display: none; " />
    <input type="text"  name=status
           value="${data.status}" style="display: none; " />
    <table cellpadding="10"  class="table_list" >
        <tr style="height: 100px;">
            <td style="text-align: center;">是否改为作废状态？</td>
        </tr>
        <tr style="height: 60px;">
            <td>
                <button type="button" class="table_form_close_dialog "
                        style="float: right">关闭</button>
                <button type="button" class="table_form_submit_dialog"
                        style="float: right">确定</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>