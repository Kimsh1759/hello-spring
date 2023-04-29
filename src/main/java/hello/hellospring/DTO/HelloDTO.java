package hello.hellospring.DTO;

import java.util.Base64;

public class HelloDTO {

    public static class UserInfoDTO
    {
        private int employeeNumber;
        private String name;
        private int PW;
        private int authority;
        private int team;
        private int JG;
        private int birth;
        private String addr;
        private String tel;
        private String mail;
        private int DoE;
        public int getEmployeeNumber() {return employeeNumber;}

        public String getName() {return name;}

        public int getPW() {return PW;}

        public int getAuthority() {return authority;}

        public int getTeam() {return team;}

        public int getJG() {return JG;}

        public int getBirth() {return birth;}

        public String getAddr() {return addr;}

        public String getTel() {return tel;}

        public String getMail() {return mail;}

        public int getDoE() {return DoE;}
        public void setEmployeeNumber(int employeeNumber) {
            this.employeeNumber = employeeNumber;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPW(int PW) {
            this.PW = PW;
        }

        public void setAuthority(int authority) {
            this.authority = authority;
        }

        public void setTeam(int team) {
            this.team = team;
        }

        public void setJG(int JG) {
            this.JG = JG;
        }

        public void setBirth(int birth) {
            this.birth = birth;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public void setDoE(int doE) {
            DoE = doE;
        }
    }

    public static class ImageDTO {
        private String table;
        private String column;
        private int num;
        private String img;

        public int getNum() {
            return num;
        }
        public byte[] getImg() {
            return Base64.getDecoder().decode(img);
        }
        public String getColumn() {
            return column;
        }
        public String getTable() {
            return table;
        }

    }

    public static class MemoDTO
    {
        private int num;

        private int date;

        private String memo;

        public void setNum(int num) {
            this.num = num;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public int getNum() {
            return num;
        }

        public int getDate() {
            return date;
        }

        public String getMemo() {
            return memo;
        }

    }

    public static class noticeDTO
    {
        private int num;
        private String name;
        private String title;
        private String content;
        private int wdate;
        private String division;

        private String id;

        public int getNum() {
            return num;
        }

        public String getName() {
            return name;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public int getWdate() {
            return wdate;
        }

        public String getDivision() {
            return division;
        }

        public String getId() {
            return id;
        }
    }

    public static class ApplicationForLeaveDTO
    {
        private String writer;
        private String team;
        private String title;
        private int startdate;
        private int endDate;
        private String emergencyTel;
        private String reason;
        private String id;
        private int state;

        private int type;
        private int date;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public void setWriter(String writer) {
            this.writer = writer;
        }

        public void setTeam(String team) {
            this.team = team;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setStartdate(int startdate) {
            this.startdate = startdate;
        }

        public void setEndDate(int endDate) {
            this.endDate = endDate;
        }

        public void setEmergencyTel(String emergencyTel) {
            this.emergencyTel = emergencyTel;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getWriter() {return writer;}

        public String getTeam() {return team;}

        public String getTitle() {return title;}

        public int getStartdate() {return startdate;}

        public int getEndDate() {return endDate;}

        public String getEmergencyTel() {return emergencyTel;}

        public String getReason() {return reason;}
    }

    public static class JournalDTO
    {
        private String title;
        private String writer;

        private String team;

        private String JG;

        private int date;

        private String morning;
        private String afternoon;
        private String significant;
        private String untreated;

        private String id;

        private int state;

        private int type;

        public String getTeam() {
            return team;
        }

        public void setTeam(String team) {
            this.team = team;
        }

        public String getJG() {
            return JG;
        }

        public void setJG(String JG) {
            this.JG = JG;
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getWriter() {
            return writer;
        }

        public String getMorning() {
            return morning;
        }

        public String getAfternoon() {
            return afternoon;
        }

        public String getSignificant() {
            return significant;
        }

        public String getUntreated() {
            return untreated;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public void setWriter(String writer) {
            this.writer = writer;
        }

        public void setMorning(String morning) {
            this.morning = morning;
        }

        public void setAfternoon(String afternoon) {
            this.afternoon = afternoon;
        }

        public void setSignificant(String significant) {
            this.significant = significant;
        }

        public void setUntreated(String untreated) {
            this.untreated = untreated;
        }
    }

    public static class DraftDTO
    {
        private int number;
        private String team;
        private String JG;
        private String writer;
        private int date;
        private String title;
        private String remarks;
        private String detail;
        private String id;
        private int state;
        private int type;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getTeam() {
            return team;
        }

        public void setTeam(String team) {
            this.team = team;
        }

        public String getJG() {
            return JG;
        }

        public void setJG(String JG) {
            this.JG = JG;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getWriter() {
            return writer;
        }

        public void setWriter(String writer) {
            this.writer = writer;
        }
    }
}
