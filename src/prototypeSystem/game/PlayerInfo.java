package prototypeSystem.game;

import prototypeSystem.character.Player;

import java.util.Scanner;

public class PlayerInfo {

    int attack;
    int magicAttack;
    int defense;
    int magicDefense;
    int critical;
    int dodge;
    int accuracy;
    int maxExp;
    int attackSpeed;

    boolean expCheck;


    Scanner scanner = new Scanner(System.in);

    public void levelUp(Player player) {
        while (true) {
            showPlayer(player);

            System.out.println("| 1.체력 | 2.근력 | 3.기교 | 4.지력 | 5.이전 |");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    expCheck = expCheck(player);
                    if (expCheck) {
                        System.out.println("체력 : " + player.getMaxHP() + " -> " + (player.getMaxHP() + 5));
                        player.setMaxHP(player.getMaxHP() + 5);
                    }
                    break;
                case "2":
                    expCheck = expCheck(player);
                    if (expCheck) {
                        System.out.println("근력 : " + player.getSTR() + " -> " + (player.getSTR() + 1));
                        player.setSTR(player.getSTR() + 1);
                    }
                    break;
                case "3":
                    expCheck = expCheck(player);
                    if (expCheck) {
                        System.out.println("기교 : " + player.getDEX() + " -> " + (player.getDEX() + 1));
                        player.setDEX(player.getDEX() + 1);
                    }
                    break;
                case "4":
                    expCheck = expCheck(player);
                    if (expCheck) {
                        System.out.println("지력 : " + player.getINT() + " -> " + (player.getINT() + 1));
                        player.setINT(player.getINT() + 1);

                    }
                    break;
                case "5":
                    return;
                default:
                    System.out.println("올바른 입력이 아닙니다.");

            }
        }

    }

    public boolean expCheck(Player player) {
        if (player.getCurrentEXP() < maxExp) {
            System.out.println("경험치가 부족합니다.");
            return false;
        } else {
            player.setUsedExp(player.getUsedExp() + player.getCurrentEXP());
            player.setCurrentEXP(player.getCurrentEXP() - maxExp);
            System.out.println("레벨 : " + player.getLevel() + " -> " + (player.getLevel() + 1));
            player.setLevel(player.getLevel() + 1);
            return true;
        }
    }

    public void showPlayer(Player player) {
        getStats(player);
        System.out.println("===========================");
        System.out.println("레벨 : " + player.getLevel());
        System.out.print("체력 : " + player.getMaxHP());
        System.out.println("  | 근력 : " + player.getSTR());
        System.out.print("기교 : " + player.getDEX());
        System.out.println("  | 지력 : " + player.getINT());
        System.out.println();
        System.out.print("공격력 : " + attack);
        System.out.println("  | 마법공격력 : " + magicAttack);
        System.out.print("방어력 : " + defense);
        System.out.println("  | 마법방어력 : " + magicDefense);
        System.out.print("회피율 : " + dodge);
        System.out.println("  | 명중률 : " + accuracy);
        System.out.println("치명타 확률 :" + critical);
        System.out.println();
        System.out.println("레벨업 필요 경험치 : " + maxExp);
        System.out.println("현재 경험치 : " + player.getCurrentEXP());
        System.out.println("현재 보유 금화 : " + player.getGold());

        System.out.println("===========================");
    }

    public void getStats(Player player) {
        attack = (player.getSTR() * 3) + player.getDEX();
        magicAttack = (player.getINT() * 3);
        defense = player.getSTR() * 2;
        magicDefense = player.getINT() * 2;
        critical = player.getDEX();
        dodge = player.getDEX();
        attackSpeed = player.getDEX();
        maxExp = player.getLevel() * player.getLevel() * 5;


        if (player.getSTR() > player.getDEX() && player.getSTR() > player.getINT()) {
            accuracy = player.getSTR();
        } else if (player.getDEX() > player.getINT()) {
            accuracy = player.getDEX();
        } else {
            accuracy = player.getINT();
        }
    }
}
