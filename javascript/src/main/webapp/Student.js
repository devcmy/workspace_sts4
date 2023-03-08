/*
학생객체를 생성해서 반환해주는 <<< 함수 >>> 작성
*/


/************prototype[JSON]******************/
function Student(id,name,kor,eng,math){
    		/*
    		호출 new Student('xxx','KIM',10,20,30)
    			1.Object객체생성({json},new Object()) - new라고붙어서 호출
    			2.금방 생성된 Object객체(this)에 속성를 동적으로 추가
    			3. 생성된 Object객체 반환
    		*/	
    			this.id=id;
    			this.name=name;
    			this.kor=kor;
    			this.eng=eng;
    			this.math=math;
    			this.tot=0;
    			this.avg=0.0;
    			/*
    			this.calculateTot=function(){
    			this.tot=this.kor+this.eng+this.math;
	    		}
	    		this.calculateAvg=function(){
	    			this.avg=this.tot/3;
	    		}
	    		this.toString=function(){
	    			return "["+this.id+"] "+this.name+","+this.kor+","+this.eng+","+this.math+","+this.tot+","+this.avg;
	    		}
    			*/
    			
    		}
     
     
     
     

    /************prototype[case 1]*****************
    Student.prototype객체안에 instanace 객체 생성후 호출하는 메쏘드추가(모든 Student객체들이 사용하는 instance메쏘드)
     - Student객체의메쏘드를 호출하면 Student.prototype객체안에서 메쏘드를 찾아서호출한다 -> 객체 메모리 부하도 줄일수 있다.
     (프로토타입에 넣어서 만들면, 생성시에 만들어진다.)
    **********************************************/
    /*
	Student.prototype.calculateTot = function(){//프로토타입안에는 필드 정의 x(function 정의해야한다)
		this.tot=this.kor+this.eng+this.math;
     };
     
     Student.prototype.calculateAvg= function(){
    	 this.avg=this.tot/3;
     };
     Student.prototype.toString=function(){
    	 return "["+this.id+"] "+this.name+","+this.kor+","+this.eng+","+this.math+","+this.tot+","+this.avg;
     }
    */
    
    
    /************prototype[JSON][case 2]***********/
	Student.prototype={  //바로 대입
    	calculateTot(){
   		this.tot=this.kor+this.eng+this.math;
    	},//아래 =function 이 생략된것도 같은 것이다.
    	calculateAvg(){
   		this.avg=this.tot/3;
    	},
    	toString(){
       	return "["+this.id+"] "+this.name+","+this.kor+","+this.eng+","+this.math+","+this.tot+","+this.avg;
    	}
    }
    
    
    
    