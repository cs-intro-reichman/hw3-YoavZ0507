// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum=x1;
		 sum+= x2 ;

		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int min=x1;
		 min -= x2;
		return min;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int times=0;
		if(x2>=0){
		for(int i=1;i<=x2;i++){
			if(x1>0 && x2>0){
		times +=x1;
			}else if(x2==0){
				times=0;
			}
		}

			
		}else{
			for(int i=1;i<=x1;i++){
				times += x2;
			}
		}
		return times;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int pow=1;
		for(int i=1;i<=n;i++){
			if(x>=0){
			pow=times(pow, x );}
			else if(x<0){
				x= times(x,(-1));
				pow=times(pow, x );

			}
		}
		return pow;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int count=0;
		if(x1>=0 && x2>=0){
		while (x1>=x2) {
			 x1 = minus(x1,x2);
			count++;
		}
		} else if(x1<0 && x2<0){
			x1= times(x1,(-1));
			x2= times(x2,(-1));
			while (x1>=x2) {
				x1 = minus(x1,x2);
			   count++;
			}
		}else if(x1<0 && x2>0){
			x1= times(x1,(-1));
			while (x1>=x2) {
				x1 = minus(x1,x2);
			   count++;
			}
			count=times(count,(-1));

		}else if(x1>0 && x2<0){
			x2= times(x2,(-1));
			while (x1>=x2) {
				x1 = minus(x1,x2);
			   count++;
			}
			count=times(count,(-1));
		}


			

		
		
		return count;	
		}
		
	

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int mod1= div(x1,x2);
		int mod2= x1-times(mod1,x2);

		
		return mod2;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int sqrt=0;
		for(int i=1;i<=x;i++){
			int p= times(i,i);
			
			if(p==x){
				sqrt=i;
				break;
			}
		}
		return sqrt;
	}	  	  
}