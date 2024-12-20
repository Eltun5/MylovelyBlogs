package com.Simple_Blog.repsitory;

import com.Simple_Blog.enums.AuthorType;
import com.Simple_Blog.model.Author;
import com.Simple_Blog.simpleDB.DBQueries;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorRepository implements ParentOfAllRepositories<Author> {
    private final JdbcTemplate jdbcTemplate;

    public AuthorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Author> getAll() {
        return jdbcTemplate.query(DBQueries.GET_ALL_AUTHORS_QUERY, new RowMapper<Author>() {
            @Override
            public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Author(rs.getInt("id"), rs.getString("username")
                        , rs.getString("email"), null,
                        AuthorType.valueOf(rs.getString("role")),
                        rs.getTimestamp("created_at").toLocalDateTime());
            }
        });
    }
}
