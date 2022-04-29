package com.at.internship.schedule.config;

import com.at.internship.schedule.repository.IAppointmentRepository;
import com.at.internship.schedule.repository.IContactRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultRepositoryConfig {
    /**Application context*/
    private final ApplicationContext context;
    public static final String DEFAULT_CONTACT_REPOSITORY = "${com.at.internship.default.contact.repository}";
    public static final String DEFAULT_APPOINTMENT_REPOSITORY = "${com.at.internship.default.appointment.repository}";


    public DefaultRepositoryConfig(ApplicationContext context){
        this.context = context;
    }

    @Value(DEFAULT_CONTACT_REPOSITORY)
    private String defaultContactRepository;

    @Value(DEFAULT_APPOINTMENT_REPOSITORY)
    private String defaultAppointmentRepository;

    @Bean(name = DEFAULT_CONTACT_REPOSITORY)
    public IContactRepository contactRepository(){
        return (IContactRepository) context.getBean(defaultContactRepository);
    }

    @Bean(name = DEFAULT_APPOINTMENT_REPOSITORY)
    public IAppointmentRepository appointmentRepository(){
        return (IAppointmentRepository) context.getBean(defaultAppointmentRepository);
    }
}
