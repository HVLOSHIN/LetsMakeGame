package prototypeSystem.combat;

import prototypeSystem.character.Enemy;
import prototypeSystem.character.Player;

import java.util.Random;
import java.util.Scanner;


public class Generator {
    Scanner scanner = new Scanner(System.in);
    CombatSystem combatSystem = new CombatSystem();
    Random rand = new Random();


    public void enemyGenerate(int stageChoice, Player player) {
        Enemy[] enemyNum = new Enemy[100];
        enemyNum[0] = null;

        enemyNum[1] = new Enemy("Enemy1", 1, 10, 10, 1, 1, 1, 1);
        enemyNum[2] = new Enemy("Enemy2", 4, 20, 20, 2, 3, 3, 1);
        enemyNum[3] = new Enemy("Enemy3", 7, 30, 30, 3, 5, 5, 3);
        enemyNum[4] = new Enemy("Enemy4", 10, 40, 40, 4, 7, 5, 3);
        enemyNum[5] = new Enemy("Enemy5", 13, 50, 50, 5, 10, 10, 3);

        enemyNum[6] = new Enemy("Enemy6", 16, 60, 60, 6, 15, 15, 5);
        enemyNum[7] = new Enemy("Enemy7", 19, 70, 70, 7, 17, 17, 6);
        enemyNum[8] = new Enemy("Enemy8", 22, 80, 80, 8, 18, 18, 10);
        enemyNum[9] = new Enemy("Enemy8", 25, 90, 90, 9, 20, 20, 12);
        enemyNum[10] = new Enemy("Enemy9", 28, 100, 100, 10, 22, 22, 15);


        Enemy[] boss = new Enemy[10];
        boss[0] = null;
        boss[1] = new Enemy("Boss1", 15, 100, 300, 100, 10, 10, 10, 1);
        boss[2] = new Enemy("Boss2", 30, 200, 1000, 300, 22, 22, 20, 1);


// 지역별로 드랍되는 아이템 추가 예정


        choiceEnemy(player, stageChoice, enemyNum, boss);
    }

    public void regionGenerate(Player player) {
        int mapUnlock = player.getMapUnlock();
        Region[] regionNum = new Region[10];
        regionNum[0] = null;
        regionNum[1] = new Region("초원", 1, 1, 15);
        regionNum[2] = new Region("region2", 2, 16, 30);
        regionNum[3] = new Region("region3", 3, 31, 45);
        regionNum[4] = new Region("region4", 4, 46, 60);
        regionNum[5] = new Region("region5", 5, 61, 75);
        //TODO 지역 추가


        //해금도에 따른 지역 보여주기
        for (int i = 1; i <= mapUnlock; i++) {
            System.out.println(regionNum[i]);
        }


        System.out.println("이동할 지역 선택  (0누를시 뒤로 이동)");
        int stageChoice = scanner.nextInt();
        if (stageChoice == 0) {
            return;
        }
        if (stageChoice > mapUnlock) {
            System.out.println("이 지역은 아직 해금되지 않았습니다.");
        } else if (0 < stageChoice && stageChoice < regionNum.length) {
            System.out.println(regionNum[stageChoice].getName() + "으로 이동합니다.");
            enemyGenerate(stageChoice, player);
        }
    }


    public void choiceEnemy(Player player, int stageChoice, Enemy[] enemyNum, Enemy[] boss) {

        System.out.println("전투 상대 선택 (0누를시 뒤로 이동)");
        //적 디스플레이
        for (int x = stageChoice; x < stageChoice + 5; x++) {
            System.out.println(enemyNum[x]);
        }

        int enemyChoice = scanner.nextInt();
        {
            if (enemyChoice == 0) {
                return;
            } else if (0 < enemyChoice && enemyChoice <= 5) {

                System.out.print("전투 횟수 입력 (1 ~ 10까지 가능) : ");
                int combatCount = scanner.nextInt();
                //반복 전투 정의
                if (2 <= combatCount && combatCount <= 10) {
                    shortCombat(player, enemyNum, boss, combatCount, enemyChoice, stageChoice);
                } else if (combatCount == 1) {
                    longCombat(player, enemyNum, boss, enemyChoice, stageChoice);
                } else {
                    System.out.println("올바른 입력이 아닙니다.");
                }

            }
        }


    }

    public void shortCombat(Player player, Enemy[] enemyNum, Enemy[] boss, int combatCount, int enemyChoice, int stageChoice) {
        for (int j = 0; j < combatCount; j++) {
            //보스전 정의
            if (enemyChoice == 5) {
                int random = rand.nextInt(100);
                //보스전
                if (random > 70) {
                    System.out.print("전투 " + (j + 1) + " : ");
                    combatSystem.startShortCombat(player, boss[stageChoice], stageChoice);
                }
                //일반전
                else if (random <= 70) {
                    System.out.print("전투 " + (j + 1) + " : ");
                    combatSystem.startShortCombat(player, enemyNum[(enemyChoice + (5 * stageChoice)) - 5], stageChoice);
                }
                // 1~4몹
            } else if (enemyChoice < 5) {
                combatSystem.startShortCombat(player, enemyNum[(enemyChoice + (5 * stageChoice)) - 5], stageChoice);
            }

        }


    }

    public void longCombat(Player player, Enemy[] enemyNum, Enemy[] boss, int enemyChoice, int stageChoice) {

        if (enemyChoice == 5) {
            int random = rand.nextInt(100);
            if (random > 70) {
                combatSystem.startCombat(player, boss[stageChoice], stageChoice);
            }

        }
        combatSystem.startCombat(player, enemyNum[(enemyChoice + (5 * stageChoice)) - 5], stageChoice);

    }

}


