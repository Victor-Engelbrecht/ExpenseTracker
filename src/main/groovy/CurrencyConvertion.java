package spend;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

@Introspected
public class CurrencyConvertion{

    @JsonProperty("USD")
    private float usValue;
    @JsonProperty("ZAR")
    private float zaValue;

    CurrencyConvertion(){

    }
    public float getUsValue(){
        return usValue;
    }
    public void setUsValue(float newUs){
        this.usValue = newUs;
    }

    public float getZaValue(){
        return usValue;
    }
    public void setZaValue(float newZa){
        this.zaValue = newZa;
    }
}

//For csv
//https://sergiodelamo.com/blog/grails-tips-how-to-output-csv-from-a-grails-3-controller.html
//For java in grails
//https://guides.grails.org/grails-mock-http-server/guide/index.html#openweather
