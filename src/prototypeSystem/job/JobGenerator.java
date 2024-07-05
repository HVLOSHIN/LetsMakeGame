package prototypeSystem.job;

import prototypeSystem.System.DatabaseConnect;
import prototypeSystem.job.subClass.Caster;
import prototypeSystem.job.subClass.Page;
import prototypeSystem.job.subClass.Thief;

import java.sql.SQLException;
import java.util.Scanner;

public class JobGenerator {
    Scanner scanner = new Scanner(System.in);

    public void getClassOriginal(Job[] job, DatabaseConnect databaseConnect, int jobArraySize) throws SQLException {

        int[][] arr = new int[jobArraySize + 1][9];

        for (int i = 1; i <= jobArraySize; i++) {
            databaseConnect.getJobOriginal(arr, i);
        }
        executeArray(job, arr);
    }

    public void getClass(Job[] job, DatabaseConnect databaseConnect, int jobArraySize) throws SQLException {

        int[][] arr = new int[jobArraySize + 1][9];

        for (int i = 1; i <= jobArraySize; i++) {
            databaseConnect.getJob(arr, i);
        }
        executeArray(job, arr);
    }

    public void executeArray(Job[] job, int[][] arr) {
        job[1] = new Page(arr[1][1], arr[1][2], arr[1][3], arr[1][4], arr[1][5], arr[1][6], arr[1][7], arr[1][8]);
        job[2] = new Thief(arr[2][1], arr[2][2], arr[2][3], arr[2][4], arr[2][5], arr[2][6], arr[2][7], arr[2][8]);
        job[3] = new Caster(arr[3][1], arr[3][2], arr[3][3], arr[3][4], arr[3][5], arr[3][6], arr[3][7], arr[3][8]);
    }

    public void DisplayJob(Job[] job, int jobArraySize) {
        for (int i = 1; i <= jobArraySize; i++) {
            if(job[i].getUnLock() ==1) {
                if (job[i].getJobHave() == 1) {
                    System.out.print("(보유중) ");
                }
                System.out.println(i + " : " + job[i].getJobName() + "       " + job[i].getJobEXP() + " / " + job[i].getJobMaxEXP());
            }

        }
    }
    public void DisplayOwnedJob(Job[] job, int jobArraySize) {
        System.out.println("보유한 클래스의 패시브효과들은 일괄 적용됩니다.");
        System.out.println("마스터하지 못한 직업은 변경할시 패시브 효과를 잃어버립니다.");

        for (int i = 1; i <= jobArraySize; i++) {
            if(job[i].getJobHave() ==1) {
                if(job[i].getJobMain() == 1) {
                    System.out.print("(main) ");
                }

                System.out.println(i + " : " + job[i].getJobName() + "       " + job[i].getJobEXP() + " / " + job[i].getJobMaxEXP());
                System.out.print("       액티브 - ");
                job[i].activeDescription();
                System.out.print("       패시브 - ");
                job[i].passiveDescription();
            }
        }
        System.out.println("활성화할 액티브를 선택 (0입력시 이전)");
        int choice = scanner.nextInt();
        if (choice == 0) {
            return;
        }
        if(job[choice].getJobHave() == 1) {
            for(int i = 1; i <= jobArraySize; i++) {
                job[i].setJobMain(0);
            }
            job[choice].setJobMain(1);
            System.out.println(job[choice].getJobName() + "클래스의 " + job[choice].getActiveName() + "를 메인 공격으로 설정합니다.");
        }






    }
    public void choiceJob(Job[] job, int jobArraySize){
        System.out.println("클래스 선택");
        int choice = scanner.nextInt();
        if (choice > jobArraySize) {
            System.out.println("아직 개방되지 않은 직업입니다.");
            return;
        } else if (job[choice].getJobHave() == 1) {
            System.out.println("이미 보유한 클래스입니다.");
            return;
        }
        System.out.println(job[choice].getJobName() + "로 전직합니다.");
        job[choice].setJobHave(1);
    }


}
