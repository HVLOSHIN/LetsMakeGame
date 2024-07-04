package prototypeSystem.combat;

import prototypeSystem.character.Enemy;
import prototypeSystem.character.Player;
import prototypeSystem.item.Armor;
import prototypeSystem.item.Weapon;

import java.util.Random;

public class CombatSystem {
    Random rand = new Random();
    //player
    private String Name;
    private int MaxHP;
    private int currentHP;
    private int attack;
    private int magicAttack;
    private int defense;
    private int magicDefense;
    private int critical;
    private int dodge;
    private int accuracy;
    private int attackSpeed;
    private int STR;
    private int DEX;
    private int INT;
    //enemy
    private String eName;
    private int eMaxHP;
    private int eCurrentHP;
    private int eAttack;
    private int eMagicAttack;
    private int eDefense;
    private int eMagicDefense;
    private int eCritical;
    private int eDodge;
    private int eAccuracy;
    private int eAttackSpeed;


    public void startCombat(Player player, Enemy enemy, int stageChoice) {
    if(enemy.getBoss() == 1){
        System.out.println("========================보스전=======================");
    }
        System.out.println(enemy.getName() + "과 전투를 시작합니다.");
        getCombatStatus(player, enemy);


        int count = 1;
        while (true) {
            System.out.println("=====================================================");
            System.out.println(count + "턴");
            // if(playerAttackSpeed >= enemyAttackSpeed){  //공격속도 추가 예정

            //크리티컬 적용 예정

            System.out.println(Name + ", 체력 : " + currentHP + "/" + MaxHP);
            int currentAttack1 = attack + (int) (additionalDamage() * attack * 0.01) - eDefense;
            if (currentAttack1 < 1) {
                currentAttack1 = 1;
            }

            System.out.print(Name + "의 공격 : "); //playerAttack 에 디폴트 스킬 장착예정
            if (playerHitChance()) {
                System.out.println(eName + ", 공격을 회피했다.");
            } else {
                System.out.println(currentAttack1 + "의 피해를 입혔다.");
                eCurrentHP -= currentAttack1;
            }


            System.out.println("                              " + eName + ", 체력 : " + eCurrentHP + "/" + eMaxHP);
            if (eCurrentHP <= -0) {


                System.out.println("적 사망. \n" + enemy.getEXP() + " 경험치 획득");

                if(enemy.getBoss()==1 && player.getMapUnlock()== stageChoice){
                    System.out.println("보스처치.. 다음지역이 해금됩니다..");
                    System.out.println("상점에 새로운 물건들이 보급됩니다.");
                    player.setMapUnlock(2);
                }

                //아이템 드랍 추가예정
                goldChance(player, enemy);
                player.setCurrentEXP(player.getCurrentEXP() + enemy.getEXP());
                player.setKillCount(player.getKillCount() + 1);
                break;

            }

            int currentAttack2 = eAttack + (int) (additionalDamage() * eAttack * 0.01) - defense;
            if (currentAttack2 < 1) {
                currentAttack2 = 1;
            }
            System.out.print("                              " + eName + "의 공격 : ");
            if (enemyHitChance()) {
                System.out.println(Name + ", 공격을 회피했다.");
            } else {
                System.out.println(currentAttack2 + "의 피해를 입혔다.");
                currentHP -= currentAttack2;
            }
            System.out.println(Name + ", 체력 : " + currentHP + "/" + MaxHP);
            if (currentHP <= -0) {
                System.out.println("당신은 사망하였습니다. 경험치의 일부를 잃어버립니다.");
                player.setDeathCount(player.getDeathCount() + 1);
                player.setCurrentEXP(player.getCurrentEXP() / 4);
                break;
            }
            System.out.println(count + "턴 종료");
            count++;
            if (count == 15) {
                System.out.println("전투가 너무 오래 지속되어 무승부로 끝납니다.");
                return;
            }
        }


    }

    public void startShortCombat(Player player, Enemy enemy, int stageChoice) {
        getCombatStatus(player, enemy);
        int count = 1;
        while (true) {
            int currentAttack1 = attack + (int) (additionalDamage() * attack * 0.01) - eDefense;
            if (currentAttack1 < 1) {
                currentAttack1 = 1;
            }
            if (playerHitChance()) {
               // System.out.println(eName + ", 공격을 회피했다.");
            } else {
                eCurrentHP -= currentAttack1;
            }
            if (eCurrentHP <= -0) {

                System.out.print("적 사망.                 " + enemy.getEXP() + " 경험치 획득");
                if(enemy.getBoss()==1 && player.getMapUnlock()== stageChoice){
                    System.out.print("             보스처치.. 다음지역이 해금됩니다..");
                    player.setMapUnlock(1);
                }

                shortGoldChance(player, enemy);
                player.setCurrentEXP(player.getCurrentEXP() + enemy.getEXP());
                player.setKillCount(player.getKillCount() + 1);
                System.out.println();
                break;
            }

            int currentAttack2 = eAttack + (int) (additionalDamage() * eAttack * 0.01) - defense;
            if (currentAttack2 < 1) {
                currentAttack2 = 1;
            }
            if (enemyHitChance()) {
              //  System.out.println(Name + ", 공격을 회피했다.");
            } else {
                currentHP -= currentAttack2;
            }
            if (currentHP <= -0) {
                System.out.println("당신은 사망하였습니다. 경험치의 일부를 잃어버립니다.");
                player.setDeathCount(player.getDeathCount() + 1);
                player.setCurrentEXP(player.getCurrentEXP() / 4);
                break;
            }
         //   System.out.println(count + "턴 종료");
            count++;
            if (count == 15) {
                System.out.println("전투가 너무 오래 지속되어 무승부로 끝납니다.");
                return;
            }
        }


    }

