package Draw;

import java.awt.*;
import java.net.Proxy;

public class Shape {
    private  int x1, y1, x2, y2;
    private  String typeName;

    public Shape(int x1, int y1, int x2, int y2, String typeName)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.typeName = typeName;
    }
    public void repaint(Graphics g){
        switch (typeName){
            case"直线":
                {
                    g.drawLine(x1, y1, x2, y2);
                    break;
                }
            case "圆形":
            {
                g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
                break;
            }
            case "矩形":
            {
                g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
                break;
            }
        }

    }



}
