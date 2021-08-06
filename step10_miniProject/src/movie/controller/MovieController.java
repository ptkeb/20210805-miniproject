package movie.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import movie.exception.DuplicateException;
import movie.exception.NotExistException;
import movie.model.dto.Movie;
import movie.model.dto.Reservation;
import movie.model.dto.Theater;
import movie.service.MovieService;
import movie.view.EndView;
import movie.view.FailView;

public class MovieController {

	private static MovieController instance = new MovieController();
	private MovieService service = MovieService.getInstance();
	
	private MovieController() {}
	
	public static MovieController getInstance() {
		return instance;
	}
	
	
	/**
	 * ��� Movie �˻�  >> ����
	 */	
	public void getMovieList() {
		ArrayList<Movie> movieList = MovieService.getMovieList();
		
		if (movieList.size() != 0){
			EndView.movieListView(movieList);
		}else {
			EndView.messageView("���� ��ȭ �����Ͱ� �������� �ʽ��ϴ�.");
		}
	}
	
	public void getTheaterList() {
		ArrayList<Theater> theaterList = MovieService.getTheaterList();
		
		if (theaterList.size() != 0){
			EndView.theaterListView(theaterList);
		}else {
			EndView.messageView("���� �󿵰� �����Ͱ� �������� �ʽ��ϴ�.");
		}
	}
	
	public void getReservationList() {
		ArrayList<Reservation> ReservationList = MovieService.getReservationList();
		
		if (ReservationList.size() != 0){
			EndView.reservationListView(ReservationList);
		}else {
			EndView.messageView("���� ���� �����Ͱ� �������� �ʽ��ϴ�");
		}
	}

	// �ؽ����� �̿��� ��ȭ ��ȸ - Movie
	public void getMovieList1(){
		HashMap<Theater, Movie> movieInfo = service.getMovieInfo();

		Collection<Theater> theaterCollections = movieInfo.keySet();
		Theater key = null;
		if (!theaterCollections.isEmpty()){
			Iterator<Theater> theaterIter = theaterCollections.iterator();
			while (theaterIter.hasNext()){
				key = theaterIter.next();
				EndView.movieView(movieInfo.get(key));
			}
		}else {
			EndView.messageView("���� ��ȭ �����Ͱ� �������� �ʽ��ϴ�");
		}

	}


	// �ؽ����� �̿��� �󿵰� ��ȸ - Theater
	public void getTheaterList1() {
		HashMap<Theater, Movie> movieInfo = service.getMovieInfo();
		
		Collection<Theater> theaterCollections = movieInfo.keySet();
		Theater key = null;
		if (!theaterCollections.isEmpty()){
			Iterator<Theater> theaterIter = theaterCollections.iterator();
			while (theaterIter.hasNext()){
				key = theaterIter.next();
				EndView.theatertView(key);
			}
		}else {
			EndView.messageView("���� ��ȭ �����Ͱ� �������� �ʽ��ϴ�");
		}
	}
	
	
	
	
	
	/**
	 * ��ȭ �������� Ư�� Movie �˻� >> ����
	 * 
	 * @param movieTitle
	 */
	public void getMovie(String movieTitle) {
		Movie movie = service.getMovie(movieTitle);
		if(movie != null) {
			EndView.movieView(movie);
		}else {
			EndView.messageView("�˻��Ͻ� ������ ��ȭ�� �������� �ʽ��ϴ�.");
		}
	}
	
	
	/**
	 * �󿵰� �̸����� Ư�� Theater �˻�  >> ����
	 * 
	 * @param theaterName
	 */
	public void getTheater(String theaterName) {
		Theater theater = service.getTheater(theaterName);
		if(theater != null) {
			EndView.theatertView(theater);
		}else {
			EndView.messageView("�˻��Ͻ� �̸��� �󿵰��� �������� �ʽ��ϴ�.");
		}
	}

	
	/**
	 * ������ �̸����� Ư�� Reservation �˻�  >> ����
	 * 
	 * @param name
	 */
	public void getReservation(String name) {
			Reservation reservation = MovieService.getReservation(name);
			if(reservation != null) {
				EndView.reservationView(reservation);
			}else {
				EndView.messageView("�˻��Ͻ� �̸��� ���� ������ �������� �ʽ��ϴ�.");
		}
	}
	
//	---------------------------------------------------------------------------------
	
	/**
	 * ���ο� Reservation ����
	 * 
	 * @param newReservation
	 */
	public void insertReservation(Reservation newReservation) {
		if(newReservation != null) {
			try {
				service.reservationInsert(newReservation);
				EndView.messageView(newReservation.getName() + "���� ������ ���� �����Ǿ����ϴ�.");
			}catch(DuplicateException e) {
				FailView.failMessageView(e.getMessage());
			}
		}else {
			EndView.messageView("���� �����ϰ��� �ϴ� ���� ������ �����ϴ�. ��Ȯ�� �� �ּ���");
		}
	}
	
	
	/**
	 * �����ϴ� Reservation�� ��ȭ ���� ���� 
	 * ������ �̸����� �˻��ؼ� �ش��ϴ� ������ ��ȭ ���� ����
	 * 
	 * @param name
	 * @param movieTitle
	 */
	public void updateReservation(String name, String movieTitle) {
		if(movieTitle != null) {
			try {
				service.reservationUpdate(name, movieTitle);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}	
		}else {
			EndView.messageView("�����ϰ��� �ϴ� ��ȭ ������ ��ȿ�մϴ�, �� Ȯ�� �� �ּ���");
		}
	}
	
	
	/** 
	 * �����ϴ� Reservation ���� 
	 * ������ �̸����� �˻��ؼ� �ش��ϴ� ���� ����
	 * 
	 * @param name
	 */
	public void deleteReservation(String name) {
		if(name != null) {
			try {
				service.reservationDelete(name);
				EndView.messageView(name + "���� ������ �����Ǿ����ϴ�.");
			}catch(NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}	
		}else {
			EndView.messageView("�����ϰ��� �ϴ� ������ �����ڸ��� ��ȿ�մϴ�. �� Ȯ�� �� �ּ���");
		}
	}
	
	
	/** 
	 * Ű����� ������ �Է��ؼ� ���� ���� �߰� 
	 * 
	 */
	public Reservation startReservation() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(in.readLine(),":");;
			
			Reservation newrev = new Reservation();
			newrev.setName(st.nextToken());
			newrev.setMovieTitle(st.nextToken());
			newrev.setTheaterName(st.nextToken());
			newrev.setScreeningDate(st.nextToken());
			newrev.setRunningTime(Integer.parseInt(st.nextToken()));
			newrev.setReservationDate(st.nextToken());
			
			return newrev;
		}catch (IOException e) {
			e.printStackTrace();
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	
}