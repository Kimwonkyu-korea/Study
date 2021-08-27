
public class SwitchClass {

	public static void main(String[] args) {
		/*
		  	switch : if와 비슷하다.
		  			 값이 명확해야 된다.
		  			 범위를 지정할 수 없다. if(number >= 90 && number <= 100) X
		  			 
		  			 if(number == 100){
		  			 
		  			 }
		  			 else if(number == 99){
		  			 
		  			 }
		  			 
		  		case, break
		  		
		  		형식: 
		  			switch( 대상이 되는 변수 ) {
		  				case 값1:	if( 대상이 되는 변수 == 값1 )
		  					처리1
		  					break;
		  				case 값2:	else if( 대상이 되는 변수 == 값2 )
		  					처리2
		  					break;
		  				case 값3:
		  					처리3
		  					break;
		  				default:	== else
		  			}
		 */
		
		int number = 2;
		
		switch( number ) {
			case 1:			// if( number == 1 )
				System.out.println("number는 1입니다.");
				break;
			case 2:			// else if( number == 2 )
				System.out.println("number는 2입니다.");
				break;
				
			default:		// else
				System.out.println("number는 1도 아니고 2도 아닙니다.");
		}
		/*			// 범위 지정이 안된다.
		switch(number) {
		case number > 0:
			break;
		}
		
		// if와 switch 비교
		double d = 1.1;
		
		if(d == 1.1) {
			
		}
		
		switch(d) {
		case d> 1.1:
			break;
		}
		*/
		
		
		
		
	}

}
