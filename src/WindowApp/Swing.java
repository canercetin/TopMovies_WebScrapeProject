package WindowApp;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import org.apache.log4j.Logger;

import WebScraper.JSoup;

public class Swing implements ActionListener {
	
	static final Logger log = Logger.getLogger(Swing.class);
	
	//Frame
	JFrame frame = new JFrame("Top Movies");
	
	//Menu
	JMenuItem all, action, adventure, animation, biography, comedy,
	crime, drama, family, fantasy;
	
	//Label
	JLabel label = new JLabel("All");
	
	//Table	
	String[] tableTitles = {"RANK","TITLE","GRADE"};
	JTable table; 
	JScrollPane scroll;
	
	//DI
	private JSoup jsoup;
	
	public Swing(JSoup jsoup_) throws IOException {
		log.info("Constructor IN");
		
		//DI
		jsoup = jsoup_;		
		
		//Frame
		frame.setSize(800,600);
		frame.setResizable(false);
		
		//Icon
		Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/Caner/eclipse-workspace/TopMovies_WebScrapeProject/src/WindowApp/icon.png");  
		frame.setIconImage(icon);
		
		//Menu
		JMenuBar menuBar = new JMenuBar();
		JMenu genres = new JMenu("Select Genre");
		menuBar.add(genres);
						
		all = new JMenuItem("All"); genres.add(all); all.addActionListener(this);		
		action = new JMenuItem("Action"); genres.add(action); action.addActionListener(this);	
		adventure = new JMenuItem("Adventure"); genres.add(adventure); adventure.addActionListener(this);	
		animation = new JMenuItem("Animation"); genres.add(animation); animation.addActionListener(this);
		biography = new JMenuItem("Biography"); genres.add(biography); biography.addActionListener(this);
		comedy = new JMenuItem("Comedy"); genres.add(comedy); comedy.addActionListener(this);
		crime = new JMenuItem("Crime"); genres.add(crime); crime.addActionListener(this);
		drama = new JMenuItem("Drama"); genres.add(drama); drama.addActionListener(this);
		family = new JMenuItem("Family"); genres.add(family); family.addActionListener(this);
		fantasy = new JMenuItem("Fantasy"); genres.add(fantasy); fantasy.addActionListener(this);
		
		//Label
		label.setBounds(50, 10, 100, 50);
		frame.add(label);
		
		//Table
		table = new JTable(jsoup.GetAll(),tableTitles);
		scroll = new JScrollPane(table);
		table.setEnabled(false);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(15, 50, frame.getWidth()-50, frame.getHeight()-150);
		frame.add(scroll);
		
		frame.setJMenuBar(menuBar);		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
		frame.setLayout(null);
		frame.setVisible(true);
		
		log.info("Constructor OUT");
	}
	//Actions
	@Override
	public void actionPerformed(ActionEvent e) {
		log.info("actionPerformed("+e.getActionCommand()+") method IN");
		if(e.getSource() == all) {
				try {
					String[][] movies = jsoup.GetAll();
					for(int i = 0; i < movies.length; i++) {
						table.setValueAt(movies[i][0], i, 0);
						table.setValueAt(movies[i][1], i, 1);
						table.setValueAt(movies[i][2], i, 2);
					}
					label.setText("All");
				} catch (IOException e1) {log.error(e1.getMessage());}
				
		}
		if(e.getSource() == action) {
			try {
				String[][] movies = jsoup.GetByGenre("action");
				for(int i = 0; i < movies.length; i++) {
					table.setValueAt(movies[i][0], i, 0);
					table.setValueAt(movies[i][1], i, 1);
					table.setValueAt(movies[i][2], i, 2);
				}
				label.setText("Action");
				throw(new IOException("This is an error!"));
			} catch (IOException e1) {log.error(e1.getMessage());}
			
		}
		if(e.getSource() == adventure) {
			try {
				String[][] movies = jsoup.GetByGenre("adventure");
				for(int i = 0; i < movies.length; i++) {
					table.setValueAt(movies[i][0], i, 0);
					table.setValueAt(movies[i][1], i, 1);
					table.setValueAt(movies[i][2], i, 2);
				}
				label.setText("Adventure");
			} catch (IOException e1) {log.error(e1.getMessage());}
			
		}
		if(e.getSource() == animation) {
			try {
				String[][] movies = jsoup.GetByGenre("animation");
				for(int i = 0; i < movies.length; i++) {
					table.setValueAt(movies[i][0], i, 0);
					table.setValueAt(movies[i][1], i, 1);
					table.setValueAt(movies[i][2], i, 2);
				}	
				label.setText("Animation");
			} catch (IOException e1) {log.error(e1.getMessage());}
			
		}
		if(e.getSource() == biography) {
			try {
				String[][] movies = jsoup.GetByGenre("biography");
				for(int i = 0; i < movies.length; i++) {
					table.setValueAt(movies[i][0], i, 0);
					table.setValueAt(movies[i][1], i, 1);
					table.setValueAt(movies[i][2], i, 2);
				}
				label.setText("Biography");
			} catch (IOException e1) {log.error(e1.getMessage());}
			
		}
		if(e.getSource() == comedy) {
			try {
				String[][] movies = jsoup.GetByGenre("comedy");
				for(int i = 0; i < movies.length; i++) {
					table.setValueAt(movies[i][0], i, 0);
					table.setValueAt(movies[i][1], i, 1);
					table.setValueAt(movies[i][2], i, 2);
				}
				label.setText("Comedy");
			} catch (IOException e1) {log.error(e1.getMessage());}
			
		}
		if(e.getSource() == crime) {
			try {
				String[][] movies = jsoup.GetByGenre("crime");
				for(int i = 0; i < movies.length; i++) {
					table.setValueAt(movies[i][0], i, 0);
					table.setValueAt(movies[i][1], i, 1);
					table.setValueAt(movies[i][2], i, 2);
				}
				label.setText("Crime");
			} catch (IOException e1) {log.error(e1.getMessage());}
			
		}
		if(e.getSource() == drama) {
			try {
				String[][] movies = jsoup.GetByGenre("drama");
				for(int i = 0; i < movies.length; i++) {
					table.setValueAt(movies[i][0], i, 0);
					table.setValueAt(movies[i][1], i, 1);
					table.setValueAt(movies[i][2], i, 2);
				}
				label.setText("Drama");
			} catch (IOException e1) {log.error(e1.getMessage());}
		}
		if(e.getSource() == family) {
			try {
				String[][] movies = jsoup.GetByGenre("family");
				for(int i = 0; i < movies.length; i++) {
					table.setValueAt(movies[i][0], i, 0);
					table.setValueAt(movies[i][1], i, 1);
					table.setValueAt(movies[i][2], i, 2);
				}
				label.setText("Family");
			} catch (IOException e1) {log.error(e1.getMessage());}
			
		}
		if(e.getSource() == fantasy) {
			try {
				String[][] movies = jsoup.GetByGenre("fantasy");
				for(int i = 0; i < movies.length; i++) {
					table.setValueAt(movies[i][0], i, 0);
					table.setValueAt(movies[i][1], i, 1);
					table.setValueAt(movies[i][2], i, 2);
				}
				label.setText("Fantasy");
			} catch (IOException e1) {log.error(e1.getMessage());}
			
		}
		log.info("actionPerformed("+e.getActionCommand()+") method OUT");
	}
}
