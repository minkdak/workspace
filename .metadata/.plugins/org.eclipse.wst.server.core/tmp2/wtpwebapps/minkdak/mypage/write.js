var fititle = $('#wirte_title'),
fisdt = $('.write_start_date'),
fiedt = $('.write_end_date'),

ficont = $('.text_write_box');

var mno =0;   
$.getJSON('../member/header.json', function(result) {

	console.log(result);
	mno=parseInt(result.mno);
	var template = Handlebars.compile($('#tbody-template2').html())
	var generatedHTML = template(result) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
//	tbody.text('') // tbody의 기존 tr 태그들을 지우고
	tbody.append(generatedHTML) // 새 tr 태그들로 설정한다.
})

var d = new Date(); 
var localeDate  =  d.toLocaleDateString(); 

/*
$('#write_save_btn').click(function() {

	$.post('../post/add.json', {
		'title': fititle.val(),
		'sdt': fisdt.val(),
		'edt': fiedt.val(),
		'cont':ficont.val(),
		'mno': mno
		 'pdt': localeDate,
      'cont': ficont.val()
	}, function(result) {
//		location.href = '../main_minkdak/main.html'
	}, 'json')
	
	var pictures=[];
	for(i=0;i<=count;i++){
		if($('#text_parent_'+i+'> img')){
			console.log($('#text_parent_'+i+' > img'))
			pictures[i]=$('#text_parent_'+i+' > img')
		}
		console.log(pictures)
	}
	*/
	/*$.post('../post/add.json', {
		'title': fititle.val(),
		'sdt': fisdt.val(),
		'edt': fiedt.val(),
		'cont':ficont.val(),
		'mno': mno
		 'pdt': localeDate,
      'cont': ficont.val()
	}, function(result) {
//		location.href = '../main_minkdak/main.html'
	}, 'json')
	
	
})*/

//$('#file1').fileupload({
//url: '../File/upload.json',        // 서버에 요청할 URL
//dataType: 'json', /* "서버가 보낸 데이터가 JSON 문자열이다. 자바스크립트 객체로 바꿔라." 라는 의미*/
//done: function (e, data) { // 서버에서 응답이 오면 호출된다. 각 파일 별로 호출된다.
//console.log('done()...');
//console.log(data.result);
//var file = data.result.fileList[0];
//$.each(data.result.fileList, function(index, file) {
//$('<p/>').text(file.filename + " : " + file.filesize).appendTo(document.body);

//});

//}
//});



var aaa=0;



/*$('#write_save_btn').click(function() {

$.post('../post/add.json', {
	'title': fititle.val(),
	'sdt': fisdt.val(),
	'edt': fiedt.val(),
	'cont':ficont.val(),
	'mno': mno
	 'pdt': localeDate,
  'cont': ficont.val()
}, function(result) {
//	location.href = '../main_minkdak/main.html'
}, 'json')

var pictures=[];
for(i=0;i<=count;i++){
	if($('#text_parent_'+i+'> img')){
		console.log($('#text_parent_'+i+' > img'))
		pictures[i]=$('#text_parent_'+i+' > img')
	}
	console.log(pictures)
}*/



