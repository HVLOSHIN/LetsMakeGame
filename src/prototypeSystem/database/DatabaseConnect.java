package prototypeSystem.database;

import prototypeSystem.Character.Enemy;
import prototypeSystem.Character.Player;

import java.sql.*;

public class DatabaseConnect {
    private Connection conn;
    public DatabaseConnect() {
        String url = "jdbc:mysql://localhost:3306/TextRPGSave";
        String user = "root";
        String password = "";
        conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection 객체 생성 성공");

//

//            conn.prepareStatement("s")
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
        } catch (
                SQLException e) {
            System.out.println("Connection 객체 생성 실패");
        } finally {
//            try {
//                if (conn != null) {
////                    conn.close();
//                }
//            }
//            catch(SQLException e){
//                    System.out.println("Conn.close() 에러");
//                }
//            }
        }
    }


    public Player getPlayer(int playerId) throws SQLException {
            Player player = null;
//            conn.prepareStatement("insert into TextRPGSave(name,level,maxHealth,maxEXP,currentEXP,strengthAbility,dexterityAbility) values ('b', 1,100,100,100,100,100);").execute();
            ResultSet resultSet = conn.prepareStatement("select * from TextRPGSave where id=" + playerId).executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int level = resultSet.getInt(3);
                int maxHealth = resultSet.getInt(4);
                int maxExp = resultSet.getInt(5);
                int currentExp = resultSet.getInt(6);
                int strengthAbility = resultSet.getInt(6);
                int dexterityAbility = resultSet.getInt(6);
                player = new Player(id, name, level, maxHealth, currentExp, maxExp, currentExp, strengthAbility, dexterityAbility);
                System.out.println(player);
            }
            return player;
    }
    public void savePlayer(Player player) throws SQLException {
        String sql = "update TextRPGSave Set name = ?,level = ?,maxHealth = ?,maxEXP = ?,currentEXP = ?,strengthAbility = ?,dexterityAbility = ? where id=?";

        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, player.getName());
        psmt.setInt(2, player.getLevel());
        psmt.setInt(3, player.getMaxHealth());
        psmt.setInt(4, player.getMaxEXP());
        psmt.setInt(5, player.getCurrentEXP());
        psmt.setInt(6, player.getStrengthAbility());
        psmt.setInt(7, player.getDexterityAbility());
        psmt.setInt(8, player.getId());
        psmt.executeUpdate();
    }
}

