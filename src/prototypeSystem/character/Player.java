package prototypeSystem.character;

import prototypeSystem.item.weapon.Weapon;

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
    // 여기까지 기본 스텟
    private int deathCount;


    private int addDamage;
    private int multDamage;
    private int addMagicDamage;
    private int multMagicDamage;
    private int addSTR;
    private int addDEX;
    private int addINT;
    private int addHP;


    public Player(int id, String name, int level, int maxHealth, int currentHealth, int currentEXP, int strengthAbility, int dexterityAbility, int intelligenceAbility, int usedExp, int mapUnlock, int money, int killCount, int deathCount) {
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
        this.deathCount = deathCount;
    }

    public Player(String name) {
        this.id = 1;
        this.name = name;
        this.level = 1;
        this.maxHealth = 30;
        this.currentHealth = maxHealth;
        this.currentEXP = 50;
        this.strengthAbility = 1;
        this.dexterityAbility = 1;
        this.intelligenceAbility = 1;
        this.usedExp = 0;
        this.mapUnlock = 0;
        this.money = 100;
        this.killCount = 0;

    }


    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
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

    public int getMultMagicDamage() {
        return multMagicDamage;
    }

    public void setMultMagicDamage(int multMagicDamage) {
        this.multMagicDamage = multMagicDamage;
    }

    public int getAddMagicDamage() {
        return addMagicDamage;
    }

    public void setAddMagicDamage(int addMagicDamage) {
        this.addMagicDamage = addMagicDamage;
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
                ", maxHealth=" + maxHealth +
                ", currentHealth=" + currentHealth +
                ", currentEXP=" + currentEXP +
                ", usedExp=" + usedExp +
                ", strengthAbility=" + strengthAbility +
                ", dexterityAbility=" + dexterityAbility +
                ", intelligenceAbility=" + intelligenceAbility +
                '}';
    }

    public void showHaveItems(Weapon[] weapon) {
        getPlayerAdditionalStats(weapon);
        for (int i = 1; i < 8; i++) {

            if (weapon[i].getPlayerHave() == 1) {
                displayItems(weapon, i);
            }
        }
        getItemStats();
    }

    public void getPlayerAdditionalStats(Weapon[] weapon) {
        resetItemStats();
        for (int i = 1; i < 8; i++) {
            if (weapon[i].getPlayerHave() == 1) {

                addDamage += weapon[i].getWeaponAddDamage();
                multDamage *= weapon[i].getWeaponMultDamage();
                addMagicDamage += weapon[i].getWeaponAddMajicDamage();
                multMagicDamage *= weapon[i].getWeaponmultMajicDamage();
                addSTR += weapon[i].getWeaponAddSTR();
                addDEX += weapon[i].getWeaponAddDEX();
                addINT += weapon[i].getWeaponAddINT();
                addHP += weapon[i].getWeaponAddHP();
            }
            //방어구 , 직업 보너스도 여기에 연산하면 될듯
        }
    }

    public void resetItemStats() {
        addDamage = 0;
        multDamage = 1;
        addMagicDamage = 0;
        multMagicDamage = 1;
        addSTR = 0;
        addDEX = 0;
        addINT = 0;
        addHP = 0;
    }

    public void displayItems(Weapon[] weapons, int i) {
        System.out.print(i + ". " + weapons[i].getWeaponName() + " - " + "물리공격력 : " + weapons[i].getWeaponAddDamage() + ", 물리배율 : " + weapons[i].getWeaponMultDamage());
        System.out.print(", 마법공격력 : " + weapons[i].getWeaponAddMajicDamage() + ", 마법배율 : " + weapons[i].getWeaponmultMajicDamage() + ", 근력 : " + weapons[i].getWeaponAddSTR());
        System.out.println(", 기교 : " + weapons[i].getWeaponAddDEX() + ", 지력 : " + weapons[i].getWeaponAddINT() + ", 체력 : " + weapons[i].getWeaponAddHP());
    }
    public void getItemStats(){
        System.out.println("====================================");
        System.out.println("효과 (강화, 장비, 직업)");
        System.out.println(name + " : 물리공격력 : " + addDamage + ", 물리배율 : " + multDamage + ", 마법공격력 : " + addMagicDamage + ", 마법배율 : " + multMagicDamage + ", 근력 : " + addSTR + ", 기교 : " + addDEX + ", 지력 : "  + addINT + ", 추가 체력 : " + addHP);

    }

    public void getStatistics(){
        //통계 메서드
        System.out.println("처치한 적 : " + killCount);
        System.out.println("사용한 경험치 : " + usedExp);
        System.out.println("죽은 횟수 : " + deathCount);

        System.out.println("맵 언락 스테이지 : " + (mapUnlock + 1));
        //System.out.println("처치한 가장 강한 적 : " );
    }
}

