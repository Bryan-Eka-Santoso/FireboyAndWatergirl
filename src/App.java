import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        int menuAwal, player = 0;
        String keyGame;
        int coin = 0;
        boolean done = false;

        Scanner scanI = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);

        // 1 =
        // 2 |
        // 3 Fireboy B
        // 4 Watergirl G

        int[][] map = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {2, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

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
                do {
                    if(player % 2 == 0){
                        System.out.println("Current Turn: Fire Boy");
                    } else {
                        System.out.println("Current Turn: Water Girl");
                    }

                    for(int i = 0; i < 11; i++){
                        for(int j = 0; j < 23; j++){
                            if(map[i][j] == 1){
                                System.out.print("=");
                            } else if(map[i][j] == 2){
                                System.out.print("|");
                            } else if(map[i][j] == 3){
                                System.out.print("B");
                            } else if(map[i][j] == 4){
                                System.out.print("G");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    
                    System.out.println("Coin: " + coin + "/2");
                    System.out.println("A = Right");
                    System.out.println("D = Left");
                    System.out.println("Q = Jump to Right Platform");
                    System.out.println("E = Jump to Left Platform");
                    System.out.print("Input Move: ");
                    keyGame = scanS.nextLine();

                    if(player % 2 == 0){
                        if(keyGame.charAt(0) == 'A'){
                            
                        } else if (keyGame.charAt(0) == 'D'){

                        } else if (keyGame.charAt(0) == 'Q'){

                        } else if (keyGame.charAt(0) == 'E'){

                        }
                    } else {
                        if(keyGame.charAt(0) == 'A'){

                        } else if (keyGame.charAt(0) == 'D'){

                        } else if (keyGame.charAt(0) == 'Q'){

                        } else if (keyGame.charAt(0) == 'E'){

                        }
                    }

                } while (keyGame.charAt(0) != '0');

                if(keyGame.charAt(0) == '0'){
                    System.out.println("Game Over!");
                }

            } else if (menuAwal == 2){
                System.out.println("= Your Progress =");
                System.out.println("Coin: " + coin + "/2");
                if(done){
                    System.out.println("Exit Reached!");
                } else {
                    System.out.println("Exit Not Reached Yet!");
                }
            }

        } while (menuAwal !=3);
    }
}
