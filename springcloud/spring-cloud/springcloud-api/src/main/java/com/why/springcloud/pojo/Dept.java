package com.why.springcloud.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept implements Serializable {
    /**
     *
     */
    private Long depton;

    /**
     *
     */
    private String dname;

    /**
     *
     */
    private String db_source;


}

