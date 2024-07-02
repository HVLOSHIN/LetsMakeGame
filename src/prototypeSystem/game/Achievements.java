package prototypeSystem.game;

public class Achievements {
    private int achieveID ;
    private int clear;
    private String achieveName;
    private String achieveDesc;

   public Achievements(int achieveID, int clear , String achieveName, String achieveDesc){
        this.achieveID = achieveID;
        this.clear = clear;
        this.achieveName = achieveName;
        this.achieveDesc = achieveDesc;
    }



    public int getAchieveID() {
        return achieveID;
    }

    public void setAchieveID(int achieveID) {
        this.achieveID = achieveID;
    }

    public int getClear() {
        return clear;
    }

    public void setClear(int clear) {
        this.clear = clear;
    }

    public String getAchieveName() {
        return achieveName;
    }

    public void setAchieveName(String achieveName) {
        this.achieveName = achieveName;
    }

    public String getAchieveDesc() {
        return achieveDesc;
    }

    public void setAchieveDesc(String achieveDesc) {
        this.achieveDesc = achieveDesc;
    }
}
