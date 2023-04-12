import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int N = Integer.parseInt(myObj.nextLine());

        if (N % 2 == 1 || ((N % 2 == 0) && (6 <= N && N <= 20))) {
            System.out.println("Weird");
        } else if (N % 2 == 0 && ((2 <= N && N <= 5) || (N > 20))) {
            System.out.println("Not Weird");
        }
    }
}

