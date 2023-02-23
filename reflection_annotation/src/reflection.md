
 Reflection이란?

	- 구체적인 클래스 타입을 알지 못해도 그 클래스의 메소드, 타입, 변수들에 접근할 수 있도록   	해주는 자바 API
	- 런타임에 지금 실행되고 있는 클래스를 가져와서 실행해야하는 경우
	- 동적으로 객체를 생성하고 메서드를 호출하는 방법
	- 자바의 리플렉션은 클래스, 인터페이스, 메소드들을 찾을 수 있고, 
	  객체를 생성하거나 변수를 변경하거나 메소드를 호출할 수 있다.

 어떤 경우에 사용되나?

	코드를 작성할 시점에는 어떤 타입의 클래스를 사용할지 모르지만, 
	런타임 시점에 지금 실행되고 있는 클래스를 가져와서 실행해야 하는 경우
	프레임워크나 IDE에서 이런 동적인 바인딩을 이용한 기능을 제공한다. 
	eclipse의 자동완성 기능, 
	스프링의 어노테이션이 리플렉션을 이용한 기능이다.
	
	
 리플렉션(Reflection) API
 
	- '구체적인 클래스 타입을 알지 못해도, 클래스의 메소드, 타입, 변수들을 접근할 수 있도록 
	  	가능하게 해주는 자바 API'
	- 'JVM에서 실행되는 애플리케이션의 런타임 동작을 검사하거나 수정할 수 있는 기능이 필요한 
	   	프로그램에서 사용됩니다.'
	- 클래스의 구조를 개발자가 확인할 수 있고, 메소드, 변수 등을 호출하는데 사용됩니다.
	-->리플렉션(Reflection):컴파일 시간(Compile Time)이 아닌 실행 시간(Run Time)에 동적으로 
						    특정 클래스의 정보를 추출해낼 수 있는 프로그래밍 기법입니다.	