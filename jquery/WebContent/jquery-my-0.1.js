window.jQuery = function(arg){
	if(typeof arg=='string'){ //typeof 어떤타입인지
		/********************** Selector ******************/
		let elementNodeList = document.querySelectorAll(arg);
		if(!elementNodeList) elementNodeList=[]; //null과 undefined 체크
		let jqueryWrapperObject = {
			'elementNodeList':elementNodeList, //검색해서 모든 node list
			'css':function(propertyName,propertyValue){  //라이브러리안에 'css' 같은  function들이 json형태로 엄청많이 들어있다.
				for(let i=0;i<this.elementNodeList.length;i++){
					this.elementNodeList[i].style.cssText
					+=`${propertyName}:${propertyValue};`;  //style.cssText -> js에서 제공해줌(string 형태로) -> css 누적 +=
				}
				return this; //jqueryWrapperObject -> return하는 이유 : chaining code하려고 
			},
			'text':function(textArg){
				
				if(textArg){
					//set text
					for(let i=0;i<this.elementNodeList.length;i++){
						//this.elementNodeList[i].innerHTML=textArg;
						this.elementNodeList[i].firstChild.nodeValue=textArg; //fistChild
					}
					return this;
				}else if(textArg==undefined){
					//get text
					let returnText="";
					for(let i=0;i<this.elementNodeList.length;i++){
						//this.elementNodeList[i].innerHTML=textArg;
						returnText += this.elementNodeList[i].firstChild.nodeValue; //fistChild
					}
					return returnText;
				}
				 //jqueryWrapperObject return하는 이유 : chaining code하려고
			}
			
		}
		return jqueryWrapperObject;
		
		}else if(typeof arg=='function'){
			/*
			 인자로 대입된 함수를 DOM트리생성직후에 호출되도록
			 window.onload 이벤트 프로퍼티에 등록
			 function이면 onload에 등록해봄
			 */	
			 window.addEventListener('load',arg);	
		}else if(typeof arg == 'object'){
			/*
			표준객체(타입이 Element, Document, Window,...)
			*/
			let elementNodeList=[];
		elementNodeList.push(arg);
		let jqueryWrapperObject={
			'elementNodeList':elementNodeList,
			'css':function(propertyName,propertyValue){
				for(let i=0;i<this.elementNodeList.length;i++){
					this.elementNodeList[i].style.cssText
					+=`${propertyName}:${propertyValue};`;
				}
				return this;
			},
			'text':function(textArg){
				if(textArg){
					//set text
					for(let i=0;i<this.elementNodeList.length;i++){
						//this.elementNodeList[i].innerHTML=textArg;
						this.elementNodeList[i].firstChild.nodeValue=textArg;
					}
					return this;
				}else if(textArg==undefined){
					//get text
					let returnText="";
					for(let i=0;i<this.elementNodeList.length;i++){
						//this.elementNodeList[i].innerHTML=textArg;
						returnText += this.elementNodeList[i].firstChild.nodeValue;
					}
					return returnText;
				}
				
			}
				
		}
		return jqueryWrapperObject;
	}
	
}

/************jQuery global function  *************/
window.jQuery.each=function(array,funcArg){
	for(let i=0;i<array.length;i++){
		funcArg(i,array[i]);
	}
}


	
window.$=window.jQuery;







