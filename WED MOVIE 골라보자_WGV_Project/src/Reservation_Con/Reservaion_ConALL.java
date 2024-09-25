package Reservation_Con;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import MainPage.MainPage;
import MainPage.MainPageFrame;
import Movie.Movie;
import Reservaion.ReservationDTO;
import Reservaion.ReservationFrame;
import Reservaion.SeatDTO;
import food.Snack;
import food.SnackBackDAO;
import food.SnackBackDTO;
import login.idDAO;
import login.idDTO;
import login.idFrame;

public class Reservaion_ConALL extends JFrame implements ActionListener {

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
   ImageIcon WE_adr = new ImageIcon("image/adv2.gif");
   JLabel l_W_adr = new JLabel(WE_adr);

   // --------------3. 동쪽----------------//
   JLabel l_E_adr = new JLabel(WE_adr);

   // --------------4. 가운데----------------//

   // 4-1. 영화 예매 부분
   JPanel p_MOVIE = new JPanel();
   JScrollPane scrollPane = new JScrollPane(p_MOVIE);
   JScrollBar bar = new JScrollBar(JScrollBar.VERTICAL);

   ImageIcon line3 = new ImageIcon("image/선1.png"); // 그레이선

   JLabel l_line5 = new JLabel(line3);
   JPanel p_movieinfo = new JPanel();
   JPanel p_movieres = new JPanel();
   JLabel l_movieinfo = new JLabel("MY 예매내역");
   JLabel l_movieResCount = new JLabel("+" + "건  (6개 이상은 볼 수 없습니다._)");

   static ImageIcon l_pic = new ImageIcon(""); // 선택한 영화 이미지 버튼
   static String movieimagePath; // = 데이터베이스에 저장할 값
   static JLabel l_moiveimg = new JLabel(l_pic);

   JPanel p_movieName = new JPanel(); // 영화 제목
   static JTextArea area = new JTextArea("");

   JPanel p_movieInfo = new JPanel(); // 영화 날짜/시간/상영관/좌석선택
   static JLabel l_날짜 = new JLabel("");
   static JLabel l_시간 = new JLabel("현재 예매된 내역이 없습니다");
   static JLabel l_상영관 = new JLabel("");

   JPanel p_seatInfo = new JPanel(); // 영화 좌석 번호
   JLabel l_인원 = new JLabel("");
   JLabel l_좌석 = new JLabel("");
   JPanel p_cancel = new JPanel();

   JButton b_취소 = new JButton("예매 취소");

   public Reservaion_ConALL() {

      setSize(1500, 1000);
      setTitle("WGV 좌석 선택");
      setLocation(250, 30);

      init();
      start();
      setVisible(true);

   }

