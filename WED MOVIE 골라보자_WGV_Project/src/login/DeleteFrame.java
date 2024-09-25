package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MainPage.MainPageFrame;

public class DeleteFrame extends JFrame implements ActionListener {
	ImageIcon imageIcon = new ImageIcon("img/wgv.gif");

	JTextField usernameField;
	JButton deletebutton;
	JButton cencel;

	idDAO dao = new idDAO();

	// 5/08 추가 항목
	Container container = getContentPane();
	ImageIcon tabmoive = new ImageIcon("image/WGV1.png");
	JLabel label_north = new JLabel(tabmoive);
	JPanel panel = new JPanel();

	public DeleteFrame() {
		setTitle("회원탈퇴");
		setSize(300, 220);
		setLocationRelativeTo(null); // 화면 중앙에 창 표시
		init();
		start();
		setIconImage(imageIcon.getImage());
	}

	private void init() {
		
		container.setLayout(new BorderLayout());
		container.add("North",label_north);
		container.add("Center",panel);
		
		panel = new JPanel(new GridLayout(2, 1));
		panel.setBackground(new Color(53, 53, 53));
		// 입력
		JLabel usernameLabel = new JLabel("등록한 아이디:");
		usernameLabel.setForeground(Color.white);
		panel.add(usernameLabel);
		usernameField = new JTextField();
		usernameField.setBackground(Color.LIGHT_GRAY);
		panel.add(usernameField);

		// 버튼
		deletebutton = new JButton("회원 탈퇴");
		deletebutton.setBackground(new Color(53, 53, 53));
		deletebutton.setForeground(Color.white);
		panel.add(deletebutton);
		cencel = new JButton("취소");
		cencel.setBackground(new Color(53, 53, 53));
		cencel.setForeground(Color.white);
		panel.add(cencel);
		add(panel);
		setVisible(true);

	}

	private void start() {
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		deletebutton.addActionListener(this);
		cencel.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// 프레임이 닫힐 때 필요한 작업 수행
				// 예를 들어, 프레임을 숨기는 것이 아니라 종료하고 싶다면
				// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);를 사용할 수 있습니다.
				// 혹은 setVisible(false);를 호출하여 프레임을 숨길 수도 있습니다.
				// 여기서는 종료하는 것으로 예시를 작성합니다.
				int option = JOptionPane.showConfirmDialog(DeleteFrame.this, "회원탈퇴를 종료하시겠습니까?", "종료 확인",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
				//	new MainPageFrame().setVisible(true); // 프레임을 닫음
					dispose();
				} else {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // "아니오"를 선택하면 아무 동작도 하지 않음
				}
//				new MainPageFrame();
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == deletebutton) {
			// 클릭 시 택스트입력칸의 내용을 받아옴
			String username = usernameField.getText();
			// 아이디 입력창이 비었을때 입력하라고 창 뜨고 돌려보냄
			if (username.isEmpty()) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
				return;
			}

			// 입력받은 택스트의 내용이 있으면 지움
			if (dao.findname(username) == true) {
				JOptionPane.showMessageDialog(this, "회원이 탈퇴되었습니다.");
				dao.deleteArticle(username);
				dispose(); // 로그인 창 닫기
			} else {
				JOptionPane.showMessageDialog(this, "아이디를 확인하세요.");
				return;
			}

		} else if (e.getSource() == cencel) {
			dispose();
		}
	}

}
