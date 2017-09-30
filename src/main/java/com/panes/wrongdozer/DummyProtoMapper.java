package com.panes.wrongdozer;

import com.panes.dozerprotobuf.DummyDecoded;
import com.panes.dozerprotobuf.DummyProto;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.stereotype.Component;

@Component
public class DummyProtoMapper extends BeanMappingBuilder {

    @Override
    protected void configure() {
        mapping(DummyProto.Dummy.class, DummyDecoded.class);
    }
}
