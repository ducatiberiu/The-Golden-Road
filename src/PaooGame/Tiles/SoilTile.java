package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip sol.
 */
public class SoilTile extends Tile
{
    /*
        \brief Constructorul de initializare al clasei
        \param id Id-ul dalei util in desenarea hartii.
     */
    public SoilTile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.soil, id);
    }
}
