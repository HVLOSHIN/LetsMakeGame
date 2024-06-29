import prototypeSystem.Character.EnemySpawn;
import prototypeSystem.Character.Player;
import prototypeSystem.database.DatabaseConnect;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        DatabaseConnect databaseConnect = new DatabaseConnect();
//        Player player = new Player("HVLO");
//        System.out.println(player.getName());
        Player player = databaseConnect.getPlayer(1);

        player.setCurrentHealth(60);
        player.setMaxHealth(500);

        databaseConnect.savePlayer(player);
        EnemySpawn e = new EnemySpawn();
        e.getEnemyInfo(0);
        e.getEnemyInfo(1);


    }
}