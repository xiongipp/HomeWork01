package Draw;

import javax.swing.*;
import java.awt.*;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class Frame{

    public static void main(String[] args) {
    Frame frame=new Frame();
    frame.showPaper();
    }
    public  void showPaper(){

        JFrame jf= new  JFrame();
        jf.setTitle("Draw画图");
        jf.setSize(600,600);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new FlowLayout());
        ButtonListener buttonListener=new ButtonListener();//创建监听对象
        //给窗口加图形选项按钮
        String []shape={"圆形","直线","三角形","矩形"};
        for(int i=0;i<shape.length;i++){
            JButton button=new JButton(shape[i]);
            button.addActionListener(buttonListener);
            jf.add(button);
        }
        /*
        JButton circle=new JButton("圆形");
        JButton Line=new JButton("直线");
        circle.addActionListener(buttonListener);
        Line.addActionListener(buttonListener);
        jf.add(circle);
        jf.add(Line);
        */
        JButton colorChooser=new JButton("选择颜色");
       colorChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ButtonListener.color=JColorChooser.showDialog(jf,"选择颜色",null);
                colorChooser.setBackground(ButtonListener.color);
            }
        });
        jf.add(colorChooser);//添加颜色选择按钮
        jf.addMouseListener(buttonListener);//窗口添加鼠标监听
        jf.setVisible(true);
        Graphics G=jf.getGraphics();
        buttonListener.penToListener(G);


    }


}

