package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class Grass3Tile extends Tile
{
    /*
        \brief Constructorul de initializare al clasei
        \param id Id-ul dalei util in desenarea hartii.
     */
    public Grass3Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.grass3, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
