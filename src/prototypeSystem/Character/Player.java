package prototypeSystem.Character;

public class Player {
    private int id;
    private String name;
    private int level;
    private int maxHealth;
    private int currentHealth;
    private int maxEXP;
    private int currentEXP;

    private int strengthAbility;
    private int dexterityAbility;

/*
    private int attackAbility;
    private int defenseAbility;
    private int accuracyAbility;
    private int dodgeAbility;
*/

    public Player(int id, String name, int level, int maxHealth, int currentHealth, int maxEXP, int currentEXP, int strengthAbility, int dexterityAbility) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.maxEXP = maxEXP;
        this.currentEXP = currentEXP;
        this.strengthAbility = strengthAbility;
        this.dexterityAbility = dexterityAbility;
    }

    public Player(String name) {
        this.id = 1;
        this.name = name;
        this.level = 1;
        this.maxHealth = 100;
        this.currentHealth = maxHealth;
        this.maxEXP = 100;
        this.currentEXP = 0;
        this.strengthAbility = 10;
        this.dexterityAbility = 10;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getId() {
        return id;
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

    public int getMaxEXP() {
        return maxEXP;
    }
    public void setMaxEXP(int maxEXP) {
        this.maxEXP = maxEXP;
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

    public void playerGetCombatStatus(Player player){
        player.name = this.name;
        player.level = this.level;
        player.maxHealth = this.maxHealth;
        player.currentHealth = this.currentHealth;
        player.maxEXP = this.maxEXP;
        player.currentEXP = this.currentEXP;
        player.strengthAbility = this.strengthAbility;
        player.dexterityAbility = this.dexterityAbility;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", maxHealth=" + maxHealth +
                ", currentHealth=" + currentHealth +
                ", maxEXP=" + maxEXP +
                ", currentEXP=" + currentEXP +
                ", strengthAbility=" + strengthAbility +
                ", dexterityAbility=" + dexterityAbility +
                '}';
    }
}

