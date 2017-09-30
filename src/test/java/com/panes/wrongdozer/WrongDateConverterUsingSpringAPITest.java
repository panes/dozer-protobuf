package com.panes.wrongdozer;


import com.google.protobuf.Timestamp;
import com.panes.dozerprotobuf.TestAppConfig;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WrongTestAppConfig.class})
public class WrongDateConverterUsingSpringAPITest {

    @Autowired
    Mapper mapper;

    @Test
    public void test() {
        Timestamp answer = mapper.map(LocalDate.now(), Timestamp.class);

        assertNotNull(answer);
        assertNotNull(answer.getSeconds());
    }
}