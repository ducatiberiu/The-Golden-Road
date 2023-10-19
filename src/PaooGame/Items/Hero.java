package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;

import PaooGame.Game;
import PaooGame.Graphics.Animation;
import PaooGame.Items.Objects.Key;
import PaooGame.Items.Objects.Objects;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).
 */
public class Hero extends Character
{
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/
    private Animation animStay, animDown, animUp, animLeft, animRight, animAttackEast, animAttackWest, animAttackNorth, animAttackSouth; // Animations
    private long lastAttackTimer, attackCooldown = 30, attackTimer = attackCooldown; // Atack timer
    private int collectedKeys = 0;

    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Hero(RefLinks refLink, float x, float y)
    {
        ///Apel al constructorului clasei de baza
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 2;
        bounds.y = -1;
        bounds.width = 50;
        bounds.height = 65;
        life = 300;

        // Animations
        animStay = new Animation(250, Assets.heroStay);
        animDown = new Animation(350,Assets.heroDown);
        animUp = new Animation(350,Assets.heroUp);
        animLeft = new Animation(250,Assets.heroLeft);
        animRight = new Animation(250,Assets.heroRight);

        animAttackEast = new Animation(250, Assets.heroAttackEast);
        animAttackWest = new Animation(250, Assets.heroAttackWest);
        animAttackNorth = new Animation(250, Assets.heroAttackNorth);
        animAttackSouth = new Animation(250, Assets.heroAttackSouth);

    }

    /*! \fn public void Update()
        \brief Actualizeaza pozitia, imaginea, atacul jucatorului si numarul de chei colectate
     */
    @Override
    public void Update()
    {
        // Animations
        animStay.Update();
        animDown.Update();
        animUp.Update();
        animLeft.Update();
        animRight.Update();

        animAttackEast.Update();
        animAttackWest.Update();
        animAttackNorth.Update();
        animAttackSouth.Update();

        GetInput();
        Move();
        refLink.GetGame().GetGameCamera().centerOnItem(this);

        // Attack
        checkAtacks();
        //Colectare chei(interactiunea cu obiecte)
        CollectKeys();
    }

    //Implementeaza atacul jucatorului
    private void checkAtacks()// verificam daca jucatorul a apasat tasta de atac si apoi vom genera atacul
    {
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown)
            return;

        Rectangle collbounds = getCollisionBounds(0,0);
        Rectangle attackr = new Rectangle();
        int attackrSize = 20;// dimensiunea dreptunghiului de coliziune care e setata la 20 de pixeli
        attackr.width = attackrSize;
        attackr.height = attackrSize;

        if(refLink.GetKeyManager().attack_key && direction == 1)//desenarea dreptunghiului de coliziune in partea de sus
        {
            attackr.x = collbounds.x + collbounds.width / 2 - attackrSize / 2;
            attackr.y = collbounds.y - attackrSize;
        }
        else if(refLink.GetKeyManager().attack_key && direction == 3)//desenarea dreptunghiului de coliziune in partea de jos
        {
            attackr.x = collbounds.x + collbounds.width / 2 - attackrSize / 2;
            attackr.y = collbounds.y + collbounds.height;
        }
        else if(refLink.GetKeyManager().attack_key && direction == 2)//desenarea dreptunghiului de coliziune in stanga
        {
            attackr.x = collbounds.x - attackrSize;
            attackr.y = collbounds.y + collbounds.height / 2 - attackrSize / 2;
        }
        else if(refLink.GetKeyManager().attack_key && direction == 4)//desenarea dreptunghiului de coliziune in dreapta
        {
            attackr.x = collbounds.x + collbounds.width;
            attackr.y = collbounds.y + collbounds.height / 2 - attackrSize / 2;
        }
        else
        {
            return;
        }

        attackTimer = 0;

