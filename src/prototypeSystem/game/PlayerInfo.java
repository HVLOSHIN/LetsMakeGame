package prototypeSystem.game;

import prototypeSystem.character.Player;
import prototypeSystem.combat.CombatSystem;
import prototypeSystem.item.Armor;
import prototypeSystem.item.Weapon;
import prototypeSystem.job.Job;

import java.util.Scanner;

public class PlayerInfo {
    int HP;
    int STR;
    int DEX;
    int INT;


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
    CombatSystem combatSystem = new CombatSystem();

    public void levelUp(Player player , Weapon[] weapon, Armor[] armor, Job[] job, int jobArraySize) {
        maxExp = (player.getLevel()*player.getLevel())*3;
        while (true) {
          //  showPlayer(player, weapon, armor);
            combatSystem.displayPlayerCombatStatus(player, job, jobArraySize);

            System.out.println("| 1.체력 | 2.근력 | 3.기교 | 4.지력 | 5.이전 |");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    expCheck = expCheck(player);
                    if (expCheck) {
                        System.out.println("체력 : " + player.getMaxHP() + " -> " + (player.getMaxHP() + 10));
                        player.setMaxHP(player.getMaxHP() + 10);
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
        maxExp = (player.getLevel()*player.getLevel())*3;
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

}
