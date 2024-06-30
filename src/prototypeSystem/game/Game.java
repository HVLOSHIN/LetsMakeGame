package prototypeSystem.game;

import prototypeSystem.Character.Player;
import prototypeSystem.database.DatabaseConnect;
import java.sql.SQLException;
import java.util.Scanner;

public class Game {
    private DatabaseConnect databaseConnect;

    public Game(DatabaseConnect databaseConnect) {
        this.databaseConnect = databaseConnect;
    }

    Scanner scanner = new Scanner(System.in);
    public Player gameStart() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Game Start");
        System.out.println("1.불러오기 | 2.새로 시작");
        int choice = scanner.nextInt();
        Player returnPlayer = null;
        switch (choice) {
            case 1:
                returnPlayer = databaseConnect.getPlayer(1);
                System.out.println(returnPlayer.getName() + "님, 모험을 시작합니다.");
                break;
            case 2:
                System.out.println("플레이어 이름 : ");
                String newPlayerName = scanner.next();
                returnPlayer = new Player(newPlayerName);
                System.out.println(returnPlayer.getName() + "님, 모험을 시작합니다.");
                break;
            default:
                System.out.println("올바른 입력이 아닙니다.");
        }
        return returnPlayer;

    }
    public void gameSave(Player player) throws SQLException {
        {
            System.out.println("게임을 세이브 하시겠습니까?");
            System.out.println("1.저장 | 2.저장안함");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    databaseConnect.savePlayer(player);
                    System.out.println(player);
                    break;
                case 2:
                    System.out.println("저장 취소");
                    break;
                default:
                    System.out.println("올바른 입력이 아닙니다.");
            }
        }
    }
    public void gameExit(Player player) throws SQLException {
        this.gameSave(player);
        System.out.println("게임을 종료합니다.");
        System.exit(0);
    }
}
