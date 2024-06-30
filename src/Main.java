import prototypeSystem.Character.EnemySpawn;
import prototypeSystem.Character.Player;
import prototypeSystem.database.DatabaseConnect;
import prototypeSystem.gameSaveLoad.GameSaveClass;
import prototypeSystem.gameSaveLoad.GameStartClass;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnect databaseConnect = new DatabaseConnect();
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        GameStartClass gameStartClass = new GameStartClass();
        GameSaveClass gameSaveClass = new GameSaveClass();
        gameStartClass.gameStart();

        EnemySpawn e = new EnemySpawn();

        player.setMaxHealth(500);

        gameSaveClass.gameSave(player,databaseConnect);

        System.out.println("게임을 종료합니다.");
        System.exit(0);


    }
}