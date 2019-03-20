import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame implements KeyListener{

	static Draw drawing = new Draw();
	static Sound sound = new Sound();

	public void keyPressed(KeyEvent e){

		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			drawing.moveRight();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}

		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			drawing.moveLeft();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}

		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			drawing.jump();
			System.out.println("jump");
		}

		else if(e.getKeyCode() == KeyEvent.VK_A){
			drawing.attack1();
			System.out.println("attack1");
		}

		else if(e.getKeyCode() == KeyEvent.VK_W){
			drawing.attack2();
			System.out.println("attack2");
		}

		else if(e.getKeyCode() == KeyEvent.VK_D){
			drawing.attack3();
			System.out.println("attack3");
		}

		else if(e.getKeyCode() == KeyEvent.VK_R){
			drawing.spawnEnemy();
		}

		else if(e.getKeyCode() == KeyEvent.VK_S){
			sound.play();
			System.out.println("play sound");
		}
    }

    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e){

    }
	
	public static void main(String args[]){
		MyFrame gameFrame = new MyFrame();
		gameFrame.setSize(896,524);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(drawing);
		gameFrame.addKeyListener(gameFrame);
	}
}