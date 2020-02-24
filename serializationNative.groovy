import groovy.json.JsonOutput 
import groovy.json.JsonSlurper
import groovy.json.JsonParserType
import java.text.SimpleDateFormat
class serializationNative{
  static void main(String[] args) {
    def cleanupmap= [
        'name': 'dco-cleanup',
        'subversion': '2.5',
        'tag': 'auto'
    ]

   def requestmanagermap= [
        'name': 'dco-request-manager',
        'subversion': '2.8',
        'tag': 'auto-clean'
    ]

    Contact contact = new Contact()
    contact.name = 'John'
    contact.registration = Date.parse('dd/MM/yyyy', '20/10/2011')


    def conList = new Contact(name: 'John',registration : Date.parse('dd/MM/yyyy', '20/10/2011'),\
                              componentList:[cleanupmap,requestmanagermap])

    String jsonData = JsonOutput.toJson(conList)
    println(jsonData)

    JsonSlurper slurper = new JsonSlurper().setType( JsonParserType.INDEX_OVERLAY )
    def object = slurper.parseText(jsonData)
    Contact reloadContact = new Contact(object)
    print(reloadContact)

   }
}

class Contact {
    String name
    Date registration
    List componentList
}
