package food;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import MainPage.MainPageFrame;
import Movie.Movie;
import Reservaion.ReservationFrame;
import Reservation_Con.Reservaion_Con;
import login.idFrame;

public class Snack extends JFrame implements ActionListener {
	Container container = getContentPane();
	String[] strs = { "1", "2", "3", "4", "5" };
	JComboBox<String> comboBox = new JComboBox<String>(strs);

	// 메인 센터 패널
	JPanel p_main = new JPanel();
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
	ImageIcon WE_adr = new ImageIcon("image/adv2.png");
	JLabel l_W_adr = new JLabel(WE_adr);

	// --------------4. 동쪽----------------//
	JLabel l_E_adr = new JLabel(WE_adr);

	// --------------5. 가운데 ----------------// => * 추가

	// 아이콘 이미지 변경
	ImageIcon foodIcon = new ImageIcon("foodimg/food.png");
	// 시작 패널
	JPanel panel_main = new JPanel();
	// 스토어 상품 패널
	JPanel panel_main_north = new JPanel();
	// store 라벨
	JLabel label_store = new JLabel("메뉴");
	// 상품고르세요 라벨
	JLabel label_price = new JLabel("원하시는 상품을 골라주세요.");
	// 탭 항목 들
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
	JPanel panel_combo = new JPanel();
	JPanel panel_popcorn = new JPanel();
	JPanel panel_drink = new JPanel();
	JPanel panel_snack = new JPanel();

