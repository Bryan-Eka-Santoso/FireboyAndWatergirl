import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        int menuAwal, player = 0;
        String keyGame;
        int currentCoin = 0;
        boolean currentWin = false;

        Scanner scanI = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);

        char[][] map = {
            {'=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '='},
            {'|', ' ', ' ', 'C', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ']', '[', ' ', '|'},
            {'=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', ' ', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '='},
            {'|', ' ', ' ', ' ', ' ', ' ', 'E', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'=', '=', ' ', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', ' ', '=', '='},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'C', ' ', ' ', ' ', ' ', '|'},
            {'=', '=', '=', 'W', 'W', 'W', 'W', 'W', '=', '=', '-', '-', '-', '=', '=', '=', '=', '=', '=', '=', '=', '=', '='},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'T', ' ', '|'},
            {'=', '=', '=', '=', ' ', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', '=', ' ', '=', '=', '=', '='},
            {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'=', '=', '=', '=', '=', '=', '=', '=', '=', 'L', 'L', 'L', 'L', 'L', '=', '=', '=', '=', '=', '=', '=', '=', '='}
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
                boolean trapDoor = false;
                boolean kenaTrap = false;
                boolean exitDoor = false;
                boolean fbDone = false;
                boolean wgDone = false;
                int coin = 0;
                boolean win = false;
                char[][] mapChar = new char[11][23];
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[0].length; j++) {
                        mapChar[i][j] = map[i][j];
                    }
                }

                int xb = 2, yb = 9;
                int xg = 1, yg = 9;

                do {
                    if(player % 2 == 0){
                        System.out.println("Current Turn: Fire Boy");
                    } else {
                        System.out.println("Current Turn: Water Girl");
                    }

                    if(trapDoor){
                        mapChar[6][10] = ' ';
                        mapChar[6][11] = ' ';
                        mapChar[6][12] = ' ';
                    }

                    if(exitDoor){
                        mapChar[1][19] = '[';
                        mapChar[1][20] = ']';
                    }

                    for(int i = 0; i < mapChar.length; i++){
                        for(int j = 0; j < mapChar[0].length; j++){
                            if(mapChar[yg][xg] != '['){
                                mapChar[yg][xg] = 'G';
                            }
                            
                            if(mapChar[yb][xb] != '['){
                                mapChar[yb][xb] = 'B';
                            }
                            System.out.print(mapChar[i][j]);
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
                        if(keyGame.equals("a") && mapChar[yb][xb-1] != '|' && mapChar[yb][xb-1] != ']'){
                            mapChar[yb][xb] = ' ';
                            xb--;
                            if(!wgDone && !fbDone){
                                player++;
                            }
                            if(mapChar[yb+1][xb] == ' '){
                                mapChar[yb][xb] =  ' ';
                                yb+= 2;
                            } else if (mapChar[yb+1][xb] == 'W'){
                                mapChar[yb][xb] =  ' ';
                                kenaTrap = true;
                            } else if (mapChar[yb][xb] == 'T'){
                                trapDoor = true;
                            } else if (mapChar[yb][xb] == 'C'){
                                coin++;
                            } else if (mapChar[yb][xb] == 'E'){
                                exitDoor = true;
                            }
                        } else if (keyGame.equals("d") && mapChar[yb][xb+1] != '|' && mapChar[yb][xb+1] != ']'){
                            mapChar[yb][xb] = ' ';
                            xb++;
                            if(!wgDone && !fbDone){
                                player++;
                            }
                            if(mapChar[yb+1][xb] == ' '){
                                mapChar[yb][xb] =  ' ';
                                yb+= 2;
                            } else if (mapChar[yb+1][xb] == 'W'){
                                mapChar[yb][xb] =  ' ';
                                kenaTrap = true;
                            } else if (mapChar[yb][xb] == 'T'){
                                trapDoor = true;
                            } else if (mapChar[yb][xb] == 'C'){
                                coin++;
                            } else if (mapChar[yb][xb] == 'E'){
                                exitDoor = true;
                            } else if (mapChar[yb][xb] == '['){
                                fbDone = true;
                            }
                        } else if (keyGame.equals("q") && mapChar[yb-1][xb] == ' '){
                            mapChar[yb][xb] = ' ';
                            xb--;
                            if(!wgDone && !fbDone){
                                player++;
                            }
                            if(mapChar[yb-1][xb] == '='){
                                yb -= 2;
                            }
                        } else if (keyGame.equals("e") && mapChar[yb-1][xb] == ' '){
                            mapChar[yb][xb] = ' ';
                            xb++;
                            if(!wgDone && !fbDone){
                                player++;
                            }
                            if(mapChar[yb-1][xb] == '='){
                                yb -= 2;
                            }
                        }
                    } else {
                        if(keyGame.equals("a") && mapChar[yg][xg-1] != '|' && mapChar[yg][xg-1] != ']'){
                            mapChar[yg][xg] = ' ';
                            xg--;
                            if(!wgDone && !fbDone){
                                player++;
                            }
                            if(mapChar[yg+1][xg] == ' '){
                                mapChar[yg][xg] =  ' ';
                                yg+= 2;
                            } else if (mapChar[yg+1][xg] == 'L'){
                                mapChar[yg][xg] =  ' ';
                                kenaTrap = true;
                            } else if (mapChar[yg][xg] == 'T'){
                                trapDoor = true;
                            } else if (mapChar[yg][xg] == 'C'){
                                coin++;
                            } else if (mapChar[yg][xg] == 'E'){
                                exitDoor = true;
                            }
                        } else if (keyGame.equals("d") && mapChar[yg][xg+1] != '|' && mapChar[yg][xg+1] != ']'){
                            mapChar[yg][xg] =  ' ';
                            xg++;
                            if(!wgDone && !fbDone){
                                player++;
                            }
                            if(mapChar[yg+1][xg] == ' '){
                                mapChar[yg][xg] =  ' ';
                                yg+= 2;
                            } else if (mapChar[yg+1][xg] == 'L'){
                                mapChar[yg][xg] =  ' ';
                                kenaTrap = true;
                            } else if (mapChar[yg][xg] == 'T'){
                                trapDoor = true;
                            } else if (mapChar[yg][xg] == 'C'){
                                coin++;
                            } else if (mapChar[yg][xg] == 'E'){
                                exitDoor = true;
                            } else if (mapChar[yg][xg] == '['){
                                wgDone = true;
                            }
                        } else if (keyGame.equals("q") && mapChar[yg-1][xg] == ' '){
                            mapChar[yg][xg] = ' ';
                            xg--;
                            if(!wgDone && !fbDone){
                                player++;
                            }
                            if(mapChar[yg-1][xg] == '='){
                                yg -= 2;
                            }
                        } else if (keyGame.equals("e") && mapChar[yg-1][xg] == ' '){
                            mapChar[yg][xg] = ' ';
                            xg++;
                            if(!wgDone && !fbDone){
                                player++;
                            }
                            if(mapChar[yg-1][xg] == '='){
                                yg -= 2;
                            }
                        }
                    }

                    if (wgDone && fbDone){
                        win = true;
                    }

                } while (!keyGame.equals("0") && !kenaTrap && !win);

                if(keyGame.equals("0") || kenaTrap){
                    System.out.println("Game Over!");
                    if(currentCoin < coin){
                        currentCoin = coin;
                    }
                } else {
                    if(currentCoin < coin){
                        currentCoin = coin;
                    }

                    if(!currentWin){
                        currentWin = true;
                    }

                    System.out.println("You Win!");
                }

            } else if (menuAwal == 2){
                System.out.println("= Your Progress =");
                System.out.println("Coin: " + currentCoin + "/2");
                if(currentWin){
                    System.out.println("Exit Reached!");
                } else {
                    System.out.println("Exit Not Reached Yet!");
                }
            }
        } while (menuAwal !=3);

        scanI.close();
        scanS.close();
    }
}
