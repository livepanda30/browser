import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class ReadFile extends JFrame {
	
	private JTextField addressBar;
	private JEditorPane display;
	
	//constructor
	public ReadFile(){
		super("Ken Browser");
		
		//creates address bar
		addressBar = new JTextField("enter a URL");
		addressBar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						loadcrap(event.getActionCommand());
					}
				}
				);
		add(addressBar,BorderLayout.NORTH);
		
		//creating the GUI
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(
				new HyperlinkListener() {
					public void hyperlinkUpdate(HyperlinkEvent event) {
						if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED) {
							loadcrap(event.getURL().toString());
						}
					}
				}
				);
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(500,300);
		setVisible(true);
		
	}
	
	//load stuff to display to screen
	public void loadcrap(String userText) {
		try {
			display.setPage(userText);
			addressBar.setText(userText);
		}catch(Exception e) {
			System.out.println("ya done messed up!");
		}
	}

}
