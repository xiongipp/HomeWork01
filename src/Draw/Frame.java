package Draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.lang.reflect.Constructor;
import java.text.AttributedCharacterIterator;

public class Frame extends JPanel{

    public static void main(String[] args) throws NoSuchMethodException {
     Frame frame= new  Frame();

      Class<Frame>clazz1=Frame.class;//.class属性
      System.out.println(clazz1.getCanonicalName());
      System.out.println(clazz1.getClassLoader());
      System.out.println(clazz1.getTypeName());

      Constructor constructor=clazz1.getConstructor();
      System.out.println(constructor.toString());
      Constructor constructor1=clazz1.getConstructor(String.class);
      System.out.println(constructor1.toString());
      Constructor constructor2=clazz1.getConstructor(String.class,int.class);
      System.out.println(constructor2.toString());
      //Constructor constructor3=clazz1.getConstructor(boolean.class);会报错，getConstructor无法获取非公有构造方法
      Constructor[] constructors=clazz1.getConstructors();//getConstructor方法获取构造列表
      for(Constructor constructor3:constructors){
          System.out.println(constructor3.toString());
      }

      System.out.println(frame.getClass());//getClass方法

      String className="Draw.Shape";
        try {
            Class<?> clazz2=Class.forName(className);//forName方法
            System.out.println(clazz2.getTypeName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
        Shape []shapearr=new Shape[100];
        public Frame(String name){}//*该构造函数只是为了测试函数没有实际功能
        public Frame(String name,int n){}//*
        protected Frame(boolean s){}//*
        public  Frame(){
        JFrame jf= new  JFrame();
        jf.setTitle("Draw画图");
        jf.setSize(600,600);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new FlowLayout());
        ButtonListener buttonListener=new ButtonListener();//创建监听对象
        //给窗口加图形选项按钮
        String []shape={"圆形","直线","矩形"};
        for(int i=0;i<shape.length;i++){
            JButton button=new JButton(shape[i]);
            button.addActionListener(buttonListener);
            jf.add(button);
        }
        //给窗口加颜色选项按钮
        JButton colorChooser=new JButton("选择颜色");
        colorChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ButtonListener.color=JColorChooser.showDialog(jf,"选择颜色",null);
                colorChooser.setBackground(ButtonListener.color);
            }
        });
        jf.add(colorChooser);
        jf.addMouseListener(buttonListener);//窗口添加鼠标监听
        jf.add(this);
        jf.setVisible(true);
        Graphics G=jf.getGraphics();
        buttonListener.penToListener(G);
        buttonListener.setShapeArray(shapearr);

    }
    @Override
    public void paint(Graphics g)
    {
        System.out.println("绘制窗口");
        super.paint(g);
        g.drawLine(300, 50, 300, 200);
        int len=ButtonListener.getLen();
        System.out.println(len);
        for(int i=0;i<len;i++){
            if(shapearr[i]!=null){
                shapearr[i].repaint(g);
                System.out.println(shapearr[i].toString());
            }else
            {
                break;
            }
        }
    }
}