//$('.file1').fileupload({
//    url: '../File/upload.json',        // 서버에 요청할 URL
//    dataType: 'json', /* "서버가 보낸 데이터가 JSON 문자열이다. 자바스크립트 객체로 바꿔라." 라는 의미*/
//    done: function (e, data) {
//
//		console.log($(this).val())
//		console.log(data.files);
//		var no = $(this).attr('class').split('_')[1].split(' ')[0]
//		console.log(no)
//		/*console.log(no)*/
//
//		var imagesDiv = $("#text_parent_"+aaa+"").empty();
//		adddiv()
//		imagesDiv.html("");
//		for (var i = 0; i < data.files.length; i++) {
//			try {
////				console.log($(this).attr('class').split(' ')[1]);
////				no = location.href.split('?')[1].split('=')[1]
//				if (data.files[i].preview.toDataURL) {
//					console.log($("#text_parent_" + aaa))
//					$("<img>").attr('src', data.files[i].preview.toDataURL()).css('width', '700px').appendTo(imagesDiv);
//				}
//			} catch (err) {}
//		}
//		$('#write_save_btn').unbind("click");
//		$('#write_save_btn').click(function() {
//			$.post('../post/add.json', {
//				'title': fititle.val(),
//				'sdt': fisdt.val(),
//				'edt': fiedt.val(),
//				'cont':ficont.val(),
//				'mno': mno
//				/* 'pdt': localeDate,
//		      'cont': ficont.val()*/
//			}, function(result) {
////				location.href = '../main_minkdak/main.html'
//			}, 'json')
//			
//			var pictures=[];
//			for(i=0;i<=count;i++){
//				if($('#text_parent_'+i+'> img')){
//					console.log($('#text_parent_'+i+' > img'))
//					pictures[i]=$('#text_parent_'+i+' > img')
//				}
//				console.log(pictures)
//		}
//			
//		});
//	 // 서버에서 응답이 오면 호출된다. 각 파일 별로 호출된다.
////      console.log('done()...');
////      console.log(data.result);
//      /*
//      var file = data.result.fileList[0];
//      $.each(data.result.fileList, function(index, file) {
//        $('<p/>').text(file.filename + " : " + file.filesize).appendTo(document.body);
//      });*/
//      
//    }
//});

$('#write_save_btn').click(function() {
	if(fititle.val() == null){
		alert("제목을 입력해주세요")
	}else if(fisdt.val()== null||fiedt.val()==null){
		alert("날짜를 입력해 주세요")
	}else{
	$.post('../post/add.json', {
		'title': fititle.val(),
		'sdt': fisdt.val(),
		'edt': fiedt.val(),
		'cont':ficont.val(),
		'mno': mno
		/* 'pdt': localeDate,
      'cont': ficont.val()*/
	}, function(result) {
//		location.href = '../main_minkdak/main.html'
	}, 'json')
	
	var pictures=[];
	for(i=0;i<=count;i++){
		if($('#text_parent_'+i+'> img')){
			console.log($('#text_parent_'+i+' > img'))
			pictures[i]=$('#text_parent_'+i+' > img')
		}
		console.log(pictures)
	}
}
});

/*미리보기 파일업로드*/

$('.file1').fileupload({
	url: '../File/upload3.json',        // 서버에 요청할 URL
	dataType: 'json',         // 서버가 보낸 응답이 JSON임을 지정하기
	sequentialUploads: true,  // 여러 개의 파일을 업로드 할 때 순서대로 요청하기.
	singleFileUploads: false, // 한 요청에 여러 개의 파일을 전송시키기.
	autoUpload: true,        // 파일을 추가할 때 자동 업로딩 하지 않도록 설정.
	disableImageResize: /Android(?!.*Chrome)|Opera/
		.test(window.navigator && navigator.userAgent), // 안드로이드와 오페라 브라우저는 크기 조정 비활성 시키기
		previewMaxWidth: 700,   // 미리보기 이미지 너비
		previewMaxHeight: 560,  // 미리보기 이미지 높이 
		previewCrop: true,      // 미리보기 이미지를 출력할 때 원본에서 지정된 크기로 자르기
		processalways: function(e, data) {

			console.log('fileuploadprocessalways()...');
			console.log($(this).val())
			console.log(data.files);
			var no = $(this).attr('class').split('_')[1].split(' ')[0]
			console.log(no)
			/*console.log(no)*/

			var imagesDiv = $("#text_parent_"+aaa+"").empty();
			adddiv()
			imagesDiv.html("");
			for (var i = 0; i < data.files.length; i++) {
				try {
//					console.log($(this).attr('class').split(' ')[1]);
//					no = location.href.split('?')[1].split('=')[1]
					if (data.files[i].preview.toDataURL) {
						console.log($("#text_parent_" + aaa))
						$("<img>").attr('src', data.files[i].preview.toDataURL()).css('width', '700px').appendTo(imagesDiv);
					}
				} catch (err) {}
			}
			$('#write_save_btn').unbind("click");
			
		}, 
		
		
		done: function (e, data) { // 서버에서 응답이 오면 호출된다. 각 파일 별로 호출된다.
			console.log('done()...');
			console.log(data.result);
			var file = data.result.fileList[0];
			/*$('<p/>').text("name : " + data.result.name).appendTo(document.body);
			$('<p/>').text("age : " + data.result.age).appendTo(document.body);*/
			$.each(data.result.fileList, function(index, file) {
				$('<p/>').text(file.filename + " : " + file.filesize).appendTo(document.body);
			});
		}
});




