package server;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
@CrossOrigin
public class OdbiorcaResource {
    OdbiorcaRepository odbiorcaRepository;

    public OdbiorcaResource(OdbiorcaRepository odbiorcaRepository){
        this.odbiorcaRepository = odbiorcaRepository;
    }

    @GetMapping("/odbiorca")
    public List<Nadawca> getNadawca(){
        return (List<Nadawca>) nadawcaRepository.findAll();
    }
}