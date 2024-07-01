package prototypeSystem.village;

import prototypeSystem.character.Player;

import java.util.Scanner;

public class VillageLoop {
Scanner scanner = new Scanner(System.in);

   public void VillageLoop(Player player) {
        String choice = scanner.nextLine();
       System.out.println(" | 1.상점 | 2.전직 | 0.이전 |");
        switch (choice) {
            case "1":

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
