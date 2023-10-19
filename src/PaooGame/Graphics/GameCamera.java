package PaooGame.Graphics;

import PaooGame.Game;
import PaooGame.Items.Item;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

public class GameCamera {
    private RefLinks refLink;
    private float xOffset, yOffset;

    //Constructor de initializare al clasei GameCamera
    public GameCamera(RefLinks refLink, float xOffset, float yOffset)
    {
        this.refLink = refLink;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    //Stabileste limitele camerei astfel incat sa se randeze in functie de dimensiunea hartii
    public void checkBlanckSpace()
    {
        if(xOffset < 0)
        {
            xOffset = 0;//Ajustare stanga
        }
        else if(xOffset > refLink.GetMap().getWidth() * Tile.TILE_WIDTH - refLink.GetWidth())
        {
            //Ajustare dreapta
            xOffset = refLink.GetMap().getWidth() * Tile.TILE_WIDTH - refLink.GetWidth();//xOffset este setat cu diferenta dintre latimea hartii si cea a ferestrei jocullui
        }

        if(yOffset < 0)
        {
            yOffset = 0;//Ajustare sus
        }
        else if (yOffset > refLink.GetMap().getHeight() * Tile.TILE_HEIGHT - refLink.GetHeight())
        {
            //Ajustare jos
            yOffset = refLink.GetMap().getHeight() * Tile.TILE_HEIGHT - refLink.GetHeight();//yOffset este setat cu diferenta dintre inaltimea hartii si cea a ferestrei jocullui
        }
    }

    //Mentine centrul camerei pe jucator
    public void centerOnItem(Item e)
    {
        xOffset = e.GetX() - refLink.GetWidth()/2 + e.GetWidth()/2;
        yOffset = e.GetY() - refLink.GetHeight()/2 + e.GetHeight()/2;
        checkBlanckSpace();
    }
    public void move(float xAmt, float yAmt)
    {
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlanckSpace();
    }

    public void setxOffset(float xOffset)
    {
        this.xOffset = xOffset;
    }
    public float getxOffset()
    {
        return xOffset;
    }

    public void setyOffset(float yOffset)
    {
        this.yOffset = yOffset;
    }
    public float getyOffset()
    {
        return yOffset;
    }

}
