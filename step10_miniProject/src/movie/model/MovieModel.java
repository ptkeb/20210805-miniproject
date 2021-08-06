package movie.model;

import java.util.ArrayList;
import java.util.HashMap;

import movie.model.dto.Movie;
import movie.model.dto.Reservation;
import movie.model.dto.Theater;


public class MovieModel {
	private static MovieModel instance = new MovieModel();
	
	private static ArrayList<Movie> movieList = new ArrayList<Movie>();
	private static ArrayList<Theater> theaterList = new ArrayList<Theater>();
	private static ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	
	private static HashMap<Theater, Movie>movieInfo = new HashMap<>();
	
	static{
		
		// 영화제목, 감독, 주인공, 장르, 개봉일, 관람등급, 러닝타임
		Movie movieList1 = new Movie("모가디슈", "류승완", "김윤석", "액션,드라마", "2021-07-28", "15세 관람가" , 121);
		Movie movieList2 = new Movie("보스 베이비2" , "톰 맥그라스", "알렉 볼드윈", "애니메이션,코미디,모험",  "2021-07-21", "전체 관람가" , 107);
		Movie movieList3 = new Movie("블랙 위도우","케이트 쇼트랜드", "스칼릿 조핸슨", "액션, 모험, SF", "2021-07-07",  "12세 관람가" , 134);
		Movie movieList4 = new Movie("랑종", "반종 피산다나쿤", "나릴야 군몽콘켓", "공포, 스릴러, 드라마", "2021-07-14", "청소년 관람불가", 131);
		Movie movieList5 = new Movie("정글 크루즈", "자움 콜렛 세라", "드웨인 존슨", "액션, 모험", "2021-07-28", "12세 관람가", 127);
		Movie movieList6 = new Movie("우리, 둘", "필리포 메네게티", "바바라 수코바", "드라마,멜로/로맨스", "2021-07-28", "12세 관람가", 95);
		Movie movieList7 = new Movie("아이스 로드", "조나단 헨슬레이", "리암 니슨", "스릴러", "2021-07-21", "12세 관람가", 110);
		Movie movieList8 = new Movie("꽃다발 같은 사랑을 했다", "도이 노부히로", "아리무라 카스미", "멜로/로맨스", "2021-07-14", "12세 관람가", 123);
		Movie movieList9 = new Movie("피닉스",  "크리스티안 펫졸트", "니나 호스", "드라마/로맨스/멜로", "2021-07-22", "12세 관람가", 98);
		Movie movieList10= new Movie("방법:재차의","김용완", "엄지완", "미스터리,스릴러",  "2021-07-28", "15세 관람가" , 109);
		
		movieList.add(movieList1);
		movieList.add(movieList2);
		movieList.add(movieList3);
		movieList.add(movieList4);
		movieList.add(movieList5);
		movieList.add(movieList6);
		movieList.add(movieList7);
		movieList.add(movieList8);
		movieList.add(movieList9);
		movieList.add(movieList10);
		
		//영화관 이름, 영화관 위치, 좌석수 
		Theater theaterList1 = new Theater("메가박스" , "청담", 110);
		Theater theaterList2 = new Theater("CGV", "신사동", 123);
		Theater theaterList3 = new Theater("롯데시네마", "대치1동", 123);
		Theater theaterList4 = new Theater("씨네Q", "압구정동", 65);
		Theater theaterList5 = new Theater("대한극장", "논현2동", 854);
		Theater theaterList6 = new Theater("조이앤시네마", "모현동", 110);
		Theater theaterList7 = new Theater("아리랑시네센터", "세곡동", 641);
		Theater theaterList8 = new Theater("영화공간주안", "논현1동", 1324);
		Theater theaterList9 = new Theater("영화의전당", "일원2동", 341);
		Theater theaterList10 = new Theater("전주시네마타운", "전북동", 653);
		
		theaterList.add(theaterList1);
		theaterList.add(theaterList2);
		theaterList.add(theaterList3);
		theaterList.add(theaterList4);
		theaterList.add(theaterList5);
		theaterList.add(theaterList6);
		theaterList.add(theaterList7);
		theaterList.add(theaterList8);
		theaterList.add(theaterList9);
		theaterList.add(theaterList10);
		
		// 예약자 이름, 영화 제목, 상영관 이름, 상영 날짜, 러닝타임, 예약 날짜 
		Reservation reservLis1= new Reservation("홍길동", "모가디슈", "메가박스", "2021-07-28", 121, "2021-08-27");
		Reservation reservLis2 = new Reservation("엔코아", "보스 베이비2", "CGV", "2021-07-21", 107, "2021-08-15");
		Reservation reservLis3 = new Reservation("플레이", "블랙 위도우", "롯데시네마", "2021-07-07", 134, "2021-08-26");
		Reservation reservLis4 = new Reservation("행인", "랑종", "씨네Q", "2021-07-14", 131, "2021-07-30");
		Reservation reservLis5 = new Reservation("눈사람", "정글 크루즈", "대한극장", "2021-07-28", 127, "2021-08-04");
		Reservation reservLis6 = new Reservation("김사랑", "우리, 둘", "조이앤시네마", "2021-07-28", 95, "2021-08-06");
		Reservation reservLis7 = new Reservation("김하나", "아이스 로드", "아리랑시네센터", "2021-07-21", 110, "2021-08-15");
		Reservation reservLis8 = new Reservation("김앤나", "꽃다발 같은 사랑을 했다", "영화공간주안", "2021-07-14", 123, "2021-08-31");
		Reservation reservLis9 = new Reservation("제빵왕", "피닉스", "영화의전당", "2021-07-22", 98, "2021-08-16");
		Reservation reservLis10 = new Reservation("김탁구", "방법:재차의", "전주시네마타운", "2021-07-28", 109, "2021-08-31");
		
		reservationList.add(reservLis1);
		reservationList.add(reservLis2);
		reservationList.add(reservLis3);
		reservationList.add(reservLis4);
		reservationList.add(reservLis5);
		reservationList.add(reservLis6);
		reservationList.add(reservLis7);
		reservationList.add(reservLis8);
		reservationList.add(reservLis9);
		reservationList.add(reservLis10);
		
		// 상영관별 상영 영화 리스트 mapping
		movieInfo.put(theaterList1, movieList1);
		movieInfo.put(theaterList2, movieList2);
		movieInfo.put(theaterList3, movieList3);
		movieInfo.put(theaterList4, movieList4);
		movieInfo.put(theaterList5, movieList5);
		movieInfo.put(theaterList6, movieList6);
		movieInfo.put(theaterList7, movieList7);
		movieInfo.put(theaterList8, movieList8);
		movieInfo.put(theaterList9, movieList9);
		movieInfo.put(theaterList10, movieList10);
		
	}
	
	public static MovieModel getInstance() {
		return instance;
	}
	

	public void insertReservation(Reservation newReservation) {
		reservationList.add(newReservation);
	}

	public static HashMap<Theater, Movie> movieAll() {
		return movieInfo;
	}
	
	// movieList, theaterList, reservationList getter, setter
	public static ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public static void setMovieList(ArrayList<Movie> movieList) {
		MovieModel.movieList = movieList;
	}

	public static ArrayList<Theater> getTheaterList() {
		return theaterList;
	}

	public static void setTheaterList(ArrayList<Theater> theaterList) {
		MovieModel.theaterList = theaterList;
	}

	public static ArrayList<Reservation> getReservationList() {
		return reservationList;
	}

	public static void setRevervationList(ArrayList<Reservation> revervationList) {
		MovieModel.reservationList = revervationList;
	}

}
