package prototypeSystem.job.subClass;

import prototypeSystem.job.Job;

public class Caster extends Job {
    public Caster(int ID,int jobMain, int jobHave, int jobEXP, int activeON, int passiveON, int unLock,int master) {
        super(ID,jobMain, jobHave,jobEXP,activeON,passiveON,unLock,master);

        setJobName("스펠캐스터");
        setJobMaxEXP(3000);
        setActiveName("매직미사일");
        setPassiveName("마나수양");
        setPassiveDescription("더 위대한 마법사가 되기위해 마나와 친해진다.");

        if(activeON == 1) {
            activeSkill();
        }
        if (passiveON == 1) {
            passiveSkill();
        }
    }

    @Override
    public void activeSkill() {
        setIsActiveMelee(0);
        setAddDamage(0);
        setMultDamage(1);
        setAddMagicDamage(5);
        setMultMagicDamage(1);
    }

    @Override
    public void passiveSkill() {
        setAddSTR(0);
        setAddDEX(0);
        setAddINT(5);
        setAddHP(0);
    }

    @Override
    public void activeDescription() {
        System.out.println(getActiveName() + " : " + "마법 미사일을 발사한다.");
    }

    @Override
    public void passiveDescription() {
        System.out.println(getPassiveName() + " : " + getPassiveDescription() + "지력 5증가");
    }

}
