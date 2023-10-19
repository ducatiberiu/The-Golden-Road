package PaooGame.States;

import java.awt.*;
import PaooGame.RefLinks;

/*! \class State
    \brief Implementeaza notiunea abstracta de stare a jocului/programului.
 */
public abstract class State
{
    ///Urmatoarele atribute sunt statice pentru a evita dealocarea spatiului de memorie la trecerea dintr-o stare in alta.
    private static State previousState  = null; /*!< Referinta catre starea anterioara a jocului.*/
    private static State currentState   = null; /*!< Referinta catre starea curenta a jocului: game, meniu, settings, about etc.*/
    protected RefLinks refLink;
    protected final Font textFont, youWonFont;
    public State(RefLinks refLink)
    {
        this.refLink = refLink;
        textFont = new Font("Cambria", Font.PLAIN, 25);
        youWonFont = new Font("Stencil", Font.PLAIN, 60);
    }

    /*! \fn public static void SetState(State state)
        \brief Seteaza starea curenta a jocului.

        \param state Noua stare a programului (jocului).
     */
    public static void SetState(State state)
    {
        previousState = currentState;
        currentState = state;
    }

    public static State GetState()
    {
        return currentState;
    }

    ///Metoda abstracta destinata actualizarii starii curente
    public abstract void Update();
    ///Metoda abstracta destinata desenarii starii curente
    public abstract void Draw(Graphics g);

}
