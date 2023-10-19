package PaooGame.Tiles.SoilTileEdges;

import PaooGame.Tiles.Tile;
import PaooGame.Graphics.Assets;

public class StraightSoilEdgeTile18 extends Tile
{
    /*
       \brief Constructorul de initializare al clasei
        \param id Id-ul dalei util in desenarea hartii.
     */
    public StraightSoilEdgeTile18(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.straight_soil_edge8, id);
    }
}
