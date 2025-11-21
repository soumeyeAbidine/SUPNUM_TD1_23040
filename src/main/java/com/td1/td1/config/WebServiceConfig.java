package com.td1.td1.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurer;
import org.springframework.ws.server.endpoint.adapter.method.MarshallingPayloadMethodProcessor;
import org.springframework.ws.server.endpoint.adapter.method.MethodArgumentResolver;
import org.springframework.ws.server.endpoint.adapter.method.MethodReturnValueHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.List;

@EnableWs
@Configuration
public class WebServiceConfig implements WsConfigurer {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext ctx) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(ctx);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.td1.td1.endpoint");
        return marshaller;
    }

    @Bean(name = "servers")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema serversSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("ServerPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://td1.com/serveur");
        wsdl.setSchema(serversSchema);
        return wsdl;
    }

    @Bean
    public XsdSchema serversSchema() {
        return new SimpleXsdSchema(new org.springframework.core.io.ClassPathResource("servers.xsd"));
    }

    @Override
    public void addArgumentResolvers(List<MethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new MarshallingPayloadMethodProcessor(marshaller()));
    }

    @Override
    public void addReturnValueHandlers(List<MethodReturnValueHandler> returnValueHandlers) {
        returnValueHandlers.add(new MarshallingPayloadMethodProcessor(marshaller()));
    }
}
