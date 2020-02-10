package com.yousyuukai.presto.api.util;

public class Constants {

    public final static String Const = "Const";

    public enum DataType {
        LAKE(1, "L"),
        WAREHOUSE(2, "W"),
        MART(3, "M");

        DataType(int code, String type) {
            this.code = code;
            this.type = type;
        }

        private int code;

        private String type;

        public void setCode(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        @Override
        public String toString() {
            return "DataType{" +
                    "code=" + code +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
}