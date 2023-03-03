package tms.tennismanagementsystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tms.tennismanagementsystem.app.student.EleveEntity;
import tms.tennismanagementsystem.app.student.EleveRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DataInit {
    @Bean
    CommandLineRunner commandLineRunner(EleveRepository eleveRepository) {
        return args -> {
            EleveEntity first = new EleveEntity("Sam", "Sicard", "H", "+32481098012", "ramesh@gmail.com", LocalDate.now());
            EleveEntity second = new EleveEntity("Morn", "Tyn", "H", "+32481098012", "ramesh@gmail.com", LocalDate.now());
            eleveRepository.saveAll(List.of(first,second));
        };
    }
}
