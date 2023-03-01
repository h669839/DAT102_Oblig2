package RekursiveFunksjoner;

public class a {

	public static void main(String[] args) {
		System.out.print(sum(100));

	}
	
	public static int sum(int n) {
		if(n>0) {
			return n + sum(n-1);
		}else {
			return 0;
		}
	}

}
