package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip apa.
 */
public class WaterTile extends Tile
{
    /*
        \brief Constructorul de initializare al clasei
        \param id Id-ul dalei util in desenarea hartii.
     */
    public WaterTile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.water, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
