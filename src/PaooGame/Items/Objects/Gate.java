package PaooGame.Items.Objects;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class Gate extends Objects{
    //Constructor ce apeleaza constructorul clasei de baza si seteaza dimensiunile dreptunghiului de coliziune
    public Gate(RefLinks refLink, float x, float y)
    {
        super(refLink, x, y, Tile.TILE_WIDTH+40, Tile.TILE_HEIGHT+55);

        bounds.x = 5;
        bounds.y = 5;
        bounds.width = 60;
        bounds.height = 80;
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
        g.drawImage(Assets.gate, (int)(x - refLink.GetGameCamera().getxOffset()), (int)(y - refLink.GetGameCamera().getyOffset()), width, height, null);

        // pentru vizualizarea dreptunghiului de coliziune
        //g.setColor(Color.red);
        //g.fillRect((int)(x + bounds.x - refLink.GetGameCamera().getxOffset()), (int)(y + bounds.y - refLink.GetGameCamera().getyOffset()), bounds.width, bounds.height);
    }
}
