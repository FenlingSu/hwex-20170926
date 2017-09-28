import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static java.lang.Math.random;

public class MainFrame extends Frame {

    private Button btnleft = new Button("<--");
    private Button btnright = new Button("-->");
    private Button btnfire = new Button("Fire");
    private Button btnexit = new Button("exit");
    private Button btnauto = new Button("Auto move right");
    private Button btnauto2 = new Button("Auto move left");
    private Label labgun = new Label("Gun");
    private Label labboom = new Label("B");
    private Label labsun = new Label("Sun");
    private Label labhit = new Label("Hit: 0");
    private Timer t1,t2,t3;
    private int labgunX = 320 , bulY=320 , sunw = 200 , sunh = 200 , n = 0 , ran ,ran2;
    private boolean flag=true;



    public MainFrame() {
        initComp();
    }

    public void initComp(){
        this.setBounds(100,100,700,500);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        this.setLayout(null);

        btnleft.setBounds(248,370,50,30);
        btnfire.setBounds(320,370,50,30);
        btnright.setBounds(390,370,50,30);
        this.add(btnleft);
        this.add(btnfire);
        this.add(btnright);

        labgun.setBounds(labgunX,320,50,30);               //砲塔
        this.add(labgun);

        btnleft.addActionListener(new ActionListener() {                    //向左按鈕
            @Override
            public void actionPerformed(ActionEvent e) {
                labgunX -=10;
                labgun.setLocation(labgunX,320);
                labboom.setLocation(labgunX,bulY);
                t1.stop();
                t2.stop();
            }
        });
        btnright.addActionListener(new ActionListener() {                   //向右按鈕
            @Override
            public void actionPerformed(ActionEvent e) {
                labgunX +=10;
                labgun.setLocation(labgunX,320);
                labboom.setLocation(labgunX,bulY);
                t1.stop();
                t2.stop();
            }
        });


        btnauto.setBounds(40,450,90,30);                //自動向右
        this.add(btnauto);
        btnauto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.start();
                t2.stop();
            }
        });

        btnauto2.setBounds(135,450,90,30);              //自動向左
        this.add(btnauto2);
        btnauto2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t2.start();
                t1.stop();
            }
        });


        t1 = new Timer(50, new ActionListener() {                      //自動向右設定
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag) {
                    labgunX += 5;
                    labgun.setLocation(labgunX,320);
                    labboom.setLocation(labgunX,bulY);
                    if (labgunX > MainFrame.this.getWidth()) {
                        flag = false;
                    }
                }
                else {
                    labgunX -= 5;
                    labgun.setLocation(labgunX,320);
                    labboom.setLocation(labgunX,bulY);
                    if (labgunX < 0) {
                        flag = true;
                    }
                }
            }
        });

        t2 = new Timer(50, new ActionListener() {                       //自動向左設定
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag) {
                    labgunX -= 5;
                    labgun.setLocation(labgunX,320);
                    labboom.setLocation(labgunX,bulY);
                    if (labgunX < 0) {
                        flag = false;
                    }
                }
                else {
                    labgunX += 5;
                    labgun.setLocation(labgunX,320);
                    labboom.setLocation(labgunX,bulY);
                    if (labgunX > MainFrame.this.getWidth()) {
                        flag = true;
                    }
                }
            }
        });


        labboom.setBounds(labgunX,bulY,13,20);                      //子彈
        this.add(labboom);

        labsun.setBounds(sunw,sunh,30,30);                          //太陽
        this.add(labsun);

        labhit.setBounds(160,390,80,30);                      //得分
        this.add(labhit);

        btnfire.addActionListener(new ActionListener() {                          //射擊按鈕
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.stop();
                t2.stop();
                t3.start();
            }
        });



        t3 = new Timer(50, new ActionListener() {                          //子彈射擊設定
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag) {
                    bulY -= 10;
                    labboom.setLocation(labgunX, bulY);
                    if (bulY < 0) {
                        flag = false;
                    }
                } else {
                    bulY = 320;
                    labboom.setLocation(labgunX, bulY);
                    t3.stop();
                    if (bulY > 0) {
                        flag = true;
                    }
                }
                if ( labgunX >= sunw - 5 && labgunX <= sunw + 20 && bulY <= sunh + 10 && bulY >= sunh - 40) {

                    ran = (int) (Math.random() * (MainFrame.this.getWidth() - 80) + 50);    //產生亂數
                    sunw = ran;
                    ran2 = (int) (Math.random() * (MainFrame.this.getHeight() - 350) + 50); //產生亂數
                    sunh = ran2;
                    labsun.setLocation(sunw, sunh);
                    n++;                                                                    //增加得分
                    labhit.setText("Hit:" + Integer.toString(n));
                    flag = false;                                                           //子彈歸位
                }
            }
        });


        btnexit.setBounds(600,450,50,30);                               //結束按鈕
        this.add(btnexit);
        btnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }


}