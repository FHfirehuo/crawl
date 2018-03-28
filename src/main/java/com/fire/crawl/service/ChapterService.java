package com.fire.crawl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChapterService {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
    public ChapterService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	public void save(String title, String content) {
		
		
		String sql = "insert into chapter (title, content) values (?, ?)";
		jdbcTemplate.update(sql, title, content);
	}

}