	// 콤보 버튼 부분
	// 더블콤보
	JPanel panel_cm1 = new JPanel();
	JPanel panel_cm11 = new JPanel();
	JPanel panel_cm111 = new JPanel();
	JButton button_cm1 = new JButton(new ImageIcon("foodimg/combo1.png"));
	JLabel label_cm1 = new JLabel("더블 콤보");
	JLabel label_cm11 = new JLabel("팝콘(M)2+탄산음료(M)2");
	JLabel label_cm111 = new JLabel("13,000원");
	// 라지콤보
	JPanel panel_cm2 = new JPanel();
	JPanel panel_cm22 = new JPanel();
	JPanel panel_cm222 = new JPanel();
	JButton button_cm2 = new JButton(new ImageIcon("foodimg/combo2.png"));
	JLabel label_cm2 = new JLabel("라지 콤보");
	JLabel label_cm22 = new JLabel("팝콘(L)2+탄산음료(L)2");
	JLabel label_cm222 = new JLabel("15,000원");
	// 스몰세트
	JPanel panel_cm3 = new JPanel();
	JPanel panel_cm33 = new JPanel();
	JPanel panel_cm333 = new JPanel();
	JButton button_cm3 = new JButton(new ImageIcon("foodimg/combo3.png"));
	JLabel label_cm3 = new JLabel("스몰 세트");
	JLabel label_cm33 = new JLabel("팝콘(M)1+탄산음료(M)1");
	JLabel label_cm333 = new JLabel("7,000원");
	// CGV 콤보
	JPanel panel_cm4 = new JPanel();
	JPanel panel_cm44 = new JPanel();
	JPanel panel_cm444 = new JPanel();
	JButton button_cm4 = new JButton(new ImageIcon("foodimg/combo4.png"));
	JLabel label_cm4 = new JLabel("★BEST MENU★ CGV 콤보");
	JLabel label_cm44 = new JLabel("팝콘(L)1+탄산음료(M)2");
	JLabel label_cm444 = new JLabel("10,000원");
	// 우리패키지
	JPanel panel_cm5 = new JPanel();
	JPanel panel_cm55 = new JPanel();
	JPanel panel_cm555 = new JPanel();
	JButton button_cm5 = new JButton(new ImageIcon("foodimg/combo5.png"));
	JLabel label_cm5 = new JLabel("우리 패키지");
	JLabel label_cm55 = new JLabel("일반 영화 관람권 4매+더블콤보 1개");
	JLabel label_cm555 = new JLabel("61,000원");
	// 나랑 너 패키지
	JPanel panel_cm6 = new JPanel();
	JPanel panel_cm66 = new JPanel();
	JPanel panel_cm666 = new JPanel();
	JButton button_cm6 = new JButton(new ImageIcon("foodimg/combo6.png"));
	JLabel label_cm6 = new JLabel("나랑 너 패키지");
	JLabel label_cm66 = new JLabel("일반 영화 관람권 2매+CGV콤보 1개");
	JLabel label_cm666 = new JLabel("34,000원");
	// 팝콘 버튼 부분
	// 더블 치즈팝콘M
	JPanel panel_pc1 = new JPanel();
	JPanel panel_pc11 = new JPanel();
	JPanel panel_pc111 = new JPanel();
	JButton button_pc1 = new JButton(new ImageIcon("foodimg/popcorn1.png"));
	JLabel label_pc1 = new JLabel("더블치즈팝콘(M)");
	JLabel label_pc11 = new JLabel("6,000원");
	// 바질어니언팝콘M
	JPanel panel_pc2 = new JPanel();
	JPanel panel_pc22 = new JPanel();
	JPanel panel_pc222 = new JPanel();
	JButton button_pc2 = new JButton(new ImageIcon("foodimg/popcorn2.png"));
	JLabel label_pc2 = new JLabel("바질어니언팝콘(M)");
	JLabel label_pc22 = new JLabel("6,000원");
	// 달콤팝콘M
	JPanel panel_pc3 = new JPanel();
	JPanel panel_pc33 = new JPanel();
	JPanel panel_pc333 = new JPanel();
	JButton button_pc3 = new JButton(new ImageIcon("foodimg/popcorn3.png"));
	JLabel label_pc3 = new JLabel("달콤팝콘(M)");
	JLabel label_pc33 = new JLabel("6,000원");
	// 더블치즈팝콘L
	JPanel panel_pc4 = new JPanel();
	JPanel panel_pc44 = new JPanel();
	JPanel panel_pc444 = new JPanel();
	JButton button_pc4 = new JButton(new ImageIcon("foodimg/popcorn4.png"));
	JLabel label_pc4 = new JLabel("★BEST MENU★ 더블치즈팝콘(L)");
	JLabel label_pc44 = new JLabel("6,500원");
	// 바질어니언팝콘L
	JPanel panel_pc5 = new JPanel();
	JPanel panel_pc55 = new JPanel();
	JPanel panel_pc555 = new JPanel();
	JButton button_pc5 = new JButton(new ImageIcon("foodimg/popcorn5.png"));
	JLabel label_pc5 = new JLabel("★BEST MENU★ 바질어니언팝콘(L)");
	JLabel label_pc55 = new JLabel("6,500원");
	// 달콤팝콘L
	JPanel panel_pc6 = new JPanel();
	JPanel panel_pc66 = new JPanel();
	JPanel panel_pc666 = new JPanel();
	JButton button_pc6 = new JButton(new ImageIcon("foodimg/popcorn6.png"));
	JLabel label_pc6 = new JLabel("달콤팝콘(L)");
	JLabel label_pc66 = new JLabel("6,500원");
	// 음료 버튼 부분
	// 핑크레몬에이드
	JPanel panel_dk1 = new JPanel();
	JPanel panel_dk11 = new JPanel();
	JPanel panel_dk111 = new JPanel();
	JButton button_dk1 = new JButton(new ImageIcon("foodimg/drink1.png"));
	JLabel label_dk1 = new JLabel("핑크레몬에이드");
	JLabel label_dk11 = new JLabel("5,500원");
	// 에이드
	JPanel panel_dk2 = new JPanel();
	JPanel panel_dk22 = new JPanel();
	JPanel panel_dk222 = new JPanel();
	JButton button_dk2 = new JButton(new ImageIcon("foodimg/drink2.png"));
	JLabel label_dk2 = new JLabel("에이드");
	JLabel label_dk22 = new JLabel("5,500원");
	// 아메리카노 아이스
	JPanel panel_dk3 = new JPanel();
	JPanel panel_dk33 = new JPanel();
	JPanel panel_dk333 = new JPanel();
	JButton button_dk3 = new JButton(new ImageIcon("foodimg/drink3.png"));
	JLabel label_dk3 = new JLabel("아메리카노(ICE)");
	JLabel label_dk33 = new JLabel("4,500원");
	// 아메리카노 핫
	JPanel panel_dk4 = new JPanel();
	JPanel panel_dk44 = new JPanel();
	JPanel panel_dk444 = new JPanel();
	JButton button_dk4 = new JButton(new ImageIcon("foodimg/drink4.png"));
	JLabel label_dk4 = new JLabel("아메리카노(HOT)");
	JLabel label_dk44 = new JLabel("4,000원");
	// 탄산음료L
	JPanel panel_dk5 = new JPanel();
	JPanel panel_dk55 = new JPanel();
	JPanel panel_dk555 = new JPanel();
	JButton button_dk5 = new JButton(new ImageIcon("foodimg/drink5.png"));
	JLabel label_dk5 = new JLabel("탄산음료(L)");
	JLabel label_dk55 = new JLabel("3,500원");
	// 탄산음료M
	JPanel panel_dk6 = new JPanel();
	JPanel panel_dk66 = new JPanel();
	JPanel panel_dk666 = new JPanel();
	JButton button_dk6 = new JButton(new ImageIcon("foodimg/drink6.png"));
	JLabel label_dk6 = new JLabel("탄산음료(M)");
	JLabel label_dk66 = new JLabel("3,000원");
	// 스낵 버튼 부분
	// 칠리치즈나쵸
	JPanel panel_sn1 = new JPanel();
	JPanel panel_sn11 = new JPanel();
	JPanel panel_sn111 = new JPanel();
	JButton button_sn1 = new JButton(new ImageIcon("foodimg/snack1.png"));
	JLabel label_sn1 = new JLabel("칠리치즈나쵸");
	JLabel label_sn11 = new JLabel("4,900원");
	// 플레인핫도그
	JPanel panel_sn2 = new JPanel();
	JPanel panel_sn22 = new JPanel();
	JPanel panel_sn222 = new JPanel();
	JButton button_sn2 = new JButton(new ImageIcon("foodimg/snack2.png"));
	JLabel label_sn2 = new JLabel("플레인핫도그");
	JLabel label_sn22 = new JLabel("4,500원");
	// 칠리치즈핫도그
	JPanel panel_sn3 = new JPanel();
	JPanel panel_sn33 = new JPanel();
	JPanel panel_sn333 = new JPanel();
	JButton button_sn3 = new JButton(new ImageIcon("foodimg/snack3.png"));
	JLabel label_sn3 = new JLabel("칠리치즈핫도그");
	JLabel label_sn33 = new JLabel("5,000원");
	// 맛밤
	JPanel panel_sn4 = new JPanel();
	JPanel panel_sn44 = new JPanel();
	JPanel panel_sn444 = new JPanel();
	JButton button_sn4 = new JButton(new ImageIcon("foodimg/snack4.png"));
	JLabel label_sn4 = new JLabel("맛밤");
	JLabel label_sn44 = new JLabel("3,500원");

