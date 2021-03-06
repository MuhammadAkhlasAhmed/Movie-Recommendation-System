package com.app.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.app.dao.ItemReviewDao;
import com.app.model.ItemReview;

/**
 * The Class ItemReviewDaoImpl.
 */
@Repository
public class ItemReviewDaoImpl extends JdbcDaoSupport implements ItemReviewDao {

    public static List<ItemReview> resultSet;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    /**
     * The method that return all user reviews.
     */
    @Override
    public List<ItemReview> getAllItemReviews() {
        String sql = "SELECT * FROM item_review";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<ItemReview> result = new ArrayList<ItemReview>();
        for (Map<String, Object> row : rows) {
            ItemReview itemReview = new ItemReview();
            itemReview.setId(Long.parseLong((row.get("item_id").toString())));
            itemReview.setAction(row.get("action").toString());
            itemReview.setAdventure(row.get("adventure").toString());
            itemReview.setAnimation(row.get("animation").toString());
            itemReview.setChildrens(row.get("childrens").toString());
            itemReview.setComedy(row.get("comedy").toString());
            itemReview.setCrime(row.get("crime").toString());
            itemReview.setDocumentary(row.get("documentary").toString());
            itemReview.setDrama(row.get("drama").toString());
            itemReview.setFantasy(row.get("fantasy").toString());
            itemReview.setFilmNoir(row.get("film_noir").toString());
            itemReview.setHorror(row.get("horror").toString());
            itemReview.setMusical(row.get("musical").toString());
            itemReview.setMystery(row.get("mystery").toString());
            itemReview.setRomance(row.get("romance").toString());
            itemReview.setSciFi(row.get("sci_fi").toString());
            itemReview.setThriller(row.get("thriller").toString());
            itemReview.setWar(row.get("war").toString());
            itemReview.setWestern(row.get("western").toString());
            itemReview.setFamily(row.get("family").toString());
            itemReview.setHistory(row.get("history").toString());
            itemReview.setRealityTv(row.get("reality_tv").toString());
            itemReview.setMusic(row.get("music").toString());
            result.add(itemReview);
        }

        return result;
    }

