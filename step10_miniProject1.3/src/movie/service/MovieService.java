package movie.service;

import java.util.ArrayList;
import java.util.HashMap;

import movie.model.MovieModel;
import movie.model.dto.Movie;
import movie.model.dto.Reservation;
import movie.model.dto.Theater;
import movie.exception.DuplicateException;
import movie.exception.NotExistException;

public class MovieService {
	
	private static MovieService instance = new MovieService();
	
	private static MovieModel movieModel = MovieModel.getInstance();
	
	private MovieService() {}
	
	public static MovieService getInstance() {
		return instance;
	}
	
	/**
	 * 모든 Movie 검색  >> 경준
	 */
	public static ArrayList<Movie> getMovieList() {
		ArrayList<Movie> movieList = MovieModel.getMovieList();
		return movieList;
	}
	
	public static ArrayList<Theater> getTheaterList() {
		ArrayList<Theater> theaterList = MovieModel.getTheaterList();
		return theaterList;
	}

	public static ArrayList<Reservation> getReservationList() {
		ArrayList<Reservation> reservationList = MovieModel.getReservationList();
		return reservationList;
	}
	
	// 해쉬맵을 이용한 영화 정보 조회
	public static HashMap<Theater, Movie> getMovieInfo()
	{
		HashMap<Theater, Movie> movieInfo = MovieModel.movieAll();
		return movieInfo;
	}

	

	
	/**
	 * 영화 제목으로 특정 Movie 검색 - movie 반환 >> 지수
	 * 
	 * @param movieTitle
	 * @return Movie 검색된 영화, 검색하고자 하는 영화가 없을 경우 null 반환
	 */
	public Movie getMovie(String movieTitle) {
		ArrayList<Movie> movieList = getMovieList();
		
		for(Movie movie : movieList) {
			if (movie.getMovieTitle().equals(movieTitle)) {
				return movie;
			}
		}
		return null;
	}
	
	
	/**
	 * 상영관 이름으로 특정 Theater 검색 - theater 반환 >> 지수
	 * 
	 * @param theaterName
	 * @return Theater 검색된 상영관, 검색하고자 하는 상영관이 없을 경우 null 반환
	 */
	public Theater getTheater(String theaterName) {
		ArrayList<Theater> theaterList = getTheaterList();
		
		for(Theater theater : theaterList) {
			if (theater.getTheaterName().equals(theaterName)) {
				return theater;
			}
		}
		return null;
	}
	
	
	
	/**
	 * 예약자 이름으로 특정 Reservation 검색 - reservation 반환  >> 지수
	 * 
	 * @param name
	 * @return Reservation 검색된 예약, 검색하고자 하는 예약 내역이 없을 경우 null 반환
	 */
	public static Reservation getReservation(String name) {
		ArrayList<Reservation> reservationList = getReservationList();
		
		for(Reservation reservation : reservationList) {
			if (reservation.getName().equals(name)) {
				return reservation;
			} 
		}
		return null;
	}
	
	/**
	 * 예약 번호로 특정 Reservation 검색 - reservation 반환  >> 지수
	 * 
	 * @param reservationNo
	 * @return Reservation 검색된 예약, 검색하고자 하는 예약 내역이 없을 경우 null 반환
	 */
	public static Reservation getReservationNo(int reservationNo) {
		ArrayList<Reservation> reservationList = getReservationList();
		
		for(Reservation reservation : reservationList) {
			if (reservation.getReservationNo() == reservationNo) {
				return reservation;
			} 
		}
		return null;
	}
	
	
//	------------------------------------------------------------------------------------------
	
	/**
	 * 새로운 Reservation 추가 
	 * 새로 저장하고자 하는 Reservation이 이미 존재할 경우 DuplicateException 예외 발생
	 * 
	 * @param newReservation      저장하고자 하는 새로운 예약
	 * @throws DuplicateException
	 */
	public void reservationInsert(Reservation newReservation) throws DuplicateException {
		Reservation reservation = getReservationNo(newReservation.getReservationNo());
		
		if (reservation != null) {
			throw new DuplicateException("해당 예약 번호와 동일한 번호의 예약 내역이 존재합니다.");
		}
		movieModel.insertReservation(newReservation);
	}
	

	
	/**
	 * Reservation의 영화 제목 수정 - 예약자 이름으로 검색해서 해당 예약의 영화 제목 수정
	 * 수정하고자 하는 예약이 존재하지 않을 경우 NotExistException 발생
	 * 
	 * @param name 예약자 이름
	 * @param movieTitle 영화 제목
	 * @throws NotExistException
	 */
	public void reservationUpdate(String name, String movieTitle) throws NotExistException {
		Reservation reservation = getReservation(name);
		
		if(reservation == null){
			throw new NotExistException("수정하고자 하는 예약 내역이 존재하지 않는 에러가 발생했습니다.");
		}else {
			reservation.setMovieTitle(movieTitle);
		}
	}

	
	/**
	 * Reservation 삭제 - 예약자 이름으로 해당 예약 삭제
	 * 
	 * @param name 예약자 이름
	 * @throws NotExistException
	 */
	public void reservationDelete(String name) throws NotExistException{
		Reservation reservation = getReservation(name);
		
		if(reservation == null) {
			throw new NotExistException("삭제하고자 하는 예약 내역이 존재하지 않는 에러가 발생했습니다.");
		}else {
			getReservationList().remove(reservation);
		}
	}
	
}