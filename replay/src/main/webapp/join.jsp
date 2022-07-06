<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
</head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<link rel="stylesheet" href="css/form.css">
    <title>JOIN</title>
</head>
<body>
    <h1>JOIN</h1>
    <form method="post" action="joinPro.jsp">
        <div class="contents">
        	아이디<br>
        	<input type="text" class="idmsg" name="id" id="id" onblur="blurNulls(id)"><br>
        	<span style="display:none;color: red;" aria-live="assertive" id="idmsg">필수 정보입니다.</span>
        	비밀번호<br>
        	<input type="password" class="pwmsg" name="pw" id="pw" onblur="blurNulls(id)"><br>
        	<span style="display:none;color: red;" aria-live="assertive" id="pwmsg">필수 정보입니다.</span>
        	비밀번호 재확인<br>
        	<input type="password" class="pwckmsg" name="pw" id="pwck" onblur="blurNulls(id)"><br>
        	<span style="display:none;color: red;" aria-live="assertive" id="pwckmsg">필수 정보입니다.</span>
        	이름<br>
        	<input type="text" class="namemsg" name="name" id="name" onblur="blurNulls(id)"><br>
        	<span style="display:none;color: red;" aria-live="assertive" id="namemsg">필수 정보입니다.</span>
        	생년월일<br>
        	<input type="number" onblur="blurNulls(id)" class="datemsg" name="year" placeholder="년(4자)" id="year" oninput="handleOnInput(this,4)">
        	<select name="month" class="datemsg" id="month" onblur="blurNulls(id)">
        		<option value>월</option>
        		<option value="1">1</option>
        		<option value="2">2</option>
        		<option value="3">3</option>
        		<option value="4">4</option>
        		<option value="5">5</option>
        		<option value="6">6</option>
        		<option value="7">7</option>
        		<option value="8">8</option>
        		<option value="9">9</option>
        		<option value="10">10</option>
        		<option value="11">11</option>
        		<option value="12">12</option>
        	</select>
        	<input type="number" onblur="blurNulls(id)" class="datemsg" name="day" id="id" placeholder="일" oninput="handleOnInput(this,2)"><br>
        	<span style="display:none;color: red;" aria-live="assertive" id="datemsg">필수 정보입니다.</span>
        	성별<br>
        	<select name="gender" class="gendermsg" id="gender" onblur="blurNulls(id)">
        		<option value=0>선택 안함</option>
        		<option value=1>남자</option>
        		<option value=2>여자</option>
        	</select><br>
        	<span style="display:none;color: red;" aria-live="assertive" id="gendermsg">필수 정보입니다.</span>
        	본인 확인 이메일(선택)<br>
        	<input type="text" onblur="emailCheck(id)" class="emailmsg" id="email" name="email" placeholder="선택입력">
        	<span style="display:none;color: red;" aria-live="assertive" id="emailmsg">이메일 형태가 아닙니다.</span><br>
        	휴대전화<br>
        	<select name="coun">
        		<option value="kor">대한민국 +82</option>
        	</select>
        	<input type="text" placeholder="전화번호 입력" name="mobile" id="mobile" class="mobilemsg" onblur="blurNulls(id)">
        	<input type="button" value="인증번호 받기" onclick="location.href='https://www.naver.com/'"><br>
        	<input type="text" placeholder="인증번호를 입력하세요" id="mobileCk" class="mobilemsg" onblur="blurNulls(id)"><br>
        	<span style="display:none;color: red;" aria-live="assertive" id="mobilemsg">필수 정보입니다.</span>
        </div>
        <div class="buttons">
        	<input type="button" value="가입" onclick="joinCheck(form)">
        	<input type="button" value="취소" onclick="location.href='lndex.jsp'">
        </div>
    </form>
	
    <script src="script/validation.js"></script>
</body>
</html>