
//mvc2일때 url이 수정되어야됨
function idCheck(id) {
	if(id == "") {
		alert("아이디를 입력해.");
		document.regForm.id.focus();
	}else {
		//파라미터를 두개 연결할때 &(and)로 연결
	 url = "member.mdo?cmd=idCheck&id="+id
	 window.open(url, "post", "width=300, height=150");	
	}
}

/*주소 검색*/
function zipCheck() {
	
	url = "member.mdo?cmd=zipCheck&check=y";
	window.open(url, "post", "toolbar = no, width=500, height=300, directories=no, status=yes, scrollbars=yes, menubar=no");
	
	
}

function dongCheck() {
	if(document.zipForm.dong.value=="") {
		alert("동 이름을 입력해주세요.");
		document.zipForm.dong.focus();
		return;
	}
	document.zipForm.submit();
}


/*주소를 검색했을때 자동으로 채워넣어줄수 있는 함수 검색을했을때 자동으로 채워줘야되는 부분이 regForm의 주소부분임
자기자신을 닫게 self.close*/
function sendAddress(zipcode,sido,gugun,dong,ri,bunji) { 
	var address = sido+" "+gugun+" "+dong+" "+ri+" "+bunji;
	opener.document.regForm.zipcode.value = zipcode;
	opener.document.regForm.address1.value = address;
	self.close();
}

/*유효성 검사 이메일이 맞는지 비밀번호가 맞는지 등등 */
function inputCheck() {
	/*아이디 먼저 검사*/
	if(document.regForm.id.value==""){
		alert("아이디를 입력해주세요.");
		document.regForm.id.focus();
		/*중지*/
		return;
	}
	if(document.regForm.pass.value==""){
		alert("비밀번호를 입력해주세요.");
		document.regForm.pass.focus();
		/*중지*/
		return;
	}
	if(document.regForm.repass.value==""){
		alert("비밀번호를 똑같이 입력해주세요.");
		document.regForm.repass.focus();
		/*중지*/
		return;
	}
	if(document.regForm.pass.value !=document.regForm.repass.value){
		alert("비밀번호가 일치 하지 않습니다 똑바로 입력해");
		document.regForm.repass.focus(); /*비밀번호를 repass에 focus로 맞춘다.*/
		/*중지*/
		return;
	}
	if(document.regForm.name.value==""){
		alert("이름을 입력해주세요.");
		document.regForm.name.focus();
		/*중지*/
		return;
	}
	if(document.regForm.phone1.value==""){
		alert("통신사를 입력해주세요.");
		document.regForm.phone1.focus();
		/*중지*/
		return;
	}
	if(document.regForm.phone2.value==""){
		alert("전화번호를 입력해주세요.");
		document.regForm.phone2.focus();
		/*중지*/
		return;
	}
	if(document.regForm.phone3.value==""){
		alert("전화번호를 입력해주세요.");
		document.regForm.phone3.focus();
		/*중지*/
		return;
	}
	if(document.regForm.email.value==""){
		alert("email을 입력해주세요.");
		document.regForm.email.focus();
		/*중지*/
		return;
	}
	/*email 유효성 검사 해야된다.*/
	//ex)hong@naver.com(이메일 형식 검사)
	var str= document.regForm.email.value;
	var atPos = str.indexOf('@');  //골뱅이 앞뒤 위치 
	var atLastPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.');
	var spacePos =str.indexOf(' '); //공백 스페이스버튼 하나 저걸 몇개 뛰어서 설정하면 리턴할떄 오류남
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;
																						//+1은 인덱스 하나 추가
	if(atPos > 1 && atPos == atLastPos && dotPos > 3 && spacePos == -1 && commaPos == -1 && atPos +1 < dotPos && dotPos + 1 < eMailSize){
	}else {
		alert("E_Mail 주소 형식이 잘못 되었습니다. \n\r 다시 입력 해'줘'");
		document.regForm.email.focus();
		return;
	}
	
	if(document.regForm.zipcode.value==""){
		alert("우편번호를 입력해주세요.");
		document.regForm.zipcode.focus();
		/*중지*/
		return;
	}
	if(document.regForm.address1.value==""){
		alert("주소를 입력해주세요.");
		document.regForm.address1.focus();
		/*중지*/
		return;
	}
	if(document.regForm.address2.value==""){
		alert("상세주소를 입력해주세요.");
		document.regForm.address2.focus();
		/*중지*/
		return;
	}
	
	//document 레그 폼에 있는 거를 전송해라
	document.regForm.submit();	
}


//회원정보 수정에 대한 유효성 검사
function updateCheck() { 
	//두번째 방법
	
	var theForm = document.regForm;	
	
	
	if(theForm.pass.value==""){
		alert("비밀번호를 입력해주세요.");
		theForm.pass.focus();
		/*중지*/
		return;
	}
	if(theForm.repass.value==""){
		alert("비밀번호를 똑같이 입력해주세요.");
		theForm.repass.focus();
		/*중지*/
		return;
	}
	if(theForm.pass.value !=theForm.repass.value){
		alert("비밀번호가 일치 하지 않습니다 똑바로 입력해");
		theForm.repass.focus(); /*비밀번호를 repass에 focus로 맞춘다.*/
		/*중지*/
		return;
	}
	
	if(theForm.phone1.value==""){
		alert("통신사를 입력해주세요.");
		theForm.phone1.focus();
		/*중지*/
		return;
	}
	if(theForm.phone2.value==""){
		alert("전화번호를 입력해주세요.");
		theForm.phone2.focus();
		/*중지*/
		return;
	}
	if(theForm.phone3.value==""){
		alert("전화번호를 입력해주세요.");
		theForm.phone3.focus();
		/*중지*/
		return;
	}
	if(theForm.email.value==""){
		alert("email을 입력해주세요.");
		theForm.email.focus();
		/*중지*/
		return;
	}
	/*email 유효성 검사 해야된다.*/
	//ex)hong@naver.com(이메일 형식 검사)
	var str= theForm.email.value;
	var atPos = str.indexOf('@');  //골뱅이 앞뒤 위치 
	var atLastPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.');
	var spacePos =str.indexOf(' '); //공백 스페이스버튼 하나 저걸 몇개 뛰어서 설정하면 리턴할떄 오류남
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;
																						//+1은 인덱스 하나 추가
	if(atPos > 1 && atPos == atLastPos && dotPos > 3 && spacePos == -1 && commaPos == -1 && atPos +1 < dotPos && dotPos + 1 < eMailSize){
	}else {
		alert("E_Mail 주소 형식이 잘못 되었습니다. \n\r 다시 입력 해'줘'");
		theForm.email.focus();
		return;
	}
	
	if(theForm.zipcode.value==""){
		alert("우편번호를 입력해주세요.");
		theForm.zipcode.focus();
		/*중지*/
		return;
	}
	if(theForm.address1.value==""){
		alert("주소를 입력해주세요.");
		theForm.address1.focus();
		/*중지*/
		return;
	}
	if(theForm.address2.value==""){
		alert("상세주소를 입력해주세요.");
		theForm.address2.focus();
		/*중지*/
		return;
	}
	
	
	document.regForm.submit();	
}

//회원탈퇴 
function begin() {
	document.myForm.pass.focus(); 
}


function checkIt() {
	//마이폼안에 밸류값에 아무것도 없으면 
	if(!document.myForm.pass.value){
		alert("비밀번호를 입력하지 않았습니다.");
		document.myForm.pass.focus(); //alert가 뜨고 다시 focus를 pass에 
		return false;
	}
}	


