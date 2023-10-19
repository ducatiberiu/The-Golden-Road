package PaooGame.Input;

import PaooGame.UI.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftPressed, rightPressed;
    private int mouseXPoz, mouseYPoz;
    private UIManager uiManager;
    public MouseManager()
    {

    }

    //Seteaza flag-ul true in cazul in care a fost apasat un buton al mouse-ului(click stanga/click dreapta)
    @Override
    public void mousePressed(MouseEvent e)
    {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftPressed = true;
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed = true;
    }

    //Seteaza flag-ul false in cazul in care a fost eliberat un buton al mouse-ului(click stanga/click dreapta)
    //si apeleaza metoda onMouseRelease din clasa UIManager
    @Override
    public void mouseReleased(MouseEvent e)
    {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftPressed = false;
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed = false;

        if(uiManager != null)
            uiManager.onMouseRelease(e);
    }

    //Actualizeaza pozitia mouse-ului si apeleaza metoda onMouseMove din clasa UIManager
    //si apeleaza metoda onMouseMove din clasa UIManager
    @Override
    public void mouseMoved(MouseEvent e)
    {
        mouseXPoz = e.getX();
        mouseYPoz = e.getY();

        if(uiManager != null)
            uiManager.onMouseMove(e);
    }

    public void setUiManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }
    public boolean isLeftPressed(){
        return leftPressed;
    }
    public boolean isRightPressed() {
        return rightPressed;
    }
    public int getMouseXPoz() {
        return mouseXPoz;
    }
    public int getMouseYPoz() {
        return mouseYPoz;
    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
