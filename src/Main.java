import prototypeSystem.Character.EnemySpawn;
import prototypeSystem.Character.Player;
import prototypeSystem.database.DatabaseConnect;
import prototypeSystem.gameSaveLoad.GameExitClass;
import prototypeSystem.gameSaveLoad.GameSaveClass;
import prototypeSystem.gameSaveLoad.GameStartClass;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnect databaseConnect = new DatabaseConnect();
        Scanner scanner = new Scanner(System.in);
        //게임시작
        Player player = new Player();
        {
            System.out.println("Game Start");
            System.out.println("1.불러오기 | 2.새로 시작");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {

                    player = databaseConnect.getPlayer(1);
                    System.out.println(player.getName() + "님, 모험을 시작합니다.");
                    break;
                }
                case 2: {
                    System.out.println("플레이어 이름 : ");
                    String newPlayerName = scanner.next();
                    player = new Player(newPlayerName);
                    System.out.println(player.getName() + "님, 모험을 시작합니다.");
                    System.out.println( player.toString());
                    break;
                }
                default:
                    System.out.println("올바른 입력이 아닙니다.");
            }

        }
        EnemySpawn e = new EnemySpawn();

        {
            System.out.println("게임을 세이브 하시겠습니까?");
            System.out.println("1.저장 | 2.저장안함");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    System.out.println( player.toString());
                    databaseConnect.savePlayer(player);
                    break;
                case 2:
                    System.out.println("저장 취소");
                    break;
                default:
                    System.out.println("올바른 입력이 아닙니다.");
            }
        }
        GameExitClass.exitGame();


    }
}