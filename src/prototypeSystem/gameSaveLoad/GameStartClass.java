package prototypeSystem.gameSaveLoad;

import prototypeSystem.Character.Player;
import prototypeSystem.database.DatabaseConnect;

import java.sql.SQLException;
import java.util.Scanner;

public class GameStartClass {

    public void gameStart() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Game Start");
        System.out.println("1.불러오기 | 2.새로 시작");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                DatabaseConnect databaseConnect = new DatabaseConnect();
                Player player = databaseConnect.getPlayer(1);
                System.out.println(player.getName() + "님, 모험을 시작합니다.");
                break;
            case 2:
                System.out.println("플레이어 이름 : ");
                String newPlayerName = scanner.next();
                Player newPlayer = new Player(newPlayerName);
                System.out.println(newPlayer.getName() + "님, 모험을 시작합니다.");
                break;
            default:
                System.out.println("올바른 입력이 아닙니다.");
        }
    }
}