/*미리보기 파일업로드 끝*/

/*back file 업로드 시작*/
$('#title_fileupload').fileupload({
	url: '../File/upload3.json',        // 서버에 요청할 URL
	dataType: 'json',         // 서버가 보낸 응답이 JSON임을 지정하기
	sequentialUploads: true,  // 여러 개의 파일을 업로드 할 때 순서대로 요청하기.
	singleFileUploads: false, // 한 요청에 여러 개의 파일을 전송시키기.
	autoUpload: true,        // 파일을 추가할 때 자동 업로딩 하지 않도록 설정.
	disableImageResize: /Android(?!.*Chrome)|Opera/
		.test(window.navigator && navigator.userAgent), // 안드로이드와 오페라 브라우저는 크기 조정 비활성 시키기
		previewMaxWidth: 1920,   // 미리보기 이미지 너비
		previewMaxHeight: 800,  // 미리보기 이미지 높이 
		previewCrop: true,      // 미리보기 이미지를 출력할 때 원본에서 지정된 크기로 자르기
		processalways: function(e, data) {

			console.log('fileuploadprocessalways()...');
			console.log($(this).val())
			console.log(data.files);
			/*var no = $(this).attr('class').split('_')[1].split(' ')[0]*/
			/*console.log(no)*/
			/*console.log(no)*/

			/*var imagesDiv = $("#text_parent_"+aaa+"").empty();*/
			
			/*imagesDiv.html("");*/
			for (var i = 0; i < data.files.length; i++) {
				try {
//					console.log($(this).attr('class').split(' ')[1]);
//					no = location.href.split('?')[1].split('=')[1]
					if (data.files[i].preview.toDataURL) {
						/*console.log($("#text_parent_" + aaa))*/
						var a = data.files[i].preview.toDataURL()
						console.log(a)
						var img = new Image();
						img.src = a;
						$(".blank-one").css("background-image", "url('" + img.src + "')");
						
					}
				} catch (err) {}
			}
			$('#write_save_btn').unbind("click");
			
		}, 
		
		
		done: function (e, data) { // 서버에서 응답이 오면 호출된다. 각 파일 별로 호출된다.
			console.log('done()...');
			console.log(data.result);
			var file = data.result.fileList[0];
			/*$('<p/>').text("name : " + data.result.name).appendTo(document.body);
			$('<p/>').text("age : " + data.result.age).appendTo(document.body);*/
			$.each(data.result.fileList, function(index, file) {
				$('<p/>').text(file.filename + " : " + file.filesize).appendTo(document.body);
			});
		}
});

/* 민섭 파일 전체 올리기*/


