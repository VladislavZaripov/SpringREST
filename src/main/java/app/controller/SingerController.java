package app.controller;

import app.entity.Singer;
import app.entity.Singers;
import app.service.SingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
@RequestMapping(value = "/singer")
public class SingerController {

    private static Logger logger = LoggerFactory.getLogger(SingerController.class);

    @Autowired
    SingerService singerService;

    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value = "/listdata", method = RequestMethod.GET)
//    @ResponseBody
    @GetMapping(value = "/listdata")
    public Singers listDate(){
        return new Singers(singerService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value="/{id}", method=RequestMethod.GET)
//    @ResponseBody
    @GetMapping(value = "/{id}")
    public Singer findSingerById(@PathVariable Long id) {
        return singerService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(value="/", method=RequestMethod.POST)
//    @ResponseBody
    @PostMapping(value = "/")
    public Singer create(@RequestBody Singer singer) {
        logger.info("Creating singer: " + singer);
        singerService.save(singer);
        logger.info("Singer created successfully with info: " + singer);
        return singer;
    }

    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
//    @ResponseBody
    @PutMapping(value = "/{id}")
    public void update(@RequestBody Singer singer, @PathVariable Long id) {
        logger.info("Updating singer: " + singer);
        singerService.save(singer);
        logger.info("Singer updated successfully with info: " + singer);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
//    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        logger.info("Deleting singer with id: " + id);
        Singer singer = singerService.findById(id);
        singerService.delete(singer);
        logger.info("Singer deleted successfully");
    }
}
