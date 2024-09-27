/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.example.travels.quarkus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.lang.*;
import java.util.*;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VExternal {

    private static final Logger logger = LoggerFactory.getLogger(VExternal.class);
	
    private String src;
    private String e_num;
    private String e_type;
    private String e_valid_till;
    private String addition_num;

    // Default constructor
    public VExternal() {}

    @JsonCreator
    public VExternal(@JsonProperty("src") String src, @JsonProperty("e_num") String e_num, @JsonProperty("e_type") String e_type, @JsonProperty("e_valid_till") String e_valid_till, @JsonProperty("addition_num") String addition_num) {
        this.src = src;
        this.e_num = e_num;
        this.e_type = e_type;
        this.e_valid_till = e_valid_till;
        this.addition_num = addition_num;
    }

    // Getters and setters
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getE_num() {
        return e_num;
    }

    public void setE_num(String e_num) {
        this.e_num = e_num;
    }

    public String getE_type() {
        return e_type;
    }

    public void setE_type(String e_type) {
        this.e_type = e_type;
    }

    public String getE_valid_till() {
        return e_valid_till;
    }

    public void setE_valid_till(String e_valid_till) {
        this.e_valid_till = e_valid_till;  
    }

    public String getAddition_num() {
        return addition_num;
    }

    public void setAddition_num(String addition_num) {
        this.addition_num = addition_num;
    }

    // @Override
    public String toString() {
        return "{src='" + src + "', e_type='" + e_type + "', e_num='" + e_num + "', e_valid_till='" + e_valid_till + "', addition_num='" + addition_num + "'}";
    }

    // public List<String> getPassport() {
    //     return passport;
    // }

    // public void setPassport(List<String> passport) {
    //     this.passport = passport;
    // }

    // public List<String> getSrc() {
    //     return src;
    // }

    // public void setSrc(List<String> src) {
    //     this.src = src;
    // }
}