package com.amit.springaop.flightmanagement.dao;

import com.amit.springaop.flightmanagement.domain.Passenger;
import com.amit.springaop.flightmanagement.exception.CountryDoesNotExistException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PassengerDaoImpl implements PassengerDao {

    private static Map<Integer,Passenger> passengerMap = new HashMap<>();
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Passenger> rowMapper = ((resultSet, rowNum) -> {
        Passenger passenger = new Passenger();
        passenger.setName(resultSet.getString("name"));
        passenger.setCountry(resultSet.getString("country"));
        return passenger;
    } );

    public  static Map<Integer, Passenger> getPassengerMap() {
        return passengerMap;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    private Passenger getById(int id){
        String sql = "SELECT * FROM PASSENGER WHERE ID=?";
        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    @Override
    public Passenger getPassenger(int id) {

        if(passengerMap.get(id)!=null)
            return passengerMap.get(id);
        Passenger passenger = getById(id);
        return passenger;
    }

    @Override
    public void add(Passenger passenger) {
        if(!Arrays.asList(Locale.getISOCountries()).contains(passenger.getCountry())){
            throw new CountryDoesNotExistException(passenger.getCountry());
        }

        String sql = "INSERT INTO PASSENGER (NAME,COUNTRY) VALUES(?,?)";
        jdbcTemplate.update(sql,new Object[]{passenger.getName(),passenger.getCountry()});
    }
}
