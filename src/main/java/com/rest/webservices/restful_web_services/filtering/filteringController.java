package com.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class filteringController {
    @GetMapping(path = "/filtering")
    public SomeBean filtering(){
        return new SomeBean("value1","value2","value3");
    }
    @GetMapping(path = "/filtering-list")
    public List<SomeBean> filteringList(){
        SomeBean bean1=new SomeBean("value1","value2","value3");
        SomeBean bean2=new SomeBean("value1","value2","value3");
        SomeBean bean3=new SomeBean("value1","value2","value3");
        List<SomeBean> list=new ArrayList<>();
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);

        return list;
    }
    @GetMapping(path = "/filtering-dynamic")
    public MappingJacksonValue filteringDynamic(){
        SomeBean someBean=new SomeBean("value1","value2","value3");

        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
        FilterProvider filters=  new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
