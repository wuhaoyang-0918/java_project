package org.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 昊洋
 * @date:2021-07-31 9:54
 * @PackageName: org.example
 * @description:
 * @Version 1.0
 */
@Component
public class ComplexAssembly {
  /*  @Value("${petsList}")
    private List<String> list;

    private Map<String, String> map;
    @Value("${petsSet}")
    private Set<String> set;
    @Value("${petsArray}")
    private String[] array;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "ComplexAssembly{" +
                "list=" + list +
                ", map=" + map +
                ", set=" + set +
                ", array=" + Arrays.toString(array) +
                '}';
    }*/
}
