package PaooGame.Maps;

import PaooGame.Database.KeysDatabase;
import PaooGame.Items.Enemy;
import PaooGame.Items.Hero;
import PaooGame.Items.Item;
import PaooGame.Items.ItemManager;
import PaooGame.Items.ItemsFactory.Factory;
import PaooGame.Items.Objects.*;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;
import PaooGame.Utils.Utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/*! \class public class Map
    \brief Implementeaza notiunea de harta a jocului.
 */
public class Map
{
    private RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    private int width;          /*!< Latimea hartii in numar de dale. */
    private int height;         /*!< Inaltimea hartii in numar de dale.*/
    private int [][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/
    private int spawnX, spawnY;
    private int level = 1;//se incrementeaza odata cu trecerea la nivelul urmator. Setez valoarea implicita pentru nivel astfel incat jocul sa porneasca de la primul nivel
    //Items
    private ItemManager itemManager;
    private MapItems mapItems;
    private Factory factory;

    /*! \fn public Map(RefLinks refLink)
            \brief Constructorul de initializare al clasei.

            \param refLink O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
         */
    public Map(RefLinks refLink)
    {
        /// Retine referinta "shortcut".
        this.refLink = refLink;
        itemManager = new ItemManager(refLink, new Hero(refLink,100,100));
        factory = new Factory();
        mapItems = new MapItems(refLink, itemManager, factory);
        mapItems.AddLevel1Items();

        SelectAndLoadWorld(level);
    }

    //Actualizeaza harta jocului in functie de evenimente si apeleaza metoda de trecere la urmatorul nivel
    public  void Update()
    {
        GoToTheNextLevel();
        itemManager.Update();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Functia de desenare a hartii.

        \param g Contextul grafic in care se realizeaza desenarea.
     */
    public void Draw(Graphics g)
    {
        int xStart = (int)Math.max(0, refLink.GetGameCamera().getxOffset()/Tile.TILE_WIDTH);
        int xEnd = (int)Math.min(width, (refLink.GetGameCamera().getxOffset() + refLink.GetWidth())/Tile.TILE_WIDTH + 1);
        int yStart = (int)Math.max(0, refLink.GetGameCamera().getyOffset()/Tile.TILE_HEIGHT);
        int yEnd = (int)Math.min(height, (refLink.GetGameCamera().getyOffset() + refLink.GetHeight())/ Tile.TILE_HEIGHT + 1);

        for(int y = yStart; y < yEnd; y++)
        {
            for(int x = xStart; x < xEnd; x++)
            {
                GetTile(x, y).Draw(g, (int)(x * Tile.TILE_WIDTH - refLink.GetGameCamera().getxOffset()), (int)(y * Tile.TILE_HEIGHT - refLink .GetGameCamera().getyOffset()));
            }
        }

        itemManager.Draw(g);
    }

    /*! \fn public Tile GetTile(int x, int y)
        \brief Intoarce o referinta catre dala aferenta codului din matricea de dale.
     */
    public Tile GetTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height)
        {
            return Tile.grassTile;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null) // daca folosesc un id care nu exista atunci se pune pe harta in mod automat un tile de tip water
        {
            return Tile.waterTile;
        }
        return t;
    }

    /*! \fn private void LoadWorld()
        \brief Functie de incarcare a hartii jocului din fisier
     */
    private void LoadWorld(String path)
    {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for(int y = 0; y < height; y++)
            for(int x = 0; x < width; x++)
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);

        itemManager.GetHero().SetX(spawnX); //la fiecare apel al metodei LoadWorld, se da respawn la player
        itemManager.GetHero().SetY(spawnY);
    }

    //Metoda realizeaza selectarea si incarcarea hartii in functie de nivel
    private void SelectAndLoadWorld(int mapId) {
        String path;
        switch(mapId) {
            case 1: // case 1 = level 1;
                path = "res/maps/map1.txt";
                break;
            case 2:  // case 2 = level 2;
                path = "res/maps/map2.txt";
                break;
            case 3:  // case 3 = level 3;
                path = "res/maps/map3.txt";
                break;
            default:
                System.err.println("Invalid map ID specified");
                return;
        }
        LoadWorld(path);
    }

    //Implementeaza trecerea la nivelul urmator si adauga item-uri pe harta nivelului respeciv
    private void GoToTheNextLevel()
    {
        if(itemManager.GetHero().GetX() >= 550 && itemManager.GetHero().GetX() <= 620 && itemManager.GetHero().GetY() >= 130 && itemManager.GetHero().GetY() <= 180)
        {
            if (level == 1 && itemManager.GetHero().GetCollectedKeys() == 2)
            {
                SetNextMap();
                itemManager.GetHero().setLife(250);
                mapItems.AddLevel2Items();
                SelectAndLoadWorld(level);
            }
            else if (level == 2 && itemManager.GetHero().GetCollectedKeys() >= 3)
            {
                SetNextMap();
                itemManager.GetHero().setLife(250);
                mapItems.AddLevel3Items();
                SelectAndLoadWorld(level);
            }
        }
    }

    private void SetNextMap()
    {
        level++;
        itemManager = new ItemManager(refLink, new Hero(refLink, 100, 100));//sterg item-urile de pe harta precedenta prin crearea unui nou manager de item-uri
        mapItems = new MapItems(refLink, itemManager, factory);
    }
    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }
    public ItemManager getItemManager() {
        return itemManager;
    }
    public int GetLevel()
    {
        return level;
    }
    public void SetLevel(int level)
    {
        this.level = level;
    }

}