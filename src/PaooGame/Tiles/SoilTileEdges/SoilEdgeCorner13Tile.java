package PaooGame.Tiles.SoilTileEdges;

import PaooGame.Tiles.Tile;
import PaooGame.Graphics.Assets;

public class SoilEdgeCorner13Tile extends Tile
{
    /*!
        \brief Constructorul de initializare al clasei
        \param id Id-ul dalei util in desenarea hartii.
     */
    public SoilEdgeCorner13Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.soil_edge_corner3, id);
    }

}
