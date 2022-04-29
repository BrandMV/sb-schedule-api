package com.at.internship.schedule.config;

import com.at.internship.schedule.repository.IAppointmentRepository;
import com.at.internship.schedule.repository.IContactRepository;
import com.at.internship.schedule.repository.impl.CsvAppointmentRepository;
import com.at.internship.schedule.repository.impl.CsvContactRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CsvRepositoryConfig {
    public static final String BEAN_CONTACT_REPOSITORY = "csvContactRepository";
    public static final String BEAN_APPOINTMENT_REPOSITORY = "csvAppointmentRepository";

    @Bean(name = BEAN_CONTACT_REPOSITORY)
    //@Primary /**Al ser primarios spring supone que este es el bean a buscar si no se dice que bean se quiere*/
    public IContactRepository csvContactRepository(){
        return CsvContactRepository.getSingleton();
    }

    /**El nombre*/
    @Bean(name = BEAN_APPOINTMENT_REPOSITORY)
    public IAppointmentRepository csvAppointmentRepository(){
        return CsvAppointmentRepository.getSingleton();
    }
}
