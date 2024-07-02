package prototypeSystem.game;

import prototypeSystem.character.Player;
import prototypeSystem.combat.Generator;
import prototypeSystem.database.DatabaseConnect;
import prototypeSystem.item.WeaponShop;
import prototypeSystem.item.weapon.Weapon;


import java.sql.SQLException;
import java.util.Scanner;

public class Game {
    private DatabaseConnect databaseConnect;
    PlayerInfo playerInfo = new PlayerInfo();
    Scanner scanner = new Scanner(System.in);
    WeaponShop weaponShop = new WeaponShop();
    Weapon[]  weapon = new Weapon[100];

    public Game(DatabaseConnect databaseConnect) {
        this.databaseConnect = databaseConnect;
    }

    // 게임 시작
    public Player gameStart() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Game Start");
        System.out.println("1.불러오기 | 2.새로 시작");
        int choice = scanner.nextInt();

        Player returnPlayer = null;

        // 세이브 데이터 or 새로 시작을 위해 미리 객체 생성

        switch (choice) {
            case 1:     //세이브 불러오기
                returnPlayer = databaseConnect.getPlayer(1);
                for (int i = 0; i <= 10; i++ ){
                    weapon[i] = databaseConnect.getWeapon(i);
                }
                System.out.println(returnPlayer.getName() + "님, 모험을 시작합니다.");

                break;
            case 2:     // 새로 시작
                System.out.print("플레이어 이름 : ");
                String newPlayerName = scanner.next();
                // 새로운 플레이어 생성
                returnPlayer = new Player(newPlayerName);
                System.out.println(returnPlayer.getName() + "님, 모험을 시작합니다.");

                // Original 에서 아이템 데이터 받기
                for (int i = 0; i <= 10; i++ ){
                    weapon[i] = databaseConnect.getWeaponOriginal(i);
                }
                break;
            default:
                System.out.println("올바른 입력이 아닙니다.");
        }
        return returnPlayer;
    }
    // 게임 저장
    public void gameSave(Player player) throws SQLException {
        {
            System.out.println("게임을 세이브 하시겠습니까?");
            System.out.println("1.저장 | 2.저장안함");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    databaseConnect.savePlayer(player);
                    System.out.println();
                        databaseConnect.saveWeapon(weapon);
                    break;

                case 2:
                    System.out.println("저장 취소");
                    break;
                default:
                    System.out.println("올바른 입력이 아닙니다.");
            }
        }
    }
    public void gameExit(Player player) throws SQLException {
        this.gameSave(player);
        System.out.println("게임을 종료합니다.");
        System.exit(0);
    }

    public void gameLogic(Player player) throws SQLException {
        Generator generator = new Generator();





        while (true) {
            System.out.println("=======================================================");
            System.out.println("| 1.탐험 | 2.레벨업 | 3.스테이터스 | 4.마을 | 5.저장 | 6.종료 |");
            System.out.println("=======================================================");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    player.getPlayerAdditionalStats(weapon); //전투 들어가기 전에 캐릭터 스텟 한번 점검
                    generator.regionGenerate(player);
                    break;

                case "2":
                    playerInfo.levelUp(player);
                    break;

                case "3":
                    System.out.println("| 1.캐릭터 | 2.효과 | 0.뒤로가기 |");
                    String choice2 = scanner.nextLine();
                    if(choice2.equals("1")) {
                        playerInfo.showPlayer(player);
                        System.out.println("사용한 경험치 : " + player.getUsedExp());
                    }
                    else if(choice2.equals("2")) {
                        player.showHaveItems(weapon);
                    }
                    else if(choice2.equals("0")) {
                        break;
                    }
                    else{
                        System.out.println("올바른 입력이 아닙니다.");
                    }
                    break;
                case "4":
                    System.out.println("마을로 이동합니다.");
                    System.out.println("| 1.무기상점 | 2.방어구상점 | 2.전직 | 0.이전 |");
                    String choice3 = scanner.nextLine();

                    switch (choice3) {
                        case "1":
                            weaponShop.CallWeaponShop(player,weapon);


                            break;
                        case "2":

                            break;
                        case "0":
                            return;
                        default:
                            System.out.println("올바른 입력이 아닙니다.");
                    }
                    break;

                case "5":
                    gameSave(player);
                    break;

                case "6":
                    gameExit(player);
                    break;

                default:
                    System.out.println("올바른 입력이 아닙니다.");
            }

        }
    }


}
