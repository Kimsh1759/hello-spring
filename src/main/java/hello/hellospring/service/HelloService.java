package hello.hellospring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class HelloService {
    DataSource dataSource = new DriverManagerDataSource("jdbc:mysql://database.cv7tztt1jtpd.ap-northeast-2.rds.amazonaws.com:3306/person", "admin", "1q2w3e4r");
    @Autowired
    private final JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);

    public String[] SplitData(String data)
    {
        String[] split_Data = data.split("//");
        return split_Data;
    }

    public void createData(String table, String data) {
        String[] userInfoSplit = SplitData(data);
        String sql = "";
        if(Objects.equals(table, "UserInfo"))
        {
            sql = String.format("Call InsertUser(%s, \"%s\", %s, %s, %s, %s,%s,%s,%s,%s,%s)",
                    userInfoSplit[0],userInfoSplit[1],userInfoSplit[2],userInfoSplit[3],userInfoSplit[4],userInfoSplit[5],userInfoSplit[6],userInfoSplit[7]
                    ,userInfoSplit[8],userInfoSplit[9],userInfoSplit[10]);
        }
//        else if(Objects.equals(table, ))
        jdbcTemplate.update(sql);
    }
    // Read
    public String getAllData() throws JsonProcessingException {
        String sql = "SELECT * FROM UserInfo";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(rows);
    }

    public String getData(String table, int num) throws JsonProcessingException {
        String sql = String.format("SELECT * FROM %s WHERE employeeNumber = %d",table, num);
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(rows.get(0));
    }

    public void addMemo_delete(int num, int date)
    {
        String sql = String.format("DELETE person.MyPage FROM person.MyPage JOIN (SELECT id FROM person.MyPage WHERE employeeNumber =" +
                " %d AND Mdate = %d) AS subquery ON person.MyPage.id = subquery.id;",num, date);
        jdbcTemplate.update(sql);
    }

    public void addMemo_insert(int num, int date, String memo)
    {
        String sql = String.format("call InsertMemo(%d, %d, %s)", num, date, memo);
        jdbcTemplate.update(sql);
    }

    // Update
    public void updateData(String table, String column, String data, int num) {
        String sql;
        try{
            int dataToInt = Integer.parseInt(data);
            sql = String.format("UPDATE %s SET %s = %d WHERE employeeNumber= %d", table, column, dataToInt, num);
        }
        catch (NumberFormatException ex){
            sql = String.format("UPDATE %s SET %s = \"%s\" WHERE employeeNumber= %d", table, column, data, num);
        }
        jdbcTemplate.update(sql);
    }

    // Delete
    public void deleteData(String table_name, int number) {
        String sql = String.format("DELETE FROM person." +table_name+ " WHERE employeeNumber = %d",number);
        jdbcTemplate.update(sql);
    }

    public void UpdateImage(String name, String menu,int number ,byte[] imageBytes) {
        //String byteHex = bytesToHex(imageBytes);
        String sql = String.format("UPDATE %s SET %s = ? WHERE employeeNumber = ?",name,menu);
        jdbcTemplate.update(sql, imageBytes, number);
    }

    public ObjectNode ReadImage(String table_name, int number) throws JsonProcessingException {
        String sql = String.format("SELECT img From person.%s WHERE employeeNumber = %d", table_name, number);
        byte[] imageData = jdbcTemplate.queryForObject(sql, byte[].class);
        String encoded = Base64.getEncoder().encodeToString(imageData);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonNode = objectMapper.createObjectNode();
        jsonNode.put("img", encoded);
        return jsonNode;
    }
}
