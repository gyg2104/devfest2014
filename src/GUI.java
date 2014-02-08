import javax.swing.*;

import com.gtranslate.Language;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * simple GUI for the translation process
 * @author katie wolf (main contributor)
 * @author gracie gilbert (action listeners only)
 *
 */
public class GUI implements ActionListener{
	
	JPanel side1, side2, buttpan, translatepanel, outpanel;
	JTextField translate;
	JTextArea output;
	JLabel translabel, outlabel;
	JButton transbutt;
	JButton transbutt2;
	
	

	public JPanel createContentPane(){
		JPanel totalGUI= new JPanel();
		totalGUI.setLayout(new BoxLayout(totalGUI, BoxLayout.X_AXIS));
		
		//two sides
		side1 = new JPanel();
		side1.setMinimumSize(new Dimension(500,700));
		side1.setPreferredSize(new Dimension(700,900));
		totalGUI.add(side1);

		
		totalGUI.add(Box.createRigidArea(new Dimension(10, 0)));
		
		side2 = new JPanel();
		side2.setMinimumSize(new Dimension(500, 700));
		side2.setPreferredSize(new Dimension(700, 1200));
		totalGUI.add(side2);
		
		
		//label pan
		buttpan = new JPanel();
		buttpan.setMinimumSize(new Dimension(72,52));
		
		
		
		//button
		transbutt = new JButton("TRANSLATE TO GERMAN!");
		transbutt.setSize(new Dimension(70,50));
		transbutt.addActionListener(this);
		buttpan.add(transbutt);
		transbutt2=new JButton("TRANSLATE TO FRENCH!");
		transbutt2.setSize(new Dimension(70,50));
		transbutt2.addActionListener(this);
		buttpan.add(transbutt2);
		
		
		//panel1
		translatepanel = new JPanel();
		translatepanel.setMinimumSize(new Dimension(410,410));
		translatepanel.setPreferredSize(new Dimension(410,410));
		side1.add(translatepanel);
		side1.add(buttpan);

		
		
		//text field
		
		translate = new JTextField();
		translate.setMinimumSize(new Dimension(400,400));
		translate.setPreferredSize(new Dimension(400,400));
		translatepanel.add(translate);
			
		
		
		
		
		//panel2
		outpanel = new JPanel();	
		outpanel.setMinimumSize(new Dimension(410, 610));
		outpanel.setPreferredSize(new Dimension(410,610));
		side2.add(outpanel);
		

		
		
		//textarea
		output = new JTextArea();
		output.setMinimumSize(new Dimension(400,600));
		output.setPreferredSize(new Dimension(400,600));
		outpanel.add(output);
		
		
		
		
	
		totalGUI.setOpaque(true);
		return totalGUI;
		
	}
	
	
	
	
	
	
	
	

	private static void createAndShowGUI() {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Translator");
		
		GUI demo = new GUI();
		frame.setContentPane(demo.createContentPane());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run()  {
				createAndShowGUI();
				
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(transbutt)){
			String dispMessage="";
			String sent=translate.getText();
			TranslateWord trans=new TranslateWord(sent, Language.GERMAN);
			String myTrans=trans.getTrans();
			dispMessage+="Google Translate Says: "+myTrans+"\n";
			String mT2="";
		
			try{
				mT2 = trans.getBingTrans();
				dispMessage+="Bing Translate Says: "+mT2+"\n";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Parser pars=new Parser(myTrans, "ger");
			String myParsed=pars.parse();
			
			Search_Receive search=new Search_Receive("\""+myParsed+"\"");
			dispMessage+="Google parsed ("+myParsed+") returned "+search.getNumber()+" results\n";
			Parser pars2=new Parser(mT2, "ger");
			String myParsed2=pars2.parse();
			Search_Receive search2=new Search_Receive("\""+myParsed2+"\"");
			dispMessage+="Bing parsed ("+myParsed2+") returned "+search2.getNumber()+" results\n";
			output.setText(dispMessage);
			
			
		}
		else if(arg0.getSource().equals(transbutt2)){
			String sent=translate.getText();
			String dispMessage="";
			TranslateWord trans=new TranslateWord(sent, Language.FRENCH);
			String myTrans=trans.getTrans();
			dispMessage+="Google Translate says: "+myTrans+"\n";
			String mT2="";
		
			try{
				mT2 = trans.getBingTrans();
				dispMessage+="Bing Translate Says: "+mT2+"\n";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Parser pars=new Parser(myTrans, "fr");
			String myParsed=pars.parse();
			Search_Receive search=new Search_Receive("\""+myParsed+"\"");
			dispMessage+="Google parsed ("+myParsed+") returned "+search.getNumber()+" results \n";
			Parser pars2=new Parser(mT2, "ger");
			String myParsed2=pars2.parse();
			Search_Receive search2=new Search_Receive("\""+myParsed2+"\"");
			dispMessage+="Bing parsed("+myParsed2+") returned "+search2.getNumber()+" results\n";
			output.setText(dispMessage);
			
		}
	}	
	
}
