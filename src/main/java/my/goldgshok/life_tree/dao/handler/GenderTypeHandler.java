package my.goldgshok.life_tree.dao.handler;

import my.goldgshok.life_tree.model.Gender;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.OTHER)
@MappedTypes(Gender.class)
public class GenderTypeHandler implements TypeHandler<Gender> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Gender gender, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, gender.getId());
    }

    @Override
    public Gender getResult(ResultSet resultSet, String s) throws SQLException {
        return Gender.getById(resultSet.getInt(s));
    }

    @Override
    public Gender getResult(ResultSet resultSet, int i) throws SQLException {
        return Gender.getById(resultSet.getInt(i));
    }

    @Override
    public Gender getResult(CallableStatement callableStatement, int i) throws SQLException {
        return Gender.getById(callableStatement.getInt(i));
    }

}