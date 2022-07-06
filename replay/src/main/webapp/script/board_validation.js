/**
 * 
 */

// 로그인한 상태인지 체크. 로그인 해야만 이용가능한 기능에 사용
function loginLogCk(log){
	if(log===""||log===null||log===undefined){
		alert("로그인이나 해");
	}	
	else{
		location.href="boardWriteForm.jsp";
	}
}
// 게시글 작성 후 글쓰기 완료시 내용이 비어있지 않은 지 체크.
function boardContentsCheck(form){
	if(form.title.value===""){
		alert("제목이 비어있습니다.");
	}
	else if(form.contents.value===""){ 
		alert("내용이 비어있습니다.");
	}
	else{
		form.submit();		
	}
}

$('#boardSet').click(function () {
	console.log($('#boardSet'));
	
	
})

