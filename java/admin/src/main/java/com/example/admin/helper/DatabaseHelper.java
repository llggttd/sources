/**
 * yinghuo.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */
package com.example.admin.helper;

import static org.springframework.util.ResourceUtils.CLASSPATH_URL_PREFIX;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.sqlite.SQLiteDataSource;

/**
 * @author Guotao.Liu
 * @version : DatabaseHelper.java, v 0.1 2020-08-11 14:32 lgt Exp $
 */
public class DatabaseHelper {
    private final static Logger logger = LoggerFactory.getLogger(DatabaseHelper.class);

    @Resource
    private SQLiteDataSource    dataSource;

    private void initDataBase() {
        try {
            String checkSql = "SELECT COUNT(1) FROM sqlite_master";
            Connection connection = dataSource.getConnection();
            ResultSet result = connection.prepareStatement(checkSql).executeQuery();
            if (result != null && result.getInt(1) > 1) {
                logger.info("database exists");
                return;
            }

            File file = ResourceUtils.getFile(CLASSPATH_URL_PREFIX + "db-create.sql");
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if ("\r".equals(line)) {
                    continue;
                }
                stringBuilder.append(line).append("\n");
            }
            connection.prepareStatement(stringBuilder.toString()).execute();
        } catch (FileNotFoundException e) {
            logger.error("file not found {}", CLASSPATH_URL_PREFIX + "db-create.sql");
        } catch (SQLException | IOException throwable) {
            logger.error("", throwable);
        }
    }
}
