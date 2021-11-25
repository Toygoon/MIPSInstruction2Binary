package com.toygoon.mipsi2b;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveManager {
    private SimpleDateFormat sdf = new SimpleDateFormat ( "yyyyMMdd_HHmmss");
    private Date date;
    private String fileName;
    private File file;

    public SaveManager() {
        this.date = new Date();
        fileName = sdf.format(date) + ".txt";
        file = new File(fileName);
    }

    public void appendData(String content) throws Exception {
        FileOutputStream fos = new FileOutputStream(file, true);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        PrintStream ps = new PrintStream(bos);

        ps.println(content);
        ps.close();
    }
}