	// 단순 하단 색상 넣기용
	JPanel panel_south = new JPanel();
	JLabel Label_south = new JLabel("WGV 영화관을 이용해주셔서 감사합니다.");
	JButton button_pay = new JButton("결제를 해주세요");

	// 라벨 변경
	// 스낵 부분 비활성화 버튼
	JButton button23 = new JButton("준비중입니다.");
	JButton button24 = new JButton("준비중입니다.");

	public Snack() {
		setSize(1500, 1000);
		setTitle("WGV/음식");
		setLocation(250, 30);
		setIconImage(foodIcon.getImage());
		setResizable(false);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", p_north);
		container.add("Center", panel_main);
		container.add("South", p_south);
		container.add("East", p_east);
		container.add("West", p_west);

		// 메인 레이아웃
		panel_main.setLayout(new BorderLayout());
		panel_main.add("North", panel_main_north);
		panel_main.add("Center", tabbedPane);
		panel_main.add("South", panel_south);

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
		b_WGV.setBackground(Color.white);
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

		// 상단 스토어,상품선택
		panel_main_north.setBackground(new Color(220, 70, 30));
		panel_main_north.setLayout(new GridLayout(1, 1));
		panel_main_north.add(label_store);
		panel_main_north.add(label_price);

		// 스토어, 상품 글자 크기 조절
		label_store.setFont(new Font("맑은고딕", Font.BOLD, 30));
		label_price.setFont(new Font("맑은고딕", Font.BOLD, 30));
		// 탭 항목
		tabbedPane.setFont(new Font("맑은고딕", Font.BOLD, 50));

		// 라벨 글자크기 + 가운데 정렬
		// 콤보
		label_cm1.setHorizontalAlignment(JLabel.CENTER);
		label_cm11.setHorizontalAlignment(JLabel.CENTER);
		label_cm111.setHorizontalAlignment(JLabel.CENTER);
		label_cm1.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_cm11.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_cm111.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_cm2.setHorizontalAlignment(JLabel.CENTER);
		label_cm22.setHorizontalAlignment(JLabel.CENTER);
		label_cm222.setHorizontalAlignment(JLabel.CENTER);
		label_cm2.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_cm22.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_cm222.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_cm3.setHorizontalAlignment(JLabel.CENTER);
		label_cm33.setHorizontalAlignment(JLabel.CENTER);
		label_cm333.setHorizontalAlignment(JLabel.CENTER);
		label_cm3.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_cm33.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_cm333.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_cm4.setHorizontalAlignment(JLabel.CENTER);
		label_cm4.setForeground(Color.RED);
		label_cm44.setHorizontalAlignment(JLabel.CENTER);
		label_cm444.setHorizontalAlignment(JLabel.CENTER);
		label_cm4.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_cm44.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_cm444.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_cm5.setHorizontalAlignment(JLabel.CENTER);
		label_cm55.setHorizontalAlignment(JLabel.CENTER);
		label_cm555.setHorizontalAlignment(JLabel.CENTER);
		label_cm5.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_cm55.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_cm555.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_cm6.setHorizontalAlignment(JLabel.CENTER);
		label_cm66.setHorizontalAlignment(JLabel.CENTER);
		label_cm666.setHorizontalAlignment(JLabel.CENTER);
		label_cm6.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_cm66.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_cm666.setFont(new Font("맑은고딕", Font.BOLD, 17));
		// 라벨 글자크기 + 가운데 정렬
		// 팝콘
		label_pc1.setHorizontalAlignment(JLabel.CENTER);
		label_pc11.setHorizontalAlignment(JLabel.CENTER);
		label_pc1.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_pc11.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_pc2.setHorizontalAlignment(JLabel.CENTER);
		label_pc22.setHorizontalAlignment(JLabel.CENTER);
		label_pc2.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_pc22.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_pc3.setHorizontalAlignment(JLabel.CENTER);
		label_pc33.setHorizontalAlignment(JLabel.CENTER);
		label_pc3.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_pc33.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_pc4.setHorizontalAlignment(JLabel.CENTER);
		label_pc4.setForeground(Color.RED);
		label_pc44.setHorizontalAlignment(JLabel.CENTER);
		label_pc4.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_pc44.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_pc5.setHorizontalAlignment(JLabel.CENTER);
		label_pc5.setForeground(Color.RED);
		label_pc55.setHorizontalAlignment(JLabel.CENTER);
		label_pc5.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_pc55.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_pc6.setHorizontalAlignment(JLabel.CENTER);
		label_pc66.setHorizontalAlignment(JLabel.CENTER);
		label_pc6.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_pc66.setFont(new Font("맑은고딕", Font.BOLD, 17));
		// 라벨 글자크기 + 가운데 정렬
		// 음료
		label_dk1.setHorizontalAlignment(JLabel.CENTER);
		label_dk11.setHorizontalAlignment(JLabel.CENTER);
		label_dk1.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_dk11.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_dk2.setHorizontalAlignment(JLabel.CENTER);
		label_dk22.setHorizontalAlignment(JLabel.CENTER);
		label_dk2.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_dk22.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_dk3.setHorizontalAlignment(JLabel.CENTER);
		label_dk33.setHorizontalAlignment(JLabel.CENTER);
		label_dk3.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_dk33.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_dk4.setHorizontalAlignment(JLabel.CENTER);
		label_dk44.setHorizontalAlignment(JLabel.CENTER);
		label_dk4.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_dk44.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_dk5.setHorizontalAlignment(JLabel.CENTER);
		label_dk55.setHorizontalAlignment(JLabel.CENTER);
		label_dk5.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_dk55.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_dk6.setHorizontalAlignment(JLabel.CENTER);
		label_dk66.setHorizontalAlignment(JLabel.CENTER);
		label_dk6.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_dk66.setFont(new Font("맑은고딕", Font.BOLD, 17));
		// 라벨 글자크기 + 가운데 정렬
		// 스낵
		label_sn1.setHorizontalAlignment(JLabel.CENTER);
		label_sn11.setHorizontalAlignment(JLabel.CENTER);
		label_sn1.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_sn11.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_sn2.setHorizontalAlignment(JLabel.CENTER);
		label_sn22.setHorizontalAlignment(JLabel.CENTER);
		label_sn2.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_sn22.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_sn3.setHorizontalAlignment(JLabel.CENTER);
		label_sn33.setHorizontalAlignment(JLabel.CENTER);
		label_sn3.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_sn33.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_sn4.setHorizontalAlignment(JLabel.CENTER);
		label_sn44.setHorizontalAlignment(JLabel.CENTER);
		label_sn4.setFont(new Font("맑은고딕", Font.BOLD, 17));
		label_sn44.setFont(new Font("맑은고딕", Font.BOLD, 17));
		// panel 화면구성
		// 콤보
		tabbedPane.add("콤보", panel_combo);
		panel_combo.setLayout(new GridLayout(2, 3));
		panel_combo.add(panel_cm1);
		panel_cm1.setLayout(new BorderLayout());
		panel_cm1.add("Center", panel_cm11);
		panel_cm11.setLayout(new BorderLayout());
		panel_cm11.add("Center", button_cm1);
		panel_cm11.add("South", panel_cm111);
		panel_cm111.setLayout(new BorderLayout());
		panel_cm111.add("North", label_cm1);
		panel_cm111.add("Center", label_cm11);
		panel_cm111.add("South", label_cm111);
		panel_combo.add(panel_cm2);
		panel_cm2.setLayout(new BorderLayout());
		panel_cm2.add("Center", panel_cm22);
		panel_cm22.setLayout(new BorderLayout());
		panel_cm22.add("Center", button_cm2);
		panel_cm22.add("South", panel_cm222);
		panel_cm222.setLayout(new BorderLayout());
		panel_cm222.add("North", label_cm2);
		panel_cm222.add("Center", label_cm22);
		panel_cm222.add("South", label_cm222);
		panel_combo.add(panel_cm3);
		panel_cm3.setLayout(new BorderLayout());
		panel_cm3.add("Center", panel_cm33);
		panel_cm33.setLayout(new BorderLayout());
		panel_cm33.add("Center", button_cm3);
		panel_cm33.add("South", panel_cm333);
		panel_cm333.setLayout(new BorderLayout());
		panel_cm333.add("North", label_cm3);
		panel_cm333.add("Center", label_cm33);
		panel_cm333.add("South", label_cm333);
		panel_combo.add(panel_cm4);
		panel_cm4.setLayout(new BorderLayout());
		panel_cm4.add("Center", panel_cm44);
		panel_cm44.setLayout(new BorderLayout());
		panel_cm44.add("Center", button_cm4);
		panel_cm44.add("South", panel_cm444);
		panel_cm444.setLayout(new BorderLayout());
		panel_cm444.add("North", label_cm4);
		panel_cm444.add("Center", label_cm44);
		panel_cm444.add("South", label_cm444);
		panel_combo.add(panel_cm5);
		panel_cm5.setLayout(new BorderLayout());
		panel_cm5.add("Center", panel_cm55);
		panel_cm55.setLayout(new BorderLayout());
		panel_cm55.add("Center", button_cm5);
		panel_cm55.add("South", panel_cm555);
		panel_cm555.setLayout(new BorderLayout());
		panel_cm555.add("North", label_cm5);
		panel_cm555.add("Center", label_cm55);
		panel_cm555.add("South", label_cm555);
		panel_combo.add(panel_cm6);
		panel_cm6.setLayout(new BorderLayout());
		panel_cm6.add("Center", panel_cm66);
		panel_cm66.setLayout(new BorderLayout());
		panel_cm66.add("Center", button_cm6);
		panel_cm66.add("South", panel_cm666);
		panel_cm666.setLayout(new BorderLayout());
		panel_cm666.add("North", label_cm6);
		panel_cm666.add("Center", label_cm66);
		panel_cm666.add("South", label_cm666);
		// panel 화면구성
		// 팝콘
		tabbedPane.add("팝콘", panel_popcorn);
		panel_popcorn.setLayout(new GridLayout(2, 3));
		panel_popcorn.add(panel_pc1);
		panel_pc1.setLayout(new BorderLayout());
		panel_pc1.add("Center", panel_pc11);
		panel_pc11.setLayout(new BorderLayout());
		panel_pc11.add("Center", button_pc1);
		panel_pc11.add("South", panel_pc111);
		panel_pc111.setLayout(new BorderLayout());
		panel_pc111.add("North", label_pc1);
		panel_pc111.add("Center", label_pc11);
		panel_popcorn.add(panel_pc2);
		panel_pc2.setLayout(new BorderLayout());
		panel_pc2.add("Center", panel_pc22);
		panel_pc22.setLayout(new BorderLayout());
		panel_pc22.add("Center", button_pc2);
		panel_pc22.add("South", panel_pc222);
		panel_pc222.setLayout(new BorderLayout());
		panel_pc222.add("North", label_pc2);
		panel_pc222.add("Center", label_pc22);
		panel_popcorn.add(panel_pc3);
		panel_pc3.setLayout(new BorderLayout());
		panel_pc3.add("Center", panel_pc33);
		panel_pc33.setLayout(new BorderLayout());
		panel_pc33.add("Center", button_pc3);
		panel_pc33.add("South", panel_pc333);
		panel_pc333.setLayout(new BorderLayout());
		panel_pc333.add("North", label_pc3);
		panel_pc333.add("Center", label_pc33);
		panel_popcorn.add(panel_pc4);
		panel_pc4.setLayout(new BorderLayout());
		panel_pc4.add("Center", panel_pc44);
		panel_pc44.setLayout(new BorderLayout());
		panel_pc44.add("Center", button_pc4);
		panel_pc44.add("South", panel_pc444);
		panel_pc444.setLayout(new BorderLayout());
		panel_pc444.add("North", label_pc4);
		panel_pc444.add("Center", label_pc44);
		panel_popcorn.add(panel_pc5);
		panel_pc5.setLayout(new BorderLayout());
		panel_pc5.add("Center", panel_pc55);
		panel_pc55.setLayout(new BorderLayout());
		panel_pc55.add("Center", button_pc5);
		panel_pc55.add("South", panel_pc555);
		panel_pc555.setLayout(new BorderLayout());
		panel_pc555.add("North", label_pc5);
		panel_pc555.add("Center", label_pc55);
		panel_popcorn.add(panel_pc6);
		panel_pc6.setLayout(new BorderLayout());
		panel_pc6.add("Center", panel_pc66);
		panel_pc66.setLayout(new BorderLayout());
		panel_pc66.add("Center", button_pc6);
		panel_pc66.add("South", panel_pc666);
		panel_pc666.setLayout(new BorderLayout());
		panel_pc666.add("North", label_pc6);
		panel_pc666.add("Center", label_pc66);
		// panel 화면구성
		// 음료
		tabbedPane.add("음료", panel_drink);
		panel_drink.setLayout(new GridLayout(2, 3));
		panel_drink.add(panel_dk1);
		panel_dk1.setLayout(new BorderLayout());
		panel_dk1.add("Center", panel_dk11);
		panel_dk11.setLayout(new BorderLayout());
		panel_dk11.add("Center", button_dk1);
		panel_dk11.add("South", panel_dk111);
		panel_dk111.setLayout(new BorderLayout());
		panel_dk111.add("North", label_dk1);
		panel_dk111.add("Center", label_dk11);
		panel_drink.add(panel_dk2);
		panel_dk2.setLayout(new BorderLayout());
		panel_dk2.add("Center", panel_dk22);
		panel_dk22.setLayout(new BorderLayout());
		panel_dk22.add("Center", button_dk2);
		panel_dk22.add("South", panel_dk222);
		panel_dk222.setLayout(new BorderLayout());
		panel_dk222.add("North", label_dk2);
		panel_dk222.add("Center", label_dk22);
		panel_drink.add(panel_dk3);
		panel_dk3.setLayout(new BorderLayout());
		panel_dk3.add("Center", panel_dk33);
		panel_dk33.setLayout(new BorderLayout());
		panel_dk33.add("Center", button_dk3);
		panel_dk33.add("South", panel_dk333);
		panel_dk333.setLayout(new BorderLayout());
		panel_dk333.add("North", label_dk3);
		panel_dk333.add("Center", label_dk33);
		panel_drink.add(panel_dk4);
		panel_dk4.setLayout(new BorderLayout());
		panel_dk4.add("Center", panel_dk44);
		panel_dk44.setLayout(new BorderLayout());
		panel_dk44.add("Center", button_dk4);
		panel_dk44.add("South", panel_dk444);
		panel_dk444.setLayout(new BorderLayout());
		panel_dk444.add("North", label_dk4);
		panel_dk444.add("Center", label_dk44);
		panel_drink.add(panel_dk5);
		panel_dk5.setLayout(new BorderLayout());
		panel_dk5.add("Center", panel_dk55);
		panel_dk55.setLayout(new BorderLayout());
		panel_dk55.add("Center", button_dk5);
		panel_dk55.add("South", panel_dk555);
		panel_dk555.setLayout(new BorderLayout());
		panel_dk555.add("North", label_dk5);
		panel_dk555.add("Center", label_dk55);
		panel_drink.add(panel_dk6);
		panel_dk6.setLayout(new BorderLayout());
		panel_dk6.add("Center", panel_dk66);
		panel_dk66.setLayout(new BorderLayout());
		panel_dk66.add("Center", button_dk6);
		panel_dk66.add("South", panel_dk666);
		panel_dk666.setLayout(new BorderLayout());
		panel_dk666.add("North", label_dk6);
		panel_dk666.add("Center", label_dk66);
		// panel 화면구성
		// 스낵
		tabbedPane.add("스낵", panel_snack);
		tabbedPane.setFont(new Font("맑은고딕", Font.BOLD, 23));
		panel_snack.setLayout(new GridLayout(2, 3));
		panel_snack.add(panel_sn1);
		panel_sn1.setLayout(new BorderLayout());
		panel_sn1.add("Center", panel_sn11);
		panel_sn11.setLayout(new BorderLayout());
		panel_sn11.add("Center", button_sn1);
		panel_sn11.add("South", panel_sn111);
		panel_sn111.setLayout(new BorderLayout());
		panel_sn111.add("North", label_sn1);
		panel_sn111.add("Center", label_sn11);
		panel_snack.add(panel_sn2);
		panel_sn2.setLayout(new BorderLayout());
		panel_sn2.add("Center", panel_sn22);
		panel_sn22.setLayout(new BorderLayout());
		panel_sn22.add("Center", button_sn2);
		panel_sn22.add("South", panel_sn222);
		panel_sn222.setLayout(new BorderLayout());
		panel_sn222.add("North", label_sn2);
		panel_sn222.add("Center", label_sn22);
		panel_snack.add(panel_sn3);
		panel_sn3.setLayout(new BorderLayout());
		panel_sn3.add("Center", panel_sn33);
		panel_sn33.setLayout(new BorderLayout());
		panel_sn33.add("Center", button_sn3);
		panel_sn33.add("South", panel_sn333);
		panel_sn333.setLayout(new BorderLayout());
		panel_sn333.add("North", label_sn3);
		panel_sn333.add("Center", label_sn33);
		panel_snack.add(panel_sn4);
		panel_sn4.setLayout(new BorderLayout());
		panel_sn4.add("Center", panel_sn44);
		panel_sn44.setLayout(new BorderLayout());
		panel_sn44.add("Center", button_sn4);
		panel_sn44.add("South", panel_sn444);
		panel_sn444.setLayout(new BorderLayout());
		panel_sn444.add("North", label_sn4);
		panel_sn444.add("Center", label_sn44);
		panel_snack.add(button23);
		panel_snack.add(button24);

		// 이미지 버튼 컬러 색상 변경
		button_cm1.setBackground(Color.WHITE);
		button_cm2.setBackground(Color.WHITE);
		button_cm3.setBackground(Color.WHITE);
		button_cm4.setBackground(Color.WHITE);
		button_cm5.setBackground(Color.WHITE);
		button_cm6.setBackground(Color.WHITE);
		button_pc1.setBackground(Color.WHITE);
		button_pc2.setBackground(Color.WHITE);
		button_pc3.setBackground(Color.WHITE);
		button_pc4.setBackground(Color.WHITE);
		button_pc5.setBackground(Color.WHITE);
		button_pc6.setBackground(Color.WHITE);
		button_dk1.setBackground(Color.WHITE);
		button_dk2.setBackground(Color.WHITE);
		button_dk3.setBackground(Color.WHITE);
		button_dk4.setBackground(Color.WHITE);
		button_dk5.setBackground(Color.WHITE);
		button_dk6.setBackground(Color.WHITE);
		button_sn1.setBackground(Color.WHITE);
		button_sn2.setBackground(Color.WHITE);
		button_sn3.setBackground(Color.WHITE);
		button_sn4.setBackground(Color.WHITE);

		// 스낵 부분 준비중입니다 버튼 클릭X 처리
		button23.setBackground(Color.LIGHT_GRAY);
		button23.setFont(new Font("맑은고딕", Font.BOLD, 35));
		button23.setEnabled(false);
		button24.setBackground(Color.LIGHT_GRAY);
		button24.setFont(new Font("맑은고딕", Font.BOLD, 35));
		button24.setEnabled(false);

		// 단순 하단 색깔 넣기용+ 결제 버튼
		panel_south.setBackground(new Color(220, 70, 30));
		panel_south.setLayout(new BorderLayout());
		panel_south.add("Center", Label_south);
		panel_south.add("East", button_pay);
		button_pay.setEnabled(false);
		Label_south.setHorizontalAlignment(JLabel.CENTER);
		Label_south.setFont(new Font("맑은고딕", Font.BOLD, 25));
		// 버튼 색상 변경
		button_pay.setBackground(Color.BLACK);
		button_pay.setFont(new Font("맑은고딕", Font.BOLD, 25));

		// 콤보 박스 크기 설정
		comboBox.setPreferredSize(new Dimension(200, 30));
		// comboBox 내용 수정 설정
		comboBox.setEditable(true);
		// comboBox의 행의 갯수 설정
		comboBox.setMaximumRowCount(5);

	}

