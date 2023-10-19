package PaooGame.Items.Objects;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class Ruin extends Objects{
    //Constructor ce apeleaza constructorul clasei de baza si seteaza dimensiunile dreptunghiului de coliziune
    public Ruin(RefLinks refLink, float x, float y)
    {
        super(refLink, x, y, Tile.TILE_WIDTH*5, Tile.TILE_HEIGHT*5);

        bounds.x = 10;
        bounds.y = 60;
        bounds.width = 120;
        bounds.height = 100;
        life = 1000;
    }

    @Override
    public void Update()
    {

    }
    @Override
    public void Die() {

    }

    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(Assets.ruin, (int)(x - refLink.GetGameCamera().getxOffset()), (int)(y - refLink.GetGameCamera().getyOffset()), width, height, null);

        // pentru vizualizarea dreptunghiului de coliziune
        //g.setColor(Color.red);
        //g.fillRect((int)(x + bounds.x - refLink.GetGameCamera().getxOffset()), (int)(y + bounds.y - refLink.GetGameCamera().getyOffset()), bounds.width, bounds.height);
    }
}
