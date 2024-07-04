package prototypeSystem.System;

import prototypeSystem.character.Player;
import prototypeSystem.game.Achievements;
import prototypeSystem.item.Armor;
import prototypeSystem.item.Weapon;

import java.sql.*;

public class DatabaseConnect {
    private Connection conn;

    //DB Connect
    public DatabaseConnect() {
        String url = "jdbc:mysql://localhost:3306/TextRPGSave";
        String user = "root";
        String password = "";
        conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("데이터 베이스 접속 중..");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
        } catch (
                SQLException e) {
            System.out.println("Connection 객체 생성 실패");
        }
    }

    //PLAYER
    public Player getPlayer(int playerId) throws SQLException {
        Player player = null;
        ResultSet rs = conn.prepareStatement("select * from playerSave where id=" + playerId).executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int level = rs.getInt(3);
            int maxHP = rs.getInt(4);
            int currentExp = rs.getInt(5);
            int STR = rs.getInt(6);
            int DEX = rs.getInt(7);
            int INT = rs.getInt(8);
            int usedExp = rs.getInt(9);
            int mapUnlock = rs.getInt(10);
            int money = rs.getInt(11);
            int killCount = rs.getInt(12);
            int deathCount = rs.getInt(13);
            player = new Player(id, name, level, maxHP, currentExp, currentExp, STR, DEX, INT, usedExp, mapUnlock, money, killCount, deathCount);
            System.out.println("세이브 불러오기 성공..");
        }
        return player;
    }

    public void savePlayer(Player player) throws SQLException {
        String sql = "update playerSave Set name = ?,level = ?,maxHealth = ?,currentEXP = ?,strengthAbility = ?,dexterityAbility = ?,intelligenceAbility = ?,usedExp = ?, mapUnlock =?, money =?,killCount=?, deathCount=? where id=?";

        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, player.getName());
        psmt.setInt(2, player.getLevel());
        psmt.setInt(3, player.getMaxHP());
        psmt.setInt(4, player.getCurrentEXP());
        psmt.setInt(5, player.getSTR());
        psmt.setInt(6, player.getDEX());
        psmt.setInt(7, player.getINT());
        psmt.setInt(8, player.getUsedExp());
        psmt.setInt(9, player.getMapUnlock());
        psmt.setInt(10, player.getGold());
        psmt.setInt(11, player.getKillCount());
        psmt.setInt(12, player.getDeathCount());

        psmt.setInt(13, player.getId());  //얘가 무조건 끝에 와야함
        psmt.executeUpdate();
        System.out.println("캐릭터 세이브 저장 완료..");
    }

    //WEAPON

    public Weapon getWeapon(int weaponID) throws SQLException {
        Weapon weapon = null;

        ResultSet rs = conn.prepareStatement("select * from TextRPGSave.saveWeapon where id=" + weaponID).executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int addDamage = rs.getInt(3);
            int multDamage = rs.getInt(4);
            int addMagicDamage = rs.getInt(5);
            int multMagicDamage = rs.getInt(6);
            int addSTR = rs.getInt(7);
            int addDEX = rs.getInt(8);
            int addINT = rs.getInt(9);
            int addHP = rs.getInt(10);
            int price = rs.getInt(11);
            int have = rs.getInt(12);
            weapon = new Weapon(id, name, addDamage, multDamage, addMagicDamage, multMagicDamage, addSTR, addDEX, addINT, addHP, price, have);

        }

        return weapon;
    }

    public Weapon getWeaponOriginal(int weaponID) throws SQLException {
        Weapon weapon = null;

        ResultSet rs = conn.prepareStatement("select * from TextRPGSave.SaveWeaponOriginal where id=" + weaponID).executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int addDamage = rs.getInt(3);
            int multDamage = rs.getInt(4);
            int addMagicDamage = rs.getInt(5);
            int multMagicDamage = rs.getInt(6);
            int addSTR = rs.getInt(7);
            int addDEX = rs.getInt(8);
            int addINT = rs.getInt(9);
            int addHP = rs.getInt(10);
            int price = rs.getInt(11);
            int have = rs.getInt(12);
            weapon = new Weapon(id, name, addDamage, multDamage, addMagicDamage, multMagicDamage, addSTR, addDEX, addINT, addHP, price, have);

        }

        return weapon;
    }

    public void saveWeapon(Weapon[] weapon, int weaponArraySize) throws SQLException {

        String sql = "update TextRPGSave.saveWeapon set name =?, addDamage=?,multDamage=?,addMagicDamage=?,multMagicDamage=?,addSTR=?,addDEX=?,addINT=?,addHP=?,price=?,have=? where id=?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        for (int i = 1; i < 10; i++) {
            psmt.setString(1, weapon[i].getName());
            psmt.setInt(2, weapon[i].getAddDamage());
            psmt.setInt(3, weapon[i].getMultDamage());
            psmt.setInt(4, weapon[i].getAddMagicDamage());
            psmt.setInt(5, weapon[i].getMultMagicDamage());
            psmt.setInt(6, weapon[i].getAddSTR());
            psmt.setInt(7, weapon[i].getAddDEX());
            psmt.setInt(8, weapon[i].getAddINT());
            psmt.setInt(9, weapon[i].getAddHP());
            psmt.setInt(10, weapon[i].getPrice());
            psmt.setInt(11, weapon[i].getHave());

            psmt.setInt(12, weapon[i].getID());
            psmt.executeUpdate();
            //  System.out.println("무기 세이브 저장 완료..");
        }
    }

    //ARMOR

    public Armor getArmor(int armorID) throws SQLException {
        Armor armor = null;

        ResultSet rs = conn.prepareStatement("select * from TextRPGSave.SaveArmor where id=" + armorID).executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int addDamage = rs.getInt(3);
            int multDamage = rs.getInt(4);
            int addMagicDamage = rs.getInt(5);
            int multMagicDamage = rs.getInt(6);
            int addSTR = rs.getInt(7);
            int addDEX = rs.getInt(8);
            int addINT = rs.getInt(9);
            int addHP = rs.getInt(10);
            int price = rs.getInt(11); //이상하게 SaveArmor 테이블만 Column 순서 꼬여있음 (11,12)
            int have = rs.getInt(12);
            armor = new Armor(id, name, addDamage, multDamage, addMagicDamage, multMagicDamage, addSTR, addDEX, addINT, addHP, price, have);

        }

        return armor;
    }

    public Armor getArmorOriginal(int armorID) throws SQLException {
        Armor armor = null;

        ResultSet rs = conn.prepareStatement("select * from TextRPGSave.SaveArmorOriginal where id=" + armorID).executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int addDamage = rs.getInt(3);
            int multDamage = rs.getInt(4);
            int addMagicDamage = rs.getInt(5);
            int multMagicDamage = rs.getInt(6);
            int addSTR = rs.getInt(7);
            int addDEX = rs.getInt(8);
            int addINT = rs.getInt(9);
            int addHP = rs.getInt(10);
            int price = rs.getInt(11);
            int have = rs.getInt(12);
            armor = new Armor(id, name, addDamage, multDamage, addMagicDamage, multMagicDamage, addSTR, addDEX, addINT, addHP, price, have);

        }

        return armor;
    }

    public void saveArmor(Armor[] armor, int armorArraySize) throws SQLException {


        String sql = "update TextRPGSave.SaveArmor set name =?, addDamage=?,multDamage=?,addMagicDamage=?,multMagicDamage=?,addSTR=?,addDEX=?,addINT=?,addHP=?,price=?, have=? where id=?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        for (int i = 1; i < 10; i++) {
            psmt.setString(1, armor[i].getName());
            psmt.setInt(2, armor[i].getAddDamage());
            psmt.setInt(3, armor[i].getMultDamage());
            psmt.setInt(4, armor[i].getAddMagicDamage());
            psmt.setInt(5, armor[i].getMultMagicDamage());
            psmt.setInt(6, armor[i].getAddSTR());
            psmt.setInt(7, armor[i].getAddDEX());
            psmt.setInt(8, armor[i].getAddINT());
            psmt.setInt(9, armor[i].getAddHP());
            psmt.setInt(10, armor[i].getPrice());
            psmt.setInt(11, armor[i].getHave());//이상하게 SaveArmor 테이블만 Column 순서 꼬여있음 (11,12)

            psmt.setInt(12, armor[i].getID());
            psmt.executeUpdate();
            //  System.out.println("무기 세이브 저장 완료..");
        }
    }

    //ACHIEVE
    public Achievements getAchievements(int achievementID) throws SQLException {
        Achievements achievements = null;

        ResultSet resultSet = conn.prepareStatement("select * from TextRPGSave.saveAchievements where id=" + achievementID).executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            int clear = resultSet.getInt(2);
            String name = resultSet.getString(3);
            String description = resultSet.getString(4);

            achievements = new Achievements(id, clear, name, description);
        }
        return achievements;
    }

    public Achievements getAchievementsOriginal(int achievementID) throws SQLException {
        Achievements achievements = null;

        ResultSet resultSet = conn.prepareStatement("select * from TextRPGSave.saveAchievementsOriginal where id=" + achievementID).executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            int clear = resultSet.getInt(2);
            String name = resultSet.getString(3);
            String description = resultSet.getString(4);

            achievements = new Achievements(id, clear, name, description);
        }
        return achievements;
    }

    public void saveAchievements(Achievements[] achievements, int achieveArraySize) throws SQLException {
        String sql = "update TextRPGSave.saveAchievements set clear =?, name =?, description =? where id=?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        for (int i = 1; i <= achieveArraySize; i++) {
            psmt.setInt(1, achievements[i].getClear());
            psmt.setString(2, achievements[i].getAchieveName());
            psmt.setString(3, achievements[i].getAchieveDesc());

            psmt.setInt(4, achievements[i].getAchieveID());
            psmt.executeUpdate();
        }
    }

}

