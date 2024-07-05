package prototypeSystem.job.subClass;

import prototypeSystem.job.Job;

public class Page extends Job {

    public Page(int ID,int jobMain, int jobHave, int jobEXP, int activeON, int passiveON, int unLock,int master) {
        super(ID,jobMain, jobHave,jobEXP,activeON,passiveON,unLock,master);
        setJobMain(jobMain);
        setJobHave(jobHave);
        setJobEXP(jobEXP);
        setActiveON(activeON);
        setPassiveON(passiveON);
        setUnLock(unLock);

        setJobName("소년기사");
        setJobMaxEXP(3000);
        setActiveName("강타I");
        setPassiveName("집중I");
        setPassiveDescription("훈련을 통해 어떤 순간에도 흐트러지지 않는다.");

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
        setAddSTR(3);
        setAddDEX(0);
        setAddINT(0);
        setAddHP(40);
    }

    @Override
    public void activeDescription() {
        System.out.println(getActiveName() + " : " + "적을 강하게 내리친다.");
    }

    @Override
    public void passiveDescription() {
        System.out.println(getPassiveName() + " : " + getPassiveDescription() + "근력 5 증가");
    }
}
