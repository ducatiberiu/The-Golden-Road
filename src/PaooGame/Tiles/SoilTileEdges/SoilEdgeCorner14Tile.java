package PaooGame.Tiles.SoilTileEdges;

import PaooGame.Tiles.Tile;
import PaooGame.Graphics.Assets;

public class SoilEdgeCorner14Tile extends Tile
{
    /*!
        \brief Constructorul de initializare al clasei
        \param id Id-ul dalei util in desenarea hartii.
     */
    public SoilEdgeCorner14Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.soil_edge_corner4, id);
    }

}
