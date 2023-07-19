package mykola.springsecurityproselytebase.rest;

import mykola.springsecurityproselytebase.model.Developer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {

    private List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L,"Vanya","Ivanov"),
            new Developer(2L,"Petr","Petroff"),
            new Developer(3L,"Vanya","Sergeyeff"),
            new Developer(4L,"Tedd","Johnson"),
            new Developer(5L,"Dan","Craython")
    ).collect(Collectors.toList());

    @GetMapping()
    public List<Developer> getAll() {
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id) {

        return DEVELOPERS.stream().filter(d->d.getId().equals(id))
                .findFirst()
                .orElse(new Developer(1000L,"USER","NOTFOUND"));
    }

}
