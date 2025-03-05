import java.util.*;

public class App {
    // For System("Cls");
    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        int menuAwal, player = 0;
        String keyGame;
        int coin = 0;
        boolean win = false;
        boolean door = false;

        Scanner scanI = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);

        int xb = 2, yb = 9;
        int xg = 1, yg = 9;

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
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
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
                            map[yb][xb] = 3; 
                            map[yg][xg] = 4; 

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
                        if(keyGame.charAt(0) == 'A' && map[yb][xb+1] == 0){
                            map[yb][xb] = 0;
                            xb++;
                            player++;
                        } else if (keyGame.charAt(0) == 'D' && map[yb][xb-1] == 0){
                            map[yb][xb] = 0;
                            xb--;
                            player++;
                        } else if (keyGame.charAt(0) == 'Q'){

                        } else if (keyGame.charAt(0) == 'E'){

                        }
                    } else {
                        if(keyGame.charAt(0) == 'A' && map[yg][xg+1] == 0){
                            map[yg][xg] = 0;
                            xg++;
                            player++;
                        } else if (keyGame.charAt(0) == 'D' && map[yg][xg-1] == 0){
                            map[yg][xg] = 0;
                            xg--;
                            player++;
                        } else if (keyGame.charAt(0) == 'Q'){

                        } else if (keyGame.charAt(0) == 'E'){

                        }
                    }
                    clear();
                } while (keyGame.charAt(0) != '0');

                if(keyGame.charAt(0) == '0'){
                    System.out.println("Game Over!");
                } else {
                    System.out.println("You Win!");
                    coin = 0;
                    win = false;
                }

            } else if (menuAwal == 2){
                System.out.println("= Your Progress =");
                System.out.println("Coin: " + coin + "/2");
                if(win){
                    System.out.println("Exit Reached!");
                } else {
                    System.out.println("Exit Not Reached Yet!");
                }
            }

        } while (menuAwal !=3);
    }
}
