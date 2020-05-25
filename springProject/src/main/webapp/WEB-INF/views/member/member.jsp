<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
		function check(){ // 비밀번호 중복체크기능
			pw=document.getElementById("pw").value;
			pw1=document.getElementById("pw1").value;
			if(pw==pw1){
				document.getElementById("pw1_conform").innerHTML="확인!!";
				
			}
			else{
				document.getElementById("pw1_conform").innerHTML="불일치!!";
				document.getElementById("pw").value="";
				document.getElementById("pw1").value="";
				document.getElementById("pw").focus;
			}
		}
		function mouseCursor(textbox) { //마우스 커서 자동으로 옮기는 기능
			if(textbox.value.length==4){
				document.getElementById("code").focus();
			}
		}
		function popup() {
			window.open("popup","","width=400,height=400,top=500,left=500")
		}
		function idcheck() {
			window.open("idcheck","","width=400,height=400,top=500,left=500")
		}
		
		//아이디 중복체크
	
	function idcheck() {
		var id = document.getElementById("id").value;
		if (id.length < 1 || id == null) {
			alert("중복체크할 아이디를 입력하십시오");
			return false;
		}
		var url = "idcheck?id=" + id;
		window.open(url, "get", "height = 100, width = 230,top=100,left=500");
	}
	//회원가입 유효성 검사
	function validate() {
		var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		// 이메일이 적합한지 검사할 정규식

		var pw = document.getElementById("pw");
		var pw_answer = document.getElementById("pw_answer");
		var name = document.getElementById("name");
		var email = document.getElementById("email");
		var addr = document.getElementById("addr");
		var addr2 = document.getElementById("addr2");
		var tel = document.getElementById("tel1");
	
		if (join.pw.value == "") {
			alert("비밀번호를 입력해 주세요");
			join.pw.focus();
			return false;
		}
		if (join.name.value == "") {
			alert("이름을 입력해 주세요");
			join.name.focus();
			return false;
		}
		if (join.pw_answer.value == "") {
			alert("비밀번호 확인 질문에 답해주세요");
			join.pw_answer.focus();
			return false;
		}
		if (join.addr.value == "") {
			alert("주소를 입력해 주세요");
			join.addr.focus();
			return false;
		}
		if (join.addr2.value == "") {
			alert("상세주소를 입력해 주세요");
			join.addr2.focus();
			return false;
		}
		if (join.tel1.value == "") {
			alert("전화번호를 입력해 주세요");
			join.tel1.focus();
			return false;
		}
		if (email.value == "") {
			alert("이메일을 입력해 주세요");
			email.focus();
			return false;
		}

		if (!check(re2, email, "적합하지 않은 이메일 형식입니다.")) {
			return false;
		}
	}
</script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}
</script>
</head>
<body>
<h1>회원가입 페이지(*은 필수항목)</h1>

<form action="chkRegister" method="post"  name="join" onsubmit="return validate()">
   <table>
      <tr>
         <td>* 아이디</td><td><input type="text" id="id" name="id">&nbsp;&nbsp;
         <input type="button"  onclick="idcheck()" value="아이디 중복확인">
         </td>
      </tr>
      <tr>
         <td>* 비밀번호 입력</td><td><input type="text" name="pw" id="pw"></td>
      </tr>
      <tr>
         <td>* 비밀번호 확인</td><td><input type="text" name="pw1" id="pw1" onchange="check()"><font style="margin-left: 10px;" id="pw1_conform" color="red"></font></td>
      </tr>
      <tr>
      	<td>비밀번호 확인 질문</td>
      	<td>
      	<select size="1" name="conform" style="height: 23px;">
      		<option value="con1">기억에남는 추억의 장소는?
      		<option value="con2">자신의 인생 좌우명은?
      		<option value="con3">자신의 보물 제1호는?
      		<option value="con4">추억하고 싶은 날짜가 있다면?
      		<option value="con5">자신이 가장 존경하는 인물은?
      	</select></td>
      </tr>
      <tr>
      	<td>비밀번호 확인 답변</td><td><input type="text" style="width: 400px;" name="pw_answer"></td>
      </tr>
      <tr>
      	<td>* 이름</td><td><input type="text" name="name"></td>
      </tr>
      <tr>
      	<td rowspan="4" style="padding-bottom: 50px;">* 주소</td><td>
      	<input type="text" name="addr" style="width: 50px;" id="sample6_postcode"> - 
      	<input type="button" value="우편번호" onclick="sample6_execDaumPostcode()" ></td>
      </tr>
      <tr>
      	<td><input type="text" style="width: 300px;" name="addr1" id="sample6_address">주소<td>
      </tr>
      <tr>	
      	<td><input type="text" style="width: 300px;" name="addr2" id="sample6_detailAddress">상세주소</td>
	  </tr>
      <tr>	
      	<td><input type="text" style="width: 100px;" id="sample6_extraAddress">참고항목</td>
	  </tr>
      <tr>
      	<td>* 휴대전화</td>
      	<td >
      	<select size="1" name="tel" style="height: 23px;">
      		<option value="010">010
      		<option value="011">011
      		<option value="016">016
      		<option value="018">018
      		<option value="019">019
      	</select> - 
      	<input type="text" style="width: 70px;" id="birth" onkeyup="mouseCursor(this)" name="tel1"> - 
      	<input type="text" style="width: 70px;" maxlength="4" id="code" name="tel2">
      	</td>
      </tr>
      <tr>
      	<td>* 이메일</td><td><input type="email" style="width: 200px;" name="email">
      </tr>
   
   </table>
   <input type="submit" value="회원가입" style="margin-left: 150px;">
   <input type="button" value="취소" style="margin-left: 10px;" onclick="location.href='login'">
</form>
</body>
</html>