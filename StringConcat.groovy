import groovy.json.JsonOutput 
import groovy.json.JsonSlurper
class StringConcat {
  static void main(String[] args) {
    StringBuffer buildStringParam = new StringBuffer();
    buildStringParam.append('environment~')
    buildStringParam.append('version~') 
    buildStringParam.append('DTRURL~')
    println(buildStringParam.toString())


   }
}

class Person {
    String name
    List interests
}
