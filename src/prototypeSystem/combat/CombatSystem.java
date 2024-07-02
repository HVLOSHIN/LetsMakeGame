package prototypeSystem.combat;

import prototypeSystem.character.Enemy;
import prototypeSystem.character.Player;

import java.util.Random;

public class CombatSystem {
    Random rand = new Random();

    String playerName;
    int playerHealth;
    int playerCurrentHealth;
    int playerAttack;
    int playerMagicAttack;
    int playerDefense;
    int playerMagicDefense;
    int playerCritical;
    int playerDodge;
    int playerAccuracy;
    int playerAttackSpeed;

    String enemyName;
    int enemyHealth;
    int enemyCurrentHealth;
    int enemyAttack;
    int enemyMagicAttack;
    int enemyDefense;
    int enemyMagicDefense;
    int enemyCritical;
    int enemyDodge;
    int enemyAccuracy;
    int enemyAttackSpeed;


    public void startCombat(Player player, Enemy enemy) {
        System.out.println(enemy.getName() + "과 전투를 시작합니다.");
        getCombatStatus(player, enemy);


        int count = 1;
        while (true) {
            System.out.println("=====================================================");
            System.out.println(count + "턴");
            // if(playerAttackSpeed >= enemyAttackSpeed){  //공격속도 추가 예정

            //크리티컬, 회피율 적용 예정

            System.out.println(playerName + ", 체력 : " + playerCurrentHealth + "/" + playerHealth);
            int currentAttack1 = playerAttack + (int) (additionalDamage() * playerAttack * 0.01) - enemyDefense;
            if (currentAttack1 < 1){
                currentAttack1 = 1;
            }

            System.out.print(playerName + "의 공격 : "); //playerAttack 에 디폴트 스킬 장착예정
            if (playerHitChance()) {
                System.out.println(enemyName + ", 공격을 회피했다.");
            } else {
                System.out.println(currentAttack1 + "의 피해를 입혔다.");
                enemyCurrentHealth -= currentAttack1;
            }


            System.out.println("                              " + enemyName + ", 체력 : " + enemyCurrentHealth + "/" + enemyHealth);
            if (enemyCurrentHealth <= -0) {
                System.out.println("적 사망. \n" + enemy.getGiveEXP() + " 경험치 획득");
                //아이템 드랍 추가예정
                goldChance(player,enemy);
                player.setCurrentEXP(player.getCurrentEXP() + enemy.getGiveEXP());
                player.setKillCount(player.getKillCount() + 1);
                break;
                //  }

            }

            int currentAttack2 = enemyAttack + (int) (additionalDamage() * enemyAttack * 0.01) - playerDefense;
            if (currentAttack2 < 1){
                currentAttack2 = 1;
            }
            System.out.print("                              " + enemyName + "의 공격 : ");
            if (enemyHitChance()) {
                System.out.println(playerName + ", 공격을 회피했다.");
            }
            else {
                System.out.println(currentAttack2 + "의 피해를 입혔다.");
                playerCurrentHealth -= currentAttack2;
            }
            System.out.println(playerName + ", 체력 : " + playerCurrentHealth + "/" + playerHealth);
            if (playerCurrentHealth <= -0) {
                System.out.println("당신은 사망하였습니다. 경험치의 일부를 잃어버립니다.");
                player.setDeathCount(player.getDeathCount()+1);
                player.setCurrentEXP(player.getCurrentEXP() / 4);
                break;
            }
            System.out.println(count + "턴 종료");
            count++;
            if(count == 15){
                System.out.println("전투가 너무 오래 지속되어 무승부로 끝납니다.");
                return;
            }
        }


    }

    public void getCombatStatus(Player player, Enemy enemy) {

        playerName = player.getName();
        playerHealth = player.getMaxHealth() + player.getAddHP();
        playerCurrentHealth = playerHealth;
        playerAttack = ((player.getStrengthAbility() + player.getAddSTR()) * 3) + (player.getDexterityAbility()+ player.getAddDEX());
        playerMagicAttack = ((player.getIntelligenceAbility() + player.getAddINT()) * 3);
        playerDefense = ((player.getStrengthAbility() + player.getAddSTR()) * 2);
        playerMagicDefense = ((player.getIntelligenceAbility() + player.getAddINT()) * 2);

        playerCritical = (player.getDexterityAbility()+ player.getAddDEX());
        playerDodge = (player.getDexterityAbility()+ player.getAddDEX());
        playerAttackSpeed = (player.getDexterityAbility()+ player.getAddDEX());


        if (player.getStrengthAbility() + player.getAddSTR() > player.getDexterityAbility() + player.getAddDEX() && player.getStrengthAbility() + player.getAddSTR() > player.getIntelligenceAbility() + player.getAddINT()) {
            playerAccuracy = player.getStrengthAbility() + player.getAddSTR();
        } else if (player.getDexterityAbility() + player.getAddDEX()> player.getIntelligenceAbility() + player.getAddINT()) {
            playerAccuracy = player.getDexterityAbility()+ player.getAddDEX();
        } else {
            playerAccuracy = player.getIntelligenceAbility() + player.getAddINT();
        }

        {
            enemyName = enemy.getName();
            enemyHealth = enemy.getMaxHealth();
            enemyCurrentHealth = enemyHealth;

            enemyAttack = (enemy.getStrengthAbility() * 3) + enemy.getDexterityAbility();
            enemyMagicAttack = enemy.getIntelligenceAbility() * 3;
            enemyDefense = enemy.getStrengthAbility() * 2;
            enemyMagicDefense = enemy.getIntelligenceAbility() * 2;

            enemyCritical = enemy.getDexterityAbility();
            enemyDodge = enemy.getDexterityAbility();
            enemyAttackSpeed = enemy.getDexterityAbility();

            if (enemy.getStrengthAbility() > enemy.getDexterityAbility() && enemy.getStrengthAbility() > enemy.getStrengthAbility()) {
                enemyAccuracy = enemy.getStrengthAbility();
            } else if (enemy.getDexterityAbility() > enemy.getIntelligenceAbility()) {
                enemyAccuracy = enemy.getDexterityAbility();
            } else {
                enemyAccuracy = enemy.getIntelligenceAbility();
            }
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
        int chance = random + playerAccuracy - enemyDodge;
        if (chance >= 40) {
            return false;
        } else {
            return true;
        }
    }

    public boolean enemyHitChance() {
        int random = rand.nextInt(100);
        int chance = random + playerDodge - enemyAccuracy;
        if (chance >= 40) {
            return false;
        } else {
            return true;
        }

    }
    public void goldChance(Player player,Enemy enemy){
        int random = rand.nextInt(100);
        if (random >= 50) {
            System.out.println(enemy.getGiveMoney() + " 골드를 얻었다.");
            player.setMoney(player.getMoney() + enemy.getGiveMoney());
        }
    }
}
