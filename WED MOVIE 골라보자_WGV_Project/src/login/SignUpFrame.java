package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import MainPage.MainPageFrame;

public class SignUpFrame extends JFrame implements ActionListener {
   idDAO dao = new idDAO();

   JTextField usernameField = new JTextField(14);
   JPasswordField passwordField = new JPasswordField(22);
   JTextField nameField = new JTextField(22);
   JTextField residentNumberField = new JTextField(22);
   JTextField emailField = new JTextField(22);
   JButton idCheckButton = new JButton("중복 확인");
   JTextField confirmPasswordField = new JPasswordField(22);

   JLabel usernameLabel = new JLabel("아이디 : ");
   JLabel passwordLabel = new JLabel("비밀번호 : ");
   JLabel passwordCheakLable = new JLabel("비밀번호 확인 : ");
   JLabel nameLabel = new JLabel("이름 : ");
   JLabel residentNumberLabel = new JLabel("주민번호:");
   JLabel emailLabel = new JLabel("이메일 : ");
   JButton signUpButton = new JButton("회원가입");
   JButton cencel = new JButton("취소");

   Container container = getContentPane();
   JPanel panel_id = new JPanel();
   JPanel panel_pw = new JPanel();
   JPanel panel_pwch = new JPanel();
   JPanel panel_name = new JPanel();
   JPanel panel_jumin = new JPanel();
   JPanel panel_email = new JPanel();
   JPanel panel_button = new JPanel();
   
   
   // 5/08 추가 항목
   ImageIcon tabmoive = new ImageIcon("image/WGV1.png");
   JLabel label_north = new JLabel(tabmoive);
   JPanel panel_north = new JPanel();
   JPanel panel = new JPanel();
   

   public SignUpFrame() {
      setTitle("회원가입");
      setSize(380, 370);
      init();
      start();
      setLocationRelativeTo(null);
      setVisible(true);
      setResizable(false);
   }

   private void init() {
      
      container.setLayout(new BorderLayout());
      container.add("North",panel_north);
      container.add("Center",panel);
      
      panel_north.add(label_north);
      panel_north.setBackground(new Color(53, 53, 53));
      
      panel.setLayout(new GridLayout(7,1));
      panel.setBackground(new Color(53, 53, 53));
      panel.add(panel_id);
      panel.add(panel_pw);
      panel.add(panel_pwch);
      panel.add(panel_name);
      panel.add(panel_jumin);
      panel.add(panel_email);
      panel.add(panel_button);

      panel_id.setLayout(new FlowLayout(FlowLayout.LEFT));
      usernameLabel.setPreferredSize(new Dimension(100, 30)); // 폭 100, 높이 30으로 설정
      panel_id.setBackground(new Color(53, 53, 53));
      idCheckButton.setBackground(new Color(53, 53, 53));
      idCheckButton.setForeground(Color.WHITE);
      usernameLabel.setForeground(Color.WHITE);
      usernameField.setBackground(Color.LIGHT_GRAY);
      panel_id.add(usernameLabel);
      panel_id.add(usernameField);
      panel_id.add(idCheckButton);

      panel_pw.setLayout(new FlowLayout(FlowLayout.LEFT));
      panel_pw.setBackground(new Color(53, 53, 53));
      passwordLabel.setForeground(Color.WHITE);
      passwordField.setBackground(Color.LIGHT_GRAY);
      panel_pw.add(passwordLabel);
      panel_pw.add(passwordField);
      passwordLabel.setPreferredSize(new Dimension(100, 30)); // 폭 100, 높이 30으로 설정

      panel_pwch.setLayout(new FlowLayout(FlowLayout.LEFT));
      panel_pwch.setBackground(new Color(53, 53, 53));
      passwordCheakLable.setForeground(Color.WHITE);      
      confirmPasswordField.setBackground(Color.LIGHT_GRAY);
      panel_pwch.add(passwordCheakLable);
      panel_pwch.add(confirmPasswordField);      
      passwordCheakLable.setPreferredSize(new Dimension(100, 30)); // 폭 100, 높이 30으로 설정

      panel_name.setLayout(new FlowLayout(FlowLayout.LEFT));
      panel_name.setBackground(new Color(53, 53, 53));
      nameLabel.setForeground(Color.WHITE);
      nameField.setBackground(Color.LIGHT_GRAY);
      panel_name.add(nameLabel);
      panel_name.add(nameField);
      nameLabel.setPreferredSize(new Dimension(100, 30)); // 폭 100, 높이 30으로 설정
      

      panel_jumin.setLayout(new FlowLayout(FlowLayout.LEFT));
      panel_jumin.setBackground(new Color(53, 53, 53));
      residentNumberLabel.setForeground(Color.WHITE);
      residentNumberField.setBackground(Color.LIGHT_GRAY);
      panel_jumin.add(residentNumberLabel);
      panel_jumin.add(residentNumberField);
      residentNumberLabel.setPreferredSize(new Dimension(100, 30)); // 폭 100, 높이 30으로 설정

      panel_email.setLayout(new FlowLayout(FlowLayout.LEFT));
      panel_email.setBackground(new Color(53, 53, 53));
      emailLabel.setForeground(Color.WHITE);
      emailField.setBackground(Color.LIGHT_GRAY);
      panel_email.add(emailLabel);
      panel_email.add(emailField);
      emailLabel.setPreferredSize(new Dimension(100, 30)); // 폭 100, 높이 30으로 설정

      panel_button.setLayout(new FlowLayout(FlowLayout.CENTER));
      panel_button.setBackground(new Color(53, 53, 53));
      signUpButton.setForeground(Color.WHITE);
      cencel.setForeground(Color.WHITE);
      panel_button.add(signUpButton);
      signUpButton.setBackground(new Color(53, 53, 53));
      panel_button.add(cencel);
      cencel.setBackground(new Color(53, 53, 53));
   }

