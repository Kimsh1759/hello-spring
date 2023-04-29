package hello.hellospring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import hello.hellospring.DTO.HelloDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.*;

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

    public void UserInfo_add(HelloDTO.UserInfoDTO DTO)
    {
        String sql = String.format("Call InsertUser(%d, \"%s\", %d, %d, %d, %d,%d,\"%s\",\"%s\",\"%s\",%d)",DTO.getEmployeeNumber(),DTO.getName(),DTO.getPW(),DTO.getAuthority(),
                DTO.getTeam(), DTO.getJG(),DTO.getBirth(),DTO.getAddr(), DTO.getTel(), DTO.getMail(), DTO.getDoE());
        jdbcTemplate.update(sql);
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
    public String getAllData(String table) throws JsonProcessingException {
        String sql = String.format("SELECT * FROM %s",table);
        return sqlToDataAll(sql);
    }

    public String getAllDataElectric(String table, int state) throws JsonProcessingException {
        String sql = String.format("SELECT * FROM person.%s where state = %d",table, state);
        return sqlToDataAll(sql);
    }

    public String getAllDataElectricSelf(String table, String writer, int state) throws JsonProcessingException {
        String sql = String.format("SELECT * FROM person.%s where writer = \"%s\" and state = %d",table, writer, state);
        return sqlToDataAll(sql);
    }

    public String getElectric(String table, String id) throws JsonProcessingException {
        String sql = String.format("SELECT * FROM person.%s where id = \"%s\"",table, id);
        return sqlToData(sql);
    }

    public String getALLElectricTeam(String table, String team, int state) throws JsonProcessingException
    {
        String sql = String.format("SELECT * FROM person.%s where team = \"%s\" and state = %d",table, team, state);
        return sqlToDataAll(sql);
    }

    public String getData(String table, int num) throws JsonProcessingException {
        String sql = String.format("SELECT * FROM %s WHERE employeeNumber = %d",table, num);
        return sqlToData(sql);
    }

    public String getMemo(String table, int num, int date) throws JsonProcessingException {
        String sql = String.format("SELECT Memo FROM person.%s WHERE employeeNumber = %d and Mdate = %d", table, num, date);
        return sqlToData(sql);
    }
    public void addMemo_delete(int num, int date)
    {
        String sql = String.format("DELETE person.MyPage FROM person.MyPage JOIN (SELECT id FROM person.MyPage WHERE employeeNumber =" +
                " %d AND Mdate = %d) AS subquery ON person.MyPage.id = subquery.id;",num, date);
        jdbcTemplate.update(sql);
    }

    public void addMemo_insert(int num, int date, String memo)
    {
        String sql = String.format("call InsertMemo(%d, %d, \"%s\")", num, date, memo);
        jdbcTemplate.update(sql);
    }

    public void AddNotice(int num, String name, String title, String content, int wdate, String division, String id)
    {
        String sql = String.format("Call InsertNoticeBoard(%d, \"%s\", \"%s\", \"%s\", %d, \"%s\", \"%s\")", num,name, title,content,wdate,division,id);
        jdbcTemplate.update(sql);
    }

    public void AddApplicationForLeave(String Writer, String team, String title, int startdate, int endDate, String emergencyTel, String reason, String id, int state, int type, int date)
    {
        String sql = String.format("call InsertApplicationForLeave(\"%s\",\"%s\",\"%s\",%d,%d,\"%s\",\"%s\",\"%s\",%d,%d,%d)",Writer, team, title,startdate,endDate,
                emergencyTel,reason,id, state,type,date);
        jdbcTemplate.update(sql);
    }

    public void Addjournal(String title, String writer, String team, String JG, int date, String morning, String afternoon, String significant, String untreated, String id,
                           int state, int type)
    {
        String sql = String.format("call InsertJournal(\"%s\",\"%s\",\"%s\",\"%s\",%d,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",%d,%d)",title,
                writer, team, JG, date, morning, afternoon,significant,untreated,id,state,type);
        jdbcTemplate.update(sql);
    }

    public void AddDraft(int number, String team, String JG, String writer, int date, String title, String remarks, String detail, String id, int state, int type)
    {
        String sql = String.format("call InsertDraft(%d,\"%s\",\"%s\",\"%s\",%d,\"%s\",\"%s\",\"%s\",\"%s\",%d,%d)",number,team,JG,
                writer, date,title,remarks, detail,id,state,type);
        jdbcTemplate.update(sql);
    }

    public void AddPost(int num, String name, String title, String content, int wdate, String division, String id) {
        String sql = String.format("Call InsertFreeBoard(%d, \"%s\", \"%s\", \"%s\", %d, \"%s\", \"%s\")", num, name, title, content, wdate, division, id);
        this.jdbcTemplate.update(sql);
    }

    public String getBoard(String table) throws JsonProcessingException {
        String sql = String.format("SELECT * FROM %s", table);
        return sqlToDataAll(sql);
    }

    public String getBoardContent(String table, String id) throws JsonProcessingException {
        String sql = String.format("SELECT * FROM %s WHERE id = \"%s\"", table, id);
        return sqlToData(sql);
    }

    public String getElectronicPayment(String table) throws JsonProcessingException {
        String sql = String.format("SELECT * FROM %s", table);
        return sqlToDataAll(sql);
    }

    public String sqlToData(String sql) throws JsonProcessingException {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(rows.get(0));
    }

    public String sqlToDataAll(String sql) throws JsonProcessingException {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(rows);
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

    public void updateState(String table, int state, String id)
    {
        String sql = String.format("UPDATE %s SET state = %d WHERE id = \"%s\"", table, state, id);
        jdbcTemplate.update(sql);
    }

    // Delete
    public void deleteDataInt(String table_name, int number) {
        String sql = String.format("DELETE FROM person." +table_name+ " WHERE employeeNumber = %d",number);
        jdbcTemplate.update(sql);
    }

    public void deleteDataString(String table_name, String number) {
        String sql = String.format("DELETE FROM person." +table_name+ " WHERE id = \"%s\"",number);
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