	private void start() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		button_cm1.addActionListener(this);
//		button_cm2.addActionListener(this);
//		button_cm3.addActionListener(this);
//		button_cm4.addActionListener(this);
//		button_cm5.addActionListener(this);
//		button_cm6.addActionListener(this);
//		button_pc1.addActionListener(this);
//		button_pc2.addActionListener(this);
//		button_pc3.addActionListener(this);
//		button_pc4.addActionListener(this);
//		button_pc5.addActionListener(this);
//		button_pc6.addActionListener(this);
//		button_dk1.addActionListener(this);
//		button_dk2.addActionListener(this);
//		button_dk3.addActionListener(this);
//		button_dk4.addActionListener(this);
//		button_dk5.addActionListener(this);
//		button_dk6.addActionListener(this);
//		button_sn1.addActionListener(this);
//		button_sn2.addActionListener(this);
//		button_sn3.addActionListener(this);
//		button_sn4.addActionListener(this);
//		button_pay.addActionListener(this);
//		b_logout.addActionListener(this);
//		b_WGV.addActionListener(this);
		// 커서 변경 -> 마우스로
		JButton[] allButtons = { b_logout, b_mywgv, b_custom, b_tabmoive, b_tabmoiveRe, b_tabFood, b_WGV, button_pay,
				button_sn4, button_sn3, button_sn2, button_sn1, button_sn4, button_dk6, button_dk5, button_dk4,
				button_dk3, button_dk2, button_dk1, button_pc6, button_pc5, button_pc4, button_pc3, button_pc2,
				button_pc1, button_cm6, button_cm5, button_cm4, button_cm3, button_cm2, button_cm1 };

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
		if (e.getSource() == button_cm1) {
			choose1();
		} else if (e.getSource() == button_cm2) {
			choose2();
		} else if (e.getSource() == button_cm3) {
			choose3();
		} else if (e.getSource() == button_cm4) {
			choose4();
		} else if (e.getSource() == button_cm5) {
			choose5();
		} else if (e.getSource() == button_cm6) {
			choose6();
		} else if (e.getSource() == button_pc1) {
			choose7();
		} else if (e.getSource() == button_pc2) {
			choose8();
		} else if (e.getSource() == button_pc3) {
			choose9();
		} else if (e.getSource() == button_pc4) {
			choose10();
		} else if (e.getSource() == button_pc5) {
			choose11();
		} else if (e.getSource() == button_pc6) {
			choose12();
		} else if (e.getSource() == button_dk1) {
			choose13();
		} else if (e.getSource() == button_dk2) {
			choose14();
		} else if (e.getSource() == button_dk3) {
			choose15();
		} else if (e.getSource() == button_dk4) {
			choose16();
		} else if (e.getSource() == button_dk5) {
			choose17();
		} else if (e.getSource() == button_dk6) {
			choose18();
		} else if (e.getSource() == button_sn1) {
			choose19();
		} else if (e.getSource() == button_sn2) {
			choose20();
		} else if (e.getSource() == button_sn3) {
			choose21();
		} else if (e.getSource() == button_sn4) {
			choose22();
		} else if (e.getSource() == button_pay) {
			choose23();
			dispose();
		} else if (e.getSource() == b_WGV) {
			dispose();
		} else if (e.getSource() == b_logout) {
			MainPageFrame.showWarning = true;
			new MainPageFrame();
			setVisible(false);
		} else if (e.getSource() == b_WGV) {
			new MainPageFrame();
			setVisible(false);

		} else if (e.getSource() == b_mywgv) {
			new Reservaion_Con();
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

	}

