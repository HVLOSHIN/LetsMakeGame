package prototypeSystem.item;

import prototypeSystem.character.Player;

import java.util.Scanner;

public class Shop {


    Scanner scanner = new Scanner(System.in);

    public void CallWeaponShop(Player player, Weapon[] weapon) {
        System.out.println("현재 보유 골드 : " + player.getGold());
        // map 해금에 따라 순차적 개방
        displayWeapons(player, weapon);

        // 무기 선택
        int itemChoice = scanner.nextInt();
        if (itemChoice > player.getMapUnlock()*3) {
            System.out.println("아직 해금된 무기가 아닙니다..");
        }
        try {
            buyWeapon(player, itemChoice, weapon);
        } catch (NullPointerException e) {
            System.out.println("올바른 입력이 아닙니다.");
        }
    }
    public void displayWeapons(Player player, Weapon[] weapon) {
        int mapUnlock = player.getMapUnlock();
        for (int i = 1; i <= 3 * mapUnlock; i++) {
            if (weapon[i].getHave() == 1) {
                System.out.print("(보유중)");
            }
            weapon[i].getItemInfo();
        }
    }
    public void buyWeapon(Player player, int i, Weapon[] weapon) {
        //소유 검증
        if (weapon[i].getHave() == 1) {
            System.out.println("이미 보유한 아이템 입니다.");
            return;
        }
        //골드 검증
        if (player.getGold() < weapon[i].getPrice()) {
            System.out.println("골드가 부족 합니다.");
            return;
        }

        System.out.println(weapon[i].getName() + "를 구매합니다.");
        System.out.println(player.getGold() + " -> " + (player.getGold() - weapon[i].getPrice()) + " (골드)");
        player.setGold(player.getGold() - weapon[i].getPrice());
        weapon[i].setHave(1);
    }



    public void CallArmorShop(Player player, Armor[] armor) {
        System.out.println("현재 보유 골드 : " + player.getGold());

        displayArmors(player, armor);
        //방어구 선택
        int itemChoice = scanner.nextInt();
        if (itemChoice > player.getMapUnlock()*3) {
            System.out.println("아직 해금된 방어구가 아닙니다..");
        }
        try {
            buyArmor(player, itemChoice, armor);
        } catch (NullPointerException e) {
            System.out.println("올바른 입력이 아닙니다.");
        }
    }
    public void displayArmors(Player player, Armor[] armor) {
        int mapUnlock = player.getMapUnlock();
        for (int i = 1; i <= 3 * mapUnlock; i++) {
            if (armor[i].getHave() == 1) {
                System.out.print("(보유중)");
            }
            armor[i].getItemInfo();
        }
    }
    public void buyArmor(Player player, int i, Armor[] armor) {
        //소유 검증
        if (armor[i].getHave() == 1) {
            System.out.println("이미 보유한 아이템 입니다.");
            return;
        }
        //골드 검증
        if (player.getGold() < armor[i].getPrice()) {
            System.out.println("골드가 부족 합니다.");
            return;
        }

        System.out.println(armor[i].getName() + "를 구매합니다.");
        System.out.println(player.getGold() + " -> " + (player.getGold() - armor[i].getPrice()) + " (골드)");
        player.setGold(player.getGold() - armor[i].getPrice());
        armor[i].setHave(1);
    }


}


