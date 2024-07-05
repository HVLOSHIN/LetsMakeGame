package prototypeSystem.job;

import prototypeSystem.System.DatabaseConnect;
import prototypeSystem.job.subClass.Caster;
import prototypeSystem.job.subClass.Page;
import prototypeSystem.job.subClass.Thief;

import java.sql.SQLException;

public class JobGenerator {

    public void getClassOriginal(Job[] job, DatabaseConnect databaseConnect, int jobArraySize) throws SQLException {

        int[][] arr = new int[jobArraySize + 1][8];

        for (int i = 1; i <= jobArraySize; i++) {
            databaseConnect.getJobOriginal(arr, i);
        }
        job[1] = new Page(arr[1][1], arr[1][2], arr[1][3], arr[1][4], arr[1][5], arr[1][6], arr[1][7]);
        job[2] = new Thief(arr[2][1], arr[2][2], arr[2][3], arr[2][4], arr[2][5], arr[2][6], arr[2][7]);
        job[3] = new Caster(arr[3][1], arr[3][2], arr[3][3], arr[3][4], arr[3][5], arr[3][6], arr[3][7]);
    }
    public void getClass(Job[] job, DatabaseConnect databaseConnect, int jobArraySize) throws SQLException {

        int[][] arr = new int[jobArraySize + 1][8];

        for (int i = 1; i <= jobArraySize; i++) {
            databaseConnect.getJob(arr, i);
        }
        job[1] = new Page(arr[1][1], arr[1][2], arr[1][3], arr[1][4], arr[1][5], arr[1][6], arr[1][7]);
        job[2] = new Thief(arr[2][1], arr[2][2], arr[2][3], arr[2][4], arr[2][5], arr[2][6], arr[2][7]);
        job[3] = new Caster(arr[3][1], arr[3][2], arr[3][3], arr[3][4], arr[3][5], arr[3][6], arr[3][7]);
    }
}
