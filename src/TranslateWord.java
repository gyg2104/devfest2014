import com.gtranslate.Translator;
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
/**
 * Takes a word or phrase and translates it to another language
 * @author gracie gilbert (gyg2104)
 *
 */
//Gracie
public class TranslateWord {

	Translator translate;
	String sentence;
	String origlanguage;
	String trans;
	String translanguage;
	
	
	public TranslateWord(String sent, String translang){
		translate=Translator.getInstance();
		sentence=sent;
		origlanguage=translate.detect(sentence);
		trans=null;
		translanguage=translang;
		
	}
	
	/**
	 * this method translates the sentence
	 * @return trans, the translated string
	 */
	public String getTrans(){
		//String tl=translanguage.toString();
		trans=translate.translate(sentence, origlanguage, translanguage);
		return trans;
	}
	
	public String getBingTrans() throws Exception{
		Translate.setClientId("dev2014fest");
        Translate.setClientSecret("GQqH2yz98IqgHy8WUnuqA/LAMKmNUUn/OgFNjoJ0eKw=");
       
        Language lang;
        if(translanguage.equals("fr")){
        	lang=Language.FRENCH;
        }
        else{
        	lang=Language.GERMAN;
        }
        String translatedText = Translate.execute(sentence, lang);
        return translatedText;
        
	}
	
	

}
