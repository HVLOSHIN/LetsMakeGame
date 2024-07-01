package prototypeSystem.village;

import prototypeSystem.character.Player;
import prototypeSystem.item.WeaponShop;

import java.util.Scanner;

public class VillageLoop {
Scanner scanner = new Scanner(System.in);

   public void VillageLoop(Player player, WeaponShop weaponShop) {
       System.out.println("마을로 이동합니다.");
       System.out.println("| 1.무기상점 | 2.방어구상점 | 2.전직 | 0.이전 |");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                weaponShop.ShowWeapon(player);


                break;
            case "2":

                break;
            case "0":
                return;
            default:
                System.out.println("올바른 입력이 아닙니다.");
        }


   }

}
