import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.Gson;

/**
 * searches a phrase on google and returns how many search results came up
 * @author chris wang
 *
 */

public class Search_Receive {
	private String query;
	private String website;
	private String charset = "UTF-8";
	private String number;
	
	public Search_Receive(String search){
		website = "https://www.googleapis.com/customsearch/v1?key=" +
				"AIzaSyBShG3mcIuXhmXCyCKkoJ9xEOrpCSStC8k&cx=" +
				"014121263881055938277:pijprakkpko&q=";
		query = search;
	}
	
	public int getNumber(){
		URL url;
		Reader reader = null;
		try {
			url = new URL(website + URLEncoder.encode(query, charset));
			reader = new InputStreamReader(url.openStream(), charset);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);
	    number = results.getQueries().getRequests().get(0).getTotalResults();
	    return Integer.parseInt(number);
	}
}