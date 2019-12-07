package com.dummyTesting;

public class CSVFileException extends Exception {
        public enum ExceptionType{
            NO_SUCHFILE, RUNTIME_ERROR;
        }
        public ExceptionType type;

        public CSVFileException(String message, ExceptionType type) {
            super(message);
            this.type= type;
        }
        public CSVFileException(ExceptionType type, Throwable cause) {
            super(cause);
            this.type= type;
        }
    }


