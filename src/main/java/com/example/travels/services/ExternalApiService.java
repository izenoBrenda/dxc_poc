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
package com.example.travels.services;

import com.example.travels.rest.ExternalApiClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class ExternalApiService {
    
    private static final Logger logger = LoggerFactory.getLogger(ExternalApiService.class);

    @Inject
    @RestClient
    ExternalApiClient externalApiClient;

    public String fetchData(String parameter) {
        try {
            return externalApiClient.getEnrolment(parameter);
        } catch (Exception e) {
            logger.error("Error processing data: {}", e.getMessage());
            // return e.getMessage();
            return externalApiClient.getEnrolment(parameter);
        }
    }

    public String sendData(String body) {
        // Call the API and return the result
        return externalApiClient.postEnrolment(body);
    }
}