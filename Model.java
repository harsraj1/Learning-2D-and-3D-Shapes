import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.lang.Math;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.awt.*;

public class Model extends JFrame implements ActionListener{
    JPanel welcomePanel, lastPanel;
    JPanel secondPanel, subPanel2D, subPanel3D, mainDisplay, picPanel, quizDisplay;
    JPanel twoParamsPanel2D, twoParamsPanel3D, oneParamsPanel2D;
    JLabel label1, label2, label3, label4, picLabel, picLabel1, question1;  //label3 for result
    String typeOfObject, result;
    JTextField val1, val2, val3, res;
	JRadioButton rb1,rb2, rb3, rb4; 
	String correctAns;	
	ButtonGroup bg;
	

    int num1, num2, num3, ans;
    JButton action1, action2, action3, quizButton;
    double slant;
	int x, y;
    BufferedImage myPicture;
	
	public static void main(String[] args){
		new Model();
	} 
	
    Model(){
		super("Learning 2D and 3D Shapes");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        double width = screenSize.getWidth();

        double height = screenSize.getHeight();
		int x = (int)Math.round(width)-100;
		int y = (int)Math.round(height)-150;
		
        setSize((int)Math.round(width),(int)Math.round(height));
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

        //first screen
        welcomePanel = new JPanel();
        welcomePanel.setBounds(45,45,x,y);
        welcomePanel.setBackground(Color.ORANGE);
        welcomePanel.setLayout(null);
        welcomePanel.setVisible(true);
        add(welcomePanel);
		
		
		
        JLabel welcome = new JLabel("Welcome to the game", SwingConstants.CENTER);
        welcome.setForeground(Color.RED);
        welcome.setFont(new Font("Serif", Font.BOLD, y/18));
        welcome.setBounds(x/5, 18*y/90, 60*x/100, y/15);
        welcomePanel.add(welcome);
		
		JLabel welcome1 = new JLabel("of", SwingConstants.CENTER);
		welcome1.setForeground(Color.RED);
        welcome1.setFont(new Font("Serif", Font.BOLD, y/18));
        welcome1.setBounds(x/5, 24*y/90, 60*x/100, y/15);
        welcomePanel.add(welcome1);
		
		JLabel welcome2 = new JLabel("2D and 3D shapes", SwingConstants.CENTER);
        welcome2.setForeground(Color.RED);
        welcome2.setFont(new Font("Serif", Font.BOLD, y/18));
        welcome2.setBounds(x/5, 30*y/90, 60*x/100, y/15);
        welcomePanel.add(welcome2);
		
		
        JButton letsStart = new JButton("Lets Start");  letsStart.setName("Lets Start");
        letsStart.setBounds(45*x/100, 36*y/90, x/10,y/15);
        welcomePanel.add(letsStart);
        letsStart.addActionListener(this);

        //second screen
        secondPanel = new JPanel();
        secondPanel.setBounds(45,45,x,y);
        secondPanel.setBackground(Color.BLUE);
        secondPanel.setLayout(null);

        lastPanel = new JPanel();
        lastPanel.setBounds(45,45,x,y);
        lastPanel.setBackground(Color.BLACK);
        lastPanel.setLayout(null);

        subPanel2D = new JPanel();
        subPanel2D.setBounds(1*x/100,2*y/100,20*x/100,96*y/100);
        subPanel2D.setBackground(Color.RED);
        subPanel2D.setLayout(null);
        secondPanel.add(subPanel2D);

        subPanel3D = new JPanel();
        subPanel3D.setBounds(79*x/100,2*y/100,20*x/100,96*y/100);
        subPanel3D.setBackground(Color.RED);
        subPanel3D.setLayout(null);
        secondPanel.add(subPanel3D);

        JLabel twoDShapes = new JLabel("2D Shapes", SwingConstants.CENTER);
		twoDShapes.setFont(new Font("Monospaced", Font.BOLD, y/18));
        twoDShapes.setBounds(2*x/100, 3*y/100, 16*x/100, 10*y/100);
        subPanel2D.add(twoDShapes);

        JButton squareB = new JButton("square");                squareB.setFont(new Font("SansSerif", Font.BOLD, y/25));				squareB.setBounds(2*x/100, 16*y/100, 16*x/100, 10*y/100);         subPanel2D.add(squareB);
        JButton rectangleB = new JButton("rectangle");          rectangleB.setFont(new Font("SansSerif", Font.BOLD, y/25));			rectangleB.setBounds(2*x/100, 29*y/100, 16*x/100, 10*y/100);      subPanel2D.add(rectangleB);
        JButton circleB = new JButton("circle");                circleB.setFont(new Font("SansSerif", Font.BOLD, y/25));			circleB.setBounds(2*x/100, 42*y/100, 16*x/100, 10*y/100);         subPanel2D.add(circleB);
        JButton triangleB = new JButton("triangle");            triangleB.setFont(new Font("SansSerif", Font.BOLD, y/25));			triangleB.setBounds(2*x/100, 55*y/100, 16*x/100, 10*y/100);       subPanel2D.add(triangleB);
        JButton parallelogramB = new JButton("parallelogram");  parallelogramB.setFont(new Font("SansSerif", Font.BOLD, y/25));		parallelogramB.setBounds(2*x/100, 68*y/100, 16*x/100, 10*y/100);  subPanel2D.add(parallelogramB);
        JButton trapeziumB = new JButton("trapezium");          trapeziumB.setFont(new Font("SansSerif", Font.BOLD, y/25));			trapeziumB.setBounds(2*x/100, 81*y/100, 16*x/100, 10*y/100);      subPanel2D.add(trapeziumB);

        //registering actionLIsteners
        
        squareB.addActionListener(this);
        rectangleB.addActionListener(this);
        circleB.addActionListener(this);
        triangleB.addActionListener(this);
        parallelogramB.addActionListener(this);
        trapeziumB.addActionListener(this);

        JLabel threeDShapes = new JLabel("3D Shapes", SwingConstants.CENTER);
		threeDShapes.setFont(new Font("Monospaced", Font.BOLD, y/18));
        threeDShapes.setBounds(2*x/100, 3*y/100, 16*x/100, 10*y/100);
        subPanel3D.add(threeDShapes);

        JButton sphereB = new JButton("sphere");			sphereB.setFont(new Font("SansSerif", Font.BOLD, y/25));        sphereB.setBounds(2*x/100, 16*y/100, 16*x/100, 10*y/100);         subPanel3D.add(sphereB);
        JButton cuboidB = new JButton("cuboid");            cuboidB.setFont(new Font("SansSerif", Font.BOLD, y/25));		cuboidB.setBounds(2*x/100, 29*y/100, 16*x/100, 10*y/100);         subPanel3D.add(cuboidB);
        JButton cylinderB = new JButton("cylinder");        cylinderB.setFont(new Font("SansSerif", Font.BOLD, y/25));    	cylinderB.setBounds(2*x/100, 42*y/100, 16*x/100, 10*y/100);       subPanel3D.add(cylinderB);
        JButton coneB = new JButton("cone");                coneB.setFont(new Font("SansSerif", Font.BOLD, y/25));    		coneB.setBounds(2*x/100, 55*y/100, 16*x/100, 10*y/100);           subPanel3D.add(coneB);
        JButton hemisphereB = new JButton("hemisphere");    hemisphereB.setFont(new Font("SansSerif", Font.BOLD, y/25));    hemisphereB.setBounds(2*x/100, 68*y/100, 16*x/100, 10*y/100);     subPanel3D.add(hemisphereB);
        JButton cubeB = new JButton("cube");                cubeB.setFont(new Font("SansSerif", Font.BOLD, y/25));    		cubeB.setBounds(2*x/100, 81*y/100, 16*x/100, 10*y/100);           subPanel3D.add(cubeB);

        //setting names for buttons
        squareB.setName("square");      rectangleB.setName("rectangle");            circleB.setName("circle");
        triangleB.setName("triangle");  parallelogramB.setName("parallelogram");    trapeziumB.setName("trapezium");
        sphereB.setName("sphere");      cuboidB.setName("cuboid");                  cylinderB.setName("cylinder");
        coneB.setName("cone");          hemisphereB.setName("hemisphere");          cubeB.setName("cube");

        sphereB.addActionListener(this);
        cuboidB.addActionListener(this);
        cylinderB.addActionListener(this);
        coneB.addActionListener(this);
        hemisphereB.addActionListener(this);
        cubeB.addActionListener(this);

        //main display
        mainDisplay = new JPanel();     mainDisplay.setBounds(27*x/100, 2*y/100, 46*x/100, 42*y/100);     mainDisplay.setBackground(Color.ORANGE);
        secondPanel.add(mainDisplay);   mainDisplay.setVisible(false);                 mainDisplay.setLayout(null);

        JLabel mainDisplayLabel = new JLabel(" ");   mainDisplayLabel.setBounds(20, 20, 300, 30);   mainDisplay.add(mainDisplayLabel); 
        
        twoParamsPanel2D = new JPanel();      twoParamsPanel2D.setBounds(27*x/100, 1*y/100, 18*x/100, 40*y/100);
        mainDisplay.add(twoParamsPanel2D);    twoParamsPanel2D.setLayout(null);

        picPanel = new JPanel();      picPanel.setBounds(1*x/100, 1*y/100, 25*x/100, 40*y/100);
        mainDisplay.add(picPanel);    picPanel.setLayout(null);
		
        
        label1 = new JLabel("val1");    label1.setBounds(2*x/100, 10*y/100, 4*x/100, 5*y/100);   twoParamsPanel2D.add(label1);
        label2 = new JLabel("val2");    label2.setBounds(2*x/100, 17*y/100, 4*x/100, 5*y/100);  twoParamsPanel2D.add(label2);
        label3 = new JLabel("result");  label3.setBounds(2*x/100, 33*y/100, 4*x/100, 5*y/100);  twoParamsPanel2D.add(label3);
        label4 = new JLabel("val3"); 	label4.setBounds(2*x/100, 3*y/100, 4*x/100, 5*y/100);  twoParamsPanel2D.add(label4);


        val1 = new JTextField();     val1.setBounds(8*x/100, 10*y/100, 7*x/100, 5*y/100);    twoParamsPanel2D.add(val1); 
        val2 = new JTextField();     val2.setBounds(8*x/100, 17*y/100, 7*x/100, 5*y/100);   twoParamsPanel2D.add(val2);
        res = new JTextField();      res.setBounds(8*x/100, 33*y/100, 7*x/100, 5*y/100);    twoParamsPanel2D.add(res);
        val3 = new JTextField();     val3.setBounds(8*x/100, 3*y/100, 7*x/100, 5*y/100);   twoParamsPanel2D.add(val3);
		
        action1 = new JButton("action1");     action1.setBounds(1*x/100, 23*y/100, 75*x/1000, 4*y/100);    twoParamsPanel2D.add(action1); action1.setName("action1");
        action2 = new JButton("action2");     action2.setBounds(95*x/1000, 23*y/100, 75*x/1000, 4*y/100);  twoParamsPanel2D.add(action2); action2.setName("action2");
		action3 = new JButton("action3");     action3.setBounds(53*x/1000, 28*y/100, 75*x/1000, 4*y/100);    twoParamsPanel2D.add(action3); action3.setName("action3");
		
        action1.addActionListener(this);   action2.addActionListener(this);		action3.addActionListener(this);

		//Quiz display part
		quizDisplay = new JPanel();     quizDisplay.setBounds(24*x/100, 50*y/100, 52*x/100, 42*y/100);      quizDisplay.setBackground(Color.ORANGE);
        secondPanel.add(quizDisplay);   quizDisplay.setVisible(false);                 quizDisplay.setLayout(null);

		question1 = new JLabel("question");    question1.setBounds(1*x/100, 2*y/100, 50*x/100, 3*y/100);   quizDisplay.add(question1);
		question1.setVisible(false);	question1.setFont(new Font("SansSerif", Font.BOLD, y/40));
		question1.setForeground(Color.BLUE);
		
		rb1 = new JRadioButton("option 1");	rb1.setName("option 1");
		rb2 = new JRadioButton("option 2");	rb2.setName("option 2");
		rb3 = new JRadioButton("option 3");	rb3.setName("option 3");
		rb4 = new JRadioButton("option 4"); rb4.setName("option 4");
		
		rb1.setBounds(1*x/100, 8*y/100, 245*x/1000, 6*y/100);
		rb2.setBounds(1*x/100, 15*y/100, 245*x/1000, 6*y/100);
		rb3.setBounds(265*x/1000, 8*y/100, 245*x/1000, 6*y/100);
		rb4.setBounds(265*x/1000, 15*y/100, 245*x/1000, 6*y/100);
		
		quizDisplay.add(rb1);
		quizDisplay.add(rb2);
		quizDisplay.add(rb3);
		quizDisplay.add(rb4);
		
		rb1.setVisible(true);
		rb2.setVisible(true);
		rb3.setVisible(true);
		rb4.setVisible(true);
		
		correctAns=new String("hello");
		
		bg = new ButtonGroup();
		bg.add(rb1); bg.add(rb2); bg.add(rb3); bg.add(rb4);
		quizButton = new JButton("submit");
		quizButton.setName("quizSubmit");
		quizButton.setBounds(23*x/100, 35*y/100, 6*x/100, 5*y/100);
		quizDisplay.add(quizButton);
		quizButton.setVisible(true);
		quizButton.addActionListener(this);
		
		

			


		//exit display part
        JButton exit = new JButton("exit"); exit.setFont(new Font("SansSerif", Font.BOLD, y/30));	exit.setBounds(44*x/100, 94*y/100, 12*x/100, 5*y/100); secondPanel.add(exit); exit.setName("exit");
        exit.addActionListener(this);

        JLabel bye = new JLabel("Thanks for using the game", SwingConstants.CENTER);
        bye.setBounds(x/5, 18*y/90, 60*x/100, y/8);
        bye.setFont(new Font("Serif", Font.BOLD, y/10));
        bye.setForeground(Color.GREEN);
        lastPanel.setLayout(null);
        lastPanel.add(bye);
		
		JLabel byline = new JLabel("by Gopal Kumar Saw and Harsh Raj", JLabel.RIGHT);
        byline.setBounds(60*x/100, 94*y/100, 35*x/100, y/20);
        byline.setFont(new Font("Monospaced", Font.ITALIC, y/30));
        byline.setForeground(Color.WHITE);
        lastPanel.setLayout(null);
        lastPanel.add(byline);
       
        /****************************************** */
        //initialising the container for the pictures//
        try{
            
            myPicture = ImageIO.read(new File("./img/parallelogram.png"));
        }
        catch(IOException ex){}
        picLabel = null;
        picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(5, 5, 300, 255);
        picPanel.add(picLabel);
        /********************************************/
        

        setVisible(true);
    }

