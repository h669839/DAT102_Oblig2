package RekursiveFunksjoner;

public class c_og_d {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
		System.out.print(fib(i) + " ");
		}
		System.out.println();
		
		ikkeRekursivFib(30);

	}
	
	public static int fib(int n) {
		if(n > 1) {
			return fib(n-1)+fib(n-2);
		}else if(n==1) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void ikkeRekursivFib(int n) {
		int n1 = 0;
		int n2 = 1;
		
		int teller = 0;
		
		 while(teller < n) {
			 System.out.print(n1 + " ");
			 
			 int n3 = n1 + n2;
			 n1= n2;
			 n2 = n3;
			 teller +=1;
			 
		 }
		
		
	}

}
