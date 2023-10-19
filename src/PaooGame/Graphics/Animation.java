package PaooGame.Graphics;

import java.awt.image.BufferedImage;

public class Animation {
    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] frames;

    //Constructor de initializare al clasei Animation
    public Animation(int speed, BufferedImage[] frames)
    {
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    //Actualizeaza frame-ul animatiilor
    public void Update()
    {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > speed)
        {
            index++;
            timer = 0;
            if(index >= frames.length)
                index = 0;// se reia animatia de la primul frame
        }
    }
    //Returneaza frame-ul curent corespunzator index-ului
    public BufferedImage getCurrentFrame()
    {
        return frames[index];
    }
}
