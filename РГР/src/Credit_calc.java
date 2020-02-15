import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Credit_calc {
	//�������� ������� ��� ��������� ������� ���������� � ������� ����������
	//������������ ���������� �� ���� ������ ����� �������
	public static double summa (double a) {				//����� ��� ����� 
		return (double)(Math.round (a*100))/100;		
	}
	public static double srok (double a) {				//����� ��� �����
		return Math.floor(a);
	}
	public static double percent (double a) {			//����� ��� ���������
		return (double)(Math.round (a*100))/100;
	}
	public static double result (double summa, double srok, double percent) {		//����� ��� ������� ����������
		percent = (double)(Math.round (percent*10000/12))/1000000;					//������� �� ������� � �������� ���������� ������
		return ((double)Math.round (summa*(percent+(percent/(Math.pow((1+percent), srok)-1)))*srok*100))/100;	//������� ��� ������� �������
	}
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame();							//�������� ���������� ������������ ����������
		//������� ���������� ����������
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	//����� �������� ��� �������� ���� 
		window.setSize(435, 350); 								//������
		JPanel mainPanel=new JPanel();							//�������� ������� ������
		mainPanel.setLayout(null); 								//��� ������������ ����������� null
		window.setContentPane(mainPanel); 						//���������� ����������� � ���������
		window.setVisible(true);								//����������� ����������
		window.setLocationRelativeTo(null);						//������������ ���� �� ������ ������

		
		JTextField SummaF = new JTextField(20);					//�������� ���������� ���� �����
		SummaF.setLocation(10,50);								
		SummaF.setSize(390,30);
		SummaF.setFont(new Font("Dialog", Font.PLAIN, 22));
		mainPanel.add(SummaF);									//���������� ���� �� ������
		
		////////////////////////////////////////////////////////////////////////////
		
		JTextField SrokF = new JTextField(20);					//�������� ���������� ���� �����
		SrokF.setLocation(10,125);
		SrokF.setSize(390,30);
		SrokF.setFont(new Font("Dialog", Font.PLAIN, 22));
		mainPanel.add(SrokF);									//���������� ���� �� ������		
		
		////////////////////////////////////////////////////////////////////////////
		
		JTextField PercentF = new JTextField(20);				//�������� ���������� ���� �����
		PercentF.setLocation(10,200);
		PercentF.setSize(390,30);
		PercentF.setFont(new Font("Dialog", Font.PLAIN, 22));
		mainPanel.add(PercentF);								//���������� ���� �� ������

		////////////////////////////////////////////////////////////////////////////
		Font font = new Font("Verdana", Font.BOLD, 12);			//�������� �����
		
		JLabel Header = new JLabel("��� �������� ������� ��������� ��������������� ����");	//�������� �������
		Header.setLocation(15,5);
		Header.setSize(390,15);
		Header.setFont(font);
		mainPanel.add(Header);									//���������� ������� �� ������
		
		JLabel Sumlb = new JLabel("1.������� ����� �������");	//�������� �������
		Sumlb.setLocation(10,30);
		Sumlb.setSize(200,15);
		Sumlb.setFont(new Font("Dialog", Font.ITALIC, 12));
		mainPanel.add(Sumlb);									//���������� ������� �� ������
		
		JLabel Sroklb = new JLabel("2.������� ���� ��������� ������� (���.)");	//�������� �������
		Sroklb.setLocation(10,105);
		Sroklb.setSize(300,15);
		Sroklb.setFont(new Font("Dialog", Font.ITALIC, 12));
		mainPanel.add(Sroklb);									//���������� ������� �� ������
		
		JLabel Perclb = new JLabel("3.������� ���������� ������ (%)");	//�������� �������
		Perclb.setLocation(10,180);
		Perclb.setSize(230,15);
		Perclb.setFont(new Font("Dialog", Font.ITALIC, 12));
		mainPanel.add(Perclb);									//���������� ������� �� ������
		
		// �������� �������� ���������� �� ������
		
		JLabel SummErrorlb = new JLabel("");					//�������� �������
		SummErrorlb.setLocation(10,80);
		SummErrorlb.setSize(390,20);
		SummErrorlb.setFont(font);
		SummErrorlb.setForeground(Color.RED);
		mainPanel.add(SummErrorlb);								//���������� ������� �� ������
		
		JLabel SrokErrorlb = new JLabel("");					//�������� �������
		SrokErrorlb.setLocation(10,158);
		SrokErrorlb.setSize(390,20);
		SrokErrorlb.setFont(font);
		SrokErrorlb.setForeground(Color.RED);
		mainPanel.add(SrokErrorlb);								//���������� ������� �� ������
				
		JLabel PercErrorlb = new JLabel("");					//�������� �������
		PercErrorlb.setLocation(10,233);
		PercErrorlb.setSize(390,20);
		PercErrorlb.setFont(font);
		PercErrorlb.setForeground(Color.RED);
		mainPanel.add(PercErrorlb);								//���������� ������� �� ������
		
		////////////////////////////////////////////////////////////////////////////
		
		JButton ResultB = new JButton ("���������");			//�������� ������
		ResultB.setLocation(90,255);
		ResultB.setSize(250,40);
		ResultB.setForeground(Color.white);
		ResultB.setBackground(Color.blue);
		mainPanel.add(ResultB);									//���������� ������ �� ������
		
		//����� ��������� ������� ������ �� ������
		ResultB.addMouseListener( new MouseAdapter()			
		{
		public void mouseClicked(MouseEvent event) {
			/////�������� �����/////
			boolean error = false;				//��������� ��������� �� ������� ������
			//�������� �� ����������� ������ �����
			switch(SummaF.getText()) {
			case(""):	SummErrorlb.setText("��������� ����!"); error = true; break;
			default: SummErrorlb.setText("");}		
			
			switch(SrokF.getText()) {
			case(""):	SrokErrorlb.setText("��������� ����!"); error = true; break;
			default: SrokErrorlb.setText("");}
			
			switch(PercentF.getText()) {
			case(""):	PercErrorlb.setText("��������� ����!"); error = true; break;
			default: PercErrorlb.setText("");}
			
			//�������� �� ���� �����
			if (SummaF.getText().length() > 0){
			try { Double summa = Double.parseDouble(SummaF.getText()); }
			catch (NumberFormatException ex) {SummErrorlb.setText("����� ������� ������ �����"); error = true;}}			//�������� �� ������ ����������
			
			if (SrokF.getText().length() > 0){
			try { Double srok = Double.parseDouble(SrokF.getText()); }
			catch (NumberFormatException ex) {SrokErrorlb.setText("����� ������� ������ ����� (�����)"); error = true;}}	//�������� �� ������ ����������
			
			if (PercentF.getText().length() > 0){
			try { Double percent = Double.parseDouble(PercentF.getText()); }
			catch (NumberFormatException ex) {PercErrorlb.setText("����� ������� ������ �����"); error = true;}}			//�������� �� ������ ����������
			
			//�������� ��������� �������� //����� - �� 1000 �� 20 000 000 // ���� - �� 3 ������� �� 50 ��� (600 ���.) // �������� - ������ 100
			if (error == false) {
				if (SummaF.getText().length() > 0){
					Float a = Float.parseFloat(SummaF.getText());
					if (a < 1000) { SummErrorlb.setText("����������� ����� �������  - 1000�."); error = true;}
					if (a > 20000000) {SummErrorlb.setText("������������ ����� ������� - 20 000 000�."); error = true;}}		
				
				if (SrokF.getText().length() > 0){
					Float b = Float.parseFloat(SrokF.getText());
					if (b < 3) { SrokErrorlb.setText("����������� ���� �������  - 3 ���."); error = true;}
					if (b > 600) {SrokErrorlb.setText("������������ ���� ������� - 600 ���."); error = true;}}
			
				if (PercentF.getText().length() > 0){
					Float c = Float.parseFloat(PercentF.getText());
					if (c < 0) { PercErrorlb.setText("����� ��������� ������ ���� � ��������� �� 0 �� 100"); error = true;}
					if (c > 100) {PercErrorlb.setText("����� ��������� ������ ���� � ��������� �� 0 �� 100"); error = true;}}
			}
			/////�������� �����/////
			
			if (error) {return;}
			
			/////�������/////
			double summa = summa (Double.parseDouble(SummaF.getText())); 			//�������������� ����� ������� (2 ����� ����� �������)
			double srok = srok (Double.parseDouble(SrokF.getText()));				//���� � ������� (� ����������� � ��������)
			double percent = percent (Double.parseDouble(PercentF.getText()));		//���������� ������ (2 ����� ����� �������)
			double result = result (summa, srok, percent);							//���������� ����������
			SummaF.setText(Double.toString(summa)); SrokF.setText(Double.toString(srok)); PercentF.setText(Double.toString(percent));
			Double over = result - summa;											//������� ���������
			over = ((double)Math.round (over*100))/100;;
			JOptionPane.showMessageDialog(null, "����� �������� ��������:  " + result + "\n" + "���������:  " + over,"������� ���������", JOptionPane.INFORMATION_MESSAGE);			
			/////�������/////
		}});
	}
}
