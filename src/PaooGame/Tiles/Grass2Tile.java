package PaooGame.Tiles;

import PaooGame.Graphics.Assets;
public class Grass2Tile extends Tile
{
    /*!
        \brief Constructorul de initializare al clasei
        \param id Id-ul dalei util in desenarea hartii.
     */
    public Grass2Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.grass2, id);
    }
}
