package PaooGame.Items.Objects;

import PaooGame.Items.Item;
import PaooGame.RefLinks;

public abstract class Objects extends Item {
    //Constructor ce apeleaza constructorul clasei de baza
    public Objects(RefLinks refLink, float x, float y, int width, int height)
    {
        super(refLink, x, y, width, height);
    }
}
