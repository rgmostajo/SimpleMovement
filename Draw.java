import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

public class Draw extends JComponent{

	private BufferedImage image;
	private BufferedImage backgroundPic;
	private URL resource = getClass().getResource("run3.png");

	//circle's position
	public int x = 30;
	public int y = 30;
	public int height = 0;
	public int width = 0;

	//animation states
	public int state = 0;

	public Random randomizer;

	// enemy
	public int enemyCount;
	Monster[] monsters = new Monster[10];

	public Draw(){
		randomizer = new Random();
		spawnEnemy();
		
		try{
			image = ImageIO.read(resource);
			backgroundPic = ImageIO.read(getClass().getResource("backgroundforest.jpg"));
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
						for(int c = 0; c < monsters.length; c++){
							if(monsters[c]!=null){
								monsters[c].moveTo(x,y);
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
		if(enemyCount < 10){
			monsters[enemyCount] = new Monster(randomizer.nextInt(500), randomizer.nextInt(333), this);
			enemyCount++;
		}
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

	public void smrsltAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("somersault/smrslt0.png");
						}
						else{
							resource = getClass().getResource("somersault/smrslt"+ctr+".png");
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

	public void jumpAnimation(){
		Thread thread2 = new Thread(new Runnable(){
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
		thread2.start();
	}

	public void crouchAnimation(){
		Thread thread3 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("crouch/crouch0.png");
						}
						else{
							resource = getClass().getResource("crouch/crouch"+ctr+".png");
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
		thread3.start();
	}

	public void attack1Animation(){
		Thread thread4 = new Thread(new Runnable(){
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

				for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 10;
						}
					}
				}
			}
		});
		thread4.start();
	}

	public void attack2Animation(){
		Thread thread5 = new Thread(new Runnable(){
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

				for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 10;
						}
					}
				}
			}
		});
		thread5.start();
	}

	public void attack3Animation(){
		Thread thread6 = new Thread(new Runnable(){
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

				for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 10;
						}
					}
				}
			}
		});
		thread6.start();
	}

	public void dieAnimation(){
		Thread thread7 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 7; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("die/die0.png");
						}
						else{
							resource = getClass().getResource("die/die"+ctr+".png");
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
		thread7.start();
	}

	public void slideAnimation(){
		Thread thread8 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 2; ctr++){
					try {
						if(ctr==4){
							resource = getClass().getResource("slide/slide0.png");
						}
						else{
							resource = getClass().getResource("slide/slide"+ctr+".png");
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
		thread8.start();
	}

	public void crouch(){
		crouchAnimation();
	}

	public void jump(){
		y = y - 20;
		jumpAnimation();
	}

	public void smrslt(){
		x = x + 10;
		smrsltAnimation();
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

	public void die(){
		dieAnimation();
	}

	public void slide(){
		x = x + 20;
		slideAnimation();
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

	public void moveDown(){
		y = y + 5;
		state++;
		repaint();
		reloadImage();
		checkCollision();
	}

	public void moveUp(){
		y = y - 5;
		state++;
		repaint();
		reloadImage();
		checkCollision();
	}

	public void checkCollision(){
		int xChecker = x + width;
		int yChecker = y;

		for(int x=0; x<monsters.length; x++){
			boolean collideX = false;
			boolean collideY = false;

			if(monsters[x]!=null){
				monsters[x].contact = false;

				if(yChecker > monsters[x].yPos){
					if(yChecker-monsters[x].yPos < monsters[x].height){
						collideY = true;
						System.out.println("collideY");
					}
				}
				else{
					if(monsters[x].yPos - (yChecker+height) < monsters[x].height){
						collideY = true;
						System.out.println("collideY");
					}
				}

				if(xChecker > monsters[x].xPos){
					if((xChecker-width)-monsters[x].xPos < monsters[x].width){
						collideX = true;
						System.out.println("collideX");
					}
				}
				else{
					if(monsters[x].xPos-xChecker < monsters[x].width){
						collideX = true;
						System.out.println("collideX");
					}
				}
			}

			if(collideX && collideY){
				System.out.println("collision!");
				monsters[x].contact = true;
			}
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backgroundPic, 0, 0, this);
		g.drawImage(image, x, y, this);
		g.setColor(Color.GREEN);
		g.fillRect(5, 5, 200, 15);
		g.setColor(Color.BLUE);
		g.fillRect(5, 15, 200, 5);


		for(int c = 0; c < monsters.length; c++){
			if(monsters[c]!=null){
				// character grid for monsters
				// g.setColor(Color.BLUE);
				// g.fillRect(monsters[c].xPos, monsters[c].yPos+5, monsters[c].width, monsters[c].height);
				g.drawImage(monsters[c].image, monsters[c].xPos, monsters[c].yPos, this);
				g.setColor(Color.GREEN);
				g.fillRect(monsters[c].xPos+7, monsters[c].yPos, monsters[c].life, 2);
		}	
	}
}
}