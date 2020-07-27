let index = {
		
	init: function(){
		// let _this = this; //this 바인딩
		// $("#btn-save").on("click", function (){
		
		// 1. 리스너
		$("#btn-save").on("click", ()=>{
			
			// 콜백 스택
			this.save();
		});
		
		// 1. 리스너
		$("#btn-delete").on("click", ()=>{

			// 콜백 스택
			this.deleteContent();
		});
		
		// 1. 리스너
		$("#btn-update-mode").on("click", ()=>{
			console.log(this);
			// 콜백 스택
			this.updateMode();
		});
		$("#btn-update").on("click", ()=>{

			// 콜백 스택
			console.log("클릭됨");
			this.update();
		});
		$("#btn-update").hide();
	},
	
	update: function(){
		console.log("업데이트 요청");
		let data = {
				id: $("#id").val(),
				title: $("#title").val(),
				content: $("#content").val()	
		};
		
		$.ajax({
			type: "PUT",
			url: "/post/"+data.id,
			data: JSON.stringify(data), // json 으로 바꿔줌
			contentType: "application/json; charset=utf-8", 
			dataType: "json"
			
		}).done(function(resp){
			// console.log(JSON.parse(resp)); // text 타입으로 데이터를 받았을때 json 오브젝트로
			// 바꿔줌

				alert("수정 성공");
				location.href="/post/"+data.id;
		}).fail(function(error){
			alert("수정 실패");
			console.log(error);
		})
	},
	
	save: function(){
		// alert("btn-save 로직 실행");
		let data = {
				title: $("#title").val(),
				content: $("#content").val(),
				userId: $("#userId").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/post",
			data: JSON.stringify(data), // json 으로 바꿔줌
			contentType: "application/json; charset=utf-8", 
			dataType: "json"
			
		}).done(function(resp){
			// console.log(JSON.parse(resp)); // text 타입으로 데이터를 받았을때 json 오브젝트로
			// 바꿔줌

				alert("글쓰기 성공");
				location.href="/";
		}).fail(function(error){
			alert("글쓰기 실패");
			console.log(error);
		})
	},
	
	deleteContent: function(){
		// alert("btn-save 로직 실행");
		let data = {
				Id: $("#id").val()
		};
		
		console.log(data.Id);
		
		$.ajax({
			type: "DELETE",
			url: "/post/"+data.Id,
			dataType: "json"
			
		}).done(function(resp){
			alert("삭제 성공");
			location.href="/";
		}).fail(function(error){
			alert("삭제 실패");
			console.log(error);
		})
	},
	
	updateMode: function(){
		// alert("btn-save 로직 실행");
		
		$("#title").attr("readOnly",false);
		$("#content").attr("readOnly",false);
		
		$("#btn-update").show();
		$("#btn-update-mode").hide();

	}
	
}

index.init();



