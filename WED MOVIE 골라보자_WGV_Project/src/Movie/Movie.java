package Movie;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import MainPage.MainPageFrame;
import Reservaion.ReservationFrame;
import Reservation_Con.Reservaion_Con;
import food.Snack;

//import login.idDAO;
//import login.idDTO;

public class Movie extends JFrame implements ActionListener {
   CardLayout cardLayout = new CardLayout();

   Color color_black = new Color(30, 30, 30);
   Color color_white = new Color(204, 204, 204);
   Color color_gray = new Color(247, 247, 247);

   // 폰트 저장
   Font font10 = new Font("맑은 고딕", Font.BOLD, 10);
   Font font18 = new Font("맑은 고딕", Font.BOLD, 18);
   Font font25 = new Font("맑은 고딕", Font.BOLD, 25);

   Container con = getContentPane();

   // 1. 큰 틀
   JPanel p_north = new JPanel();
   JPanel p_west = new JPanel();
   JPanel p_center = new JPanel();
   JPanel p_east = new JPanel();
   JPanel p_south = new JPanel();

   // --------------2. 북쪽----------------//
   JPanel p_NWGV = new JPanel(); // WGV 마크 & 로그인 & 회원가입 & 예약 확인 버튼
   JPanel p_NTab = new JPanel(); // 영화, 예매, 음식 버튼 -> 클릭하면 넘어감
   JPanel p_NBlink = new JPanel(); // 빈칸

   // 2-1-1. 북쪽 WGV 마크 + 광고
   JLabel l_Nblink = new JLabel(); // 빈칸
   ImageIcon WGV = new ImageIcon("image/WGV.png"); // WGV 마크
   JButton b_WGV = new JButton(WGV);
   ImageIcon N_adr = new ImageIcon("image/adv.png"); // 광고
   JLabel l_N_adr = new JLabel(N_adr);
   JPanel p_login = new JPanel(); // 로그인 버튼 묶음
   ImageIcon line1 = new ImageIcon("image/선1.png"); // 그레이선
   JLabel l_line1 = new JLabel(line1);

   // 2-1-2. 북쪽 로그인 버튼들
   /** 수정 */
   ImageIcon logout = new ImageIcon("image/로그아웃.png");
   JButton b_logout = new JButton(logout); // 로그인 버튼
   ImageIcon logblink = new ImageIcon("image/빈칸.png");
   JButton b_logblink = new JButton(logblink); // 로그인 버튼
   ImageIcon mywgv = new ImageIcon("image/MY WGV.png");
   JButton b_mywgv = new JButton(mywgv); // my WGV 버튼
   ImageIcon custom = new ImageIcon("image/고객센터.png");
   JButton b_custom = new JButton(custom); // 고객센터 버튼

   // 2-2. 북쪽 탭 버튼들
   JLabel l_tabblink = new JLabel(); // 빈칸
   ImageIcon tabmoive = new ImageIcon("image/탭영화.png");
   JButton b_tabmoive = new JButton(tabmoive); // 영화 탭
   ImageIcon tabmoiveRe = new ImageIcon("image/탭예매.png");
   JButton b_tabmoiveRe = new JButton(tabmoiveRe); // 예약 탭
   ImageIcon tabFood = new ImageIcon("image/탭음식.png");
   JButton b_tabFood = new JButton(tabFood); // 음식 탭

   // 2-3. 빈화면
   ImageIcon line2 = new ImageIcon("image/선2.png"); // 그레이선
   JLabel l_line2 = new JLabel(line2);
   JLabel l_blink = new JLabel();

   // --------------3. 서쪽----------------//
   ImageIcon WE_adr = new ImageIcon("image/adv3.png");
   JLabel l_W_adr = new JLabel(WE_adr);

   // --------------4. 동쪽----------------//
   JLabel l_E_adr = new JLabel(WE_adr);

   // --------------5. 가운데 ----------------// => * 추가
   // 검색(패널)
   JPanel panel_searchbar = new JPanel();
   // 검색창
   JPanel panel_search = new JPanel();
   ImageIcon icon_search = new ImageIcon("movie_img/searchIcon.png");
   JTextField textField_search = new JTextField(15);
   JButton button_search = new JButton(icon_search);

