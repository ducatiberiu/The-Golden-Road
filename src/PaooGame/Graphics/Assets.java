package PaooGame.Graphics;

import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc.
    public static BufferedImage background, game_title;
    public static BufferedImage[] playButton;
    public static BufferedImage[] heroStay, heroDown, heroUp, heroLeft, heroRight;
    public static BufferedImage[]  heroAttackNorth, heroAttackSouth, heroAttackEast, heroAttackWest;
    public static BufferedImage[] enemyStay, enemyDown, enemyUp, enemyLeft, enemyRight, enemy2Stay, enemy2Down, enemy2Up, enemy2Left, enemy2Right;
    public static BufferedImage grass, water, soil, tree, wall, key, gate, bush, rock, ruin, ruin2, grass2, grass3, house1, house2;
    public static BufferedImage soil_edge_corner1, soil_edge_corner2, soil_edge_corner3, soil_edge_corner4;
    public static BufferedImage soil_and_grass_corner1, soil_and_grass_corner2, soil_and_grass_corner3, soil_and_grass_corner4;
    public static BufferedImage straight_soil_edge5, straight_soil_edge6, straight_soil_edge7, straight_soil_edge8;

    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

     */
    public static void Init()
    {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        // aici practic se incarca SpriteSheet-ul
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/RPG Nature Tileset.png"));
        SpriteSheet hero = new SpriteSheet(ImageLoader.LoadImage("/textures/hero.png"));
        SpriteSheet key_sprite = new SpriteSheet(ImageLoader.LoadImage("/textures/key.png"));
        SpriteSheet gate_sprite = new SpriteSheet(ImageLoader.LoadImage("/textures/gate.png"));
        SpriteSheet enemy_sprite = new SpriteSheet(ImageLoader.LoadImage("/textures/enemy.png"));
        SpriteSheet play_button_sprite = new SpriteSheet(ImageLoader.LoadImage("/textures/buton verde.png"));
        SpriteSheet ruin_sprite = new SpriteSheet(ImageLoader.LoadImage("/textures/ruin.png"));
        SpriteSheet grass2_sprite = new SpriteSheet(ImageLoader.LoadImage("/textures/grass2.png"));
        SpriteSheet grass3_sprite = new SpriteSheet(ImageLoader.LoadImage("/textures/grass3.png"));
        SpriteSheet ruin2_sprite = new SpriteSheet(ImageLoader.LoadImage("/textures/ruin2.png"));
        SpriteSheet house1_sprite = new SpriteSheet(ImageLoader.LoadImage("/textures/house1.png"));
        SpriteSheet house2_sprite = new SpriteSheet(ImageLoader.LoadImage("/textures/house2.png"));
        SpriteSheet enemy2_sprite = new SpriteSheet(ImageLoader.LoadImage("/textures/enemy2.png"));

        heroStay = new BufferedImage[1];
        heroDown = new BufferedImage[2];
        heroUp = new BufferedImage[2];
        heroLeft = new BufferedImage[4];
        heroRight = new BufferedImage[4];

        heroAttackEast = new BufferedImage[3];
        heroAttackWest = new BufferedImage[3];
        heroAttackNorth = new BufferedImage[4];
        heroAttackSouth = new BufferedImage[4];

        enemyStay = new BufferedImage[1];
        enemyDown = new BufferedImage[2];
        enemyUp = new BufferedImage[2];
        enemyLeft = new BufferedImage[2];
        enemyRight = new BufferedImage[2];

        enemy2Stay = new BufferedImage[1];
        enemy2Down = new BufferedImage[2];
        enemy2Up = new BufferedImage[2];
        enemy2Left = new BufferedImage[2];
        enemy2Right = new BufferedImage[2];

        playButton = new BufferedImage[2];

        /// Se obtin subimaginile corespunzatoare elementelor necesare.
        grass3 = grass3_sprite.crop(0,0,32,32);
        grass2 = grass2_sprite.crop(0,0,32,32);
        grass = sheet.crop(0, 2, 32, 32);
        water = sheet.crop(1,2, 32, 32);
        soil = sheet.crop(2,2, 32,32);
        tree = sheet.crop(0,0, 32, 64);
        wall = sheet.crop(3,2, 32, 32);
        key = key_sprite.crop(0,0, 32, 32);
        gate = gate_sprite.crop(2,3, 56, 64);
        bush = sheet.crop(1,1, 32, 32);
        rock = sheet.crop(2,1, 32, 32);
        ruin = ruin_sprite.crop(0,0,96,96);
        ruin2 = ruin2_sprite.crop(0,0,80,96);
        house1 = house1_sprite.crop(0,0,80,112);
        house2 = house2_sprite.crop(0,0,128,112);

        soil_edge_corner1 = sheet.crop(2,3, 32, 32);
        soil_edge_corner2 = sheet.crop(0,3,32, 32);
        soil_edge_corner3 = sheet.crop(0,5,32, 32);
        soil_edge_corner4 = sheet.crop(2,5,32, 32);

        soil_and_grass_corner1 = sheet.crop(3,3, 32, 32);
        soil_and_grass_corner2 = sheet.crop(4,3, 32, 32);
        soil_and_grass_corner3 = sheet.crop(3,4, 32, 32);
        soil_and_grass_corner4 = sheet.crop(4,4, 32, 32);

        straight_soil_edge5 = sheet.crop(1,5,32, 32);
        straight_soil_edge6 = sheet.crop(2,4,32, 32);
        straight_soil_edge7 = sheet.crop(1,3,32, 32);
        straight_soil_edge8 = sheet.crop(0,4,32, 32);

        heroStay[0] = hero.crop(5,1, 16, 24);

        heroDown[0] = hero.crop(6,5, 16, 24);
        heroDown[1] = hero.crop(8,5, 16, 24);

        heroUp[0] = hero.crop(1,5, 16, 24);
        heroUp[1] = hero.crop(3,5, 16, 24);

        heroLeft[0] = hero.crop(1,7, 16, 24);
        heroLeft[1] = hero.crop(2,7, 16, 24);
        heroLeft[2] = hero.crop(3,7, 16, 24);
        heroLeft[3] = hero.crop(4,7, 16, 24);

        heroRight[0] = hero.crop(5,7, 16, 24);
        heroRight[1] = hero.crop(6,7, 16, 24);
        heroRight[2] = hero.crop(7,7, 16, 24);
        heroRight[3] = hero.crop(8,7, 16, 24);

        heroAttackSouth[0] = hero.crop(0,13, 16, 24);
        heroAttackSouth[1] = hero.crop(2,13, 16, 24);
        heroAttackSouth[2] = hero.crop(3,13, 16, 24);
        heroAttackSouth[3] = hero.crop(5,13, 16, 24);

        heroAttackNorth[0] = hero.crop(6,13, 16, 24);
        heroAttackNorth[1] = hero.crop(8,13, 16, 24);
        heroAttackNorth[2] = hero.crop(9,13, 16, 24);
        heroAttackNorth[3] = hero.crop(11,13, 16, 24);

        heroAttackEast[0] = hero.crop(12,13, 16, 24);
        heroAttackEast[1] = hero.crop(14,13, 16, 24);
        heroAttackEast[2] = hero.crop( 15,13, 16, 24);

        heroAttackWest[0] = hero.crop(18,13, 16, 24);
        heroAttackWest[1] = hero.crop(20,13, 16, 24);
        heroAttackWest[2] = hero.crop(21,13, 16, 24);

        enemyStay[0] = enemy_sprite.crop(1,0, 32, 32);

        enemyDown[0] = enemy_sprite.crop(0,0, 32, 32);
        enemyDown[1] = enemy_sprite.crop(2,0, 32, 32);

        enemyUp[0] = enemy_sprite.crop(0,3, 32, 32);
        enemyUp[1] = enemy_sprite.crop(2, 3,32, 32);

        enemyLeft[0] = enemy_sprite.crop(0,1, 32, 32);
        enemyLeft[1] = enemy_sprite.crop(2,1, 32, 32);

        enemyRight[0] = enemy_sprite.crop(0,2, 32, 32);
        enemyRight[1] = enemy_sprite.crop(2,2, 32, 32);

        enemy2Stay[0] = enemy2_sprite.crop(1,0, 32, 32);

        enemy2Down[0] = enemy2_sprite.crop(0,0, 32, 32);
        enemy2Down[1] = enemy2_sprite.crop(2,0, 32, 32);

        enemy2Up[0] = enemy2_sprite.crop(0,3, 32, 32);
        enemy2Up[1] = enemy2_sprite.crop(2, 3,32, 32);

        enemy2Left[0] = enemy2_sprite.crop(0,1, 32, 32);
        enemy2Left[1] = enemy2_sprite.crop(2,1, 32, 32);

        enemy2Right[0] = enemy2_sprite.crop(0,2, 32, 32);
        enemy2Right[1] = enemy2_sprite.crop(2,2, 32, 32);

        playButton[0] = play_button_sprite.crop(0,0,509,180);
        playButton[1] = play_button_sprite.crop(0,1,509,180);

        background = ImageLoader.LoadImage("/textures/background.png");
        game_title = ImageLoader.LoadImage("/textures/game title.png");
    }
}
