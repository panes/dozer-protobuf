package com.panes.dozerprotobuf;


import com.google.protobuf.Timestamp;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.dozer.util.DozerConstants;
import org.junit.Test;

import java.time.LocalDate;

import static junit.framework.TestCase.assertNotNull;

public class DateConverterUsingXmlTest {


    @Test
    public void test() {
        Mapper mapper = getMapper("mappings/dozer.xml");
        Timestamp answer = mapper.map(LocalDate.now(), Timestamp.class);

        assertNotNull(answer);
        assertNotNull(answer.getSeconds());
    }

    private Mapper getMapper(String fileName) {
        System.setProperty("log4j.debug", "true");
        System.setProperty(DozerConstants.DEBUG_SYS_PROP, "true");

        return DozerBeanMapperBuilder.create()
                .withMappingFiles(fileName)
                .build();
    }
}