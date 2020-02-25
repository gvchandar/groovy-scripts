import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.json.JsonParserType
class DTRBuildSer {
 static void main(String[] args) {
  def cleanup = new ComponentInfo(
   'name': 'dco-cleanup', \
   'shortName': 'cleanup', \
   'subversion': '5.3', \
   'tag': 'auto1', \
   'gitPath': 'cleanuprepo', \
   'folderPath': 'cleanupFolder', \
   'dockerRepo': 'http://cleanupdockerrepo'
  )
  def manager = new ComponentInfo(
   'name': 'dco-manager', \
   'shortName': 'manager', \
   'subversion': '5.6', \
   'tag': 'auto2', \
   'gitPath': 'managerrepo', \
   'folderPath': 'managerFolder', \
   'dockerRepo': 'http://managerdockerrepo'
  )
  def dtrbuild = new DTRBuildInfo(environment: "DEV", version: "5.9", \
   componentList: [cleanup, manager])
  def dtrbuild_json = JsonOutput.toJson(dtrbuild)

  JsonSlurper slurper = new JsonSlurper().setType(JsonParserType.INDEX_OVERLAY)
  def reloadobject = slurper.parseText(dtrbuild_json)

  DTRBuildInfo reloadDTRBuildInfo = new DTRBuildInfo(reloadobject)

  println("Environment $reloadDTRBuildInfo.environment")
  println("Version $reloadDTRBuildInfo.version")
  //println("Component List $reloadDTRBuildInfo.componentList")

  reloadDTRBuildInfo.componentList.each {
    def componentSplit = "${it}".split(',');
    ComponentInfo component = getComponentInfo(componentSplit)
    println("Name:" + component.name)
  }
 }

 public static ComponentInfo getComponentInfo(String[] componentSplit) {
   println(componentSplit)
   String dockerRepo = componentSplit[0].substring(componentSplit[0].indexOf(':')+1)
   String gitPath = componentSplit[1].substring(componentSplit[1].indexOf(':')+1)
   String folderPath = componentSplit[2].substring(componentSplit[2].indexOf(':')+1)
   String subversion = componentSplit[3].substring(componentSplit[3].indexOf(':')+1)
   String name = componentSplit[4].substring(componentSplit[4].indexOf(':')+1)
   String tag = componentSplit[5].substring(componentSplit[5].indexOf(':')+1)
   String shortName = componentSplit[6].substring(componentSplit[6].indexOf(':')+1,\
                      componentSplit[6].length()-1)
  
   def component = new ComponentInfo(
                   'name': name , \
                   'shortName': shortName, \
                   'subversion': subversion, \
                   'tag': tag, \
                   'gitPath': gitPath, \
                   'folderPath': folderPath, \
                   'dockerRepo': dockerRepo
                  )

   return component
   }

}

class DTRBuildInfo {
 String environment;
 String version;
 String DTRURL;
 def componentList = [];
}

class ComponentInfo {
 String name;
 String shortName;
 String subversion;
 String tag;
 String gitPath;
 String folderPath;
 String dockerRepo;
}
