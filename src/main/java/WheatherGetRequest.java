
import io.restassured.response.Response;
import org.omg.Messaging.SyncScopeHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class WheatherGetRequest {
    //Status code: 200
    @Test
    public void Test1() {
        Response resp = when().
                get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=3ce7a700fd8a77c196c55cd7695e6f43");
        System.out.println(resp.getStatusCode());
        Assert.assertEquals(resp.getStatusCode(), 200);

    }

    //Status code 401
    @Test
    public void Test2() {
        Response resp = when().
                get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=3ce7a700fd8a77c196c55cd7695e6f4");
        System.out.println(resp.getStatusCode());
        Assert.assertEquals(resp.getStatusCode(), 401);

    }

    @Test
    public void Test3() {
        Response resp = given().
                param("q", "London").
                param("appid", "3ce7a700fd8a77c196c55cd7695e6f43").
                when().

                get("http://api.openweathermap.org/data/2.5/weather");
        System.out.println(resp.getStatusCode());
        Assert.assertEquals(resp.getStatusCode(), 200);

        if (resp.getStatusCode()==200){
            System.out.println("API status is ok");
        }else{
            System.out.println("API is not working");
        }


    }
    @Test
    public void Test4(){
                given().
                param("q", "London").
                param("appid", "3ce7a700fd8a77c196c55cd7695e6f43").
                when().
                get("http://api.openweathermap.org/data/2.5/weather").
                then().
                assertThat().statusCode(200);
    }
    @Test
    public void Test5() {
        Response resp = given().
                param("q", "London").
                param("appid", "3ce7a700fd8a77c196c55cd7695e6f43").
                when().
                get("http://api.openweathermap.org/data/2.5/weather");
        System.out.println(resp.asString());
    }
    //get("http://api.openweathermap.org/data/2.5/weather?id=2172797")
    @Test
    public void Test6(){
        Response resp =
    }




}


