package prototypeSystem.game;

import prototypeSystem.character.Player;
import prototypeSystem.combat.CombatSystem;
import prototypeSystem.combat.Generator;
import prototypeSystem.System.DatabaseConnect;
import prototypeSystem.item.Armor;
import prototypeSystem.item.Shop;
import prototypeSystem.item.Weapon;
import prototypeSystem.job.Job;
import prototypeSystem.job.JobGenerator;


import java.sql.SQLException;
import java.util.Scanner;

public class Game {
    private DatabaseConnect databaseConnect;
    PlayerInfo playerInfo = new PlayerInfo();
    Scanner scanner = new Scanner(System.in);
    Shop shop = new Shop();
    JobGenerator jobGenerator = new JobGenerator();
    Weapon[] weapon = new Weapon[100];
    Armor[] armor = new Armor[100];
    Achievements[] achieve = new Achievements[100];
    Job[] job = new Job[100];
    int weaponArraySize = 10;
    int armorArraySize = 25;
    int achieveArraySize = 9;
    int jobArraySize = 3;
    CombatSystem combatSystem = new CombatSystem();
    int areYouComeBack = 0;

    public Game(DatabaseConnect databaseConnect) {
        this.databaseConnect = databaseConnect;
    }

    // 게임 시작
    public Player gameStart() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Game Start");
        System.out.println("1.불러오기 | 2.새로 시작");
        int choice = scanner.nextInt();

        Player player = null;

        // 세이브 데이터 or 새로 시작을 위해 미리 객체 생성

