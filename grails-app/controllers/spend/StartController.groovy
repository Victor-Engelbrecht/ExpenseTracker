package spend

class StartController {

    def startService

    def index(){
        render "Start here: ${startService.myTest()}"
    }
}