   // 화면전환
   JPanel panel_sceneChange = new JPanel();

   // 중앙 서브(패널)
   JPanel panel_centerborder = new JPanel();

   // 무비 차트 제목
   JPanel panel_title = new JPanel();
   // 무비 차트 (라벨)
   JLabel label_title = new JLabel("무비차트");
   // 무비 차트 (버튼)
   JPanel panel_Tbts = new JPanel();
   ImageIcon icon_r = new ImageIcon("movie_img/right.gif");
   ImageIcon icon_l = new ImageIcon("movie_img/left.gif");
   JButton button_left = new JButton(icon_l);
   JButton button_right = new JButton(icon_r);

   // 페이지 패널
   JPanel panel_page = new JPanel();

   // 무비리스트
   JPanel panel_MS = new JPanel();

   // 첫번째 페이지 (패널)
   JPanel panel_movies1 = new JPanel();
   // 두번째 페이지 (패널)
   JPanel panel_movies2 = new JPanel();
   // 세번째 페이지 (패널)
   JPanel panel_movies3 = new JPanel();
   // 영화포스터(0~19) (아이콘)
   ImageIcon[] icon = new ImageIcon[20]; // ("move_img/move1.png");
   // 영화포스터 (버튼)
   JButton[] top = new JButton[20]; // (ImageIcon[0]);

   // 영화 소개 창

   // 예매하기 버튼
   JPanel[] panel_reserve = new JPanel[20];
   JButton[] button_reserve = new JButton[20]; // ("예매 하기");

   // 영화목록 버튼
   JPanel[] panel_movelist = new JPanel[20];
   JButton[] button_movelist = new JButton[20]; // ("영화 목록");

   // top 배열
   JPanel[] panel_report = new JPanel[20];
   JPanel[] panel_Rcenter = new JPanel[20];
   JPanel[] panel_RCleft = new JPanel[20];
   ImageIcon[] plotimg = new ImageIcon[20]; // ("move_img/move1_RP.png");
   // top1 report
   JLabel[] labelplotIMG = new JLabel[20]; // (plotimg1);
   // 파일 경로 지정
   String[] filePath = new String[20]; // "plotfile/1plot.txt";
   // 텍스트 파일 읽어오기
   String[] fileContent = new String[20]; // TextFileReader.readTextFile(filePath);
   // 줄거리 창
   JTextArea[] plotArea = new JTextArea[20]; // (fileContent);
   JScrollPane[] plotScrollPane = new JScrollPane[20]; // (plotArea1);

   // 검색 창
   JPanel panel_searchCard = new JPanel();
   JPanel panel_searchMoive = new JPanel();

   // 빈 검색 창
   JPanel panel_searchCard_null = new JPanel();
   JPanel panel_searchMoive_null = new JPanel();

   public Movie() {

      setSize(1500, 1030);
      setTitle("WGV 무비 차트");
      setLocation(250, 10);

      init();
      start();
      setResizable(false);
      setVisible(true);

   }

