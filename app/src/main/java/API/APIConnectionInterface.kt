package API

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.POST

interface IAPIConnectionInterface {

    //Метод для отправки кода на Email введенный пользователем
    @POST("api/SendCodeEmail")
    fun SendCodeOnEmail(@Header("User-email")emailAddress : String) : Call<ResponseBody>

    //Метод для отправки кода пользователя на проверку
    @POST("api/SignInApp")
    fun CheckEmailCode(@Header("User-email")emailAddress : String
                       , @Header("User-code")emailCode : String) : Call<ResponseBody>
}