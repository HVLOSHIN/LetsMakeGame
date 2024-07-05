package prototypeSystem.character;

import prototypeSystem.game.Achievements;
import prototypeSystem.item.Armor;
import prototypeSystem.item.Weapon;
import prototypeSystem.job.Job;

//@Getter


public class Player {

    private int id;
    private String name;
    private int level;
    private int maxHP;
    private int currentHP;
    private int currentEXP;
    private int usedExp;
    private int STR;
    private int DEX;
    private int INT;
    private int mapUnlock;
    private int gold;
    private int killCount;
    private int deathCount;


    private int addDamage;
    private int multDamage;
    private int addMDamage;
    private int multMDamage;
    private int addSTR;
    private int addDEX;
    private int addINT;
    private int addHP;


    public Player(int id, String name, int level, int maxHP, int currentHP, int currentEXP, int STR, int DEX, int INT, int usedExp, int mapUnlock, int gold, int killCount, int deathCount) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.maxHP = maxHP;
        this.currentHP = currentHP;
        this.currentEXP = currentEXP;
        this.STR = STR;
        this.DEX = DEX;
        this.INT = INT;
        this.usedExp = usedExp;
        this.mapUnlock = mapUnlock;
        this.gold = gold;
        this.killCount = killCount;
        this.deathCount = deathCount;
    }

    public Player(String name) {
        this.id = 1;
        this.name = name;
        this.level = 1;
        this.maxHP = 20;
        this.currentHP = maxHP;
        this.currentEXP = 50;
        this.STR = 2;
        this.DEX = 2;
        this.INT = 2;
        this.usedExp = 0;
        this.mapUnlock = 1;
        this.gold = 200;
        this.killCount = 0;

    }


    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getKillCount() {
        return killCount;
    }

    public void setKillCount(int killCount) {
        this.killCount = killCount;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public int getUsedExp() {
        return usedExp;
    }

    public void setUsedExp(int usedExp) {
        this.usedExp = usedExp;
    }

    public int getMapUnlock() {
        return mapUnlock;
    }

    public void setMapUnlock(int mapUnlock) {
        this.mapUnlock = mapUnlock;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getCurrentEXP() {
        return currentEXP;
    }

    public void setCurrentEXP(int currentEXP) {
        this.currentEXP = currentEXP;
    }

    public int getSTR() {
        return STR;
    }

    public void setSTR(int STR) {
        this.STR = STR;
    }

    public int getDEX() {
        return DEX;
    }

    public void setDEX(int DEX) {
        this.DEX = DEX;
    }

    public int getINT() {
        return INT;
    }

    public void setINT(int INT) {
        this.INT = INT;
    }

    public int getAddHP() {
        return addHP;
    }

    public void setAddHP(int addHP) {
        this.addHP = addHP;
    }

    public int getAddINT() {
        return addINT;
    }

    public void setAddINT(int addINT) {
        this.addINT = addINT;
    }

    public int getAddDEX() {
        return addDEX;
    }

    public void setAddDEX(int addDEX) {
        this.addDEX = addDEX;
    }

    public int getAddSTR() {
        return addSTR;
    }

    public void setAddSTR(int addSTR) {
        this.addSTR = addSTR;
    }

    public int getMultMDamage() {
        return multMDamage;
    }

    public void setMultMDamage(int multMDamage) {
        this.multMDamage = multMDamage;
    }

    public int getAddMDamage() {
        return addMDamage;
    }

    public void setAddMDamage(int addMDamage) {
        this.addMDamage = addMDamage;
    }

    public int getMultDamage() {
        return multDamage;
    }

    public void setMultDamage(int multDamage) {
        this.multDamage = multDamage;
    }

    public int getAddDamage() {
        return addDamage;
    }

    public void setAddDamage(int addDamage) {
        this.addDamage = addDamage;
    }



    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", maxHealth=" + maxHP +
                ", currentHealth=" + currentHP +
                ", currentEXP=" + currentEXP +
                ", usedExp=" + usedExp +
                ", strengthAbility=" + STR +
                ", dexterityAbility=" + DEX +
                ", intelligenceAbility=" + INT +
                '}';
    }

    public void showHaveItems(Weapon[] weapon, Armor[] armor) {
        getPlayerAddWeaponStats(weapon, armor);
        for (int i = 1; i < 8; i++) {

            if (weapon[i].getHave() == 1) {
                displayWeapons(weapon, i);
            }
        }
        for (int i = 1; i < 8; i++) {

            if (armor[i].getHave() == 1) {
                displayArmors(armor, i);
            }
        }
        getItemStats();
    }
    public void getPlayerAddWeaponStats(Weapon[] weapon, Armor[] armor) {
        resetItemStats();

        for (int i = 1; i < 8; i++) {
            if (weapon[i].getHave() == 1) {

                addDamage += weapon[i].getAddDamage();
                multDamage *= weapon[i].getMultDamage();
                addMDamage += weapon[i].getAddMagicDamage();
                multMDamage *= weapon[i].getMultMagicDamage();
                addSTR += weapon[i].getAddSTR();
                addDEX += weapon[i].getAddDEX();
                addINT += weapon[i].getAddINT();
                addHP += weapon[i].getAddHP();
            }
            if (armor[i].getHave() == 1) {

                addDamage += armor[i].getAddDamage();
                multDamage *= armor[i].getMultDamage();
                addMDamage += armor[i].getAddMagicDamage();
                multMDamage *= armor[i].getMultMagicDamage();
                addSTR += armor[i].getAddSTR();
                addDEX += armor[i].getAddDEX();
                addINT += armor[i].getAddINT();
                addHP += armor[i].getAddHP();
            }

        }
    }
    public void getPlayerAddAllStats(Weapon[] weapon, Armor[] armor, Job[] job) {
       getPlayerAddWeaponStats(weapon,armor);

        for (int i = 1; i <= 3; i++) {
            if(job[i].getJobHave() == 1) {
                addDamage += job[i].getAddDamage();
                multDamage *= job[i].getMultDamage();
                addMDamage += job[i].getAddMagicDamage();
                multMDamage *= job[i].getMultMagicDamage();
                addSTR += job[i].getAddSTR();
                addDEX += job[i].getAddDEX();
                addINT += job[i].getAddINT();
                addHP += job[i].getAddHP();
            }

        }






    }


    public void resetItemStats() {
        addDamage = 0;
        multDamage = 1;
        addMDamage = 0;
        multMDamage = 1;
        addSTR = 0;
        addDEX = 0;
        addINT = 0;
        addHP = 0;
    }

    public void displayWeapons(Weapon[] weapon, int i) {
        System.out.print(i + ". " + weapon[i].getName() + " - " + "물리공격력 : " + weapon[i].getAddDamage() + ", 물리배율 : " + weapon[i].getMultDamage());
        System.out.print(", 마법공격력 : " + weapon[i].getAddMagicDamage() + ", 마법배율 : " + weapon[i].getMultMagicDamage() + ", 근력 : " + weapon[i].getAddSTR());
        System.out.println(", 기교 : " + weapon[i].getAddDEX() + ", 지력 : " + weapon[i].getAddINT() + ", 체력 : " + weapon[i].getAddHP());
    }
    public void displayArmors(Armor[] armor, int i) {
        System.out.print(i + ". " + armor[i].getName() + " - " + "물리공격력 : " + armor[i].getAddDamage() + ", 물리배율 : " + armor[i].getMultDamage());
        System.out.print(", 마법공격력 : " + armor[i].getAddMagicDamage() + ", 마법배율 : " + armor[i].getMultMagicDamage() + ", 근력 : " + armor[i].getAddSTR());
        System.out.println(", 기교 : " + armor[i].getAddDEX() + ", 지력 : " + armor[i].getAddINT() + ", 체력 : " + armor[i].getAddHP());
    }
    public void getItemStats(){
        System.out.println("====================================");
        System.out.println("효과 (강화, 장비, 직업)");
        System.out.println(name + " : 물리공격력 : " + addDamage + ", 물리배율 : " + multDamage + ", 마법공격력 : " + addMDamage + ", 마법배율 : " + multMDamage + ", 근력 : " + addSTR + ", 기교 : " + addDEX + ", 지력 : "  + addINT + ", 추가 체력 : " + addHP);

    }

    public void getStatistics(){
        //통계 메서드
        System.out.println("처치한 적 : " + killCount);
        System.out.println("사용한 경험치 : " + usedExp);
        System.out.println("죽은 횟수 : " + deathCount);

        System.out.println("맵 언락 스테이지 : " + (mapUnlock));
        //System.out.println("처치한 가장 강한 적 : " );
    }
    public void showAchievements(Achievements[] achievements){
        int counter = 0;
        for(int i = 1 ; i <= 5 ; i++){
            if(achievements[i].getClear() == 1){
                System.out.println( i + ". " + achievements[i].getAchieveName()+" - "+achievements[i].getAchieveDesc());
                counter++;
            }

        }
        System.out.println();
        System.out.println("총 " + counter + "개의 업적 달성!");
        System.out.println("===============================");
        if(counter == 0){
            System.out.println("아무런 업적도 달성하지 못했습니다.");
        }
    }
}

