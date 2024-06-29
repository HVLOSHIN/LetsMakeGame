package prototypeSystem.gameSaveLoad;

import java.sql.SQLException;
import java.util.Scanner;

public class GameExitClass {
    Scanner scanner = new Scanner(System.in);

    public static void exitGame() throws SQLException {
        System.out.println("게임을 종료합니다.");
        GameSaveClass.gameSave();
        System.exit(0);
    }




}
