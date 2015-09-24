package com.controller;

import com.model.Animal;
import com.model.Stapan;
import com.service.IAnimalService;
import com.service.IStapanSerivce;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by bristena.vrancianu on 9/2/2015.
 */
@Controller
public class AnimalController {

    IAnimalService animalService;
    IStapanSerivce stapanService;
    static Logger log = Logger.getLogger(AnimalController.class);

    public void setAnimalService(IAnimalService animalService){
        this.animalService = animalService;

    }
    @RequestMapping("/animals/")
    public @ResponseBody List<Animal> getAnimals(){
        log.info("getAnimals");
       return animalService.getAnimals();

    }

    @RequestMapping("/stapani/")
    public @ResponseBody List<Stapan> getAll(){
        return stapanService.getAll();

    }
    @RequestMapping("/stapani/{id}")
    public @ResponseBody Stapan getStapanById(@PathVariable("id") int id){

        return stapanService.getStapanById(id);

    }
    @RequestMapping("/homeless/")
    public @ResponseBody List<Animal>getAnimaleHomeless(){
        return animalService.createShelterAnimals();

    }

    @RequestMapping("/animale/{id}")
    public @ResponseBody List<Animal>getAnimaleByStapanId(@PathVariable("id") int id){
        return animalService.getAnimalsByIdStapan(id);

    }
    @RequestMapping(value = "/denumire/{nume}", method = RequestMethod.POST)
    public @ResponseBody List<Animal> getDenumireAnimal(@PathVariable("nume") String nume){
        return animalService.getDenumireAnimal(nume);
    }

    @RequestMapping(value ="/greeting/{id}", method = RequestMethod.GET)
    public @ResponseBody Animal getAnimal(@PathVariable("id") int id) {
        return animalService.getAnimalById(id);
    }


    @RequestMapping(value = "/greeting/", method = RequestMethod.POST)
    public @ResponseBody Animal insert(@RequestBody Animal a) {

        return animalService.insert(a);
    }

    @RequestMapping(value = "/greeting/", method = RequestMethod.PUT)
    public @ResponseBody void update( @RequestBody Animal a) {
        animalService.update(a.getId(),a.getDenumire(), a.isHomeless(), a.getIdStapan());

    }

    @RequestMapping(value = "/update/", method = RequestMethod.PUT)
        public @ResponseBody void updateStapan(@RequestBody Stapan stapan) {
        stapanService.update(stapan.getId(), stapan.getNume(), stapan.getCnp(), stapan.isActive());

    }

    @RequestMapping(value = "/insert/", method = RequestMethod.POST)
    public @ResponseBody Stapan insertStapan(@RequestBody Stapan stapan) {
        return stapanService.insert(stapan);

    }


    @RequestMapping(value = "/greeting/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void delete(@PathVariable("id") int id) {
        animalService.delete(id);

    }

    @RequestMapping(value = "/stapan/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteStapan(@PathVariable("id") int id) {
        stapanService.delete(id);

    }

    @RequestMapping("/greeting/{id}")
    public ResponseEntity<String> showAnimal(@PathVariable int id){
        Animal a = animalService.getAnimalById(id);
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping("/animals")
    public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
        String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader");
        byte[] requestBody = requestEntity.getBody();

        // do something with request header and body

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value ="/animals/{id}", method = RequestMethod.GET)
    public ResponseEntity <Animal> getAnimalById(HttpEntity<byte[]> requestEntity,@PathVariable int id) throws UnsupportedEncodingException {

        String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader");
        byte[] requestBody = requestEntity.getBody();
       animalService.getAnimals();
        Animal a = animalService.getAnimalById(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        if(a != null) {

            responseHeaders.set("MyResponseHeader", "MyValue");
            return new ResponseEntity<Animal>(a, responseHeaders, HttpStatus.OK);
        }
        else
            return new ResponseEntity<Animal>(null, responseHeaders, HttpStatus.GONE);

    }

    @RequestMapping(value = "/animals/", method = RequestMethod.POST)
    public ResponseEntity<String> insert(HttpEntity<byte[]> requestEntity,@RequestBody Animal a) {

        String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader");
        byte[] requestBody = requestEntity.getBody();
        Animal animal = animalService.getAnimalById(a.getId());
        HttpHeaders responseHeaders = new HttpHeaders();
        if(a == null) {
            animalService.insert(a);
            responseHeaders.set("MyResponseHeader", "MyValue");
            return new ResponseEntity<String>(a.toString()+" - inserat cu succes", responseHeaders, HttpStatus.OK);
        }
        else
            return new ResponseEntity<String>("Exista acest animal", responseHeaders, HttpStatus.OK);

    }



    public void setStapanService(IStapanSerivce stapanService) {
        this.stapanService = stapanService;
    }
}
