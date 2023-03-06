package tms.tennismanagementsystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tms.tennismanagementsystem.app.formulecours.FormuleCoursEntity;
import tms.tennismanagementsystem.app.formulecours.Periode;
import tms.tennismanagementsystem.app.formulecours.TypeBalle;
import tms.tennismanagementsystem.app.student.EleveEntity;
import tms.tennismanagementsystem.app.student.EleveRepository;
import tms.tennismanagementsystem.app.formulecours.FormuleCoursRepository;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataInit {

    @Bean
    CommandLineRunner commandLineRunner(EleveRepository eleveRepository, FormuleCoursRepository formuleCoursRepository) {
        return args -> {
            EleveEntity first = new EleveEntity("Sam", "Sicard", "H", "+32481098012", "ramesh@gmail.com", LocalDate.now());
            EleveEntity second = new EleveEntity("Morn", "Tyn", "H", "+32481098012", "ramesh@gmail.com", LocalDate.now());
            eleveRepository.saveAll(List.of(first,second));

            FormuleCoursEntity premiereFormule = new FormuleCoursEntity(
                    "Cours jeudi balle dure Vivian 16h", 4, 22,1, "1H",
                    320.00d, 2022,LocalDate.of(2022,06,10), LocalDate.of(2022,8,10), Periode.ETE, TypeBalle.JAUNE);
            FormuleCoursEntity secondeFormule = new FormuleCoursEntity(
                    "Cours samedi balle dure samuel 8h", 4, 22, 1,"1H", 300.00d, 2022, LocalDate.of(2022,06,10), LocalDate.of(2022,8,10), Periode.ETE, TypeBalle.JAUNE);
            FormuleCoursEntity troisiemeFormule = new FormuleCoursEntity(
                    "Cours jeudi balle verte Marco 12h", 4, 30,1, "1H30" ,480.00d, 2022,LocalDate.of(2022,06,10), LocalDate.of(2022,8,10), Periode.HIVER, TypeBalle.VERTE);
            formuleCoursRepository.saveAll(List.of(premiereFormule,secondeFormule,troisiemeFormule));

        };
    }
}
