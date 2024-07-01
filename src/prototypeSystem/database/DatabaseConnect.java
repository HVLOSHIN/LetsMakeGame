package prototypeSystem.database;

import prototypeSystem.character.Player;
import prototypeSystem.item.WeaponShop;

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
            System.out.println("데이터 베이스 접속 중..");

//

//            conn.prepareStatement("s")
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
        } catch (
                SQLException e) {
            System.out.println("Connection 객체 생성 실패");
        }
        /*finally {
           try {
                if (conn != null) {
                    conn.close();
                }
            }
            catch(SQLException e){
                    System.out.println("Conn.close() 에러");
                }
            }
        }
    }*/
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
            int currentExp = resultSet.getInt(5);
            int strengthAbility = resultSet.getInt(6);
            int dexterityAbility = resultSet.getInt(7);
            int intelligenceAbility = resultSet.getInt(8);
            int usedExp = resultSet.getInt(9);
            int mapUnlock = resultSet.getInt(10);
            int money = resultSet.getInt(11);
            int killCount = resultSet.getInt(12);
            player = new Player(id, name, level, maxHealth, currentExp, currentExp, strengthAbility, dexterityAbility, intelligenceAbility, usedExp, mapUnlock ,money, killCount);


            System.out.println("세이브 불러오기 성공..");
        }
        return player;
    }

    public void savePlayer(Player player) throws SQLException {
        String sql = "update TextRPGSave Set name = ?,level = ?,maxHealth = ?,currentEXP = ?,strengthAbility = ?,dexterityAbility = ?,intelligenceAbility = ?,usedExp = ?, mapUnlock =?, money =?,killCount=? where id=?";

        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, player.getName());
        psmt.setInt(2, player.getLevel());
        psmt.setInt(3, player.getMaxHealth());
        psmt.setInt(4, player.getCurrentEXP());
        psmt.setInt(5, player.getStrengthAbility());
        psmt.setInt(6, player.getDexterityAbility());
        psmt.setInt(7, player.getIntelligenceAbility());
        psmt.setInt(8, player.getUsedExp());
        psmt.setInt(9, player.getMapUnlock());
        psmt.setInt(10,player.getMoney());
        psmt.setInt(11, player.getKillCount());

        psmt.setInt(12, player.getId());  //얘가 무조건 끝에 와야함
        psmt.executeUpdate();

       // String sql2 =


        System.out.println("세이브 저장 완료..");
    }
}

