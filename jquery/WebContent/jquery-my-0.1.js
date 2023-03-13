window.jQuery = function(arg){
	if(typeof arg=='string'){ //typeof 어떤타입인지
		
		let elementNodeList = document.querySelectorAll(arg);
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
				for(let i=0;i<this.elementNodeList.length;i++){
					//this.elementNodeList[i].innerHTML=textArg;
					this.elementNodeList[i].firstChild.nodeValue=textArg; //fistChild
				}
				return this; //jqueryWrapperObject return하는 이유 : chaining code하려고
			}
			
		}
		return jqueryWrapperObject;
	}
	
}
window.$=window.jQuery;







