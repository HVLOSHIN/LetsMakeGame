package prototypeSystem.combat;

import prototypeSystem.character.Enemy;
import prototypeSystem.character.Player;

import java.util.Scanner;


public class Generator {
    Scanner scanner = new Scanner(System.in);
    CombatSystem combatSystem = new CombatSystem();

    public void enemyGenerate(int i, Player player) {
        Enemy[] enemyNum = new Enemy[100];
        enemyNum[0] = new Enemy("Enemy1", 1, 10, 10, 1, 1, 1, 1);
        enemyNum[1] = new Enemy("Enemy2", 2, 20, 20, 2, 3, 3, 1);
        enemyNum[2] = new Enemy("Enemy3", 3, 30, 30, 3, 5, 5, 3);
        enemyNum[3] = new Enemy("Enemy4", 4, 40, 40, 4, 7, 5, 3);
        enemyNum[4] = new Enemy("Enemy5", 5, 50, 50, 5, 10, 10, 3);
        enemyNum[5] = new Enemy("Enemy6", 6, 60, 60, 6, 15, 15, 5);

// 지역별로 드랍되는 아이템 추가 예정

        while (true) {
            System.out.println("전투 상대 선택 (0누를시 뒤로 이동)");
            for (int j = i; j < i + 5; j++) {
                System.out.println(enemyNum[j]);
            }
            int choice = scanner.nextInt();

                {
                    if (choice == 0) {
                        return;
                    } else if (0 < choice && choice < 5) {
                        //   System.out.println(enemyNum[(choice + (5*i))-1].getName() + "과 전투를 시작합니다..");
                        combatSystem.startCombat(player, enemyNum[(choice + (5 * i)) - 1]);

                        System.out.println("1.이어서 탐험 | 2. 메인화면으로");
                        String choice2 = scanner.nextLine();
                        scanner.nextInt();
                        switch (choice2) {
                            case "1":

                                break;
                            case "2":

                                return;

                            default:
                                System.out.println("잘못된 입력입니다.");
                        }

                    }
                }

        }
    }

    public void regionGenerate(Player player) {
        int mapUnlock = player.getMapUnlock();
        Region[] regionNum = new Region[10];
        regionNum[0] = new Region("region1", 1, 1, 5);
        regionNum[1] = new Region("region2", 2, 6, 10);
        regionNum[2] = new Region("region3", 3, 11, 15);
        regionNum[3] = new Region("region4", 4, 16, 20);
        regionNum[4] = new Region("region5", 5, 21, 25);
        //TODO 지역 추가

        for (int i = 0; i <= mapUnlock + 1; i++) {
            System.out.println(regionNum[i]);

        }
        System.out.println("이동할 지역 선택  (0누를시 뒤로 이동)");

        int choice = scanner.nextInt();
        if (choice == 0) {
            return;
        }
        if (choice - 1 > mapUnlock) {
            System.out.println("이 지역은 아직 해금되지 않았습니다.");
        } else if (0 < choice && choice < regionNum.length) {
            System.out.println(regionNum[choice - 1].getRegionName() + "으로 이동합니다.");
            enemyGenerate(choice - 1, player);
        }

    }

}