    //controller part//

    

    public void actionPerformed(ActionEvent e){
        String buttonType = ((JButton)e.getSource()).getName();
		String response = new String();
		
		if(buttonType=="quizSubmit"){
			if(rb1.isSelected())response=rb1.getName();
			if(rb2.isSelected())response=rb2.getName();
			if(rb3.isSelected())response=rb3.getName();
			if(rb4.isSelected())response=rb4.getName();
			System.out.println(response);
			System.out.println(correctAns);
			if(response == correctAns){
				System.out.println("Congrats! Your Answer Is Correct");
				JOptionPane.showMessageDialog(this,"Congrats! Your Answer Is Correct");
                				
			}
			else{
				System.out.println("Oops! Wrong Answer");
				JOptionPane.showMessageDialog(this,"Oops! Wrong Answer");
			}
		}
        // System.out.println(buttonType);
        //for display
        if(buttonType=="exit"){
            secondPanel.setVisible(false);
            add(lastPanel);
            lastPanel.setVisible(true);
        }
        if(buttonType=="square" || buttonType=="rectangle" || buttonType=="triangle" || buttonType=="parallelogram"
                                || buttonType=="trapezium" || buttonType=="circle"){
                                    action1.setText("area");         action1.setName("area");
                                    action2.setText("perimeter");    action2.setName("perimeter");
                                }
        if(buttonType=="sphere" || buttonType=="cuboid" || buttonType=="cylinder" || buttonType=="hemisphere"
                                || buttonType=="cone" || buttonType=="cube"){
                                    action1.setText("TSA");    action1.setName("TSA");
                                    action2.setText("volume");          action2.setName("volume");
									action3.setText("CSA");				action3.setName("CSA");
                                }
        if(buttonType=="Lets Start"){
            welcomePanel.setVisible(false);
            remove(welcomePanel);
            add(secondPanel);
            secondPanel.setVisible(true);
        }

        else if(buttonType=="square" || buttonType=="rectangle" || buttonType=="triangle" || buttonType=="parallelogram"
                                || buttonType=="trapezium" || buttonType=="circle" || buttonType=="sphere" || buttonType=="cuboid" || buttonType=="cylinder" || buttonType=="hemisphere"
                                || buttonType=="cone" || buttonType=="cube"){            
            typeOfObject = buttonType;
            System.out.println(typeOfObject);
			quizDisplay.setVisible(true);
            mainDisplay.setVisible(true);
			question1.setText("Try Quiz Coming Soon!!");
			question1.setVisible(true);
			
			
            if(buttonType == "rectangle"){
                picPanel.remove(picLabel);
                try{
                    System.out.println("in try");
                    myPicture = ImageIO.read(new File("./img/rectangle.png"));
                }
                catch(IOException ex){}
				picLabel = null;
                picLabel = new JLabel(new ImageIcon(myPicture));
                picLabel.setBounds(5, 5, 300, 255);
                picPanel.add(picLabel);
                picPanel.setVisible(false);
                picPanel.setVisible(true);
                label1.setText("length");
                label2.setText("breadth");
                val2.setVisible(true);
                val3.setVisible(false);
                label4.setText(" ");
				action3.setVisible(false);
				question1.setText("Q.Find the area & perimeter of rectangle whose length and breadth are 6cm and 7cm?");//write question
				rb1.setText("56sq cm,22 cm");//option1
				rb2.setText("84sq cm,34 cm");
				rb3.setText("48sq cm,28 cm");
				rb4.setText("42sq cm,26 cm");
				rb1.setName("56sq cm,22 cm");
				rb2.setName("84sq cm,34 cm");
				rb3.setName("48sq cm,28 cm");
				rb4.setName("42sq cm,26 cm");
				correctAns = "42sq cm,26 cm";//correct answer
				System.out.println(correctAns);
				
				
				question1.setVisible(true);
				
				
				
				
            }
            else if(buttonType == "parallelogram"){
                picPanel.remove(picLabel);
                try{
                    System.out.println("in try");
                    myPicture = ImageIO.read(new File("./img/parallelogram.png"));
                }
                catch(IOException ex){}
                picLabel = null;
                picLabel = new JLabel(new ImageIcon(myPicture));
                picLabel.setBounds(5, 5, 300, 255);
                picPanel.add(picLabel);
                picPanel.setVisible(false);
                picPanel.setVisible(true);
                label1.setText("length/l");
                label2.setText("height/h");
                val2.setVisible(true);
                val3.setVisible(true);
                label4.setText("breadth/b");
				action3.setVisible(false);
				question1.setText("Q.Find the area of parallelogram whose one of the || sides & height are 12 and 7?");//write question
				rb1.setText("84sq cm");//option1
				rb2.setText("54sq cm");
				rb3.setText("48sq cm");
				rb4.setText("30sq cm");
				rb1.setName("84sq cm");
				rb2.setName("54sq cm");
				rb3.setName("48sq cm");
				rb4.setName("30sq cm");
				correctAns = "84sq cm";//correct answer
				System.out.println(correctAns);
				
				
				
				question1.setVisible(true);
            }
            else if(buttonType == "square"){
                picPanel.remove(picLabel);
                try{
                    System.out.println("in try");
                    myPicture = ImageIO.read(new File("./img/square.png"));
                }
                catch(IOException ex){}
                picLabel = null;
                picLabel = new JLabel(new ImageIcon(myPicture));
                picLabel.setBounds(5, 5, 300, 255);
                picPanel.add(picLabel);
                picPanel.setVisible(false);
                picPanel.setVisible(true);
                label1.setText("side");
                label2.setText(" ");
                val2.setVisible(false);
                val3.setVisible(false);
                label4.setText(" ");
				action3.setVisible(false);
				question1.setText("Q.Find the area and the perimeter of square whose side is 5 cm?");//write question
				rb1.setText("50sq cm , 22cm");//option1
				rb2.setText("25sq cm , 20cm");
				rb3.setText("45sq cm , 20cm");
				rb4.setText("30sq cm , 25cm");
				rb1.setName("50sq cm , 22cm");
				rb2.setName("25sq cm , 20cm");
				rb3.setName("45sq cm , 20cm");
				rb4.setName("30sq cm , 25cm");
				correctAns = "25sq cm , 20cm";//correct answer
				System.out.println(correctAns);
            }
            else if(buttonType == "circle"){
                picPanel.remove(picLabel);
                try{
                    System.out.println("in try");
                    myPicture = ImageIO.read(new File("./img/circle.png"));
                }
                catch(IOException ex){}
                picLabel = null;
                picLabel = new JLabel(new ImageIcon(myPicture));
                picLabel.setBounds(5, 5, 300, 255);
                picPanel.add(picLabel);
                picPanel.setVisible(false);
                picPanel.setVisible(true);
                label1.setText("radius");
                label2.setText(" ");
                val2.setVisible(false);
                val3.setVisible(false);
                label4.setText(" ");
				action3.setVisible(false);
				question1.setText("Q.Find the area and circumference of circle whose radius is 7cm?");//write question
				rb1.setText("154sq cm,44cm");//option1
				rb2.setText("84sq cm,56 cm");
				rb3.setText("48sq cm,26 cm");
				rb4.setText("30sq cm,32 cm");
				rb1.setName("154sq cm,44cm");
				rb2.setName("84sq cm,56 cm");
				rb3.setName("48sq cm,26 cm");
				rb4.setName("30sq cm,32 cm");
				correctAns = "154sq cm,44cm";//correct answer
				System.out.println(correctAns);
            }
            else if(buttonType == "triangle"){
                picPanel.remove(picLabel);
                try{
                    System.out.println("in try");
                    myPicture = ImageIO.read(new File("./img/triangle.png"));
                }
                catch(IOException ex){}
                picLabel = null;
                picLabel = new JLabel(new ImageIcon(myPicture));
                picLabel.setBounds(5, 5, 300, 255);
                picPanel.add(picLabel);
                picPanel.setVisible(false);
                picPanel.setVisible(true);
                label1.setText("side 2");
                label2.setText("side 3");
                val2.setVisible(true);
                val3.setVisible(true);
                label4.setText("side 1");
				action3.setVisible(false);
				question1.setText("Q.Find the area and perimeter of triangle whose sides are 3 , 4 and 5?");//write question
				rb1.setText("16sq cm,15 cm");//option1
				rb2.setText("8sq cm,14 cm");
				rb3.setText("6sq cm,12 cm");
				rb4.setText("13sq cm,15 cm");
				rb1.setName("16sq cm,15 cm");
				rb2.setName("8sq cm,14 cm");
				rb3.setName("6sq cm,12 cm");
				rb4.setName("13sq cm,15 cm");
				correctAns = "6sq cm,12 cm";//correct answer
				System.out.println(correctAns);
            }
            else if(buttonType == "trapezium"){
                picPanel.remove(picLabel);
                try{
                    System.out.println("in try");
                    myPicture = ImageIO.read(new File("./img/trapezium.png"));
                }
                catch(IOException ex){}
                picLabel = null;
                picLabel = new JLabel(new ImageIcon(myPicture));
                picLabel.setBounds(5, 5, 300, 255);
                picPanel.add(picLabel);
                picPanel.setVisible(false);
                picPanel.setVisible(true);
                label1.setText("|| side'a'");
                label2.setText("|| side'b'");
                val2.setVisible(true);
                val3.setVisible(true);
                label4.setText("height'h'");
				action3.setVisible(false);
				question1.setText("Q.Find the area of trapezium whose || sides & height are 12 , 4 and 6?");//write question
				rb1.setText("64sq cm");//option1
				rb2.setText("34sq cm");
				rb3.setText("48sq cm");
				rb4.setText("30sq cm");
				rb1.setName("64sq cm");
				rb2.setName("34sq cm");
				rb3.setName("48sq cm");
				rb4.setName("30sq cm");
				correctAns = "48sq cm";//correct answer
				System.out.println(correctAns);
            }
            else if(buttonType == "sphere"){
                picPanel.remove(picLabel);
                try{
                    System.out.println("in try");
                    myPicture = ImageIO.read(new File("./img/sphere.png"));
                }
                catch(IOException ex){}
                picLabel = null;
                picLabel = new JLabel(new ImageIcon(myPicture));
                picLabel.setBounds(5, 5, 300, 255);
                picPanel.add(picLabel);
                picPanel.setVisible(false);
                picPanel.setVisible(true);
                label1.setText("radius");
                label2.setText(" ");
                label3.setText("result");//result
                label4.setText(" ");//top for third value
                val2.setVisible(false);
                val3.setVisible(false);
				action3.setVisible(true);
				question1.setText("Q.Find the volume and TSA of sphere whose radius is 14cm?");//write question
				rb1.setText("640sq cm,2400 cm");//option1
				rb2.setText("820sq cm,2462 cm");
				rb3.setText("480sq cm,3132 cm");
				rb4.setText("300sq cm,2240 cm");
				rb1.setName("640sq cm,2400 cm");
				rb2.setName("820sq cm,2462 cm");
				rb2.setName("820sq cm,2462 cm");
				rb3.setName("480sq cm,3132 cm");
				rb4.setName("300sq cm,2240 cm");
				correctAns = "820sq cm,2462 cm";//correct answer
				System.out.println(correctAns);
            }
            else if(buttonType == "cube"){
                picPanel.remove(picLabel);
                try{
                    System.out.println("in try");
                    myPicture = ImageIO.read(new File("./img/cube.png"));
                }
                catch(IOException ex){}
                picLabel = null;
                picLabel = new JLabel(new ImageIcon(myPicture));
                picLabel.setBounds(5, 5, 300, 255);
                picPanel.add(picLabel);
                picPanel.setVisible(false);
                picPanel.setVisible(true);
                label1.setText("edge");
                label2.setText(" ");
                label3.setText("result");//result
                label4.setText(" ");//top for third value
                val2.setVisible(false);
                val3.setVisible(false);
				action3.setText("LSA");
				action3.setVisible(true);
				question1.setText("Q.Find the volume and TSA of cube whose edge length is 4cm?");//write question
				rb1.setText("54cubic cm , 66sq cm");//option1
				rb2.setText("72cubic cm , 98sq cm");
				rb3.setText("64cubic cm , 96sq cm");
				rb4.setText("98cubic cm , 92sq cm");
				rb1.setName("54cubic cm , 66sq cm");
				rb2.setName("72cubic cm , 98sq cm");
				rb3.setName("64cubic cm , 96sq cm");
				rb4.setName("98cubic cm , 92sq cm");
				correctAns = "64cubic cm , 96sq cm";//correct answer
				System.out.println(correctAns);
            }
            else if(buttonType == "cylinder"){
                picPanel.remove(picLabel);
                try{
                    System.out.println("in try");
                    myPicture = ImageIO.read(new File("./img/cylinder.png"));
                }
                catch(IOException ex){}
                picLabel = null;
                picLabel = new JLabel(new ImageIcon(myPicture));
                picLabel.setBounds(5, 5, 300, 255);
                picPanel.add(picLabel);
                picPanel.setVisible(false);
                picPanel.setVisible(true);
                label1.setText("radius");
                label2.setText("height");
                label3.setText("result");//result
                label4.setText(" ");//top for third value
                val2.setVisible(true);
                val3.setVisible(false);
				action3.setVisible(true);
				question1.setText("Q.Find the volume and CSA of cylinder whose radius and height are 7cm and 14cm?");//write question
				rb1.setText("254cubic cm , 366sq cm");//option1
				rb2.setText("972cubic cm , 498sq cm");
				rb3.setText("2154cubic cm , 615sq cm");
				rb4.setText("1098cubic cm , 692sq cm");
				rb1.setName("254cubic cm , 366sq cm");
				rb2.setName("972cubic cm , 498sq cm");
				rb3.setName("2154cubic cm , 615sq cm");
				rb4.setName("1098cubic cm , 692sq cm");
				correctAns = "2154cubic cm , 615sq cm";//correct answer
				System.out.println(correctAns);
            }
            else if(buttonType == "cone"){
                picPanel.remove(picLabel);
                try{
                    System.out.println("in try");
                    myPicture = ImageIO.read(new File("./img/cone.png"));
                }
                catch(IOException ex){}
                picLabel = null;
                picLabel = new JLabel(new ImageIcon(myPicture));
                picLabel.setBounds(5, 5, 300, 255);
                picPanel.add(picLabel);
                picPanel.setVisible(false);
                picPanel.setVisible(true);
                label1.setText("radius");
                label2.setText("height");
                label3.setText("result");//result
                label4.setText(" ");//top for third value
                val2.setVisible(true);
                val3.setVisible(false);
				action3.setVisible(true);
				question1.setText("Q.Find the CSA of cone whose radius and slant height are 14cm and 7cm?");//write question
				rb1.setText("308sq cm");//option1
				rb2.setText("498sq cm");
				rb3.setText("615sq cm");
				rb4.setText("692sq cm");
				rb1.setName("308sq cm");
				rb2.setName("498sq cm");
				rb3.setName("2615sq cm");
				rb4.setName("692sq cm");
				correctAns = "308sq cm";//correct answer
				System.out.println(correctAns);
            }
            else if(buttonType == "hemisphere"){
                picPanel.remove(picLabel);
                try{
                    System.out.println("in try");
                    myPicture = ImageIO.read(new File("./img/hemisphere.png"));
                }
                catch(IOException ex){}
                picLabel = null;
                picLabel = new JLabel(new ImageIcon(myPicture));
                picLabel.setBounds(5, 5, 300, 255);
                picPanel.add(picLabel);
                picPanel.setVisible(false);
                picPanel.setVisible(true);
                label1.setText("radius");
                label2.setText(" ");
                label3.setText("result");//result
                label4.setText(" ");//top for third value
                val2.setVisible(false);
                val3.setVisible(false);
				action3.setVisible(true);
				question1.setText("Q.Find the TSA of hemisphere whose radius is 7cm?");//write question
				rb1.setText("366sq cm");//option1
				rb2.setText("498sq cm");
				rb3.setText("462sq cm");
				rb4.setText("398sq cm");
				rb1.setName("366sq cm");
				rb2.setName("498sq cm");
				rb3.setName("462sq cm");
				rb4.setName("398sq cm");
				correctAns = "462sq cm";//correct answer
				System.out.println(correctAns);
            }
            else if(buttonType == "cuboid"){
                picPanel.remove(picLabel);
                try{
                    System.out.println("in try");
                    myPicture = ImageIO.read(new File("./img/cuboid.png"));
                }
                catch(IOException ex){}
                picLabel = null;
                picLabel = new JLabel(new ImageIcon(myPicture));
                picLabel.setBounds(5, 5, 300, 255);
                picPanel.add(picLabel);
                picPanel.setVisible(false);
                picPanel.setVisible(true);
                label1.setText("breadth");
                label2.setText("height");
                label3.setText("result");//result
                label4.setText("length");//top for third value
                val2.setVisible(true);
                val3.setVisible(true);
				action3.setText("LSA");
				action3.setVisible(true);
				question1.setText("Q.Find the volume and LSA of cuboid whose L , B , and H are 4cm , 6cm and 8cm?");//write question
				rb1.setText("154cubic cm , 166sq cm");//option1
				rb2.setText("172cubic cm , 198sq cm");
				rb3.setText("164cubic cm , 196sq cm");
				rb4.setText("192cubic cm , 160sq cm");
				rb1.setName("154cubic cm , 166sq cm");
				rb2.setName("172cubic cm , 198sq cm");
				rb3.setName("164cubic cm , 196sq cm");
				rb4.setName("192cubic cm , 160sq cm");
				correctAns = "192cubic cm , 160sq cm";//correct answer
				System.out.println(correctAns);
            }
			
        }

        //logic for calculation

        else if(buttonType == "area" || buttonType == "perimeter"
                || buttonType == "TSA" || buttonType == "volume" || buttonType == "CSA"){
			if(typeOfObject == "rectangle"){
				num1 = Integer.parseInt(val1.getText());
				num2 = Integer.parseInt(val2.getText());
				if(buttonType == "area"){
					result = String.valueOf(num1*num2);
				}
				else if(buttonType == "perimeter"){
					result =String.valueOf(2*(num1+num2));
				}
			}
			else if(typeOfObject == "parallelogram"){
				num1 = Integer.parseInt(val1.getText());
				num2 = Integer.parseInt(val2.getText());
				num3 = Integer.parseInt(val3.getText());
				if(buttonType == "area"){
					result = String.valueOf(num1*num2);
				}
				else if(buttonType=="perimeter"){
					result = String.valueOf(2*(num1+num3));
				}
			}
            else if(typeOfObject == "square" || typeOfObject == "circle"){
                num1 = Integer.parseInt(val1.getText());
                if(typeOfObject == "square"){
                    if(buttonType == "area"){
                        result = String.valueOf(num1*num1);
                    }
                    else if(buttonType=="perimeter"){
                        result = String.valueOf(2*(num1+num1));
                    }
                }
                if(typeOfObject == "circle"){
                    if(buttonType == "area"){
                        result = String.valueOf(3.14*num1*num1);
                    }
                    else if(buttonType=="perimeter"){
                        result = String.valueOf(2*3.14*num1);
                    }
                }
            }
            else if(typeOfObject == "triangle"  || typeOfObject == "trapezium"){
                num1 = Integer.parseInt(val1.getText());
                num2 = Integer.parseInt(val2.getText());
                num3 = Integer.parseInt(val3.getText());
                if(typeOfObject == "triangle"){
                    if(buttonType == "area"){
                        slant = (num1+num2+num3)*0.5;
                        slant = Math.sqrt(slant*(slant-num1)*(slant-num2)*(slant-num3));
                        result = String.valueOf(slant);
                    }
                    else if(buttonType=="perimeter"){
                        result = String.valueOf(num1+num2+num3);
                    }
                }
                if(typeOfObject == "trapezium"){
                    if(buttonType == "area"){
                        result = String.valueOf(0.5*num3*(num1+num2));
                    }
                    else if(buttonType=="perimeter"){
						if(num1<num2){
							slant = Math.sqrt(((num2-num1)*(num2-num1)*0.25)+((num3)*(num3)));
						}
						else if(num1>num2){
							slant = Math.sqrt(((num1-num2)*(num1-num2)*0.25)+((num3)*(num3)));
						}
                        result = String.valueOf(num1+num2+slant+slant);
                    }
                }
            }
            else if(typeOfObject == "cylinder" || typeOfObject == "cone"){
                num1 = Integer.parseInt(val1.getText());
                num2 = Integer.parseInt(val2.getText());
                if(typeOfObject == "cylinder"){
                    if(buttonType == "TSA"){
                        result = String.valueOf(2*3.14*num1*(num1+num2));
                    }
                    else if(buttonType=="volume"){
                        result = String.valueOf(3.14*num1*num1*num2);
                    }
					else if(buttonType=="CSA"){
						result = String.valueOf(2*3.14*num1*num2);
					}
                }
                if(typeOfObject == "cone"){
                    if(buttonType == "TSA"){
                        slant = Math.sqrt((num1*num1 + num2*num2));
                        result = String.valueOf(3.14*num1*(num1+slant));
                    }
                    else if(buttonType=="volume"){
                        result = String.valueOf(0.33*3.14*num1*num1*num2);
                    }
					else if(buttonType == "CSA"){
						result = String.valueOf(3.14*num1*slant);
					}
                }
            }
            else if(typeOfObject == "sphere" || typeOfObject == "cube" || typeOfObject == "hemisphere"){
                num1 = Integer.parseInt(val1.getText());
                if(typeOfObject == "sphere"){
                    if(buttonType == "TSA"){
                        result = String.valueOf(4*3.14*num1*num1);
                    }
                    else if(buttonType=="volume"){
                        result = String.valueOf((1.333)*3.14*num1*num1*num1);
                    }
					else if(buttonType == "CSA"){
                        result = String.valueOf(4*3.14*num1*num1);
                    }
                }
                if(typeOfObject == "hemisphere"){
                    if(buttonType == "TSA"){
                        result = String.valueOf(3*3.14*num1*num1);
                    }
                    else if(buttonType=="volume"){
                        result = String.valueOf((0.666)*3.14*num1*num1*num1);
                    }
					else if(buttonType == "CSA"){
						result = String.valueOf(2*3.14*num1*num1);
					}
                }
                if(typeOfObject == "cube"){
                    if(buttonType == "TSA"){
                        result = String.valueOf(6*num1*num1);
                    }
                    else if(buttonType=="volume"){
                        result = String.valueOf(num1*num1*num1);
					
                    }
					else if(buttonType == "CSA"){
					result = String.valueOf(4*num1*num1);	
						
					}
                }
            }
            else if(typeOfObject == "cuboid"){
                num1 = Integer.parseInt(val1.getText());
                num2 = Integer.parseInt(val2.getText());
                num3 = Integer.parseInt(val3.getText());
                if(buttonType == "TSA"){
                    result = String.valueOf(2*(num1*num2+num2*num3+num1*num3));
                }
                else if(buttonType=="volume"){
                    result = String.valueOf(num1*num2*num3);
					
                }
				else if(buttonType=="CSA"){
                    result = String.valueOf(2*(num1+num3)*num2);
                }
            }
            res.setText(result);
        }
    }
    
}
