package prototypeSystem.combat;

public class Region {

    String regionName;
    int regionNum;
    int recommendLvMin;
    int recommendLvMax;


    public Region(String regionName, int regionNum, int recommendLvMin, int recommendLvMax) {
        this.regionName = regionName;
        this.regionNum = regionNum;
        this.recommendLvMin = recommendLvMin;
        this.recommendLvMax = recommendLvMax;
    }

    @Override
    public String toString() {
        return "지역" + regionNum + " : " + regionName + " / 권장 레벨 : " + recommendLvMin + " ~ " + recommendLvMax;
    }

    public String getRegionName() {
        return regionName;
    }
}
