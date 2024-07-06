package prototypeSystem.job.subClass;

import prototypeSystem.job.Job;

public class Thief extends Job {
    public Thief(int ID,int jobMain, int jobHave, int jobEXP, int activeON, int passiveON, int unLock, int master) {
        super(ID,jobMain, jobHave,jobEXP,activeON,passiveON,unLock,master);
        setJobMain(jobMain);
        setJobHave(jobHave);
        setJobEXP(jobEXP);
        setActiveON(activeON);
        setPassiveON(passiveON);
        setUnLock(unLock);

        setJobName("좀도둑");
        setJobMaxEXP(3000);
        setActiveName("뒤통수치기");
        setPassiveName("현란한 손재주");
        setPassiveDescription("말보다 주먹이 빠른 법");

        if(activeON == 1) {
            activeSkill();
        }
        if (passiveON == 1) {
            passiveSkill();
        }

    }

    @Override
    public void activeSkill() {
        setIsActiveMelee(1);
        setAddDamage(5);
        setMultDamage(1);
        setAddMagicDamage(0);
        setMultMagicDamage(1);
    }

    @Override
    public void passiveSkill() {
        setAddSTR(getAddSTR() + 0);
        setAddDEX(getAddDEX() + 4);
        setAddINT(getAddINT() + 0);
        setAddHP(getAddHP() + 0);
        setMultHP(getMultHP() + 0);
    }

    @Override
    public void activeDescription() {
        System.out.println(getActiveName() + " : " + "뒤통수를 후린다.");
    }

    @Override
    public void passiveDescription() {
        System.out.println(getPassiveName() + " : " + getPassiveDescription() + " 기교 4 증가");
    }
}
