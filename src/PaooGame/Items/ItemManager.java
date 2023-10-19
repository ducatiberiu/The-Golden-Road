package PaooGame.Items;

import PaooGame.Items.Objects.Gate;
import PaooGame.RefLinks;

import java.awt.*;
import java.util.ArrayList;
import PaooGame.Items.Objects.Key;
import java.util.Iterator;
//Clasa reprezinta un "mananger" al item-urilor deoarece se ocupa cu gestionarea actualizarii si randarii acestora
public class ItemManager {
    private RefLinks refLink;
    private Hero hero;
    private ArrayList<Item> objects;

    //Constructorul clasei ItemManager
    public ItemManager(RefLinks refLink, Hero hero)
    {
        this.refLink = refLink;
        this.hero = hero;
        objects = new ArrayList<Item>();
        AddItem(hero);
    }

    //Metoda de actualizare prin care se itereaza prin obiectele de tip Item, iar pentru fiecare obiect se apeleaza metoda Update
    //si totodata elimina din joc obiectele inactive
    public void Update()
    {
        Iterator<Item> it = objects.iterator();
        while(it.hasNext())
        {
            Item object = it.next();
            object.Update();
            if(!object.isActive())
                it.remove();
        }
    }

    //Metoda de randare prin care se itereaza prin obiectele de tip Item, iar pentru fiecare obiect se apeleaza metoda Draw
    public void Draw(Graphics g)
    {
        for(int i = 0; i < objects.size(); i++)
        {
            Item object = objects.get(i);
            object.Draw(g);
        }
    }

    public void AddItem(Item object)
    {
        objects.add(object);
    }

    public RefLinks GetRefLink(){return refLink;}
    public Hero GetHero(){return hero;}
    public ArrayList<Item> GetItems(){return objects;}
    public void SetReflinks(RefLinks refLink){this.refLink = refLink;}
    public void SetHero(Hero hero){this.hero = hero;}
    public void SetItems(ArrayList<Item> objects){this.objects = objects;}
}