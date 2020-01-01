import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class M2E_E2M
{
    HashMap<String, String> M2E = new HashMap<>();
    HashMap<String, String> E2M = new HashMap<>();
    {
    E2M.put("A",".-");
    E2M.put("B","-...");
    E2M.put("C","-.-.");
    E2M.put("D","-..");
    E2M.put("E",".");
    E2M.put("F","..-.");
    E2M.put("G","--.");
    E2M.put("H","....");
    E2M.put("I","..");
    E2M.put("J",".---");
    E2M.put("K",".-.-");
    E2M.put("L",".-..");
    E2M.put("M","--");
    E2M.put("N","-.");
    E2M.put("O","---");
    E2M.put("P",".--.");
    E2M.put("Q","--.-");
    E2M.put("R",".-.");
    E2M.put("S","...");
    E2M.put("T","-");
    E2M.put("U","..-");
    E2M.put("V","...-");
    E2M.put("W",".--");
    E2M.put("X","-..-");
    E2M.put("Y","-.--");
    E2M.put("Z","--..");

    E2M.put("1",".----");
    E2M.put("2","..---");
    E2M.put("3","...--");
    E2M.put("4","....-");
    E2M.put("5",".....");
    E2M.put("6","-....");
    E2M.put("7","--...");
    E2M.put("8","---..");
    E2M.put("9","----.");
    E2M.put("0","-----");

    E2M.put(".",".-.-.-");
    E2M.put(",","--.--");
    E2M.put("?","..--..");
    E2M.put("!","..--.");
    E2M.put(":","---...");
    E2M.put("\"",".-..-.");
    E2M.put("'",".----.");
    E2M.put("=","-...-");

        List<Object> values = Arrays.asList(E2M.values().toArray());
        List<Object> keys = Arrays.asList(E2M.keySet().toArray());
        for(int i = 0; i < values.size(); i++) {
            M2E.put(values.get(i).toString(), keys.get(i).toString());
        }
    }
    private String info = "Note: \n" +
    "Morse code words are separated by / \n" +
    "Morse code alphabets are separated by single whitespace \n" +
    "Press space bar for auto translation";


    M2E_E2M()
    {
        JTextArea ETextArea = new JTextArea(20,20);
        ETextArea.setLineWrap(true);
        ETextArea.setWrapStyleWord(true);
        ETextArea.setMargin(new Insets(5, 5, 5, 5));
        ETextArea.setText("Mr.Nobody");
        
        JLabel ETextlabel = new JLabel("English Text");
        ETextlabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton clearEText = new JButton("Clear");
        JButton  E2Mbt = new JButton("English --> Morse");
        
        
        JPanel EcntlPanel =new JPanel();
        EcntlPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        EcntlPanel.add(clearEText);
        EcntlPanel.add(E2Mbt);

        JPanel ETextPanel = new JPanel();
        ETextPanel.setLayout(new BorderLayout());
        ETextPanel.add(ETextlabel,BorderLayout.NORTH);
        ETextPanel.add(new JScrollPane(ETextArea),BorderLayout.CENTER);
        ETextPanel.add(EcntlPanel,BorderLayout.SOUTH);


        JTextArea MTextArea = new JTextArea();
        MTextArea.setLineWrap(true);
        MTextArea.setWrapStyleWord(true);
        MTextArea.setMargin(new Insets(5, 5, 5, 5));
        MTextArea.setText(".-");
        MTextArea.setFont(new Font("",0,20));
        
        JLabel MTextlabel = new JLabel("Morse Code");
        MTextlabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton clearMText = new JButton("Clear");
        JButton  M2Ebt = new JButton("Morse --> English");
        
        JPanel McntlPanel =new JPanel();
        McntlPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        McntlPanel.add(M2Ebt);
        McntlPanel.add(clearMText);


        JPanel MTextPanel = new JPanel();
        MTextPanel.setLayout(new BorderLayout());
        MTextPanel.add(MTextlabel,BorderLayout.NORTH);
        MTextPanel.add(new JScrollPane(MTextArea),BorderLayout.CENTER);
        MTextPanel.add(McntlPanel,BorderLayout.SOUTH);


        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,ETextPanel,MTextPanel);
        splitPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JTextArea infoTextArea =new JTextArea();
        
        infoTextArea.setLineWrap(true);
        infoTextArea.setWrapStyleWord(true);
        infoTextArea.setMargin(new Insets(5, 5, 5, 5));
        infoTextArea.setText(info);
        infoTextArea.setBackground(new Color(241,241,241));
        infoTextArea.setEditable(false);

        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.add(infoTextArea,BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(infoPanel, BorderLayout.NORTH);
        mainPanel.add(splitPane, BorderLayout.CENTER);



        E2Mbt.addActionListener((e)->{
            String english = ETextArea.getText().trim();
            MTextArea.setText(E2Mword(english));});   


        M2Ebt.addActionListener((e)->{
            String morse = MTextArea.getText().trim();
            ETextArea.setText(M2Eword(morse));}); 


        ETextArea.addKeyListener(new KeyAdapter(){
                public void keyTyped(KeyEvent e){
                if(Character.isWhitespace(e.getKeyChar())||e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                   MTextArea.setText(E2Mword(ETextArea.getText()));                
                 }
            }

        });  
     
            
        MTextArea.addKeyListener(new KeyAdapter(){
                public void keyTyped(KeyEvent e){
                if(Character.isWhitespace(e.getKeyChar())||e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                   ETextArea.setText(E2Mword(MTextArea.getText()));             
                    }
            }

        });  

        clearEText.addActionListener((e ->{
            ETextArea.setText(null);
        }));

        clearMText.addActionListener((e ->{
            MTextArea.setText(null);
        }));
        

        JFrame frame =new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setTitle("English to Morse Translator");
        frame.add(mainPanel,BorderLayout.CENTER);
        frame.setSize(new Dimension(800,650));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        splitPane.setDividerLocation(frame.getWidth()/2);
        E2Mbt.doClick();      
        
    }

        public String E2Mword(String englishWord)
        {
            StringBuffer buffer = new StringBuffer();
            Stream.of(englishWord.split("[\n]")).forEach( s ->{
                
                for(char c : s.toCharArray())
                { 
                buffer.append(E2M.containsKey(String.valueOf(c).toUpperCase()) ? E2M.get(String.valueOf(c).toUpperCase()) + " " : " ?? ");

                }
                buffer.append(" / ");
            });
            return buffer.toString();
        }

        public String M2Eword(String morseWord)
        {
            StringBuffer buffer = new StringBuffer();
            Stream.of(morseWord.split("[\\s\\n]")).filter((s) -> s!= null && !s.isEmpty())
            .forEach( s ->{
                
                if(s.equalsIgnoreCase("/")||s.equalsIgnoreCase("|")){
                    buffer.append(" ");
                }
                else{
                    
                buffer.append((M2E.containsKey(s)?M2E.get(s):" ?? ").toUpperCase());

                }
             });
            return buffer.toString();
        }

        public static void main(String []args)
        {
               
            //SwingUtilities.invokeLater(() -> {
                new M2E_E2M();
       //  });
     }
}



