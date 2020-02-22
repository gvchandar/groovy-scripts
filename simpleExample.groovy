import groovy.json.JsonOutput 
import groovy.json.JsonSlurper
class simpleExample {
  static void main(String[] args) {
    def output = JsonOutput.toJson([name: 'John', ID: 1])
    println(output);  
    
    //Convert Object to JSON
    def json = JsonOutput.toJson([ new Person(name: 'John',interests: ["a","b","c"]), \
                                   new Person(name: 'Max' ,interests: ["d","e","f"]) ])
    //assert json == '[{"name":"John"},{"name":"Max"}]'
    println(json);
    //Convert JSON to Object
    def jsonSlurper = new JsonSlurper()
    def object = jsonSlurper.parseText(json)
    println(object);

   }
}

class Person {
    String name
    List interests
}

