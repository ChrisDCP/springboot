package com.example.demo.Controlesrs;

//import javax.smartcardio.Card;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.model.ServiceResponse;
import com.example.demo.model.cardModels;
import com.example.demo.service.ICardService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class Controler {

    @Autowired
    private ICardService iCardService;

    @GetMapping("/list")
    public List<cardModels> list(){
        return iCardService.VerAll();
    }

    @PostMapping("/save")
    public ResponseEntity<cardModels> save(@RequestBody cardModels cardmodel){
        cardModels nueva_tarjeta = iCardService.save(cardmodel);
        return new ResponseEntity<>(nueva_tarjeta, HttpStatus.CREATED);
    }

    @GetMapping("/tarjeta/{id}")
    public ResponseEntity<cardModels>FindById(@PathVariable long id){
       cardModels tarjetaPorid = iCardService.FindById(id);
        return ResponseEntity.ok(tarjetaPorid);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<cardModels> update(@PathVariable long id, @RequestBody cardModels cardmodel){
        cardModels tarjetaPorid = iCardService.FindById(id);
        tarjetaPorid.setNombre(cardmodel.getNombre());
        tarjetaPorid.setNumero(cardmodel.getNumero());
        tarjetaPorid.setTipo(cardmodel.getTipo());
        tarjetaPorid.setCvv(cardmodel.getCvv());
        tarjetaPorid.setEstado(cardmodel.getEstado());

        cardModels tarjetaActualizada = iCardService.save(tarjetaPorid);

        return new ResponseEntity<>(tarjetaActualizada, HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<HashMap<String, Boolean>> Eliminar(@PathVariable long id){
        this.iCardService.deleteById(id);
        HashMap<String,Boolean> estadoTarjetaEliminada = new HashMap<>();
        estadoTarjetaEliminada.put("eliminada", true);
        return ResponseEntity.ok(estadoTarjetaEliminada);
    }
}
