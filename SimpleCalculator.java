import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class SimpleCalculator extends JFrame implements ActionListener{
    TextField tf1,tf2,tfResult;
    Button add,sub,mul,div,clear;
    public SimpleCalculator(){
        setLayout(new GridLayout(2,5,20,20));
        tf1= new TextField();
        tf2 = new TextField();
        tfResult = new TextField();
        tfResult.setEditable(false);
        add = new Button("+");
        sub = new Button("-");
        mul = new Button ("*");
        div = new Button("/");
        clear = new Button("Clear");
        add(new Label("First Number: "));
        add(tf1);
        add(new Label("Second Number: "));
        add(tf2);
        add(new Label("Result: "));
        add(tfResult);
        add(add);
        add(sub);
        add(mul);
        add(div);
        add(clear);
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        clear.addActionListener(this);

        setTitle("Priyanshu Kumar Calculator");
        setSize(500,500);
        setVisible(true);

        setBackground(Color.red);
        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent we){dispose();}});

    }
    public void actionPerformed (ActionEvent ae){
        try{
            double num1= Double.parseDouble(tf1.getText());
            double num2= Double.parseDouble(tf2.getText());
            double result =0;
            if(ae.getSource()==add){
                result=num1+num2;
            }else if(ae.getSource()==sub){
                result = num1- num2;
            }else if(ae.getSource()==mul){
                result = num1*num2;
            }else if(ae.getSource()==div){
                if(num2==0){
                    tfResult.setText("Cannot divide by zero");
                    return;
                }
                result=num1/num2;
            }else if(ae.getSource()==clear){
                tf1.setText("");
                tf2.setText("");
                tfResult.setText("");
                return;
            }
            tfResult.setText(String.valueOf(result));
        }catch(NumberFormatException e){
            tfResult.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new PriyanshuFrameclassCrate.SimpleAWTCalculator();
    }
}