package spend


import com.stehno.ersatz.ErsatzServer
import com.stehno.ersatz.cfg.ContentType
import com.stehno.ersatz.encdec.Encoders
import grails.testing.services.ServiceUnitTest
import spock.lang.IgnoreIf
import spock.lang.Specification

@IgnoreIf( { System.getenv('TRAVIS') as boolean } )
class ZARToUSDServiceSpec extends Specification implements ServiceUnitTest<ZARToUSDService> {

    def "For an unauthorized key, null is return"() {
        given:
        ErsatzServer ersatz = new ErsatzServer()
        String apikey = '5e8eab0a3b05fc1ec0dd638fcef128d1'
        ersatz.expectations {
            GET('api/latest') {
                query('?',)
                query('access_key=', apikey)
                called(1)
                responder {
                    encoder(ContentType.APPLICATION_JSON, Map, Encoders.json)
                    code(201)
                    body([
                            rates :[USD:1.216441, ZAR:17.096062]
                    ], ContentType.APPLICATION_JSON)
                }
            }
        }
        service.setupHttpClient(ersatz.httpUrl)
        service.appid = appid

        when:
        CurrencyConvertion currencyConvertion = service.currencyConvertion()

        then:
        currencyConvertion

        zARToUSDService.usValue ==1.216441
        zARToUSDService.usValue ==17.096062

        and:
        ersatz.verify()

        cleanup:
        ersatz.stop()
    }
}