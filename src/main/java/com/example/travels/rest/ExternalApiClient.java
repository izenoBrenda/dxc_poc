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
package com.example.travels.rest;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "http://a2d355a84067144a9b368ca737078442-1807504106.ap-southeast-1.elb.amazonaws.com:8080")
public interface ExternalApiClient {
    // http://a2d355a84067144a9b368ca737078442-1807504106.ap-southeast-1.elb.amazonaws.com:8080/castlemock/mock/rest/project/ppN5j2/application/rrV11V/enrolment_v1

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/castlemock/mock/rest/project/ppN5j2/application/rrV11V/{parameter}")
    String getEnrolment(@PathParam("parameter") String parameter);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/castlemock/mock/rest/project/ppN5j2/application/rrV11V/completed-screening")    // completed-screening
    String postEnrolment(String body);
}