   /** 프레임 설정 하기 */
   private void init() {
      con.setLayout(new BorderLayout());
      // 0. 기본 틀
      con.add("North", p_north);
      con.add("West", p_west);
      con.add("Center", p_center);
      con.add("East", p_east);

      // 0-1) 동서남북 가운데 사이즈 정해주기
      p_north.setPreferredSize(new Dimension(1500, 235));
      p_center.setPreferredSize(new Dimension(1130, 765));
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
      p_NBlink.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
      p_NBlink.add(l_line2);
      p_NBlink.add(l_blink);

      l_line2.setPreferredSize(new Dimension(1500, 3));
      l_blink.setPreferredSize(new Dimension(1500, 77));

      p_NBlink.setBackground(Color.white);

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

      // --------------가운데----------------//
      // 4-1. 가운데 설정
      p_center.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
      p_center.add(p_MOVIE);

      // 4-2. 영화 예매내역 출력
      // 4-2-1. 영화 예매내역 출력
      p_MOVIE.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

      p_MOVIE.add(p_movieinfo);
      p_MOVIE.add(p_movieres);
      p_MOVIE.setPreferredSize(new Dimension(1130, 765));
      // * 4-2-1. 영화 예매내역 사이즈
      p_movieinfo.setPreferredSize(new Dimension(1130, 50));
      p_movieres.setPreferredSize(new Dimension(1130, 150));

      // 4-2-2) 예매내용 타이틀 출력
      p_movieinfo.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 15));
      p_movieinfo.add(l_movieinfo).setFont(font18);
      p_movieinfo.add(l_movieResCount).setFont(font18);

      // 4-2-3) 영화 예약 내용들 출력
      p_movieres.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
      p_movieres.add(l_moiveimg); // 영화 이미지
      p_movieres.add(p_movieName); // 영화 제목 라
      p_movieres.add(p_movieInfo); // 영화 일시,상영관
      p_movieres.add(p_seatInfo); // 인원,좌석번호

      // 4-2-3) 영화 제목 텍스트 설정
      p_movieName.add(area).setFont(font18);
      area.setBackground(color_gray);

      // 4-2-3) 영화 일시,상영관 설정
      p_movieInfo.setLayout(new GridLayout(3, 1, 0, 0));
      p_movieInfo.add(l_날짜).setFont(font18);
      p_movieInfo.add(l_시간).setFont(font18);
      p_movieInfo.add(l_상영관).setFont(font18);

      // 4-2-4) 인원,좌석번호 설정
      p_seatInfo.setLayout(new GridLayout(3, 1, 0, 0));
      p_seatInfo.add(l_인원).setFont(font18);
      p_seatInfo.add(l_좌석).setFont(font18);
      p_seatInfo.add(p_cancel);
      p_cancel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
      p_cancel.add(b_취소).setFont(font18);

      // * 4. 이름 사이즈 셋팅
      l_moiveimg.setPreferredSize(new Dimension(185, 145)); // 영화 이미지
      p_movieName.setPreferredSize(new Dimension(210, 145)); // 영화 이름
      p_movieInfo.setPreferredSize(new Dimension(300, 145)); // 영화 일시,상영관,인원
      p_seatInfo.setPreferredSize(new Dimension(300, 145)); // 영화 좌석
      b_취소.setPreferredSize(new Dimension(150, 40)); // 영화 좌석
      b_취소.setBackground(color_gray); // 영화 좌석
      
      
   


   }

   private void start() {
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      // 예매 정보를 데이터베이스에서 가져오기

      TotalDAO moviersdao = new TotalDAO();
      List<SeatDTO> reservationList = moviersdao.printmovie(idFrame.getUsername()); // 예매 정보를 모두 가져옴
      // 가져온 정보가 없는 경우를 처리해야 합니다.
      if (reservationList != null && !reservationList.isEmpty()) {
         // 가져온 정보가 있다면 첫 번째 예매 정보만 가져와서 사용합니다.
         
         
         for (int i = 0; i < reservationList.size(); i++) {
            SeatDTO rsdto = reservationList.get(i);

            // 각 예매 정보에서 필요한 데이터 추출
            String Image = rsdto.getImage(); // 영화 이미지 경로
            String Mvname = rsdto.getMvname(); // 영화 제목
            String Cal = rsdto.getCal(); // 상영 일자
            String Time = rsdto.getTime(); // 상영 시간
            String Room = rsdto.getRoom(); // 상영관
            String Count = rsdto.getCount(); // 예매 인원
            String CountStr = String.valueOf(Count);
            String seatnum = rsdto.getSeatnum(); // 예매 좌석 번호

            // 영화 이미지 설정
            ImageIcon movieImage = new ImageIcon(Image);
            l_moiveimg.setIcon(movieImage);

            // 영화 제목 설정
            area.setText(Mvname);
			area.setEditable(false); // JTextArea를 편집 불가능하도록 설정

            // 날짜, 시간, 상영관, 인원, 좌석 번호 설정
            l_날짜.setText(Cal);
            l_시간.setText(Time);
            l_상영관.setText(Room);
            l_인원.setText(CountStr);
            l_좌석.setText(seatnum);

            // 건수
            String count = String.valueOf(reservationList.size());
            l_movieResCount.setText("+ " + count + "건");
         }
      } else {
         l_movieResCount.setText("");
         movieimagePath = "";
         l_moiveimg.setText(movieimagePath);
         area.setText("");

         l_날짜.setText("");
         l_시간.setText("현재 예매된 내역이 없습니다");
         l_상영관.setText("");
         l_인원.setText("");
         l_좌석.setText("");

      }

      JButton[] allButtons = { b_logout, b_mywgv, b_custom, b_tabmoive, b_tabmoiveRe, b_tabFood, b_WGV ,b_취소};

      for (JButton allButton : allButtons) {
         // 마우스가 올라갔을 떄 커서 변경
         allButton.addActionListener(this);
         allButton.addMouseListener(new MouseAdapter() {
             JButton button = allButton;

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
         new Reservaion_ConALL();
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
      if(e.getSource() == b_취소) {
         TotalDAO totaldao = new TotalDAO();
         totaldao.deletemovie(area.getText(), l_날짜.getText(), l_시간.getText(), l_상영관.getText(), l_인원.getText(), l_좌석.getText(), idFrame.getUsername());
         JOptionPane.showOptionDialog(this, "예약 취소가 완료 되었습니다.", "예약취소", JOptionPane.DEFAULT_OPTION,
               JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "확인" }, "확인");      }
      p_MOVIE.removeAll();
      p_MOVIE.revalidate();
      p_MOVIE.repaint();

      
   }
}