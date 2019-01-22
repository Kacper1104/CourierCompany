package server;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
@CrossOrigin
public class KurierResource {
    KurierRepository kurierRepository;

    public KurierResource(KurierRepository kurierRepository){
        this.kurierRepository = kurierRepository;
    }

    @GetMapping("/kurier")
    public List<Kurier> getKueier(){
        return (List<Kurier>) kurierRepository.findAll();
    }
}