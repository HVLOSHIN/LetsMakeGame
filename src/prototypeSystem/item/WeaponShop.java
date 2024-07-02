package prototypeSystem.item;

import prototypeSystem.character.Player;
import prototypeSystem.database.DatabaseConnect;
import prototypeSystem.item.weapon.Weapon;

import java.sql.SQLException;
import java.util.Scanner;

public class WeaponShop {



Scanner scanner = new Scanner(System.in);
DatabaseConnect db = new DatabaseConnect();
    public void CallWeaponShop(Player player, Weapon[] weapon){
        ShowWeapon(player,weapon);


    }


    public void ShowWeapon(Player player, Weapon[] weapon){
        for(int i = 1 ; i < 4; i++) {
            if(weapon[i].getPlayerHave() == 0) {
                weapon[i].getItemInfo();
            }
        }
        if (player.getMapUnlock() > 0){
            for(int i = 4 ; i < 7; i++) {
                if(weapon[i].getPlayerHave() == 0) {
                    weapon[i].getItemInfo();
                }
            }
        }
        // 계속 추가하자!

        int choice = scanner.nextInt();
        try {
            buyWeapon(player, choice, weapon);
        }
        catch (NullPointerException e){
            System.out.println("올바른 입력이 아닙니다.");
        }


    }


    public void ShowPlayerOwnWeapon(Player player, Weapon[] weapon){
        for (Weapon weapon1 : weapon) {
            System.out.println("보유중인 무기");
            if(weapon1.getPlayerHave() == 1){
                System.out.println(weapon1.getWeaponName());
            }
        }
    }

    public void buyWeapon(Player player, int i, Weapon[] weapon){
        boolean flag1 = true;
        boolean flag2 = true;
        flag1 = haveCheck(player,i,weapon);
        if (!flag1){return;}
        flag2 = moneyCheck(player,i,weapon);
        if (!flag2){return;}

        System.out.println(weapon[i].getWeaponName() + "를 구매합니다.");
        System.out.println(player.getMoney() + " -> " + (player.getMoney() - weapon[i].getWeaponPrice()));
        player.setMoney(player.getMoney()-weapon[i].getWeaponPrice());

        weapon[i].setPlayerHave(1);


    }



    public boolean haveCheck(Player player, int i, Weapon[] weapon){
        if(weapon[i].getPlayerHave() == 1 ){
            System.out.println("이미 보유한 아이템 입니다.");
            return false;
        }
        else return true;
    }
    public boolean moneyCheck(Player player, int i, Weapon[] weapon){
        if (player.getMoney() < weapon[i].getWeaponPrice()) {
            System.out.println("골드가 부족 합니다.");
            return false;
        }
        else return true;
    }





    }


