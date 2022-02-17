
package mx.edu.uteq.evaluacion1.controller;

import java.util.Date;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import mx.edu.uteq.evaluacion1.dao.IPhotosDao;
import mx.edu.uteq.evaluacion1.model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/AU")
public class RestControllerPhotosAU {
    
    @Autowired
    private IPhotosDao photoDao;
    
    @GetMapping("/photosAU")
    public List<Photo> list() {
        List<Photo> listPhoto = photoDao.findAll();
        return listPhoto;
    }
    
    @GetMapping("/photosAU/{id}")
    public Photo get(@PathVariable Long id) {
        return photoDao.findById(id).orElse(null);
    }
    
    @PutMapping("/photosAU/edit/{id}")
    public ResponseEntity<Photo> put(@PathVariable Long id, @RequestBody Photo photoAU) {
        
        Photo currentPhotoAU = photoDao.findById(id).orElse(null);
        
        if (currentPhotoAU == null) {
            return new ResponseEntity<>(currentPhotoAU, HttpStatus.NOT_FOUND );
        }
        
        currentPhotoAU.setTitle(photoAU.getTitle());
        currentPhotoAU.setUrl(photoAU.getUrl());
        currentPhotoAU.setStatus(true);
        currentPhotoAU.setLastTime(new Date());
        
        Photo updatedPhoto = photoDao.save(currentPhotoAU);
        
        HttpStatus statusUpdatedHttp = HttpStatus.CREATED;
        return new ResponseEntity<>(updatedPhoto, statusUpdatedHttp);
    }
    
    @PostMapping("/photosAU/add")
    public ResponseEntity<Photo> post(@RequestBody Photo photo) {
        return new ResponseEntity<>(photoDao.save(photo), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/photosAU/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        photoDao.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
    
}
