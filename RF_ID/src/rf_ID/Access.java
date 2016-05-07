package rf_ID;
/**56. Написать программу, моделирующую систему Контрольно-пропускного пункта на предприятии. 
 * Система КПП состоит из турникета, проход через который осуществляется с помощью карточек доступа.
 *  Каждой карточке доступа соответствует уникальный код, однозначно идентифицирующий сотрудника.
 *   Каждый раз. когда сотрудник входит или выходит из здания, турникет посылает системе данные карты
 *    (код) и дату входа/выхода. Система должна уметь:
 * показывать текущее количество сотрудников в здании
 *показывать время, когда в здании находилось максимальное количество сотрудников
 *сообщать об исключительных ситуациях при попытках несанкционированного доступа/выхода в/из здание/-я:
 *кто-то пытается выйти из здания, когда в здании нет сотрудников
 *кто-то пытается войти в здание по карточке с незарегестрированным номером
 * кто-то пытается войти с картой, которая уже “вошла” в здание
 * кто-то пытается выйти по картой, которая уже “вышла” из здания
*/
import java.awt.EventQueue;
import java.awt.Font;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import com.fazecast.jSerialComm.SerialPort;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Scanner;
import java.awt.Color;
import java.awt.TextArea;
/**
 * 
 * @author victor
 *Database : postrgreSQl
 *TABLES:
 * entry { entry_time TIMESTAMP, card_id VARCHAR(10), direction  VARCHAR(3), primary key: entry_time }
 * person { person_id VARCHAR(10), name VARCHAR[30], photo BYTEA, primary key: person_id}
 * card { card_id  VARCHAR(11), person_id VARCHAR(10), primary key: card_id}
 */
public class Access {

	private AudioClip beepClip; 
	private JFrame frame;
	Guard guard;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