   /** 프레임 설정 하기 */
   private void init() {
      con.setLayout(new BorderLayout());
      // 0. 기본 틀
      con.add("North", p_north);
      con.add("West", p_west);
      con.add("Center", panel_sceneChange);
      con.add("East", p_east);

      // 0-1) 동서남북 가운데 사이즈 정해주기
      p_north.setPreferredSize(new Dimension(1500, 235));
      p_center.setPreferredSize(new Dimension(1130, 765)); // * 추가 : 넣는 곳 => 가운데 사이즈
      p_west.setPreferredSize(new Dimension(185, 1000));
      p_east.setPreferredSize(new Dimension(185, 1000));
      // 1. 북쪽 패널 설정
      p_north.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

      p_north.add(p_NWGV);
      p_north.add(p_NTab);
      p_north.add(p_NBlink);

      // --------------북쪽----------------//
      // * 1) 북쪽 . 패널 사이즈 설정
      p_NWGV.setPreferredSize(new Dimension(1500, 105)); // WGV 마크 쪽 사이즈
      p_NTab.setPreferredSize(new Dimension(1500, 50)); // 탭 쪽 사이즈
      p_NBlink.setPreferredSize(new Dimension(1500, 80)); // 빈칸 사이즈

      // 1-1. 북쪽 wgv 마크 & 버튼 설정
      p_NWGV.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
      p_NWGV.add(l_Nblink); // WGV 마크
      p_NWGV.add(b_WGV); // WGV 마크
      p_NWGV.add(l_N_adr);// 광고
      p_NWGV.add(p_login);// 로그인 버튼 묶음
      p_NWGV.add(l_line1);// 로그인 버튼 묶음

      // * 1-1) 북쪽 wgv 마크 & 버튼 설정 사이즈 설정
      l_Nblink.setPreferredSize(new Dimension(185, 104));
      b_WGV.setPreferredSize(new Dimension(525, 104));
      l_N_adr.setPreferredSize(new Dimension(210, 104));
      p_login.setPreferredSize(new Dimension(580, 104));
      l_line1.setPreferredSize(new Dimension(1500, 1)); // 선1 추가

      p_NWGV.setBackground(Color.white);
      p_NWGV.paintComponents(getGraphics());
      b_WGV.setBorder(new EmptyBorder(0, 0, 0, 0));
      b_WGV.setBackground(Color.white);

      // 1-1-1. 북쪽 WGV 마크 맨 오른쪽 로그인 버튼들
      p_login.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

      p_login.add(b_logblink);
      p_login.add(b_logout);
      p_login.add(b_mywgv);
      p_login.add(b_custom);

      p_login.setBackground(Color.white);

      // * 1-1-1.)북쪽 WGV 마크 맨 오른쪽 로그인 버튼들 사이즈 설정
      b_logblink.setPreferredSize(new Dimension(100, 105));
      b_logout.setPreferredSize(new Dimension(100, 105));
      b_mywgv.setPreferredSize(new Dimension(100, 105));
      b_custom.setPreferredSize(new Dimension(100, 105));

      // * 버튼 테투리선 제거
      b_logblink.setBorder(new EmptyBorder(0, 0, 0, 0));
      b_logout.setBorder(new EmptyBorder(0, 0, 0, 0));
      b_mywgv.setBorder(new EmptyBorder(0, 0, 0, 0));
      b_custom.setBorder(new EmptyBorder(0, 0, 0, 0));
      
      // 1-2. 북쪽 탭 설정
      p_NTab.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
      p_NTab.add(l_tabblink);
      p_NTab.add(b_tabmoive);
      p_NTab.add(b_tabmoiveRe);
      p_NTab.add(b_tabFood);

      // * 1-2) 탭 배경 색
      p_NTab.setBackground(Color.white);

      // * 1-2.)북쪽 탭 설정 버튼들 사이즈 설정
      l_tabblink.setPreferredSize(new Dimension(185, 50));
      b_tabmoive.setPreferredSize(new Dimension(180, 50));
      b_tabmoiveRe.setPreferredSize(new Dimension(180, 50));
      b_tabFood.setPreferredSize(new Dimension(180, 50));

      // * 버튼 테투리선 제거
      b_tabmoive.setBorder(new EmptyBorder(0, 0, 0, 0));
      b_tabmoiveRe.setBorder(new EmptyBorder(0, 0, 0, 0));
      b_tabFood.setBorder(new EmptyBorder(0, 0, 0, 0));

      // * 1-3.) 북쪽 블링크 생성
      p_NBlink.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
      p_NBlink.add(l_line2);
      p_NBlink.add(panel_searchbar);

      l_line2.setPreferredSize(new Dimension(1500, 3));
      l_blink.setPreferredSize(new Dimension(1500, 77));
      p_NBlink.setBackground(Color.white);

      // panel_searchbar
      panel_searchbar.setLayout(new FlowLayout(FlowLayout.RIGHT, 13, 0));
      panel_searchbar.setBackground(Color.white);
      panel_searchbar.add(panel_search);

      // panel_search
      panel_search.setBackground(Color.white);
      panel_search.add(textField_search);
      panel_search.add(button_search);

      // textField_search
      textField_search.setPreferredSize(new Dimension(90, 50));
      textField_search.setFont(new Font("맑은 고딕", Font.BOLD, 25));

      // button_search
      button_search.setPreferredSize(new Dimension(45, 45));
      button_search.setBorder(new EmptyBorder(0, 0, 0, 0));
      button_search.setBackground(new Color(0, 0, 0, 0));
      button_search.setOpaque(false);

      // --------------서쪽----------------//
      // 2. 서쪽 광고 삽입
      p_west.setLayout(new GridLayout(2, 1, 5, 5));
      p_west.add(l_W_adr);

      p_west.setBackground(Color.white);

      // --------------동쪽----------------//
      // 3. 동쪽 광고 삽입
      p_east.setLayout(new GridLayout(2, 1, 0, 0));
      p_east.add(l_E_adr);

      p_east.setBackground(Color.white);

      // --------------중앙----------------//
      // Center
      p_center.setLayout(new BorderLayout());
      p_center.setBackground(Color.white);
      p_center.add("North", panel_title);
      p_center.add("Center", panel_centerborder);

      // panel_title
      panel_title.setLayout(new BorderLayout());
      panel_title.setBackground(Color.white);
      panel_title.add("West", label_title);

      // title font
      label_title.setFont(new Font("맑은 고딕", Font.BOLD, 25));

      panel_title.add("East", panel_Tbts);
      panel_Tbts.setBackground(Color.white);
      panel_Tbts.add(button_left);
      panel_Tbts.add(button_right);

      button_left.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      button_right.setFont(new Font("맑은 고딕", Font.BOLD, 18));

      // title buttons color
      button_left.setBackground(Color.white);
      button_right.setBackground(Color.white);
      button_left.setBorder(new EmptyBorder(5, 5, 5, 5));
      button_right.setBorder(new EmptyBorder(5, 5, 5, 5));

      // panel_centerborder
      panel_centerborder.setLayout(new BorderLayout());
      panel_centerborder.setBackground(Color.white);
      panel_centerborder.add("Center", panel_MS);
   

      // panel_MS
      panel_MS.setLayout(new BorderLayout());
      panel_MS.setBackground(Color.white);
      panel_MS.add("Center",panel_page);

      // panel_page
      panel_page.setLayout(cardLayout);
      panel_page.add(panel_movies1, "1");
      panel_page.add(panel_movies2, "2");
      panel_page.add(panel_movies3, "3");

      // 이미지 아이콘 생성 및 버튼에 아이콘 삽입
      for (int i = 0; i < 20; i++) {
         icon[i] = new ImageIcon("movie_img/move" + (i + 1) + ".png");
         top[i] = new JButton(icon[i]);
         // 버튼 배경색
         top[i].setBackground(Color.white);
         // 버튼 테두리 색
         top[i].setBorder(new EmptyBorder(0, 0, 0, 0));
      }

      // panel_movies1 버튼 입력
      panel_movies1.setLayout(new GridLayout(2, 4, 10, 5));
      panel_movies1.setBackground(Color.white);
      // panel_movies1 버튼 입력
      for (int i = 0; i < 8; i++) {
         panel_movies1.add(top[i]);
      }

      // panel_movies2
      panel_movies2.setLayout(new GridLayout(2, 4, 10, 5));
      panel_movies2.setBackground(Color.white);
      // panel_movies2 버튼 입력
      for (int i = 0; i < 8; i++) {
         panel_movies2.add(top[(i + 8)]);
      }

      // panel_movies3
      panel_movies3.setLayout(new GridLayout(2, 4, 10, 5));
      panel_movies3.setBackground(Color.white);
      // panel_movies3 버튼 입력
      for (int i = 0; i < 4; i++) {
         panel_movies3.add(top[(i + 16)]);
      }
      // 영화 소개 창

      // top

      for (int i = 0; i < 20; i++) {
         panel_report[i] = new JPanel();
         panel_Rcenter[i] = new JPanel();
         plotScrollPane[i] = new JScrollPane();
         panel_reserve[i] = new JPanel();
         panel_movelist[i] = new JPanel();
         button_movelist[i] = new JButton("영화 목록");
         button_reserve[i] = new JButton("예매 하기");

         // 이미지 삽입
         plotimg[i] = new ImageIcon("movie_img/move" + (i + 1) + "_RP.png");
         labelplotIMG[i] = new JLabel(plotimg[i]);
         // 텍스트파일 경로 지정
         filePath[i] = new String("plotfile/" + (i + 1) + "plot.txt");
         // 텍스트파일 읽어오기
         fileContent[i] = new String(TextFileReader.readTextFile(filePath[i]));
         // 텍스트에리어에 삽입
         plotArea[i] = new JTextArea(fileContent[i]);
         // 스크롤페인에 텍스트에리어 삽입
         plotScrollPane[i] = new JScrollPane(plotArea[i]);
         // 패널 정렬
         panel_report[i].setLayout(new BorderLayout());
         panel_report[i].setBackground(Color.white);
         panel_report[i].add("Center", labelplotIMG[i]);
         panel_report[i].add("South", panel_Rcenter[i]);

         // 줄거리 칸 패널

         panel_Rcenter[i].setBackground(Color.white);
         panel_Rcenter[i].setLayout(new BorderLayout());
         panel_Rcenter[i].add("Center", plotScrollPane[i]);
         panel_Rcenter[i].add("West", panel_movelist[i]);
         panel_Rcenter[i].add("East", panel_reserve[i]);

         // 텍스트에리어 셋팅
         plotArea[i].setFont(new Font("맑은 고딕", Font.BOLD, 15));
         plotArea[i].setEditable(false);

         plotScrollPane[i].setBorder(new EmptyBorder(5, 3, 5, 3));
         plotScrollPane[i].setBackground(Color.white);

         // 영화리스트 버튼
         panel_movelist[i].setLayout(new BorderLayout());
         panel_movelist[i].setBackground(Color.white);
         panel_movelist[i].add("North", button_movelist[i]);
         button_movelist[i].setFont(new Font("맑은 고딕", Font.BOLD, 15));
         button_movelist[i].setBackground(new Color(237, 49, 36));
         button_movelist[i].setBorderPainted(false); // 버튼의 테두리를 그리지 않음
         panel_movelist[i].setPreferredSize(new Dimension(100, 100));
         // 예매하기 버튼
         panel_reserve[i].setLayout(new BorderLayout());
         panel_reserve[i].setBackground(Color.white);
         panel_reserve[i].add("South", button_reserve[i]);
         button_reserve[i].setFont(new Font("맑은 고딕", Font.BOLD, 15));
         button_reserve[i].setBackground(new Color(237, 49, 36));
         button_reserve[i].setBorderPainted(false); // 버튼의 테두리를 그리지 않음
         button_reserve[i].setPreferredSize(new Dimension(100, 100));

      }

      // 검색 창
      panel_searchCard.setLayout(new BorderLayout());
      panel_searchCard.setBackground(Color.white);
      panel_searchCard.add("Center", panel_searchMoive);
      panel_searchMoive.setLayout(new GridLayout(2, 4, 10, 10));
      panel_searchMoive.setBackground(Color.white);

      // 검색 창
      panel_searchCard_null.setLayout(new BorderLayout());
      panel_searchCard_null.setBackground(Color.white);
      panel_searchCard_null.add("Center", panel_searchMoive_null);
      panel_searchMoive_null.setLayout(new GridLayout(2, 4, 10, 10));
      panel_searchMoive_null.setBackground(Color.white);

      // scene change
      panel_sceneChange.setLayout(cardLayout);
      panel_sceneChange.add(p_center, "home");
      for (int i = 0; i < 20; i++) {
         panel_sceneChange.add(panel_report[i], "top" + i);
      }
      panel_sceneChange.add(panel_searchCard, "search");
      panel_sceneChange.add(panel_searchCard_null, "search_null");

   }

