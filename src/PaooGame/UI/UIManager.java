package PaooGame.UI;

import PaooGame.RefLinks;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager {
    private RefLinks reflink;
    private ArrayList<UIElement> elements;

    public UIManager(RefLinks reflink)
    {
        this.reflink = reflink;
        elements = new ArrayList<UIElement>();
    }

    public void Update()
    {
        for(UIElement el : elements)
            el.Update();
    }

    public void Draw(Graphics g)
    {
        for(UIElement el : elements)
            el.Draw(g);
    }

    public void onMouseMove(MouseEvent e)
    {
        for(UIElement el : elements)
            el.onMouseMove(e);
    }

    public ArrayList<UIElement> getElements() {
        return elements;
    }

    public void setElements(ArrayList<UIElement> elements) {
        this.elements = elements;
    }

    public RefLinks getReflink() {
        return reflink;
    }

    public void setReflink(RefLinks reflink) {
        this.reflink = reflink;
    }

    public void onMouseRelease(MouseEvent e)
    {
        for(UIElement el : elements)
            el.onMouseRelease(e);
    }

    public void addElement(UIElement el)
    {
        elements.add(el);
    }

    public void removeElement(UIElement el)
    {
        elements.remove(el);
    }
}
