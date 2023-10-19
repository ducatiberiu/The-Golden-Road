package PaooGame.UI;

import java.awt.*;
import java.awt.image.BufferedImage;
//Clasa implementeaza un element UI din punct de vedere grafic(imagine)
public class UIImages extends UIElement{
    private BufferedImage[] images;
    private ClickListener clicker;
    //Constructorul de initializare al clasei UIImages
    public UIImages(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker)
    {
        super(x, y, width, height);
        this.clicker = clicker;
        this.images = images;
    }

    @Override
    public void Update()
    {

    }

    //Metoda ce realizeaza randarea unui element UI.Acesta contine doua imagini, randate in functie de pozitia mouse-ului
    @Override
    public void Draw(Graphics g)
    {
        if(over)
            g.drawImage(images[1], (int) x, (int) y, width, height, null);
        else
            g.drawImage(images[0], (int) x, (int) y, width, height, null);
    }

    @Override
    public void onClick()
    {
        clicker.onClick();
    }
}
