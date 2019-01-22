package server;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
@CrossOrigin
public class Lista_rozwozowaResource {
    Lista_rozwozowaRepository lista_rozwozowaRepository;

    public Lista_rozwozowaResource(Lista_rozwozowaRepository lista_rozwozowaRepository){
        this.lista_rozwozowaRepository = lista_rozwozowaRepository;
    }

    @GetMapping("/lista_rozwozowa")
    public List<Lista_rozwozowa> getLista_rozwozowa(){
        return (List<Lista_rozwozowa>) lista_rozwozowaRepository.findAll();
    }
}