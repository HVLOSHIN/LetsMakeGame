package prototypeSystem.System;

import prototypeSystem.character.Player;
import prototypeSystem.game.Achievements;
import prototypeSystem.item.weapon.Weapon;

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
    //플레이어 세이브 불러오기
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
            int deathCount = resultSet.getInt(13);
            player = new Player(id, name, level, maxHealth, currentExp, currentExp, strengthAbility, dexterityAbility, intelligenceAbility, usedExp, mapUnlock ,money, killCount, deathCount);


            System.out.println("세이브 불러오기 성공..");
        }
        return player;
    }

    public Weapon getWeapon(int weaponID) throws SQLException {
        Weapon weapon = null;

        ResultSet resultSet = conn.prepareStatement("select * from TextRPGSave.saveWeapon where id=" +weaponID).executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int addDamage = resultSet.getInt(3);
            int multDamage = resultSet.getInt(4);
            int addMagicDamage = resultSet.getInt(5);
            int multMagicDamage = resultSet.getInt(6);
            int addSTR = resultSet.getInt(7);
            int addDEX = resultSet.getInt(8);
            int addINT = resultSet.getInt(9);
            int addHP = resultSet.getInt(10);
            int price = resultSet.getInt(11);
            int have = resultSet.getInt(12);
            weapon = new Weapon(id,name,addDamage,multDamage,addMagicDamage,multMagicDamage,addSTR,addDEX,addINT,addHP,price,have);

        }

        return  weapon;
    }

    public Weapon getWeaponOriginal(int weaponID) throws SQLException {
        Weapon weapon = null;

        ResultSet resultSet = conn.prepareStatement("select * from TextRPGSave.SaveWeaponOriginal where id=" +weaponID).executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int addDamage = resultSet.getInt(3);
            int multDamage = resultSet.getInt(4);
            int addMagicDamage = resultSet.getInt(5);
            int multMagicDamage = resultSet.getInt(6);
            int addSTR = resultSet.getInt(7);
            int addDEX = resultSet.getInt(8);
            int addINT = resultSet.getInt(9);
            int addHP = resultSet.getInt(10);
            int price = resultSet.getInt(11);
            int have = resultSet.getInt(12);
            weapon = new Weapon(id,name,addDamage,multDamage,addMagicDamage,multMagicDamage,addSTR,addDEX,addINT,addHP,price,have);

        }

        return  weapon;
    }

    public Achievements getAchievements(int achievementID) throws SQLException {
        Achievements achievements = null;

        ResultSet resultSet = conn.prepareStatement("select * from TextRPGSave.Achievements where id=" +achievementID).executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            int clear = resultSet.getInt(2);
            String name = resultSet.getString(3);
            String description = resultSet.getString(4);

            achievements = new Achievements(id, clear, name, description );
        }
        return achievements;
    }
    public Achievements getAchievementsOriginal(int achievementID) throws SQLException {
        Achievements achievements = null;

        ResultSet resultSet = conn.prepareStatement("select * from TextRPGSave.AchievementsOriginal where id=" +achievementID).executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            int clear = resultSet.getInt(2);
            String name = resultSet.getString(3);
            String description = resultSet.getString(4);

            achievements = new Achievements(id, clear, name, description );
        }
        return achievements;
    }





    public void saveWeapon(Weapon[] weapon) throws SQLException {

        String sql = "update TextRPGSave.saveWeapon set name =?, addDamage=?,multDamage=?,addMagicDamage=?,multMagicDamage=?,addSTR=?,addDEX=?,addINT=?,addHP=?,price=?,have=? where id=?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        for (int i = 1 ; i < 10; i++) {
            psmt.setString(1, weapon[i].getWeaponName());
            psmt.setInt(2, weapon[i].getWeaponAddDamage());
            psmt.setInt(3, weapon[i].getWeaponMultDamage());
            psmt.setInt(4, weapon[i].getWeaponAddMajicDamage());
            psmt.setInt(5, weapon[i].getWeaponmultMajicDamage());
            psmt.setInt(6, weapon[i].getWeaponAddSTR());
            psmt.setInt(7, weapon[i].getWeaponAddDEX());
            psmt.setInt(8, weapon[i].getWeaponAddINT());
            psmt.setInt(9, weapon[i].getWeaponAddHP());
            psmt.setInt(10, weapon[i].getWeaponPrice());
            psmt.setInt(11, weapon[i].getPlayerHave());

            psmt.setInt(12, weapon[i].getWeaponID());
            psmt.executeUpdate();
            //  System.out.println("무기 세이브 저장 완료..");
        }
    }
    public void saveAchievements(Achievements[] achievements) throws SQLException {
        String sql = "update TextRPGSave.Achievements set clear =?, name =?, description =? where id=?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        for (int i = 1 ; i <= 5; i++) {
            psmt.setInt(1, achievements[i].getClear());
            psmt.setString(2,achievements[i].getAchieveName());
            psmt.setString(3,achievements[i].getAchieveDesc());

            psmt.setInt(4,achievements[i].getAchieveID());
            psmt.executeUpdate();
        }
    }




    // 플레이어 세이브 저장
    public void savePlayer(Player player) throws SQLException {
        String sql = "update TextRPGSave Set name = ?,level = ?,maxHealth = ?,currentEXP = ?,strengthAbility = ?,dexterityAbility = ?,intelligenceAbility = ?,usedExp = ?, mapUnlock =?, money =?,killCount=?, deathCount=? where id=?";

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
        psmt.setInt(12, player.getDeathCount());

        psmt.setInt(13, player.getId());  //얘가 무조건 끝에 와야함
        psmt.executeUpdate();
        System.out.println("캐릭터 세이브 저장 완료..");
    }



}

