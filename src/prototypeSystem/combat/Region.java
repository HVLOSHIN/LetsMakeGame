package prototypeSystem.combat;

public class Region {

    String name;
    int regionNum;
    int minLV;
    int maxLV;


    public Region(String name, int regionNum, int minLV, int maxLV) {
        this.name = name;
        this.regionNum = regionNum;
        this.minLV = minLV;
        this.maxLV = maxLV;
    }

    @Override
    public String toString() {
        return "지역" + regionNum + " : " + name + " / 권장 레벨 : " + minLV + " ~ " + maxLV;
    }

    public String getName() {
        return name;
    }
}
