package PaooGame.Tiles.SoilTileEdges;

import PaooGame.Tiles.Tile;
import PaooGame.Graphics.Assets;

public class SoilAndGrassCorner21Tile extends Tile
{
    /*!
        \brief Constructorul de initializare al clasei
        \param id Id-ul dalei util in desenarea hartii.
     */
    public SoilAndGrassCorner21Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.soil_and_grass_corner3, id);
    }

}
