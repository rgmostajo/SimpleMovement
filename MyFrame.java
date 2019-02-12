import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame implements KeyListener{

	static Draw drawing = new Draw();

	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP){
			drawing.moveUp();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}

		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			drawing.moveRight();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}

		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			drawing.moveLeft();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}

		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			drawing.moveDown();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}

		else if(e.getKeyCode() == KeyEvent.VK_S){
			drawing.smrslt();
			System.out.println("smrslt");
		}

		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			drawing.jump();
			System.out.println("jump");
		}

		else if(e.getKeyCode() == KeyEvent.VK_C){
			drawing.crouch();
			System.out.println("crouch");
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

		else if(e.getKeyCode() == KeyEvent.VK_F){
			drawing.slide();
			System.out.println("slide");
		}

		else if(e.getKeyCode() == KeyEvent.VK_R){
			drawing.spawnEnemy();
		}
    }

    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e){

    }
	
	public static void main(String args[]){
		MyFrame gameFrame = new MyFrame();
		gameFrame.setSize(500,333);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(drawing);
		gameFrame.addKeyListener(gameFrame);
	}
}