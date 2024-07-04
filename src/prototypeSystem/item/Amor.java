package prototypeSystem.item;

public class Amor {
    private int ID;
    private String name;
    private int addDamage;
    private int multDamage;
    private int addMagicDamage;
    private int multMagicDamage;
    private int addSTR;
    private int addDEX;
    private int addINT;
    private int addHP;
    private int have;
    private int price;

    public Amor(int ID, String name, int addDamage, int multDamage, int addMagicDamage, int multMagicDamage, int addSTR, int addDEX, int addINT, int addHP, int have, int price) {
        this.ID = ID;
        this.name = name;
        this.addDamage = addDamage;
        this.multDamage = multDamage;
        this.addMagicDamage = addMagicDamage;
        this.multMagicDamage = multMagicDamage;
        this.addSTR = addSTR;
        this.addDEX = addDEX;
        this.addINT = addINT;
        this.addHP = addHP;
        this.have = have;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAddDamage() {
        return addDamage;
    }

    public void setAddDamage(int addDamage) {
        this.addDamage = addDamage;
    }

    public int getMultDamage() {
        return multDamage;
    }

    public void setMultDamage(int multDamage) {
        this.multDamage = multDamage;
    }

    public int getAddMagicDamage() {
        return addMagicDamage;
    }

    public void setAddMagicDamage(int addMagicDamage) {
        this.addMagicDamage = addMagicDamage;
    }

    public int getMultMagicDamage() {
        return multMagicDamage;
    }

    public void setMultMagicDamage(int multMagicDamage) {
        this.multMagicDamage = multMagicDamage;
    }

    public int getAddSTR() {
        return addSTR;
    }

    public void setAddSTR(int addSTR) {
        this.addSTR = addSTR;
    }

    public int getAddDEX() {
        return addDEX;
    }

    public void setAddDEX(int addDEX) {
        this.addDEX = addDEX;
    }

    public int getAddINT() {
        return addINT;
    }

    public void setAddINT(int addINT) {
        this.addINT = addINT;
    }

    public int getAddHP() {
        return addHP;
    }

    public void setAddHP(int addHP) {
        this.addHP = addHP;
    }

    public int getHave() {
        return have;
    }

    public void setHave(int have) {
        this.have = have;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
