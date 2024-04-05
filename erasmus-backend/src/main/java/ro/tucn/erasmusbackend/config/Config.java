package ro.tucn.erasmusbackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.tucn.erasmusbackend.mapper.*;
import ro.tucn.erasmusbackend.repository.*;
import ro.tucn.erasmusbackend.service.*;

@Configuration
public class Config {

    @Bean
    public ChefService chefServiceBean(
            ChefRepository chefRepository,
            ChefMapper chefMapper,
            @Value("${spring.application.name:BACKEND}") String applicationName
    ) {
        return new ChefServiceBean(chefRepository, chefMapper, applicationName);
    }

    @Bean
    public BareSubjectService bareSubjectService(
            BareSubjectRepository bareSubjectRepository,
            BareSubjectMapper bareSubjectMapper,
            @Value("${spring.application.name:BACKEND}") String applicationName
    ) {
        return new BareSubjectServiceBean(bareSubjectRepository, bareSubjectMapper, applicationName);
    }

    @Bean
    public AnnouncementService announcementServiceBean(
            AnnouncementRepository announcementRepository,
            AnnouncementMapper announcementMapper,
            @Value("${spring.application.name:BACKEND}") String applicationName
    ) {
        return new AnnouncementServiceBean(announcementRepository, announcementMapper, applicationName);
    }

    @Bean
    public FacultyService facultyServiceBean(
            FacultyRepository facultyRepository,
            FacultyMapper facultyMapper,
            @Value("${spring.application.name:BACKEND}") String applicationName
    ) {
        return new FacultyServiceBean(facultyRepository, facultyMapper, applicationName);
    }

    @Bean
    public UniversityService universityServiceBean(
            UniversityRepository universityRepository,
            UniversityMapper universityMapper,
            @Value("${spring.application.name:BACKEND}") String applicationName
    ) {
        return new UniversityServiceBean(universityRepository, universityMapper, applicationName);
    }

    @Bean
    public UniqueSubjectService uniqueubjectService(
            UniqueSubjectRepository uniqueSubjectRepository,
            UniqueSubjectMapper uniqueSubjectMapper,
            @Value("${spring.application.name:BACKEND}") String applicationName
    ) {
        return new UniqueSubjectServiceBean(uniqueSubjectRepository, uniqueSubjectMapper, applicationName);
    }
}