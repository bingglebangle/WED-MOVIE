package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MainPage.MainPageFrame;

public class FindIDFrame extends JFrame implements ActionListener {
	JTextField nameField;
	JTextField juminField;
	JButton seeIDButton;
	JButton cencel;

	ImageIcon imageIcon = new ImageIcon("img/wgv.gif");
	// 5/08 추가 항목
	Container container = getContentPane();
	ImageIcon tabmoive = new ImageIcon("image/WGV1.png");
	JLabel label_north = new JLabel(tabmoive);
	JPanel panel = new JPanel();
	public FindIDFrame() {
		setTitle("아이디 찾기");
		setSize(300, 230);

		setLocationRelativeTo(null); // 화면 중앙에 창 표시
		init();
		start();
		setIconImage(imageIcon.getImage());
		
	}
	
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North",label_north);
		container.add("Center",panel);
		
		panel.setLayout(new GridLayout(3, 1));
		panel.setBackground(new Color(53, 53, 53));
		JLabel nameLabel = new JLabel("성함 : ");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("맑은고딕", Font.BOLD, 15));
		panel.add(nameLabel);
		nameField = new JTextField();
		nameField.setBackground(Color.LIGHT_GRAY);
		panel.add(nameField);

		JLabel juminLabel = new JLabel("주민번호를 (-) 없이 입력 : ");
		juminLabel.setForeground(Color.WHITE);
		juminLabel.setFont(new Font("맑은고딕", Font.BOLD, 12));
		panel.add(juminLabel);
		juminField = new JTextField();
		juminField.setBackground(Color.LIGHT_GRAY);
		panel.add(juminField);

		seeIDButton = new JButton("아이디 찾기");
		cencel = new JButton("취소");

		panel.add(seeIDButton);
		seeIDButton.setBackground(new Color(53, 53, 53));
		seeIDButton.setForeground(Color.WHITE);
		panel.add(cencel);
		cencel.setBackground(new Color(53, 53, 53));
		cencel.setForeground(Color.WHITE);
		
		add(panel);
		setVisible(true);

	}

	private void start() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		seeIDButton.addActionListener(this);
		cencel.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// 프레임이 닫힐 때 필요한 작업 수행
				// 예를 들어, 프레임을 숨기는 것이 아니라 종료하고 싶다면
				// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);를 사용할 수 있습니다.
				// 혹은 setVisible(false);를 호출하여 프레임을 숨길 수도 있습니다.
				// 여기서는 종료하는 것으로 예시를 작성합니다.
				int option = JOptionPane.showConfirmDialog(FindIDFrame.this, "아이디찾기를 종료하시겠습니까?", "종료 확인",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					dispose();				} else {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // "아니오"를 선택하면 아무 동작도 하지 않음
				}
//				new MainPageFrame();
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == seeIDButton) {
			idDAO dao = new idDAO();
			String name = nameField.getText();
			String jumin = juminField.getText();

			List<idDTO> list = null;
			list = dao.findID(name, jumin);
			// 아이디가 비어있는지 확인
			if (name.isEmpty()) {
				JOptionPane.showMessageDialog(FindIDFrame.this, "성함을 입력하세요.");
				return;
			}
			// 주민번호가 비어있는지 확인
			if (jumin.isEmpty()) {
				JOptionPane.showMessageDialog(FindIDFrame.this, "주민번호를 입력하세요.");
				return;
			}

			String result = "";
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					idDTO dto = list.get(i);
					result += dto.getId();  
				}
				JOptionPane.showMessageDialog(this, result);
			}

			dispose(); // 계정 찾기 창 닫기
//		new idFrame(); // 로그인창으로 돌아가기
		} else if(e.getSource() == cencel) {
			dispose();
		}
	}

}
