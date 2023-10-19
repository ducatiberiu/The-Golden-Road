package PaooGame.Items.Objects;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class Key extends Objects{
    //Constructor ce apeleaza constructorul clasei de baza si seteaza dimensiunile dreptunghiului de coliziune
    public Key(RefLinks refLink, float x, float y)
    {
        super(refLink, x, y, Tile.TILE_WIDTH*2, Tile.TILE_HEIGHT+10);

        bounds.x = 27;
        bounds.y = 5;
        bounds.width = 10;
        bounds.height = 32;
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
        g.drawImage(Assets.key, (int) (x - refLink.GetGameCamera().getxOffset()), (int) (y - refLink.GetGameCamera().getyOffset()), width, height, null);

        // pentru vizualizarea dreptunghiului de coliziune
        //g.setColor(Color.red);
        //g.fillRect((int)(x + bounds.x - refLink.GetGameCamera().getxOffset()), (int)(y + bounds.y - refLink.GetGameCamera().getyOffset()), bounds.width, bounds.height);
    }
}
