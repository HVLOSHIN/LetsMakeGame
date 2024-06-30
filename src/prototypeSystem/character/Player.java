package prototypeSystem.character;

public class Player {
    private int id;
    private String name;
    private int level;
    private int maxHealth;
    private int currentHealth;
    private int currentEXP;
    private int usedExp;
    private int strengthAbility;
    private int dexterityAbility;
    private int intelligenceAbility;
    private int mapUnlock;
    private int money;
    private int killCount;
        int maxEXP;

    public Player(int id, String name, int level, int maxHealth, int currentHealth,  int currentEXP, int strengthAbility, int dexterityAbility, int intelligenceAbility,int usedExp, int mapUnlock, int money, int killCount) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.currentEXP = currentEXP;
        this.strengthAbility = strengthAbility;
        this.dexterityAbility = dexterityAbility;
        this.intelligenceAbility = intelligenceAbility;
        this.usedExp = usedExp;
        this.mapUnlock = mapUnlock;
        this.money = money;
        this.killCount = killCount;
    }

    public Player(String name) {
        this.id = 1;
        this.name = name;
        this.level = 1;
        this.maxHealth = 30;
        this.currentHealth = maxHealth;
        this.maxEXP = level*15;       //레벨업 필요 경험치 (엘든링 식)
        this.currentEXP = 50;
        this.strengthAbility = 1;
        this.dexterityAbility = 1;
        this.intelligenceAbility = 1;
        this.usedExp = 0;
        this.mapUnlock = 0;
        this.money = 0;


    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
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

    public int getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    public int getCurrentHealth() {
        return currentHealth;
    }
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
    public int getCurrentEXP() {
        return currentEXP;
    }
    public void setCurrentEXP(int currentEXP) {
        this.currentEXP = currentEXP;
    }
    public int getStrengthAbility() {
        return strengthAbility;
    }
    public void setStrengthAbility(int strengthAbility) {
        this.strengthAbility = strengthAbility;
    }
    public int getDexterityAbility() {
        return dexterityAbility;
    }
    public void setDexterityAbility(int dexterityAbility) {
        this.dexterityAbility = dexterityAbility;
    }

    public int getIntelligenceAbility() {
        return intelligenceAbility;
    }

    public void setIntelligenceAbility(int intelligenceAbility) {
        this.intelligenceAbility = intelligenceAbility;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", maxHealth=" + maxHealth +
                ", currentHealth=" + currentHealth +
                ", currentEXP=" + currentEXP +
                ", usedExp=" + usedExp +
                ", strengthAbility=" + strengthAbility +
                ", dexterityAbility=" + dexterityAbility +
                ", intelligenceAbility=" + intelligenceAbility +
                '}';
    }
}

