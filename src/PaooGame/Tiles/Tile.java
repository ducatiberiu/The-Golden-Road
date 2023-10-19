package PaooGame.Tiles;

import PaooGame.Tiles.SoilTileEdges.*;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Tile
    \brief Retine toate dalele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */
public class Tile
{
    private static final int NO_TILES   = 32;
    public static Tile[] tiles          = new Tile[NO_TILES];       /*!< Vector de referinte de tipuri de dale.*/

        /// Urmatoarele dale sunt statice si publice. Acest lucru ne permite sa le avem incarcate
        /// o singura data in memorie
    public static Tile grassTile        = new GrassTile(0);     /*!< Dala de tip iarba*/
    public static Tile waterTile        = new WaterTile(1);     /*!< Dala de tip apa*/
    public static Tile WaterTile = new WaterTile(9);
    public static Tile SoilTile = new SoilTile(10);      /*!< Dala de tip sol*/
    public static Tile SoilEdgeCorner11Tile = new SoilEdgeCorner11Tile(11);
    public static Tile SoilEdgeCorner12Tile = new SoilEdgeCorner12Tile(12);
    public static Tile SoilEdgeCorner13Tile = new SoilEdgeCorner13Tile(13);
    public static Tile SoilEdgeCorner14Tile = new SoilEdgeCorner14Tile(14);

    public static Tile StraightSoilEdgeTile15 = new StraightSoilEdgeTile15(15);
    public static Tile StraightSoilEdgeTile16 = new StraightSoilEdgeTile16(16);
    public static Tile StraightSoilEdgeTile17 = new StraightSoilEdgeTile17(17);
    public static Tile StraightSoilEdgeTile18 = new StraightSoilEdgeTile18(18);
    public static Tile SoilAndGrassCorner19Tile = new SoilAndGrassCorner19Tile(19);
    public static Tile SoilAndGrassCorner20Tile = new SoilAndGrassCorner20Tile(20);
    public static Tile SoilAndGrassCorner21Tile = new SoilAndGrassCorner21Tile(21);
    public static Tile SoilAndGrassCorner22Tile = new SoilAndGrassCorner22Tile(22);
    public static Tile Grass2Tile = new Grass2Tile(23);
    public static Tile Grass3Tile = new Grass3Tile(24);

    public static final int TILE_WIDTH  = 32;                       /*!< Latimea unei dale.*/
    public static final int TILE_HEIGHT = 32;                       /*!< Inaltimea unei dale.*/
    protected BufferedImage img;                                    /*!< Imaginea aferenta tipului de dala.*/
    protected final int id;                                         /*!< Id-ul unic aferent tipului de dala.*/

    /*! \fn public Tile(BufferedImage texture, int id)
        \brief Constructorul aferent clasei.

        \param image Imaginea corespunzatoare dalei.
        \param id Id-ul dalei.
     */
    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;

        tiles[id] = this;
    }

    /*! \fn public void Update()
        \brief Actualizeaza proprietatile dalei.
     */
    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g, int x, int y)
        \brief Deseneaza in fereastra dala.

        \param g Contextul grafic in care sa se realizeze desenarea
        \param x Coordonata x in cadrul ferestrei unde sa fie desenata dala
        \param y Coordonata y in cadrul ferestrei unde sa fie desenata dala
     */
    public void Draw(Graphics g, int x, int y)
    {
            /// Desenare dala
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    /*! \fn public boolean IsSolid()
        \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
     */
    public boolean IsSolid()
    {
        return false;
    }

    /*! \fn public int GetId()
        \brief Returneaza id-ul dalei.
     */
    public int GetId()
    {
        return id;
    }
}
