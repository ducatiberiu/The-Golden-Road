package PaooGame;

public class Main
{
    public static void main(String[] args)
    {
        Game paooGame = Game.SingletonGameInstance();// SINGLETON: apelez metoda statica creata pentru implementarea sablonului SINGLETON
        paooGame.StartGame();
    }
}
