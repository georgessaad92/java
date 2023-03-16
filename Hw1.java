import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hw1 extends JFrame{
  JButton left = new JButton("LEFT");
  JButton right = new JButton("RIGHT");
  JButton up = new JButton("UP");
  JButton down = new JButton("DOWN");
  JPanel p = new JPanel();
  MyPanel mp = new MyPanel();
  ButtonListener b = new ButtonListener();
  public Hw1()
  {p.setLayout(new FlowLayout());
   p.add(left);
   p.add(right);
   p.add(up);
   p.add(down); 
   left.addActionListener(b);
   right.addActionListener(b);
   up.addActionListener(b);
   down.addActionListener(b);
   add(p,BorderLayout.SOUTH);
   add(mp,BorderLayout.CENTER);


  }
    


  public static void main(String[] args)
  { 
      Hw1 frame = new Hw1();
      frame.setTitle("Part 1");
      frame.setSize(400,400);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
  }

  class MyPanel extends JPanel{

    int x=50,y=50;
    
    public MyPanel()
    {}
    
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawOval(x,y,25,25);
    }
    
    public void upWards()
    { if(y==-25)
        y=mp.getHeight();
      else  
        y-=5;
      repaint();}
    public void downWards()
    { if(y==mp.getHeight())
        y=-25;
      else  
        y+=5;
    repaint();}
    public void leftSide()
    {if(x==-25)
       x=mp.getWidth();
     else  
       x-=5;
    repaint();}
    public void rightSide()
    { if(x==mp.getWidth())
        x=-25;
      else  
        x+=5;
    repaint();}
  }  

  class ButtonListener implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
        if(e.getSource()==left)
          mp.leftSide();
        else if(e.getSource()==right)
          mp.rightSide();
        else if(e.getSource()==up)   
          mp.upWards();
        else if(e.getSource()==down)  
          mp.downWards();
    }
  }
}