$('#fileAllUpload').fileupload({
	url: '../File/upload3.json',        // 서버에 요청할 URL
	dataType: 'json',         // 서버가 보낸 응답이 JSON임을 지정하기
	sequentialUploads: true,  // 여러 개의 파일을 업로드 할 때 순서대로 요청하기.
	singleFileUploads: false, // 한 요청에 여러 개의 파일을 전송시키기.
	autoUpload: true,        // 파일을 추가할 때 자동 업로딩 하지 않도록 설정.
	disableImageResize: /Android(?!.*Chrome)|Opera/
		.test(window.navigator && navigator.userAgent), // 안드로이드와 오페라 브라우저는 크기 조정 비활성 시키기
		previewMaxWidth: 700,   // 미리보기 이미지 너비
		previewMaxHeight: 560,  // 미리보기 이미지 높이 
		previewCrop: true,      // 미리보기 이미지를 출력할 때 원본에서 지정된 크기로 자르기
		processalways: function(e, data) {

			console.log('fileuploadprocessalways()...', data.loaded, data.total);
			console.log($(this).val())
			console.log(data.files);
			/*console.log(no)*/
			
	        var progress = parseInt(data.loaded / data.total * 100, 10);
	        $('#progress .bar').css(
	            'width',
	            progress + '%'
	        );
			
/*			var imagesDiv = $("#text_parent_"+aaa+"").empty();
			adddiv()
			imagesDiv.html("");
			for (var i = 0; i < data.files.length; i++) {
				try {
//					console.log($(this).attr('class').split(' ')[1]);
//					no = location.href.split('?')[1].split('=')[1]
					if (data.files[i].preview.toDataURL) {
						console.log($("#text_parent_" + aaa))
						$("<img>").attr('src', data.files[i].preview.toDataURL()).css('width', '100px').appendTo(imagesDiv);
					}
				} catch (err) {}
			}*/
			$('#write_save_btn').unbind("click");
		}, 
		
		
		done: function (e, data) { // 서버에서 응답이 오면 호출된다. 각 파일 별로 호출된다.
			console.log('done()...');
			console.log(data._response);
			console.log(data._response.result[0].path)
			var file = data.result.fileList;
			/*$('<p/>').text("name : " + data.result.name).appendTo(document.body);
			$('<p/>').text("age : " + data.result.age).appendTo(document.body);*/
			$.each(data.result.fileList, function(index, file) {
				$('<p/>').text(file.filename + " : " + file.filesize).appendTo(document.body);
			});
			console.log(data.result.length);
			var imagesDiv = $("#text_parent_"+aaa+"").empty();
			imagesDiv.html("");
//			$('#p_save_btn').click(function() {
			plus(data);
			var countPhoto = aaa;
			for(var i = 0; i < photo.length; i++){
			adddiv()
			var textParent= $("#text_parent_"+countPhoto+"")
			if (photo[i].length == 2) {
			    $("<div class='whole_collage2'>")
			    .html("<div  class='two_photo_col' id='collage2-1-count" +countPhoto +"'><img id='img_4' src=''></div>"
			     + "<div  class='two_photo_col' id='collage2-2-count" +countPhoto +"'><img id='img_4' src=''></div>"
			     + "</div>"
			     ).appendTo(textParent)
			     $('#collage2-1-count'+ countPhoto +'> img').attr('src', photo[i][0] + "_500.png").css('width', '534px').css('height','534px');
			     $('#collage2-2-count'+ countPhoto +'> img').attr('src', photo[i][1] + "_500.png").css('width', '534px').css('height','534px');
			     console.log(photo[i][0])
			     console.log(photo[i][1])
			} else if (photo[i].length == 3) {
				
//				var str = ".." + data._response.result[i].path;
//				var dataSource = data._response.result[i].path
				
				try {
					console.log(data._response.result[1].path);

				  $("<div class='whole_collage3'>")
				  .html("<div id='collage3-1-big'><img id='img_4' src=''></div>"
				   + "<div class='collage3_2inner_collage'>"
				   + "<div class='inner_two_collage' id='collage3-2'><img src=''></div>"
				   + "<div class='inner_two_collage' id='collage3-3'><img src=''></div>"
				   + "</div></div>"
				   ).appendTo(textParent)
					$('#collage3-1-big > img').attr('src', photo[i][0]+"_500.png").css('width', '534px').css('height','534px');
					$('#collage3-2 > img').attr('src', photo[i][1] +"_300.png").css('width', '260px').css('height','265px');
					$('#collage3-3 > img').attr('src', photo[i][2] +"_300.png").css('width', '260px').css('height','265px');
					
				} catch (err) {}
			}else if (photo[i].length == 4) {
				
				try {
			    $("<div class='whole_collage4'>")
			    .html("<div class='four_photo_collage' id='collage4-1'><img src=''></div>"
			     + "<div class='four_photo_collage' id='collage4-2'><img src=''></div>"
			     + "<div class='four_photo_collage' id='collage4-3'><img src=''></div>"
			     + " <div class='four_photo_collage' id='collage4-4'><img src=''></div>"
			     + "</div>"
			     ).appendTo(textParent)
			     
			    $('#collage4-1 > img').attr('src', photo[i][0]+"_400.png").css('width', '397px').css('height','397px');
			    $('#collage4-2 > img').attr('src', photo[i][1]+"_400.png").css('width', '397px').css('height','397px');
			    $('#collage4-3 > img').attr('src', photo[i][2]+"_400.png").css('width', '397px').css('height','397px');
			    $('#collage4-4 > img').attr('src', photo[i][3]+"_400.png").css('width', '397px').css('height','397px');
			    
				} catch (err) {} 	
			} else if (photo[i].length == 5) {
				
				try {
				  $("<div class='whole_collage5'>")
				  .html("<div  class='top_three_collage' id='collage5-1'><img src=''></div>"
				  + "<div  class='top_three_collage' id='collage5-2'><img src=''></div>"
				  + "<div  class='top_three_collage' id='collage5-3'><img src=''></div>"

				  + "<div  class='bottom_two_collage' id='collage5-4'><img src=''></div>"
				  + "<div  class='bottom_two_collage' id='collage5-5'><img src=''></div>"
				  + "</div>"
			    ).appendTo(textParent) 
			    $('#collage5-1 > img').attr('src', photo[i][0]+"_300.png").css('width', '260px').css('height','260px');
			    $('#collage5-2 > img').attr('src', photo[i][1]+"_300.png").css('width', '259px').css('height','260px');
			    $('#collage5-3 > img').attr('src', photo[i][2]+"_300.png").css('width', '260px').css('height','260px');
			    
			    $('#collage5-4 > img').attr('src', photo[i][3]+"_400.png").css('width', '397px').css('height','397px');
			    $('#collage5-5 > img').attr('src', photo[i][4]+"_400.png").css('width', '397px').css('height','397px');
			    
				} catch (err) {} 	
			} else if (photo[i].length == 6) {
				
				try {
				  $("<div class='whole_collage6'>")
				   .html("<div  id='collage6-1-big'><img id='img_4' src=''></div>"
				    +"<div id='collage6-2side-collage'>"
				    +"<div class='side_two_collage' id='collage6-2'><img src=''></div>"
				    +"<div class='side_two_collage' id='collage6-3'><img src=''></div>"
				    +"</div>"

				    +"<div  class='bottom_three_collage' id='collage6-4'><img id='img_4' src=''></div>"
				    +"<div  class='bottom_three_collage' id='collage6-5'><img id='img_4' src=''></div>"
				    +"<div  class='bottom_three_collage' id='collage6-6'><img id='img_4' src=''></div>"
				    +"</div>"
				    ).appendTo(textParent) 
			    $('#collage6-1-big > img').attr('src', photo[i][0]+"_600.png").css('width', '534px').css('height','534px');
			    $('#collage6-2 > img').attr('src', photo[i][1]+"_300.png").css('width', '260px').css('height','265px');
			    $('#collage6-3 > img').attr('src', photo[i][2]+"_300.png").css('width', '260px').css('height','265px');
			    
			    $('#collage6-4 > img').attr('src', photo[i][3]+"_300.png").css('width', '264px').css('height','260px');
			    $('#collage6-5 > img').attr('src', photo[i][4]+"_300.png").css('width', '264px').css('height','260px');
			    $('#collage6-6 > img').attr('src', photo[i][5]+"_300.png").css('width', '264px').css('height','260px');
			    
				} catch (err) {} 	
			} else if (photo[i].length == 7) {
				try {
				  $("<div class='whole_collage7'>")
			       .html("<div class='four_of_seven'>"
			       +"<div class='right_four_of_seven' id='collage7-1-small'><img src=''></div>"
			       +"<div class='right_four_of_seven' id='collage7-2-small'><img src=''></div>"
			       +"<div class='right_four_of_seven' id='collage7-3-small'><img src=''></div>"
			       +"<div class='right_four_of_seven' id='collage7-4-small'><img src=''></div>"
			       +"</div>"


			       +"<div  class='bottom_three_of_seven' id='collage7-5'><img src=''></div>"
			       +"<div  class='bottom_three_of_seven' id='collage7-6'><img src=''></div>"
			       +"<div  class='bottom_three_of_seven' id='collage7-7'><img src=''></div>"
			       +"</div>"
				    ).appendTo(textParent)  
				    $('#collage7-1-small > img').attr('src', photo[i][0]+"_200.png").css('width', '192px').css('height','193px');
				    $('#collage7-2-small > img').attr('src', photo[i][1]+"_200.png").css('width', '192px').css('height','193px');
				    $('#collage7-3-small > img').attr('src', photo[i][2]+"_200.png").css('width', '192px').css('height','193px');
				    $('#collage7-4-small > img').attr('src', photo[i][3]+"_200.png").css('width', '192px').css('height','193px');
				    
				    $('#collage7-5 > img').attr('src', photo[i][4]+"_400.png").css('width', '397px').css('height','397px');
				    $('#collage7-6 > img').attr('src', photo[i][5]+"_400.png").css('width', '397px').css('height','397px');
				    $('#collage7-7 > img').attr('src', photo[i][6]+"_400.png").css('width', '397px').css('height','397px');
				        
			    
				} catch (err) {} 	
			} else if (photo[i].length == 8) {
				
				try {
					$("<div class='whole_collage8'>")
					.html("<div  id='collage8-1-big'><img id='img_4' src=''></div>"
				     +"<div  id='four_of_eight'>"
				     +"<div class='right_four_of_eight' id='collage8-2'><img src=''></div>"
				     +"<div class='right_four_of_eight' id='collage8-3'><img src=''></div>"
				     +"<div class='right_four_of_eight' id='collage8-4'><img src=''></div>"
				     +"<div class='right_four_of_eight' id='collage8-5'><img src=''></div>"
				     +"</div>"

				     +"<div  class='bottom_three_of_eight' id='collage8-6'><img id='img_4' src=''></div>"
				     +"<div  class='bottom_three_of_eight' id='collage8-7'><img id='img_4' src=''></div>"
				     +"<div  class='bottom_three_of_eight' id='collage8-8'><img id='img_4' src=''></div>"
				     +"</div>"
				     ).appendTo(textParent)
				  

					
			    $('#collage8-1-big > img').attr('src', photo[i][0]+"_400.png").css('width', '397px').css('height','397px');
			    $('#collage8-2 > img').attr('src', photo[i][1]+"_200.png").css('width', '195px').css('height','195px');
			    $('#collage8-3 > img').attr('src', photo[i][2]+"_200.png").css('width', '195px').css('height','195px');
			    $('#collage8-4 > img').attr('src', photo[i][3]+"_200.png").css('width', '195px').css('height','195px');
			    $('#collage8-5 > img').attr('src', photo[i][4]+"_200.png").css('width', '195px').css('height','195px');
			    
			    $('#collage8-6 > img').attr('src', photo[i][5]+"_300.png").css('width', '262px').css('height','260px');
			    $('#collage8-7 > img').attr('src', photo[i][6]+"_300.png").css('width', '262px').css('height','260px');
			    $('#collage8-8 > img').attr('src', photo[i][7]+"_300.png").css('width', '262px').css('height','260px');
			    
				} catch (err) {} 	
			} else if (photo[i].length == 9) {
				
				try {
				    $("<div class='whole_collage9'>")
				     .html("<div  id='collage9-1-big'><img id='img_4' src='ca.jpg'></div>"
				      +"<div  class='four_of_nine'>"
				      +"<div class='right_four_of_nine' id='collage9-2'><img src=''></div>"
				      +"<div class='right_four_of_nine' id='collage9-3'><img src='mrbike.PNG'></div>"
				      +"<div class='right_four_of_nine' id='collage9-4'><img src='mrbike.PNG'></div>"
				      +"<div class='right_four_of_nine' id='collage9-5'><img src='mrbike.PNG'></div>"
				      +"</div>"

				      +"<div  class='bottom_four_of_nine' id='collage9-6'><img src='ca.jpg'></div>"
				      +"<div  class='bottom_four_of_nine' id='collage9-7'><img src='ca.jpg'></div>"
				      +"<div  class='bottom_four_of_nine' id='collage9-8'><img src='ca.jpg'></div>"
				      +"<div  class='bottom_four_of_nine' id='collage9-9'><img src='ca.jpg'></div>"
				      +"</div>"
				  ).appendTo(textParent)
					
			    $('#collage9-1-big > img').attr('src', photo[i][0]+"_400.png").css('width', '397px').css('height','397px');
			    $('#collage9-2 > img').attr('src', photo[i][1]+"_200.png").css('width', '195px').css('height','195px');
			    $('#collage9-3 > img').attr('src', photo[i][2]+"_200.png").css('width', '195px').css('height','195px');
			    $('#collage9-4 > img').attr('src', photo[i][3]+"_200.png").css('width', '195px').css('height','195px');
			    $('#collage9-5 > img').attr('src', photo[i][4]+"_200.png").css('width', '195px').css('height','195px');
			    
			    $('#collage9-6 > img').attr('src', photo[i][5]+"_200.png").css('width', '195px').css('height','191px');
			    $('#collage9-7 > img').attr('src', photo[i][6]+"_200.png").css('width', '195px').css('height','191px');
			    $('#collage9-8 > img').attr('src', photo[i][7]+"_200.png").css('width', '195px').css('height','191px');
			    $('#collage9-9 > img').attr('src', photo[i][8]+"_200.png").css('width', '195px').css('height','191px');
			    
				} catch (err) {} 	
			} else {
			
				// 사진이 두장이라면
				  var str = photo[i][0];
				  
				try {
					$("<img>").attr('src', str+"_300.png").css('width', 'auto').appendTo(textParent);
				} catch (err) {}

			} //else
			countPhoto++
			} // 사진 for문
			
//		})
		} //done
});

