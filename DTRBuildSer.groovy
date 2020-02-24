import groovy.json.JsonOutput 
import groovy.json.JsonSlurper
import groovy.json.JsonParserType
class DTRBuildSer {
  static void main(String[] args) {
    /*
    def output = JsonOutput.toJson([name: 'John', ID: 1])
    println(output);  
    
    Convert Object to JSON
    def json = JsonOutput.toJson([ new Person(name: 'John',interests: ["a","b","c"]), \
                                   new Person(name: 'Max' ,interests: ["d","e","f"]) ])
    assert json == '[{"name":"John"},{"name":"Max"}]'
    JsonOutput.prettyPrint(json)
    println(json);
    Convert JSON to Object
    def jsonSlurper = new JsonSlurper()
    def object = jsonSlurper.parseText(json)
    println(object);
    */
    def cleanup = new ComponentInfo(name:"cleanup",tag: "5.2",gitPath:"gitPathcleanup")
    def manager = new ComponentInfo(name:"manager",tag: "5.4",gitPath:"gitPathmanager")
    
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
    //def dtrbuild = new DTRBuildInfo(environment:"DEV",version:"5.9",\
    //                   componentList:[cleanupmap,requestmanagermap])
    def dtrbuild = new DTRBuildInfo(environment:"DEV",version:"5.9",\
                       componentList:[cleanup,manager])
    def dtrbuild_json = JsonOutput.toJson(dtrbuild)
    //println(" Print JSON")
    //println(dtrbuild_json)


    JsonSlurper slurper = new JsonSlurper().setType( JsonParserType.INDEX_OVERLAY )
    def reloadobject = slurper.parseText(dtrbuild_json)
    DTRBuildInfo reloadDTRBuildInfo = new DTRBuildInfo(reloadobject)

    println(" Print Object")
    println("Environment $reloadDTRBuildInfo.environment")
    println("Version $reloadDTRBuildInfo.version")
    println("Component List $reloadDTRBuildInfo.componentList")
    
    reloadDTRBuildInfo.componentList.each {
      println"Object is:"
      println "${it}"
      def componentSplit = "${it}".split(',');   
      for( String values : componentSplit )
      println(values);

    }
    

    //assert dtrbuild_object instanceof DTRBuildInfo
    /*
    println(dtrbuild_object)
    println(dtrbuild_object.environment)
    println(dtrbuild_object.version)
    println(dtrbuild_object.componentList)
    def componentmap = [:]
    dtrbuild_object.componentList.each {
      componentmap = "${it}"
      println(componentmap)
      componentmap.each { 
        println "${it}"
      }
    }
    */
    //println("version is :"dtrbuild_object.version)
    //println("version is :" dtrbuild_object.getVersion())
    //println("component list is :" dtrbuild_object.componentList)

   }
}

class Person {
    String name
    List interests
}

class DTRBuildInfo{
  String environment;
  String version;
  String DTRURL;
  def componentList = []
  String getEnvironment() {
    return this.environment;
  }
  String getVersion() {
    return this.version;
  }
}


class ComponentInfo
{
  String name;
  String shortName;
  String subversion;
  String tag;
  String gitPath;
  String folderPath;
  String dockerRepo;
}
