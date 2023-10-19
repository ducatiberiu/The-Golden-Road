package PaooGame.UI;

import java.awt.*;
import java.awt.event.MouseEvent;

//Clasa va contine componentele de baza ale interfetei cu utilizatorul
public abstract class UIElement {

    protected float x, y;
    protected int width, height;
    protected boolean over = false;
    protected Rectangle bounds;

    //Constructorul clasei UIElement ce seteaza dimensiunile unui element UI si construieste dreptunghiul de coliziune
    public UIElement(float x, float y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle((int) x, (int) y, width, height);
    }

    //Metoda ce realizeaza actualizarea unui element UI
    public abstract void Update();

    //Metoda ce realizeaza randarea unui element UI
    public abstract void Draw(Graphics g);

    //Metoda ce realizeaza diferite actiuni in momentul in care se apasa click
    public abstract void onClick();

    //Detecteaza daca mouse-ul este plasat pe un buton sau nu
    public void onMouseMove(MouseEvent e)
    {
        if(bounds.contains(e.getX(), e.getY()))
            over = true;
        else
            over = false;
    }

    //Detecteaza daca s-a eliberat butonul de click si apeleaza metoda onClick
    public void onMouseRelease(MouseEvent e)
    {
        if(over)
            onClick();
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
}
