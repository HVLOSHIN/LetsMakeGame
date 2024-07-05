package prototypeSystem.job.subClass;

import prototypeSystem.character.Player;
import prototypeSystem.job.Job;

public class Page extends Job {

    public Page(int jobON, int jobEXP, int activeON, int passiveON, int unLock) {
        setJobON(jobON);
        setJobEXP(jobEXP);
        setActiveON(activeON);
        setPassiveON(passiveON);
        setUnLock(unLock);

        setJobName("소년기사");
        setJobMaxEXP(1000);
        setActiveName("강타I");
        setPassiveName("집중I");
    }


    @Override
    public void activeSkill() {
        System.out.println(getActiveName());
        setAddDamage(5);
        setMultDamage(1);
        setAddMagicDamage(0);
        setMultMagicDamage(1);
    }

    @Override
    public void passiveSkill() {
        System.out.println(getPassiveName());
        System.out.println("매 순간 정신을 집중해 어떤 순간에도 흐트러지지 않는다.");
        setAddSTR(3);
        setAddDEX(3);
        setAddINT(0);
        setAddHP(0);
    }

}