    /**
     * The method that return user reviews against genres.
     */
    @Override
    public List<ItemReview> getRowAgainstGenres(List<String> list) {

        if (list.size() == 1 || list.get(0).equalsIgnoreCase("foreign")) {
        	String genre = "Drama";
            String sql = "SELECT * FROM item_review where (" + genre.toLowerCase() + "='1')";
            List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
            resultSet = new ArrayList<ItemReview>();
            for (Map<String, Object> row : rows) {
                ItemReview itemReview = new ItemReview();
                itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                itemReview.setAction(row.get("action").toString());
                itemReview.setAdventure(row.get("adventure").toString());
                itemReview.setAnimation(row.get("animation").toString());
                itemReview.setChildrens(row.get("childrens").toString());
                itemReview.setComedy(row.get("comedy").toString());
                itemReview.setCrime(row.get("crime").toString());
                itemReview.setDocumentary(row.get("documentary").toString());
                itemReview.setDrama(row.get("drama").toString());
                itemReview.setFantasy(row.get("fantasy").toString());
                itemReview.setFilmNoir(row.get("film_noir").toString());
                itemReview.setHorror(row.get("horror").toString());
                itemReview.setMusical(row.get("musical").toString());
                itemReview.setMystery(row.get("mystery").toString());
                itemReview.setRomance(row.get("romance").toString());
                itemReview.setSciFi(row.get("sci_fi").toString());
                itemReview.setThriller(row.get("thriller").toString());
                itemReview.setWar(row.get("war").toString());
                itemReview.setWestern(row.get("western").toString());
                itemReview.setFamily(row.get("family").toString());
                itemReview.setHistory(row.get("history").toString());
                itemReview.setRealityTv(row.get("reality_tv").toString());
                itemReview.setMusic(row.get("music").toString());
                resultSet.add(itemReview);
            }
        }// end 1st if
        if (list.size() == 2) {
        	if(list.get(0).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
        		String sql = "SELECT * FROM item_review where " + genre.toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1'";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
                    ItemReview itemReview = new ItemReview();
                    itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                    itemReview.setAction(row.get("action").toString());
                    itemReview.setAdventure(row.get("adventure").toString());
                    itemReview.setAnimation(row.get("animation").toString());
                    itemReview.setChildrens(row.get("childrens").toString());
                    itemReview.setComedy(row.get("comedy").toString());
                    itemReview.setCrime(row.get("crime").toString());
                    itemReview.setDocumentary(row.get("documentary").toString());
                    itemReview.setDrama(row.get("drama").toString());
                    itemReview.setFantasy(row.get("fantasy").toString());
                    itemReview.setFilmNoir(row.get("film_noir").toString());
                    itemReview.setHorror(row.get("horror").toString());
                    itemReview.setMusical(row.get("musical").toString());
                    itemReview.setMystery(row.get("mystery").toString());
                    itemReview.setRomance(row.get("romance").toString());
                    itemReview.setSciFi(row.get("sci_fi").toString());
                    itemReview.setThriller(row.get("thriller").toString());
                    itemReview.setWar(row.get("war").toString());
                    itemReview.setWestern(row.get("western").toString());
                    itemReview.setFamily(row.get("family").toString());
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(1).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
        		String sql = "SELECT * FROM item_review where " + list.get(0).toLowerCase() + "='1' and " + genre.toLowerCase() + "='1'";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
                    ItemReview itemReview = new ItemReview();
                    itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                    itemReview.setAction(row.get("action").toString());
                    itemReview.setAdventure(row.get("adventure").toString());
                    itemReview.setAnimation(row.get("animation").toString());
                    itemReview.setChildrens(row.get("childrens").toString());
                    itemReview.setComedy(row.get("comedy").toString());
                    itemReview.setCrime(row.get("crime").toString());
                    itemReview.setDocumentary(row.get("documentary").toString());
                    itemReview.setDrama(row.get("drama").toString());
                    itemReview.setFantasy(row.get("fantasy").toString());
                    itemReview.setFilmNoir(row.get("film_noir").toString());
                    itemReview.setHorror(row.get("horror").toString());
                    itemReview.setMusical(row.get("musical").toString());
                    itemReview.setMystery(row.get("mystery").toString());
                    itemReview.setRomance(row.get("romance").toString());
                    itemReview.setSciFi(row.get("sci_fi").toString());
                    itemReview.setThriller(row.get("thriller").toString());
                    itemReview.setWar(row.get("war").toString());
                    itemReview.setWestern(row.get("western").toString());
                    itemReview.setFamily(row.get("family").toString());
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if (list.get(0).toLowerCase() != "foreign" &&  list.get(1).toLowerCase() != "foreign") {
        		String sql = "SELECT * FROM item_review where " + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1'";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
                    ItemReview itemReview = new ItemReview();
                    itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                    itemReview.setAction(row.get("action").toString());
                    itemReview.setAdventure(row.get("adventure").toString());
                    itemReview.setAnimation(row.get("animation").toString());
                    itemReview.setChildrens(row.get("childrens").toString());
                    itemReview.setComedy(row.get("comedy").toString());
                    itemReview.setCrime(row.get("crime").toString());
                    itemReview.setDocumentary(row.get("documentary").toString());
                    itemReview.setDrama(row.get("drama").toString());
                    itemReview.setFantasy(row.get("fantasy").toString());
                    itemReview.setFilmNoir(row.get("film_noir").toString());
                    itemReview.setHorror(row.get("horror").toString());
                    itemReview.setMusical(row.get("musical").toString());
                    itemReview.setMystery(row.get("mystery").toString());
                    itemReview.setRomance(row.get("romance").toString());
                    itemReview.setSciFi(row.get("sci_fi").toString());
                    itemReview.setThriller(row.get("thriller").toString());
                    itemReview.setWar(row.get("war").toString());
                    itemReview.setWestern(row.get("western").toString());
                    itemReview.setFamily(row.get("family").toString());
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	}
       }// end 2nd if
        if (list.size() == 3) {
        	if(list.get(0).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + genre.toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
                    ItemReview itemReview = new ItemReview();
                    itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                    itemReview.setAction(row.get("action").toString());
                    itemReview.setAdventure(row.get("adventure").toString());
                    itemReview.setAnimation(row.get("animation").toString());
                    itemReview.setChildrens(row.get("childrens").toString());
                    itemReview.setComedy(row.get("comedy").toString());
                    itemReview.setCrime(row.get("crime").toString());
                    itemReview.setDocumentary(row.get("documentary").toString());
                    itemReview.setDrama(row.get("drama").toString());
                    itemReview.setFantasy(row.get("fantasy").toString());
                    itemReview.setFilmNoir(row.get("film_noir").toString());
                    itemReview.setHorror(row.get("horror").toString());
                    itemReview.setMusical(row.get("musical").toString());
                    itemReview.setMystery(row.get("mystery").toString());
                    itemReview.setRomance(row.get("romance").toString());
                    itemReview.setSciFi(row.get("sci_fi").toString());
                    itemReview.setThriller(row.get("thriller").toString());
                    itemReview.setWar(row.get("war").toString());
                    itemReview.setWestern(row.get("western").toString());
                    itemReview.setFamily(row.get("family").toString());
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(1).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + genre.toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
                    ItemReview itemReview = new ItemReview();
                    itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                    itemReview.setAction(row.get("action").toString());
                    itemReview.setAdventure(row.get("adventure").toString());
                    itemReview.setAnimation(row.get("animation").toString());
                    itemReview.setChildrens(row.get("childrens").toString());
                    itemReview.setComedy(row.get("comedy").toString());
                    itemReview.setCrime(row.get("crime").toString());
                    itemReview.setDocumentary(row.get("documentary").toString());
                    itemReview.setDrama(row.get("drama").toString());
                    itemReview.setFantasy(row.get("fantasy").toString());
                    itemReview.setFilmNoir(row.get("film_noir").toString());
                    itemReview.setHorror(row.get("horror").toString());
                    itemReview.setMusical(row.get("musical").toString());
                    itemReview.setMystery(row.get("mystery").toString());
                    itemReview.setRomance(row.get("romance").toString());
                    itemReview.setSciFi(row.get("sci_fi").toString());
                    itemReview.setThriller(row.get("thriller").toString());
                    itemReview.setWar(row.get("war").toString());
                    itemReview.setWestern(row.get("western").toString());
                    itemReview.setFamily(row.get("family").toString());
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(2).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + genre.toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
                    ItemReview itemReview = new ItemReview();
                    itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                    itemReview.setAction(row.get("action").toString());
                    itemReview.setAdventure(row.get("adventure").toString());
                    itemReview.setAnimation(row.get("animation").toString());
                    itemReview.setChildrens(row.get("childrens").toString());
                    itemReview.setComedy(row.get("comedy").toString());
                    itemReview.setCrime(row.get("crime").toString());
                    itemReview.setDocumentary(row.get("documentary").toString());
                    itemReview.setDrama(row.get("drama").toString());
                    itemReview.setFantasy(row.get("fantasy").toString());
                    itemReview.setFilmNoir(row.get("film_noir").toString());
                    itemReview.setHorror(row.get("horror").toString());
                    itemReview.setMusical(row.get("musical").toString());
                    itemReview.setMystery(row.get("mystery").toString());
                    itemReview.setRomance(row.get("romance").toString());
                    itemReview.setSciFi(row.get("sci_fi").toString());
                    itemReview.setThriller(row.get("thriller").toString());
                    itemReview.setWar(row.get("war").toString());
                    itemReview.setWestern(row.get("western").toString());
                    itemReview.setFamily(row.get("family").toString());
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if (list.get(0).toLowerCase() != "foreign" &&  list.get(1).toLowerCase() != "foreign" && list.get(2).toLowerCase() != "foreign") {
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
                    ItemReview itemReview = new ItemReview();
                    itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                    itemReview.setAction(row.get("action").toString());
                    itemReview.setAdventure(row.get("adventure").toString());
                    itemReview.setAnimation(row.get("animation").toString());
                    itemReview.setChildrens(row.get("childrens").toString());
                    itemReview.setComedy(row.get("comedy").toString());
                    itemReview.setCrime(row.get("crime").toString());
                    itemReview.setDocumentary(row.get("documentary").toString());
                    itemReview.setDrama(row.get("drama").toString());
                    itemReview.setFantasy(row.get("fantasy").toString());
                    itemReview.setFilmNoir(row.get("film_noir").toString());
                    itemReview.setHorror(row.get("horror").toString());
                    itemReview.setMusical(row.get("musical").toString());
                    itemReview.setMystery(row.get("mystery").toString());
                    itemReview.setRomance(row.get("romance").toString());
                    itemReview.setSciFi(row.get("sci_fi").toString());
                    itemReview.setThriller(row.get("thriller").toString());
                    itemReview.setWar(row.get("war").toString());
                    itemReview.setWestern(row.get("western").toString());
                    itemReview.setFamily(row.get("family").toString());
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} 
        }// end 3rd if
        if (list.size() == 4) {
        	if(list.get(0).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + genre.toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
                    ItemReview itemReview = new ItemReview();
                    itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                    itemReview.setAction(row.get("action").toString());
                    itemReview.setAdventure(row.get("adventure").toString());
                    itemReview.setAnimation(row.get("animation").toString());
                    itemReview.setChildrens(row.get("childrens").toString());
                    itemReview.setComedy(row.get("comedy").toString());
                    itemReview.setCrime(row.get("crime").toString());
                    itemReview.setDocumentary(row.get("documentary").toString());
                    itemReview.setDrama(row.get("drama").toString());
                    itemReview.setFantasy(row.get("fantasy").toString());
                    itemReview.setFilmNoir(row.get("film_noir").toString());
                    itemReview.setHorror(row.get("horror").toString());
                    itemReview.setMusical(row.get("musical").toString());
                    itemReview.setMystery(row.get("mystery").toString());
                    itemReview.setRomance(row.get("romance").toString());
                    itemReview.setSciFi(row.get("sci_fi").toString());
                    itemReview.setThriller(row.get("thriller").toString());
                    itemReview.setWar(row.get("war").toString());
                    itemReview.setWestern(row.get("western").toString());
                    itemReview.setFamily(row.get("family").toString());
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(1).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + genre.toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
                    ItemReview itemReview = new ItemReview();
                    itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                    itemReview.setAction(row.get("action").toString());
                    itemReview.setAdventure(row.get("adventure").toString());
                    itemReview.setAnimation(row.get("animation").toString());
                    itemReview.setChildrens(row.get("childrens").toString());
                    itemReview.setComedy(row.get("comedy").toString());
                    itemReview.setCrime(row.get("crime").toString());
                    itemReview.setDocumentary(row.get("documentary").toString());
                    itemReview.setDrama(row.get("drama").toString());
                    itemReview.setFantasy(row.get("fantasy").toString());
                    itemReview.setFilmNoir(row.get("film_noir").toString());
                    itemReview.setHorror(row.get("horror").toString());
                    itemReview.setMusical(row.get("musical").toString());
                    itemReview.setMystery(row.get("mystery").toString());
                    itemReview.setRomance(row.get("romance").toString());
                    itemReview.setSciFi(row.get("sci_fi").toString());
                    itemReview.setThriller(row.get("thriller").toString());
                    itemReview.setWar(row.get("war").toString());
                    itemReview.setWestern(row.get("western").toString());
                    itemReview.setFamily(row.get("family").toString());
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(2).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + genre.toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
                    ItemReview itemReview = new ItemReview();
                    itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                    itemReview.setAction(row.get("action").toString());
                    itemReview.setAdventure(row.get("adventure").toString());
                    itemReview.setAnimation(row.get("animation").toString());
                    itemReview.setChildrens(row.get("childrens").toString());
                    itemReview.setComedy(row.get("comedy").toString());
                    itemReview.setCrime(row.get("crime").toString());
                    itemReview.setDocumentary(row.get("documentary").toString());
                    itemReview.setDrama(row.get("drama").toString());
                    itemReview.setFantasy(row.get("fantasy").toString());
                    itemReview.setFilmNoir(row.get("film_noir").toString());
                    itemReview.setHorror(row.get("horror").toString());
                    itemReview.setMusical(row.get("musical").toString());
                    itemReview.setMystery(row.get("mystery").toString());
                    itemReview.setRomance(row.get("romance").toString());
                    itemReview.setSciFi(row.get("sci_fi").toString());
                    itemReview.setThriller(row.get("thriller").toString());
                    itemReview.setWar(row.get("war").toString());
                    itemReview.setWestern(row.get("western").toString());
                    itemReview.setFamily(row.get("family").toString());
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(3).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1' and " + genre.toLowerCase() + "='1')";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
                    ItemReview itemReview = new ItemReview();
                    itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                    itemReview.setAction(row.get("action").toString());
                    itemReview.setAdventure(row.get("adventure").toString());
                    itemReview.setAnimation(row.get("animation").toString());
                    itemReview.setChildrens(row.get("childrens").toString());
                    itemReview.setComedy(row.get("comedy").toString());
                    itemReview.setCrime(row.get("crime").toString());
                    itemReview.setDocumentary(row.get("documentary").toString());
                    itemReview.setDrama(row.get("drama").toString());
                    itemReview.setFantasy(row.get("fantasy").toString());
                    itemReview.setFilmNoir(row.get("film_noir").toString());
                    itemReview.setHorror(row.get("horror").toString());
                    itemReview.setMusical(row.get("musical").toString());
                    itemReview.setMystery(row.get("mystery").toString());
                    itemReview.setRomance(row.get("romance").toString());
                    itemReview.setSciFi(row.get("sci_fi").toString());
                    itemReview.setThriller(row.get("thriller").toString());
                    itemReview.setWar(row.get("war").toString());
                    itemReview.setWestern(row.get("western").toString());
                    itemReview.setFamily(row.get("family").toString());
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if (list.get(0).toLowerCase() != "foreign" &&  list.get(1).toLowerCase() != "foreign" && list.get(2).toLowerCase() != "foreign" && list.get(3).toLowerCase() != "foreign") {
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1' and " + list.get(3).toLowerCase() + "='1')";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
                    ItemReview itemReview = new ItemReview();
                    itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                    itemReview.setAction(row.get("action").toString());
                    itemReview.setAdventure(row.get("adventure").toString());
                    itemReview.setAnimation(row.get("animation").toString());
                    itemReview.setChildrens(row.get("childrens").toString());
                    itemReview.setComedy(row.get("comedy").toString());
                    itemReview.setCrime(row.get("crime").toString());
                    itemReview.setDocumentary(row.get("documentary").toString());
                    itemReview.setDrama(row.get("drama").toString());
                    itemReview.setFantasy(row.get("fantasy").toString());
                    itemReview.setFilmNoir(row.get("film_noir").toString());
                    itemReview.setHorror(row.get("horror").toString());
                    itemReview.setMusical(row.get("musical").toString());
                    itemReview.setMystery(row.get("mystery").toString());
                    itemReview.setRomance(row.get("romance").toString());
                    itemReview.setSciFi(row.get("sci_fi").toString());
                    itemReview.setThriller(row.get("thriller").toString());
                    itemReview.setWar(row.get("war").toString());
                    itemReview.setWestern(row.get("western").toString());
                    itemReview.setFamily(row.get("family").toString());
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
			}
        } //end 4th if
        	if (list.size() == 5) {
        	if(list.get(0).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + genre.toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
                    ItemReview itemReview = new ItemReview();
                    itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                    itemReview.setAction(row.get("action").toString());
                    itemReview.setAdventure(row.get("adventure").toString());
                    itemReview.setAnimation(row.get("animation").toString());
                    itemReview.setChildrens(row.get("childrens").toString());
                    itemReview.setComedy(row.get("comedy").toString());
                    itemReview.setCrime(row.get("crime").toString());
                    itemReview.setDocumentary(row.get("documentary").toString());
                    itemReview.setDrama(row.get("drama").toString());
                    itemReview.setFantasy(row.get("fantasy").toString());
                    itemReview.setFilmNoir(row.get("film_noir").toString());
                    itemReview.setHorror(row.get("horror").toString());
                    itemReview.setMusical(row.get("musical").toString());
                    itemReview.setMystery(row.get("mystery").toString());
                    itemReview.setRomance(row.get("romance").toString());
                    itemReview.setSciFi(row.get("sci_fi").toString());
                    itemReview.setThriller(row.get("thriller").toString());
                    itemReview.setWar(row.get("war").toString());
                    itemReview.setWestern(row.get("western").toString());
                    itemReview.setFamily(row.get("family").toString());
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(1).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + genre.toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
                    ItemReview itemReview = new ItemReview();
                    itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                    itemReview.setAction(row.get("action").toString());
                    itemReview.setAdventure(row.get("adventure").toString());
                    itemReview.setAnimation(row.get("animation").toString());
                    itemReview.setChildrens(row.get("childrens").toString());
                    itemReview.setComedy(row.get("comedy").toString());
                    itemReview.setCrime(row.get("crime").toString());
                    itemReview.setDocumentary(row.get("documentary").toString());
                    itemReview.setDrama(row.get("drama").toString());
                    itemReview.setFantasy(row.get("fantasy").toString());
                    itemReview.setFilmNoir(row.get("film_noir").toString());
                    itemReview.setHorror(row.get("horror").toString());
                    itemReview.setMusical(row.get("musical").toString());
                    itemReview.setMystery(row.get("mystery").toString());
                    itemReview.setRomance(row.get("romance").toString());
                    itemReview.setSciFi(row.get("sci_fi").toString());
                    itemReview.setThriller(row.get("thriller").toString());
                    itemReview.setWar(row.get("war").toString());
                    itemReview.setWestern(row.get("western").toString());
                    itemReview.setFamily(row.get("family").toString());
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(2).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + genre.toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
                    ItemReview itemReview = new ItemReview();
                    itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                    itemReview.setAction(row.get("action").toString());
                    itemReview.setAdventure(row.get("adventure").toString());
                    itemReview.setAnimation(row.get("animation").toString());
                    itemReview.setChildrens(row.get("childrens").toString());
                    itemReview.setComedy(row.get("comedy").toString());
                    itemReview.setCrime(row.get("crime").toString());
                    itemReview.setDocumentary(row.get("documentary").toString());
                    itemReview.setDrama(row.get("drama").toString());
                    itemReview.setFantasy(row.get("fantasy").toString());
                    itemReview.setFilmNoir(row.get("film_noir").toString());
                    itemReview.setHorror(row.get("horror").toString());
                    itemReview.setMusical(row.get("musical").toString());
                    itemReview.setMystery(row.get("mystery").toString());
                    itemReview.setRomance(row.get("romance").toString());
                    itemReview.setSciFi(row.get("sci_fi").toString());
                    itemReview.setThriller(row.get("thriller").toString());
                    itemReview.setWar(row.get("war").toString());
                    itemReview.setWestern(row.get("western").toString());
                    itemReview.setFamily(row.get("family").toString());
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(3).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1' and " + genre.toLowerCase() + "='1')";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
                    ItemReview itemReview = new ItemReview();
                    itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                    itemReview.setAction(row.get("action").toString());
                    itemReview.setAdventure(row.get("adventure").toString());
                    itemReview.setAnimation(row.get("animation").toString());
                    itemReview.setChildrens(row.get("childrens").toString());
                    itemReview.setComedy(row.get("comedy").toString());
                    itemReview.setCrime(row.get("crime").toString());
                    itemReview.setDocumentary(row.get("documentary").toString());
                    itemReview.setDrama(row.get("drama").toString());
                    itemReview.setFantasy(row.get("fantasy").toString());
                    itemReview.setFilmNoir(row.get("film_noir").toString());
                    itemReview.setHorror(row.get("horror").toString());
                    itemReview.setMusical(row.get("musical").toString());
                    itemReview.setMystery(row.get("mystery").toString());
                    itemReview.setRomance(row.get("romance").toString());
                    itemReview.setSciFi(row.get("sci_fi").toString());
                    itemReview.setThriller(row.get("thriller").toString());
                    itemReview.setWar(row.get("war").toString());
                    itemReview.setWestern(row.get("western").toString());
                    itemReview.setFamily(row.get("family").toString());
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(4).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1' and " + list.get(3).toLowerCase() + "='1') or (" + genre.toLowerCase() + "='1')";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
                    ItemReview itemReview = new ItemReview();
                    itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                    itemReview.setAction(row.get("action").toString());
                    itemReview.setAdventure(row.get("adventure").toString());
                    itemReview.setAnimation(row.get("animation").toString());
                    itemReview.setChildrens(row.get("childrens").toString());
                    itemReview.setComedy(row.get("comedy").toString());
                    itemReview.setCrime(row.get("crime").toString());
                    itemReview.setDocumentary(row.get("documentary").toString());
                    itemReview.setDrama(row.get("drama").toString());
                    itemReview.setFantasy(row.get("fantasy").toString());
                    itemReview.setFilmNoir(row.get("film_noir").toString());
                    itemReview.setHorror(row.get("horror").toString());
                    itemReview.setMusical(row.get("musical").toString());
                    itemReview.setMystery(row.get("mystery").toString());
                    itemReview.setRomance(row.get("romance").toString());
                    itemReview.setSciFi(row.get("sci_fi").toString());
                    itemReview.setThriller(row.get("thriller").toString());
                    itemReview.setWar(row.get("war").toString());
                    itemReview.setWestern(row.get("western").toString());
                    itemReview.setFamily(row.get("family").toString());
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if (list.get(0).toLowerCase() != "foreign" &&  list.get(1).toLowerCase() != "foreign" && list.get(2).toLowerCase() != "foreign" && list.get(3).toLowerCase() != "foreign" && list.get(4).toLowerCase() != "foreign") {
            String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1' and " + list.get(3).toLowerCase() + "='1') or (" + list.get(4).toLowerCase() + "='1')";
            List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
            resultSet = new ArrayList<ItemReview>();
            for (Map<String, Object> row : rows) {
                ItemReview itemReview = new ItemReview();
                itemReview.setId(Long.parseLong((row.get("item_id").toString())));
                itemReview.setAction(row.get("action").toString());
                itemReview.setAdventure(row.get("adventure").toString());
                itemReview.setAnimation(row.get("animation").toString());
                itemReview.setChildrens(row.get("childrens").toString());
                itemReview.setComedy(row.get("comedy").toString());
                itemReview.setCrime(row.get("crime").toString());
                itemReview.setDocumentary(row.get("documentary").toString());
                itemReview.setDrama(row.get("drama").toString());
                itemReview.setFantasy(row.get("fantasy").toString());
                itemReview.setFilmNoir(row.get("film_noir").toString());
                itemReview.setHorror(row.get("horror").toString());
                itemReview.setMusical(row.get("musical").toString());
                itemReview.setMystery(row.get("mystery").toString());
                itemReview.setRomance(row.get("romance").toString());
                itemReview.setSciFi(row.get("sci_fi").toString());
                itemReview.setThriller(row.get("thriller").toString());
                itemReview.setWar(row.get("war").toString());
                itemReview.setWestern(row.get("western").toString());
                itemReview.setFamily(row.get("family").toString());
                itemReview.setHistory(row.get("history").toString());
                itemReview.setRealityTv(row.get("reality_tv").toString());
                itemReview.setMusic(row.get("music").toString());
                resultSet.add(itemReview);
              }
            }
        } else {
	}
        return resultSet;
    }

    /**
     * The method that save user reviews against genres.
     */
	@Override
	public int save(List<String> movieGenres, List<String> allGenres, String feature) {
		if(feature.equalsIgnoreCase("like")) {
			int insert = 0;
		if(movieGenres.size() == 1) {
			String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+") values('1')";
			insert = getJdbcTemplate().update(sqlInsert);
		} if(movieGenres.size() == 2) {
			String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+","+movieGenres.get(1).toLowerCase()+") values('1','1')";
			insert = getJdbcTemplate().update(sqlInsert);
		} if(movieGenres.size() == 3) {
			String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+","+movieGenres.get(1).toLowerCase()+","+movieGenres.get(2).toLowerCase()+") values('1','1','1')";
			insert = getJdbcTemplate().update(sqlInsert);
		} if(movieGenres.size() == 4) {
			String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+","+movieGenres.get(1).toLowerCase()+","+movieGenres.get(2).toLowerCase()+","+movieGenres.get(3).toLowerCase()+") values('1','1','1','1')";
			insert = getJdbcTemplate().update(sqlInsert);
		} if(movieGenres.size() == 5) {
			String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+","+movieGenres.get(1).toLowerCase()+","+movieGenres.get(2).toLowerCase()+","+movieGenres.get(3).toLowerCase()+","+movieGenres.get(4).toLowerCase()+") values('1','1','1','1','1')";
			insert = getJdbcTemplate().update(sqlInsert);
		}
		return insert;
	}
		int insert = 0;
	if(movieGenres.size() == 1) {
		String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+") values('0')";
		insert = getJdbcTemplate().update(sqlInsert);
	} if(movieGenres.size() == 2) {
		String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+","+movieGenres.get(1).toLowerCase()+") values('0','0')";
		insert = getJdbcTemplate().update(sqlInsert);
	} if(movieGenres.size() == 3) {
		String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+","+movieGenres.get(1).toLowerCase()+","+movieGenres.get(2).toLowerCase()+") values('0','0','0')";
		insert = getJdbcTemplate().update(sqlInsert);
	} if(movieGenres.size() == 4) {
		String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+","+movieGenres.get(1).toLowerCase()+","+movieGenres.get(2).toLowerCase()+","+movieGenres.get(3).toLowerCase()+") values('0','0','0','0')";
		insert = getJdbcTemplate().update(sqlInsert);
	} if(movieGenres.size() == 5) {
		String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+","+movieGenres.get(1).toLowerCase()+","+movieGenres.get(2).toLowerCase()+","+movieGenres.get(3).toLowerCase()+","+movieGenres.get(4).toLowerCase()+") values('0','0','0','0','0')";
		insert = getJdbcTemplate().update(sqlInsert);
	}
	return insert;
		}
	}
