package Draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class  ButtonListener implements MouseListener, ActionListener{
    //private JPanel jp;
    private Graphics g;
    private String Command="";
    private Shape shapearry[];
    static int i=0;
    public static Color color=Color.black;//设置画笔默认颜色为黑
    int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
    public static int getLen(){
        return i;
    }

    @Override
    //获得button命令
    public void actionPerformed(ActionEvent actionEvent) {
        String buttonName=actionEvent.getActionCommand();
        Command=buttonName;
        System.out.println(Command);
    }

    // Override鼠标监听//点击
    public void mouseClicked(MouseEvent e) {

    }

    @Override // 按下
    public void mousePressed(MouseEvent e) {
        //鼠标按下的时候，分别获取起点的横纵坐标,设置画笔颜色
        x1 = e.getX();
        y1 = e.getY();
        g.setColor(color);
        System.out.println(x1);
        System.out.println(y1);
    }

    @Override // 松开
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        //鼠标松开的时候，分别获取终点的横纵坐标
        x2 = e.getX();
        y2 = e.getY();
        if("直线".equals(Command)){
            g.drawLine(x1, y1, x2, y2);
            shapearry[i++]=new Shape(x1, y1, x2, y2,"直线");

        }
        if("圆形".equals(Command)){
            g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
            shapearry[i++]=new Shape(x1, y1, x2, y2,"圆形");
        }
        if("矩形".equals(Command)){
            g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
            shapearry[i++]=new Shape(x1, y1, x2, y2,"矩形");
        }

    }

    @Override // 进入
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override // 移出
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    public void penToListener(Graphics pen){
        g=pen;
    }
    public void setShapeArray(Shape ShapeArray[]){
        this.shapearry=ShapeArray;
    }

}
