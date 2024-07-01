package prototypeSystem.item.weapon;

public class Weapon {
    private int weaponID;
    private String WeaponName;
    private int WeaponAddDamage;
    private int WeaponMultDamage;
    private int WeaponAddMajicDamage;
    private int WeaponmultMajicDamage;
    private int WeaponAddSTR;
    private int WeaponAddDEX;
    private int WeaponAddINT;
    private int WeaponAddHP;
    private int playerHave;
    private int playerEquip;
    private int WeaponPrice;

    public Weapon(int weaponID, String name, int addDamage, int multDamage, int addMagicDamage, int multMagicDamage,int addSTR, int addDEX, int addINT, int addHP, int weaponPrice) {
        this.weaponID = weaponID;
        this.WeaponName = name;
        this.WeaponAddDamage = addDamage;
        this.WeaponMultDamage = multDamage;
        this.WeaponAddMajicDamage = addMagicDamage;
        this.WeaponmultMajicDamage = multMagicDamage;
        this.WeaponAddSTR = addSTR;
        this.WeaponAddDEX = addDEX;
        this.WeaponAddINT = addINT;
        this.WeaponAddHP = addHP;
        this.WeaponPrice = weaponPrice;
        this.playerHave = 0;
        this.playerEquip = 0;
    }

    public String getWeaponName() {
        return WeaponName;
    }

    public void setWeaponName(String weaponName) {
        WeaponName = weaponName;
    }

    public int getWeaponAddDamage() {
        return WeaponAddDamage;
    }

    public void setWeaponAddDamage(int weaponAddDamage) {
        WeaponAddDamage = weaponAddDamage;
    }

    public int getWeaponMultDamage() {
        return WeaponMultDamage;
    }

    public void setWeaponMultDamage(int weaponMultDamage) {
        WeaponMultDamage = weaponMultDamage;
    }

    public int getWeaponAddSTR() {
        return WeaponAddSTR;
    }

    public void setWeaponAddSTR(int weaponAddSTR) {
        WeaponAddSTR = weaponAddSTR;
    }

    public int getWeaponAddDEX() {
        return WeaponAddDEX;
    }

    public void setWeaponAddDEX(int weaponAddDEX) {
        WeaponAddDEX = weaponAddDEX;
    }

    public int getWeaponAddINT() {
        return WeaponAddINT;
    }

    public void setWeaponAddINT(int weaponAddINT) {
        WeaponAddINT = weaponAddINT;
    }

    public int getWeaponAddHP() {
        return WeaponAddHP;
    }

    public void setWeaponAddHP(int weaponAddHP) {
        WeaponAddHP = weaponAddHP;
    }

    public int getPlayerHave() {
        return playerHave;
    }

    public void setPlayerHave(int playerHave) {
        this.playerHave = playerHave;
    }

    public int getPlayerEquip() {
        return playerEquip;
    }

    public void setPlayerEquip(int playerEquip) {
        this.playerEquip = playerEquip;
    }

    public void getItemInfo(){
        System.out.println(weaponID + ". " + WeaponName + ", 공격력 : " + WeaponAddDamage + ", 공격배율 : x" + WeaponMultDamage);
    }
}
