package herve.project.webapp.service;

import herve.project.webapp.model.Hobby;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HobbyService {


    private List<Hobby> hobbies;

    public HobbyService() {

        hobbies = new ArrayList<>();

        Hobby cinema = new Hobby();
        cinema.setId("1");
        cinema.setName("Cinéma");

        Hobby sport = new Hobby();
        sport.setId("2");
        sport.setName("Sport");

        Hobby manga = new Hobby();
        manga.setId("3");
        manga.setName("Manga");

        Hobby kendo = new Hobby();
        kendo.setId("4");
        kendo.setName("Kendo");

        hobbies.add(cinema);
        hobbies.add(sport);
        hobbies.add(manga);
        hobbies.add(kendo);
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }
}
