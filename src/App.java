import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        int menuAwal;

        Scanner scanI = new Scanner(System.in);

        do {
            System.out.println("== Fire Boy & Water Girl ==");
            System.out.println("1. Play");
            System.out.println("2. Your Progress");
            System.out.println("3. Exit");
            do {
                System.out.print(">> ");
                menuAwal = scanI.nextInt();
            } while (menuAwal < 1 || menuAwal > 3);

            if(menuAwal == 1){

            } else if (menuAwal == 2){
                System.out.println("= Your Progress =");
            }

        } while (menuAwal !=3);
    }
}
