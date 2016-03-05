package w4_1;
/**checkerboard contains 8 rows of squares and 8 columns, but for this task the board
 *can have any number of rows and columns that are specified by user. The squares
 *are black and white. The white squares should be marked as space (‘O‘), and the
 *black squares should be marked as ‘#’.
 *Here is a tricky way to determine whether a given square should be red or
 *black: If the row number and the column number are either both even or both odd,
 *then the square is white. Otherwise, it is black.
 */
import javax.swing.*;
import java.awt.*;

public class Chess extends JFrame {
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 400;
	private static final long serialVersionUID = 1L;
	private ChessBoard board = new ChessBoard();
	public Chess() {
		add(board);
		this.setResizable(false);
	}
	public static void main(String[] args) {
		Chess mf = new Chess();
		SwingUtilities.invokeLater(new Runnable() {
			
			
			@Override
			public void run() {
				mf.setTitle(mf.getClass().getSimpleName());
				mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mf.setSize(FRAME_WIDTH, FRAME_HEIGHT);
				mf.setVisible(true);
			}
			
		});
	}

}

class ChessBoard extends JPanel {

	private static final long serialVersionUID = 1L;
	private  int sqNumHor = 8; //number of squares horizontally
	private  int sqNumVer = 8;	//number of squares vertically
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int h = this.getHeight();
		int w = this.getWidth();
		int deltaH = h / sqNumHor ;
		int deltaW = w / sqNumVer;
		for(int i = 0; i < sqNumVer; i ++)
			for(int j = 0; j < sqNumHor; j ++) {
				if(((i + j) % 2) == 0)
					g2.setColor(Color.white);
				else
					g2.setColor(Color.black);
				g2.fillRect(deltaW * j, deltaH * i, deltaW, deltaH);
			}
			
	}
	
}