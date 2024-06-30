package prototypeSystem.gameSaveLoad;

import prototypeSystem.Character.Player;
import prototypeSystem.database.DatabaseConnect;

import java.sql.SQLException;
import java.util.Scanner;

public class GameSaveClass {
    Scanner scanner = new Scanner(System.in);
  //  DatabaseConnect databaseConnect = new DatabaseConnect();
    public void gameSave(Player player, DatabaseConnect databaseConnect) throws SQLException {
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
    }
}
