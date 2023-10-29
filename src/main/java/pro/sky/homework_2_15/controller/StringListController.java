package pro.sky.homework_2_15.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.homework_2_15.exception.ElementNotFoundException;
import pro.sky.homework_2_15.service.StringList;

@RestController
@RequestMapping("/stringList")
public class StringListController {

    @ExceptionHandler
    public String handleException(RuntimeException e){
        return e.getMessage();
    }

    private final StringList stringList;

    public StringListController(StringList stringList) {
        this.stringList = stringList;
    }

    @GetMapping(path = "/add", params = "item") // /stringList/add?item=one
    public String add(@RequestParam String item) {
        return stringList.add(item);
    }

    @GetMapping(path = "/add", params = {"index","item"}) // /stringList/add?index=1&item=one
    public String add(@RequestParam int index,
                      @RequestParam String item) throws IndexOutOfBoundsException{
        return stringList.add(index, item);
    }

    @GetMapping(path = "/set", params = {"index","item"}) // /stringList/set?index=1&item=two
    public String set(@RequestParam int index,
                      @RequestParam String item) throws IndexOutOfBoundsException{
        return stringList.set(index, item);
    }

    @GetMapping(path = "/remove", params = "item") // /stringList/remove?item=two
    public String remove(@RequestParam String item) throws ElementNotFoundException {
        return stringList.remove(item);
    }

    @GetMapping(path = "/remove", params = "index") // /stringList/remove?index=1
    public String remove(@RequestParam int index) throws ElementNotFoundException, IndexOutOfBoundsException {
        return stringList.remove(index);
    }

    @GetMapping(path = "/contains", params = "item") // /stringList/contains?item=one
    public boolean contains(@RequestParam String item) {
        return stringList.contains(item);
    }

    @GetMapping(path = "/indexOf", params = "item") // /stringList/indexOf?item=one
    public int indexOf(@RequestParam String item) {
        return stringList.indexOf(item);
    }

    @GetMapping(path = "/lastIndexOf", params = "item") // /stringList/lastIndexOf?item=one
    public int lastIndexOf(@RequestParam String item) {
        return stringList.lastIndexOf(item);
    }

    @GetMapping(path = "/get", params = "index") // /stringList/get?index=1
    public String get(@RequestParam int index) throws IndexOutOfBoundsException {
        return stringList.get(index);
    }

    @GetMapping(path = "/equals", params = "otherList") // /stringList/equals?otherList=one,two
    public boolean equals(@RequestParam String[] otherList) throws IllegalArgumentException {
        return stringList.equals(otherList);
    }

    @GetMapping(path = "/size") // /stringList/size
    public int size() {
        return stringList.size();
    }

    @GetMapping(path = "/isEmpty") // /stringList/isEmpty
    public boolean isEmpty() {
        return stringList.isEmpty();
    }

    @GetMapping(path = "/clear") // /stringList/clear
    public void clear() {
        stringList.clear();
    }

    @GetMapping(path = "/toArray") // /stringList/toArray
    public String[] toArray() {
        return stringList.toArray();
    }
}