var photo = [];
var dataa=[]
/*function plus(dataa){
	사진 sortNo 중복값 제거하고 배열에 담기
	var sortNo = []
	for(j = 0; j < dataa.result.length; j++) {
		sortNo[j] = dataa._response.result[j].sortno;
		var classify = sortNo.filter(function(itm,k,sortNo) {
			return k==sortNo.indexOf(itm);
		})
	}
	사진 sortNo 중복값 제거하고 배열에 담기 끝
	
	var photoData = []
	var m = 0;
	console.log(photoData)
	
//	console.log(dataa._response)
	
	var sortnoa=0
	for(i=0;i<=dataa.result[dataa.result.length-1].sortno;i++){
		console.log(dataa.result[0].sortno)
		for(j=0; sortnoa == i;j++){
			console.log(countcc)
			console.log(dataa.result)
			sortnoa=dataa.result[j].sortno
			photoData[i] = new Array();
			photoData[i][j] = dataa._response.result[countcc]
			countcc++;
		}
	}
	for(var i = 0; i< dataa.result.length; i++) {
		console.log(dataa._response.result[0].sortno)
		var sortno= dataa._response.result[count].sortno
//		for(var l = 0; l < classify.length; l++){
		for(var l = 0; sortno == i ; l++){
			photoData[i] = new Array();
			photoData[i][l] = dataa._response.result[count]
			count++;
//			if (dataa._response.result[i].sortno == classify[l]) {
//				photoData[i][l]=
//		    photoData[l] = new Array();
//		    console.log(photoData[l])
//			photoData[l][m++] = dataa._response.result[i];
//			photoData[l].push(dataa._response.result[i])
//			}

			}
		photo[i][i] = ".."+dataa._response.result[i].path;
	}
	
	console.log(photoData)
	return photo[i]
}*/


