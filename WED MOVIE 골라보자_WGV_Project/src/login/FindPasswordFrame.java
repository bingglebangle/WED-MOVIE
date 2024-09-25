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
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

import MainPage.MainPageFrame;

public class FindPasswordFrame extends JFrame implements ActionListener {
   JTextField usernameField;
   JButton findPW;
   JButton cencel;
   JPasswordField newPasswordField;
   JPasswordField confirmPasswordField;

   ImageIcon imageIcon = new ImageIcon("img/wgv.gif");

   Container container = getContentPane();
   ImageIcon tabmoive = new ImageIcon("image/WGV1.png");
   JLabel label_north = new JLabel(tabmoive);
   JPanel panel = new JPanel();
   JPanel panel2 = new JPanel();
   JPanel panel3 = new JPanel();
   JPanel panel4 = new JPanel();
   JPanel panel5 = new JPanel();

   public FindPasswordFrame() {
      setTitle("비밀번호 찾기");
      setSize(300, 270);
      setLocationRelativeTo(null); // 화면 중앙에 창 표시
      init();
      start();
      setIconImage(imageIcon.getImage());
   }

   private void init() {
      container.setLayout(new BorderLayout());
      container.add("North", label_north);
      container.add("Center", panel);

      panel.setLayout(new GridLayout(4, 1));
      panel.add(panel2);
      panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
      panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
      panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
      panel.add(panel3);
      panel.add(panel4);
      panel.add(panel5);
      panel2.setBackground(new Color(53, 53, 53));
      JLabel usernameLabel = new JLabel("등록한 아이디:");
      usernameLabel.setForeground(Color.white);
      usernameLabel.setPreferredSize(new Dimension(100, 30)); // 폭 100, 높이 30으로 설정
      panel2.add(usernameLabel);
      usernameField = new JTextField(15);
      usernameField.setBackground(Color.LIGHT_GRAY);
      panel2.add(usernameField);

      JLabel newPasswordLabel = new JLabel("새 비밀번호:");
      newPasswordField = new JPasswordField(15);
      newPasswordLabel.setForeground(Color.white);
      newPasswordLabel.setPreferredSize(new Dimension(100, 30)); // 폭 100, 높이 30으로 설정
      newPasswordField.setBackground(Color.LIGHT_GRAY);
      JLabel confirmPasswordLabel = new JLabel("비밀번호 확인:");
      confirmPasswordLabel.setPreferredSize(new Dimension(100, 30)); // 폭 100, 높이 30으로 설정
      confirmPasswordField = new JPasswordField(15);
      confirmPasswordLabel.setForeground(Color.white);
      confirmPasswordField.setBackground(Color.LIGHT_GRAY);
      panel3.add(newPasswordLabel);
      panel3.add(newPasswordField);
      panel4.add(confirmPasswordLabel);
      panel4.add(confirmPasswordField);

      findPW = new JButton("비밀번호 재설정");
      panel5.add(findPW);
      findPW.setBackground(new Color(53, 53, 53));
      findPW.setForeground(Color.white);
      cencel = new JButton("취소");
      cencel.setBackground(new Color(53, 53, 53));
      cencel.setForeground(Color.white);
      panel5.add(cencel);

      panel.setBackground(new Color(53, 53, 53));
      panel2.setBackground(new Color(53, 53, 53));
      panel3.setBackground(new Color(53, 53, 53));
      panel4.setBackground(new Color(53, 53, 53));
      panel5.setBackground(new Color(53, 53, 53));
//      findPW.setBackground(new Color(53, 53, 53));
//      findPW.setForeground(Color.WHITE);
//      cencel.setBackground(new Color(53, 53, 53));
//      cencel.setForeground(Color.WHITE);
//       add(panel);
      setVisible(true);

   }

   private void start() {
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);

      findPW.addActionListener(this);
      cencel.addActionListener(this);

      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            // 프레임이 닫힐 때 필요한 작업 수행
            // 예를 들어, 프레임을 숨기는 것이 아니라 종료하고 싶다면
            // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);를 사용할 수 있습니다.
            // 혹은 setVisible(false);를 호출하여 프레임을 숨길 수도 있습니다.
            // 여기서는 종료하는 것으로 예시를 작성합니다.
            int option = JOptionPane.showConfirmDialog(FindPasswordFrame.this, "비밀번호찾기를 종료하시겠습니까?", "종료 확인",
                  JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
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
      if (e.getSource() == findPW) {
         idDAO dao = new idDAO();
         String username = usernameField.getText();
         char[] newPassword = newPasswordField.getPassword();
         char[] confirmPassword = confirmPasswordField.getPassword();

         // 입력 유효성 검사
         if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
            return;
         }

         if (!Arrays.equals(newPassword, confirmPassword)) {
            JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
            return;
         }

         // 비밀번호 찾기 기능 수행
         List<idDTO> list = dao.findPW(username);
         if (list.size() > 0) {
            // 비밀번호를 찾았으므로, 재설정을 시도
            boolean success = dao.resetPassword(username, new String(newPassword));
            System.out.println(success);
            if (success) {
               System.out.println(success);
               JOptionPane.showMessageDialog(this, "비밀번호가 재설정되었습니다.");
               dispose();
            } else {
               JOptionPane.showMessageDialog(this, "비밀번호 재설정에 실패했습니다.");
            }
         } else {
            JOptionPane.showMessageDialog(this, "아이디를 확인하세요.");
         }
      }

//         dispose(); // 계정 찾기 창 닫기
      else if (e.getSource() == cencel) {
         dispose();
      }
   }
}