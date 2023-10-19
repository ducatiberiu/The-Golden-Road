package PaooGame.Items.Objects;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class Wall extends Objects{
    //Constructor ce apeleaza constructorul clasei de baza si seteaza dimensiunile dreptunghiului de coliziune
    public Wall(RefLinks refLink, float x, float y)
    {
        super(refLink, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 32;
        bounds.height = 32;
        life = 15;
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
        g.drawImage(Assets.wall, (int)(x - refLink.GetGameCamera().getxOffset()), (int)(y - refLink.GetGameCamera().getyOffset()), width, height, null);

        // pentru vizualizarea dreptunghiului de coliziune
        //g.setColor(Color.red);
        //g.fillRect((int)(x + bounds.x - refLink.GetGameCamera().getxOffset()), (int)(y + bounds.y - refLink.GetGameCamera().getyOffset()), bounds.width, bounds.height);
    }
}
