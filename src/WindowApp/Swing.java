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
	JMenuItem[] menuItems; 
	
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
		
		//Get Button Names
		String[] genreNames  = jsoup.GetGenres();		
		
		//Set Buttons
		menuItems = new JMenuItem[genreNames.length];
		
		for(int i=0; i<menuItems.length; i++) {
			menuItems[i] = new JMenuItem(genreNames[i]);
			genres.add(menuItems[i]);
			menuItems[i].addActionListener(this);
		}
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
		if(e.getSource() == menuItems[0]) {
				try {
					String[][] movies = jsoup.GetAll();
					for(int i = 0; i < movies.length; i++) {
						table.setValueAt(movies[i][0], i, 0);
						table.setValueAt(movies[i][1], i, 1);
						table.setValueAt(movies[i][2], i, 2);
					}
					label.setText("All");
				} catch (IOException e1) {log.error(e1.getMessage());}
				
		}else{
			try {
				String[][] movies = jsoup.GetByGenre(e.getActionCommand().toLowerCase());
				for(int i = 0; i < movies.length; i++) {
					table.setValueAt(movies[i][0], i, 0);
					table.setValueAt(movies[i][1], i, 1);
					table.setValueAt(movies[i][2], i, 2);
				}
				label.setText("Action");
				throw(new IOException("This is an error!"));
			} catch (IOException e1) {log.error(e1.getMessage());}
			
		}
		log.info("actionPerformed("+e.getActionCommand()+") method OUT");
	}
}
