package PaooGame.Tiles.SoilTileEdges;

import PaooGame.Tiles.Tile;
import PaooGame.Graphics.Assets;

public class StraightSoilEdgeTile16 extends Tile
{
    /*!
        \brief Constructorul de initializare al clasei
        \param id Id-ul dalei util in desenarea hartii.
     */
    public StraightSoilEdgeTile16(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.straight_soil_edge6, id);
    }
}
