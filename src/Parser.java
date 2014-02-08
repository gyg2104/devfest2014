import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

/**
 * replaces nouns with * for better google searching
 * @author gracie gilbert
 *
 */
public class Parser {

	String origSent;
	String parsed;
	List<String> sepWords;
	MaxentTagger max;
	
	public Parser(String sent, String language){
		origSent=sent;
		parsed=null;
		sepWords=new ArrayList<String>();
		if(language.equals("ger")){
			
			max=new MaxentTagger("taggers/german-fast.tagger");
		}
		else{
			max=new MaxentTagger("taggers/french.tagger");
		}	
	}
	
	public String parse(){
		separate();
		parsed=removeNoun();
		return parsed;
	}
	
	private void separate(){
		String taggedSent=max.tagString(origSent);
		System.out.println(taggedSent);
		sepWords=Arrays.asList(taggedSent.split("\\s+"));
	}
	
	private String removeNoun(){
		
		String newSent="";
		for(int i=0; i<sepWords.size(); i++){
			String[] wordAndPOS=sepWords.get(i).split("_");
			if(wordAndPOS[1].equals("NN")||wordAndPOS[1].equals("NNP")||
					wordAndPOS[1].equals("NNPS")||wordAndPOS[1].equals("NNS")||
					wordAndPOS[1].equals("N")|| wordAndPOS[1].equals("ET")){
				newSent+="* ";
			}
			else{
				newSent+=wordAndPOS[0]+" ";
			}
			
		}
		return newSent;
		
	}

}
