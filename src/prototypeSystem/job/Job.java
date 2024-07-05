package prototypeSystem.job;

public  class Job {
    private int ID;
    private String jobName;
    private int jobMain;
    private int jobHave;
    private int jobMaxEXP;
    private int jobEXP;

    private String activeName;
    private int activeON;
    private String passiveName;
    private String passiveDescription;
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



    public  void activeSkill(){}
    public  void passiveSkill(){}
    public  void activeDescription(){}
    public  void passiveDescription(){}

    public Job(int ID, int jobMain, int jobHave, int jobEXP, int activeON, int passiveON, int unLock) {
        this.ID = ID;
        this.jobMain = jobMain;
        this.jobHave = jobHave;
        this.jobEXP = jobEXP;
        this.activeON = activeON;
        this.passiveON = passiveON;
        this.unLock = unLock;
    }

    public int getJobMain() {
        return jobMain;
    }

    public void setJobMain(int jobMain) {
        this.jobMain = jobMain;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getJobHave() {
        return jobHave;
    }

    public void setJobHave(int jobHave) {
        this.jobHave = jobHave;
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

    public String getPassiveDescription() {
        return passiveDescription;
    }

    public void setPassiveDescription(String passiveDescription) {
        this.passiveDescription = passiveDescription;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
