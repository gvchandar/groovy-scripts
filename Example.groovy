import groovy.json.JsonOutput 
class Example {
  static void main(String[] args) {
    def output = JsonOutput.toJson([name: 'John', ID: 1])
    println(output);  

    Person person = new Person(name: 'John', title: null, age: 21, password: 'secret',
                          dob: Date.parse('yyyy-MM-dd', '1984-12-15'),
                          favoriteUrl: new URL('http://groovy-lang.org/'))
    def json = JsonOutput.toJson(person);
    println(person);

   }
}

class Person {
    String name
    String title
    int age
    String password
    Date dob
    URL favoriteUrl
}