	// DAO 호출
	SnackDAO dao = new SnackDAO();
	SnackDTO dto = new SnackDTO();
	SnackBackDAO Bagdao = new SnackBackDAO();
	SnackBackDTO Bagdto;

	// 리셋 => 주문번호 +1씩 증가 (화면 킬떄마다)
	int num = Bagdao.snackbagNum() + 1;

	private void choose23() {

		int result = 0;

		if (result == JOptionPane.YES_OPTION) {
			List<SnackBackDTO> list = Bagdao.snackbagTOT(num);

			String foodresult = "";
			int totprice = 0;

			for (int i = 0; i < list.size(); i++) {
				Bagdto = list.get(i);
				if (Bagdto.amount >= 0) {
					foodresult += Bagdto.toString() + "\n";
					totprice += Bagdto.getPricetot();
					button_pay.setEnabled(true);

				} else if (Bagdto.getFoodname().equals("")) {
					button_pay.setEnabled(false);
				}
			}
			JOptionPane.showMessageDialog(this, "결제가 완료되었습니다.\n" + foodresult + "\n총 가격 : " + totprice + "원", "결제 완료",
					JOptionPane.INFORMATION_MESSAGE);
			num++;

		} else {
			// 사용자가 결제를 취소한 경우
			JOptionPane.showMessageDialog(this, "결제가 취소되었습니다.", "결제 취소", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// 더블콤보 선택
	private void choose1() {
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("더블콤보");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "더블콤보", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/combo1.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("더블콤보", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "더블콤보 " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);

				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 13000; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("더블콤보"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "더블콤보는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "더블콤보의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose2() { // 라지콤보
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("라지콤보");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "라지콤보", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/combo2.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("라지콤보", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "라지콤보 " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);

				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 15000; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("라지콤보"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */

				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "라지콤보는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "라지콤보의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose3() { // 스몰세트
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("스몰세트");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "스몰세트", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/combo3.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("스몰세트", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "스몰세트 " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 7000; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("스몰세트"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "스몰세트는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "스몰세트의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose4() { // CGV콤보
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("CGV콤보");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "CGV콤보", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/combo4.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를
				button_pay.setEnabled(true);
				int count = dao.updatesnack("CGV콤보", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "CGV콤보 " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);

				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 10000; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("CGV콤보"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "CGV콤보는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "CGV콤보의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose5() { // 우리 패키지
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("우리 패키지");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "우리 패키지", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/combo5.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("우리 패키지", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "우리 패키지 " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 61000; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("우리 패키지"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "우리 패키지는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "우리 패키지의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose6() { // 나랑 너 패키지
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("나랑 너 패키지");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "나랑 너 패키지", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/combo6.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("나랑 너 패키지", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "나랑 너 패키지 " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 34000; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("나랑 너 패키지"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "나랑 너 패키지는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "나랑 너 패키지의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose7() { // 더블치즈팝콘M
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("더블치즈팝콘M");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "더블치즈팝콘M", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/popcorn1.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("더블치즈팝콘M", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "더블치즈팝콘M " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 6000; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("더블치즈팝콘M"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "더블치즈팝콘M는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "더블치즈팝콘M의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose8() { // 바질어니언팝콘M
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("바질어니언팝콘M");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "바질어니언팝콘M", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/popcorn2.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("바질어니언팝콘M", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "바질어니언팝콘M " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 6000; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("바질어니언팝콘M"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "바질어니언팝콘M는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "바질어니언팝콘M의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose9() { // 달콤팝콘M
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("달콤팝콘M");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "달콤팝콘M", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/popcorn3.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("달콤팝콘M", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "달콤팝콘M " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 6000; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("달콤팝콘M"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "달콤팝콘M는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "달콤팝콘M의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose10() { // 더블치즈팝콘L
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("더블치즈팝콘L");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "더블치즈팝콘L", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/popcorn4.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("더블치즈팝콘L", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "더블치즈팝콘L " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 6500; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("더블치즈팝콘L"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "더블치즈팝콘L는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "더블치즈팝콘L의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose11() { // 바질어니언L
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("바질어니언팝콘L");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "바질어니언팝콘L", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/popcorn5.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("바질어니언팝콘L", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "바질어니언팝콘L " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 6500; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("바질어니언팝콘L"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "바질어니언팝콘L는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "바질어니언팝콘L의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose12() { // 달콤팝콘L
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("달콤팝콘L");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "달콤팝콘L", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/popcorn6.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("달콤팝콘L", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "달콤팝콘L " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 6500; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("달콤팝콘L"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "달콤팝콘L는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "달콤팝콘L의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose13() { // 핑크레몬에이드
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("핑크레몬에이드");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "핑크레몬에이드", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/drink1.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("핑크레몬에이드", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "핑크레몬에이드 " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 5500; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("핑크레몬에이드"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "핑크레몬에이드는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "핑크레몬에이드의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose14() { // 에이드
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("에이드");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "에이드", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/drink2.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("에이드", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "에이드 " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 5500; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("에이드"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "에이드는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "에이드의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose15() { // 아메리카노ICE
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("아메리카노ICE");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "아메리카노ICE", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/drink3.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("아메리카노ICE", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "아메리카노ICE " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 4500; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("아메리카노ICE"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "아메리카노ICE는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "아메리카노ICE의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose16() { // 아메리카노HOT
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("아메리카노HOT");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "아메리카노HOT", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/drink4.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("아메리카노HOT", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "아메리카노HOT " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 4000; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("아메리카노HOT"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "아메리카노HOT는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "아메리카노HOT의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose17() { // 탄산음료L
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("탄산음료L");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "탄산음료L", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/drink5.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("탄산음료L", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "탄산음료L " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 3500; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("탄산음료L"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "탄산음료L는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "탄산음료L의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose18() { // 탄산음료M
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("탄산음료M");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "탄산음료M", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/drink6.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("탄산음료M", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "탄산음료M " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 3000; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("탄산음료M"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "탄산음료M는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "탄산음료M의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose19() { // 칠리치즈나쵸
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("칠리치즈나쵸");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "칠리치즈나쵸", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/snack1.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("칠리치즈나쵸", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "칠리치즈나쵸 " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 4900; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("칠리치즈나쵸"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "칠리치즈나쵸는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "칠리치즈나쵸의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose20() { // 플레인핫도그
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("플레인핫도그");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "플레인핫도그", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/snack2.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("플레인핫도그", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "플레인핫도그 " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 4500; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("플레인핫도그"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "플레인핫도그는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "플레인핫도그의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose21() { // 칠리치즈핫도그
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("칠리치즈핫도그");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "칠리치즈핫도그", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/snack3.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("칠리치즈핫도그", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "칠리치즈핫도그 " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 5000; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("칠리치즈핫도그"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "칠리치즈핫도그는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "칠리치즈핫도그의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void choose22() { // 맛밤
		// 수량 선택 다이얼로그 표시
		int amount = dao.selectArticle("맛밤");
		String message = "현재 재고: " + amount + "개\n수량을 선택해주세요?";

		// 수량 선택 다이얼로그 표시
		String result = (String) JOptionPane.showInputDialog(this, message, "맛밤", JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon("foodimg/snack4.png"), strs, "1");

		// 사용자가 수량을 선택하고 확인을 눌렀을 때
		if (result != null) {
			int quantity = Integer.parseInt(result); // 문자열을 정수로 변환

			// 음식이 품절되었는지 확인
			if (amount >= 0 && amount >= quantity) {
				// 업데이트하고 업데이트 결과를 받아옴
				button_pay.setEnabled(true);
				int count = dao.updatesnack("맛밤", quantity); // 선택한 수량만큼 차감
				JOptionPane.showMessageDialog(this, "맛밤 " + quantity + "개 를 장바구니에 담았습니다", "장바구니",
						JOptionPane.INFORMATION_MESSAGE);
				/** 장바구니에 담기 => 각각 품목에 넣어주기 */
				Bagdto = new SnackBackDTO();

				int price = 3500; // -> 1개 가격
				int totalPrice = price * quantity;
				Bagdto.setNum(num);
				Bagdto.setFoodname("맛밤"); // -> 이름
				Bagdto.setPrice(price);
				Bagdto.setAmount(quantity);
				Bagdto.setPricetot(totalPrice);
				Bagdto.setId(idFrame.getUsername());

				Bagdao.snackbag(Bagdto);
				/** 여기까지 */
				// 수량이 0 이하일 때
				if (count <= 0) {
					JOptionPane.showMessageDialog(this, "맛밤는 품절되었습니다.", "품절", JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "맛밤의 재고가 부족합니다.", "재고 부족", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}