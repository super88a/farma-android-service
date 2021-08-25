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
  
  
  @RequestMapping(value = "/nama/{nama}", method = RequestMethod.GET)
  public ResponseEntity<Obt> get(@PathVariable("nama") String nama) {
    Obt obt = repository.findByNama(nama);
    if (null == obt) {
      return new ResponseEntity<Obt>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Obt>(obt, HttpStatus.OK);
  }
  
  @RequestMapping(value = "/namalike/{nama}", method = RequestMethod.GET)
  public ResponseEntity<Obt> get(@PathVariable("nama") String nama) {
    Obt obt = repository.findByNamaLike(nama);
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
  
    repository.save(new Obt("Nystatin drop (Nystatin 100.000 Unit/mL)", 
        "Kandidiasis pada mulut",
        "Obat diminum bersamaan dengan makanan. Ikuti aturan pakai dengan rutin dan penuh sesuai periode pengobatan yang diresepkan",
        "gangguan perut, diare, mual, iritasi") );
        
    
    return "DB has been initialized.";
  }
  

  @RequestMapping
  public List<Obt> all() {
    return repository.findAll();
  }
}
