import java.util.Random;

public class Random_Numbers {
	
	Random Rand = new Random();

	public void Get_Random_Number() {
		int Next_Number = Rand.nextInt(25); //Generates numbers between 0-24
	}
	public static void main(String[] args) {
		Random_Numbers RN = new Random_Numbers();
	}
}
