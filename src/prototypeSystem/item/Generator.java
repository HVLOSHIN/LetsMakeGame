package prototypeSystem.item;

import prototypeSystem.character.Player;
import prototypeSystem.item.weapon.Weapon;

public class Generator {
    Weapon[]  weapon = new Weapon[100];

    public void WeaponGenerator(Player player){

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
        for(int i = 1 ; i < 4; i++) {
            weapon[i].getItemInfo();
        }
        if (player.getMapUnlock() > 0){
            for(int i = 4 ; i < 7; i++) {
                weapon[i].getItemInfo();
            }
        }
        // 계속 추가하자!

    }
    public void ShowPlayerOwnWeapon(Player player){
        for (Weapon weapon1 : weapon) {
            System.out.println("보유중인 무기");
            if(weapon1.getPlayerHave() == 1){
                System.out.println(weapon1.getWeaponName());
            }
        }
    }









}
