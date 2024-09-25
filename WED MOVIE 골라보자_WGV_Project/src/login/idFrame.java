package login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import MainPage.MainPageFrame;

public class idFrame extends JFrame implements ActionListener {

   Container container = getContentPane();

   static JTextField usernameField = new JTextField(10);
   JPasswordField passwordField = new JPasswordField(10);

   JButton loginButton = new JButton("로그인");
   JButton findIDButton = new JButton("아이디 찾기");
   JButton findPasswordButton = new JButton("PW 재설정");
   JButton signUpButton = new JButton("회원가입");
   JButton deleteButton = new JButton("회원탈퇴");

   JPanel panel = new JPanel();
   JPanel labelPanel = new JPanel();
   JPanel textPanel = new JPanel();
   JPanel inputPanel = new JPanel();
   JPanel buttonPanel = new JPanel();
   JPanel AllbuttonPanel = new JPanel();

   JLabel usernameLabel = new JLabel("ID              ");
   JLabel passwordLabel = new JLabel("PASSWORD");

   JPanel loginPanel = new JPanel(new BorderLayout()); // 로그인 버튼 패널 생성

//   Font font18 = new Font("맑은 고딕",Font.BOLD,18);

   ImageIcon imageIcon = new ImageIcon("img/wgv.gif");

   idDAO dao = new idDAO();

   ImageIcon tabmoive = new ImageIcon("image/WGV2.png");
   JPanel panel_north = new JPanel();
   JLabel label_north1 = new JLabel(tabmoive);
   JLabel label_north2 = new JLabel("ID /PW 를 입력해주세요!");
   JPanel panel_1 = new JPanel();
   JPanel panel_111 = new JPanel(); // ID / pW랑 로그인 간격 띄우기 위한 패널 
   
   public idFrame() {
      setTitle("로그인");
      setSize(435, 535);
      init();
      start();
      setLocationRelativeTo(null);
      setIconImage(imageIcon.getImage());
      setVisible(true);
   }
   private void init() {

      container.setLayout(new BorderLayout());
      container.add("North", panel_north);
      panel_north.setLayout(new BorderLayout());
      panel_north.add("North",label_north1);
      panel_north.add("Center",label_north2);
      panel_north.add("South", panel_111);
            
      panel_111.setBackground(new Color(53, 53, 53));
      label_north1.setHorizontalAlignment(JLabel.CENTER);
      label_north1.setForeground(Color.white);
      label_north2.setHorizontalAlignment(JLabel.CENTER);
      label_north1.setFont(new Font("맑은고딕", Font.BOLD, 23));
      label_north2.setFont(new Font("맑은고딕", Font.BOLD, 17));
      label_north2.setForeground(Color.WHITE);
      panel_north.setBackground(new Color(53, 53, 53));
      
      container.add("Center", panel_1);
      container.setBackground(new Color(53, 53, 53));
      panel_1.setBackground(new Color(53, 53, 53));
//      container.setLayout(new BorderLayout());
//      buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // 보더 설정
//      loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // 보더 설정
//      container.setBackground(Color.darkGray);
      
      // panel_1.add("North", panel);
      panel_1.add("Center", inputPanel);
      panel_1.add("South", AllbuttonPanel);
      // panel.setBackground(Color.pink);
      inputPanel.setBackground(new Color(53, 53, 53));
      AllbuttonPanel.setBackground(Color.gray);
      labelPanel.setBackground(new Color(53, 53, 53));
      textPanel.setBackground(new Color(53, 53, 53));


//      JLabel titleLabel = new JLabel("환영합니다!", JLabel.CENTER);
//      titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
//      panel.add(titleLabel, BorderLayout.NORTH);

      loginButton = new JButton("로그인");
      loginButton.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      loginButton.setPreferredSize(new Dimension(200, 40));
      loginButton.setBackground(new Color(204, 61, 61));
      loginButton.setForeground(Color.WHITE);
      loginButton.setFocusPainted(false);
      loginPanel.add(loginButton, BorderLayout.SOUTH); // 로그인 버튼을 로그인 버튼 패널의 남쪽에 추가

      usernameField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE), // 흰색
              BorderFactory.createEmptyBorder(5, 10, 5, 10)));
      usernameField.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      usernameField.setPreferredSize(new Dimension(200, 40));

      passwordField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE), // 흰색
              BorderFactory.createEmptyBorder(5, 10, 5, 10)));

      passwordField.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      passwordField.setPreferredSize(new Dimension(200, 40));

      inputPanel.setLayout(new GridLayout(5, 0));
      inputPanel.add(panel_111);
      inputPanel.add(labelPanel);
      inputPanel.add(textPanel);

      labelPanel.add("West", usernameLabel);
      textPanel.add("West", passwordLabel);

      labelPanel.add("East", usernameField);
      textPanel.add("East", passwordField);

      AllbuttonPanel.setLayout(new BorderLayout());
      AllbuttonPanel.add("Center", buttonPanel);
      AllbuttonPanel.add("North", loginPanel);

      buttonPanel.setLayout(new GridLayout(1, 4, 1, 1));