					Access window = new Access();
					window.frame.setVisible(true);
			}
		});
	}
	public Access() {
		guard = new Guard();
		String path = "sound/beep.wav";
		URL soundURL = Access.class.getResource(path);
		if(soundURL != null) {
			beepClip = Applet.newAudioClip(soundURL);
		}
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Access control");
		frame.setResizable(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel mainPanel = new JPanel();
		tabbedPane.addTab("Main", null, mainPanel, null);
		mainPanel.setLayout(null);
		
		JLabel port1Label = new JLabel("No Com Port opened");
		port1Label.setBounds(228, 20, 186, 20);
		mainPanel.add(port1Label);
		
		JButton readBut = new JButton("Read");
		readBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		readBut.setBounds(484, 503, 117, 33);
		mainPanel.add(readBut);
		
		JButton saveBut = new JButton("Save");
		saveBut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		saveBut.setBounds(617, 503, 117, 33);
		mainPanel.add(saveBut);
		
		JTextField personNameText = new JTextField();
		personNameText.setBounds(158, 346, 256, 30);
		mainPanel.add(personNameText);
		personNameText.setColumns(10);
		
		JTextField lastCardText = new JTextField();
		lastCardText.setBounds(158, 304, 256, 30);
		mainPanel.add(lastCardText);
		lastCardText.setColumns(10);
		
		JTextField personIdText = new JTextField();
		personIdText.setBounds(158, 388, 256, 30);
		mainPanel.add(personIdText);
		personIdText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Person ID");
		lblNewLabel.setBounds(31, 395, 70, 15);
		mainPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Person name");
		lblNewLabel_1.setBounds(31, 353, 109, 15);
		mainPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("RFID card");
		lblNewLabel_2.setBounds(31, 311, 70, 15);
		mainPanel.add(lblNewLabel_2);
		
		
		JLabel lblInGate = new JLabel("GATE #1");
		lblInGate.setBounds(47, 23, 70, 15);
		mainPanel.add(lblInGate);

		JLabel lblOutGate = new JLabel("GATE #2");
		lblOutGate.setBounds(47, 120, 70, 15);
		mainPanel.add(lblOutGate);

		JLabel port2Label = new JLabel("No Com Port opened");
		port2Label.setBounds(228, 118, 186, 15);
		mainPanel.add(port2Label);

		JTextField gate1Text = new JTextField();
		gate1Text.setBounds(484, 52, 250, 25);
		mainPanel.add(gate1Text);
		gate1Text.setColumns(10);

		JTextField gate2Text = new JTextField();
		gate2Text.setBounds(484, 145, 250, 25);
		mainPanel.add(gate2Text);
		gate2Text.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 222, 767, 2);
		mainPanel.add(separator);
		
		JTextField entryMessage = new JTextField();
		entryMessage.setBounds(31, 503, 383, 33);
		mainPanel.add(entryMessage);
		entryMessage.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Last message");
		lblNewLabel_5.setBounds(31, 268, 109, 15);
		mainPanel.add(lblNewLabel_5);
		
		JTextField lastText = new JTextField();
		lastText.setBounds(158, 259, 256, 33);
		mainPanel.add(lastText);
		lastText.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Total number");
		lblNewLabel_6.setBounds(31, 429, 105, 30);
		mainPanel.add(lblNewLabel_6);
		
		JTextField totalNumberText = new JTextField();
		totalNumberText.setBounds(158, 430, 254, 30);
		mainPanel.add(totalNumberText);
		totalNumberText.setColumns(10);
		
		JPanel photoPanel = new JPanel();
		photoPanel.setBackground(Color.WHITE);
		photoPanel.setBounds(484, 259, 250, 200);
		mainPanel.add(photoPanel);

		JLabel photoLabel = new JLabel(""); 
		photoPanel.add(photoLabel);

		JPanel logPanel = new JPanel();
		tabbedPane.addTab("Log", null, logPanel, null);
		logPanel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Rush Hour");
		lblNewLabel_3.setBackground(new Color(127, 255, 212));
		lblNewLabel_3.setBounds(36, 474, 214, 35);
		logPanel.add(lblNewLabel_3);

		JTextField rushHourText = new JTextField();
		rushHourText.setBounds(143, 474, 464, 36);
		logPanel.add(rushHourText);
		rushHourText.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Entry Log");
		lblNewLabel_4.setBounds(36, 23, 412, 15);
		logPanel.add(lblNewLabel_4);

		TextArea logText = new TextArea();
		logText.setEditable(false);
		logText.setBounds(30, 73, 573, 353);
		logPanel.add(logText);

		JButton btnGetRushHour = new JButton("Get RH");
		btnGetRushHour.setBounds(646, 473, 117, 36);
		logPanel.add(btnGetRushHour);

		JButton btnLog = new JButton("Get Log");
		btnLog.setBounds(646, 73, 117, 36);
		btnLog.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				logText.setText(guard.getLog());
			}
	
		});
		logPanel.add(btnLog);

		JButton btnClearLog = new JButton("Clear log");
		btnClearLog.setBounds(646, 133, 117, 35);
		btnClearLog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guard.clearLog();
				logText.setText(guard.getLog());
				totalNumberText.setText(guard.numberOfPeopleInside() + "");
			}
	
		});
		logPanel.add(btnClearLog);

		SerialPort[] ports = SerialPort.getCommPorts();

		PortComboBoxModel portGate1Model = new PortComboBoxModel(ports);
		PortComboBoxModel portGate2Model = new PortComboBoxModel(ports);

		class ComThread extends Thread {
			public ComThread(SerialPort serialPort, JTextField gateText,
						JLabel portLabel) {
				super(new Runnable() {

						@Override
						public void run() {
							if(serialPort.openPort())
								portLabel.setText("Port opened successfully.");
							else {
								portLabel.setText("Unable to open the port.");
					
							}
							serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
				
							Scanner data = new Scanner(serialPort.getInputStream());
							while(data.hasNextLine()) {
								beepClip.play();
								final String 	value = data.nextLine();
								
								String answer = " " + guard.check(value);
								String card = value.substring(1,12);
								String name = guard.getName(card);
								String personId = guard.getPersonId(card);
								byte[] imgArray = guard.getPhoto(personId);
								final ImageIcon personImage;
								if(imgArray != null) 
									personImage = new ImageIcon(imgArray);
								else {
									String path = "images/unknown.jpeg";
									URL imgURL = Access.class.getResource(path);
									//System.out.println(imgURL);
									if (imgURL != null) {
										personImage = new ImageIcon(imgURL);
									}
									else personImage = null;
								}
								int num = guard.numberOfPeopleInside();
								//System.out.println(num);
				
								try {
									EventQueue.invokeAndWait(new Runnable() {
										@Override
										public void run() {
											gateText.setText(value);
											lastText.setText(value);
											if(value.charAt(0) == ' ')
												lastCardText.setText(card);
											personNameText.setText(name);
											personIdText.setText(personId);
											entryMessage.setText(answer);
											Font f = entryMessage.getFont().deriveFont(Font.BOLD);
											entryMessage.setFont(f);
											totalNumberText.setText(num + "");
											photoLabel.setIcon(personImage);
										}
									});
								} catch (InvocationTargetException e) {
									e.printStackTrace();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							data.close();
						}
					});
				}
			}

		JComboBox<SerialPort> portGate1List = new JComboBox<SerialPort>(portGate1Model);
		portGate1List.setRenderer(new PortListCellRenderer());
		portGate1List.setBounds(47, 52, 367, 25);
		portGate1List.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<SerialPort> combo = (JComboBox<SerialPort>)e.getSource();
				SerialPort serialPort = (SerialPort) combo.getSelectedItem();
				new ComThread(serialPort, gate1Text, port1Label).start();
			}
		});	

		mainPanel.add(portGate1List);
		JComboBox<SerialPort> portGate2List = new JComboBox<SerialPort>(portGate2Model);
		portGate2List.setRenderer(new PortListCellRenderer());
		portGate2List.setBounds(47, 145, 367, 25);
		portGate2List.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<SerialPort> combo = (JComboBox<SerialPort>)e.getSource();
				SerialPort serialPort = (SerialPort) combo.getSelectedItem();
				new ComThread(serialPort, gate2Text, port2Label).start();
			}
		});	
		mainPanel.add(portGate2List);

	}
}
