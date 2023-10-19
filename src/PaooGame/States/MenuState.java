package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIImages;
import PaooGame.UI.UIManager;

import java.awt.*;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */
public class MenuState extends State
{
    private UIManager uiManager;

    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public MenuState(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza.
        super(refLink);
        uiManager = new UIManager(refLink);
        refLink.GetMouseManager().setUiManager(uiManager);

        uiManager.addElement(new UIImages(250, 170, 200, 70, Assets.playButton, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUiManager(null);
                State.SetState(refLink.GetGame().playState);
            }
        }));
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {
        uiManager.Update();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(Assets.background, 0,0,700,480,null);// desenez imaginea de background a meniu-ului
        g.drawImage(Assets.game_title, 70, 10, 550,120,null);
        uiManager.Draw(g);
    }
}
