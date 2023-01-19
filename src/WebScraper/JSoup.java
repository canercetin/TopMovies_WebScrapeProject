package WebScraper;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JSoup {

	static final Logger log = Logger.getLogger(JSoup.class);	
	
	public static void main(String[] args) throws IOException {
		Document document = Jsoup.connect(
				"https://www.imdb.com/chart/top/")
				.get();
		Elements names = document	.select("td.titleColumn a");
		Elements ratings = document	.select("td.ratingColumn.imdbRating strong");
		Elements rankings = document.select("td.titleColumn");
		
		for(int i = 0; i < 250; i++) {
			System.out.println(rankings.get(i).text().split(" ")[0]); 
			System.out.println(names.get(i).text()); 
			System.out.println(ratings.get(i).text());
		}
	}
	
	public String[][] GetAll() throws IOException {
		log.info("GetAll method IN.");
		Document document = Jsoup.connect(
				"https://www.imdb.com/chart/top/")
				.get();
		Elements names = document	.select("td.titleColumn a");
		Elements ratings = document	.select("td.ratingColumn.imdbRating strong");
		Elements rankings = document.select("td.titleColumn");
		
		String[][] array = new String[50][3];
		for(int i = 0; i < 50; i++) {
			array[i][0] = rankings.get(i).text().split(" ")[0];
			array[i][1] = names.get(i).text();
			array[i][2] = ratings.get(i).text();
		}
		log.info("GetAll method OUT.");
		return array;
	}
	public String[][] GetByGenre(String genre) throws IOException{
		log.info("GetByGenre("+genre+") method IN");
		Document document = Jsoup.connect(
				"https://www.imdb.com/search/title/?genres="+genre
				+"&sort=user_rating,desc"
				+ "&title_type=feature&num_votes=25000,&pf_rd_m=A2FGELUUNOQJNL&pf_rd_p="
				+ "f11158cc-b50b-4c4d-b0a2-40b32863395b&pf_rd_r=A01JF8595YXZ1MF8Q0T0&pf"
				+ "_rd_s=right-6&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_gnr_")
				.get();
		Elements names = document	.select("div.lister-item.mode-advanced")
				.select("h3.lister-item-header a");
		Elements ratings = document	.select("div.inline-block.ratings-imdb-rating strong");
		Elements rankings = document.select("span.lister-item-index.unbold.text-primary");
		String[][] array = new String[50][3];
		for(int i = 0; i < 50; i++) {
			array[i][0] = rankings.get(i).text();
			array[i][1] = names.get(i).text();
			array[i][2] = ratings.get(i).text();
		}
		log.info("GetByGenre("+genre+") method OUT");
		return array;			
	}
}
