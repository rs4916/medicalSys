package zrs.util;

import java.sql.ResultSet;

public interface ResultSetHandler<T> {
    <T> T handler(ResultSet resultSet);
}