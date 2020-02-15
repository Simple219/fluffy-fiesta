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
	//создание методов для обработки входных переменных и расчета результата
	//производится округление до двух знаков после запятой
	public static double summa (double a) {				//метод для суммы 
		return (double)(Math.round (a*100))/100;		
	}
	public static double srok (double a) {				//метод для срока
		return Math.floor(a);
	}
	public static double percent (double a) {			//метод для процентов
		return (double)(Math.round (a*100))/100;
	}
	public static double result (double summa, double srok, double percent) {		//метод для расчета результата
		percent = (double)(Math.round (percent*10000/12))/1000000;					//перевод из годовой в месячную процентную ставку
		return ((double)Math.round (summa*(percent+(percent/(Math.pow((1+percent), srok)-1)))*srok*100))/100;	//формула для расчета кредита
	}
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame();							//создание контейнера графического интерфейса
		//задание параметров контейнера
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	//выбор операция при закрытии окна 
		window.setSize(435, 350); 								//размер
		JPanel mainPanel=new JPanel();							//создание главной панели
		mainPanel.setLayout(null); 								//тип расположение компонентов null
		window.setContentPane(mainPanel); 						//добавление содержимого в контейнер
		window.setVisible(true);								//отображение контейнера
		window.setLocationRelativeTo(null);						//расположение окна по центру экрана

		
		JTextField SummaF = new JTextField(20);					//создание текстового поля ввода
		SummaF.setLocation(10,50);								
		SummaF.setSize(390,30);
		SummaF.setFont(new Font("Dialog", Font.PLAIN, 22));
		mainPanel.add(SummaF);									//добавление поля на панель
		
		////////////////////////////////////////////////////////////////////////////
		
		JTextField SrokF = new JTextField(20);					//создание текстового поля ввода
		SrokF.setLocation(10,125);
		SrokF.setSize(390,30);
		SrokF.setFont(new Font("Dialog", Font.PLAIN, 22));
		mainPanel.add(SrokF);									//добавление поля на панель		
		
		////////////////////////////////////////////////////////////////////////////
		
		JTextField PercentF = new JTextField(20);				//создание текстового поля ввода
		PercentF.setLocation(10,200);
		PercentF.setSize(390,30);
		PercentF.setFont(new Font("Dialog", Font.PLAIN, 22));
		mainPanel.add(PercentF);								//добавление поля на панель

		////////////////////////////////////////////////////////////////////////////
		Font font = new Font("Verdana", Font.BOLD, 12);			//создание стиля
		
		JLabel Header = new JLabel("Для рассчета кредита заполните соответствующие поля");	//создание надписи
		Header.setLocation(15,5);
		Header.setSize(390,15);
		Header.setFont(font);
		mainPanel.add(Header);									//добавление надписи на панель
		
		JLabel Sumlb = new JLabel("1.Введите сумму кредита");	//создание надписи
		Sumlb.setLocation(10,30);
		Sumlb.setSize(200,15);
		Sumlb.setFont(new Font("Dialog", Font.ITALIC, 12));
		mainPanel.add(Sumlb);									//добавление надписи на панель
		
		JLabel Sroklb = new JLabel("2.Введите срок погашения кредита (мес.)");	//создание надписи
		Sroklb.setLocation(10,105);
		Sroklb.setSize(300,15);
		Sroklb.setFont(new Font("Dialog", Font.ITALIC, 12));
		mainPanel.add(Sroklb);									//добавление надписи на панель
		
		JLabel Perclb = new JLabel("3.Введите процентную ставку (%)");	//создание надписи
		Perclb.setLocation(10,180);
		Perclb.setSize(230,15);
		Perclb.setFont(new Font("Dialog", Font.ITALIC, 12));
		mainPanel.add(Perclb);									//добавление надписи на панель
		
		// Создание надписей сообщающих об ошибке
		
		JLabel SummErrorlb = new JLabel("");					//создание надписи
		SummErrorlb.setLocation(10,80);
		SummErrorlb.setSize(390,20);
		SummErrorlb.setFont(font);
		SummErrorlb.setForeground(Color.RED);
		mainPanel.add(SummErrorlb);								//добавление надписи на панель
		
		JLabel SrokErrorlb = new JLabel("");					//создание надписи
		SrokErrorlb.setLocation(10,158);
		SrokErrorlb.setSize(390,20);
		SrokErrorlb.setFont(font);
		SrokErrorlb.setForeground(Color.RED);
		mainPanel.add(SrokErrorlb);								//добавление надписи на панель
				
		JLabel PercErrorlb = new JLabel("");					//создание надписи
		PercErrorlb.setLocation(10,233);
		PercErrorlb.setSize(390,20);
		PercErrorlb.setFont(font);
		PercErrorlb.setForeground(Color.RED);
		mainPanel.add(PercErrorlb);								//добавление надписи на панель
		
		////////////////////////////////////////////////////////////////////////////
		
		JButton ResultB = new JButton ("Расчитать");			//создание кнопки
		ResultB.setLocation(90,255);
		ResultB.setSize(250,40);
		ResultB.setForeground(Color.white);
		ResultB.setBackground(Color.blue);
		mainPanel.add(ResultB);									//добавление кнопки на панель
		
		//метод обработки нажатия мышкой на кнопку
		ResultB.addMouseListener( new MouseAdapter()			
		{
		public void mouseClicked(MouseEvent event) {
			/////Проверка ввода/////
			boolean error = false;				//переменая говорящая об наличии ошибок
			//проверка на отстутствие пустых полей
			switch(SummaF.getText()) {
			case(""):	SummErrorlb.setText("Заполните поле!"); error = true; break;
			default: SummErrorlb.setText("");}		
			
			switch(SrokF.getText()) {
			case(""):	SrokErrorlb.setText("Заполните поле!"); error = true; break;
			default: SrokErrorlb.setText("");}
			
			switch(PercentF.getText()) {
			case(""):	PercErrorlb.setText("Заполните поле!"); error = true; break;
			default: PercErrorlb.setText("");}
			
			//проверка на ввод чисел
			if (SummaF.getText().length() > 0){
			try { Double summa = Double.parseDouble(SummaF.getText()); }
			catch (NumberFormatException ex) {SummErrorlb.setText("Можно вводить только числа"); error = true;}}			//проверка на выброс исключения
			
			if (SrokF.getText().length() > 0){
			try { Double srok = Double.parseDouble(SrokF.getText()); }
			catch (NumberFormatException ex) {SrokErrorlb.setText("Можно вводить только числа (целые)"); error = true;}}	//проверка на выброс исключения
			
			if (PercentF.getText().length() > 0){
			try { Double percent = Double.parseDouble(PercentF.getText()); }
			catch (NumberFormatException ex) {PercErrorlb.setText("Можно вводить только числа"); error = true;}}			//проверка на выброс исключения
			
			//проверка диапазона значений //сумма - от 1000 до 20 000 000 // срок - от 3 месяцев до 50 лет (600 мес.) // проценты - меньше 100
			if (error == false) {
				if (SummaF.getText().length() > 0){
					Float a = Float.parseFloat(SummaF.getText());
					if (a < 1000) { SummErrorlb.setText("Минимальная сумма кредита  - 1000р."); error = true;}
					if (a > 20000000) {SummErrorlb.setText("Максимальная сумма кредита - 20 000 000р."); error = true;}}		
				
				if (SrokF.getText().length() > 0){
					Float b = Float.parseFloat(SrokF.getText());
					if (b < 3) { SrokErrorlb.setText("Минимальный срок кредита  - 3 мес."); error = true;}
					if (b > 600) {SrokErrorlb.setText("Максимальный срок кредита - 600 мес."); error = true;}}
			
				if (PercentF.getText().length() > 0){
					Float c = Float.parseFloat(PercentF.getText());
					if (c < 0) { PercErrorlb.setText("Число процентов должно быть в диапазоне от 0 до 100"); error = true;}
					if (c > 100) {PercErrorlb.setText("Число процентов должно быть в диапазоне от 0 до 100"); error = true;}}
			}
			/////Проверка ввода/////
			
			if (error) {return;}
			
			/////РАСЧЕТЫ/////
			double summa = summa (Double.parseDouble(SummaF.getText())); 			//первоначальная сумма кредита (2 знака после запятой)
			double srok = srok (Double.parseDouble(SrokF.getText()));				//срок в месяцах (с округлением к меньшему)
			double percent = percent (Double.parseDouble(PercentF.getText()));		//процентная ставка (2 знака после запятой)
			double result = result (summa, srok, percent);							//переменная результата
			SummaF.setText(Double.toString(summa)); SrokF.setText(Double.toString(srok)); PercentF.setText(Double.toString(percent));
			Double over = result - summa;											//подсчет переплаты
			over = ((double)Math.round (over*100))/100;;
			JOptionPane.showMessageDialog(null, "Сумма платежей составит:  " + result + "\n" + "Переплата:  " + over,"Расчеты выполнены", JOptionPane.INFORMATION_MESSAGE);			
			/////РАСЧЕТЫ/////
		}});
	}
}
