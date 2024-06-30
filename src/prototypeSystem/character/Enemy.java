package prototypeSystem.character;

public class Enemy {
        private String name;
        private int level;
        private int maxHealth;
        private int currentHealth;
        private int giveEXP;
        private int giveMoney;

        private int strengthAbility;
        private int dexterityAbility;
        private int intelligenceAbility;


    public Enemy(String name, int level, int maxHealth, int giveEXP,int giveMoney, int strengthAbility, int dexterityAbility , int intelligenceAbility) {
        this.name = name;
        this.level = level;
        this.maxHealth = maxHealth;
        this.giveEXP = giveEXP;
        this.giveMoney = giveMoney;
        this.strengthAbility = strengthAbility;
        this.dexterityAbility = dexterityAbility;
        this.intelligenceAbility = intelligenceAbility;
    }


    public String getName() {
        return name;
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



        public void EnemyGetCombatStatus(Enemy enemy){
            enemy.name = this.name;
            enemy.level = this.level;
            enemy.maxHealth = this.maxHealth;
            enemy.currentHealth = this.currentHealth;
            enemy.giveEXP = this.giveEXP;
            enemy.strengthAbility = this.strengthAbility;
            enemy.dexterityAbility = this.dexterityAbility;
        }

    public int getLevel() {
        return level;
    }

    public int getGiveEXP() {
        return giveEXP;
    }

    public int getStrengthAbility() {
        return strengthAbility;
    }

    public int getDexterityAbility() {
        return dexterityAbility;
    }

    public int getIntelligenceAbility() {
        return intelligenceAbility;
    }

    public int getGiveMoney() {
        return giveMoney;
    }

    @Override
    public String toString() {
        return
                "이름 : " + name +
                ", 레벨 : " + level
               + ", 체력 : " + maxHealth ;
              /*
                ", 힘 : " + strengthAbility +
                ", 민첩 : " + dexterityAbility;
                */
    }
}
