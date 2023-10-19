package PaooGame.Items;

import PaooGame.GameWindow.GameWindow;
import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.Items.Character;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends Character {
    private Animation enemyAnimStay, enemyAnimDown, enemyAnimUp, enemyAnimLeft, enemyAnimRight;
    private final Rectangle visibility;//aria de vizibilitate a inamicului
    private long lastAttackTimer, attackCooldown = 30, attackTimer = attackCooldown;

    //Constructor de initializare al clasei Enemy
    public Enemy(RefLinks refLink, float x, float y)
    {
        super(refLink, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 5;
        bounds.y = 5;
        bounds.width = 50;
        bounds.height = 60;
        life = 50;
        visibility = new Rectangle(0 ,0 , 400, 400);//initializarea ariei de vizibilitate a inamicului
        speed = 1.0f;

        //Animations
        enemyAnimStay = new Animation(250, Assets.enemyStay);
        enemyAnimDown = new Animation(350,Assets.enemyDown);
        enemyAnimUp = new Animation(350,Assets.enemyUp);
        enemyAnimLeft = new Animation(250,Assets.enemyLeft);
        enemyAnimRight = new Animation(250,Assets.enemyRight);
    }

    //Actualizeaza animatiile si pozitia inamicului
    @Override
    public void Update()
    {
        enemyAnimStay.Update();
        enemyAnimDown.Update();
        enemyAnimUp.Update();
        enemyAnimLeft.Update();
        enemyAnimRight.Update();

        GetInput();
        Move();
    }
    @Override
    public void Die() {

    }

    //Deseneaza inamicul in noua pozitie.
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(getCurrentAnimationFrame(), (int)(x - refLink.GetGameCamera().getxOffset()), (int)(y - refLink.GetGameCamera().getyOffset()), width, height, null);

        // pentru vizualizarea dreptunghiului de coliziune
        //g.setColor(Color.red);
        //g.fillRect((int)(x + bounds.x - refLink.GetGameCamera().getxOffset()), (int)(y + bounds.y - refLink.GetGameCamera().getyOffset()), bounds.width, bounds.height);
    }

    //Returneaza frame-ul curent al inamicului in functie de directia de deplasare
    private BufferedImage getCurrentAnimationFrame()
    {
        if(xMove < 0)
            return enemyAnimLeft.getCurrentFrame();
        else if(xMove > 0)
            return enemyAnimRight.getCurrentFrame();
        else if(yMove < 0)
            return enemyAnimUp.getCurrentFrame();
        else if(yMove > 0)
            return enemyAnimDown.getCurrentFrame();
        else
            return enemyAnimStay.getCurrentFrame();
    }

    //Actualizeaza directia de deplasare a inamicului, stabileste viteza de deplasare si apeleaza metoda de atac
    private void GetInput()
    {
        xMove = 0;
        yMove = 0;
        for(Item item : refLink.GetMap().getItemManager().GetItems())//Iteram prin vectorul de item-uri
        {
            if(item instanceof Hero)//daca item-ul e de tip Hero
            {
                //daca dreptunghiul de coliziune al eroului se intersecteaza cu dreptunghiul VisibiliyBounds
                if(item.getCollisionBounds(0f , 0f).intersects(getVisibilityBounds())) {
                    if((x < item.GetX()))//Daca coord. x inamic < coord. x jucator, atunci se actualizeaza directia inamicului si nr pixeli pe axa x
                    {
                        //Daca partea de jos a eroului se află deasupra sau la același nivel cu partea de sus a inamicului
                        if ((item.GetY() + item.GetHeight() <= y) || ( y + height >= item.GetY()))//se verifica coliziunea pe axa y dintre inamic si erou(jucator).
                            direction = 4;
                        xMove = speed / 2;
                    }
                    if(x > item.GetX())
                    {
                        if ((item.GetY() + item.GetHeight() <= y) || ( y + height >= item.GetY()))
                            direction = 2;
                        xMove = -speed / 2;
                    }
                    if(y > item.GetY() )
                    {
                        if(((item.GetX() + item.GetWidth() <= x) || (x >= item.GetX())))
                            direction = 1;
                        yMove = -speed / 2;
                    }
                    if(y < item.GetY())
                    {
                        if((item.GetX() + item.GetWidth() <= x) || (x >= item.GetX()))
                            direction = 3;
                        yMove = speed/ 2;
                    }
                    enemyAttack();
                }
            }
        }
    }

    //Implementeaza atacul inamicului
    protected void enemyAttack()
    {
        attackTimer +=System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown)
            return;

        Rectangle cb = getCollisionBounds(0, 0);

        cb.width += 15;
        cb.height += 15;

        attackTimer = 0;

        for(Item object: refLink.GetMap().getItemManager().GetItems())
        {
            if(object instanceof Hero) { //numai daca item-ul este de tip Hero
                if (object.equals(this))
                    continue;
                if (object.getCollisionBounds(10, 10).intersects(cb)) {
                    object.Hurt(DamageByLevel());
                    return;
                }
            }
        }
    }

    //Stabileste damage-ul pe care jucatorul il poate primi in functie de nivel
    private int DamageByLevel()
    {
        int damage;
        int level = refLink.GetMap().GetLevel();
        switch (level)
        {
            case 2:
                damage = 2;
                break;
            case 3:
                damage = 3;
                break;
            default:
                damage = 1;
                break;
        }
        return damage;
    }

    //Returneaza un Rectangle ce reprezinta aria de vizibilitate a inamicului
    private Rectangle getVisibilityBounds()
    {
        return new Rectangle((int) (x - (visibility.width - DEFAULT_CREATURE_WIDTH) / 2), (int) (y - (visibility.height - DEFAULT_CREATURE_HEIGHT) / 2), 400, 400);
    }
}