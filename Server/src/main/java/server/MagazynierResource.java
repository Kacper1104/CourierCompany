package server;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
@CrossOrigin
public class MagazynierResource {
    MagazynierRepository magazynierRepository;

    public MagazynierResource(MagazynierRepository magazynierRepository){
        this.magazynierRepository = magazynierRepository;
    }

    @GetMapping("/magazynier")
    public List<Magazynier> getMagazynier(){
        return (List<Magazynier>) magazynierRepository.findAll();
    }
}