var tbody = $('.slide_bar_content');

$.getJSON('../member/header.json', function(result) {

	console.log(result);
	var mno=parseInt(result.no);
	    var template = Handlebars.compile($('#tbody-template2').html())
	    var generatedHTML = template(result) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
//	    tbody.text('') // tbody의 기존 tr 태그들을 지우고
	    tbody.append(generatedHTML) // 새 tr 태그들로 설정한다.
	    
	    
	    console.log(mno);
	      $.post('../post/count.json',
	    		  {mno : mno}	
	      , function(result) {
	    	  console.log(result.data.list.length)
	    	  
	    var template = Handlebars.compile($('#tbody-template2').html())
	    var generatedHTML = template(result.data.list) // 템플릿 함수에 데이터를 넣고 HTML을 생성한다.
//	    tbody.text('') // tbody의 기존 tr 태그들을 지우고
	    generatedHTML='';
	    $('.counting1').html(result.data.list.length) // 새 tr 태그들로 설정한다.
  })
  		  let str = result.memberPhoto;
	      console.log(result)
	      
	      if(str == undefined ) {
	    	  $('#photo-output').attr('src', './img/user_default.png').css('width', '100px').css('height', '100px').css('border-radius', '100%')
	    	  console.log("들어간듯?")
	    	  console.log(str)
	      } else {
	    	  $('#photo-output').attr('src', '../upload/' + str).css('width', '100px').css('height', '100px').css('border-radius', '100%')
	      }

  }) // getJSON()
  


  