        switch (choice) {
            case 1:     //세이브 불러오기
                player = databaseConnect.getPlayer(1);
                for (int i = 1; i <= weaponArraySize; i++) {
                    weapon[i] = databaseConnect.getWeapon(i);
                }
                for (int i = 1; i <= armorArraySize; i++) {
                    armor[i] = databaseConnect.getArmor(i);
                }
                for (int i = 1; i <= achieveArraySize; i++) {
                    achieve[i] = databaseConnect.getAchievements(i);
                }
                jobGenerator.getClass(job, databaseConnect, jobArraySize);

                System.out.println(player.getName() + "님, 모험을 시작합니다.");
                areYouComeBack = 1;

                break;
            case 2:     // 새로 시작
                System.out.print("플레이어 이름 : ");
                String newPlayerName = scanner.next();
                // 새로운 플레이어 생성
                player = new Player(newPlayerName);
                System.out.println(player.getName() + "님, 모험을 시작합니다.");


                // Original 에서 아이템 데이터 받기
                for (int i = 1; i <= weaponArraySize; i++) {
                    weapon[i] = databaseConnect.getWeaponOriginal(i);
                }
                for (int i = 1; i <= armorArraySize; i++) {
                    armor[i] = databaseConnect.getArmorOriginal(i);
                }

                for (int i = 1; i <= achieveArraySize; i++) {
                    achieve[i] = databaseConnect.getAchievementsOriginal(i);
                }
                jobGenerator.getClassOriginal(job, databaseConnect, jobArraySize);


                System.out.println("초기 직업을 설정해 주세요");
                jobGenerator.DisplayJob(job, jobArraySize);
                jobGenerator.choiceJob(job, jobArraySize);


                break;
            default:
                System.out.println("올바른 입력이 아닙니다.");
        }
        return player;
    }

    // 게임 저장
    public void gameSave(Player player) throws SQLException {
        {
            System.out.println("게임을 세이브 하시겠습니까?");
            System.out.println("1.저장 | 2.저장안함");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    saveGame(player);
                    System.out.println("세이브 저장 완료");
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
            //자동저장?
            saveGame(player);
            jobGenerator.getClass(job, databaseConnect, jobArraySize);
            AchievementCheck(player);
            player.organizeStats(weapon, armor, job, weaponArraySize, achieveArraySize, jobArraySize); //플레이어 종합 스텟 점검

            System.out.println("=======================================================");
            System.out.println("| 1.탐험 | 2.캐릭터 | 3.마을 | 4.저장 | 5.종료 |");
            System.out.println("=======================================================");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": {
                    int x = 0;
                    for (int i = 1; i <= jobArraySize; i++) {
                        if (job[i].getActiveON() == 1) {
                            x = i;
                        }
                    }
                    if (x == 0) {
                        System.out.println("액티브를 설정하셔야 입장할 수 있습니다.");
                        break;
                    } //예외 처리
                }


                generator.regionGenerate(player, job, jobArraySize);


                break;


                case "2":
                    System.out.println("| 1.레벨업 | 2.아이템 | 3.클래스 | 4.통계 | 5.업적 | 0.뒤로가기 |");
                    String choice2 = scanner.nextLine();
                    if (choice2.equals("1")) {
                        playerInfo.levelUp(player, weapon, armor, job, jobArraySize);
                    } else if (choice2.equals("2")) {
                        player.showHaveItems(weapon, armor, weaponArraySize, armorArraySize,job, jobArraySize);
                    } else if (choice2.equals("3")) {
                        //======================================
                        jobGenerator.DisplayOwnedJob(job, jobArraySize);


                        //=======================================
                    } else if (choice2.equals("4")) {
                        player.getStatistics();
                    } else if (choice2.equals("5")) {
                        player.showAchievements(achieve,achieveArraySize);
                    } else if (choice2.equals("0")) {
                        break;
                    } else {
                        System.out.println("올바른 입력이 아닙니다.");
                    }
                    break;
                case "3": {
                    System.out.println("마을로 이동합니다.");
                    System.out.println("| 1.무기상점 | 2.방어구상점 | 3.전직 | 0.이전 |");
                    String choice3 = scanner.nextLine();

                    if (choice3.equals("1")) {
                        shop.CallWeaponShop(player, weapon);
                    } else if (choice3.equals("2")) {
                        shop.CallArmorShop(player, armor);
                    } else if (choice3.equals("3")) {
                        jobGenerator.DisplayJob(job, jobArraySize);
                        jobGenerator.choiceJob(job, jobArraySize);

                    } else if (choice3.equals("0")) {
                        break;
                    } else {
                        System.out.println("올바른 입력이 아닙니다.");
                    }


                    break;
                }
                case "4":
                    gameSave(player);
                    break;

                case "5":
                    gameExit(player);
                    break;

                default:
                    System.out.println("올바른 입력이 아닙니다.");
            }

        }
    }

    public void AchievementCheck(Player player) {
        if (player.getKillCount() >= 100 && achieve[2].getClear() == 0) {
            System.out.println("도전과제 달성! 보상 : 1000EXP");
            achieve[2].setClear(1);
            player.setCurrentEXP(player.getCurrentEXP() + 1000);
        }
        if (player.getGold() >= 1000 && achieve[3].getClear() == 0) {
            System.out.println("도전과제 달성! 보상 1000EXP");
            achieve[3].setClear(1);
            player.setCurrentEXP(player.getCurrentEXP() + 1000);
        }
        if (player.getMapUnlock() > 1 && achieve[4].getClear() == 0) {
            System.out.println("도전과제 달성! 보상 1000EXP");
            achieve[4].setClear(1);
            player.setCurrentEXP(player.getCurrentEXP() + 1000);
        }
        if (areYouComeBack == 1 && achieve[5].getClear() == 0) {
            System.out.println("도전과제 달성! 보상 1000EXP");
            achieve[5].setClear(1);
            player.setCurrentEXP(player.getCurrentEXP() + 1000);
        }
        if (player.getDeathCount() == 1 && achieve[6].getClear() == 0) {
            System.out.println("도전과제 달성! 보상 1000EXP");
            achieve[6].setClear(1);
            player.setCurrentEXP(player.getCurrentEXP() + 1000);
        }
        if (player.getDeathCount() == 10 && achieve[7].getClear() == 0) {
            System.out.println("도전과제 달성! 보상 3000EXP");
            achieve[7].setClear(1);
            player.setCurrentEXP(player.getCurrentEXP() + 1000);
        }
        if (player.getLevel() == 10 && achieve[8].getClear() == 0) {
            achieve[8].setClear(1);
            player.setCurrentEXP(player.getCurrentEXP() + 1000);
        }
        if (player.getLevel() == 20 && achieve[9].getClear() == 0) {
            achieve[9].setClear(1);
            player.setCurrentEXP(player.getCurrentEXP() + 2000);
        }
    }

    public void saveGame(Player player) throws SQLException {
        databaseConnect.savePlayer(player);
        databaseConnect.saveWeapon(weapon, weaponArraySize);
        databaseConnect.saveArmor(armor, armorArraySize);
        databaseConnect.saveAchievements(achieve, achieveArraySize);
        databaseConnect.saveJob(job, jobArraySize);

    }
}
