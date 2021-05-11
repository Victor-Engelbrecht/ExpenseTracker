package spend

import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.http.uri.UriBuilder
import org.grails.web.json.JSONObject

@CompileStatic
class ZARToUSDService implements GrailsConfigurationAware {
    String apikey
    BlockingHttpClient client

    //Gets the data in the application.yml file and sets needed variables
    @Override
    void setConfiguration(Config co) {
        setupHttpClient(co.getProperty('CurrencyConvertion.url', String, 'http://data.fixer.io'))
        apikey = co.getProperty('CurrencyConvertion.apikey', String)
    }


    void setupHttpClient(String url) {
        this.client = HttpClient.create(url.toURL()).toBlocking()
    }

    CurrencyConvertion currencyConvertion() {
        try {
            HttpRequest request = HttpRequest.GET(currencyConvertionUri())
            return client.retrieve(request, CurrencyConvertion)

        } catch (HttpClientResponseException e) {
            return null
        }
    }

    URI currencyConvertionUri() {
        UriBuilder uriBuilder = UriBuilder.of('/api/latest')
                .queryParam('q')
                .queryParam('access_key', apikey)
        uriBuilder.build()
    }
}


//This would not work as it is not supported by the free version of that program
/*Potential way need to look into it further

def bindings = [name:'world']

    def response = new ScriptEngineManager()
            .getEngineByName('javascript')
            .eval("// set endpoint and your API key\n" +
                    "endpoint = 'convert';\n" +
                    "access_key = '5e8eab0a3b05fc1ec0dd638fcef128d1';\n" +
                    "\n" +
                    "// define from currency, to currency, and amount\n" +
                    "from = 'USD';\n" +
                    "to = 'ZAR';\n" +
                    "amount = '10';\n" +
                    "\n" +
                    "// execute the conversion using the \"convert\" endpoint:\n" +
                    "\$.ajax({\n" +
                    "    url: 'http://data.fixer.io/api/' + endpoint + '?access_key=' + access_key +'&from=' + from + '&to=' + to + '&amount=' + amount,\n" +
                    "    dataType: 'jsonp',\n" +
                    "    success: function(json) {\n" +
                    "\n" +
                    "        // access the conversion result in json.result\n" +
                    "        alert(json.result);\n" +
                    "\n" +
                    "    }\n" +
                    "});", bindings as SimpleBindings)*/




//<g:javascript src="myscript.js" />
// set amount of data and this should be ready to go

/*
// set endpoint and your API key
endpoint = 'convert';
access_key = '5e8eab0a3b05fc1ec0dd638fcef128d1';

// define from currency, to currency, and amount
from = 'USD';
to = 'ZAR';
amount = '10';

// execute the conversion using the "convert" endpoint:
$.ajax({
    url: 'http://data.fixer.io/api/' + endpoint + '?access_key=' + access_key +'&from=' + from + '&to=' + to + '&amount=' + amount,
    dataType: 'jsonp',
    success: function(json) {

        // access the conversion result in json.result
        alert(json.result);

    }
});
*/