   private void start() {
      signUpButton.addActionListener(this);
      cencel.addActionListener(this);
      idCheckButton.addActionListener(this);
      
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            // 프레임이 닫힐 때 필요한 작업 수행
            // 예를 들어, 프레임을 숨기는 것이 아니라 종료하고 싶다면
            // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);를 사용할 수 있습니다.
            // 혹은 setVisible(false);를 호출하여 프레임을 숨길 수도 있습니다.
            // 여기서는 종료하는 것으로 예시를 작성합니다.
            int option = JOptionPane.showConfirmDialog(SignUpFrame.this, "회원가입창을 종료하시겠습니까?", "종료 확인",
                  JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
            //   new MainPageFrame().setVisible(true); // 프레임을 닫음
               dispose();
            } else {
               setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // "아니오"를 선택하면 아무 동작도 하지 않음
            }
//            new MainPageFrame();
         }
      });
      
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == signUpButton) {
         String username = usernameField.getText();
         String password = new String(passwordField.getPassword());
         String confirmPassword = new String(((JPasswordField) confirmPasswordField).getPassword());
         String name = nameField.getText();
         String residentNumber = residentNumberField.getText();
         String email = emailField.getText();

         // 모든 필드가 비어있는지 확인
         if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || name.isEmpty()
               || residentNumber.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(SignUpFrame.this, "모든 정보를 입력하세요.");
            return;
         }

         // 비밀번호와 비밀번호 확인이 일치하는지 확인
         if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(SignUpFrame.this, "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            return;
         }

         idDTO dto = new idDTO();
         dto.setId(username);
         dto.setPassword(password);
         dto.setName(name);
         dto.setJumin(residentNumber);
         dto.setEmail(email);

         String result = idcheak(dto);
         JOptionPane.showMessageDialog(this, result);

         usernameField.setText("");
//         dispose(); // 회원가입 창 닫기
      } else if (e.getSource() == cencel) {
         dispose();
      } else if (e.getSource() == idCheckButton) {
         // 중복 체크 버튼이 클릭되었을 때의 동작
         String username = usernameField.getText();
         if (username.isEmpty()) {
            JOptionPane.showMessageDialog(SignUpFrame.this, "아이디를 입력하세요.");
            return;
         }
         idDTO dto = new idDTO();
         dto.setId(username);
         String result = idCheck(dto);
         JOptionPane.showMessageDialog(this, result);
      }

   }

   public String idcheak(idDTO dto) {
      List<idDTO> list = dao.selectAll();
      for (int i = 0; i < list.size(); i++) {
         idDTO idDTO = list.get(i);
         if (idDTO.getId().equals(dto.getId())) {
            return dto.getId() + " 아이디가 이미 존재하고 있습니다.";
         }
      }
      int result = dao.newMember(dto);
      dispose();
      if (result > 0)
         return dto.getName() + "님의 가입을 환영합니다.";
      else
         return "저장 실패";
   }

   public String idCheck(idDTO dto) {
      List<idDTO> list = dao.selectAll();
      for (int i = 0; i < list.size(); i++) {
         idDTO idDTO = list.get(i); 
         if (idDTO.getId().equals(dto.getId())) {
        	 usernameField.setText("");
            return dto.getId() + " 아이디가 이미 존재합니다.";
         }
      }
      return dto.getId() + " 아이디는 사용할 수 있습니다.";
   }

}