   private void start() {
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);

      // 무비리스트 와 소개페이지 이동 이벤트
      for (int i = 0; i < 20; i++) {
          final int index = i; 
          button_movelist[i].addActionListener(this);
          button_movelist[i].addMouseListener(new MouseAdapter() {
              public void mouseEntered(MouseEvent e) {
                  button_movelist[index].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
              }

              @Override
              public void mouseExited(MouseEvent e) {
                  button_movelist[index].setCursor(Cursor.getDefaultCursor());
              }
          });
      }
      // 소개 페이지
      for (int i = 0; i < 20; i++) {
          final int index = i; // Declare a final variable to hold the value of i
         top[i].addActionListener(this);
         top[i].addMouseListener(new MouseAdapter() {
                 public void mouseEntered(MouseEvent e) {
                    top[index].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                 }

                 @Override
                 public void mouseExited(MouseEvent e) {
                    top[index].setCursor(Cursor.getDefaultCursor());
                 }
             });
      }

      for (int i = 0; i < 20; i++) {
          final int index = i; // Declare a final variable to hold the value of i
          button_reserve[i].addActionListener(this);
          button_reserve[i].addMouseListener(new MouseAdapter() {
                 public void mouseEntered(MouseEvent e) {
                	 button_reserve[index].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                 }

                 @Override
                 public void mouseExited(MouseEvent e) {
                	 button_reserve[index].setCursor(Cursor.getDefaultCursor());
                 }
             });
      }
      
