function ajaxRequest(method,url,params,callbackFunction){
	let xhr=new XMLHttpRequest();
	method = (method) ? method:'GET';
	method = (method!='GET'&& method!='POST')?'GET':method;
	params = (params)? params:null;
	url = (method=='GET'&& params!=null) ? url+"?"+params : url; 
	
	xhr.open(method,url,true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded"); //form의 data를 파라메타로 전송
	xhr.onload=function(){
		callbackFunction(xhr);
	};
	xhr.send((method=='POST')?params:null);
	
}