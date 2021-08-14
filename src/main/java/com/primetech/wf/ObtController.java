package com.primetech.wf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obat")
public class ObtController {

  //private ObtRepository repository;
	private ObtRepository repository;

  @Autowired
  public ObtController(ObtRepository repository) {
    this.repository = repository;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Obt> get(@PathVariable("id") Long id) {
    Obt obt = repository.findOne(id);
    if (null == obt) {
      return new ResponseEntity<Obt>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Obt>(obt, HttpStatus.OK);
  }
  
  
  @RequestMapping(value = "/{nama}", method = RequestMethod.GET)
  public ResponseEntity<Obt> get(@PathVariable("nama") String nama) {
    Obt obt = repository.findByNama(nama);
    if (null == obt) {
      return new ResponseEntity<Obt>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Obt>(obt, HttpStatus.OK);
  }
  

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public ResponseEntity<Obt> update(@RequestBody Obt obt) {
    repository.save(obt);
    return get(obt.getId());
  }
  
  @RequestMapping("/init")
  @ResponseBody
  String hello() {
  
    repository.save(new Obt("Mikonazol", 
        "Infeksi jamur pada vagina, mulut, kulit, Kandidiasis, tinea corporis, tinea pedis, tinea versicolor, kandisosis kutis",
        "2x sehari (pagi dan malam)",
        "Iritasi dan rasa terbakar (burning). Bila iritasi terjadi, segera hentikan penggunaan krim/ salep") );
        
    repository.save(new Obt("Griseofulvin", 
	      "Infeksi jamur pada kulit, kulit kepala, rambut, kuku",
	      "sesuai resep",
	      "Diare, sakit kepala, tidak nyaman pada lambung, pusing, kelelahan") );

    return "DB is initialized.";
  }
  

  @RequestMapping
  public List<Obt> all() {
    return repository.findAll();
  }
}
