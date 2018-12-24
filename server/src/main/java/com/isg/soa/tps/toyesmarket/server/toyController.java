package com.isg.soa.tps.toyesmarket.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class toyController {
    private final Logger log= LoggerFactory.getLogger(toyController.class);

    @Autowired
    private  toyRepository repository;


    public toyController(toyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/allElectonictoys")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Toy> allElectonicToys(){
        return repository.findAll().stream()
                .filter(this::isElectronicToyes)
                .collect(Collectors.toList());
    }

    @GetMapping("/alltoys")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Toy> allToys(){
        return repository.findAll();
    }
    private boolean isElectronicToyes(Toy toy) {
        return toy.getType().equals("Electronic");
    }

    @GetMapping("/toy/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> getToy(@PathVariable("id") long id)
    {
        Optional<Toy> toy=repository.findById(id);
        return toy.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
@GetMapping("/toyByName/{name}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Toy> getToy(@PathVariable String name)
    {
        List<Toy> lsttoy=repository.findAll().stream().filter(x ->x.getName().equals(name)).collect(Collectors.toList());
        return lsttoy; //lsttoy.stream().map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/newToy")
    @CrossOrigin(origins = "http://localhost:4200")
    public  ResponseEntity<Toy> addToy(@Valid @RequestBody Toy toy) throws URISyntaxException
    {
        log.info("Request for adding new toy {}",toy);
        Toy result = repository.save(toy);
        return ResponseEntity.created(new URI("/newtoy"+result.getCode())).body(result);
    }

    @PutMapping("/updateToy/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public  ResponseEntity<Toy> updateToy(@Valid @RequestBody Toy toy, @PathVariable("id")  long id)
    {
        log.info("Request for updating new toy {}", toy);

        Optional<Toy> toyOptional = repository.findById(id);

        if (!toyOptional.isPresent())
            return ResponseEntity.notFound().build();

        Toy toy1=toyOptional.get();
        toy1.setCode(id);
        toy1.setName(toy.getName());
        toy1.setType(toy.getType());
        toy1.setMaxAge(toy.getMaxAge());
        toy1.setMinAge(toy.getMinAge());
        toy1.setPrice(toy.getPrice());

       // repository.deleteById(id); //with this a new id will be generated
        Toy result=repository.save(toy1);

        //return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(result);
//        Toy toyCopy = new Toy();
//        BeanUtils.copyProperties(toy, toyCopy);
//        ToyService.updateToy(toy);
//
//        Toy ob = new Toy();
//        BeanUtils.copyProperties(toyCopy, ob);
//        return new ResponseEntity<Toy>(ob, HttpStatus.OK);
//
//
//        BeanUtils.copyProperties(toy, toyc);
//        Toy result = repository.save(toy);
//        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/updateByName/{name}")
    @CrossOrigin(origins = "http://localhost:4200")
    public  ResponseEntity<Toy> updateToyByName(@Valid @RequestBody Toy toy, @PathVariable("name")  String name)
    {
        log.info("Request for updating new toy {}", toy);

        Toy toy1 = repository.findAll().stream().filter(x ->x.getName().equals(name)).collect(Collectors.toList()).get(0);
        

        if (toy1==null)
            return ResponseEntity.notFound().build();


        if(toy.getCode()!=null){toy1.setCode(toy.getCode());}
        if(toy.getName()!=null){toy1.setName(toy.getName());}
        if(toy.getType()!=null){toy1.setType(toy.getType());}
        if(toy.getMaxAge()!=null){toy1.setMaxAge(toy.getMaxAge());}
        if(toy.getMinAge()!=null){toy1.setMinAge(toy.getMinAge());}
        if(toy.getPrice()!=null){toy1.setPrice(toy.getPrice());}

        //BeanUtils.copyProperties(toy, toy1);
        //Toy result = repository.save(toy);

        Toy result=repository.save(toy1);

        return ResponseEntity.ok().body(result);

    }

    @DeleteMapping("/removeToy/{name}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> deleteToy(@PathVariable("name") String name)
    {
        log.info("Request for removing toy {}", name);
	    long id=((List<Toy> )repository.findAll().stream().filter(x ->x.getName().equals(name)).collect(Collectors.toList())
                                                                                                ).get(0).getCode();

        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