    public void getCombatStatus(Player player, Enemy enemy) {
        //player
        getPlayerCombatStatus(player);

        //enemy
        getEnemyCombatStatus(enemy);


    }

    public void getPlayerCombatStatus(Player player) {
        //player

        STR = player.getSTR() + player.getAddSTR();
        DEX = player.getDEX() + player.getAddDEX();
        INT = player.getINT() + player.getAddINT();
        Name = player.getName();
        MaxHP = player.getMaxHP() + player.getAddHP();
        currentHP = MaxHP;
        attack = (STR * 3) + DEX;
        magicAttack = INT * 3;
        defense = STR * 2;
        magicDefense = INT * 2;

        critical = DEX;
        dodge = DEX;
        attackSpeed = DEX;

        if (STR > DEX && STR > INT) {
            accuracy = STR;
        } else if (DEX > INT) {
            accuracy = DEX;
        } else {
            accuracy = INT;
        }


    }

    public void getEnemyCombatStatus(Enemy enemy){
        eName = enemy.getName();
        eMaxHP = enemy.getMaxHP();
        eCurrentHP = eMaxHP;

        eAttack = (enemy.getSTR() * 3) + enemy.getDEX();
        eMagicAttack = enemy.getINT() * 3;
        eDefense = enemy.getSTR() * 2;
        eMagicDefense = enemy.getINT() * 2;

        eCritical = enemy.getDEX();
        eDodge = enemy.getDEX();
        eAttackSpeed = enemy.getDEX();

        if (enemy.getSTR() > enemy.getDEX() && enemy.getSTR() > enemy.getSTR()) {
            eAccuracy = enemy.getSTR();
        } else if (enemy.getDEX() > enemy.getINT()) {
            eAccuracy = enemy.getDEX();
        } else {
            eAccuracy = enemy.getINT();
        }
    }

    public int additionalDamage() {
        int additionalDamage = 0;
        int randomValue1 = rand.nextInt(2);  // 난수가 음수일지, 양수일지를 선택해주는 메서드
        int randomValue2 = rand.nextInt(40); // 추가데미지 난수
        if (randomValue1 == 0) {
            additionalDamage = (randomValue2 * -1);
        } else {
            additionalDamage = randomValue2;
        }
        return additionalDamage;
    }

    public boolean playerHitChance() {
        int random = rand.nextInt(100);
        int chance = random + accuracy - eDodge;
        if (chance >= 40) {
            return false;
        } else {
            return true;
        }
    }

    public boolean enemyHitChance() {
        int random = rand.nextInt(100);
        int chance = random + dodge - eAccuracy;
        if (chance >= 40) {
            return false;
        } else {
            return true;
        }

    }

    public void goldChance(Player player, Enemy enemy) {
        int random = rand.nextInt(100);
        if (random >= 50) {
            System.out.println(enemy.getMoney() + " 골드를 얻었다.");
            player.setGold(player.getGold() + enemy.getMoney());
        }
    }

    public void shortGoldChance(Player player, Enemy enemy) {
        int random = rand.nextInt(100);
        if (random >= 50) {
            System.out.print("            " + enemy.getMoney() + " 골드를 얻었다.");
            player.setGold(player.getGold() + enemy.getMoney());
        }
    }

    public void displayPlayerCombatStatus(Player player) {
        getPlayerCombatStatus(player);
        System.out.println("===========================");
        System.out.println("레벨 : " + player.getLevel());
        System.out.print("체력 : " + MaxHP + " (+" + player.getAddHP() + ")");
        System.out.println("  | 근력 : " + STR + " (+" + player.getAddSTR() + ")");
        System.out.print("기교 : " + DEX + " (+" + player.getAddDEX() + ")");
        System.out.println("  | 지력 : " + INT + " (+" + player.getAddINT() + ")");
        System.out.println();
        System.out.print("공격력 : " + attack);
        System.out.println("  | 마법공격력 : " + magicAttack);
        System.out.print("방어력 : " + defense);
        System.out.println("  | 마법방어력 : " + magicDefense);
        System.out.print("회피율 : " + dodge);
        System.out.println("  | 명중률 : " + accuracy);
        System.out.println("치명타 확률 :" + critical);
        System.out.println();
        System.out.println("레벨업 필요 경험치 : " + (player.getLevel()*player.getLevel()*3));
        System.out.println("현재 경험치 : " + player.getCurrentEXP());
        System.out.println("현재 보유 금화 : " + player.getGold());

        System.out.println("===========================");
    }
}
