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

        int maxEXP;

    public Player(int id, String name, int level, int maxHealth, int currentHealth,  int currentEXP, int strengthAbility, int dexterityAbility, int intelligenceAbility,int usedExp) {
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
