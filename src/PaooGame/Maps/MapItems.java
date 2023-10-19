package PaooGame.Maps;

import PaooGame.Items.Enemy;
import PaooGame.Items.ItemManager;
import PaooGame.Items.ItemsFactory.Factory;
import PaooGame.Items.ItemsFactory.ItemsFactory;
import PaooGame.Items.Objects.*;
import PaooGame.RefLinks;

//Clasa este dedicata obiectelor ce urmeaza a fi adaugate in functie de harta si implicit de nivel
public class MapItems{
    private RefLinks refLink;
    private ItemManager itemManager;
    private Factory factory;

    //Constructorul clasei MapItems
    public MapItems(RefLinks refLink, ItemManager itemManager, Factory factory)
    {
        this.refLink = refLink;
        this.itemManager = itemManager;
        this.factory = factory;
    }

    //Metoda prin care adaug item-uri pe harta primului nivel
    public void AddLevel1Items()
    {
        itemManager.AddItem(factory.CreateItem(refLink, 140,445,"key"));
        itemManager.AddItem(factory.CreateItem(refLink, 1042,445,"key"));
        itemManager.AddItem(factory.CreateItem(refLink, 570, 50, "gate"));
        itemManager.AddItem(factory.CreateItem(refLink, 910, 430, "enemy"));
        itemManager.AddItem(factory.CreateItem(refLink, 300, 430, "enemy"));
        itemManager.AddItem(factory.CreateItem(refLink, 530, 230, "ruin"));

        itemManager.AddItem(factory.CreateItem(refLink, 500, 250, "rock"));
        itemManager.AddItem(factory.CreateItem(refLink, 680, 290, "rock"));
        itemManager.AddItem(factory.CreateItem(refLink, 450, 350, "rock"));

        itemManager.AddItem(factory.CreateItem(refLink, 450, 220, "tree"));
        itemManager.AddItem(factory.CreateItem(refLink, 500, 310, "tree"));
        itemManager.AddItem(factory.CreateItem(refLink, 670, 230, "tree"));
        itemManager.AddItem(factory.CreateItem(refLink, 700, 350, "tree"));
        itemManager.AddItem(factory.CreateItem(refLink, 740, 250, "tree"));
    }

