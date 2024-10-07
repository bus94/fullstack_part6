$(dcument).ready(function() {
	$.ajax({
		url: "/api/articles",
		method: "GET",
		success: function(data){
			console.log("전송 성공!");
			// 데이터가 성공적으로 받아지면 data에 forEach()문장을 이용해서 하나의 문자로 만든다.
			console.log(data);
		
			var articleHtml = '';
			data.forEach(function(a) {
				articleHtml += '<div>';
				articleHtml += '<h3>' + a.title + '</h3>';
				articleHtml += '<p>' + a.content + '</p>';
				articleHtml += '</div>';
			});
			
			$('#list').html(articleHtml);
		},
		error: function(error){
			console.log("전송 실패!");
		}
	});
});
