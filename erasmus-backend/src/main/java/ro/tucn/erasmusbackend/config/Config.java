package ro.tucn.erasmusbackend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.tucn.erasmusbackend.mapper.*;
import ro.tucn.erasmusbackend.repository.*;
import ro.tucn.erasmusbackend.service.announcement.AnnouncementService;
import ro.tucn.erasmusbackend.service.announcement.AnnouncementServiceBean;
import ro.tucn.erasmusbackend.service.bareSubject.BareSubjectService;
import ro.tucn.erasmusbackend.service.bareSubject.BareSubjectServiceBean;
import ro.tucn.erasmusbackend.service.faculty.FacultyService;
import ro.tucn.erasmusbackend.service.faculty.FacultyServiceBean;
import ro.tucn.erasmusbackend.service.mail.MailService;
import ro.tucn.erasmusbackend.service.mail.SyncMailServiceBean;
import ro.tucn.erasmusbackend.service.pdf.SyncPdfServiceBean;
import ro.tucn.erasmusbackend.service.person.PersonService;
import ro.tucn.erasmusbackend.service.person.PersonServiceBean;
import ro.tucn.erasmusbackend.service.representative.RepresentativeService;
import ro.tucn.erasmusbackend.service.representative.RepresentativeServiceBean;
import ro.tucn.erasmusbackend.service.student.StudentService;
import ro.tucn.erasmusbackend.service.student.StudentServiceBean;
import ro.tucn.erasmusbackend.service.uniqueSubject.UniqueSubjectService;
import ro.tucn.erasmusbackend.service.uniqueSubject.UniqueSubjectServiceBean;
import ro.tucn.erasmusbackend.service.university.UniversityService;
import ro.tucn.erasmusbackend.service.university.UniversityServiceBean;
import ro.tucn.erasmusbackend.service.user.UserService;
import ro.tucn.erasmusbackend.service.user.UserServiceBean;
import org.springframework.jms.core.JmsTemplate;
import ro.tucn.erasmusbackend.service.mail.AsyncMailServiceBean;
import ro.tucn.erasmusbackend.service.pdf.PdfService;

@Configuration
public class Config {

    @Bean
    public UserService userServiceBean(
            UserRepository userRepository,
            UserMapper userMapper
    ) {
        return new UserServiceBean(userRepository, userMapper);
    }

    @Bean
    public BareSubjectService bareSubjectServiceBean(
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
    public UniqueSubjectService uniqueSubjectServiceBean(
            UniqueSubjectRepository uniqueSubjectRepository,
            UniqueSubjectMapper uniqueSubjectMapper,
            @Value("${spring.application.name:BACKEND}") String applicationName
    ) {
        return new UniqueSubjectServiceBean(uniqueSubjectRepository, uniqueSubjectMapper, applicationName);
    }

    @Bean
    public PersonService personServiceBean(
            PersonRepository personRepository,
            PersonMapper personMapper,
            @Value("${spring.application.name:BACKEND}") String applicationName
    ) {
        return new PersonServiceBean(personRepository, personMapper, applicationName);
    }

    @Bean
    public StudentService studentServiceBean(
            StudentRepository studentRepository,
            StudentMapper studentMapper,
            @Value("${spring.application.name:BACKEND}") String applicationName
    ) {
        return new StudentServiceBean(studentRepository, studentMapper, applicationName);
    }

    @Bean
    public RepresentativeService representativeServiceBean(
            RepresentativeRepository representativeRepository,
            RepresentativeMapper representativeMapper,
            @Value("${spring.application.name:BACKEND}") String applicationName
    ) {
        return new RepresentativeServiceBean(representativeRepository, representativeMapper, applicationName);
    }

    @Bean
    public MailService syncMailServiceBean(
            @Value("${mail-sender-app.url}") String url,
            RestTemplateBuilder restTemplateBuilder
    ) {
        return new SyncMailServiceBean(url, restTemplateBuilder.build());
    }

    @Bean
    public MailService asyncMailServiceBean(
            @Value("${queues.async-mail-sender-request}") String destination,
            JmsTemplate jmsTemplate,
            ObjectMapper objectMapper
    ) {
        return new AsyncMailServiceBean(destination, jmsTemplate, objectMapper);
    }

    @Bean
    public PdfService pdfServiceBean (
            @Value("http://localhost:2001/api/pdf/v1/generator") String url,
            RestTemplateBuilder restTemplateBuilder
    ) {
        return new SyncPdfServiceBean(url, restTemplateBuilder.build());
    }
}