      JButton[] allButtons = {button_search,button_right,button_left, b_logout, b_mywgv, b_custom, b_tabmoive, b_tabmoiveRe, b_tabFood, b_WGV };

      for (JButton allButton : allButtons) {
         // 마우스가 올라갔을 떄 커서 변경
         allButton.addActionListener(this);
         allButton.addMouseListener(new MouseAdapter() {
            final JButton button = allButton;

            public void mouseEntered(MouseEvent e) {
               button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            // 마우스가 화면 벗어날떄 커서 원상 복귀
            @Override
            public void mouseExited(MouseEvent e) {
               button.setCursor(Cursor.getDefaultCursor());
            }
         });
      }
      
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == b_WGV) {
         setVisible(false);

      } else if (e.getSource() == b_mywgv) {
         new Reservaion_Con();
         setVisible(false);

      } else if (e.getSource() == b_logout) {
         MainPageFrame.showWarning = true;
         new MainPageFrame();
         setVisible(false);
      } else if (e.getSource() == b_tabmoive) {
         new Movie();
         setVisible(false);
      } else if (e.getSource() == b_tabmoiveRe) {
         new ReservationFrame();
         setVisible(false);
      } else if (e.getSource() == b_tabFood) {
         new Snack();
         setVisible(false);
      }
      
