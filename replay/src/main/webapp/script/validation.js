
//입력 글자수 제한
function handleOnInput(el, maxlength) {
  if(el.value.length > maxlength)  {
    el.value = el.value.substr(0, maxlength);
  }
}

//이메일 @체크
function emailCheck(id){
    let emailCk=0;
    if($(`#${id}`).val()===''){
        $(`#${$(`#${id}`).attr('class')}`).attr('style','display:none;color: red;font-size: 10px;');
		
	}
	else{
        for(let n=0; n<$(`#${id}`).val().length-1; n++){
            if($(`#${id}`).val().substring(n,n+1)==='@'){
                emailCk++;
            }
        }
        if(emailCk===0){
            $(`#${$(`#${id}`).attr('class')}`).attr('style','display:block;color: red;font-size: 10px;');

        }
        else{
            $(`#${$(`#${id}`).attr('class')}`).attr('style','display:none;color: red;font-size: 10px;');
        }
		
	}
}

// null체크 빨간글씨출력
function blurNulls(id){
    if($(`#${id}`).val()===''||$(`#${id}`).val()==='월'){
		$(`#${$(`#${id}`).attr('class')}`).attr('style','display:block;color: red;font-size: 10px;');
	}
	else{
		$(`#${$(`#${id}`).attr('class')}`).attr('style','display:none;color: red;font-size: 10px;');
	}
}

//회원가입 체크
function joinCheck(form){
	if($('#id').val()!=='' && $('#pw').val()!=='' && $('#name').val()!=='' && $('#year').val()!==''
	&& $('#month').val()!=='월' && $('#day').val()!=='' && $('#gender').val()!=='0' && $('#mobile').val()!==''
	&& $('#mobileCk').val()!==''){
		if($('#pw').val()===$('#pwck').val()){
			form.submit();
		}
		else{
			alert('비밀번호가 일치하지 않습니다.');
		}
	}
	else{
		alert('필수 사항을 적어주세요');
	}
}
//로그인 체크
function loginCk(form){
	if($('#id').val()!=='' && $('#pw').val()!==''){
			form.submit();
	}
	else{
		alert('필수 사항을 적어주세요');
	}
}






