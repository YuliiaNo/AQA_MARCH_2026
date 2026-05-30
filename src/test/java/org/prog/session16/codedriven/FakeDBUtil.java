package org.prog.session16.codedriven;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class FakeDBUtil {

    @Step("Storing to DB: {value}")
    public void storeDBRecord(String value) {
        log.info("Store DB Record: " + value);
    }

    @Step("Get record from DB")
    public String getDBRecord() {
        return UUID.randomUUID().toString();
    }
}
