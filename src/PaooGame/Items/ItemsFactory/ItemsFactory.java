package PaooGame.Items.ItemsFactory;

import PaooGame.Items.Item;
import PaooGame.RefLinks;

public interface ItemsFactory {
    public Item CreateItem(RefLinks refLink, float x, float y, String type);
}
