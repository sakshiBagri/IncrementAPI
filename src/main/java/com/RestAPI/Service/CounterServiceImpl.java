package com.RestAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.RestAPI.DAO.CounterDAO;
import com.RestAPI.Model.Counter;

@Service
public class CounterServiceImpl implements CounterService {
	
	@Autowired
	private CounterDAO counDao;

	@Transactional
	public void update(Counter count) {
		counDao.update(count);
	}
	
}
