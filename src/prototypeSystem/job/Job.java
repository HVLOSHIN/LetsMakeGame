package prototypeSystem.job;

public abstract class Job {

    private String jobName;
    private int jobON;
    private int jobMaxEXP;
    private int jobEXP;

    private String activeName;
    private int activeON;
    private String passiveName;
    private int passiveON;

    private int unLock;

    private int addDamage;
    private int multDamage;
    private int addMagicDamage;
    private int multMagicDamage;
    private int addSTR;
    private int addDEX;
    private int addINT;
    private int addHP;



    public abstract void activeSkill();
    public abstract void passiveSkill();


    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getJobON() {
        return jobON;
    }

    public void setJobON(int jobON) {
        this.jobON = jobON;
    }

    public int getJobMaxEXP() {
        return jobMaxEXP;
    }

    public void setJobMaxEXP(int jobMaxEXP) {
        this.jobMaxEXP = jobMaxEXP;
    }

    public int getJobEXP() {
        return jobEXP;
    }

    public void setJobEXP(int jobEXP) {
        this.jobEXP = jobEXP;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    public int getActiveON() {
        return activeON;
    }

    public void setActiveON(int activeON) {
        this.activeON = activeON;
    }

    public String getPassiveName() {
        return passiveName;
    }

    public void setPassiveName(String passiveName) {
        this.passiveName = passiveName;
    }

    public int getPassiveON() {
        return passiveON;
    }

    public void setPassiveON(int passiveON) {
        this.passiveON = passiveON;
    }

    public int getUnLock() {
        return unLock;
    }

    public void setUnLock(int unLock) {
        this.unLock = unLock;
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

}
