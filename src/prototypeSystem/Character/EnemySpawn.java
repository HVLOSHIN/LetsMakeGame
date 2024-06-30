package prototypeSystem.Character;

public class EnemySpawn{
    Enemy[] enemyNum = new Enemy[100];

    public EnemySpawn() {
        enemyNum[0] = new Enemy("Enemy1",1,10,10,5,5);
        enemyNum[1] = new Enemy("Enemy2",2,20,20,10,10);
        enemyNum[2] = new Enemy("Enemy3",3,30,30,15,15);
        enemyNum[3] = new Enemy("Enemy4",4,40,40,20,20);
        enemyNum[4] = new Enemy("Enemy5",5,50,50,25,25);

    }
    public void getEnemyInfo(int num){

        System.out.println(enemyNum[num].toString());
    }

 }


