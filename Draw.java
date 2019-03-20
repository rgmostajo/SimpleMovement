import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.awt.Rectangle;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.*;

public class Draw extends JComponent{

	private BufferedImage image;
	private BufferedImage backgroundPic;
	private URL resource = getClass().getResource("run3.png");

	//circle's position
	public int x = 190;
	public int y = 390;
	public int height = 0;
	public int width = 0;
	public int hp = 20;

	//animation states
	public int state = 0;

	// enemy
	LinkedList<Monster> monsterList = new LinkedList<Monster>();

	Monster monster1;
	Monster monster2;
	Monster monster3;

	public Draw(){
		spawnEnemy();

		monster1 = new Monster(475, 390, this);
		monster2 = new Monster(540, 390, this);
		monster3 = new Monster(620, 390, this);

		monsterList.add(monster1);
		monsterList.add(monster2);
		monsterList.add(monster3);
		
		try{
			image = ImageIO.read(resource);
			backgroundPic = ImageIO.read(getClass().getResource("bg1.png"));
		}
		catch(IOException e){
			e.printStackTrace();
		}

		height = image.getHeight();
		width = image.getWidth();

		startGame();
	}

	public void startGame(){
		Thread gameThread = new Thread(new Runnable(){
			public void run(){
				while(true){
					try{
						for(int c = 0; c < monsterList.size(); c++){
							if(monsterList!=null){
								monsterList.get(c).moveTo(x,y);
								repaint();
							}
						}
						Thread.sleep(100);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}
			}
		});
		gameThread.start();
	}

	public void spawnEnemy(){
		Monster monsterCreated = new Monster(740, 390, this);
		monsterList.add(monsterCreated);
		this.repaint();

	}

	public void reloadImage(){
		if(state == 0){
			resource = getClass().getResource("run0.png");
		}
		else if(state == 1){
			resource = getClass().getResource("run1.png");
		}
		else if(state == 2){
			resource = getClass().getResource("run2.png");
		}
		else if(state == 3){
			resource = getClass().getResource("run3.png");
			state = 0;
		}
		else if(state == 4){
			resource = getClass().getResource("run4.png");
		}
		else if(state == 5){
			resource = getClass().getResource("run5.png");
			state = 0;
		}
		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void jumpAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("jump/jump0.png");
						}
						else{
							resource = getClass().getResource("jump/jump"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
	}

	public void attack1Animation(){
		Thread thread2 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("attack1/attack0.png");
						}
						else{
							resource = getClass().getResource("attack1/attack"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				checkCollision();
						for(Monster monster : monsterList){
							if(monster.contact){
								monster.health = monster.health - 10;
							}
						}
			}
		});
		thread2.start();
	}

	public void attack2Animation(){
		Thread thread3 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 6; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("attack2/attack0.png");
						}
						else{
							resource = getClass().getResource("attack2/attack"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				checkCollision();
						for(Monster monster : monsterList){
							if(monster.contact){
								monster.health = monster.health - 10;
							}
						}
			}
		});
		thread3.start();
	}

	public void attack3Animation(){
		Thread thread4 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 6; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("attack3/attack0.png");
						}
						else{
							resource = getClass().getResource("attack3/attack"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				checkCollision();
						for(Monster monster : monsterList){
							if(monster.contact){
								monster.health = monster.health - 10;
							}
						}
			}
		});
		thread4.start();
	}

	public void jump(){
		y = y - 20;
		jumpAnimation();
	}

	public void attack1(){
		attack1Animation();
	}

	public void attack2(){
		attack2Animation();
	}

	public void attack3(){
		attack3Animation();
	}

	public void moveRight(){
		x = x + 5;
		state++;
		repaint();
		reloadImage();
		checkCollision();
	}

	public void moveLeft(){
		x = x - 5;
		state++;
		repaint();
		reloadImage();
		checkCollision();
	}

	public void checkCollision(){
		Rectangle playerBounds = new Rectangle(x, y, image.getWidth(), image.getHeight());
    	for(Monster monsters: monsterList){
    		if(playerBounds.intersects(monsters.getBounds())){
    			monsters.contact = true;
    		}
    	}

    	for(Monster monsters: monsterList){
    	if(monsters.getBounds().intersects(playerBounds)){
    		hp--;
    		}
    	}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backgroundPic, 0, 0, this);
		g.drawImage(image, x, y, this);
		g.setColor(Color.GREEN);
		g.fillRect(5, 5, hp*5, 30);

		g.drawImage(monster1.image, monster1.xPos, monster1.yPos, this);
		g.drawImage(monster2.image, monster2.xPos, monster2.yPos, this);
		g.drawImage(monster3.image, monster3.xPos, monster3.yPos, this);

		for(Monster monster:monsterList){
			g.drawImage(monster.image, monster.xPos, monster.yPos, this);
			g.setColor(Color.GREEN);
			g.fillRect(monster.xPos, monster.yPos-5, monster.health, 5);
	}
}
}