package tms.tennismanagementsystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tms.tennismanagementsystem.app.student.EleveEntity;
import tms.tennismanagementsystem.app.student.EleveRepository;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DataInit {
    @Bean
    CommandLineRunner commandLineRunner(EleveRepository eleveRepository) {
        return args -> {
            EleveEntity first = new EleveEntity("Sam", "Fadatare", "+32481098012", "ramesh@gmail.com", LocalDateTime.now());
            EleveEntity second = new EleveEntity("Samy", "Fadatare", "+32481098012", "ramesh@gmail.com", LocalDateTime.now());
            eleveRepository.saveAll(List.of(first,second));
        };
    }
}
