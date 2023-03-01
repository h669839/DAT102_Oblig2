package RekursiveFunksjoner;

public class b {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
		System.out.println(sum(i));
		}

	}
	public static int sum(int n) {
		if(n > 1) {
			return 5*sum(n-1)-6*sum(n-2)+2;
		} else if(n==1) {
			return 5;
		} else {
			return 2;
		}
	}

}
