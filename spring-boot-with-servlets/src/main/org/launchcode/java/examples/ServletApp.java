package org.launchcode.java.examples;

/**
 * Created by mmenne on 10/19/16.
 */
/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */


import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

        import java.io.IOException;

        import javax.servlet.GenericServlet;
        import javax.servlet.Servlet;
        import javax.servlet.ServletException;
        import javax.servlet.ServletRequest;
        import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
        import org.springframework.boot.SpringBootConfiguration;
        import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
        import org.springframework.boot.builder.SpringApplicationBuilder;
        import org.springframework.boot.web.support.SpringBootServletInitializer;
        import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
@EnableAutoConfiguration
public class ServletApp extends SpringBootServletInitializer {

    @SuppressWarnings("serial")
    @Bean
    public Servlet dispatcherServlet() {
        return new GenericServlet() {
            @Override
            public void service(ServletRequest req, ServletResponse res)
                    throws ServletException, IOException {
                res.setContentType("text/plain");
                res.getWriter().append("Hello World");
            }
        };
//        return new HttpServlet() {
//            @Override
//            protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//                res.setContentType("text/plain");
//                res.getWriter().append("Hello World");
//                super.doGet(req, res);
//            }
//        };
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServletApp.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServletApp.class, args);
    }

}