        for(Item object : refLink.GetMap().getItemManager().GetItems())
        {
            if (object.equals(this))
                continue;
            if (object.getCollisionBounds(0, 0).intersects(attackr))
            {
                object.Hurt(1);
                return;
            }
        }
    }
    public void Die()
    {
        System.out.println("Game Over");
    }

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput()
    {
        ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;
        //Verificare apasare tasta "sus"
        if(refLink.GetKeyManager().up)
        {
            yMove = -speed;
            direction = 1;
        }
        //Verificare apasare tasta "jos"
        if(refLink.GetKeyManager().down)
        {
            yMove = speed;
            direction = 3;
        }
        //Verificare apasare tasta "stanga"
        if(refLink.GetKeyManager().left)
        {
            xMove = -speed;
            direction = 2;
        }
        //Verificare apasare tasta "dreapta"
        if(refLink.GetKeyManager().right)
        {
            xMove = speed;
            direction = 4;
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafic in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(getCurrentAnimationFrame(), (int)(x - refLink.GetGameCamera().getxOffset()), (int)(y - refLink.GetGameCamera().getyOffset()), width, height, null);
        ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
        //g.setColor(Color.red);
        //g.fillRect((int)(x + bounds.x - refLink.GetGameCamera().getxOffset()), (int)(y + bounds.y - refLink.GetGameCamera().getyOffset()), bounds.width, bounds.height);

        if(this.life >= 50)//Daca viata jucatorului este mai mare sau egala cu 50, health bar-ul va avea culoarea verde
            g.setColor(Color.green);
        else if(this.life >= 30)//Daca viata jucatorului este mai mare sau egala cu 30, health bar-ul va avea culoarea portocalie
            g.setColor(Color.orange);
        else//Altfel, health bar-ul jucatorului va avea culoarea rosie
            g.setColor(Color.red);
        //Desenez health bar-ul
        g.fillRect((int) (x - refLink.GetGame().GetGameCamera().getxOffset() + 9), (int) (y - refLink.GetGame().GetGameCamera().getyOffset() - 3), (int)life/6, 5);
    }

    private BufferedImage getCurrentAnimationFrame()
    {
        if(xMove < 0)
            return animLeft.getCurrentFrame();
        else if(xMove > 0)
            return animRight.getCurrentFrame();
        else if(yMove < 0)
            return animUp.getCurrentFrame();
        else if(yMove > 0)
            return animDown.getCurrentFrame();

        else if(direction == 4)
            if(refLink.GetKeyManager().attack_key)
                return animAttackEast.getCurrentFrame();
            else
                return animStay.getCurrentFrame();

        else if(direction == 2)
            if(refLink.GetKeyManager().attack_key)
                return animAttackWest.getCurrentFrame();
            else
                return animStay.getCurrentFrame();

        else if(direction == 1)
            if(refLink.GetKeyManager().attack_key)
                return animAttackNorth.getCurrentFrame();
            else
                return animStay.getCurrentFrame();

        else if(direction == 3)
            if(refLink.GetKeyManager().attack_key)
                return animAttackSouth.getCurrentFrame();
            else
                return animStay.getCurrentFrame();
        else
            return animStay.getCurrentFrame();
    }

    //Metoda are rolul de a implementa colectarea cheilor de pe harta si de a contoriza numarul de chei colectate
    private void CollectKeys()
    {
        Rectangle cb = getCollisionBounds(0, 0);//se obtine dreptunghiul de coliziune al jucatorului

        cb.width += 15;
        cb.height += 15;

        for (Item object : refLink.GetMap().getItemManager().GetItems())//se parcurg obiectele
        {
            if (object instanceof Key)//daca obiectul este cheie
            {
                if (object.equals(this))
                    continue;
                if (object.getCollisionBounds(10, 10).intersects(cb))
                {
                    Key key = (Key) object;
                    if (key.isActive())
                    {
                        key.setActive(false);//setez flag-ul false si astfel cheia dispare
                        collectedKeys++;
                    }
                }
            }
        }
    }
    public int GetCollectedKeys() {
        return collectedKeys;
    }
}