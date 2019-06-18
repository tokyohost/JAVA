package Client;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.font.TextMeasurer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

class Client extends JFrame implements ActionListener{
	 JTextField txtMessage;
	JTextArea textPane;
	JButton btnSend;
	private JTextField txtServerIpAddress;
	private JTextField txtPort;
	
	InetAddress IP = null;
	int port;
	private JButton btnNewButton;
	private static boolean isSendMsg = false;
	
	public Socket Send;
	public Client() throws Exception{
		getContentPane().setLayout(null);

		
		this.setSize(600, 450);
		txtMessage = new JTextField();
		txtMessage.setText("Message");
		txtMessage.setBounds(35, 21, 312, 35);
		getContentPane().add(txtMessage);
		txtMessage.setColumns(10);
		
		textPane = new JTextArea();
		textPane.setBounds(35, 151, 465, 207);
		JScrollPane ScrollPane = new JScrollPane(textPane);
		getContentPane().add(textPane);
		getContentPane().add(ScrollPane);
		
		btnSend = new JButton("Send");
		btnSend.setBounds(355, 20, 153, 37);
		getContentPane().add(btnSend);
		
		txtServerIpAddress = new JTextField();
		txtServerIpAddress.setText("localhost");
		txtServerIpAddress.setBounds(35, 77, 153, 35);
		getContentPane().add(txtServerIpAddress);
		txtServerIpAddress.setColumns(10);
		
		txtPort = new JTextField();
		txtPort.setText("7788");
		txtPort.setBounds(194, 77, 153, 35);
		getContentPane().add(txtPort);
		txtPort.setColumns(10);
		
		btnNewButton = new JButton("Connect");
		btnNewButton.setBounds(355, 78, 153, 37);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					//��ȡ������IP��ַ
					IP = InetAddress.getByName(txtServerIpAddress.getText());
					//��ȡ�������˿�
					port = Integer.valueOf(txtPort.getText());
					
					Send = new Socket(IP, port); //�����������������
					textPane.append(" �ѻ�ȡIP ��Port ������������ӳɹ���");
					
					btnNewButton.setEnabled(false); //ʹ��ť�����ٴε���
				}catch(UnknownHostException e1) {
					textPane.append("��������ʧ�ܣ����������Ƿ�������");
					System.out.println(e1.getMessage());
					textPane.append("\n"+e1.getMessage());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					textPane.append("��������ʧ�ܣ����������Ƿ�������");
					System.out.println(e1.getMessage());
					textPane.append("\n"+e1.getMessage());
				} 
				
				new Thread(new Runnable() {
					/*
					 * (non-Javadoc)
					 * @see java.lang.Runnable#run()
					 * �����߳����ڽ�����Ϣ
					 */
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						
								try {
									System.out.println("���ڵȴ����շ�����������Ϣ!");
									
									InputStream GetMsg = Send.getInputStream();
									byte[] buf =new byte[4096];
									int len = GetMsg.read(buf);
								
									while(len != -1) {
										
										if(isSendMsg) {
											textPane.append("\n "+"����" + txtMessage.getText());
											isSendMsg = false;
										}else {
											textPane.append("\n "+new String(buf,0,len));
										}
										
										
										len = GetMsg.read(buf);
										
									}
									
								GetMsg.close();//�ر���
								}catch(IOException e) {
									e.getStackTrace();
								}
								
						//}
					}
				}).start();
				
			}
		});
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				String StringMessage = txtMessage.getText();
				
				// TODO Auto-generated method stub
				try {
					//Socket Send = new Socket(IP, port); //��������
					
					OutputStream Msg = Send.getOutputStream();//����������
					Msg.write(StringMessage.getBytes()); //���������������
					isSendMsg = true; //�����ж��Ƿ����Լ�������һ����Ϣ
					//textPane.append("\n"+"����"+StringMessage);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		this.setVisible(true);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnNewButton) {
			
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		Client client = new Client();
		
	}
}