function plus(dataa){
	
	//사진 sortNo 중복값 제거하고 배열에 담기
	var sortNo = []
	for(j = 0; j < dataa.result.length; j++) {
		sortNo[j] = dataa.result[j].sortno;
		var classify = sortNo.filter(function(itm,k,sortNo) {
			return k==sortNo.indexOf(itm);
		})
	}
	console.log(classify)
	//사진 sortNo 중복값 제거하고 배열에 담기 끝
	var photoData = []
	var countaa=0
	console.log("==============>")
	
	
	for(var i = 0; i< dataa.result.length; i++) {
		var sortno = dataa.result[i].sortno
		if (photo[sortno] == undefined) {
			photo[sortno] = []
		}
		photo[sortno].push(dataa.result[i].path)
		
		for(var l = 0; l < classify.length; l++){
     		//if (dataa.result[i].sortno == classify[l]) {
//			    for(var l = 0; sortno == i ; l++){
//					photoData[l] = new Array();
//					photoData[l][countaa] = dataa.result[i]
//					countaa++;
//	     		}
//				photoData[i][l]=
//		    photoData[l] = new Array();
//		    console.log(photoData[l])
//			photoData[l][m++] = dataa._response.result[i];
//			photoData[l].push(dataa._response.result[i])
     		//}

	    }
	
//		for(i = 0; i< dataa.result.length; i++) {
//			console.log(dataa.result[i].path)
//			photo[i][i] = ".."+dataa.result[i].path;
//		}
	}
	console.log(photo)
	return photo

}

