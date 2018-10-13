package com.RestAPI.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.RestAPI.Model.Counter;

@Repository
public class CounterDAOImpl implements CounterDAO {

	@Autowired
	SessionFactory sessionFactory;

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public void update(Counter count) {
		List list=getID();
		String sql = "UPDATE Counter SET id =:id+1 ";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(count));
	}

	private SqlParameterSource getSqlParameterByModel(Counter count) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("id", count.getId());
		return parameterSource;
	}

	public List getID() {
		List list = new ArrayList();
		String sql = "SELECT id from counter";
		list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new counterMapper());
		return list;
	}

	private static final class counterMapper implements RowMapper {
		public Counter mapRow(ResultSet rs, int rowNum) throws SQLException {
			Counter c = new Counter();
			c.setId(rs.getInt("id"));
			return c;
		}
	}

}
