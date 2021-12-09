var reEmail = /^[\w\-]+@(?:(?:[\w\-]{2,}\.)+[a-zA-Z]{2,})$/;
var isEmailOk = false;
$(function(){
	$('input[name=email]').focusout(function(){
		var email = $('input[name=email]').val();
		var jsonData = {'email':email};		
		$.ajax({
			url: '/AJAX/member/checkEmail',
			type: 'GET',
			data: jsonData,
			dataType: 'json',
			success: function(data){
					
				if(data.result == 1){    		
					$('.resultEmail').css('color', 'red').text('이미 사용중인 이메일 입니다.');
					isEmailOk = false;
				}else if( email==''){
					$('.resultEmail').css('color', 'red').text('이메일을 입력하세요.');
					isEmailOk = false;
				}else if(data.result==0){
					 if(reEmail.test(email)){
						$('.resultEmail').css('color', 'green').text('사용할 수 있는 이메일 입니다.');
						isEmailOk = true;
					}else{//유효성검사하기
					$('.resultEmail').css('color', 'red').text('이메일 양식에 맞지 않습니다.');
					isEmailOk = false;
					}
				}
			}    				
		});
		});
		
		
	$('a[class=RegiBtn]').click(function(){
	//  input[name=singyu-email]
		
		if(!isEmailOk){
			
			return false; // 전송취소	
		}
	});
});