import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Draw extends JComponent{

	private BufferedImage image;
	private BufferedImage backgroundPic;
	private URL resource = getClass().getResource("run3.png");

	//circle's position
	public int x = 30;
	public int y = 30;

	//animation states
	public int state = 0;


	public Draw(){
		try{
			image = ImageIO.read(resource);
			backgroundPic = ImageIO.read(getClass().getResource("backgroundforest.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
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
							resource = getClass().getResource("smrslt0.png");
						}
						else{
							resource = getClass().getResource("smrslt"+ctr+".png");
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
							resource = getClass().getResource("jump0.png");
						}
						else{
							resource = getClass().getResource("jump"+ctr+".png");
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
							resource = getClass().getResource("crouch0.png");
						}
						else{
							resource = getClass().getResource("crouch"+ctr+".png");
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

	public void crouch(){
		crouchAnimation();
	}


	public void jump(){
		jumpAnimation();
	}

	public void smrslt(){
		smrsltAnimation();
	}

	public void moveRight(){
		x = x + 5;
		state++;
		repaint();
		reloadImage();
	}

	public void moveLeft(){
		x = x - 5;
		state++;
		repaint();
		reloadImage();
	}

	public void moveDown(){
		y = y + 5;
		state++;
		repaint();
		reloadImage();
	}

	public void moveUp(){
		y = y - 5;
		state++;
		repaint();
		reloadImage();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backgroundPic, 0, 0, this);
		g.drawImage(image, x, y, this);
	}
}