      // 영화 목록 초기화
      for (int i = 0; i < 8; i++) {
         panel_movies1.add(top[i]);
      }
      for (int i = 0; i < 8; i++) {
         panel_movies2.add(top[(i + 8)]);
      }
      for (int i = 0; i < 4; i++) {
         panel_movies3.add(top[(i + 16)]);
      }
      // 화면 전환(무비차트 & 상영예정작)
      if (e.getSource() == button_left) {
         cardLayout.previous(panel_page);
      } else if (e.getSource() == button_right) {
         cardLayout.next(panel_page);
      }
      // 화면 전환2(포스트 클릭 시)
      for (int i = 0; i < 20; i++) {
         if (e.getSource() == top[i]) {
            cardLayout.show(panel_sceneChange, "top" + i);
         }
      }

      // 예매하기 버튼
      for (int i = 0; i < 20; i++) {
         if (e.getSource() == button_reserve[i]) {
        	 dispose();
            new ReservationFrame();
         }
      }

    // 영화소개으로 돌아가는 버튼
      for (int i = 0; i < 20; i++) {
          if (e.getSource() == top[i]) {
             cardLayout.show(panel_sceneChange, "top" + i);
          }
       }
      
      // 영화목록으로 돌아가는 버튼
      for (int i = 0; i < 20; i++) {
          if (e.getSource() == button_movelist[i]) {
             cardLayout.show(panel_sceneChange, "home" );
          }
       }
      
      // 검색버튼
      if (e.getSource() == button_search) {
         cardLayout.show(panel_sceneChange, "search_null");
         String name = textField_search.getText();
         MovieDAO dao = new MovieDAO();
         List<MoiveDTO> list = dao.searchArticle(name);

         if (name.isEmpty()) {
            // 검색 결과가 없는 경우
         //   JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.");
         } else {
            for (MoiveDTO dto : list) {
               int result = dto.getNum();
               // System.out.println(result);// 확인용 코드
               cardLayout.show(panel_sceneChange, "search");
               panel_searchMoive.add(top[(result - 1)]);
            }
         }
      }
      // 검색창 초기화
      textField_search.setText("");
   }
   
   
}