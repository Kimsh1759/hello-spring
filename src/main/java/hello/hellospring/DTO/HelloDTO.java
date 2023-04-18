package hello.hellospring.DTO;

import java.util.Base64;

public class HelloDTO {
    public static class ImageDTO {
        private String table;

        private String column;
        private int num;
        private String img;
        //

        public int getNum() {
            return num;
        }

        public byte[] getImg() {
            return Base64.getDecoder().decode(img);
        }

        public void setImg(String img) {
            this.img = img;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }

        public String getTable() {
            return table;
        }

        public void setTable(String table_name) {
            this.table = table_name;
        }
    }

    public static class MemoDTO
    {
        private int num;

        private int date;

        private String memo;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }
    }
}
