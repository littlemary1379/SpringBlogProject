let index={
		//리스너
		init : function(){
			$("#btn-save").on("click",()=>{ //this 바인딩 할 필요 없이 바로 부모의 this를 찾음.
				//콜백
				this.save();
			});
			
			$("#btn-login").on("click",()=>{ //this 바인딩 할 필요 없이 바로 부모의 this를 찾음.
				//콜백
				this.login();
			});
		}, //이벤트 리스닝 바인딩 함수
		
		save : function(){
			let data={
					username:$("#username").val(),
					password:$("#password").val(),
					email:$("#email").val()		
			};
			
			$.ajax({
				type: "POST",
				url: "/auth/joinProc",
				data: JSON.stringify(data),
				contentType : "application/json; charset=utf-8", //스프링의 데이터 형식 인식 -> 오브젝트 변환
				dataType : "json"	
			}).done(function(resp){
				console.log(resp);
				alert("회원가입이 완료되었습니다.");
				location.href="/";
			}).fail(function(error){
				console.log(error);
				alert("회원가입 실패");
			});
		}, //이벤트 리스닝 실제 실행 함수
		
		login : function(){
			let data={
					username:$("#username").val(),
					password:$("#password").val()	
			};
			
			$.ajax({
				type: "POST",
				url: "/auth/loginProc",
				data: JSON.stringify(data),
				contentType : "application/json; charset=utf-8", //스프링의 데이터 형식 인식 -> 오브젝트 변환
				dataType : "json"	
			}).done(function(resp){
				console.log(resp);
				if(resp.statusCode==1){
					alert("로그인 성공");
				location.href="/";
				}else{
					alert("아이디와 패스워드를 확인하세요.");
				}
			}).fail(function(error){
				console.log(error);
				alert("로그인 실패");
			});
		} //이벤트 리스닝 실제 실행 함수
}

index.init();