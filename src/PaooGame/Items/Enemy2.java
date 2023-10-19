package PaooGame.Items;

import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.util.Random;
import java.awt.image.BufferedImage;

public class Enemy2 extends Enemy{
    private Animation enemy2AnimStay, enemy2AnimDown, enemy2AnimUp, enemy2AnimLeft, enemy2AnimRight;
    public int actionLockCounter = 0;

    //Constructor de initializare al clasei Enemy2
    public Enemy2(RefLinks refLink, float x, float y) {
        super(refLink, x, y);

        bounds.x = 5;
        bounds.y = 5;
        bounds.width = 50;
        bounds.height = 60;
        life = 70;
        speed = 1.0f;

        //Animations
        enemy2AnimStay = new Animation(250, Assets.enemy2Stay);
        enemy2AnimDown = new Animation(350,Assets.enemy2Down);
        enemy2AnimUp = new Animation(350,Assets.enemy2Up);
        enemy2AnimLeft = new Animation(250,Assets.enemy2Left);
        enemy2AnimRight = new Animation(250,Assets.enemy2Right);
    }

    //Actualizeaza animatiile, pozitia si atacul celui de-al doilea tip de inamic
    @Override
    public void Update()
    {
        enemy2AnimStay.Update();
        enemy2AnimDown.Update();
        enemy2AnimUp.Update();
        enemy2AnimLeft.Update();
        enemy2AnimRight.Update();

        setAction(); //Folosesc metoda setAction pentru a implementa deplasarea celui de-al doilea tip de inamic
        Move();
        enemyAttack();
    }

    @Override
    public void Die() {
        super.Die();
    }

    @Override
    public void Draw(Graphics g) {
        super.Draw(g);
        g.drawImage(getCurrentAnimationFrame(), (int)(x - refLink.GetGameCamera().getxOffset()), (int)(y - refLink.GetGameCamera().getyOffset()), width, height, null);
    }

    //Implementeaza deplasarea inamicului
    private void setAction()//Directia inamicului va fi aleatoare
    {
        actionLockCounter++;

        if(actionLockCounter == 120)
        {
            Random random = new Random();
            int i = random.nextInt(40) + 1;

            if (i <= 10) {
                yMove = -speed;//Sus
            }
            if (i > 10 && i <= 20) {
                yMove = speed;//Jos
            }
            if (i > 20 && i <= 30) {
                xMove = -speed;//Stanga
            }
            if (i > 30 && i < 40) {
                xMove = speed;//Dreapta
            }
            actionLockCounter = 0;
        }
    }

    private BufferedImage getCurrentAnimationFrame()
    {
        if(xMove < 0)
            return enemy2AnimLeft.getCurrentFrame();
        else if(xMove > 0)
            return enemy2AnimRight.getCurrentFrame();
        else if(yMove < 0)
            return enemy2AnimUp.getCurrentFrame();
        else if(yMove > 0)
            return enemy2AnimDown.getCurrentFrame();
        else
            return enemy2AnimStay.getCurrentFrame();
    }
}
