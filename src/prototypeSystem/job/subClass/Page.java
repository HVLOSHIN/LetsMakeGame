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
        setJobMaxEXP(30); //테스트용
        setActiveName("강타I");
        setPassiveName("집중I");
        setPassiveDescription("훈련을 통해 어떤 순간에도 흐트러지지 않는다.");

        if(activeON == 1) {
            activeSkill();
        }
        if (passiveON == 1) {
            passiveSkill();
        }
        if(getJobMain() == 1 && getJobMaxEXP() == getJobEXP()){
            System.out.println("현재 직업 마스터. 새로운 클래스 '수련기사' 해금됩니다.");
            //
        }

    }


    @Override
    public void activeSkill() {
        setIsActiveMelee(1);
        setAddDamage(getAddDamage() + 1);
        setMultDamage(getMultDamage() * 1.3);
        setAddMagicDamage(getAddMagicDamage() + 0);
        setMultMagicDamage(getMultMagicDamage() * 1);
    }

    @Override
    public void passiveSkill() {
        setAddSTR(getAddSTR() + 3);
        setAddDEX(getAddDEX() + 0);
        setAddINT(getAddINT() + 0);
        setAddHP(getAddHP() + 10);
        setMultHP(getMultHP() * 1.2);
    }

    @Override
    public void activeDescription() {
        System.out.println(getActiveName() + " : " + "적을 강하게 내리친다.");
    }

    @Override
    public void passiveDescription() {
        System.out.println(getPassiveName() + " : " + getPassiveDescription() + " 근력 3 증가, 체력 20% 증가");
    }
}
