package prototypeSystem.item;

import prototypeSystem.character.Player;
import prototypeSystem.item.weapon.Weapon;

import java.util.Scanner;

public class WeaponShop {
    Weapon[]  weapon = new Weapon[100];
Scanner scanner = new Scanner(System.in);

    public void weaponShopping(Player player){
        GenerateWeapon(player);
        ShowWeapon(player);



    }


    public void GenerateWeapon(Player player){

        weapon[0] = new Weapon(0,"맨손",0,1,0,1,0,0,0,0,0);
        weapon[1] = new Weapon(1,"목검",5,1,0,1,1,0,0,10,100);
        weapon[2] = new Weapon(2,"목단검",5,1,0,1,0,1,0,10,100);
        weapon[3] = new Weapon(3,"나뭇가지",0,1,5,1,0,0,1,10,100);
        if(player.getMapUnlock() > 0){
            weapon[4] = new Weapon(4,"가검",10,1,0,1,3,1,0,20,500);
            weapon[5] = new Weapon(5,"식칼",10,1,0,1,1,5,0,15,500);
            weapon[6] = new Weapon(6,"완드",0,1,15,1,0,0,5,15,500);
            //계속 추가하자!
        }



    }
    public void ShowWeapon(Player player){
        weapon[0].getItemInfo();
        for(int i = 1 ; i < 4; i++) {
            weapon[i].getItemInfo();
        }
        if (player.getMapUnlock() > 0){
            for(int i = 4 ; i < 7; i++) {
                weapon[i].getItemInfo();
            }
        }
        // 계속 추가하자!

        int choice = scanner.nextInt();
        buyWeapon(player,choice);


    }


    public void ShowPlayerOwnWeapon(Player player){
        for (Weapon weapon1 : weapon) {
            System.out.println("보유중인 무기");
            if(weapon1.getPlayerHave() == 1){
                System.out.println(weapon1.getWeaponName());
            }
        }
    }

    public void buyWeapon(Player player, int i){
        boolean flag1 = true;
        boolean flag2 = true;
        flag1 = haveCheck(player,i);
        if (!flag1){return;}
        flag2 = moneyCheck(player,i);
        if (!flag2){return;}

        System.out.println(weapon[i].getWeaponName() + "를 구매합니다.");
        System.out.println(player.getMoney() + " -> " + (player.getMoney() - weapon[i].getWeaponPrice()));
        player.setMoney(player.getMoney()-weapon[i].getWeaponPrice());

        weapon[i].setPlayerHave(1);


    }



    public boolean haveCheck(Player player, int i){
        if(weapon[i].getPlayerHave() == 1 ){
            System.out.println("이미 보유한 아이템 입니다.");
            return false;
        }
        else return true;
    }
    public boolean moneyCheck(Player player, int i){
        if (player.getMoney() < weapon[i].getWeaponPrice()) {
            System.out.println("골드가 부족 합니다.");
            return false;
        }
        else return true;
    }









}
