package prototypeSystem.character;

public class Enemy {
    private String name;
    private int level;
    private int maxHP;
    private int currentHP;
    private int EXP;
    private int money;

    private int STR;
    private int DEX;
    private int INT;
    private int boss;
    private int bossSlain;

    public Enemy(String name, int level, int maxHP, int EXP, int money, int STR, int DEX, int INT) {
        this.name = name;
        this.level = level;
        this.maxHP = maxHP;
        this.EXP = EXP;
        this.money = money;
        this.STR = STR;
        this.DEX = DEX;
        this.INT = INT;
    }
    public Enemy(String name, int level, int maxHP, int EXP, int money, int STR, int DEX, int INT, int boss) {
        this.name = name;
        this.level = level;
        this.maxHP = maxHP;
        this.EXP = EXP;
        this.money = money;
        this.STR = STR;
        this.DEX = DEX;
        this.INT = INT;
        this.boss = boss;
    }


    public String getName() {
        return name;
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

    public int getLevel() {
        return level;
    }

    public int getEXP() {
        return EXP;
    }

    public int getSTR() {
        return STR;
    }

    public int getDEX() {
        return DEX;
    }

    public int getINT() {
        return INT;
    }

    public int getMoney() {
        return money;
    }

    public int getBossSlain() {
        return bossSlain;
    }

    public void setBossSlain(int bossSlain) {
        this.bossSlain = bossSlain;
    }

    public int getBoss() {
        return boss;
    }

    public void setBoss(int boss) {
        this.boss = boss;
    }

    @Override
    public String toString() {
        return
                "이름 : " + name +
                        ", 레벨 : " + level
                        + ", 체력 : " + maxHP;

    }
}
