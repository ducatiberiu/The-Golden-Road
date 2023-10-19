package PaooGame.Tiles.SoilTileEdges;

import PaooGame.Tiles.Tile;
import PaooGame.Graphics.Assets;

public class SoilAndGrassCorner20Tile extends Tile
{
    /*!
        \brief Constructorul de initializare al clasei
        \param id Id-ul dalei util in desenarea hartii.
     */
    public SoilAndGrassCorner20Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.soil_and_grass_corner2, id);
    }

}
