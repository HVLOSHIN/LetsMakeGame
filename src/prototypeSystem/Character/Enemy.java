package prototypeSystem.Character;

public class Enemy {
        private String name;
        private int level;
        private int maxHealth;
        private int currentHealth;
        private int giveEXP;

        private int strengthAbility;
        private int dexterityAbility;




/*
        private int attackAbility;
        private int defenseAbility;
        private int accuracyAbility;
        private int dodgeAbility;
*/

    public Enemy(String name, int level, int maxHealth, int giveEXP, int strengthAbility, int dexterityAbility) {
        this.name = name;
        this.level = level;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.giveEXP = giveEXP;
        this.strengthAbility = strengthAbility;
        this.dexterityAbility = dexterityAbility;
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

        public void EnemyGetCombatStatus(Enemy enemy){
            enemy.name = this.name;
            enemy.level = this.level;
            enemy.maxHealth = this.maxHealth;
            enemy.currentHealth = this.currentHealth;
            enemy.giveEXP = this.giveEXP;
            enemy.strengthAbility = this.strengthAbility;
            enemy.dexterityAbility = this.dexterityAbility;
        }

   @Override
    public String toString() {
        return
                "이름 : " + name +
                ", 레벨 : " + level +
                ", 체력 : " + maxHealth +
                ", 힘 : " + strengthAbility +
                ", 민첩 : " + dexterityAbility;
    }
}
