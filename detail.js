# Board_detail.js (updating...)

/**
 * 
 */

$(document).ready(function(){
	
	var formData = new FormData();
	
	$.ajax({
		url:"/board/detailAction",
		data:formData,
		dataType:"json",
		
		processData:false,
		contentType:false,
		type:'GET',
		
		success:function(data){
			alert("aaaa");
			console.log(data);
			showReadult(data);
		}

	})//ajax 끝

	function showReadult(readultArr){
		if(!readultArr || readultArr.length==0){
			return;
		}
		
		var detailUL=$(".readult ul");
		var msg="";
		
		$(readultArr).each(function(i,obj){
			console.log("obj.uploadPath="+obj.uploadPath);
			console.log("obj.uuid="+obj.uuid);
			console.log("obj.fileName="+obj.fileName);
			
			var	fileCallPath=encodeURIComponent(obj.uploadPath
			+"/"+obj.uuid+"_"+obj.fileName);
			
			msg+="<li data-path='"+obj.uploadPath+"'";
			msg+="data-uuid='"+obj.uuid+"'data-filename='"+obj.fileName+"'";
			msg+="><div>";
			msg+="<span> "+obj.fileName+"</span>";
			msg+="<img src='/brdUpload/display?fileName="+fileCallPath+"'>";		
			
		})//readultArr.each() 끝
		detailUL.append(msg);
	
	}//showReadult 끝
	

function btn_click(str) {
	//alert(str)
	//str이 "update"라면 수정 action
	if(str=="update"){
		frm1.method="get";
		frm1.action="/board/update";
		
	//str이 "delete"라면 삭제 action		
	}else {
		var msg=confirm("삭제하시겠습니까?");
		//alert("삭제" + msg)
		//msg의 값을 찾는 것
		if(msg){
			frm1.action="/board/delete";
			frm1.method="post";
		}else {
			frm1.action="/board/list";
		}

		
	}
}


})
