importjava.awt.*;
importjava.awt.event.*;
importjavax.swing.*;
importjavax.swing.event.*;
classCalculatorextendsJFrame
{
privatefinal Font BIGGER_FONT = newFont("monspaced",Font.PLAIN, 20);
privateJTextFieldtextfield;
privateboolean number = true;
private String equalOp = "=";
privateCalculatorOp op = newCalculatorOp();
publicCalculator() 
	{
textfield = newJTextField("", 12);
textfield.setHorizontalAlignment(JTextField.RIGHT);
textfield.setFont(BIGGER_FONT);
        ActionListener numberListener = newNumberListener();
        String buttonOrder = "1234567890 ";
JPanelbuttonPanel = newJPanel();
buttonPanel.setLayout(newGridLayout(4, 4, 4, 4));
for (inti = 0; i<buttonOrder.length(); i++) 
		{
            String key = buttonOrder.substring(i, i+1);
if (key.equals(" ")) 
			{
buttonPanel.add(newJLabel(""));
            } 
			else
			{
JButton button = newJButton(key);
button.addActionListener(numberListener);
button.setFont(BIGGER_FONT);
buttonPanel.add(button);
            }
       }
        ActionListener operatorListener = newOperatorListener();
JPanel panel = newJPanel();
panel.setLayout(newGridLayout(4, 4, 4, 4));
String[] opOrder = {"+", "-", "*", "/","=","C","sin","cos","log"};
for (inti = 0; i<opOrder.length; i++) 
		{
JButton button = newJButton(opOrder[i]);
button.addActionListener(operatorListener);
button.setFont(BIGGER_FONT);
panel.add(button);
        }
JPanel pan = newJPanel();
pan.setLayout(newBorderLayout(4, 4));
pan.add(textfield, BorderLayout.NORTH );
pan.add(buttonPanel , BorderLayout.CENTER);
pan.add(panel , BorderLayout.EAST);
this.setContentPane(pan);
this.pack();
this.setTitle("Calculator");
this.setResizable(false);
    }
privatevoidaction() 
	{
        number = true;
textfield.setText("");
equalOp = "=";
op.setTotal("");
    }
classOperatorListenerimplements ActionListener 
	{
publicvoidactionPerformed(ActionEvent e) 
		{
            String displayText = textfield.getText();
if (e.getActionCommand().equals("sin"))
            {
textfield.setText("" + Math.sin(Double.valueOf(displayText).doubleValue()));

            }
elseif (e.getActionCommand().equals("cos"))
            {
textfield.setText("" + Math.cos(Double.valueOf(displayText).doubleValue()));

            }
elseif (e.getActionCommand().equals("log"))
            {
textfield.setText("" + Math.log(Double.valueOf(displayText).doubleValue()));

            }
elseif (e.getActionCommand().equals("C"))
            {
textfield.setText("");
            }
else
            {
if (number)
                {
action();
textfield.setText("");
                }
else
                {
                    number = true;
if (equalOp.equals("="))
                    {
op.setTotal(displayText);
                    }
elseif (equalOp.equals("+"))
                    {
op.add(displayText);
                    }
elseif (equalOp.equals("-"))
                    {
op.subtract(displayText);
                    }
elseif (equalOp.equals("*"))
                    {
op.multiply(displayText);
                    }
elseif (equalOp.equals("/"))
                    {
op.divide(displayText);
                    }
textfield.setText("" + op.getTotalString());
equalOp = e.getActionCommand();
                }
            }
        }
    }
classNumberListenerimplements ActionListener 
	{
publicvoidactionPerformed(ActionEvent event) 
		{
 String digit = event.getActionCommand();
if (number) 
{
textfield.setText(digit);
 number = false;
            } 
else
{
textfield.setText(textfield.getText() + digit);
            }
        }
    }
publicclassCalculatorOp
	{
privateint total;
publicCalculatorOp() 
		{
            total = 0;
        }
public String getTotalString() 
		{
return ""+total;
        }
publicvoidsetTotal(String n) 
		{
            total = convertToNumber(n);
        }
publicvoidadd(String n) 
		{
            total += convertToNumber(n);
        }
publicvoidsubtract(String n) 
		{
            total -= convertToNumber(n);
        }
publicvoidmultiply(String n) 
		{
            total *= convertToNumber(n);
        }
publicvoiddivide(String n) 
		{
            total /= convertToNumber(n);
        }
privateintconvertToNumber(String n) 
{
returnInteger.parseInt(n);
        }
    }
}
classSwingCalculator
{
publicstaticvoidmain(String[] args) 
	{
JFrame frame = newCalculator();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
    }
}
