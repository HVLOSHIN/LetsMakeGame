package prototypeSystem.item;

import prototypeSystem.character.Player;

import java.util.Scanner;

public class WeaponShop {


    Scanner scanner = new Scanner(System.in);

    public void CallWeaponShop(Player player, Weapon[] weapon) {
        System.out.println("현재 보유 골드 : " + player.getGold());
        // map 해금에 따라 순차적으로 개방
        // 이 메서드도 개선가능 한가?
        int itemNum = 1;
        for (int i = 1; i < 4; i++) {
            if (weapon[i].getHave() == 1) {
                System.out.print("(보유중)");
            }
            weapon[i].getItemInfo();
        }
        if (player.getMapUnlock() > 0) {
            for (int i = 4; i < 7; i++) {
                if (weapon[i].getHave() == 0) {

                    weapon[i].getItemInfo();

                }
            }
        }
        if(player.getMapUnlock() > 1){
            for (int i = 7; i < 10; i++) {
                if (weapon[i].getHave() == 0) {

                    weapon[i].getItemInfo();

                }
            }

        }
        //TODO 계속 추가!

        int choice = scanner.nextInt();
        if(choice > 3 && player.getMapUnlock() == 0){
            System.out.println("올");
        }




        try {
            buyWeapon(player, choice, weapon);
        } catch (NullPointerException e) {
            System.out.println("올바른 입력이 아닙니다.");
        }
    }

    //구매 로직 메서드
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
        System.out.println( player.getGold() + " -> " + (player.getGold() - weapon[i].getPrice()) + " (골드)");
        player.setGold(player.getGold() - weapon[i].getPrice());
        weapon[i].setHave(1);
    }
}


