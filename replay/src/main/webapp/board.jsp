<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="css/board.css">
</head>
<body>
    <h1>DOOOO BOARD</h1>
    <div class="boardListContainer">
        <table border="1">
            <thead>
                <th>no</th>
                <th>code</th>
                <th>title</th>
                <th>viewCnt</th>
                <th>likeCnt</th>
                <th>createdAt(작성일)</th>
                <th>modifiedAt(수정일)</th>


            </thead>
            <tbody>
                <tr>
                    <td><%=no%></td>
                    <td><%=code%></td>
                    <td><%=title%></td>
                    <td><%=viewCnt%></td>
                    <td><%=likeCnt%></td>
                    <td><%=createdAt%></td>
                    <td><%=modifiedAt%></td>

                </tr>


            </tbody>
        </table>


    </div>
</body>
</html>