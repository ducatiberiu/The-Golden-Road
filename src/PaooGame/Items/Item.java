package PaooGame.Items;

import PaooGame.RefLinks;

import java.awt.*;

/*! \class Item
    \brief. Implementeaza notiunea abstracta de entitate activa din joc, "element cu care se poate interactiona: monstru, turn etc.".
 */
public abstract class Item
{
    protected float x;                  /*!< Pozitia pe axa X a "tablei" de joc a imaginii entitatii.*/
    protected float y;                  /*!< Pozitia pe axa Y a "tablei" de joc a imaginii entitatii.*/
    protected int width;                /*!< Latimea imaginii entitatii.*/
    protected int height;               /*!< Inaltimea imaginii entitatii.*/
    protected Rectangle bounds;         /*!< Dreptunghiul curent de coliziune.*/
    protected int life;
    public static final int DEFAULT_LIFE = 10;
    protected boolean active = true; // cand active va fi setat false in clasa ItemManager, atunci acel item va disparea
    public boolean isActive() {return active;}
    public void setActive(boolean active) {
        this.active = active;
    }
    public int getLife() {
        return life;
    } // Returneaza viata caracterului.
    public void setLife(int life) {
        this.life = life;
    } // Seteaza viata caracterului.

    protected RefLinks refLink;         /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/

    /*! \fn public Item(RefLinks refLink, float x, float y, int width, int height)
        \brief Constructor de initializare al clasei

        \param  reflink Referinte "shortcut" catre alte referinte
        \param  x   Pozitia pe axa X a "tablei" de joc a imaginii entitatii.
        \param  y   Pozitia pe axa Y a "tablei" de joc a imaginii entitatii.
        \param  width   Latimea imaginii entitatii.
        \param  height  Inaltimea imaginii entitatii.
     */
    public Item(RefLinks refLink, float x, float y, int width, int height)
    {
        this.x = x;             /*!< Retine coordonata pe axa X.*/
        this.y = y;             /*!< Retine coordonata pe axa X.*/
        this.width = width;     /*!< Retine latimea imaginii.*/
        this.height = height;   /*!< Retine inaltimea imaginii.*/
        this.refLink = refLink; /*!< Retine the "shortcut".*/
        life    = DEFAULT_LIFE;

        bounds = new Rectangle(0, 0, width, height);
    }

    public abstract void Die(); // e declarat abstract pt ca fiecare item trebuie sa contina propria metoda "Die"

    //Scade viata item-ului cu o anumita valoare si seteaza flag-ul active ca fiind false rezultand eliminarea item-ului de pe harta
    public void Hurt(int amount) // din membrul life se scade o anumita valoare(amount) si astfel scade viata item-ului
    {
        life = life - amount;
        if(life <= 0) // daca viata e 0 sau sub 0 atunci acel item "moare" si dispare de pe harta
        {
            active = false;
            Die();
        }
    }

    ///Metoda abstracta destinata actualizarii starii curente
    public abstract void Update();
    ///Metoda abstracta destinata desenarii starii curente
    public abstract void Draw(Graphics g);

    //Verifica daca doua obiecte de tip Item se afla in coliziune
    public boolean checkItemCollisions(float xOffset, float yOffset)
    {
        for(Item object : refLink.GetMap().getItemManager().GetItems())
        {
            if(object.equals(this))
                continue;
            if(object.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset, yOffset)))
                return true;
        }
        return false;
    }

    //Returneaza un obiect de tip rectangle ce reprezinta aria de coliziune a unui item
    public Rectangle getCollisionBounds(float xOffset, float yOffset)
    {
        return new Rectangle((int)(x + bounds.x + xOffset), (int)(y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    /*! \fn public float GetX()
        \brief Returneaza coordonata pe axa X.
     */
    public float GetX()
    {
        return x;
    }

    /*! \fn public float GetY()
        \brief Returneaza coordonata pe axa Y.
     */
    public float GetY()
    {
        return y;
    }

    /*! \fn public float GetWidth()
        \brief Returneaza latimea entitatii.
     */
    public int GetWidth()
    {
        return width;
    }

    /*! \fn public float GetHeight()
        \brief Returneaza inaltimea entitatii.
     */
    public int GetHeight()
    {
        return height;
    }

    /*! \fn public float SetX()
        \brief Seteaza coordonata pe axa X.
     */
    public void SetX(float x)
    {
        this.x = x;
    }

    /*! \fn public float SetY()
        \brief Seteaza coordonata pe axa Y.
     */
    public void SetY(float y)
    {
        this.y = y;
    }

    /*! \fn public float SetWidth()
        \brief Seteaza latimea imaginii entitatii.
     */
    public void SetWidth(int width)
    {
        this.width = width;
    }

    /*! \fn public float SetHeight()
        \brief Seteaza inaltimea imaginii entitatii.
     */
    public void SetHeight(int height)
    {
        this.height = height;
    }

}
