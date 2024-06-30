import prototypeSystem.Character.EnemySpawn;
import prototypeSystem.Character.Player;
import prototypeSystem.database.DatabaseConnect;
import prototypeSystem.game.Game;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnect databaseConnect = new DatabaseConnect();
        Scanner scanner = new Scanner(System.in);

        Game game = new Game(databaseConnect);
        Player player = game.gameStart();

        EnemySpawn e = new EnemySpawn();

        game.gameSave(player);

        game.gameExit(player);


    }
}