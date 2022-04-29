package View;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
@SuppressWarnings("serial")
public class CardTableView extends JFrame {
	private JButton hitButton = new JButton("HIT");
	private JButton stayButton = new JButton("STAY");
	private JButton shuffleButton = new JButton("SHUFFLE");
	private JButton newGameButton = new JButton("NEW GAME");
	private JPanel tablePanel = new JPanel();
	
	
	public CardTableView() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(200, 200);
		tablePanel.add(hitButton);
		tablePanel.add(stayButton);
		tablePanel.add(shuffleButton);
		tablePanel.add(newGameButton);
		hitButton.setVisible(false);
		stayButton.setVisible(false);
		shuffleButton.setVisible(false);
		this.add(tablePanel);

		
		
	}

	public void addHitListener(ActionListener listenButton) {
		hitButton.addActionListener(listenButton);
	}

	public void addStayListener(ActionListener listenButton) {
		stayButton.addActionListener(listenButton);
	}
	
	public void addShuffleListener(ActionListener listenButton) {
		stayButton.addActionListener(listenButton);
	}

	public void addNewGameListener(ActionListener listenButton) {
		newGameButton.addActionListener(listenButton);
	}

	public void addCards(String[] cards) throws IOException, URISyntaxException {
		for(String card : cards) {
			Path path = Paths.get(card);
			File file = new File(path.toString());
			ImageIcon icon = new ImageIcon(path.toString());
			tablePanel.add(new JLabel(icon));
		}
		tablePanel.repaint(getBounds());
		JOptionPane.showMessageDialog(this, cards);
	}

	public void enableGame() {
		hitButton.setVisible(true);
		stayButton.setVisible(true);
		shuffleButton.setVisible(true);
		tablePanel.repaint(getBounds());
	}
}