    //Metoda prin care adaug item-uri pe harta nivelului 2
    public void AddLevel2Items()
    {
        itemManager.AddItem(factory.CreateItem(refLink, 570, 50, "gate"));

        //latime sud fara colturi. cheie stanga
        for(int i = 0; i < 6; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 64 + i * 32, 640, "wall"));
        }

        //latime nord fara colturi. cheie stanga
        for(int i = 0; i < 6; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 64 + i * 32, 512, "wall"));
        }

        //lungime vest inclusiv colturile. cheie stanga
        for(int i = 0; i < 4; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 64, 544 + i * 32, "wall"));
        }

        //lungime est inclusiv colturile. cheie stanga
        for(int i = 0; i < 4; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 224, 544 + i * 32, "wall"));
        }

        //latime sud fara colturi. cheie dreapta
        for(int i = 0; i < 6; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 800 + i * 32, 768, "wall"));
        }

        //latime nord fara colturi. cheie dreapta
        for(int i = 0; i < 6; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 800 + i * 32, 576, "wall"));
        }

        //lungime vest inclusiv colturile. cheie dreapta
        for(int i = 0; i < 5; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 800, 608 + i * 32, "wall"));
        }

        //lungime est inclusiv colturile. cheie dreapta
        for(int i = 0; i < 7; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 992, 576 + i * 32, "wall"));
        }

        itemManager.AddItem(factory.CreateItem(refLink, 130,560,"key"));
        itemManager.AddItem(factory.CreateItem(refLink, 880,680,"key"));
        itemManager.AddItem(factory.CreateItem(refLink, 570,310,"key"));
        itemManager.AddItem(factory.CreateItem(refLink, 1100,600,"key"));
        itemManager.AddItem(factory.CreateItem(refLink, 70,200,"key"));

        itemManager.AddItem(factory.CreateItem(refLink, 270,560,"enemy"));
        itemManager.AddItem(factory.CreateItem(refLink, 740,680,"enemy"));

        itemManager.AddItem(factory.CreateItem(refLink, 900, 230, "ruin2"));
        itemManager.AddItem(factory.CreateItem(refLink, 180, 240, "ruin2"));

        itemManager.AddItem(factory.CreateItem(refLink, 150, 700, "tree"));
        itemManager.AddItem(factory.CreateItem(refLink, 700, 500, "tree"));
        itemManager.AddItem(factory.CreateItem(refLink, 320, 240, "tree"));
        itemManager.AddItem(factory.CreateItem(refLink, 900, 240, "tree"));
        itemManager.AddItem(factory.CreateItem(refLink, 470, 50, "tree"));
        itemManager.AddItem(factory.CreateItem(refLink, 300, 30, "tree"));
        itemManager.AddItem(factory.CreateItem(refLink, 700, 40, "tree"));
        itemManager.AddItem(factory.CreateItem(refLink, 640, 350, "tree"));
        itemManager.AddItem(factory.CreateItem(refLink, 550, 350, "tree"));

        itemManager.AddItem(factory.CreateItem(refLink, 64,770,"ruin2"));
        itemManager.AddItem(factory.CreateItem(refLink, 1100,770,"ruin2"));
        itemManager.AddItem(factory.CreateItem(refLink, 50,50,"ruin2"));
        itemManager.AddItem(factory.CreateItem(refLink, 1100,45,"ruin2"));

        itemManager.AddItem(factory.CreateItem(refLink, 600, 135, "enemy2"));

    }

    //Metoda prin care adaug item-uri pe harta nivelului 3
    public void AddLevel3Items()
    {
        itemManager.AddItem(factory.CreateItem(refLink, 150,900,"key"));
        itemManager.AddItem(factory.CreateItem(refLink, 350,630,"key"));
        itemManager.AddItem(factory.CreateItem(refLink, 1000,720,"key"));
        itemManager.AddItem(factory.CreateItem(refLink, 870,1010,"key"));
        itemManager.AddItem(factory.CreateItem(refLink, 1150,550,"key"));
        itemManager.AddItem(factory.CreateItem(refLink, 70,200,"key"));

        itemManager.AddItem(factory.CreateItem(refLink, 300, 910, "enemy"));
        itemManager.AddItem(factory.CreateItem(refLink, 500, 630, "enemy"));
        itemManager.AddItem(factory.CreateItem(refLink, 830,720,"enemy"));
        itemManager.AddItem(factory.CreateItem(refLink, 150, 135, "enemy2"));
        itemManager.AddItem(factory.CreateItem(refLink, 900, 135, "enemy2"));
        itemManager.AddItem(factory.CreateItem(refLink, 570, 50, "gate"));

        //latime sud fara colturi. cheie stanga
        for(int i = 0; i < 6; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 64 + i * 32, 1024, "wall"));
        }

        //latime nord fara colturi. cheie stanga
        for(int i = 0; i < 6; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 64 + i * 32, 832, "wall"));
        }

        //lungime vest inclusiv colturile. cheie stanga
        for(int i = 0; i < 6; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 64, 864 + i * 32, "wall"));
        }

        //lungime est inclusiv colturile. cheie stanga
        for(int i = 0; i < 6; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 224, 864 + i * 32, "wall"));
        }

        //latime sud fara colturi. cheie dreapta
        for(int i = 0; i < 6; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 800 + i * 32, 1120, "wall"));
        }

        //latime nord fara colturi. cheie dreapta
        for(int i = 0; i < 6; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 800 + i * 32, 928, "wall"));
        }

        //lungime vest inclusiv colturile. cheie dreapta
        for(int i = 0; i < 6; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 800, 928 + i * 32, "wall"));
        }

        //lungime est inclusiv colturile. cheie dreapta
        for(int i = 0; i < 7; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 992, 928 + i * 32, "wall"));
        }

        //Celelalte doua chei
        for(int i = 0; i < 6; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 288 + i * 32, 736, "wall"));
        }

        for(int i = 0; i < 6; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 288 + i * 32, 544, "wall"));
        }

        for(int i = 0; i < 5; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 288, 576 + i * 32, "wall"));
        }

        for(int i = 0; i < 5; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 448, 576 + i * 32, "wall"));
        }

        for(int i = 0; i < 6; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 928 + i * 32, 832, "wall"));
        }

        for(int i = 0; i < 6; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 928 + i * 32, 640, "wall"));
        }

        for(int i = 0; i < 6; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 928, 640 + i * 32, "wall"));
        }

        for(int i = 0; i < 7; i++) {
            itemManager.AddItem(factory.CreateItem(refLink, 1120, 640 + i * 32, "wall"));
        }

        itemManager.AddItem(factory.CreateItem(refLink, 190,230,"house2"));
        itemManager.AddItem(factory.CreateItem(refLink, 920,240,"house2"));
        itemManager.AddItem(factory.CreateItem(refLink, 300,40,"house1"));
        itemManager.AddItem(factory.CreateItem(refLink, 840,40,"house1"));
        itemManager.AddItem(factory.CreateItem(refLink, 64,510,"house1"));
        itemManager.AddItem(factory.CreateItem(refLink, 770,520,"house1"));
        itemManager.AddItem(factory.CreateItem(refLink, 750,800,"house1"));
        itemManager.AddItem(factory.CreateItem(refLink, 350,1050,"house1"));

        itemManager.AddItem(factory.CreateItem(refLink, 64,1122,"ruin2"));
        itemManager.AddItem(factory.CreateItem(refLink, 1100,1122,"ruin2"));
        itemManager.AddItem(factory.CreateItem(refLink, 40,45,"ruin2"));
        itemManager.AddItem(factory.CreateItem(refLink, 1100,45,"ruin2"));

        itemManager.AddItem(factory.CreateItem(refLink, 60, 650, "tree"));
        itemManager.AddItem(factory.CreateItem(refLink, 950, 550, "tree"));
        itemManager.AddItem(factory.CreateItem(refLink, 720, 600, "tree"));
        itemManager.AddItem(factory.CreateItem(refLink, 640, 350, "tree"));
        itemManager.AddItem(factory.CreateItem(refLink, 550, 350, "tree"));
    }
}