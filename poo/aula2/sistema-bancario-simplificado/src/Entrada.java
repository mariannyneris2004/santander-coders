import java.util.Scanner;

public class Entrada {
    public static String getStringNextLine(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String getStringNext(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static double getDouble(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    public static int getInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
