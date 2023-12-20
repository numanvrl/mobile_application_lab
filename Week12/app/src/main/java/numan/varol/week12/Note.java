package numan.varol.week12;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {
    private String filepath;
    private Date date;
    private String header;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setFilePath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilePath() {
        return filepath;
    }
}
