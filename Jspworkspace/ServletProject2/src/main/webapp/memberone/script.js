function idCheck(id) {
	if(id == "") {
		alert("아이디를 입력해 주세요.");
		document.regForm.id.focus();
	}else {
	 url = "idCheck.jsp?id=" +id
	 window.open(url, "post", "width=300, height=150");	
	}
}

/*주소 검색*/
function zipCheck() {
	
	url = "zipCheck.jsp?check=y";
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
