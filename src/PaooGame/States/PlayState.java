package PaooGame.States;

import PaooGame.Database.Database;
import PaooGame.Database.KeysDatabase;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;
import PaooGame.Game;
import PaooGame.Tiles.Tile;

import java.awt.*;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    private int KeysFromDB;
    private KeysDatabase keysDatabase;
    private Database database;
    private Map map;    /*!< Referinta catre harta curenta.*/

    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza
        super(refLink);
        database = new Database();
        keysDatabase = new KeysDatabase();
        ///Construieste harta jocului
        map = new Map(refLink);
        ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului si verifica daca a fost apasata tasta de SAVE sau tasta de LOAD
     */
    @Override
    public void Update()
    {
        KeysFromDB = keysDatabase.NumberOfKeys(map);
        map.Update();
        if(refLink.GetKeyManager().save)
            database.SaveLevelStatus(map);
        else if(refLink.GetKeyManager().load)
            database.LoadLevelStatus(map);
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        map.Draw(g);
        g.setFont(textFont);
        g.setColor(Color.ORANGE);
        g.drawImage(Assets.key, Tile.TILE_WIDTH / 2, Tile.TILE_HEIGHT / 2, 45, 45, null);
        g.drawString("x " + refLink.GetMap().getItemManager().GetHero().GetCollectedKeys(), 55, 45);
        if(KeysFromDB > 8 && map.GetLevel() == 3) {
            g.setFont(youWonFont);
            g.drawString("YOU WON", 220, 200);
        }
    }
}
