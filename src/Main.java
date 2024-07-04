import prototypeSystem.character.Player;
import prototypeSystem.System.DatabaseConnect;
import prototypeSystem.game.Game;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        DatabaseConnect databaseConnect = new DatabaseConnect();
        Game game = new Game(databaseConnect);
        Player player = game.gameStart();
        game.gameLogic(player);

    }
}