/*function plus(dataa){
	
	//사진 sortNo 중복값 제거하고 배열에 담기
	var sortNo = []
	for(j = 0; j < dataa.result.length; j++) {
		sortNo[j] = dataa.result[j].sortno;
		var classify = sortNo.filter(function(itm,k,sortNo) {
			return k==sortNo.indexOf(itm);
		})
	}
	console.log(classify)
	//사진 sortNo 중복값 제거하고 배열에 담기 끝
	
		for(i = 0; i< dataa.result.length; i++) {
			console.log(dataa.result[i].path)
			photo[i][i] = ".."+dataa.result[i].path;
		}
	return dcountPhoto
}*/
function filePath(dataSource, no) {
  var str = ".." + data._response.result[no].path
  return str;	
}
/*$.getJSON('../member/header.json',function(result){
	let str = result.memberPhoto;
	var path = window.location.pathname;
	console.log(path)
	console.log(str)
	var imagesDiv = $("#text_parent_"+countPhoto+"").empty();
			adddiv()
			imagesDiv.html("");
	$("<img>").attr('src', data.files[i].).css('width', '100px').appendTo(imagesDiv);
}) */


//$('#fileupload').fileupload({
//url: '/control/controller24/upload2.do',        // 서버에 요청할 URL
//	  dataType: 'json',         // 서버가 보낸 응답이 JSON임을 지정하기
//	  sequentialUploads: true,  // 여러 개의 파일을 업로드 할 때 순서대로 요청하기.
//	  singleFileUploads: false, // 한 요청에 여러 개의 파일을 전송시키기.   
//	  done: function (e, data) { // 서버에서 응답이 오면 호출된다. 각 파일 별로 호출된다.
//	    console.log('done()...');
//	    console.log(data.result);
//	    var file = data.result.fileList[0];
//	    $.each(data.result.fileList, function(index, file) {
//	      $('<p/>').text(file.filename + " : " + file.filesize).appendTo(document.body);
//	    });
//	  }
//	}); 

/*back file up 끝*/