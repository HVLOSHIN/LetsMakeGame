package prototypeSystem.Character;

public class EnemySpawn{
    Enemy[] enemyNum = new Enemy[100];

    public EnemySpawn() {
        enemyNum[0] = new Enemy("Enemy1",1,10,10,5,5);
        enemyNum[1] = new Enemy("Enemy2",2,20,20,10,10);



    }
    public void getEnemyInfo(int num){

        System.out.println(enemyNum[num].toString());
    }


 }


