package demo.desk;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
@SpringBootApplication
public class DeskApplication {
 public static void main(String[] args) { SpringApplication.run(DeskApplication.class,args); }
 @Bean CommandLineRunner seed(DeskRepository repo) {
  return args -> { if (repo.all().isEmpty()) {
  repo.insert("1", new DeskRecord.Input("Canal school • missing interval", "Amélie Janssens", "Missing reading", "Open", "October first half",LocalDate.now().plusDays(2),"Compare the affected interval and allocation version with the operator data."));
  repo.insert("2", new DeskRecord.Input("Marolles pilot • allocation ratio", "Jules Mertens", "Allocation mismatch", "Reconciled", "October second half",LocalDate.now().plusDays(5),"Compare the affected interval and allocation version with the operator data."));
  repo.insert("3", new DeskRecord.Input("Dansaert co-op • new participant", "Nadia Rahmani", "Roster change", "Closed", "November first week",LocalDate.now().plusDays(8),"Compare the affected interval and allocation version with the operator data."));
  repo.insert("4", new DeskRecord.Input("Jette library • export reading", "Amélie Janssens", "Missing reading", "Open", "October first half",LocalDate.now().plusDays(11),"Compare the affected interval and allocation version with the operator data."));
  repo.insert("5", new DeskRecord.Input("Forest rooftops • roster correction", "Jules Mertens", "Allocation mismatch", "Reconciled", "October second half",LocalDate.now().plusDays(14),"Compare the affected interval and allocation version with the operator data."));
  repo.insert("6", new DeskRecord.Input("Laeken school • import gap", "Nadia Rahmani", "Roster change", "Closed", "November first week",LocalDate.now().plusDays(17),"Compare the affected interval and allocation version with the operator data."));
  }};
 }
}
