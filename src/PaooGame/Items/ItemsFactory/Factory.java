package PaooGame.Items.ItemsFactory;

import PaooGame.Items.Enemy;
import PaooGame.Items.Enemy2;
import PaooGame.Items.Hero;
import PaooGame.Items.Item;
import PaooGame.Items.Objects.*;
import PaooGame.RefLinks;

public class Factory implements ItemsFactory{
    //Returneaza un item conform valorii argumentului type.
    @Override
    public Item CreateItem(RefLinks refLink, float x, float y, String type)
    {
        switch (type)
        {
            case "tree":
                return new Tree(refLink, x, y);
            case "bush":
                return new Bush(refLink, x, y);
            case "rock":
                return new Rock(refLink, x, y);
            case "gate":
                return new Gate(refLink, x, y);
            case "key":
                return new Key(refLink, x, y);
            case "wall":
                return new Wall(refLink, x, y);
            case "enemy":
                return new Enemy(refLink, x, y);
            case "enemy2":
                return new Enemy2(refLink, x, y);
            case "hero":
                return new Hero(refLink, x, y);
            case "ruin":
                return new Ruin(refLink, x, y);
            case "ruin2":
                return new Ruin2(refLink, x, y);
            case "house1":
                return new House1(refLink, x, y);
            case "house2":
                return new House2(refLink, x, y);
            default:
                return null;
        }
    }
}