//      buttonPanel.add(loginButton);
      buttonPanel.add(findIDButton);
      buttonPanel.add(findPasswordButton);
      buttonPanel.add(signUpButton);
      buttonPanel.add(deleteButton);

      usernameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      usernameLabel.setForeground(Color.WHITE);
      passwordLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      passwordLabel.setForeground(Color.WHITE);
      
      findIDButton.setBackground(new Color(53, 53, 53));
      findIDButton.setForeground(Color.WHITE);
      findPasswordButton.setBackground(new Color(53, 53, 53));
      findPasswordButton.setForeground(Color.WHITE);
      signUpButton.setBackground(new Color(53, 53, 53));
      signUpButton.setForeground(Color.WHITE);
      deleteButton.setBackground(new Color(53, 53, 53));
      deleteButton.setForeground(Color.WHITE);

//      contentPane.add(containerPanel); // contentPane에 containerPanel 추가
//      contentPane.add(loginPanel, BorderLayout.NORTH); // 로그인 버튼 패널을 contentPane의 북쪽에 추가
//      contentPane.add(buttonPanel, BorderLayout.CENTER); // 나머지 버튼 패널을 contentPane의 가운데에 추가
      
   }

   private void start() {
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);

      signUpButton.addActionListener(this);
      loginButton.addActionListener(this);
      findIDButton.addActionListener(this);
      findPasswordButton.addActionListener(this);
      deleteButton.addActionListener(this);
      usernameField.addActionListener(this);
      passwordField.addActionListener(this);

      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            // 프레임이 닫힐 때 필요한 작업 수행
            // 예를 들어, 프레임을 숨기는 것이 아니라 종료하고 싶다면
            // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);를 사용할 수 있습니다.
            // 혹은 setVisible(false);를 호출하여 프레임을 숨길 수도 있습니다.
            // 여기서는 종료하는 것으로 예시를 작성합니다.
            int option = JOptionPane.showConfirmDialog(idFrame.this, "로그인창을 종료하시겠습니까?", "종료 확인",
                  JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
            //   new MainPageFrame().setVisible(false); // 프레임을 닫음
               dispose();
            //   new MainPageFrame().setVisible(true); // 프레임을 닫음

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
//         dispose(); // 로그인 창 닫기
         new SignUpFrame(); // 회원가입 창 열기
      } else if (e.getSource() == loginButton || e.getSource() == usernameField || e.getSource() == passwordField) { // 로그인
         String username = usernameField.getText();
         String password = new String(passwordField.getPassword());

         if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
            return;
         } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요.");
            return;
         }

         boolean result = dao.login(username, password);
         if (result == true) {
            JOptionPane.showMessageDialog(this, "로그인 되었습니다.");
            dispose(); // 로그인 창 닫기
         } else {
            JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호를 확인하세요.");
            usernameField.setText("");
            passwordField.setText("");
         }

      } else if (e.getSource() == findIDButton) {
//         dispose(); // 로그인 창 닫기
         new FindIDFrame(); // 아이디 찾는 창 열기
      } else if (e.getSource() == findPasswordButton) {
//         dispose(); // 로그인 창 닫기
         new FindPasswordFrame(); // 비밀번호 찾는 창 열기
      } else if (e.getSource() == deleteButton) {
//         dispose(); // 로그인 창 닫기
         new DeleteFrame(); // 비밀번호 찾는 창 열기
      }

   }

   public static String getUsername() {
      return usernameField.getText();
   }

}